package com.oa.service;

import java.util.List;

import com.oa.common.Pager;
import com.oa.entity.Holiday;
import com.oa.exception.ServiceException;

public interface HolidayService {

	public List<Holiday> getHolidayByRId(int id) throws ServiceException;
	public Pager<Holiday> getHolidayByAId(int pageSize,int currentPage,int id) throws ServiceException;
	public void addHoliday(Holiday holiday) throws ServiceException;
	public Holiday getHoliday(int id) throws ServiceException;
	public void updateSta(int id,int status) throws ServiceException;
}
