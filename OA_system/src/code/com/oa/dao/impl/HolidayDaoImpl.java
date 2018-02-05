package com.oa.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oa.common.Pager;
import com.oa.dao.HolidayDao;
import com.oa.entity.Holiday;
import com.oa.exception.DAOException;

public class HolidayDaoImpl extends BaseDao<Holiday, Integer> implements HolidayDao{

	@Override
	public List<Holiday> findHolidayByRpleyId(int id) throws DAOException {
		String hql = "from Holiday h where h.replyId=:replyId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("replyId", id);
		List<Holiday> list = super.queryListByHql(hql, params);
		return list!=null&&list.size()>0?list:null;
	}

	@Override
	public Pager<Holiday> findHolidayByAuditId(int pageSize,int currentPage,int id) throws DAOException {
		String hql = "from Holiday h where h.auditId=:auditId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("auditId", id);
		Pager<Holiday> list = super.findPager(hql, currentPage, pageSize, params);
		return list!=null?list:null;
	}

	@Override
	public void updateStatus(int id,int status) throws DAOException {
		String hql = "update Holiday h set h.status=:status where h.id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		params.put("id", id);
		super.executeUpdate(hql, params);
	}

	

}
