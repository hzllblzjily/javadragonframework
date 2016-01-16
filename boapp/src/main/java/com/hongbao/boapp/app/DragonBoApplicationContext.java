package com.hongbao.boapp.app;

import java.util.Properties;

public class DragonBoApplicationContext {

	public static Properties applicationProperties = null;
	
	public static boolean isApiModule(){
		if(applicationProperties.get("server.module").equals("api")){
			return true;
		}
		return false;
	}
	
	public static boolean isBackendModule(){
		if(applicationProperties.get("server.module").equals("backend")){
			return true;
		}
		return false;
	}
}
