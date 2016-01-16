package com.hongbao.dragon.controller.home;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hongbao.boapp.businessobject.User;
import com.hongbao.boapp.complextype.DragonJsonReturnType;
import com.hongbao.boapp.constant.DragonConstant;
import com.hongbao.boapp.context.DragonThreadContext;
import com.hongbao.boapp.exception.DragonBusinessException;
import com.hongbao.boapp.service.IUserService;
import com.hongbao.boapp.serviceobject.UserSo;
import com.hongbao.dragon.controller.base.DragonHomeBaseController;
import com.hongbao.dragon.cookie.DragonCookieMgr;
import com.hongbao.dragon.session.DragonSessionMgr;
import com.hongbao.dragonutil.DragonCommonMethod;

@Controller("/home/users")
@RequestMapping("/home/users")
public class UserController  extends DragonHomeBaseController{


	@Autowired
	private DragonThreadContext threadContext;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private DragonSessionMgr sessionMgr;
	
	@Autowired
	private DragonCookieMgr cookieMgr;

	
	static final Logger logger = Logger.getLogger(UserController.class);
	

	@RequestMapping(value = "/register",method = RequestMethod.POST) 
	@ResponseBody
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED,readOnly=false) 
	public DragonJsonReturnType register(@RequestParam(value="userName") String userName,@RequestParam(value="email") String email,
			@RequestParam(value="password") String password) throws DragonBusinessException, NoSuchMethodException, SecurityException, IOException, InterruptedException{

		if(DragonCommonMethod.isEmptyString(userName) && DragonCommonMethod.isEmptyString(email) && DragonCommonMethod.isEmptyString(password)){
			throw new DragonBusinessException(20301);
		}
		
		
		User user = this.userService.register(email, password, userName);
		UserSo userSo = this.threadContext.getBoFacade().convertFromBo(user, UserSo.class);
		return DragonJsonReturnType.createType(userSo);

	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST) 
	@ResponseBody
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED,readOnly=false) 
	public DragonJsonReturnType login(@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,@RequestParam(value="isRememberMe",defaultValue="0")Integer isRemember) throws DragonBusinessException, NoSuchMethodException, SecurityException, IOException, InterruptedException{
		
		if(DragonCommonMethod.isEmptyString(email) && DragonCommonMethod.isEmptyString(password)){
			throw new DragonBusinessException(20302);
		}
		User user = this.userService.getUserByEmailAndPassword(email, password);
		if(user == null){
			throw new DragonBusinessException(20303);
		}

		if(isRemember == 1){
			
			user = this.userService.generateCookieToken(user.getId());
			
			final DragonCookieMgr finalCookieMgr = this.cookieMgr;
			final User userInTransaction = user;
			final DragonSessionMgr finalSessionMgr = this.sessionMgr;
			
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
		        @Override
		        public void afterCommit() {
		            // things to do when commited
		        	finalSessionMgr.userLogin(userInTransaction);
		        	finalCookieMgr.setCookie(DragonConstant.COOKIE_USER_EMAIL,userInTransaction.getEmail(), "/", DragonConstant.COOKIE_EXPIRE_TIME);
		        	finalCookieMgr.setCookie(DragonConstant.COOKIE_USER_TOKEN,userInTransaction.getCookieToken(), "/", DragonConstant.COOKIE_EXPIRE_TIME);
		        }
				
			});
			

			
		}
		
		
		UserSo userSo = this.threadContext.getBoFacade().convertFromBo(user, UserSo.class);
		return DragonJsonReturnType.createType(userSo);

	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET) 
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED,readOnly=true) 
	public String logout() throws DragonBusinessException{
		
		this.sessionMgr.userLogout();
		this.cookieMgr.setCookie(DragonConstant.COOKIE_USER_EMAIL,null, "/", 0);
		this.cookieMgr.setCookie(DragonConstant.COOKIE_USER_TOKEN,null, "/", 0);
		
	    return "redirect:/home/index/index";  
	}


	
}
