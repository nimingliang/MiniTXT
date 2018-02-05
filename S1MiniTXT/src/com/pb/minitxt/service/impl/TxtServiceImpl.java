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
	/**小说分类和保存路径的Map                          */
	private static Map<String,String> sort2PathMap = new HashMap<String,String>();
	
	/**小说分类和对应配置XML文件的Map                     */
	private static Map<String,String> sort2XmlNameMap = new HashMap<String,String>();
	
	/**武侠小说的名称和相应实体类的Map                    */
	private static Map<String,TxtBook> wuxiaMap = new LinkedHashMap<String,TxtBook>();
	
	/**言情小说的名称和相应实体类的Map                    */
	private static Map<String,TxtBook> yanqingMap = new LinkedHashMap<String,TxtBook>();
	
	/**Key是小说分类名称，value是小说名称和相应实体类的Map  */
	private static Map<String,Map<String,TxtBook>> sort2TxtMap = new HashMap<String,Map<String,TxtBook>>();
	
	/**查看的小说列表Map，Key是小说列表号，value是对应小说的实体类*/
	private static Map<String,TxtBook> viewBookMap = new HashMap<String,TxtBook>();
	private static ConfigManager config = ConfigManager.getInstance();
	static{
		sort2PathMap.put(Constants.CATALOG_NAME_WUXIA, config.getString(Constants.CATALOG_PATH_WUXIA));
		sort2PathMap.put(Constants.CATALOG_NAME_YANQING, config.getString(Constants.CATALOG_PATH_YANQING));
		sort2XmlNameMap.put(Constants.CATALOG_NAME_WUXIA, Constants.CATALOG_XML_WUXIA);
		sort2XmlNameMap.put(Constants.CATALOG_NAME_YANQING, Constants.CATALOG_XML_YANQING);

		parseXmlBySortName(Constants.CATALOG_NAME_WUXIA,wuxiaMap);
		parseXmlBySortName(Constants.CATALOG_NAME_YANQING,yanqingMap);
		//Key是小说分类，Value是解析XML生成的Map对象
		sort2TxtMap.put(Constants.CATALOG_NAME_WUXIA, wuxiaMap);
		sort2TxtMap.put(Constants.CATALOG_NAME_YANQING, yanqingMap);
	}
	
	/**
	 * 解析XML，并生成小说分类的Map
	 * @param sortName 分类名称
	 * @param sortMap  分类的Map
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
	 * 根据小说的分类，获取分类下所有小说的列表
	 * @param sortName 分类名称
	 * @return  分类的小说列表
	 */
	public String getTxtListBySortName(String sortName){
		StringBuffer sb = new StringBuffer("");
		sb.append(Constants.OUTPUT_DOTTED_LINE).append(sortName).append("小说列表")
		  .append(Constants.OUTPUT_DOTTED_LINEN);
		sb.append(StringUtil.getFixLengthString("序号", 10))
		  .append(StringUtil.getFixLengthString("名称", 50))
		  .append(StringUtil.getFixLengthString("作者", 50))
		  .append(StringUtil.getFixLengthString("简介", 100))
		  .append("\n");
		int i = 1; 
		viewBookMap.clear();
		for(Map.Entry<String, TxtBook> entry:sort2TxtMap.get(sortName).entrySet()){
			TxtBook book = entry.getValue();
			sb.append(StringUtil.getFixLengthString(i+".", 6)).append(book.toDetailInfo()).append("\n");
			viewBookMap.put(i+"", book);
			i++;
		}
		sb.append(Constants.OUTPUT_DOTTED_LINE).append("小说列表结束")
		  .append(Constants.OUTPUT_DOTTED_LINEN);
		return sb.toString();
	}
	
	/**
	 * 根据选择的小说序号返回对应的内容
	 * @param iSequence 选择的小说序号
	 * @return 返回对应选择小说的内容
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
	 * 根据序号获取小说的路径
	 * @param iSequence 选中的小说序号
	 * @return 小说的路径
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
	 * 将文件保存在客户端
	 * @param fileName:保存的文件名
	 * @param strFileContent：保存的文件内容
	 * @return 保存文件的结果true or false
	 */
	public boolean saveFileToClient(String fileName,String strFileContent){
		boolean bRet = false;
		String downloadpath = config.getString(Constants.CLIENT_DOWNLOAD_PATH);
		boolean bCheck = FileUtil.checkPath(downloadpath);
		if (bCheck){
			String outFile = FileUtil.concatPath(downloadpath, fileName);
			bRet = FileUtil.writeFileUTF8(outFile, strFileContent);
		}else{
			System.out.println("无法创建本地目录:"+downloadpath+"!请修改配置文件！");
		}
		return bRet;
	}
	
	/**
	 * 判断小说是否在服务器上存在
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
	 * 将文件内容保存在服务器上
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
	 * 将上传的小说的信息保存到服务上的配置文件中
	 * @param txtBook  
	 * @return 保存结果 true or false
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
