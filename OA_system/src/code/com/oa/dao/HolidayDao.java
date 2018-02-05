package com.oa.dao;

import java.util.List;

import com.oa.common.Pager;
import com.oa.entity.Holiday;
import com.oa.exception.DAOException;

public interface HolidayDao extends IBaseDao<Holiday, Integer>{

	public List<Holiday> findHolidayByRpleyId(int id) throws DAOException;
	public Pager<Holiday> findHolidayByAuditId(int pageSize,int currentPage,int id) throws DAOException;
	public void updateStatus(int id,int status) throws DAOException;
}
