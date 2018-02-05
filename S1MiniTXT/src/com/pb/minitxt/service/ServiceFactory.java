package com.pb.minitxt.service;

import com.pb.minitxt.service.impl.SocketServiceImpl;
import com.pb.minitxt.service.impl.TxtServiceImpl;
import com.pb.minitxt.service.impl.UserServiceImpl;

/**
 * Service的工厂类
 * @author BDQN
 *
 */
public class ServiceFactory {
	public static IUserService getUserService(){
		return new UserServiceImpl();
	}
	public static ISocketService getSocketService(){
		return new SocketServiceImpl();
	}
	public static ITxtService getTxtService(){
		return new TxtServiceImpl();
	}


}
