<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
${style_css }
		${jquery_js }
	</head>
	
	<body>
	<div class="main">
    <div class="nav" id="nav">
					<div class="t"></div>
					<dl>
							<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息管理 
						</dt>
						<dd>
							<a href="${ctx }/admin/userInfo.action?user.id=<s:property value='#session.loginuser.id'/>"  target="mainFrame">个人信息</a>
						</dd>
					</dl>
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							邮件管理
						</dt>
						<dd>
							<a href="${ctx }/admin/findAllUser.action?user.id=<s:property value='#session.loginuser.id'/>" target="mainFrame">写邮件</a>
						</dd>
						<dd>
							<a href="${ctx }/mail/findMail.action?mail.to_uid=<s:property value='#session.loginuser.id'/>&mail.toStatu=1" target="mainFrame">收邮件</a>
						</dd>
						<dd>
							<a href="${ctx }/mail/findRubMail.action?mail.to_uid=<s:property value='#session.loginuser.id'/>&mail.toStatu=0" target="mainFrame">垃圾邮件</a>
						</dd>
					</dl>
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							考勤管理
						</dt>
						<s:if test="#session.loginuser.role==1">
						<dd>
							<a href="${ctx }/holiday/findMH.action" target="mainFrame">休假</a>
						</dd></s:if>
						<s:else>
						<dd>
							<a href="${ctx }/holiday/findCH.action" target="mainFrame">休假</a>
						</dd>
						</s:else>
					</dl>
					
					<dl >
					
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							权限管理
						</dt>
						
						<s:if test="#session.loginuser.role==1">
						<dd>
							<a href="${ctx }/admin/userInfo2.action?user.id=<s:property value='#session.loginuser.id'/>" target="mainFrame">个人账户</a>
						</dd>
						<dd>
							<a href="${ctx }/admin/findUserList.action" target="mainFrame">管理账户</a>
						</dd>
						</s:if>
						<s:else>
						<dd>
							<a href="${ctx }/admin/userInfo2.action?user.id=<s:property value='#session.loginuser.id'/>" target="mainFrame">个人账户</a>
						</dd>
						</s:else>
					</dl>
				</div></div>
  </body>
</html>
