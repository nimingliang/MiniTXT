package com.pb.minitxt.service;

import java.net.Socket;

public interface ISocketService {
	
	/**
	 * ��ȡSocket������
	 * @param ip      ��������IP
	 * @param port    �˿�
	 * @return
	 * @throws Exception
	 */
	public Socket getClientSocket(String ip,int port) throws Exception;
	
	/**
	 * �ͷ�Socket����
	 * @return
	 */
	public boolean disConnection();

}
