package com.hongbao.boapp.service;

import com.hongbao.boapp.businessobject.User;
import com.hongbao.boapp.exception.DragonBusinessException;

public interface IUserService {

	//用户注册
	public User register(String email,String password,String userName) throws DragonBusinessException;
	
	//根据邮箱和cookie token获取用户信息
	public User getUserByEmailAndCookieToken(String email,String cookieToken) throws DragonBusinessException;
	
	//根据邮箱和密码获取用户
	public User getUserByEmailAndPassword(String email,String password)throws DragonBusinessException;
	
	//生成记住我的cookie token
	public User generateCookieToken(Long userId)throws DragonBusinessException;
	
	
	public User create(User entity) throws DragonBusinessException;
	public User update(User entity) throws DragonBusinessException;
	public User get(Long id)throws DragonBusinessException;
	public void delete(Long id)throws DragonBusinessException;
	
	

	
	
}
