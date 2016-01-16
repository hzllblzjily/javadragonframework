package com.hongbao.boapp.bofacade;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hongbao.boapp.base.DragonBaseBusinessObject;
import com.hongbao.boapp.base.DragonBaseServiceObject;
import com.hongbao.boapp.context.DragonThreadContext;
import com.hongbao.boapp.exception.DragonBusinessException;

public interface IDragonBoFacade {

	public void setThreadContext(DragonThreadContext context);
	public DragonThreadContext getThreadContext();
	public void setHttpSession(HttpSession httpSession);
	public HttpSession getHttpSession();
	public <T extends DragonBaseServiceObject, S extends DragonBaseBusinessObject>  T convertFromBo(S businessObject, Class<T> serviceObjectClass) throws DragonBusinessException;
	public <T extends DragonBaseServiceObject, S extends DragonBaseBusinessObject>  List<T> convertFromBos(List<S> businessObjects, Class<T> serviceObjectClass) throws DragonBusinessException;
	public <T extends DragonBaseServiceObject, S extends DragonBaseBusinessObject>  T convertFromBo(S businessObject, Class<T> serviceObjectClass,String[] excludeFieldName) throws DragonBusinessException;
	public <T extends DragonBaseServiceObject, S extends DragonBaseBusinessObject>  List<T> convertFromBos(List<S> businessObjects, Class<T> serviceObjectClass,String[] excludeFieldName) throws DragonBusinessException;
}
