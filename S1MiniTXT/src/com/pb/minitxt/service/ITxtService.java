package com.pb.minitxt.service;

import com.pb.minitxt.entity.TxtBook;

public interface ITxtService {
	
	/**
	 * ��ȡ�����µ�С˵�б�
	 * @param sortName    С˵����
	 * @return
	 */
	public String getTxtListBySortName(String sortName);
	
	/**
	 * ��ȡѡ�е�С˵����
	 * @param iSequence   ѡ�е�С˵���
	 * @return
	 */
	public String getTxtContentBySequence(int iSequence);
	
	/**
	 * ��ȡѡ�е�С˵�ļ�����
	 * @param iSequence
	 * @return
	 */
	public String getTxtFilePath(int iSequence);
	
	/**
	 * �����ļ����ͻ���
	 * @param fileName
	 * @param strFileContent
	 * @return
	 */
	public boolean saveFileToClient(String fileName,String strFileContent);
	
	/**
	 * ���С˵�Ƿ��Ѿ��ڷ������ϴ���
	 * @param txtBook
	 * @return
	 */
	public boolean checkBookExist(TxtBook txtBook);
	
	/**
	 * �����ļ���������
	 * @param txtBook
	 * @param strFileContent
	 * @return
	 */
	public boolean saveFileToServer(TxtBook txtBook,String strFileContent);

}
