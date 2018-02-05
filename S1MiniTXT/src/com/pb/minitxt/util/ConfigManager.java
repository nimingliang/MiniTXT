package com.pb.minitxt.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

import com.pb.minitxt.constants.Constants;
/**
 * 读取Properties配置文件
 * @author bdqn
 *
 */
public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;
	public static ConfigManager getInstance(){
		if (configManager == null){
			configManager = new ConfigManager();
		}
		return configManager;
	}
	private ConfigManager(){
		/** 配置文件的路径*/
		String configFile = Constants.CONFIG_PATH+"/"+Constants.CONFIG_FILE;
		properties = new Properties();
		File file = new File(configFile);
		try{
			InputStream is = new BufferedInputStream(new FileInputStream(file));
			properties.load(is);
			is.close();
		}catch(Exception e){
			System.err.println("不能读取配置文件,请检查！");
			e.printStackTrace();
		}
		
	}
	/**
	 * 通过配置文件的Key查询对应的值，以字符串形式返回
	 * @param key 配置文件中的key
	 * @return    配置文件中的Key对应的字符串值
	 */
	public String getString(String key){
		return properties.getProperty(key);
	}
	
    /**
     * 通过配置文件的Key查询对应的值，以整形式返回
     * @param key 配置文件中的key
     * @param defaultValue 缺省值
     * @return    配置文件中的Key对应的整形值，如果不存在，以缺省值返回
     */
	public int getInt(String key,String defaultValue){
		String value = properties.getProperty(key);
		int iReturn = 0;
		if (value == null || value.equals("")){
			value = defaultValue;
		}
		iReturn = Integer.parseInt(value);
		return iReturn;
	}
	public static void main(String[] args){
		ConfigManager configManager = ConfigManager.getInstance();
		String ip = configManager.getString("socket.server.ip");
	}
	

}
