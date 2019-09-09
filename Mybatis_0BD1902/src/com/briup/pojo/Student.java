package com.briup.pojo;

import java.util.Date;

//配合package配置来使用，额外声明别名
//@Alias("Stu")
public class Student {
	private Integer studId;
	private String name;
	private String email;
	private Date dob;
	
	public Student() {}
	public Student(String name, String email, Date dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	public Student(Integer studId, String name, String email, Date dob) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	
	public Integer getStudId() {
		//System.out.println("getStudId...");
		return studId;
	}
	public void setId(Integer studId) {
		//System.out.println("setId...");
		this.studId = studId;
	}
	public void setStudId(Integer studId) {
		//System.out.println("setStudId...");
		this.studId = studId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email + ", dob=" + dob + "]";
	}
	
	//生成 构造器  get/set toString
	//alt+shift+s
	
}
