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
	<script type="text/javascript">
$(function(){
		
		var validator = $("#sendForm").validate({
				rules : {
					"mail.title" : "required",
					"upload": "required"
				},
				messages : {
					"mail.title" : "邮件标题不能为空",
					"upload": "请上传附件"
				}
			});
			$("#sendMail").click(function() {
				//表单验证
				if ($("#sendForm").valid()) {
					var url = "${ctx}/mail/doSendMail.action";
					var options = {
						url : url,
						success : callback,
						type : 'post',
						dataType : 'json'
					};
					$("#sendForm").ajaxSubmit(options);
				}

			});
		});
		
		function callback(data) {
			alert(data.retmsg);
			if (data.retcode == "0") {
				var id = $("#id").val();
				window.location.href = "${ctx}/admin/findAllUser.action?user.id="+id;
			}
		}
	</script>
	</head>
	
	<body>
	<div class="main">
		<div class="action">
						<div class="t">
							写邮件
						</div>
						<div class="pages">
						<s:form id="sendForm" action="doSendMail" method="post" namespace="/mail" enctype="multipart/form-data">
						<s:hidden name="#session.loginuser.id" id="id"></s:hidden>
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr height="27px">
									<td align="right" width="30%">收件人：</td><td  align="left">
									<s:select list="userList" headerKey="0" headerValue="请选择联系人" listKey="id" listValue="nickName" name="mail.to_uid" ></s:select>
									</td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">邮件标题：</td><td  align="left">
									<s:textfield name="mail.title" ></s:textfield>
									</td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">邮件内容：</td><td  align="left">
									
										<s:textarea name="mail.content" cols="50" rows="5" ></s:textarea>
									
									</td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">上传附件：</td><td  align="left">
									<input name="upload" type="file" />&nbsp;&nbsp;(附件不能大于9M)
									</td>
								</tr>
								
								<tr height="27px">
									<td align="center" colspan="2"><br/><input type="button" id="sendMail" onclick="submitForm()" value="发送邮件" />
									
									</td>
								</tr>
								
								</table>
								</s:form>
						</div>
					</div></div>
	</body>
</html>

