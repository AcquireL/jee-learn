package com.briup.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.pojo.PhoneNumber;

/*
 * 自定义类型转换器
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	//将数据库中查询到的数据  --->  类对象属性
	//			表类型           --->   类类型
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String colName) throws SQLException {
		//"110-001-119"
		String phoneStr = rs.getString(colName);
		String[] array = phoneStr.split("-");
		PhoneNumber phone = 
				new PhoneNumber(array[0], array[1], array[2]);
		
		return phone;
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int index) throws SQLException {
		String phoneStr = rs.getString(index);
		String[] array = phoneStr.split("-");
		PhoneNumber phone = 
				new PhoneNumber(array[0], array[1], array[2]);
		
		return phone;
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int index) throws SQLException {
		return new PhoneNumber(cs.getString(index));
	}

	//类类型 --> 表数据类型
	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, PhoneNumber phone, JdbcType arg3)
			throws SQLException {
		
		ps.setString(index, phone.getAsString());
		
	}

}
