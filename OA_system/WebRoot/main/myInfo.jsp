<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		${style_css }
		${jquery_js }
		<style type="text/css">
		.inp{
		border: 0px #767F94 solid;
		background-color:#F5FFFA
		}
		</style>
	</head>
	
	<body>
	<div class="main">
		<div class="action">
						<div class="t">
							个人账户
						</div>
						<div class="pages">
						
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr height="27px">
									<td align="right" width="30%">用户名：</td><td  align="left"><input type="text" name="user.uname" value="<s:property value="user.uname"/>" readonly="readonly" id="uname" class="inp"/></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">密码：</td><td  align="left"><input type="password" name="user.upwd" value="******" readonly="readonly" id="upwd" class="inp"/></td>
								</tr>
								
								<tr >
									<td align="center" colspan="2"><br/><input type="button" class="editUser" id="<s:property value="user.id"/>" value="编辑数据" onclick="setit()" /></td>
								</tr>
								
								</table>
								
						</div>
					</div></div>
	</body>
</html>
<script type="text/javascript">
	$(function(){
		$(".editUser").click(function(){
			var id = $(this).attr("id");
			window.location.href="${ctx}/admin/toEditUser2.action?user.id="+id;
		});
	});
</script>
