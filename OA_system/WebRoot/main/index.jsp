<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="/common/taglibs.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>北大青鸟办公自动化管理系统</title>

${style_css }
</head>
<frameset rows="123,*,125" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
	<frameset cols="400,*" frameborder="no" border="0" framespacing="0">
		<frame src="left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" />
		<frame src="right.jsp" name="mainFrame" id="mainFrame" scrolling="no" target="_self"/>		
	</frameset>
	<frame src="buttom.jsp" name="endFrame" scrolling="no" noresize="noresize" id="endFrame" />
</frameset>
<noframes><body>
</body></noframes>
</html>