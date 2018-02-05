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
						 <s:form id="editForm" action="doUpdateUser2" namespace="/admin">
    						<s:hidden name="user.id" id="id"></s:hidden>
    						<s:hidden name="#session.loginuser.upwd" id="pd"></s:hidden>
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr height="27px">
									<td align="right" width="30%">用户名：</td><td  align="left"><s:textfield name="user.uname" readonly="true" style="border:0;background-color:#F5FFFA"></s:textfield></td>
								</tr>
								<!-- <tr height="27px">
									<td align="right" width="30%">旧密码：</td><td  align="left"><s:password name="user.oupwd" id="oupwd"></s:password></td>
								</tr> -->
								<tr height="27px">
									<td align="right" width="30%">新密码：</td><td  align="left"><s:password name="user.nupwd" id="nupwd"></s:password></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">确认密码：</td><td  align="left"><s:password name="user.upwd"></s:password></td>
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
				rules:{
				/* "user.oupwd":{
					required:true,
					minlength:3,
					equalTo:"#pd"
				}, */
				"user.nupwd":{
					required:true,
					minlength:3
				},
				"user.upwd":{
					required:true,
					minlength:3,
					equalTo:"#nupwd"
					
				}
			},
			messages:{
			/* "user.oupwd":{
					required:"密码不能为空",
					minlength:"密码长度不能小于3"
					equalTo:"输入的旧密码不匹配"
				}, */
				"user.nupwd":{
					required:"密码不能为空",
					minlength:"密码长度不能小于3"
				},
				"user.upwd":{
					required:"密码不能为空",
					minlength:"密码长度不能小于3",
					equalTo:"两次密码不同"
				}
			}
			});
		$("#btnSave").click(function(){
			if($("#editForm").valid()){
			var url = "${ctx}/admin/doUpdateUser2.action";
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
	window.location.href="${ctx}/admin/userInfo2.action?user.id="+id;
	}
	}
</script>
