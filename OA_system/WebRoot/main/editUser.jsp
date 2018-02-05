<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		${style_css }
		${jquery_js }
	${jquery_form_js }
	${validate_js }
	${validate_css }
	</head>
	
	<body>
	<div class="main">
		<div class="action">
						<div class="t">
							个人信息
						</div>
						<div class="pages">
						 <s:form id="editForm" action="doUpdateUser" namespace="/admin">
    						<s:hidden name="user.id" id="id"></s:hidden>
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr height="27px">
									<td align="right" width="30%">昵称：</td><td  align="left"><s:textfield name="user.nickName"></s:textfield></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">年龄：</td><td  align="left"><s:textfield name="user.age"></s:textfield></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">性别：</td><td  align="left">
									
										<s:select list="#{'男':'男','女':'女' }" name="user.sex"></s:select>
									
									</td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">手机：</td><td  align="left"><s:textfield name="user.mobile"></s:textfield></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">地址：</td><td  align="left"><s:textfield name="user.address"></s:textfield></td>
								</tr>
								<tr height="27px" align="center">
									<td colspan="2"><input type="button" value="保存" id="btnSave" />
									&nbsp;&nbsp;<input type="button" value="返回" id="back" onclick="history.back();" /></td>
								</tr>
								
								</table>
								</s:form>
						</div>
					</div></div>
	</body>
</html>
<script type="text/javascript">
	$(function(){
	var validator = $("#editForm").validate({
				rules : {
					"user.nickName" : "required",
					"user.age":{
					required:true,
					digits:true,
					range:[18,60]
					},
					"user.mobile":{
					required:true,
					digits:true,
					rangelength:[11,11],
				},
				"user.address":"required"
				},
				messages : {
					"user.nickName" : "昵称不能为空",
					"user.age":{
					required:"年龄不能为空",
					digits:"年龄必须为整数",
					range:"年龄在18-60之间"
					},
					"user.mobile":{
					required:"手机号码不能为空",
					digits:"必须为整数数字",
					rangelength:"手机号码位数不能小于11位"
				},
				"user.address":"地址不能为空"
				}
			});
		$("#btnSave").click(function(){
			if ($("#editForm").valid()) {
			var url = "${ctx}/admin/doUpdateUser.action";
			var options = {
				url:url,
				success:callback,
				type:'post',
				dataType:'json'
			};
			$("#editForm").ajaxSubmit(options);
			}
		});
	});
	function callback(data){
	alert(data.retmsg);
	if(data.retcode=="0"){
	var id = $("#id").val();
	if(window.parent){
		window.parent.frames["topFrame"].location.reload();
	}
	window.location.href="${ctx}/admin/userInfo.action?user.id="+id;
	}
	}
</script>
