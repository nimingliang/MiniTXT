package com.pb.minitxt.service.impl;

import java.io.IOException;
import java.net.Socket;

import com.pb.minitxt.service.ISocketService;

public class SocketServiceImpl implements ISocketService {
	private Socket clientSocket = null;

	/**
	 * ��ȡSocket����
	 * @param ip��������IP
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
	 * �ͷ�Socket������
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
			System.out.println("client�ر�ʧ�ܣ�");
			e.printStackTrace();
		}
		return bDisConnect;
	}

}
