package com.hongbao.dragon.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hongbao.boapp.bofacade.DragonBoFacadeImpl;
import com.hongbao.boapp.bofacade.IDragonBoFacade;
import com.hongbao.boapp.context.DragonAuthenticationMgr;
import com.hongbao.boapp.context.DragonThreadContext;
import com.hongbao.dragonutil.DragonCommonMethod;

public class DragonCommonInterceptor implements HandlerInterceptor {

	

	
	static final Logger log = Logger.getLogger(DragonCommonInterceptor.class); 
	
	
	@Autowired
	private DragonThreadContext threadContext;
	
	
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		this.initAuthenticationMgr(request);
		this.initBoFacade(request);
		
		
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		if(ex != null){

		}

	}
	
	
	
	protected void initBoFacade(HttpServletRequest request){
		
		IDragonBoFacade boFacade = new DragonBoFacadeImpl();
		boFacade.setHttpSession(request.getSession());
		boFacade.setThreadContext(this.threadContext);
		this.threadContext.setBoFacade(boFacade);
		
		
		
	}
	
	protected void initAuthenticationMgr(HttpServletRequest request){
		

		DragonAuthenticationMgr mgr = new DragonAuthenticationMgr();
		
		String isUseProxyString =  (String) this.threadContext.getApplicationProperties().get("server.isUseProxy");
		boolean isUseProxy = true;
		if(isUseProxyString.equals("true")){
			isUseProxy = true;
		}else{
			isUseProxy = false;
		}
		String hostUrlString = "";
		if(isUseProxy){
			String serverNameString = request.getServerName();
			int serverPort= request.getServerPort();

			if(serverPort == 80){
				hostUrlString = serverNameString;
			}else{
				hostUrlString = serverNameString + ":" + serverPort;
			}
			hostUrlString = "http://" + hostUrlString;
		}else{
			String serverNameString = request.getServerName();
			int serverPort= request.getServerPort();

			if(serverPort == 80){
				hostUrlString = serverNameString;
			}else{
				hostUrlString = serverNameString + ":" + serverPort;
			}
			hostUrlString = "http://" + hostUrlString;
		}

		mgr.setHostUrl(hostUrlString);
		String homeDomain = (String)this.threadContext.getApplicationProperties().get("server.homeDomain");
		String adminDomain = (String)this.threadContext.getApplicationProperties().get("server.adminDomain");
		String wechatDomain = (String)this.threadContext.getApplicationProperties().get("server.wechatDomain");
		String apiDomain = (String)this.threadContext.getApplicationProperties().get("server.apiDomain");
		String picDomain = (String)this.threadContext.getApplicationProperties().get("server.picDomain");
		
		if(homeDomain.equals(hostUrlString)){
			mgr.setModuleName(DragonAuthenticationMgr.HOME_MODULE);
		}else if(adminDomain.equals(hostUrlString)){
			mgr.setModuleName(DragonAuthenticationMgr.ADMIN_MODULE);
		}else if(wechatDomain.equals(hostUrlString)){
			mgr.setModuleName(DragonAuthenticationMgr.WECHAT_MODULE);
		}else if(apiDomain.equals(hostUrlString)){
			mgr.setModuleName(DragonAuthenticationMgr.API_MODULE);
		}else if(picDomain.equals(hostUrlString)){
			mgr.setModuleName(DragonAuthenticationMgr.PIC_MODULE);
		}else{
			mgr.setModuleName("");
		}
		
		this.threadContext.setAuthenticationMgr(mgr);
		
		
		
	}
	
}
