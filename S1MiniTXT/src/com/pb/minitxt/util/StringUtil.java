package com.pb.minitxt.util;

import java.io.UnsupportedEncodingException;

public class StringUtil {
	
	/**
	 * Ìæ»»×Ö·û´®
	 * @param strOrg Ô´×Ö·û´®
	 * @param strOld ÒªÌæ»»µÄ×Ö·û´®
	 * @param strNew Ìæ»»ºóµÄ×Ö·û´®
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
	 * ×Ö·û´®Ìî³ä¹Ì¶¨×Ö·û
	 * @param src         Ô´×Ö·û´®
	 * @param padChar     Ìî³äµÄ×Ö·û
	 * @param rightPad    ÊÇ·ñÓÒÌî³ä
	 * @param totalLength ×Ö·û´®×Ü³¤¶È
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
	 * »ñÈ¡¹Ì¶¨³¤¶ÈµÄ×Ö·û´®
	 * @param str    Ô´×Ö·û´®
	 * @param length ¹Ì¶¨µÄ³¤¶È
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
	 * »ñÈ¡×Ö·û´®µÄ³¤¶È£¬ºº×Ö°´2¸ö×Ö½Ú¼ÆËã
	 * @param input    ¼ÆËãµÄ×Ö·û´®
	 * @return         ×Ö·û´®µÄ³¤¶È
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
