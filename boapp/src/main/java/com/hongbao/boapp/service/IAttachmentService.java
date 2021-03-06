package com.hongbao.boapp.service;

import com.hongbao.boapp.businessobject.Attachment;
import com.hongbao.boapp.exception.DragonBusinessException;

public interface IAttachmentService {

	public Attachment create(Attachment entity) throws DragonBusinessException;


	public Attachment update(Attachment entity) throws DragonBusinessException;
	
	public Attachment get(Long id)throws DragonBusinessException;
	
	public void delete(Long id)throws DragonBusinessException;
	
	
	public String getFileUrlString(Long id,String type,String method) throws DragonBusinessException;
	

}
