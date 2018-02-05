package com.oa.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oa.common.Pager;
import com.oa.dao.UserDao;
import com.oa.entity.User;
import com.oa.exception.DAOException;

public class UserDaoImpl extends BaseDao<User, Integer> implements UserDao{

	@Override
	public User findByUserName(String username) throws DAOException {
		String hql = "from User u where u.uname=:uname";
		Map<String , Object> params = new HashMap<String, Object>();
		params.put("uname", username);
		List<User> list = super.queryListByHql(hql, params);
		return list!=null&&list.size()>0?list.get(0):null;
	}

	

	@Override
	public User findById(int id) throws DAOException {
		return super.findById(id, User.class);
	}



	@Override
	public boolean updateUser(User user) throws DAOException {
		boolean flag = false;
		String hql = "update User u set u.nickName=:nickName,u.age=:age,u.sex=:sex,u.mobile=:mobile,u.address=:address where u.id=:id";
		Map<String , Object> params = new HashMap<String, Object>();
		params.put("nickName", user.getNickName());
		params.put("age", user.getAge());
		params.put("sex", user.getSex());
		params.put("mobile", user.getMobile());
		params.put("address", user.getAddress());
		params.put("id", user.getId());
		try {
			super.executeUpdate(hql, params);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}



	@Override
	public void updateNP(User user) throws DAOException {
		String hql = "update User u set u.uname=:uname,u.upwd=:upwd where u.id=:id";
		Map<String , Object> params = new HashMap<String, Object>();
		params.put("uname", user.getUname());
		params.put("upwd", user.getUpwd());
		params.put("id", user.getId());
		super.executeUpdate(hql, params);
	}



	@Override
	public List<User> findUserByRole(int role) throws DAOException {
		String hql = "from User u where u.role=:role";
		Map<String , Object> params = new HashMap<String, Object>();
		params.put("role", role);
		List<User> list = super.queryListByHql(hql, params);
		return list!=null&&list.size()>0?list:null;
	}



	@Override
	public Pager<User> getUserByPage(int pageSize, int currentPage)
			throws DAOException {
		return super.findPager(currentPage, pageSize, User.class);
	}





	
}
