package com.oa.service.impl;

import java.util.List;

import com.oa.common.Pager;
import com.oa.entity.Holiday;
import com.oa.exception.ServiceException;
import com.oa.service.HolidayService;

public class HolidayServiceImpl extends BaseService implements HolidayService{

	@Override
	public List<Holiday> getHolidayByRId(int id) throws ServiceException {
		return holidayDao.findHolidayByRpleyId(id);
	}

	@Override
	public Pager<Holiday> getHolidayByAId(int pageSize,int currentPage,int id) throws ServiceException {
		return holidayDao.findHolidayByAuditId(pageSize, currentPage, id);
	}

	@Override
	public void addHoliday(Holiday holiday) throws ServiceException {
		holidayDao.add(holiday);
		
	}

	@Override
	public Holiday getHoliday(int id) throws ServiceException {
		return holidayDao.findById(id, Holiday.class);
	}

	@Override
	public void updateSta(int id, int status) throws ServiceException {
		holidayDao.updateStatus(id, status);
		
	}

	
	

}
