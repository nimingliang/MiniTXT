package com.pb.minitxt.service;

import com.pb.minitxt.entity.TxtBook;

public interface ITxtService {
	
	/**
	 * 获取分类下的小说列表
	 * @param sortName    小说分类
	 * @return
	 */
	public String getTxtListBySortName(String sortName);
	
	/**
	 * 获取选中的小说内容
	 * @param iSequence   选中的小说序号
	 * @return
	 */
	public String getTxtContentBySequence(int iSequence);
	
	/**
	 * 获取选中的小说文件长度
	 * @param iSequence
	 * @return
	 */
	public String getTxtFilePath(int iSequence);
	
	/**
	 * 保存文件到客户端
	 * @param fileName
	 * @param strFileContent
	 * @return
	 */
	public boolean saveFileToClient(String fileName,String strFileContent);
	
	/**
	 * 检查小说是否已经在服务器上存在
	 * @param txtBook
	 * @return
	 */
	public boolean checkBookExist(TxtBook txtBook);
	
	/**
	 * 保存文件到服务器
	 * @param txtBook
	 * @param strFileContent
	 * @return
	 */
	public boolean saveFileToServer(TxtBook txtBook,String strFileContent);

}
