package com.pb.minitxt.service;

import com.pb.minitxt.entity.User;

public interface IUserService {
	/**
	 * �ж��û��Ƿ��ܵ�¼
	 * @param userName  �û���
	 * @param password  �û�����
	 * @return
	 */
	public boolean canLogin(String userName,String password);
	
	/**
	 * �ж��û��Ƿ��ܵ�¼
	 * @param user     �û���ʵ����
	 * @return
	 */
	public boolean canLogin(User user);
	
	/**
	 * �ж��û����Ƿ��Ѿ�����
	 * @param userName      �û���
	 * @return
	 */
	public boolean isExist(String userName);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user);
	
}
