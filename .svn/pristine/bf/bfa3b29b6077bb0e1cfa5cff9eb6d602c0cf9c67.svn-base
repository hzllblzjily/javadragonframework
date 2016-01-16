package com.hongbao.boapp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hongbao.boapp.businessobject.Student;


public interface IStudentDao {

	public Student get(Long id);
	
	public List<Student> listStudentByName(@Param("name") String name);
	
	public List<Student> findStudentLikeName(@Param("name") String name);
	
	public List<Map<String, Object>> listNameByName(@Param("name") String name);
	
	public void create(Student student);
	
	public void delete(Long id);
	
	public void update(Student student);
	
	public int getSubjectCount(@Param("student_id") long student_id);
	
}
