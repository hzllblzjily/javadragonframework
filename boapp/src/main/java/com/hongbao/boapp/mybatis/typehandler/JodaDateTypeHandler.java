package com.hongbao.boapp.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;

public class JodaDateTypeHandler implements TypeHandler<DateTime> {

	  public void setParameter(PreparedStatement preparedStatement, int i, DateTime dateTime, JdbcType jdbcType)
	      throws SQLException {
	    if (dateTime != null) {
	      String dateTimeString =  dateTime.toString("yyyy-MM-dd");
	      preparedStatement.setString(i, dateTimeString);
	    } else {
	      preparedStatement.setString(i, "0000-00-00");
	    }
	  }

	  public DateTime getResult(ResultSet resultSet, String s) throws SQLException {
	    return toDateTime(resultSet.getString(s));
	  }
	  
	  public DateTime getResult(ResultSet resultSet, int i) throws SQLException {
	    return toDateTime(resultSet.getString(i));
	  }

	  public DateTime getResult(CallableStatement callableStatement, int i) throws SQLException {
	    return toDateTime(callableStatement.getString(i));
	  }
	  private static DateTime toDateTime(String dateTimeStr) {
	    if (dateTimeStr != null) {
	      return new DateTime(dateTimeStr);
	    } else {
	      return null;
	    }
	  }
	}