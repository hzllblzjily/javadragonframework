package com.hongbao.boapp.attachmenthelper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hongbao.boapp.context.DragonThreadContext;

public class DragonAttachmentHelperFactory {

	@Autowired
	private DragonThreadContext threadContext;
	
	private static final Logger logger = Logger.getLogger(DragonAttachmentHelperFactory.class);
	
	public IAttachmentHelper createHelper(){  
		

		String helperName = (String) this.threadContext.getApplicationProperties().get("attachment.helper");
		if(helperName.equals("oss")){
			DragonOssAttachmentHelper helper = new DragonOssAttachmentHelper();
			helper.setOssKeyString( (String) this.threadContext.getApplicationProperties().get("oss.accessKey"));
			helper.setOssSecretString( (String) this.threadContext.getApplicationProperties().get("oss.accessKeySecret"));
			helper.setOssBucketNameString( (String) this.threadContext.getApplicationProperties().get("oss.bucket"));
			helper.setOssHostNameString( (String) this.threadContext.getApplicationProperties().get("oss.hostName"));
			helper.setAliasHostName( (String)this.threadContext.getApplicationProperties().get("oss.aliasHostName"));
			
			helper.setImgHostName( (String) this.threadContext.getApplicationProperties().get("oss.imgHostName"));
			helper.setImgCdnHostNameString( (String)this.threadContext.getApplicationProperties().get("oss.imgCdnHostName"));
			
			String isUseImageService = (String)this.threadContext.getApplicationProperties().get("oss.isUseImageService");
			if(isUseImageService.equals("true")){
				helper.setUseImageService(true);
			}else{
				helper.setUseImageService(false);
			}
			
			String isReadFromOss = (String)this.threadContext.getApplicationProperties().get("oss.isReadFromOss");
			if(isReadFromOss.equals("true")){
				helper.setReadFromOss(true);
			}else{
				helper.setReadFromOss(false);
			}
			String isOssReadPublic = (String)this.threadContext.getApplicationProperties().get("oss.isOssReadPublic");
			if(isOssReadPublic.equals("true")){
				helper.setOssReadPublic(true);
			}else{
				helper.setOssReadPublic(false);
			}
			String canCacheInClient = (String)this.threadContext.getApplicationProperties().get("oss.canCacheInClient");
			if(canCacheInClient.equals("true")){
				helper.setCanCacheInClient(true);
			}else{
				helper.setCanCacheInClient(false);
			}
			
			
			String authExpireTimeString = (String) this.threadContext.getApplicationProperties().get("oss.ossReadAuthExpireTime");
			helper.setOssReadAuthExpireTime( Integer.valueOf(authExpireTimeString));
			helper.setOssCacheFileBaseRoute( (String) this.threadContext.getApplicationProperties().get("oss.ossCacheFileBaseRoute"));
			return helper;
		}else{
			logger.error("no suitable attachment helper find by name = " + helperName);
			return null;
		}
		  

		  
	} 
	  
}
