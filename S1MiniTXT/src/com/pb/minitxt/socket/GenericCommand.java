package com.pb.minitxt.socket;

import java.io.Serializable;

/**
 * 此类是一个序列化的泛型类，用于在客户端和服务器传输数据
 * @author BDQN
 *
 * @param <T> 可以是任何序列化的对象
 */
public class GenericCommand<T> implements Serializable{
	/**主要是用来保存发送的数据*/
	private T dataObject;
	
	/**当前操作命令*/
	private String command;
	
	/**操作返回的结果*/
	private String resultInfo;
	
	/**操作结果是否成功*/
	private boolean success;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public GenericCommand(T dataObject){
		this.dataObject = dataObject;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public T getDataObject() {
		return dataObject;
	}
	public void setDataObject(T dataObject) {
		this.dataObject = dataObject;
	}
	public String getResultInfo() {
		return resultInfo;
	}
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}
}
