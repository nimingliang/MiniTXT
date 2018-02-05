package com.pb.minitxt.service.impl;

import java.io.IOException;
import java.net.Socket;

import com.pb.minitxt.service.ISocketService;

public class SocketServiceImpl implements ISocketService {
	private Socket clientSocket = null;

	/**
	 * 获取Socket连接
	 * @param ip：主机的IP
	 */
	public Socket getClientSocket(String ip, int port) {
		try {
			clientSocket = new Socket(ip, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientSocket;

	}
	
	/**
	 * 释放Socket的连接
	 */
	public boolean disConnection() {
		boolean bDisConnect = false;
		try {
//			socket.shutdownInput();
//			socket.shutdownOutput();
			if (clientSocket != null){
				clientSocket.close();
			}
			bDisConnect = true;
		} catch (IOException e) {
			System.out.println("client关闭失败！");
			e.printStackTrace();
		}
		return bDisConnect;
	}

}
