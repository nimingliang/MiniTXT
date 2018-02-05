package com.oa.service.impl;

import java.util.List;

import com.oa.common.Pager;
import com.oa.entity.Mail;
import com.oa.exception.ServiceException;
import com.oa.service.MailService;

public class MailServiceImpl extends BaseService implements MailService{

	@Override
	public boolean addMail(Mail mail) throws ServiceException {
		
		return mailDao.add(mail)>0?true:false;
	}

	@Override
	public Pager<Mail> getMails(int pageSize,int currentPage,int to_uid,int status) throws ServiceException {
		return mailDao.findMails(pageSize, currentPage, to_uid, status);
	}

	@Override
	public Mail getMailInfo(int id) throws ServiceException {
		
		return mailDao.findMailById(id);
	}

	@Override
	public void updateIR(Mail mail) throws ServiceException {
		mailDao.updateIsread(mail);
		
	}

	@Override
	public void updateST(Mail mail) throws ServiceException {
		mailDao.updateStatus(mail);
		
	}

	@Override
	public void delMail(int id) throws ServiceException {
		mailDao.deleteMail(id);
	}

}
