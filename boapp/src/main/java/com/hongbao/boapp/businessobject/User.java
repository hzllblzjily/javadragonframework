package com.hongbao.boapp.businessobject;

import org.joda.time.DateTime;

import com.hongbao.boapp.base.DragonBaseBusinessObject;

public class User extends DragonBaseBusinessObject{

	private Long id;
	private Long avatar_id = 0L;
	private String userName = "";
	private String email = "";
	private String password = "";
	private String forgetPasswdIdentifier = "";
	private DateTime resetPasswdInvalidTime;
	private String wechatOpenId = "";
	private String wechatAccessToken = "";
	private String wechatUnionId = "";
	private String wechatRefreshToken = "";
	private String cookieToken = "";
	private String token = "";
	
	private Attachment avatar = null;
	
	
	
	public Attachment getAvatar() {
		return avatar;
	}
	public void setAvatar(Attachment avatar) {
		this.avatar = avatar;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAvatar_id() {
		return avatar_id;
	}
	public void setAvatar_id(Long avatar_id) {
		this.avatar_id = avatar_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getForgetPasswdIdentifier() {
		return forgetPasswdIdentifier;
	}
	public void setForgetPasswdIdentifier(String forgetPasswdIdentifier) {
		this.forgetPasswdIdentifier = forgetPasswdIdentifier;
	}
	public DateTime getResetPasswdInvalidTime() {
		return resetPasswdInvalidTime;
	}
	public void setResetPasswdInvalidTime(DateTime resetPasswdInvalidTime) {
		this.resetPasswdInvalidTime = resetPasswdInvalidTime;
	}
	public String getWechatOpenId() {
		return wechatOpenId;
	}
	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}
	public String getWechatAccessToken() {
		return wechatAccessToken;
	}
	public void setWechatAccessToken(String wechatAccessToken) {
		this.wechatAccessToken = wechatAccessToken;
	}
	public String getWechatUnionId() {
		return wechatUnionId;
	}
	public void setWechatUnionId(String wechatUnionId) {
		this.wechatUnionId = wechatUnionId;
	}
	public String getWechatRefreshToken() {
		return wechatRefreshToken;
	}
	public void setWechatRefreshToken(String wechatRefreshToken) {
		this.wechatRefreshToken = wechatRefreshToken;
	}
	public String getCookieToken() {
		return cookieToken;
	}
	public void setCookieToken(String cookieToken) {
		this.cookieToken = cookieToken;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
