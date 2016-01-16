package com.hongbao.dragon.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.hongbao.boapp.businessobject.User;
import com.hongbao.boapp.complextype.CurrentUserInfo;
import com.hongbao.boapp.constant.DragonConstant;



public class DragonSessionMgr {

	
	@Autowired
	private HttpServletRequest request;
	
	public CurrentUserInfo userLogin(User user){
		CurrentUserInfo currentUserInfo = new CurrentUserInfo();
		currentUserInfo.setEmail(user.getEmail());
		currentUserInfo.setId(user.getId());
		
		this.request.getSession().setAttribute(DragonConstant.CURRENT_USER_INFO, currentUserInfo);
		return currentUserInfo;

	}
	
	public void userLogout(){
		this.request.getSession().setAttribute(DragonConstant.CURRENT_USER_INFO, null);
		
	}
	
	public CurrentUserInfo getCurrentUserInfo(){
		return (CurrentUserInfo) this.request.getSession().getAttribute(DragonConstant.CURRENT_USER_INFO);
	}
	
}
