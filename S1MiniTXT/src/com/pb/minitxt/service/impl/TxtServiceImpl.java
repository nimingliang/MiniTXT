package com.pb.minitxt.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.pb.minitxt.constants.Constants;
import com.pb.minitxt.entity.TxtBook;
import com.pb.minitxt.service.ITxtService;
import com.pb.minitxt.util.ConfigManager;
import com.pb.minitxt.util.FileUtil;
import com.pb.minitxt.util.StringUtil;
import com.pb.minitxt.util.XmlUtil;

public class TxtServiceImpl implements ITxtService{
	/**С˵����ͱ���·����Map                          */
	private static Map<String,String> sort2PathMap = new HashMap<String,String>();
	
	/**С˵����Ͷ�Ӧ����XML�ļ���Map                     */
	private static Map<String,String> sort2XmlNameMap = new HashMap<String,String>();
	
	/**����С˵�����ƺ���Ӧʵ�����Map                    */
	private static Map<String,TxtBook> wuxiaMap = new LinkedHashMap<String,TxtBook>();
	
	/**����С˵�����ƺ���Ӧʵ�����Map                    */
	private static Map<String,TxtBook> yanqingMap = new LinkedHashMap<String,TxtBook>();
	
	/**Key��С˵�������ƣ�value��С˵���ƺ���Ӧʵ�����Map  */
	private static Map<String,Map<String,TxtBook>> sort2TxtMap = new HashMap<String,Map<String,TxtBook>>();
	
	/**�鿴��С˵�б�Map��Key��С˵�б�ţ�value�Ƕ�ӦС˵��ʵ����*/
	private static Map<String,TxtBook> viewBookMap = new HashMap<String,TxtBook>();
	private static ConfigManager config = ConfigManager.getInstance();
	static{
		sort2PathMap.put(Constants.CATALOG_NAME_WUXIA, config.getString(Constants.CATALOG_PATH_WUXIA));
		sort2PathMap.put(Constants.CATALOG_NAME_YANQING, config.getString(Constants.CATALOG_PATH_YANQING));
		sort2XmlNameMap.put(Constants.CATALOG_NAME_WUXIA, Constants.CATALOG_XML_WUXIA);
		sort2XmlNameMap.put(Constants.CATALOG_NAME_YANQING, Constants.CATALOG_XML_YANQING);

		parseXmlBySortName(Constants.CATALOG_NAME_WUXIA,wuxiaMap);
		parseXmlBySortName(Constants.CATALOG_NAME_YANQING,yanqingMap);
		//Key��С˵���࣬Value�ǽ���XML���ɵ�Map����
		sort2TxtMap.put(Constants.CATALOG_NAME_WUXIA, wuxiaMap);
		sort2TxtMap.put(Constants.CATALOG_NAME_YANQING, yanqingMap);
	}
	
	/**
	 * ����XML��������С˵�����Map
	 * @param sortName ��������
	 * @param sortMap  �����Map
	 */
	private static void parseXmlBySortName(String sortName,Map sortMap){
		String xmlFileName = sort2XmlNameMap.get(sortName);
		String xmlConfigFile = Constants.CONFIG_PATH+"/"+xmlFileName;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try{
			db = dbf.newDocumentBuilder();
		}catch(ParserConfigurationException pce){
			pce.printStackTrace();
		}
		Document doc = null;
		try{
			doc = db.parse(xmlConfigFile);
		}catch(Exception e){
			System.out.println(Constants.ERROR_CHECK_CONFIGFILE+xmlConfigFile);
			e.printStackTrace();
		}
		Element root = doc.getDocumentElement();
		NodeList bookList = root.getElementsByTagName("txtbook");
		for( int i = 0; i< bookList.getLength(); i++){
			Element book = (Element)bookList.item(i);
			Element name = (Element)book.getElementsByTagName("name").item(0);
			Element author = (Element)book.getElementsByTagName("author").item(0);
			Element description = (Element)book.getElementsByTagName("description").item(0);
			Element filename = (Element)book.getElementsByTagName("filename").item(0);
			TxtBook txtBook = new TxtBook();
			txtBook.setName(name.getTextContent());
			txtBook.setAuthor(author.getTextContent());
			txtBook.setDescription(description.getTextContent());
			String fileName = filename.getTextContent();
			txtBook.setFileName(fileName);
			String absolutePath = FileUtil.concatPath(sort2PathMap.get(sortName),fileName);
			txtBook.setAbsolutePath(absolutePath);
			sortMap.put(txtBook.getName(), txtBook);
		}	
	}
	
	/**
	 * ����С˵�ķ��࣬��ȡ����������С˵���б�
	 * @param sortName ��������
	 * @return  �����С˵�б�
	 */
	public String getTxtListBySortName(String sortName){
		StringBuffer sb = new StringBuffer("");
		sb.append(Constants.OUTPUT_DOTTED_LINE).append(sortName).append("С˵�б�")
		  .append(Constants.OUTPUT_DOTTED_LINEN);
		sb.append(StringUtil.getFixLengthString("���", 10))
		  .append(StringUtil.getFixLengthString("����", 50))
		  .append(StringUtil.getFixLengthString("����", 50))
		  .append(StringUtil.getFixLengthString("���", 100))
		  .append("\n");
		int i = 1; 
		viewBookMap.clear();
		for(Map.Entry<String, TxtBook> entry:sort2TxtMap.get(sortName).entrySet()){
			TxtBook book = entry.getValue();
			sb.append(StringUtil.getFixLengthString(i+".", 6)).append(book.toDetailInfo()).append("\n");
			viewBookMap.put(i+"", book);
			i++;
		}
		sb.append(Constants.OUTPUT_DOTTED_LINE).append("С˵�б����")
		  .append(Constants.OUTPUT_DOTTED_LINEN);
		return sb.toString();
	}
	
	/**
	 * ����ѡ���С˵��ŷ��ض�Ӧ������
	 * @param iSequence ѡ���С˵���
	 * @return ���ض�Ӧѡ��С˵������
	 */
	public String getTxtContentBySequence(int iSequence){
		StringBuffer sb = new StringBuffer("");
		TxtBook txtBook = viewBookMap.get(iSequence+"");
		if (txtBook != null){
			sb.append(Constants.OUTPUT_ACTION_CURRENT).append(Constants.OUTPUT_ACTION_READ)
			  .append(txtBook.getName()).append("\n");
			String strContent = FileUtil.readFileContent(txtBook.getAbsolutePath());		
			sb.append(strContent);
		}else{
			sb.append(Constants.ERROR_TEXT_NOTEXIST);
		}
		return sb.toString();
	}
	
	/**
	 * ������Ż�ȡС˵��·��
	 * @param iSequence ѡ�е�С˵���
	 * @return С˵��·��
	 */
	public String getTxtFilePath(int iSequence){
		TxtBook txtBook = viewBookMap.get(iSequence+"");
		String strFilePath = "";
		if (txtBook != null){
			strFilePath = txtBook.getAbsolutePath();
		}
		return strFilePath;
	}
	
	/**
	 * ���ļ������ڿͻ���
	 * @param fileName:������ļ���
	 * @param strFileContent��������ļ�����
	 * @return �����ļ��Ľ��true or false
	 */
	public boolean saveFileToClient(String fileName,String strFileContent){
		boolean bRet = false;
		String downloadpath = config.getString(Constants.CLIENT_DOWNLOAD_PATH);
		boolean bCheck = FileUtil.checkPath(downloadpath);
		if (bCheck){
			String outFile = FileUtil.concatPath(downloadpath, fileName);
			bRet = FileUtil.writeFileUTF8(outFile, strFileContent);
		}else{
			System.out.println("�޷���������Ŀ¼:"+downloadpath+"!���޸������ļ���");
		}
		return bRet;
	}
	
	/**
	 * �ж�С˵�Ƿ��ڷ������ϴ���
	 */
	public boolean checkBookExist(TxtBook txtBook){
		boolean bExist = false;
		String strSortName = txtBook.getSortName();
		Map<String,TxtBook> txtMap = sort2TxtMap.get(strSortName);
		String txtName = txtBook.getName();
		if (txtMap.get(txtName) != null){
			bExist = true;
		}
		return bExist;
	}
	
	/**
	 * ���ļ����ݱ����ڷ�������
	 */
	public boolean saveFileToServer(TxtBook txtBook,String strFileContent){
		boolean bAdd = addTxtBookToXml(txtBook);
		String absolutePath = FileUtil.concatPath(sort2PathMap.get(txtBook.getSortName()),txtBook.getFileName());
		boolean bSave = FileUtil.writeFile(absolutePath, strFileContent);
		if (bSave){
			sort2TxtMap.get(txtBook.getSortName()).put(txtBook.getName(), txtBook);
		}
		return bAdd & bSave;
		
	}
	
	/**
	 * ���ϴ���С˵����Ϣ���浽�����ϵ������ļ���
	 * @param txtBook  
	 * @return ������ true or false
	 */
	private boolean addTxtBookToXml(TxtBook txtBook){
		String xmlFileName = sort2XmlNameMap.get(txtBook.getSortName());
		String xmlConfigFile = Constants.CONFIG_PATH+"/"+xmlFileName;
		File file = new File(xmlConfigFile);
		String strContent = "";
		boolean bRet = true;
		XmlUtil xmlUtil = new XmlUtil();
		if (file.exists()){
			String strXML = FileUtil.readFileContent(xmlConfigFile);
			String xmlTail = Constants.XML_WUXIA_TAIL;
			if (txtBook.getSortName().equals(Constants.CATALOG_NAME_YANQING)){
				xmlTail = Constants.XML_YANQING_TAIL;
			}
			int iIndex = strXML.indexOf(xmlTail);
			if (iIndex > -1){
				StringBuffer sb = new StringBuffer(strXML.substring(0,iIndex))
				.append(txtBook.toString()).append(strXML.substring(iIndex));
				strContent = sb.toString();	
			}
		}else{
			
		}
		bRet = xmlUtil.createXML(xmlConfigFile, strContent);
		return bRet;
		
		
		
	}
	public static void main(String args[]){
		TxtServiceImpl txtService = new TxtServiceImpl();
		txtService.getTxtListBySortName(Constants.CATALOG_NAME_WUXIA);
		txtService.getTxtListBySortName(Constants.CATALOG_NAME_YANQING);
	}
}
