package com.hongbao.dragon.controller.base;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.hongbao.boapp.businessobject.User;
import com.hongbao.boapp.complextype.CurrentUserInfo;
import com.hongbao.boapp.exception.DragonBusinessException;
import com.hongbao.boapp.service.IUserService;
import com.hongbao.dragon.session.DragonSessionMgr;

public class DragonHomeBaseController extends DragonBaseController {

	
	static final Logger log = Logger.getLogger(DragonHomeBaseController.class);
	
	@Autowired
	private DragonSessionMgr sessionMgr;
	
	@Autowired
	private IUserService userService;

	public ModelAndView renderScript(String path){
		ModelAndView modelAndView = new ModelAndView(path);
		
		User currentUser = null;
		CurrentUserInfo currentUserInfo = this.sessionMgr.getCurrentUserInfo();
		if(currentUserInfo != null){
			try {
				currentUser = this.userService.get(currentUserInfo.getId());
			} catch (DragonBusinessException e) {
				log.error("fail",e);
				currentUser = null;
			}
		}
		modelAndView.addObject("currentUser", currentUser);
		return modelAndView;
	}


	
	



}
