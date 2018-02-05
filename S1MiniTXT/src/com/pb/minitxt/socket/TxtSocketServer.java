package com.pb.minitxt.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import com.pb.minitxt.constants.Constants;
import com.pb.minitxt.entity.TxtBook;
import com.pb.minitxt.entity.User;
import com.pb.minitxt.service.ITxtService;
import com.pb.minitxt.service.IUserService;
import com.pb.minitxt.service.ServiceFactory;
import com.pb.minitxt.util.FileUtil;

public class TxtSocketServer implements Runnable{
	private Socket clientSocket = null;
	private BufferedInputStream bis = null;
	private BufferedOutputStream bos = null;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private ObjectInputStream ois= null;
	private ObjectOutputStream oos = null;
	private IUserService userService = ServiceFactory.getUserService();
	private ITxtService txtService = ServiceFactory.getTxtService();
	
	public TxtSocketServer(Socket clientSocket){
		this.clientSocket =clientSocket;
		
	}
	public void run() {		
		try {
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			ois = new ObjectInputStream(clientSocket.getInputStream());
			GenericCommand objCommand = null;
			try {
				//接收序列化对象
				objCommand = (GenericCommand)ois.readObject();
				objCommand = executeCommand(objCommand);
				oos.writeObject(objCommand);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 执行客户端发送给服务器端的命令
	 * @param gCommand
	 * @return        将执行结果放入到GenericCommand返回给客户端
	 */
	private GenericCommand executeCommand(GenericCommand gCommand){
		String result = null;
		String strCommand = gCommand.getCommand();
		System.out.println("command is:"+gCommand.getCommand());
		//处理登录
		if (strCommand.equals(Constants.COMMAND_LOGIN)){
			User user = (User)gCommand.getDataObject();
			boolean bCan = userService.canLogin(user);
			gCommand.setSuccess(bCan);
			if (bCan){
				gCommand.setResultInfo(Constants.OUTPUT_TEXT_LOGINSUCCESS);
			}else{
				gCommand.setResultInfo(Constants.OUTPUT_TEXT_LOGINFAIL);
			}
		}else if(strCommand.equals(Constants.COMMAND_REGISTERUSER)){
			//注册用户
			gCommand = registerUser(gCommand);
		}else if(strCommand.equals(Constants.COMMAND_SHOWTXTLIST)){
			//按TXT分类查看列表
			gCommand = getTxtListBySort(gCommand);
		}else if(strCommand.equals(Constants.COMMAND_READTXT)){
			//读取TXT文件的内容
			gCommand = getTxtFileContent(gCommand);
		}else if(strCommand.equals(Constants.COMMAND_DOWNLOADTXT)){
			//下载TXT文件
			gCommand = downloadTxt(gCommand);
		}else if(strCommand.equals(Constants.COMMAND_UPLOADTXT)){
			//上传TXT文件
			gCommand = uploadTxt(gCommand);
		}
		return gCommand;
	}
    /**
     * 解析用户对象，并注册
     * @param gCommand
     * @return
     */
	private GenericCommand registerUser(GenericCommand gCommand){
		User user = (User)gCommand.getDataObject();
		boolean isExist = userService.isExist(user.getUserName());
		if (isExist){
			gCommand.setResultInfo(Constants.OUTPUT_TEXT_USEREXIST);
			gCommand.setSuccess(false);
			return gCommand;
		}
		boolean bSave = userService.saveUser(user);
		gCommand.setSuccess(bSave);
		if (bSave){
			gCommand.setResultInfo(Constants.OUTPUT_USER_SAVESUCESS);
		}else{
			gCommand.setResultInfo(Constants.OUTPUT_USER_SAVEFAIL);
		}
		return gCommand;
	}
	
	/**
	 * 根据小说分类得到列表
	 * @param gCommand
	 * @return
	 */
	private GenericCommand getTxtListBySort(GenericCommand gCommand){
		TxtBook txtBook = (TxtBook)gCommand.getDataObject();
		String sortName = txtBook.getSortName();
		gCommand.setResultInfo(txtService.getTxtListBySortName(sortName));
		return gCommand;
	}
	
	/**
	 * 读取TXT文件内容
	 * @param gCommand
	 * @return
	 */
	private GenericCommand getTxtFileContent(GenericCommand gCommand){
		TxtBook txtBook = (TxtBook)gCommand.getDataObject();
		String sortName = txtBook.getSortName();
		int iSequence = txtBook.getISequence();
		gCommand.setResultInfo(txtService.getTxtContentBySequence(iSequence));
		return gCommand;
	}
	
	/**
	 * 下载TXT，根据客户端发过来的文件序号，下载对应文件
	 * @param gCommand
	 * @return
	 */
	private GenericCommand downloadTxt(GenericCommand gCommand){
		Map txtFileMap = (Map)gCommand.getDataObject();
		int iSequence = Integer.parseInt((String)txtFileMap.get("txtNumber"));
		String strFilePath = txtService.getTxtFilePath(iSequence);
		if (!strFilePath.equals("")){
			File file = new File(strFilePath);
			if (file.exists()){
				txtFileMap.put("fileName", file.getName());
				txtFileMap.put("fileLength", file.length());
				boolean bDown = downloadFile(strFilePath);
				gCommand.setSuccess(bDown);
			}else{
				gCommand.setResultInfo(Constants.ERROR_TEXT_SERVERNOTEXIST);
				gCommand.setSuccess(false);
			}
		}else{
			gCommand.setResultInfo(Constants.ERROR_TEXT_NOTEXIST);
			gCommand.setSuccess(false);
		}
		return gCommand;
	}
	
	/**
	 * 接受客户端发送过来的TXT文件
	 * @param gCommand
	 * @return
	 */
	private GenericCommand uploadTxt(GenericCommand gCommand){
		TxtBook txtBook = (TxtBook)gCommand.getDataObject();
		if (txtService.checkBookExist(txtBook)){
			gCommand.setResultInfo(Constants.ERROR_TEXT_TXTEXIST);
		}else{
			boolean bSave = txtService.saveFileToServer(txtBook,gCommand.getResultInfo());
			if (bSave){
				gCommand.setResultInfo(Constants.OUTPUT_TEXT_SAVESUCCESS);
			}
		}
		return gCommand;
	}
	/**
	 * 下载文件，向客户端输出文件流
	 * @param strFilePath
	 * @return
	 */
	public boolean downloadFile(String strFilePath){
		boolean bDownload = false;
		try {
			byte[] buf = new byte[1024];
			File file = new File(strFilePath);
			BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
			int len;
			while((len=fis.read(buf)) != -1){
				oos.write(buf,0,len);
				oos.flush();
			}
			fis.close();
			bDownload = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bDownload;
		}
}
