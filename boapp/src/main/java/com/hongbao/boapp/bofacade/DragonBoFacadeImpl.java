package com.hongbao.boapp.bofacade;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hongbao.boapp.annotation.DragonSoPropertyType;
import com.hongbao.boapp.annotation.DragonSoPropertyTypeEnum;
import com.hongbao.boapp.base.DragonBaseBusinessObject;
import com.hongbao.boapp.base.DragonBaseServiceObject;
import com.hongbao.boapp.context.DragonThreadContext;
import com.hongbao.boapp.exception.DragonBusinessException;

public class DragonBoFacadeImpl implements IDragonBoFacade {


	protected HttpSession httpSession;
	
	static final Logger log = Logger.getLogger(DragonBoFacadeImpl.class);
	
	protected DragonThreadContext threadContext;
	
	public void setHttpSession(HttpSession httpSession){
		this.httpSession = httpSession;
	}
	public HttpSession getHttpSession(){
		return this.httpSession;
	}

	public void setThreadContext(DragonThreadContext context){
		this.threadContext = context;
	}
	public DragonThreadContext getThreadContext(){
		return this.threadContext;
	}
	public <T extends DragonBaseServiceObject, S extends DragonBaseBusinessObject>  T convertFromBo(S businessObject, Class<T> serviceObjectClass,String[] excludeFieldName) throws DragonBusinessException{
		if(businessObject == null){
			return null;
		}
		try {
			T serviceObject = this.threadContext.getApplicationContent().getBean(serviceObjectClass);
		    Field[] fields = serviceObjectClass.getDeclaredFields();
		    List<String> aggregationFieldNameList = new ArrayList<String>();
		    for (Field field : fields) {
				String fieldNameString = field.getName();
				boolean isSkip = false;
				for (int i = 0; i < excludeFieldName.length; i++) {
					String excludeStringString = excludeFieldName[i];
					
					if(excludeStringString.equals(fieldNameString)){
						isSkip = true;
					}
				}
				if(isSkip){
					continue;
				}
				
				Method soMethod = null;
				Method boMethod = null;
				
				DragonSoPropertyType soType = field.getAnnotation(DragonSoPropertyType.class);
	
				if(soType == null || soType.type() == DragonSoPropertyTypeEnum.COLUMN){
					soMethod = serviceObjectClass.getMethod("set" + fieldNameString.substring(0,1).toUpperCase() + fieldNameString.substring(1, fieldNameString.length()),field.getType());
					boMethod = businessObject.getClass().getMethod("get" + fieldNameString.substring(0,1).toUpperCase() + fieldNameString.substring(1, fieldNameString.length()));
					Object returnValue = boMethod.invoke(businessObject);
					soMethod.invoke(serviceObject, returnValue);
				}else if(soType.type() == DragonSoPropertyTypeEnum.AGGREGATION ){
					aggregationFieldNameList.add(fieldNameString);
		    	}else if(soType.type() == DragonSoPropertyTypeEnum.INNODE){
					soMethod = serviceObjectClass.getMethod("set" + fieldNameString.substring(0,1).toUpperCase() + fieldNameString.substring(1, fieldNameString.length()),field.getType());
					boMethod = businessObject.getClass().getMethod("get" + fieldNameString.substring(0,1).toUpperCase() + fieldNameString.substring(1, fieldNameString.length()));
					
					
					DragonBaseBusinessObject returnValue = (DragonBaseBusinessObject)boMethod.invoke(businessObject);
					DragonBaseServiceObject serviceObjectReturn = this.convertFromBo(returnValue,  (Class<DragonBaseServiceObject>)field.getGenericType());
					soMethod.invoke(serviceObject, serviceObjectReturn);
		    	}else if(soType.type() == DragonSoPropertyTypeEnum.SUBNODE){
					soMethod = serviceObjectClass.getMethod("set" + fieldNameString.substring(0,1).toUpperCase() + fieldNameString.substring(1, fieldNameString.length()),field.getType());
					boMethod = businessObject.getClass().getMethod("get" + fieldNameString.substring(0,1).toUpperCase() + fieldNameString.substring(1, fieldNameString.length()));
					
					List serviceList = new ArrayList();
					List returnListValue = (List)boMethod.invoke(businessObject);
					for(Object obInList : returnListValue){
						DragonBaseBusinessObject boBaseBusinessObject  = (DragonBaseBusinessObject)obInList;

						
						ParameterizedType type = (ParameterizedType)field.getGenericType();
						Class inServiceObjectClass = (Class)type.getActualTypeArguments()[0];
						DragonBaseServiceObject serviceObjectReturn = this.convertFromBo(boBaseBusinessObject, inServiceObjectClass);
						serviceList.add(serviceObjectReturn);
					}
					soMethod.invoke(serviceObject, serviceList);
					
		    		
		    	}else{
		    		continue;
		    	}

	
			}
		    
		    for(String aggreFieldNameString : aggregationFieldNameList){
		    	serviceObject.processAggregation(aggreFieldNameString);
		    }
		    return serviceObject;
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	log.error("fail", e);
		}catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	log.error("fail", e);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	log.error("fail", e);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	log.error("fail", e);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	log.error("fail", e);
		}
		throw new DragonBusinessException(20104);
		
		
	}
	public <T extends DragonBaseServiceObject, S extends DragonBaseBusinessObject> List<T> convertFromBos(
			List<S> businessObjects, Class<T> serviceObjectClass,String[] excludeFieldName)
			throws DragonBusinessException {
		// TODO Auto-generated method stub
		if(businessObjects == null){
			return null;
		}
		List<T> soS = new ArrayList<T>();
		for (S bo : businessObjects) {
			T soT = this.convertFromBo(bo, serviceObjectClass,excludeFieldName);
			soS.add(soT);
		}
		return soS;
	}
	public <T extends DragonBaseServiceObject, S extends DragonBaseBusinessObject> T convertFromBo(
			S businessObject, Class<T> serviceObjectClass)
			throws DragonBusinessException {
		// TODO Auto-generated method stub
		return this.convertFromBo(businessObject, serviceObjectClass, new String[0]);
	}
	public <T extends DragonBaseServiceObject, S extends DragonBaseBusinessObject> List<T> convertFromBos(
			List<S> businessObjects, Class<T> serviceObjectClass)
			throws DragonBusinessException {
		// TODO Auto-generated method stub
		return this.convertFromBos(businessObjects, serviceObjectClass,new String[0]);
	}
}
