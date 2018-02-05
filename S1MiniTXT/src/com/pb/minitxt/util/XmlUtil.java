package com.pb.minitxt.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class XmlUtil {
	/**
	 * ±£´æXMLÎÄ¼þ
	 * @param filePath
	 * @param strContent
	 * @return
	 */
	public boolean createXML(String filePath, String strContent) {
		boolean bRet = false;
		Writer fw = null;
		try {
			fw=new OutputStreamWriter(new FileOutputStream(filePath),"UTF-8");
			fw.write(strContent);
			bRet = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bRet;
	}

}
