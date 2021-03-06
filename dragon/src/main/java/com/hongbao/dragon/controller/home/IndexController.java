package com.hongbao.dragon.controller.home;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hongbao.boapp.attachmenthelper.IAttachmentHelper;
import com.hongbao.boapp.businessobject.Attachment;
import com.hongbao.boapp.businessobject.Student;
import com.hongbao.boapp.complextype.CurrentUserInfo;
import com.hongbao.boapp.complextype.DragonJsonReturnType;
import com.hongbao.boapp.context.DragonThreadContext;
import com.hongbao.boapp.exception.DragonBusinessException;
import com.hongbao.boapp.service.IAttachmentService;
import com.hongbao.boapp.service.IStudentService;
import com.hongbao.boapp.serviceobject.AttachmentSo;
import com.hongbao.boapp.serviceobject.StudentSo;
import com.hongbao.dragon.annotation.HomePermission;
import com.hongbao.dragon.annotation.HomePermissionRole;
import com.hongbao.dragon.controller.base.DragonHomeBaseController;
import com.hongbao.dragonutil.DragonCommonMethod;



@Controller("/home/index")
@RequestMapping("/home/index")
public class IndexController extends DragonHomeBaseController{

	@Autowired
	private DragonThreadContext threadContext;
	
	@Autowired
	private IAttachmentService attachmentService;
	

	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IAttachmentHelper attachmentHelper;
	
	
	static final Logger logger = Logger.getLogger(IndexController.class);
	
	
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/index",method = RequestMethod.GET) 
	@ResponseBody
	//@HomePermission({HomePermissionRole.COMMON_USER})
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED,readOnly=false) 
	public DragonJsonReturnType index(@RequestParam(value="creationTime",required=false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") DateTime dateTime, @RequestParam(value="id",required=false,defaultValue="0")long id,@RequestParam(value="name",required=false,defaultValue="")String name) throws DragonBusinessException, NoSuchMethodException, SecurityException, IOException, InterruptedException{

		HttpSession session = this.request.getSession();
		String sessionIdString = session.getId();
		CurrentUserInfo userInfo = (CurrentUserInfo) this.request.getSession().getAttribute("name");
		userInfo = new CurrentUserInfo();
		userInfo.setEmail("huzilong862@126.com");
		userInfo.setId(1L);
		this.request.getSession().setAttribute("name", userInfo);
		userInfo = (CurrentUserInfo) this.request.getSession().getAttribute("name");
		
		this.request.getSession().invalidate();
		userInfo = (CurrentUserInfo) this.request.getSession().getAttribute("name");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "homeModule");
		map.put("ip",  DragonCommonMethod.getRemoteAddr(this.request));
  
		InetAddress ia=null;
	
		ia=ia.getLocalHost();
			
	    String localname=ia.getHostName();
        String localip=ia.getHostAddress();
			
		map.put("localhost",  localname);
		map.put("localip",  localip);
		Attachment at = this.attachmentService.get(97L);
//		
//		
		Student student = this.studentService.get(1L);
		StudentSo so1 = this.threadContext.getBoFacade().convertFromBo(student, StudentSo.class);
		
		AttachmentSo so = this.threadContext.getBoFacade().convertFromBo(at, AttachmentSo.class);
		return DragonJsonReturnType.createType(so1);

	}
	
	@RequestMapping(value = "/loginpage",method = RequestMethod.GET) 
	public ModelAndView loginPage() throws DragonBusinessException, NoSuchMethodException, SecurityException{

		return this.renderScript("/index/loginpage");

	}

}
