<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 

 <%@include file="/common/taglibs.jsp"  %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户登录</title>
 ${validate_css }
	${jquery_js }
	${validate_js }
${login_css }
<script type="text/javascript">
		
		$(function(){
		var validator = $("#loginForm").validate({
			rules:{
				"user.uname":"required",
				"user.upwd":{
					required:true,
					minlength:3
				}
			},
			messages:{
				"user.uname":"用户名不能为空",
				"user.upwd":{
					required:"密码不能为空",
					minlength:"密码长度不能小于3"
				}
			}
			/* errorPlacement:function(error,element){
			error.appendTo(element.parent());
			} */
		});
			$("#btnLogin").click(function(){
				//表单验证
				if($("#loginForm").valid()){
					//alert("发送ajax请求。。。");
					var url = "${ctx}/admin/login.action";
					$.get(
						url,
						{
						"user.uname":$("#uname").val(),
						"user.upwd":$("#upwd").val()
						},
						function(data){
							if(data.retcode=="0"){
								window.location.href="main/index.jsp";
							}else{
								//alert(data.retmsg);
								$("#msg").html(data.retmsg);
							}
						}
					)
				}
				
			});
		});
	</script>
</head>
 
<body>
	<div class="login-top"></div>
	<div class="login-area">
		<s:form id="loginForm" action="login" namespace="/admin">
		<table width="315px" border="0" cellspacing="0" cellpadding="0" >
			<tr height="33px">
			<td align="right" width="20px"><label> 
				工&nbsp;&nbsp;号： 
			</label>
			</td>
			<td align="left" ><s:textfield name="user.uname" id="uname"></s:textfield></td>
			</tr>
			<tr height="33px">
			<td align="right" width="20px"><label>
				密&nbsp;&nbsp;码：
			</label></td>
			<td align="left"><s:password name="user.upwd" id="upwd"></s:password></td>
			</tr>
		</table>
			<!-- <label> 
				工&nbsp;&nbsp;号： 
			</label>
			<s:textfield name="user.uname" id="uname"></s:textfield>
			<label>
				密&nbsp;&nbsp;码：
			</label>
			<s:password name="user.upwd" id="upwd"></s:password> -->
			<input type="button" class="login-sub" value="" id="btnLogin"/>
			
			<div id="msg" style="color:red"></div>
				<!-- <b><font color="red"><s:property value="message"/></font></b> -->
		</s:form>
	</div>
	<div class="login-copyright"></div>
</body>
</html>
