package com.pb.minitxt.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * 文件操作的公共类
 * 
 * @author BDQN
 * 
 */
public class FileUtil {

	public static boolean rename(String sourceFileName, String desFileName) {
		File sourceFile = new File(sourceFileName);
		File desFile = new File(desFileName);
		boolean bRet = false;
		try {
			if (desFile.exists())
				desFile.delete();
			bRet = sourceFile.renameTo(desFile);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sourceFileName rename false");
		}
		return bRet;
	}

	public static String concatPath(String strPath, String strSubPath) {
		if (strPath.endsWith(File.separator) || strPath.endsWith("/")) {
			return strPath + strSubPath;
		} else {
			return strPath + File.separator + strSubPath;
		}
	}

	// check dir ,if not exist create it
	public static boolean checkPath(String strPath) {
		boolean bRet = true;
		if (strPath == null || strPath.trim().equals("")) {
			return false;
		}
		strPath = StringUtil.replaceAllStr(strPath, "\\", "/");
		File folder = new File(strPath);
		if (!folder.isDirectory()) {
			folder.mkdirs();
		}
		return bRet;
	}

	public static String getFileName(String strPath) {
		String strFileName = "";
		if (strPath == null || strPath.trim().equals("")) {
			return strFileName;
		}
		strPath = StringUtil.replaceAllStr(strPath, "\\", "/");
		File file = new File(strPath);
		if (file.exists()) {
			strFileName = file.getName();
		}
		return strFileName;
	}

	public static boolean writeFile(String outFile, String strContent) {
		boolean bRet = false;
		try {
			File file = new File(outFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			if (!file.canWrite()) {
				// file.
			}
			FileWriter fw = new FileWriter(outFile);
			fw.write(strContent);
			fw.close();
			bRet = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bRet;
	}

	public static boolean writeFileUTF8(String outFile, String strContent) {
		boolean bRet = false;
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(outFile), "UTF-8");
			out.write(strContent);
			out.flush();
			out.close();
			bRet = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bRet;

	}

	public static String readFileContent(String fileName) {
		StringBuffer sb = new StringBuffer("");
		try {
			File file = new File(fileName);
			// InputStreamReader read = new InputStreamReader (new
			// FileInputStream(file),"UTF-8");
			// InputStreamReader read = new InputStreamReader (new
			// FileInputStream(file));
			// UnicodeReader解决TXT文件读出时有一个乱码的问题
			UnicodeReader read = new UnicodeReader(new FileInputStream(file),
					"UTF-8");
			BufferedReader in = new BufferedReader(read);
			String str = "";
			while ((str = in.readLine()) != null) {
				sb.append(str).append("\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = FileUtil
				.readFileContent("E:\\workproject\\unitone\\S1MiniTXT\\txtcatalog\\wuxia\\shediaoyingxiongzhuan.txt");
		System.out.println("txt:" + str);
	}

}
