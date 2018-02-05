package com.oa.service;

import java.util.List;

import com.oa.common.Pager;
import com.oa.entity.User;
import com.oa.exception.DAOException;
import com.oa.exception.ServiceException;

public interface UserService {

	/*
	 * 按用户名查询
	 */
	public User checkUser(String username,String password) throws ServiceException;
	
	public User getUserById(int id) throws ServiceException;
	public List<User> getUsersByRole(int role) throws ServiceException;
	public boolean update(User user) throws ServiceException;
	public void updateUname(User user) throws ServiceException;
	/*
	 * 查询所有用户昵称
	 */
	public List<User> findAllUsers() throws ServiceException;
	
	/*
	 * 添加用户
	 */
	public void addUser(User user) throws ServiceException;
	
	public Pager<User> getUserByPage(int pageSize,int currentPage) throws ServiceException;
}
