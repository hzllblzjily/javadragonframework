package com.hongbao.boapp.serviceobject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hongbao.boapp.annotation.DragonSoPropertyType;
import com.hongbao.boapp.annotation.DragonSoPropertyTypeEnum;
import com.hongbao.boapp.base.DragonBaseServiceObject;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value=Include.NON_NULL)
public class PostSo extends DragonBaseServiceObject{
	

	private long id;
	

	private String content;


	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	


}
