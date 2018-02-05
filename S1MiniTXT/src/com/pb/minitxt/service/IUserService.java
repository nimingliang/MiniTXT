package com.pb.minitxt.service;

import com.pb.minitxt.entity.User;

public interface IUserService {
	/**
	 * 判断用户是否能登录
	 * @param userName  用户名
	 * @param password  用户密码
	 * @return
	 */
	public boolean canLogin(String userName,String password);
	
	/**
	 * 判断用户是否能登录
	 * @param user     用户的实体类
	 * @return
	 */
	public boolean canLogin(User user);
	
	/**
	 * 判断用户名是否已经存在
	 * @param userName      用户名
	 * @return
	 */
	public boolean isExist(String userName);
	
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user);
	
}
