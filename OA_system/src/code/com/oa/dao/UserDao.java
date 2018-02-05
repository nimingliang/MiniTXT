package com.oa.dao;

import java.util.List;
import java.util.Set;

import com.oa.common.Pager;
import com.oa.entity.User;
import com.oa.exception.DAOException;

public interface UserDao extends IBaseDao<User, Integer>{

	/*
	 * ���û�����ѯ
	 */
	public User findByUserName(String username) throws DAOException;
	public User findById(int id) throws DAOException;
	/*
	 * �����û���ɫ��ѯ
	 */
	public List<User> findUserByRole(int role) throws DAOException;
	/*
	 * �����û���Ϣ
	 */
	public boolean updateUser(User user) throws DAOException;
	
	public void updateNP(User user) throws DAOException;
	
	/*
	 * ��ҳ��ѯ�û���Ϣ
	 */
	public Pager<User> getUserByPage(int pageSize,int currentPage) throws DAOException;
}
