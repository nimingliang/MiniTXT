package com.oa.service.impl;

import java.util.List;

import com.oa.common.Pager;
import com.oa.entity.User;
import com.oa.exception.ServiceException;
import com.oa.service.UserService;

public class UserServiceImpl extends BaseService implements UserService{

	@Override
	public User checkUser(String username, String password)
			throws ServiceException {
		User user = userDao.findByUserName(username);
		if (user!=null&&user.getUpwd().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public User getUserById(int id) throws ServiceException {
		
		return userDao.findById(id);
	}

	@Override
	public boolean update(User user) throws ServiceException {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		return userDao.find(User.class);
	}

	@Override
	public void updateUname(User user) throws ServiceException {
		userDao.updateNP(user);
		
	}

	@Override
	public void addUser(User user) throws ServiceException {
		userDao.add(user);
		
	}

	@Override
	public List<User> getUsersByRole(int role) throws ServiceException {
		// TODO Auto-generated method stub
		return userDao.findUserByRole(role);
	}

	@Override
	public Pager<User> getUserByPage(int pageSize, int currentPage)
			throws ServiceException {
		// TODO Auto-generated method stub
		return userDao.getUserByPage(pageSize, currentPage);
	}


}
