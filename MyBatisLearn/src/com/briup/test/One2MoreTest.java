package com.briup.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.mappers.One2MoreMapper;
import com.briup.pojo.Address;
import com.briup.pojo.Tutor;
import com.briup.utils.MyBatisSqlSessionFactory;

public class One2MoreTest {
	
	@Test
	public void test_findTutorById3() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		One2MoreMapper mapper = 
				session.getMapper(One2MoreMapper.class);
	
		Tutor tutor = mapper.findTutorByIdWithAddress3(1);
		
		System.out.println(tutor);
		
		session.close();
	}
	
	@Test
	public void test_findTutorById2() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		One2MoreMapper mapper = 
				session.getMapper(One2MoreMapper.class);
	
		Tutor tutor = mapper.findTutorByIdWithAddress2(1);
		
		System.out.println(tutor);
		
		session.close();
	}
	
	@Test
	public void test_findTutorById() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		One2MoreMapper mapper = 
				session.getMapper(One2MoreMapper.class);
	
		Tutor tutor = mapper.findTutorByIdWithAddress(1);
		
		System.out.println(tutor);
		
		session.close();
	}
	
	
	
}
