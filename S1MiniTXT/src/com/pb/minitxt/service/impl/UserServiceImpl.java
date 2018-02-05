package com.pb.minitxt.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.pb.minitxt.constants.Constants;
import com.pb.minitxt.entity.User;
import com.pb.minitxt.service.IUserService;
import com.pb.minitxt.util.FileUtil;

public class UserServiceImpl implements IUserService{
	/**用户信息Map,Key是用户名,value是用户实体类*/
	private static Map<String, User> userMap = new HashMap<String, User>();
	private static String userFileName = Constants.CONFIG_PATH + "/"+ Constants.USER_CONFIG_FILE;
	static {
		initUserMap();
	}

	/**
	 * 读取用户的配置文件，初始化userMap
	 */
	private static void initUserMap() {
		try {
			File file = new File(userFileName);
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader in = new BufferedReader(read);
			String str = "";
			while ((str = in.readLine()) != null) {
				String[] arrStr = str.split(Constants.USER_SPLIT_CHAR);
				if (arrStr !=null && arrStr.length >2){
					User user = new User();
					user.setUserName(arrStr[0]);
					user.setPassword(arrStr[1]);
					user.setRole(arrStr[2]);
					userMap.put(arrStr[1], user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断用户是否可以登录
	 * @param userName    用户名
	 * @param password    用户密码
	 */
	public boolean canLogin(String userName,String password){
		boolean bCan = false;
		User user = userMap.get(userName);
		bCan = user != null && user.getPassword().equals(password);
		return bCan;
	}
	public boolean canLogin(User loginUser){
		boolean bCan = false;
		User user = userMap.get(loginUser.getUserName());
		bCan = user != null && user.getPassword().equals(loginUser.getPassword());
		return bCan;
	}
	public boolean isAdmin(String userName){
		boolean bAdmin = false;
		User user = userMap.get(userName);
		bAdmin = user != null && user.getRole().equals(Constants.USER_ADMIN_FLAG);
		return bAdmin;
	}
	
	/**
	 * 判断用户名是否已经存在
	 * @param userName      用户名
	 * @return
	 */
	public boolean isExist(String userName){
		boolean bExist = false;
		User user = userMap.get(userName);
		bExist = user != null;
		return bExist;
	}
	
	/**
	 * 将用户信息保存到配置文件中
	 */
	public boolean saveUser(User user){
		boolean bSave = false;
		String strUsers = FileUtil.readFileContent(userFileName);
		strUsers = new StringBuffer(strUsers).append(user.getUserName()).append("|")
		           .append(user.getPassword()).append("|")
		           .append(user.getRole()).toString();
		bSave = FileUtil.writeFile(userFileName, strUsers);
		if(bSave){
			userMap.put(user.getUserName(), user);
		}
		return bSave;
	}
	public static void main(String[] args){
		UserServiceImpl userService = new UserServiceImpl();
		boolean bCan = userService.canLogin("admin", "admin");
		boolean bAdmin = userService.isAdmin("admin");
		System.out.println("ban="+bCan);
		System.out.println("bAdmin="+bAdmin);
	}

}
