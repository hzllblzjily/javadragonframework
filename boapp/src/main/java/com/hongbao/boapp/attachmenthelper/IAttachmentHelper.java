package com.hongbao.boapp.attachmenthelper;

import java.io.IOException;
import java.io.InputStream;

import com.hongbao.boapp.businessobject.Attachment;
import com.hongbao.boapp.exception.DragonBusinessException;

public interface IAttachmentHelper {

	
	
    public Attachment uploadFile(InputStream fileInputStream,String fileType,String originFileName,Long fileSize,String modelName,Long modelId,String modelColumn,String usage,AttachmentCordEntity cordEntity) throws IOException, DragonBusinessException;
	
	public String getFileUrlString(Long id,String type,String contentType,String keyPath,String method) throws DragonBusinessException;
	
	public boolean isValidType(String contentType) throws DragonBusinessException;
	
	public String getFileCacheBaseDir();
	
	public void downloadFileToLocal(String localFilePath,String keyPath) throws IOException;
	
	public boolean canCacheInClient();
	
	public boolean isImageType(String contentType);
	
	
}
