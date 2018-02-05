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
							休假管理
						</div>
						<div class="pages">
						 
    						<s:hidden name="holiday.id" id="hid"></s:hidden>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr height="27px">
									<td align="right" width="30%">姓名：</td><td  align="left"><s:property value="holiday.replyName"/></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">开始时间：</td><td  align="left"><s:date name="holiday.beginTime" format="yyyy-MM-dd"/></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">结束时间：</td><td  align="left"><s:date name="holiday.endTime" format="yyyy-MM-dd"/></td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">请假天数：</td><td  align="left"><s:property value="holiday.days"/>&nbsp;天</td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">休假原因：</td><td  align="left"><s:if test="holiday.reason!=''"><s:textarea name="holiday.reason" id="reason" cols="50" rows="5"  readonly="true" ></s:textarea></s:if>
									<s:else>原因不详</s:else>
									</td>
								</tr>
								<tr height="27px">
									<td align="right" width="30%">申请人：</td><td  align="left">
									<s:property value="holiday.replyName"/>
										
									
									</td>
								</tr>
								
								
								<tr height="27px">
									<td align="right"><input type="button" value="审核通过" id="replyG" /></td>
									<td align="left">&nbsp;&nbsp;<input type="button" value="审核不通过" id="replyB"  /></td>
								</tr>
								
								</table>
								
						</div>
					</div></div>
	</body>
</html>
<script type="text/javascript">
$(function(){
		var id = $("#hid").val();
	  $("#replyG").click(function(){
	    window.location.href="${ctx }/holiday/replyG.action?holiday.id="+id;
	             
	  }); 
	  $("#replyB").click(function(){
	    window.location.href="${ctx }/holiday/replyB.action?holiday.id="+id;
	             
	  });       
});
		
		
</script>