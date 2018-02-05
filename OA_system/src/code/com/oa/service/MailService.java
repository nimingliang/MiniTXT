package com.oa.service;

import java.util.List;

import com.oa.common.Pager;
import com.oa.entity.Mail;
import com.oa.exception.DAOException;
import com.oa.exception.ServiceException;

public interface MailService {

	public boolean addMail(Mail mail) throws ServiceException;
	public Pager<Mail> getMails(int pageSize,int currentPage,int to_uid,int status) throws ServiceException;
	public Mail getMailInfo(int id) throws ServiceException;
	public void updateIR(Mail mail) throws ServiceException;
	public void updateST(Mail mail) throws ServiceException;
	public void delMail(int id) throws ServiceException;
}
