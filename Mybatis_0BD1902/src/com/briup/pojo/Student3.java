package com.briup.pojo;

import java.util.Date;

public class Student3 {
	private Integer studId;
	private String name;
	private String email;
	private Date dob;
	//额外添加成员对象
	private PhoneNumber phone;
	//额外添加地址对象
	private Address address;
	
	public Student3() {}
	public Student3(String name, String email, Date dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	public Student3(Integer studId, String name, String email, Date dob, PhoneNumber phone, Address address) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
	}
	public Student3(Integer studId, String name, String email, Date dob) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
		return "Student3 [studId=" + studId + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phone="
				+ phone + ", address=" + address + "]";
	}
	//生成 构造器  get/set toString
	//alt+shift+s
	
}
