package com.oa.action;


import java.util.Date;
import java.util.List;

import com.oa.common.Pager;
import com.oa.common.RetCode;

import com.oa.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction{

	private User user;
	private List<User> userList;
	private Pager<User> pager;
	public String login() throws Exception{
		try {
			User item = userService.checkUser(user.getUname(), user.getUpwd());
			if (item!=null) {
				putToSession("loginuser",item);
				//putToSession("rightPage", "<%@include file='right.jsp' %>");
				log.info("{} login seccess!!!",item.getUpwd());
				resultMap.put("retcode", RetCode.SUCCESS);
			}else {
				resultMap.put("retcode", RetCode.FAIL);
				resultMap.put("retmsg", "用户名或密码错误");
			}
		} catch (Exception e) {
			log.error("login bug{}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "未知错误，清联系管理员");
		}
		return SUCCESS;
	}

	public String userInfo() throws Exception{
		try {
			user = userService.getUserById(user.getId());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	public String toEditUser(){
		try {
			user = userService.getUserById(user.getId());
			return SUCCESS;
		} catch (Exception e) {
			log.error("toEditUser bug:{}",e);
		}
		return ERROR;
	}
	public String doUpdateUser() {
		
		try {
			userService.update(user);
			ActionContext.getContext().getSession().remove("loginuser");
			user = userService.getUserById(user.getId());
			putToSession("loginuser", user);
			log.info("doUpdateUser success:{}",user.getId());
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("retmsg", "修改成功！");
		} catch (Exception e) {
			log.error(" doUpdateUser bug:{}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "修改失败，请重试！");
		}
		return SUCCESS;
	}
		public String doUpdateUser2() {
		
		try {
			userService.updateUname(user);
			log.info("doUpdateUser2 success:{}",user.getId());
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("retmsg", "修改成功！");
		} catch (Exception e) {
			log.error(" doUpdateUser2 bug:{}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "修改失败，请重试！");
		}
		return SUCCESS;
	}
		public String doAddUser() {
			
			try {
				user.setRole(2);
				userService.addUser(user);
				log.info("doAddUser success:{}",user.getId());
				resultMap.put("retcode", RetCode.SUCCESS);
				resultMap.put("retmsg", "添加成功！");
			} catch (Exception e) {
				log.error(" doAddUser bug:{}",e);
				resultMap.put("retcode", RetCode.UNKOWN_WRONG);
				resultMap.put("retmsg", "添加失败，请重试！");
			}
			return SUCCESS;
		}
	public String findAllUser(){
		try {
			userList = userService.findAllUsers();
			putToSession("fromID", user.getId());
			return SUCCESS;
		} catch (Exception e) {
			log.error("findUsers bug:{}",e);
		}
		return ERROR;
	}
	public String findAllUser2(){
		try {
			if (pager==null) {
				pager = new Pager<User>();
			}
			//userList = userService.findAllUsers();
			pager = userService.getUserByPage(pager.getPageSize(), pager.getCurrentPage());
			return SUCCESS;
		} catch (Exception e) {
			log.error("findUsers bug:{}",e);
		}
		return ERROR;
	}
	public String loginOut(){
		ActionContext.getContext().getSession().clear();
		
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Pager<User> getPager() {
		return pager;
	}

	public void setPager(Pager<User> pager) {
		this.pager = pager;
	}
	
}
