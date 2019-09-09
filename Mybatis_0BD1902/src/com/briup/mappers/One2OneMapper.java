package com.briup.mappers;

import java.util.List;

import com.briup.pojo.Address;
import com.briup.pojo.Student3;

public interface One2OneMapper {
	
	Address findAddressById(int id);
	
	Student3 findStudentByIdWithOutAddress(int id);
	
	Student3 findStudentByIdWithAddress(int id);
	
	List<Student3> findAllStudentsWithAddress();
	
	//往学生表中插入一条完整记录
	int insertStudentWithAddress(Student3 stu);
	
	int insertAddress(Address addr);
	
}








