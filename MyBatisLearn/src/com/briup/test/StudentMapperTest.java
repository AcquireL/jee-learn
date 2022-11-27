package com.briup.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.briup.mappers.StudentMapper;
import com.briup.pojo.Student;
import com.briup.pojo.Student2;
import com.briup.utils.MyBatisSqlSessionFactory;

/*
 * mybatis入门案例 测试类
 */
public class StudentMapperTest {

	@Test
	public void test_updateStudent() {
		//1.获取session对象
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		//2.由session获取mapper对象
		StudentMapper mapper = 
				session.getMapper(StudentMapper.class);
		
		//3.通过mapper实现功能
		Student stu = 
				new Student(2,"jack","jack@qq.com",new Date());
		mapper.updateStudent(stu);
		
		//提交事务
		session.commit();
		
		//4.释放资源
		session.close();
	}
	
	@Test
	public void test_deleteStudentById(){
		try {
			//1.获取sqlSession工厂对象
			InputStream inputStream = 
					Resources.getResourceAsStream("mybatis-config.xml"); 
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			
			//2.获取sqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//3.获取mapper对象【接口的实现类对象】
			StudentMapper studentMapper = 
					sqlSession.getMapper(StudentMapper.class);

			//4.通过mapper对象调用接口方法，执行sql语句，实现功能
			int num = studentMapper.deleteStudentById(2);
			System.out.println("num: " + num);
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_findAllStudents(){
		try {
			//1.获取sqlSession工厂对象
			InputStream inputStream = 
					Resources.getResourceAsStream("mybatis-config.xml"); 
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			
			//2.获取sqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//3.获取mapper对象【接口的实现类对象】
			StudentMapper studentMapper = 
					sqlSession.getMapper(StudentMapper.class);

			//4.通过mapper对象调用接口方法，执行sql语句，实现功能
			List<Student> list = studentMapper.findAllStudents();
			for (Student s : list) {
				System.out.println(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_findStudentById(){
		try {
			//1.获取sqlSession工厂对象
			InputStream inputStream = 
					Resources.getResourceAsStream("mybatis-config.xml"); 
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			
			//2.获取sqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//3.获取mapper对象【接口的实现类对象】
			StudentMapper studentMapper = 
					sqlSession.getMapper(StudentMapper.class);

			//4.通过mapper对象调用接口方法，执行sql语句，实现功能
			Student stu = studentMapper.findStudentById(2);
			System.out.println("stu: " + stu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_insert(){
		try {
			//1.获取sqlSession工厂对象
			InputStream inputStream = 
					Resources.getResourceAsStream("mybatis-config.xml"); 
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			
			//2.获取sqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//3.获取mapper对象【接口的实现类对象】
			StudentMapper studentMapper = 
					sqlSession.getMapper(StudentMapper.class);

			//4.通过mapper对象调用接口方法，执行sql语句，实现功能
			Student s = new Student(2,"tom2","1234@briup.com",new Date());
			studentMapper.insertStudent(s);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@Test
	public void test_insertAutoPk() {
		//1.获取session对象
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		//2.由session获取mapper对象
		StudentMapper mapper = 
				session.getMapper(StudentMapper.class);
		
		//3.通过mapper实现功能
		Student stu = 
				new Student("lucy","lucy@qq.com",new Date());
		mapper.insertStudentAutoPK(stu);
		System.out.println("after insert: " + stu);
		
		session.commit();
		session.close();
	}

	@Test
	public void test_findStudent2ById() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		StudentMapper mapper = 
				session.getMapper(StudentMapper.class);
		
		Student2 s = mapper.findStudent2ById(2);
		System.out.println("s: " + s);
		
		session.close();
	}
	
	//通过session对象直接执行sql语句
	@Test
	public void test_session_update() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
	
		//如果要通过session获取mapper对象，一定保证映射文件中namespace值
		//是接口的全限定名
		//StudentMapper mapper = 
		//		session.getMapper(StudentMapper.class);
		
		//通过session找到对应的sql语句，然后执行
		//session.方法("namespace.id")
		int num = 
				session.delete("com.briup.mappers.StudentMapper.deteleStudentByName","jack");
		System.out.println("delete几条: " + num);
		
		session.commit();
		session.close();
		
	}
	
	@Test
	public void test_session_selectOne() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
	
		//查找一个对象
		Student2 s = session.selectOne("com.briup.mappers.StudentMapper.findStudent2ById", 7);
		System.out.println("s: " + s);
		
		session.close();
		
	}
	
	@Test
	public void test_session_selectList() {
		SqlSession session = 
				MyBatisSqlSessionFactory.openSession();
		
		//查找一个对象
		List<Student> list = 
				session.selectList("com.briup.mappers.StudentMapper.findAllStudents");
		for (Student s : list) {
			System.out.println(s);
		}
		
		session.close();
		
	}
	
}










