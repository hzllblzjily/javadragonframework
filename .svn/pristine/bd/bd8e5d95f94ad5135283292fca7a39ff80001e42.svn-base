package com.hongbao.boapp.dao;

import org.apache.ibatis.annotations.Param;

import com.hongbao.boapp.businessobject.User;

public interface IUserDao {

	public User getUserByEmailAndCookieToken(@Param("email")String email,@Param("cookieToken")String cookieToken);
	public User getUserByEmail(@Param("email")String email,@Param("isLock")boolean isLock);
	public int countUserByCookieToken(@Param("cookieToken")String cookieToken,
			@Param("excludeUserId")Long excludeUserId,@Param("isLock")boolean isLock);
	
	public User get(Long id);

	public void create(User student);
	
	public void delete(Long id);
	
	public void update(User student);
}
