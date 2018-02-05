package com.oa.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oa.dao.HolidayDao;
import com.oa.dao.MailDao;
import com.oa.dao.UserDao;
import com.oa.entity.Holiday;

public class BaseService {
	public Logger log = LoggerFactory.getLogger(this.getClass());
	protected UserDao userDao;
	protected MailDao mailDao;
	protected HolidayDao holidayDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}
	public void setHolidayDao(HolidayDao holidayDao) {
		this.holidayDao = holidayDao;
	}
	
	
}
