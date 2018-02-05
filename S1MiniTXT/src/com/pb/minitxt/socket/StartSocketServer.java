package com.pb.minitxt.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.pb.minitxt.constants.Constants;
import com.pb.minitxt.util.ConfigManager;

/*
 * ����������
 */
public class StartSocketServer {
	
	public static void main(String args[]){		
		try {
			ConfigManager configManager = ConfigManager.getInstance();
			int port = configManager.getInt(Constants.SCOKET_SERVER_PORT,"5678");
			System.out.println("server port ==="+port);
			ServerSocket serverSocket = new ServerSocket(port);
			while(true){				
				Socket clientSocket = serverSocket.accept();
				System.out.println(new Date().toLocaleString()+"�ͻ��ˣ�" + clientSocket.getInetAddress() + "��ȡ�����ӣ�");
				Thread server_thread = new Thread(new TxtSocketServer(clientSocket));
				server_thread.start();
			}
		} catch (IOException e) {
			System.out.println("����������ʧ�ܣ�������ϵ����Ա���ԭ��");
			e.printStackTrace();
		}
	}
}
