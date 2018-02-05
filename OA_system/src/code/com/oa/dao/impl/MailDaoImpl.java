package com.oa.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oa.common.Pager;
import com.oa.dao.MailDao;
import com.oa.entity.Mail;
import com.oa.exception.DAOException;

public class MailDaoImpl extends BaseDao<Mail, Integer> implements MailDao{

	@Override
	public Pager<Mail> findMails(int pageSize,int currentPage,int to_uid,int status) throws DAOException {
		String hql = "from Mail m where m.to_uid=:to_uid and m.toStatu=:status";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("to_uid", to_uid);
		params.put("status", status);
		Pager<Mail> list = super.findPager(hql, currentPage, pageSize, params);
		return list!=null?list:null;
	}

	@Override
	public Mail findMailById(int id) throws DAOException {
		
		return super.findById(id, Mail.class);
	}

	@Override
	public void updateIsread(Mail mail) throws DAOException {
		String hql = "update Mail m set m.isread=:isread where m.id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isread", mail.getIsread());
		params.put("id", mail.getId());
		super.executeUpdate(hql, params);
		
	}

	@Override
	public void updateStatus(Mail mail) throws DAOException {
		String hql = "update Mail m set m.toStatu=:toStatu where m.id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("toStatu", mail.getToStatu());
		params.put("id", mail.getId());
		super.executeUpdate(hql, params);
		
	}

	@Override
	public void deleteMail(int id) throws DAOException {
		String hql = "delete Mail m where m.id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		super.executeUpdate(hql, params);
		
	}

}
