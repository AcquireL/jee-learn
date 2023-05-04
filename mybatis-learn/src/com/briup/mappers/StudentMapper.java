package com.briup.mappers;

import java.util.List;

import com.briup.pojo.Student;
import com.briup.pojo.Student2;

public interface StudentMapper {
	//ctrl+shift+o 整理包
	List<Student> findAllStudents(); 
	
	//注意：函数的返回值类型，由程序员根据实际需求 自己定义
	Student findStudentById(Integer id); 
	
	void insertStudent(Student student);
	
	//自动生成主键的插入
	void insertStudentAutoPK(Student student);
	
	int deleteStudentById(int id);
	
	void updateStudent(Student stu);
	
	public Student2 findStudent2ById(int id);
}









