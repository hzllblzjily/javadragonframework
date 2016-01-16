package com.hongbao.dragon.controller.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hongbao.boapp.context.DragonAuthenticationMgr;
import com.hongbao.boapp.context.DragonThreadContext;
import com.hongbao.boapp.exception.DragonBusinessException;



@Controller()
@RequestMapping("/")
public class DragonDefaultController extends DragonBaseController{

	
	@Autowired
	private DragonThreadContext threadContext;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index() throws DragonBusinessException, IOException, ServletException{
		if(this.threadContext.getAuthenticationMgr().getModuleName().equals(DragonAuthenticationMgr.HOME_MODULE)){
		    return "forward:/home/index/index";  
		}else if(this.threadContext.getAuthenticationMgr().getModuleName().equals(DragonAuthenticationMgr.API_MODULE)){
		    return "forward:/api/index/index";  
		}else if(this.threadContext.getAuthenticationMgr().getModuleName().equals(DragonAuthenticationMgr.ADMIN_MODULE)){
		    return "forward:/admin/index/index";  
		}else if(this.threadContext.getAuthenticationMgr().getModuleName().equals(DragonAuthenticationMgr.WECHAT_MODULE)){
		    return "forward:/wechat/index/index";  
		}else{
			throw new DragonBusinessException(20106);
		}

	}
}
