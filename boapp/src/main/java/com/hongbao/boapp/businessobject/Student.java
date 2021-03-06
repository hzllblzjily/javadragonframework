package com.hongbao.boapp.businessobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.hongbao.boapp.base.DragonBaseBusinessObject;
import com.hongbao.dragonutil.enumeration.EmGender;



public class Student extends DragonBaseBusinessObject{

	private long id = 0;
	private String name = "";
	private DateTime birth = null;
	private BigDecimal score = new BigDecimal(0.0);
	private EmGender gender = EmGender.UNDEFINED;
	private int teacher_id = 0;
	

	private Teacher teacher = null;
	
	private Author author = null;
	
	private List<Subject> subjects = new ArrayList<Subject>();
	private List<Post> posts = new ArrayList<Post>();
	
	

	
	

	

	
	
	public List<Post> getPosts() {
		return posts;
	}




	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}




	public List<Subject> getSubjects() {
		return subjects;
	}




	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}




	public Author getAuthor() {
		return author;
	}




	public void setAuthor(Author author) {
		this.author = author;
	}




	public int getTeacher_id() {
		return teacher_id;
	}




	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}




	public Teacher getTeacher() {
		return teacher;
	}




	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}




	public Student(){
		
	}

	






	public EmGender getGender() {
		return gender;
	}




	public void setGender(EmGender gender) {
		this.gender = gender;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	public DateTime getBirth() {
		return birth;
	}




	public void setBirth(DateTime birth) {
		this.birth = birth;
	}







	public BigDecimal getScore() {
		return score;
	}


	public void setScore(BigDecimal score) {
		this.score = score;
	}
	
	
}
