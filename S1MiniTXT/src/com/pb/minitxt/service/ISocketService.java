package com.pb.minitxt.service;

import java.net.Socket;

public interface ISocketService {
	
	/**
	 * 获取Socket的连接
	 * @param ip      服务器的IP
	 * @param port    端口
	 * @return
	 * @throws Exception
	 */
	public Socket getClientSocket(String ip,int port) throws Exception;
	
	/**
	 * 释放Socket连接
	 * @return
	 */
	public boolean disConnection();

}
