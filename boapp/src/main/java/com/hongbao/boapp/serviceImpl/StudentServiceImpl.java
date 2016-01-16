package com.hongbao.boapp.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hongbao.boapp.base.DragonBaseService;
import com.hongbao.boapp.businessobject.Student;
import com.hongbao.boapp.dao.IStudentDao;
import com.hongbao.boapp.exception.DragonBusinessException;
import com.hongbao.boapp.service.IStudentService;

@Service
public class StudentServiceImpl extends DragonBaseService<Student> implements IStudentService {

	
	@Autowired
	private IStudentDao studentDao;
	
	public Student create(Student entity) throws DragonBusinessException{
		super.create(entity);
		
		this.studentDao.create(entity);
		return entity;
	}


	public Student update(Student entity) throws DragonBusinessException{
		super.update(entity);
		
		this.studentDao.update(entity);
		return entity;
	}
	
	public Student get(Long id)throws DragonBusinessException{
		
		super.get(id);
		
		Student student = this.studentDao.get(id);
		return student;
		
	}
	
	public void delete(Long id)throws DragonBusinessException{
		
		super.delete(id);
		
		this.studentDao.delete(id);
	}


	public int getSubjectCount(Long student_id) throws DragonBusinessException {
		// TODO Auto-generated method stub
		return this.studentDao.getSubjectCount(student_id);
	}


	public List<Student> listStudentByName(String name)
			throws DragonBusinessException {
		// TODO Auto-generated method stub
		return this.studentDao.listStudentByName(name);
		//List<Map<String, Object>> lists = this.studentDao.listNameByName(name);
	
		//return null;
	}
}
