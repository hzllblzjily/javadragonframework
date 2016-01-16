package com.hongbao.boapp.complextype;



@ComplexType
public class DragonJsonReturnType {

	private String status;
	private Object data;
	
	public static DragonJsonReturnType createType(Object model){
		return DragonJsonReturnType.createType(model,"success");
	}
	
	public static DragonJsonReturnType createType(Object model,String status){
		DragonJsonReturnType type = new DragonJsonReturnType();
		type.setStatus(status);
		type.setData(model);
		return type;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
