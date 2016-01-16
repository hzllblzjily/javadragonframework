package com.hongbao.dragon.controller.admin;


import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hongbao.boapp.complextype.DragonJsonReturnType;
import com.hongbao.boapp.context.DragonThreadContext;
import com.hongbao.boapp.exception.DragonBusinessException;
import com.hongbao.dragon.controller.base.DragonAdminBaseController;



@Controller("/admin/index")
@RequestMapping("/admin/index")
public class IndexController extends DragonAdminBaseController{

	@Autowired
	private DragonThreadContext threadContext;
	

	
	static final Logger logger = Logger.getLogger(IndexController.class);
	
	

	@RequestMapping(value = "/index",method = RequestMethod.GET) 
	@ResponseBody
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED,readOnly=false) 
	public DragonJsonReturnType index() throws DragonBusinessException{
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "adminModule");
  
		return DragonJsonReturnType.createType(map);

	}
	
	

}
