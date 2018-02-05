package com.pb.minitxt.socket;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.pb.minitxt.constants.Constants;
import com.pb.minitxt.entity.TxtBook;
import com.pb.minitxt.entity.User;
import com.pb.minitxt.service.ISocketService;
import com.pb.minitxt.service.ITxtService;
import com.pb.minitxt.service.IUserService;
import com.pb.minitxt.service.ServiceFactory;
import com.pb.minitxt.util.ConfigManager;
import com.pb.minitxt.util.FileUtil;
import com.pb.minitxt.util.StringUtil;

public class TxtSocketClient{
	private IUserService userService = ServiceFactory.getUserService();
	private ISocketService socketService = ServiceFactory.getSocketService();
	private ITxtService txtService = ServiceFactory.getTxtService();
	private Socket clientSocket = null;
	private String loginUserName="";
	private String actionName = "";
	
	/**
	 * ��ʾ��ʼ���˵�
	 */
	public void showStartMenu(){
		System.out.print(Constants.MENU_START.toString());
		boolean bContinue = true;
		while (bContinue){
			Scanner input = new Scanner(System.in);
		   	int choice = getChoice(input);
		   	bContinue = false;
		   	switch(choice){
		   	 	case 1:
		   	    	showLoginWindow();
		   	    	break;
		   	    case 2: 
		   	    	showRegisterWindow();
		   	    	break;
		   	    case 3:
		   	    	printMessage(Constants.OUTPUT_TEXT_THANK);
		   	    	System.exit(0);
		   	    	break;
		   	    default:
		   	    	errorSelect(Constants.OUTPUT_TEXT_SELECTERROR);
		   	    	bContinue = true;
		   	    	break;
		   	 }
		}
				
	}
	/**
	 * ��ʾ��¼����
	 */
	public void showLoginWindow(){
		boolean bContinue = true;
		int i = 0;
		String userName = "";
		while(bContinue){
			showActionInfo(Constants.OUTPUT_ACTION_USERLOGIN);
			printMessage(Constants.OUTPUT_TEXT_USERNAMEE);
			Scanner input = new Scanner(System.in);
			userName = input.next();
			printMessage(Constants.OUTPUT_TEXT_PASSWORD);
			String password = input.next();
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			GenericCommand<User> gCommand = new GenericCommand<User>(user);
			gCommand.setCommand(Constants.COMMAND_LOGIN);
			if (getConnected()){
				sendOutputObject(gCommand);
				gCommand = getInputObject();
				
				showResult(gCommand.getResultInfo());
				if (gCommand.isSuccess()){
					bContinue = false;
				}
				closeClient();
			}else{
				bContinue = false;
				printMessage(Constants.ERROR_CHECK_SERVERINFO);
				System.exit(0);
			}
		}
		loginUserName = userName;
		showTxtSortWindow();
		
	}
	
	/**
	 * �û�ע�ᴰ��
	 */
	public void showRegisterWindow(){
		boolean bContinue = true;
		String userName = "";
		String password = "";
		while (bContinue){
			showActionInfo(Constants.OUTPUT_ACTION_REGISTER);
			bContinue = false;
			printMessage(Constants.OUTPUT_TEXT_USERNAMEE);
			Scanner input = new Scanner(System.in);
			userName = input.next();
			printMessage(Constants.OUTPUT_TEXT_PASSWORD);
			password = input.next();
			printMessage(Constants.OUTPUT_TEXT_PASSWORD2);
			String password2 = input.next();
			if (!password.equals(password2)){
				showResult(Constants.OUTPUT_TEXT_PASSWORDNOTEQUAL);
				bContinue = true;
			}
		}
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setRole(Constants.USER_NORMAL_FLAG);
		GenericCommand<User> gCommand = new GenericCommand<User>(user);
		gCommand.setCommand(Constants.COMMAND_REGISTERUSER);
		gCommand = getCommandResultFromServer(gCommand);
		showResult(gCommand.getResultInfo());
		if (gCommand.isSuccess()){
			showLoginWindow();
		}else{
			showRegisterWindow();
		}
	}
	
	/**
	 * ��ʾС˵����Ĵ���
	 */
	public void showTxtSortWindow(){
		printMessage(Constants.MENU_TEXT_SORT.toString());
	   	String strSortName = "";
	   	boolean bContinue = true;
	   	while (bContinue){
	   		bContinue = false;
	   		Scanner input = new Scanner(System.in);
		   	int choice = getChoice(input);
		   	switch(choice){
		   		case 0:
		   			showStartMenu();
		   			break;
		   	 	case 1:
		   	 		strSortName = Constants.CATALOG_NAME_WUXIA;
		   	 		break;
		   	    case 2: 
		   	    	strSortName = Constants.CATALOG_NAME_YANQING;
		   	    	break;
		   	    default:
		   	    	errorSelect(Constants.OUTPUT_TEXT_SELECTERROR);
		   	    	bContinue = true;
		   	    	break;
		   	}
	   	}
	   	showTxtListBySort(strSortName);
	}
	
	/**
	 * ��С˵������ʾ�б�
	 * @param strSortName  ��������
	 */
	public void showTxtListBySort(String strSortName){
		TxtBook txtBook = new TxtBook();
		txtBook.setSortName(strSortName);
		String strCommand = Constants.COMMAND_SHOWTXTLIST;
		GenericCommand<TxtBook> gCommand = new GenericCommand<TxtBook>(txtBook);
		gCommand.setCommand(strCommand);
		gCommand = getCommandResultFromServer(gCommand);
		printMessage(gCommand.getResultInfo());
		printMessage(Constants.OUTPUT_TEXT_READDOWN);
	   	boolean bContinue = true;
	   	while(bContinue){
	   		bContinue = false;
	   		Scanner input = new Scanner(System.in);
		   	int choice = getChoice(input);
		   	switch(choice){
		   		case -1:
		   			showTxtUploadWindow(strSortName);
	   	    	break;
		   		case 0:
		   			showTxtSortWindow();
		   	    	break;
		   		case -999:
		   			errorSelect(Constants.OUTPUT_TEXT_SELECTERROR);
		   	    	bContinue = true;
		   	    	break;
		   		default:
		   			showFunctionMenu(strSortName,choice);
		   	    	break;
		   	}
	   	}
	}
	
	/**
	 * �ϴ�С˵����
	 * @param strSortName  С˵����
	 */
	private void showTxtUploadWindow(String strSortName){
		String txtName = "";
		String txtAuthor = "";
		String txtDescription = "";
		Scanner input = new Scanner(System.in);
		printMessage(Constants.OUTPUT_INPUT_NAME);
		txtName = input.next();
		printMessage(Constants.OUTPUT_INPUT_AUTHOR);
		txtAuthor = input.next();
		printMessage(Constants.OUTPUT_INPUT_DESC);
		txtDescription = input.next();
		printMessage(Constants.OUTPUT_INPUT_PATH);
		boolean bRepeat = true;
		String filePath = "";
		String strCommand = Constants.COMMAND_UPLOADTXT;
		TxtBook txtBook = new TxtBook();
		while(bRepeat){
			filePath = input.next();
			String strFileName = FileUtil.getFileName(filePath);
			if (strFileName.equals("")){
				printMessage(Constants.ERROR_FILE_INPUTERROR);
			}else{
				bRepeat = false;
				txtBook.setFileName(strFileName);
			}
		}
		
		txtBook.setName(txtName);
		txtBook.setAuthor(txtAuthor);
		txtBook.setDescription(txtDescription);
		txtBook.setSortName(strSortName);
		String resultInfo = FileUtil.readFileContent(filePath);
		GenericCommand<TxtBook> gCommand = new GenericCommand<TxtBook>(txtBook);
		gCommand.setCommand(strCommand);
		gCommand.setResultInfo(resultInfo);
		gCommand = getCommandResultFromServer(gCommand);
		showResult(gCommand.getResultInfo());
		printMessage(Constants.OUTPUT_TEXT_REUPLOAD);
		boolean bContinue = true;
		while (bContinue){
			bContinue = false;
			Scanner inputNumber = new Scanner(System.in);
		   	int choice = getChoice(inputNumber);
		   	switch(choice){
		   		case 0:
		   			showTxtSortWindow();
		   	    	break;
		   		case 1:
		   			showTxtUploadWindow(strSortName);
		   			break;
		   		default:
		   			errorSelect(Constants.ERROR_TEXT_INPUTERROR);
		   			bContinue = true;
		   			break;
		   	}
		}
	}
	
	/**
	 * ��ʾС˵�Ķ������ز˵�
	 * @param strSortName    С˵����
	 * @param iTxtChoice     ѡ���С˵���
	 */
	private void showFunctionMenu(String strSortName,int iTxtChoice){
		printMessage(Constants.MENU_FUNCTION.toString());
		printMessage(Constants.OUTPUT_SIGN_SELECT);
		boolean bContinue = true;
		while (bContinue){
			bContinue = false;
			Scanner input = new Scanner(System.in);
		   	int choice = getChoice(input);
		   	switch(choice){
		   		case 0:
		   			showTxtListBySort(strSortName);
		   	    	break;
		   		case 1:
		   			readSelectedTxt(strSortName,iTxtChoice);
		   	    	break;
		   		case 2:
		   			downloadSelectedTxt(strSortName,iTxtChoice);
		   	    	break;
		   	    default:
		   	    	errorSelect(Constants.ERROR_TEXT_INPUTERROR);
		   	        bContinue = true;
		   	    	break;
		   	}
		}
	}
	
	/**
	 * �Ķ�ѡ���С˵
	 * @param strSortName   С˵�ķ���
	 * @param iTxtChoice    ѡ���С˵���
	 */
	private void readSelectedTxt(String strSortName,int iTxtChoice){
		TxtBook txtBook = new TxtBook();
		txtBook.setISequence(iTxtChoice);
		txtBook.setSortName(strSortName);
		String strCommand = Constants.COMMAND_READTXT;
		GenericCommand<TxtBook> gCommand = new GenericCommand<TxtBook>(txtBook);
		gCommand.setCommand(strCommand);
		gCommand = getCommandResultFromServer(gCommand);
		String fileContent = gCommand.getResultInfo();
		fileContent = StringUtil.getFixLengthString(gCommand.getResultInfo(), 500);
		fileContent =fileContent+"\n......,ʡ�����ݣ������غ��Ķ�";
		showResult(fileContent);
		printMessage(Constants.OUTPUT_TEXT_SELECTLIST);
		boolean bContinue = true;
		while (bContinue){
			bContinue = false;
			Scanner input = new Scanner(System.in);
		   	int choice = input.nextInt();
		   	switch(choice){
		   		case 1:
		   			showTxtListBySort(strSortName);;
		   	    	break;
		   		case 2:
		   			downloadSelectedTxt(strSortName,iTxtChoice);
		   	    	break;
		   	    default:
		   	    	errorSelect(Constants.OUTPUT_TEXT_SELECTERROR);
		   	        bContinue = true;
		   	    	break;
		   	}
		}

	}
	
	/**
	 * ����������ѡ�е�С˵
	 * @param strSortName  С˵�ķ���
	 * @param iTxtChoice   ѡ�е�С˵���
	 */
	public void downloadSelectedTxt(String strSortName,int iTxtChoice){
	   	String strCommand = Constants.COMMAND_DOWNLOADTXT;
	   	Map txtFileMap = new HashMap();
	   	txtFileMap.put("txtNumber", iTxtChoice+"");
		GenericCommand<Map> gCommand = new GenericCommand<Map>(txtFileMap);
		gCommand.setCommand(strCommand);
//		gCommand = getCommandResultFromServer(gCommand);
		getConnected();
		sendOutputObject(gCommand);
		ObjectInputStream clientInputStream = null;
		//���غ���������һ����ʱ�ļ�
		String fileNameTemp = "tempstory.txt";
		String downloadPath = ConfigManager.getInstance().getString(Constants.CLIENT_DOWNLOAD_PATH);
		try {
			clientInputStream = new ObjectInputStream(clientSocket.getInputStream());
			File fileTemp = new File(downloadPath+"/"+fileNameTemp);	
			if (fileTemp.exists()){
				fileTemp.delete();
			}
			fileTemp.createNewFile();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(fileTemp));
			//���շ��������ļ�
			byte[] buf = new byte[1024];
			int len;
			while((len = clientInputStream.read(buf)) != -1){
				fos.write(buf, 0, len);
				fos.flush();
			}
			fos.close();
			gCommand = (GenericCommand)clientInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (gCommand.isSuccess()){
			txtFileMap = gCommand.getDataObject();
			String fileName = (String)txtFileMap.get("fileName");
			printMessage(Constants.OUTPUT_ASTERISKLINE);
			printMessageLN(Constants.OUTPUT_DOWNLOAD_FILENAME+fileName);
			printMessageLN(Constants.OUTPUT_DOWNLOAD_FILEPATH+downloadPath);
			boolean bRet = FileUtil.rename(downloadPath+"/"+fileNameTemp, downloadPath+"/"+fileName);
//			boolean bRet = txtService.saveFileToClient(fileName, gCommand.getResultInfo());
			printMessageLN(Constants.OUTPUT_DOWNLOAD_RESULT+bRet);
			printMessage(Constants.OUTPUT_ASTERISKLINE);
		}else{
			showResult(gCommand.getResultInfo());
		}
		closeClient();
		printMessage(Constants.OUTPUT_TEXT_SELECTRETURN);
		boolean bContinue = true;
		while (bContinue){
			bContinue = false;
			Scanner input = new Scanner(System.in);
		   	int choice = getChoice(input);
		   	switch(choice){
		   		case 0:
		   			showTxtListBySort(strSortName);
		   	    	break;
		   	    default:
		   	    	errorSelect(Constants.ERROR_TEXT_INPUTERROR);
		   	        bContinue = true;
		   	    	break;
		   	}
		}
	}
	
	public void printMessage(String message){
		System.out.print(message);
	}
	
	/**
	 * ��ʾ�����Ϣ��������*���и���
	 * @param result �����Ϣ
	 */
	public void showResult(String result){
		System.out.println(Constants.OUTPUT_SIGN_ASTERISK);
		System.out.println(result);
		System.out.println(Constants.OUTPUT_SIGN_ASTERISK);
	}
	
	/**
	 * ��ʾ��ǰ������Ϣ
	 * @param action
	 */
	public void showActionInfo(String action){
		System.out.println(Constants.OUTPUT_SIGN_WAVELINE);
		System.out.println(Constants.OUTPUT_ACTION_CURRENT+action);
		System.out.println(Constants.OUTPUT_SIGN_WAVELINE);
	}
	public void printMessageLN(String message){
		System.out.println(message);
	}
	public void errorSelect(String message){
		System.out.print(message);
	}
	public int getChoice(Scanner input){
		int choice = -999;
		try{
			choice = input.nextInt();
		}catch(Exception e){
			//e.printStackTrace();	
		}
		return choice;
	}
	/**
	 * ��ȡSocket����
	 * @return ���ӽ��True OR False;
	 */
	public boolean getConnected(){
		boolean bGet = false;
		String ip = ConfigManager.getInstance().getString(Constants.SCOKET_SERVER_IP);
		int port =  ConfigManager.getInstance().getInt(Constants.SCOKET_SERVER_PORT,"5678");
		try {
			clientSocket = socketService.getClientSocket(ip, port);
			bGet = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bGet;
		
	}
	public void closeClient(){
		try {
			clientSocket.shutdownInput();
			clientSocket.shutdownOutput();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("client�ر�ʧ�ܣ�");
			e.printStackTrace();
		}		
	}
	/**
	 * ����������͵�������
	 * @param genericCommand  ���β���������
	 */
	public void sendOutputObject(GenericCommand genericCommand){
		ObjectOutputStream clientOS = null;
		try {
			clientOS = new ObjectOutputStream(clientSocket.getOutputStream());
			clientOS.writeObject(genericCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ��ȡ�ӷ������ش�������
	 * @return GenericCommand
	 */
	public GenericCommand getInputObject(){
		ObjectInputStream clientInputStream = null;
		GenericCommand gCommand = null;
		try {
			clientInputStream = new ObjectInputStream(clientSocket.getInputStream());
			try {
				gCommand = (GenericCommand)clientInputStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gCommand;
		
	}
	/**
	 * ����������񲢽��շ������
	 * @param gCommand 
	 * @return GenericCommand
	 */
	public GenericCommand getCommandResultFromServer(GenericCommand gCommand){
		if (getConnected()){
			sendOutputObject(gCommand);
			gCommand = getInputObject();
			closeClient();
		}else{
			gCommand.setSuccess(false);
		}
		return gCommand;
		
	}
}
