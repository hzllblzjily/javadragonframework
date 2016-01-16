package com.hongbao.boapp.mybatis.typehandler;



import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;


public class JodaDateTimeTypeHandler implements TypeHandler<DateTime> {
	  public void setParameter(PreparedStatement preparedStatement, int i, DateTime dateTime, JdbcType jdbcType)
	      throws SQLException {

	    if (dateTime != null) {
	      String dateTimeString =  dateTime.toString("yyyy-MM-dd HH:mm:ss");
	      preparedStatement.setString(i, dateTimeString);
	    } else {
	      preparedStatement.setString(i, "0000-00-00 00:00:00");
	    }
	  }
	  public DateTime getResult(ResultSet resultSet, String s) throws SQLException {

	    return toDateTime(resultSet.getTimestamp(s));
	  }
	  public DateTime getResult(ResultSet resultSet, int i) throws SQLException {
	    return toDateTime(resultSet.getTimestamp(i));
	  }
	  public DateTime getResult(CallableStatement callableStatement, int i) throws SQLException {
	    return toDateTime(callableStatement.getTimestamp(i));
	  }
	  private static DateTime toDateTime(Timestamp dateTimeStamp) {
	    if (dateTimeStamp != null) {
	      return new DateTime(dateTimeStamp.getTime());
	    } else {
	      return null;
	    }
	  }
}