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
	</head>
	
	<body>
	<div class="main">
		<div class="action">
						<div class="t">
							邮件内容
						</div>
						<div class="pages">
						<s:form action="updateIsread" id="editForm" namespace="/mail">
			 <s:hidden name="mail.id" id="id"></s:hidden>
		    <s:hidden name="mail.to_uid" id="id1"></s:hidden>
		     <s:hidden name="mail.toStatu" id="id2"></s:hidden>
					<table width="90%" border="0" cellspacing="0" cellpadding="0" >

						<tr>
							<td align="right" width="30%">邮件标题：</td>
							<td align="left"><s:textfield name="mail.title"></s:textfield>
							</td>
						</tr>
						<tr>
							<td align="right" width="30%">邮件内容：</td>
							<td align="left"><s:textarea cols="50" rows="5" name="mail.content"></s:textarea>
							<br></td>
						</tr>
						<tr>
							<td align="right" width="30%">发信时间：</td>
							<td align="left"><s:date name="mail.sendTime" format="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<td align="right" width="30%">邮件类型：</td>
							<td>
							<s:select list="#{0:'垃圾邮件',1:'正常邮件'}" name="mail.toStatu"></s:select>
							</td>
						</tr>
						<tr>
							<td align="right" width="30%">来自：</td>
							<td align="left">
						      <s:textfield name="#session.fromName" readonly="true"></s:textfield>
							</td>
						</tr>
					<tr>
							<td align="right" width="30%">文件：</td>
							<td align="left">
						  <a href="<s:url value='/download/downloadFile.action'><s:param name='fileName'><s:property value="mail.adjunctPath"/></s:param> </s:url>">下载</a>
							</td>
						</tr>
						<tr>
						<td align="center" colspan="2"><br /> 
							<input type="button" value="返回" id="btnCall" />
						</td>
						</tr>
					</table>
				</s:form>
								
						</div>
					</div></div>
	</body>
</html>
<script type="text/javascript">
$(function() {

		$("#btnCall").click(function() {
		    var id = $("#id").val();
			var uid = $("#id1").val();
			var status = $("#id2").val();
			var url = "${ctx}/mail/updateIsread.action?mail.id="+id;	
		 $.get(
          url,
        {"mail.to_uid":uid,
         "mail.toStatu":status,
         "mail.isread":1
        },
         function(data){ 
        if(data.retcode=="0"){
        window.location.href="${ctx}/mail/findMail.action?mail.to_uid="+uid+"&mail.toStatu=1";
        }else{
          alert(data.retmsg);
        }
      }
      );
		});
});
		

</script>

