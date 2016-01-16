package com.hongbao.boapp.service;

import java.util.List;

import com.hongbao.boapp.businessobject.Student;
import com.hongbao.boapp.exception.DragonBusinessException;

public interface IStudentService {

	public Student create(Student entity) throws DragonBusinessException;


	public Student update(Student entity) throws DragonBusinessException;
	
	public Student get(Long id)throws DragonBusinessException;
	
	public void delete(Long id)throws DragonBusinessException;
	
	public int getSubjectCount(Long student_id)throws DragonBusinessException;
	public List<Student> listStudentByName(String name)throws DragonBusinessException;
	
	
	
}
