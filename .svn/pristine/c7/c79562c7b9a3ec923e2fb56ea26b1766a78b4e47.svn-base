package com.hongbao.boapp.serviceobject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hongbao.boapp.base.DragonBaseServiceObject;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value=Include.NON_NULL)
public class SubjectSo extends DragonBaseServiceObject{


	private long id;
	

	private String title;
	

	private long student_id;
	

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	


}
