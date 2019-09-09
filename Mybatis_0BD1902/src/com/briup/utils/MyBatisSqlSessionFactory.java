package com.briup.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * 工具类: 直接通过类名.static方法
 * 	  不允许 实例化类对象,不允许 new。
 */
public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	//私有构造器，类外无法直接new对象
	private MyBatisSqlSessionFactory() {}
	
	private static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory == null){
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml"); 
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession() { 
		return openSession(false); 
	}
	public static SqlSession openSession(boolean autoCommit) { 
		return getSqlSessionFactory().openSession(autoCommit); 
	}
	
}
