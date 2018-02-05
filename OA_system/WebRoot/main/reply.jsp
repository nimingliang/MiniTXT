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
	 <script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script> 
	</head>
	
	<body>
	<div class="main">
		<div class="action">
						<div class="t">
							休假管理
						</div>
						<div class="pages">
						 <s:form id="repForm" action="doAddReply" namespace="/admin">
    						
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr height="27px">
									<td align="right" width="30%">姓名：</td><td  align="left"><s:textfield name="holiday.replyName" id="rname"></s:textfield></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">开始时间：</td><td  align="left">
									<input id="d11" name="holiday.beginTime" type="text" onClick="WdatePicker()"/><font color="red">*</font> 
									<!-- <s:textfield name="holiday.beginTime" id="btime"></s:textfield> --></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">结束时间：</td><td  align="left">
									<input id="d12" name="holiday.endTime" type="text" onClick="WdatePicker()"/><font color="red">*</font>
									<!-- <s:textfield name="holiday.endTime" id="etime"></s:textfield> --></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">请假天数：</td><td  align="left"><s:textfield name="holiday.days" id="days"></s:textfield></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">休假原因：</td><td  align="left"><s:textarea name="holiday.reason" id="reason" cols="50" rows="5"></s:textarea></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">审批人：</td><td  align="left">
									
										<s:select list="userList" headerKey="0" headerValue="请选择审批人" listKey="id" listValue="nickName" name="holiday.auditId" ></s:select>
									
									</td>
								</tr>
								
								
								<tr height="27px" align="center">
									<td colspan="2"><input type="button" value="提交申请" id="btnSave" />
									&nbsp;&nbsp;<input type="button" value="返回" id="back"  />
									</td>
									
								</tr>
								
								</table>
								</s:form>
						</div>
					</div></div>
	</body>
</html>
<script type="text/javascript">
		$(function(){
  $("#back").click(function(){
        window.location.href="${ctx }/holiday/back.action";
             
      });       
});
		$(function(){
		var validator = $("#repForm").validate({
			rules:{
			"holiday.replyName":"required",
				"holiday.beginTime":"required",
				"holiday.endTime":"required",
				"holiday.days":{
					required:true,
					digits:true	
				}
			},
			messages:{
			"holiday.replyName":"请填写你的真实姓名",
				"holiday.beginTime":"开始时间不能为空",
				"holiday.endTime":"结束时间不能为空",
				"holiday.days":{
					required:"休假天数不能为空",
					digits:"休假天数必须为整数"	
				}
			}
		});
			$("#btnSave").click(function(){
			//alert("111");
				//表单验证
				if($("#repForm").valid()){
					//alert("发送ajax请求。。。");
					var url = "${ctx}/holiday/doAddReply.action";
					var options = {
					url:url,
					success:callback,
					type:'post',
					dataType:'json'
					};
			$("#repForm").ajaxSubmit(options);
		}
			});
			});
			
			function callback(data){
							alert(data.retmsg);
							if(data.retcode=="0"){
								window.location.href="${ctx }/holiday/replyHoliday.action";
							}
						}
	</script>