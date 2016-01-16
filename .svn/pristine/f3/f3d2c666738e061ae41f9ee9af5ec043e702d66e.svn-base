package com.hongbao.dragon.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.cookie.SetCookie;
import org.springframework.beans.factory.annotation.Autowired;

public class DragonCookieMgr {

	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	public String getCookieByName(String cookieName){
		if(cookieName == null){
			return null;
		}
		Cookie[] cookies = this.request.getCookies();
		if(cookies == null){
			return null;
		}
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie= cookies[i];
			if(cookie.getName().equals(cookieName)){
				return cookie.getValue();
			}
		}
		return null;
	}
	
	public Cookie setCookie(String cookieName,String cookieValue,String path,int expireSecond){
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		cookie.setMaxAge(expireSecond);
		
		this.response.addCookie(cookie);
		return cookie;
	}
}
