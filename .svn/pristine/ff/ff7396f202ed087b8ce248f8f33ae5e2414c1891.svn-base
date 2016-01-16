package com.hongbao.boapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hongbao.boapp.base.DragonBaseService;
import com.hongbao.boapp.businessobject.User;
import com.hongbao.boapp.dao.IUserDao;
import com.hongbao.boapp.exception.DragonBusinessException;
import com.hongbao.boapp.service.IUserService;
import com.hongbao.dragonutil.DragonCommonMethod;


@Service
public class UserServiceImpl extends DragonBaseService<User> implements IUserService {
	@Autowired
	private IUserDao userDao;
	
	
	public User create(User entity) throws DragonBusinessException{
		super.create(entity);
		
		//验证邮箱是否唯一
		User userinEmail =  this.userDao.getUserByEmail(entity.getEmail(), true);
		if(userinEmail != null){
			throw new DragonBusinessException(20305);
		}
		
		
		this.userDao.create(entity);
		return entity;
	}


	public User update(User entity) throws DragonBusinessException{
		super.update(entity);
		
		this.userDao.update(entity);
		return entity;
	}
	
	public User get(Long id)throws DragonBusinessException{
		
		super.get(id);
		
		User entity = this.userDao.get(id);
		return entity;
		
	}
	
	public void delete(Long id)throws DragonBusinessException{
		
		super.delete(id);
		
		this.userDao.delete(id);
	}


	public User register(String email, String password, String userName)
			throws DragonBusinessException {

		if(DragonCommonMethod.isEmptyString(email) || DragonCommonMethod.isEmptyString(password) 
				|| DragonCommonMethod.isEmptyString(userName)){
			throw new DragonBusinessException(20301);
		}
		User user = new User();
		user.setEmail(email);
		String encryptPasswordString = "";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
        encryptPasswordString = passwordEncoder.encode(password);
		user.setPassword(encryptPasswordString);
		user.setUserName(userName);
		
		//验证邮箱是否唯一
		User userinEmail =  this.userDao.getUserByEmail(email, true);
		if(userinEmail != null){
			throw new DragonBusinessException(20305);
		}
		
		
		return this.create(user);
		
	}


	public User getUserByEmailAndCookieToken(String email, String cookieToken)
			throws DragonBusinessException {
		// TODO Auto-generated method stub
		if(DragonCommonMethod.isEmptyString(email) || DragonCommonMethod.isEmptyString(cookieToken)){
			return null;
		}
		return this.userDao.getUserByEmailAndCookieToken(email, cookieToken);
	}


	public User getUserByEmailAndPassword(String email,String password) throws DragonBusinessException {
		// TODO Auto-generated method stub
		if(DragonCommonMethod.isEmptyString(email) || DragonCommonMethod.isEmptyString(password)){
			return null;
		}
		
		User user =  this.userDao.getUserByEmail(email,false);
		if(user == null){
			return null;
		}
		String inPasswordString = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
        boolean isMath = passwordEncoder.matches(password, inPasswordString);
        if(isMath){
        	return user;
        }else{
        	return null;
        }
	}


	public User generateCookieToken(Long userId) throws DragonBusinessException {

		User user = this.get(userId);
		if(user == null){
			throw new DragonBusinessException(20103);
		}
		String cookieToken = "";
		if(!DragonCommonMethod.isEmptyString(user.getCookieToken())){
			cookieToken = user.getCookieToken();
		}else{
			cookieToken = DragonCommonMethod.generateGuid();
			//判断唯一性
			int count = this.userDao.countUserByCookieToken(cookieToken, userId, true);
			if(count > 0){
				throw new DragonBusinessException(20304);
			}
			user.setCookieToken(cookieToken);
			user = this.update(user);
		}
		
		

		return user;
		
	}

	
	
	
	
}
