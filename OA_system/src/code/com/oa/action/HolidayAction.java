package com.oa.action;

import java.util.List;

import com.oa.common.Pager;
import com.oa.common.RetCode;
import com.oa.entity.Holiday;
import com.oa.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class HolidayAction extends BaseAction{

	private Holiday holiday;
	private List<Holiday> holidayList;
	private Pager<Holiday> pager;
	private List<User> userList;
	public User user = (User)ActionContext.getContext().getSession().get("loginuser");
	
	
	public String findCH(){
		try {
			holidayList = holidayService.getHolidayByRId(user.getId());
			
			return SUCCESS;
		} catch (Exception e) {
			log.error("findHoliday bug:{}",e);
		}
		return ERROR;
	}
	public String findMH(){
		try {
			if (pager==null) {
				pager = new Pager<Holiday>();
			}
			//holidayList = holidayService.getHolidayByAId(user.getId());
			pager = holidayService.getHolidayByAId(pager.getPageSize(), pager.getCurrentPage(), user.getId());
			return SUCCESS;
		} catch (Exception e) {
			log.error("findHoliday bug:{}",e);
		}
		return ERROR;
	}
	public String audit(){
		try {
			holiday = holidayService.getHoliday(holiday.getId());
			return SUCCESS;
		} catch (Exception e) {
			log.error("audit bug:{}",e);
		}
		return ERROR;
	}
	public String replyHoliday(){
		try {
			userList = userService.getUsersByRole(1);
			
			return SUCCESS;
		} catch (Exception e) {
			log.error("findHoliday bug:{}",e);
		}
		return ERROR;
	}
	public String replyG(){
		try {
			holidayService.updateSta(holiday.getId(), 0);
			return SUCCESS;
		} catch (Exception e) {
			log.error("replyG bug:{}",e);
		}
		return ERROR;
	}
	public String replyB(){
		try {
			holidayService.updateSta(holiday.getId(), 3);
			return SUCCESS;
		} catch (Exception e) {
			log.error("replyG bug:{}",e);
		}
		return ERROR;
	}
	public String doAddReply() {
		
		try {
			holiday.setReplyId(user.getId());
			holiday.setStatus(1);
			holidayService.addHoliday(holiday);
			log.info("doAddReply success:{}",user.getId());
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("retmsg", "…Í«Î≥…π¶£°");
		} catch (Exception e) {
			log.error(" doAddReply bug:{}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "…Í«Î ß∞‹£¨«Î÷ÿ ‘£°");
		}
		return SUCCESS;
	}
	public String back(){
		if (user.getRole()==1) {
			return "m";
		}
		return "c";
	}
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}
	public List<Holiday> getHolidayList() {
		return holidayList;
	}
	public void setHolidayList(List<Holiday> holidayList) {
		this.holidayList = holidayList;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public Pager<Holiday> getPager() {
		return pager;
	}
	public void setPager(Pager<Holiday> pager) {
		this.pager = pager;
	}
	
	
}
