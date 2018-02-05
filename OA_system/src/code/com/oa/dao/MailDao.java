package com.oa.dao;

import java.util.List;

import com.oa.common.Pager;
import com.oa.entity.Mail;
import com.oa.exception.DAOException;

public interface MailDao extends IBaseDao<Mail, Integer>{

	public Pager<Mail> findMails(int pageSize,int currentPage,int to_uid,int status) throws DAOException;
	public Mail findMailById(int id) throws DAOException;
	public void updateIsread(Mail mail) throws DAOException;
	public void updateStatus(Mail mail) throws DAOException;
	public void deleteMail(int id) throws DAOException;
}
