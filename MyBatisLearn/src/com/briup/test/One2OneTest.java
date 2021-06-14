package com.briup.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.mappers.One2OneMapper;
import com.briup.pojo.Address;
import com.briup.pojo.PhoneNumber;
import com.briup.pojo.Student3;
import com.briup.utils.MyBatisSqlSessionFactory;

public class One2OneTest {
	
	@Test
	public void test_insertStudentWithAddress() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		One2OneMapper mapper = 
				session.getMapper(One2OneMapper.class);
		
		Student3 stu = new Student3();
		stu.setName("rose");
		stu.setEmail("rose@briup.com");
		stu.setDob(new Date());
		stu.setPhone(new PhoneNumber("11-22-33"));
		
		//此处，应该加上业务逻辑处理
		int addr_id = 3;
		Address addr = mapper.findAddressById(addr_id);
		if(addr == null) {
			System.out.println("3 号 addr不存在");
			addr = new Address(addr_id, "xyRoad", "kunshan", "suzhou", "0521", "china");
			
			//先将addr插入到addresses表中
			int num = mapper.insertAddress(addr);
			if(num == 1)
				System.out.println("3号地址 插入成功");
		}
		
		stu.setAddress(addr);
		
		mapper.insertStudentWithAddress(stu);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void test_findAddressById() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		One2OneMapper mapper = 
				session.getMapper(One2OneMapper.class);
		
		Address addr = mapper.findAddressById(1);
		System.out.println("addr: " + addr);
		
		session.close();
	}
	
	@Test
	public void test_findStudentByIdWithOutAddress() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		One2OneMapper mapper = 
				session.getMapper(One2OneMapper.class);
		
		Student3 s = mapper.findStudentByIdWithOutAddress(1);
		System.out.println(s);
		
		session.close();
	}
	
	@Test
	public void test_findStudentByIdWithAddress() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		One2OneMapper mapper = 
				session.getMapper(One2OneMapper.class);
		
		Student3 s = mapper.findStudentByIdWithAddress(2);
		System.out.println(s);
		
		session.close();
	}
	
	@Test
	public void test_findAllStudentsWithAddress() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		One2OneMapper mapper = 
				session.getMapper(One2OneMapper.class);
		
		List<Student3> list = 
				mapper.findAllStudentsWithAddress();
		
		for (Student3 s : list) {
			System.out.println(s);
		}
		
		session.close();
	}
	
	
	
}
