package com.pb.minitxt.constants;


/**
 * 常量类
 * @author BDQN
 *
 */
public class Constants {
	public static final String CONFIG_PATH = "config";
	public static final String CONFIG_FILE = "minitxt.properties";
	public static final String SCOKET_SERVER_IP = "socket.server.ip";
	public static final String SCOKET_SERVER_PORT = "socket.server.port";
	public static final String CLIENT_DOWNLOAD_PATH = "client.download.path";;
	public static final String USER_CONFIG_FILE="userinfo.txt";
	public static final String USER_SPLIT_CHAR="\\|";
	public static final String USER_ADMIN_FLAG="0";
	public static final String USER_NORMAL_FLAG="1";
	public static final String OUTPUT_SIGN_LINE="-------------------------------------\n";
	public static final String OUTPUT_SIGN_ASTERISK="*************************************";
	public static final String OUTPUT_SIGN_WAVELINE="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	public static final String OUTPUT_SIGN_SELECT="请选择： ";
	public static final String OUTPUT_TEXT_TITLE="欢 迎 使 用 在线迷 你TXT小说管 理 器\n";
	public static final String OUTPUT_TEXT_LOGIN="1.登录\n";
	public static final String OUTPUT_TEXT_REGISTER="2.注册\n";
	public static final String OUTPUT_TEXT_LOGOUT="3.退出\n";
	public static final String OUTPUT_TEXT_WUXIA="1.武侠\n";
	public static final String OUTPUT_TEXT_YANQING="2.言情\n";;
	public static final String OUTPUT_TEXT_RETURN="0.返回上级菜单\n";
	public static final String OUTPUT_TEXT_THANK="谢谢 使 用！\n";
	public static final StringBuffer MENU_START 
							   = new StringBuffer(OUTPUT_TEXT_TITLE)
	                                .append(OUTPUT_SIGN_LINE)
	                                .append(OUTPUT_TEXT_LOGIN)
	                                .append(OUTPUT_TEXT_REGISTER)
	                                .append(OUTPUT_TEXT_LOGOUT)
	                                .append(OUTPUT_SIGN_LINE)
	                                .append(OUTPUT_SIGN_SELECT);
	
	public static final StringBuffer MENU_TEXT_SORT 
								= new StringBuffer(OUTPUT_SIGN_LINE)
									.append(OUTPUT_TEXT_RETURN)
									.append(OUTPUT_TEXT_WUXIA)
									.append(OUTPUT_TEXT_YANQING)
									.append(OUTPUT_SIGN_LINE)
									.append(OUTPUT_SIGN_SELECT);
	
	
	/**
	 * LOGIN
	 */
	public static final String OUTPUT_TEXT_USERNAMEE="请输入登录名:";
	public static final String OUTPUT_TEXT_PASSWORD="请输入密码:";
	public static final String OUTPUT_TEXT_PASSWORD2="请再次输入密码:";
	public static final String OUTPUT_TEXT_USEREXIST="用户已存在！";
	public static final String OUTPUT_TEXT_PASSWORDNOTEQUAL="两次密码不一样！";
	public static final String OUTPUT_TEXT_LOGINSUCCESS="登录成功！";
	public static final String OUTPUT_TEXT_LOGINFAIL="登录失败！";
	public static final String OUTPUT_USER_SAVESUCESS="用户注册成功，请登录！";
	public static final String OUTPUT_USER_SAVEFAIL="用户注册失败，请重新注册！";
	public static final String OUTPUT_TEXT_BOOKADD="------------------增加小说-------------------\n:";
	public static final String OUTPUT_TEXT_BOOKNAME="【请输入小说的名字】:";
	public static final String OUTPUT_TEXT_BOOKAUTHOR="【请输入小说的作者】:";
	public static final String OUTPUT_TEXT_BOOKDESC="【请输入小说的简介】:";
	public static final String STORY_TEXT_RETURN="0.返回上一级菜单\n";
	public static final String STORY_TEXT_READ="1.在线阅读\n";
	public static final String STORY_TEXT_DOWNLOAD="2.下载TXT\n";
	public static final String STORY_TEXT_SHOWLIST="1.显示TXT\n";
	public static final String STORY_TEXT_UPLOAD="2.上传TXT\n";
	public static final String STORY_TEXT_MANAGE="3.TXT管理\n";
	public static final String STORY_TEXT_USERMANAGER="5.会员管理\n";
	public static final String STORY_TEXT_EXIT="6.退出\n";
	public static final StringBuffer MENU_MAIN 
	   						= new StringBuffer(OUTPUT_SIGN_LINE)
	                            .append(STORY_TEXT_READ)
         						.append(STORY_TEXT_DOWNLOAD)
         						.append(STORY_TEXT_UPLOAD)
         						.append(STORY_TEXT_MANAGE)
         						.append(STORY_TEXT_USERMANAGER)
         						.append(STORY_TEXT_EXIT)
         						.append(OUTPUT_SIGN_LINE)
         						.append(OUTPUT_SIGN_SELECT);
	public static final StringBuffer MENU_TXT_MANAGE 
							= new StringBuffer(OUTPUT_SIGN_LINE)
        						.append(STORY_TEXT_SHOWLIST)
        						.append(STORY_TEXT_UPLOAD)
        						.append(STORY_TEXT_UPLOAD)
        						.append(STORY_TEXT_MANAGE)
        						.append(OUTPUT_SIGN_SELECT);
	public static final StringBuffer MENU_FUNCTION = new StringBuffer(OUTPUT_SIGN_LINE)
								.append(STORY_TEXT_RETURN)
								.append(STORY_TEXT_READ)
								.append(STORY_TEXT_DOWNLOAD)
								.append(OUTPUT_SIGN_LINE);
	
	public static final String CATALOG_PATH_WUXIA="catalog.path.wuxia";
	public static final String CATALOG_PATH_YANQING="catalog.path.yanqing";
	public static final String CATALOG_PATH_JISHI="catalog.path.jishi";
	public static final String CATALOG_PATH_KEHUAN="catalog.path.kehuan";
	public static final String CATALOG_NAME_WUXIA="武侠";
	public static final String CATALOG_NAME_YANQING="言情";
	
	public static final String CATALOG_XML_WUXIA="txt_wuxia.xml";
	public static final String CATALOG_XML_YANQING="txt_yanqing.xml";
	public static final String COMMAND_LOGIN="login";
	public static final String COMMAND_REGISTERUSER="registeruser";
	public static final String COMMAND_SHOWTXTLIST="showTxtList";
	public static final String COMMAND_READTXT="readtxt";
	public static final String COMMAND_DOWNLOADTXT="downloadtxt";;
	public static final String COMMAND_UPLOADTXT="uploadtxt";
	public static final String COMMAND_MANAGETXT="managetxt";
	public static final String OUTPUT_ASTERISKLINE="**********************************************\n";
	
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
	public static final String XML_WUXIA_HEADER="<wuxialist>\n";
	public static final String XML_WUXIA_TAIL="</wuxialist>";
	public static final String XML_YANQING_HEADER="<yanqinglist>\n";
	public static final String XML_YANQING_TAIL="</yanqinglist>";
	
	public static final String OUTPUT_DOTTED_LINE="------------------";
	public static final String OUTPUT_DOTTED_LINEN="------------------\n";
	
	public static final String OUTPUT_TEXT_READDOWN="阅读和下载请选择文件序号，上传TXT请输入-1，返回请输入0:";
	
	public static final String OUTPUT_DOTTED_ARROW="----->";
	public static final String OUTPUT_ACTION_READ="阅读";
	public static final String OUTPUT_ACTION_REGISTER="注册用户";
	public static final String OUTPUT_ACTION_USERLOGIN="用户登录";
	public static final String OUTPUT_ACTION_CURRENT="当前操作:";
	
	public static final String OUTPUT_TEXT_SELECTLIST="继续显示列表请输入1，下载TXT请输入2:";
	public static final String OUTPUT_TEXT_SELECTRETURN="返回请输入0:";
	public static final String OUTPUT_TEXT_SELECTERROR="选择错误，请重新选择:";
	public static final String OUTPUT_INPUT_NAME="请输入小说名：";
	public static final String OUTPUT_INPUT_AUTHOR="请输入作者：";
	public static final String OUTPUT_INPUT_DESC="请输入简介：";
	public static final String OUTPUT_INPUT_PATH="请输入上传的txt(请注意路径用/或者\\\\)：";
	public static final String OUTPUT_TEXT_REUPLOAD="继续上传请输入1，返回请输入0：";
	public static final String OUTPUT_DOWNLOAD_FILENAME="下载后的文件名是：";
	public static final String OUTPUT_DOWNLOAD_FILEPATH="下载后的路径是：";
	public static final String OUTPUT_DOWNLOAD_RESULT="文件下载结果：";
	public static final String OUTPUT_TEXT_SAVESUCCESS="小说保存成功！";
	
	
	public static final String ERROR_CHECK_CONFIGFILE="请检查配置文件 是否存在:";
	public static final String ERROR_CHECK_SERVERINFO="请检查Server的配置信息!";
	public static final String ERROR_FILE_INPUTERROR="文件输入不正确，请重新输入！";
	public static final String ERROR_TEXT_INPUTERROR="输入不正确！请重新输入！";
	public static final String ERROR_TEXT_NOTEXIST="选择的小说不存在！";
	public static final String ERROR_TEXT_SERVERNOTEXIST="服务器上的小说不存在！请联系管理员检查服务器配置！";
	public static final String ERROR_TEXT_TXTEXIST="小说已经存在！";
	
	
	
	
	

}
