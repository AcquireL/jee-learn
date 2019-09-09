package com.briup.pojo;

import java.util.Date;

public class Student2 {
	private Integer studId;
	private String name;
	private String email;
	private Date dob;
	//额外添加成员对象
	private PhoneNumber phone;
	
	public Student2() {}
	public Student2(String name, String email, Date dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	public Student2(Integer studId, String name, String email, Date dob) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
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
		return "Student2 [studId=" + studId + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phone="
				+ phone + "]";
	}
	
	//生成 构造器  get/set toString
	//alt+shift+s
	
}
