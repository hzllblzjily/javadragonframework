package com.hongbao.dragon.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.hongbao.boapp.exception.DragonBusinessException;

public class DragonBaseController implements ApplicationContextAware {

	static final Logger log = Logger.getLogger(DragonBaseController.class);
	
    private ApplicationContext applicationContext;


	
    @ExceptionHandler(Exception.class) 
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView handlerException(HttpServletRequest request, Exception ex) throws Exception {  
    	
    	log.error("fail", ex);

    	//获取应该返回的类型
    	RequestMappingHandlerMapping mapping = (RequestMappingHandlerMapping) this.applicationContext.getBean("requestHandlerMapping");
    	HandlerExecutionChain chain = mapping.getHandler(request);
    	HandlerMethod handlerMethod = (HandlerMethod)chain.getHandler();

    	if(handlerMethod.getMethod().isAnnotationPresent(ResponseBody.class)){
    		//返回json
        	int errCode = 0;
        	String errMessage = "未知错误";
        	if(ex instanceof DragonBusinessException){
        		errCode = ((DragonBusinessException)ex).getErrCode();
        		errMessage = ((DragonBusinessException)ex).getErrMessage();
        	}
        	ModelAndView mav = new ModelAndView("/error/jsonerror");//实例化一个VIew的ModelAndView实例  
      	  
        	mav.addObject("errCode", errCode);
           	mav.addObject("errMessage", errMessage);
        	  
        	  
        	return mav; 
    		
    	}else{
    		//返回html
        	ModelAndView mav = new ModelAndView("/error/unknown");//实例化一个VIew的ModelAndView实例  
        	mav.addObject("exception", ex);//添加一个带名的model对象  
        	return mav;
    	}
    	



    }  
  


    
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
		
	}  
}
