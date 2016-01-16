package com.hongbao.boapp.exception;




public class DragonBusinessException extends Exception {



	/**
	 * 
	 */
	private static final long serialVersionUID = 6395563975408259666L;

	private Integer errCode;
	
	private String errMessage;
	public Integer getErrCode() {
		return errCode;
	}
	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	
	@Override
	public String toString() {
		return "DragonBusinessException [errCode=" + errCode + ", errMessage="
				+ errMessage + "]";
	}
	public DragonBusinessException(int errCode){
		this.errCode = errCode;
		switch (errCode) {
		
		//201XX开头为框架错误
		case 20103:
			errMessage = "主键对应的消息不存在";
			break;
		case 20104:
			errMessage = "实体类转换出错";
			break;
		case 20105:
			errMessage = "还未登录或登录已过期";
			break;
		case 20106:
			errMessage = "没有权限访问";
			break;
		//202XX开头为attachment错误
		case 20201:
			errMessage = "上传附件类型不合法";
			break;
		case 20202:
			errMessage = "不能上传空文件";
			break;			

			
		//203XX开头为user错误
		case 20301:
			errMessage = "注册用户信息不完整";
			break;
		case 20302:
			errMessage = "登录信息不完整";
			break;
		case 20303:
			errMessage = "用户名或密码错误";
			break;	
		case 20304:
			errMessage = "cookie token重复";
			break;
		case 20305:
			errMessage = "邮箱已被注册";
			break;
		//204XX开头为role错误
		case 20401:
			errMessage = "角色名已存在";
			break;
		case 20402:
			errMessage = "角色等级已存在";
			break;
		//205XX开头为mark错误
		case 20501:
			errMessage = "标签已存在";
			break;
		default:
			errMessage = "未知错误";
			break;
		}
		
	}
	
	
}
