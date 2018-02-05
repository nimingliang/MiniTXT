package com.oa.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.oa.common.Pager;
import com.oa.common.RetCode;
import com.oa.entity.Holiday;
import com.oa.entity.Mail;
import com.oa.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class MailAction extends BaseAction{

	private Mail mail;
	private Pager<Mail> pager;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private List<Mail> mailList;
	
	public Mail getMail() {
		return mail;
	}
	public void setMail(Mail mail) {
		this.mail = mail;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
	public Pager<Mail> getPager() {
		return pager;
	}
	public void setPager(Pager<Mail> pager) {
		this.pager = pager;
	}
	public List<Mail> getMailList() {
		return mailList;
	}
	public void setMailList(List<Mail> mailList) {
		this.mailList = mailList;
	}
	public String doSendMail(){
		
		System.out.println(upload);
		System.out.println(uploadFileName);
		long timeName = new Date().getTime();
		String subName = uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
		
		String savePath = ServletActionContext.getServletContext().getRealPath("/upload/"+timeName+subName);
		System.out.println(savePath);
		try {
			FileInputStream fis = new FileInputStream(upload);
			FileOutputStream fos = new FileOutputStream(savePath);
			
			mail.setAdjunctPath(savePath);
			mail.setIsread(0);
			mail.setSendTime(new Date());
			mail.setFrom_uid((Integer)ActionContext.getContext().getSession().get("fromID"));
			mail.setFromStatu(1);
			mail.setToStatu(1);
			mailService.addMail(mail);
			IOUtils.copy(fis, fos);
			fos.flush();
			fos.close();
			fis.close();
			log.info("sendMail success:{}",mail);
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("retmsg", "发送成功");
			return SUCCESS;
		} catch (Exception e) {
			log.error(" sendMail bug:{}",e);
			resultMap.put("retcode", RetCode.FAIL);
			resultMap.put("retmsg", "发送失败");
		}
		return ERROR;
	}
	public String findMail(){
		try {
			if (pager==null) {
				pager = new Pager<Mail>();
			}
			//mailList = mailService.getMails(mail.getTo_uid());
			pager = mailService.getMails(pager.getPageSize(), pager.getCurrentPage(), mail.getTo_uid(),mail.getToStatu());
			return SUCCESS;
		} catch (Exception e) {
			log.error("findMail bug:{}",e);
		}
		return ERROR;
	}
	public String mailInfo(){
		try {
			mail = mailService.getMailInfo(mail.getId());
			User user = userService.getUserById(mail.getFrom_uid());
			putToSession("fromName", user.getNickName());
			return SUCCESS;
		} catch (Exception e) {
			log.error("mailInfo bug:{}", e);
		}
		 return ERROR;
	}
	
	public String updateIsread(){
		
		try {
			mailService.updateIR(mail);
			resultMap.put("retcode", RetCode.SUCCESS);

		} catch (Exception e) {
			log.error("updateStatu bug:{}", e);
			resultMap.put("retcode", RetCode.FAIL);
		}
		return SUCCESS;
	}
	public String updateStatus(){
		
		try {
			mailService.updateST(mail);
			resultMap.put("retcode", RetCode.SUCCESS);

		} catch (Exception e) {
			log.error("updateStatu bug:{}", e);
			resultMap.put("retcode", RetCode.FAIL);
		}
		return SUCCESS;
	}
	public String deleteMail(){
		
		try {
			mailService.delMail(mail.getId());
			resultMap.put("retcode", RetCode.SUCCESS);

		} catch (Exception e) {
			log.error("updateStatu bug:{}", e);
			resultMap.put("retcode", RetCode.FAIL);
		}
		return SUCCESS;
	}
}
