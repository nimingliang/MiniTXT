package com.pb.minitxt.socket;

import java.io.Serializable;

/**
 * ������һ�����л��ķ����࣬�����ڿͻ��˺ͷ�������������
 * @author BDQN
 *
 * @param <T> �������κ����л��Ķ���
 */
public class GenericCommand<T> implements Serializable{
	/**��Ҫ���������淢�͵�����*/
	private T dataObject;
	
	/**��ǰ��������*/
	private String command;
	
	/**�������صĽ��*/
	private String resultInfo;
	
	/**��������Ƿ�ɹ�*/
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
