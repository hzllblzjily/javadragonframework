package com.hongbao.boapp.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;

import com.hongbao.dragonutil.enumeration.EmGender;


public class GenderTypeHandler extends BaseTypeHandler<EmGender>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			EmGender parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		int g = parameter.getG();
		ps.setInt(i, g);
		
	}

	@Override
	public EmGender getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		// TODO Auto-generated method stub
		int g = rs.getInt(columnName);
		if(g == 1){
			return EmGender.MALE;
		}else if(g == 2){
			return EmGender.FEMAILE;
		}else{
			return EmGender.UNDEFINED;
		}
	}

	@Override
	public EmGender getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		int g = rs.getInt(columnIndex);
		if(g == 1){
			return EmGender.MALE;
		}else if(g == 2){
			return EmGender.FEMAILE;
		}else{
			return EmGender.UNDEFINED;
		}
	}

	@Override
	public EmGender getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		int g = cs.getInt(columnIndex);
		if(g == 1){
			return EmGender.MALE;
		}else if(g == 2){
			return EmGender.FEMAILE;
		}else{
			return EmGender.UNDEFINED;
		}
	}
	
	
}
	 