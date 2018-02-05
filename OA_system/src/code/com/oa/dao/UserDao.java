package com.oa.dao;

import java.util.List;
import java.util.Set;

import com.oa.common.Pager;
import com.oa.entity.User;
import com.oa.exception.DAOException;

public interface UserDao extends IBaseDao<User, Integer>{

	/*
	 * 按用户名查询
	 */
	public User findByUserName(String username) throws DAOException;
	public User findById(int id) throws DAOException;
	/*
	 * 更具用户角色查询
	 */
	public List<User> findUserByRole(int role) throws DAOException;
	/*
	 * 更新用户信息
	 */
	public boolean updateUser(User user) throws DAOException;
	
	public void updateNP(User user) throws DAOException;
	
	/*
	 * 分页查询用户信息
	 */
	public Pager<User> getUserByPage(int pageSize,int currentPage) throws DAOException;
}
