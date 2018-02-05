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
						 <s:form id="addForm" action="doAddUser" namespace="/admin">
    						
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr height="27px">
									<td align="right" width="30%">用户名：</td><td  align="left"><s:textfield name="user.uname" id="uname"></s:textfield></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">密码：</td><td  align="left"><s:password name="user.upwd" id="upwd"></s:password></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">昵称：</td><td  align="left"><s:textfield name="user.nickName" id="nickName"></s:textfield></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">真实姓名：</td><td  align="left"><s:textfield name="user.realName" id="realName"></s:textfield></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">年龄：</td><td  align="left"><s:textfield name="user.age" id="age"></s:textfield></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">性别：</td><td  align="left">
									
										<s:select list="#{'男':'男','女':'女' }" name="user.sex" id="sex"></s:select>
									
									</td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">手机：</td><td  align="left"><s:textfield name="user.mobile" id="mobile"></s:textfield></td>
								</tr>
								<tr >
									<td align="right" width="30%">地址：</td><td  align="left"><s:textfield name="user.address" id="address"></s:textfield></td>
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
		var validator = $("#addForm").validate({
			rules:{
				"user.uname":"required",
				"user.upwd":{
					required:true,
					minlength:3
				},
				"user.nickName":"required",
				"user.realName":"required",
				"user.age":{
				required:true,
				range:[18,60],
				digits:true
				},
				
				"user.mobile":{
					required:true,
					digits:true,
					rangelength:[11,11]
				},
				"user.address":"required"
			},
			messages:{
				"user.uname":"用户名不能为空",
				"user.upwd":{
					required:"密码不能为空",
					minlength:"密码长度不能小于3"
				},
				"user.nickName":"昵称不能为空",
				"user.realName":"真实姓名不能为空",
				"user.age":{
				required:"年龄不能为空",
				range:"年龄在18-60之间",
				digits:"年龄必须为整数"
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
			//alert("111");
				//表单验证
				if($("#addForm").valid()){
					//alert("发送ajax请求。。。");
					var url = "${ctx}/admin/doAddUser.action";
					var options = {
					url:url,
					success:callback,
					type:'post',
					dataType:'json'
					};
			$("#addForm").ajaxSubmit(options);
		}
			});
			});
			
			function callback(data){
							alert(data.retmsg);
							if(data.retcode=="0"){
								window.location.href="${ctx }/admin/findUserList.action";
							}
						}
	</script>