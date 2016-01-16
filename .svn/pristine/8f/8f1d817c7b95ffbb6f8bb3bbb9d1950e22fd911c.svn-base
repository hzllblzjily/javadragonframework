package com.hongbao.dragon.controller.pic;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hongbao.boapp.complextype.DragonJsonReturnType;
import com.hongbao.boapp.constant.DragonConstant;
import com.hongbao.boapp.exception.DragonBusinessException;
import com.hongbao.dragon.controller.base.DragonFileContoller;


@Controller("/pic/files")
@RequestMapping("/pic/files")
public class FileController extends DragonFileContoller {


	@RequestMapping(value = "/download",method = RequestMethod.GET) 
	public void downloadAction(@RequestParam(required=true,value="id") Long id,@RequestParam(required=true,value="type",defaultValue="origin") String type,
			@RequestParam(required=false,value="method",defaultValue=DragonConstant.CONTENT_DEPOSITION_INLINE)String method, 
			@RequestParam(required=false,value="w")Long modWidth,
			@RequestParam(required=false,value="h")Long modHeight,
			HttpServletRequest request,HttpServletResponse response) throws IOException, DragonBusinessException{
		
		super.downloadAction(id, type, method, modWidth, modHeight, request, response);
		
	}
	
	 @RequestMapping(value = "/upload", method = RequestMethod.POST)  
	 @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED,readOnly=false) 
	 @ResponseBody 
	 public DragonJsonReturnType upload(HttpServletRequest request,  
	            HttpServletResponse response) throws IOException, DragonBusinessException{
		 
		 return super.upload(request, response);
	 }
	
}
