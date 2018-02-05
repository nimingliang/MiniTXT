package com.oa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String uname;
	private String upwd;
	private Integer age;
	private String sex;
	private String nickName;
	private String mobile;
	private String address;
	private String realName;
	private Integer role;
	/*private Set mailsFromUid = new HashSet();
	private Set mailsToUid = new HashSet();
	private Set replys = new HashSet();
	private Set audits = new HashSet();*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	
}
