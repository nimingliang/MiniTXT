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
 * ��ȡProperties�����ļ�
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
		/** �����ļ���·��*/
		String configFile = Constants.CONFIG_PATH+"/"+Constants.CONFIG_FILE;
		properties = new Properties();
		File file = new File(configFile);
		try{
			InputStream is = new BufferedInputStream(new FileInputStream(file));
			properties.load(is);
			is.close();
		}catch(Exception e){
			System.err.println("���ܶ�ȡ�����ļ�,���飡");
			e.printStackTrace();
		}
		
	}
	/**
	 * ͨ�������ļ���Key��ѯ��Ӧ��ֵ�����ַ�����ʽ����
	 * @param key �����ļ��е�key
	 * @return    �����ļ��е�Key��Ӧ���ַ���ֵ
	 */
	public String getString(String key){
		return properties.getProperty(key);
	}
	
    /**
     * ͨ�������ļ���Key��ѯ��Ӧ��ֵ��������ʽ����
     * @param key �����ļ��е�key
     * @param defaultValue ȱʡֵ
     * @return    �����ļ��е�Key��Ӧ������ֵ����������ڣ���ȱʡֵ����
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
