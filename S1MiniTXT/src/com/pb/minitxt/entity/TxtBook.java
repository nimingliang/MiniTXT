package com.pb.minitxt.entity;

import java.io.Serializable;

import com.pb.minitxt.util.StringUtil;

/**
 * 小说的实体类
 * @author BDQN
 *
 */
public class TxtBook implements Serializable{
	
	private int iSequence;
	private String name;
	private String author;
	private String description;
	private String updateTime;
	private String sortName;
	private String fileName;
	/**小说对应的路径*/
	private String absolutePath;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getISequence() {
		return iSequence;
	}
	public void setISequence(int sequence) {
		iSequence = sequence;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer("");
		sb.append("	<txtbook>\n")
		  .append("		<name>").append(this.getName()).append("</name>\n")
		  .append("		<author>").append(this.getAuthor()).append("</author>\n")
		  .append("		<description>").append(this.getDescription()).append("</description>\n")
		  .append("		<filename>").append(this.getFileName()).append("</filename>\n")
		  .append("	</txtbook>\n");
		return sb.toString();
	}
	public String toDetailInfo(){
		StringBuffer sb = new StringBuffer("");
		sb.append(StringUtil.getFixLengthString(this.getName(), 50))
		.append(StringUtil.getFixLengthString(this.getAuthor(), 50))
		.append(StringUtil.getFixLengthString(this.getDescription(), 100));
		return sb.toString();
	}
	

}
