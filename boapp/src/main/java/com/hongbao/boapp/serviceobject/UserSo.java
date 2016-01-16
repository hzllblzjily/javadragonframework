package com.hongbao.boapp.serviceobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hongbao.boapp.annotation.DragonSoPropertyType;
import com.hongbao.boapp.annotation.DragonSoPropertyTypeEnum;
import com.hongbao.boapp.base.DragonBaseServiceObject;
import com.hongbao.boapp.constant.DragonConstant;
import com.hongbao.boapp.exception.DragonBusinessException;
import com.hongbao.boapp.service.IAttachmentService;
import com.hongbao.boapp.service.IUserService;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value=Include.NON_NULL)
public class UserSo extends DragonBaseServiceObject {

	private Long id = 0L;
	private Long avatar_id = 0L;
	private String userName = "";


	@DragonSoPropertyType(type=DragonSoPropertyTypeEnum.AGGREGATION)
	private String avatarOriginUrl = "";
	
	@DragonSoPropertyType(type=DragonSoPropertyTypeEnum.AGGREGATION)
	private String avatarMediumUrl = "";
	
	@DragonSoPropertyType(type=DragonSoPropertyTypeEnum.AGGREGATION)
	private String avatarThumbUrl = "";
	
	
	@Autowired
	@DragonSoPropertyType(type=DragonSoPropertyTypeEnum.TRANSIENT)
	@JsonIgnore
	private IUserService userService;
	
	@Autowired
	@DragonSoPropertyType(type=DragonSoPropertyTypeEnum.TRANSIENT)
	@JsonIgnore
	private IAttachmentService attachmentService;
	
	
	@Override
	public void processAggregation(String fieldName) throws DragonBusinessException{
		if(fieldName.equals("avatarOriginUrl")){
			if(this.avatar_id == 0L){
				this.avatarOriginUrl = "/public/img/default_avatar.jpg";
			}else{
				this.avatarOriginUrl = this.attachmentService.getFileUrlString(this.avatar_id, "origin",DragonConstant.CONTENT_DEPOSITION_INLINE);
			}

		}else if(fieldName.equals("avatarMediumUrl")){
			if(this.avatar_id == 0L){
				this.avatarMediumUrl = "/public/img/default_avatar.jpg";
			}else{
				this.avatarMediumUrl = this.attachmentService.getFileUrlString(this.avatar_id, "medium",DragonConstant.CONTENT_DEPOSITION_INLINE);
			}
		}else if(fieldName.equals("avatarThumbUrl")){
			if(this.avatar_id == 0L){
				this.avatarThumbUrl = "/public/default_avatar.jpg";
			}else{
				this.avatarThumbUrl = this.attachmentService.getFileUrlString(this.avatar_id, "thumb",DragonConstant.CONTENT_DEPOSITION_INLINE);
			}
		}
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



	public String getAvatarOriginUrl() {
		return avatarOriginUrl;
	}


	public void setAvatarOriginUrl(String avatarOriginUrl) {
		this.avatarOriginUrl = avatarOriginUrl;
	}


	public String getAvatarMediumUrl() {
		return avatarMediumUrl;
	}


	public void setAvatarMediumUrl(String avatarMediumUrl) {
		this.avatarMediumUrl = avatarMediumUrl;
	}


	public String getAvatarThumbUrl() {
		return avatarThumbUrl;
	}


	public void setAvatarThumbUrl(String avatarThumbUrl) {
		this.avatarThumbUrl = avatarThumbUrl;
	}


	
	
}
