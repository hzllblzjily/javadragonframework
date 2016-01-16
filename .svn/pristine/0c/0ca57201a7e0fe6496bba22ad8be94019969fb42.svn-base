package com.hongbao.boapp.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.hongbao.boapp.bofacade.IDragonBoFacade;

//spring托管的thread context
public class DragonThreadContext implements ApplicationContextAware{


	private ThreadLocal<IDragonBoFacade> boFacadeThreadLocal = new ThreadLocal<IDragonBoFacade>();  //每个线程都有一个bofacade
	
	private ThreadLocal<DragonAuthenticationMgr> authenticationMgr = new ThreadLocal<DragonAuthenticationMgr>();  //每个线程都有一个authmgr
	
	
	private ApplicationContext applicationContext = null;
	
	private Properties applicationProperties = null;
	
	
	static final Logger logger = Logger.getLogger(DragonThreadContext.class);

	
	@PostConstruct
	public void init(){
		//初始化时区,北京时间
		TimeZone.setDefault(TimeZone.getTimeZone("Etc/GMT-8"));
		
		//初始化application properties
		this.applicationProperties = new Properties();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("META-INF/application.properties");
		try {
			this.applicationProperties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	logger.error("fail", e);
		}
		

	}
	

	public Properties getApplicationProperties() {
		return applicationProperties;
	}




	public void setBoFacade(IDragonBoFacade boFacade){
		this.boFacadeThreadLocal.set(boFacade);
	}
	
	public IDragonBoFacade getBoFacade(){
		return this.boFacadeThreadLocal.get();
	}
	


	public DragonAuthenticationMgr getAuthenticationMgr() {
		return this.authenticationMgr.get();
	}


	public void setAuthenticationMgr( DragonAuthenticationMgr authenticationMgr) {
		this.authenticationMgr.set(authenticationMgr);
	}


	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
		
	}
	
	public ApplicationContext getApplicationContent(){
		return this.applicationContext;
	}
	
}
