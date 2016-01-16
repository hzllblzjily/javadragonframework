package com.hongbao.boapp.base;

import java.util.Date;

import org.joda.time.DateTime;

import com.hongbao.boapp.exception.DragonBusinessException;

public abstract class DragonBaseService<T extends DragonBaseBusinessObject> {
	

	public T create(T entity) throws DragonBusinessException{
		entity.setCreatedAt(new DateTime());
		entity.setUpdatedAt(new DateTime());
		
		return entity;
	}


	public T update(T entity) throws DragonBusinessException{

		entity.setUpdatedAt(new DateTime());
		
		return entity;
	}
	public T get(Long id)throws DragonBusinessException{
		
		return null;
	}
	
	public void delete(Long id)throws DragonBusinessException{
		
	}




	

}
