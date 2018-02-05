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
							个人信息
						</div>
						<div class="pages">
						
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr height="27px">
									<td align="right" width="30%">昵称：</td><td  align="left"><input type="text" name="user.nickname" value="<s:property value="user.nickName"/>" readonly="readonly" id="nickname" class="inp"/></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">年龄：</td><td  align="left"><input type="text" name="user.age" value="<s:property value="user.age"/>" readonly="readonly" id="age" class="inp"/></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">性别：</td><td  align="left">
									
										<input type="text" name="user.sex" value="<s:property value="user.sex"/>" readonly="readonly" id=""  class="inp"/>
									
									</td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">手机：</td><td  align="left"><input type="text" name="user.mobile" value="<s:property value="user.mobile"/>" readonly="readonly" id="u_mobile" class="inp"/></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">地址：</td><td  align="left"><input type="text" name="user.address" value="<s:property value="user.address"/>" readonly="readonly" id="u_address" class="inp"/></td>
								</tr>
								<tr height="27px">
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
			window.location.href="${ctx}/admin/toEditUser.action?user.id="+id;
		});
	});
</script>
