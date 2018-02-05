package com.oa.entity;

import java.io.Serializable;
import java.util.Date;

public class Mail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String content;
	private Integer isread;
	private Date sendTime;
	private String adjunctPath;
	private Integer from_uid;
	private Integer to_uid;
	private Integer toStatu;
	private Integer fromStatu;
	/*private User userToUid;
	private User userFromUid;*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getIsread() {
		return isread;
	}
	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getAdjunctPath() {
		return adjunctPath;
	}
	public void setAdjunctPath(String adjunctPath) {
		this.adjunctPath = adjunctPath;
	}
	public Integer getToStatu() {
		return toStatu;
	}
	public void setToStatu(Integer toStatu) {
		this.toStatu = toStatu;
	}
	public Integer getFromStatu() {
		return fromStatu;
	}
	public void setFromStatu(Integer fromStatu) {
		this.fromStatu = fromStatu;
	}
	
	public Integer getFrom_uid() {
		return from_uid;
	}
	public void setFrom_uid(Integer from_uid) {
		this.from_uid = from_uid;
	}
	public Integer getTo_uid() {
		return to_uid;
	}
	public void setTo_uid(Integer to_uid) {
		this.to_uid = to_uid;
	}
	
	
	

}
