package com.pb.minitxt.util;

import java.io.UnsupportedEncodingException;

public class StringUtil {
	
	/**
	 * �滻�ַ���
	 * @param strOrg Դ�ַ���
	 * @param strOld Ҫ�滻���ַ���
	 * @param strNew �滻����ַ���
	 * @return
	 */
	public static String replaceAllStr(String strOrg, String strOld,
			String strNew) {
		// replace "\\" of "/"
		String strAfter = "";
		int pos = strOrg.indexOf(strOld);
		while (pos > 0) {
			String leftStr = strOrg.substring(0, pos);
			strOrg = strOrg.substring(pos + 1);
			if (strAfter.trim().length() > 0)
				strAfter += strNew;
			strAfter += leftStr;
			pos = strOrg.indexOf(strOld);
		}
		if (strOrg.trim().length() > 0) {
			if (strAfter.trim().length() > 0)
				strAfter += strNew;
			strAfter += strOrg;
		}
		return strAfter;

	}

	/**
	 * �ַ������̶��ַ�
	 * @param src         Դ�ַ���
	 * @param padChar     �����ַ�
	 * @param rightPad    �Ƿ������
	 * @param totalLength �ַ����ܳ���
	 * @return
	 */
	public static String pad(String src, char padChar, boolean rightPad,
			int totalLength) {

		int srcLength = src.length();
		if (srcLength >= totalLength) {
			return src;
		}

		int padLength = totalLength - srcLength;
		StringBuffer sb = new StringBuffer(padLength);
		for (int i = 0; i < padLength; ++i) {
			sb.append(padChar);
		}

		if (rightPad) {
			return src + sb.toString();
		} else {
			return sb.toString() + src;
		}
	}
	
	/**
	 * ��ȡ�̶����ȵ��ַ���
	 * @param str    Դ�ַ���
	 * @param length �̶��ĳ���
	 * @return
	 */
	public static String getFixLengthString(String str, int length){
		if ((str == null) || (str.trim().length() < 0))
			return getBlankString(length);
		String reStr = "";
//
//		str = str.replaceAll("\r", "");
//		str = str.replaceAll("\n", "");
		try {
			str = new String(str.getBytes(), "8859_1");
			if (str.length() >= length)
				reStr = str.substring(0, length);
			else {
				reStr = str + getBlankString(length - str.length());
			}

			byte[] bytesStr = reStr.getBytes("8859_1");
			reStr = new String(bytesStr, "gb2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reStr;
	}
	public static String getBlankString(int count) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < count; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
	
	/**
	 * ��ȡ�ַ����ĳ��ȣ����ְ�2���ֽڼ���
	 * @param input    ������ַ���
	 * @return         �ַ����ĳ���
	 */
	public static int getLength(String input) {
        int length = 0;
        if (input != null) {
            for (int i = 0; i < input.length(); i++) {
                int c = input.charAt(i);
                if (c < 255) {
                    length += 1;
                }
                else {
                    length += 2;
                }
            }
        }
        return length;
  }

}
