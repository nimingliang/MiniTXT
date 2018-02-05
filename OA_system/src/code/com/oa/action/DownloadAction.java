package com.oa.action;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

public class DownloadAction extends BaseAction{

	private String fileName;
	private String inputStream;
	
	public String getFileName() throws UnsupportedEncodingException {
		return new String(this.fileName.getBytes("ISO8859-1"),"UTF-8");
	}
	public void setInputStream(String inputStream) {
		this.inputStream = inputStream;
		
	}
	public void setFileName(String fileName) throws UnsupportedEncodingException {
		this.fileName = fileName;
	}
	public InputStream getInputStream() throws FileNotFoundException{
		//return ServletActionContext.getServletContext().getResourceAsStream("/upload"+fileName);
		//return new ByteArrayInputStream(fileName.getBytes());
		
		return new FileInputStream(fileName);
	}
	public String execute(){
		return SUCCESS;
	}
}
