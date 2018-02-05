package com.pb.minitxt.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * @author BDQN
 *
 */
public class User implements Serializable{
	/**用户名*/
	private String userName;
	private String password;
	private String role;
	private boolean isAdmin;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
