package com.hongbao.boapp.businessobject;

import com.hongbao.boapp.base.DragonBaseBusinessObject;


public class Subject extends DragonBaseBusinessObject{

	private long id = 0;
	private String title = "";
	private long student_id = 0;
	

	
	public long getId() {
		return id;
	}
	public void setId(int id) {
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
