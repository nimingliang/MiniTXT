package com.pb.minitxt.constants;


/**
 * ������
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
	public static final String OUTPUT_SIGN_SELECT="��ѡ�� ";
	public static final String OUTPUT_TEXT_TITLE="�� ӭ ʹ �� ������ ��TXTС˵�� �� ��\n";
	public static final String OUTPUT_TEXT_LOGIN="1.��¼\n";
	public static final String OUTPUT_TEXT_REGISTER="2.ע��\n";
	public static final String OUTPUT_TEXT_LOGOUT="3.�˳�\n";
	public static final String OUTPUT_TEXT_WUXIA="1.����\n";
	public static final String OUTPUT_TEXT_YANQING="2.����\n";;
	public static final String OUTPUT_TEXT_RETURN="0.�����ϼ��˵�\n";
	public static final String OUTPUT_TEXT_THANK="лл ʹ �ã�\n";
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
	public static final String OUTPUT_TEXT_USERNAMEE="�������¼��:";
	public static final String OUTPUT_TEXT_PASSWORD="����������:";
	public static final String OUTPUT_TEXT_PASSWORD2="���ٴ���������:";
	public static final String OUTPUT_TEXT_USEREXIST="�û��Ѵ��ڣ�";
	public static final String OUTPUT_TEXT_PASSWORDNOTEQUAL="�������벻һ����";
	public static final String OUTPUT_TEXT_LOGINSUCCESS="��¼�ɹ���";
	public static final String OUTPUT_TEXT_LOGINFAIL="��¼ʧ�ܣ�";
	public static final String OUTPUT_USER_SAVESUCESS="�û�ע��ɹ������¼��";
	public static final String OUTPUT_USER_SAVEFAIL="�û�ע��ʧ�ܣ�������ע�ᣡ";
	public static final String OUTPUT_TEXT_BOOKADD="------------------����С˵-------------------\n:";
	public static final String OUTPUT_TEXT_BOOKNAME="��������С˵�����֡�:";
	public static final String OUTPUT_TEXT_BOOKAUTHOR="��������С˵�����ߡ�:";
	public static final String OUTPUT_TEXT_BOOKDESC="��������С˵�ļ�顿:";
	public static final String STORY_TEXT_RETURN="0.������һ���˵�\n";
	public static final String STORY_TEXT_READ="1.�����Ķ�\n";
	public static final String STORY_TEXT_DOWNLOAD="2.����TXT\n";
	public static final String STORY_TEXT_SHOWLIST="1.��ʾTXT\n";
	public static final String STORY_TEXT_UPLOAD="2.�ϴ�TXT\n";
	public static final String STORY_TEXT_MANAGE="3.TXT����\n";
	public static final String STORY_TEXT_USERMANAGER="5.��Ա����\n";
	public static final String STORY_TEXT_EXIT="6.�˳�\n";
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
	public static final String CATALOG_NAME_WUXIA="����";
	public static final String CATALOG_NAME_YANQING="����";
	
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
	
	public static final String OUTPUT_TEXT_READDOWN="�Ķ���������ѡ���ļ���ţ��ϴ�TXT������-1������������0:";
	
	public static final String OUTPUT_DOTTED_ARROW="----->";
	public static final String OUTPUT_ACTION_READ="�Ķ�";
	public static final String OUTPUT_ACTION_REGISTER="ע���û�";
	public static final String OUTPUT_ACTION_USERLOGIN="�û���¼";
	public static final String OUTPUT_ACTION_CURRENT="��ǰ����:";
	
	public static final String OUTPUT_TEXT_SELECTLIST="������ʾ�б�������1������TXT������2:";
	public static final String OUTPUT_TEXT_SELECTRETURN="����������0:";
	public static final String OUTPUT_TEXT_SELECTERROR="ѡ�����������ѡ��:";
	public static final String OUTPUT_INPUT_NAME="������С˵����";
	public static final String OUTPUT_INPUT_AUTHOR="���������ߣ�";
	public static final String OUTPUT_INPUT_DESC="�������飺";
	public static final String OUTPUT_INPUT_PATH="�������ϴ���txt(��ע��·����/����\\\\)��";
	public static final String OUTPUT_TEXT_REUPLOAD="�����ϴ�������1������������0��";
	public static final String OUTPUT_DOWNLOAD_FILENAME="���غ���ļ����ǣ�";
	public static final String OUTPUT_DOWNLOAD_FILEPATH="���غ��·���ǣ�";
	public static final String OUTPUT_DOWNLOAD_RESULT="�ļ����ؽ����";
	public static final String OUTPUT_TEXT_SAVESUCCESS="С˵����ɹ���";
	
	
	public static final String ERROR_CHECK_CONFIGFILE="���������ļ� �Ƿ����:";
	public static final String ERROR_CHECK_SERVERINFO="����Server��������Ϣ!";
	public static final String ERROR_FILE_INPUTERROR="�ļ����벻��ȷ�����������룡";
	public static final String ERROR_TEXT_INPUTERROR="���벻��ȷ�����������룡";
	public static final String ERROR_TEXT_NOTEXIST="ѡ���С˵�����ڣ�";
	public static final String ERROR_TEXT_SERVERNOTEXIST="�������ϵ�С˵�����ڣ�����ϵ����Ա�����������ã�";
	public static final String ERROR_TEXT_TXTEXIST="С˵�Ѿ����ڣ�";
	
	
	
	
	

}
