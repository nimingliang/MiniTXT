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
							休假信息列表
						</div>
						<div class="pages">
		           
							<table width="100%" border="0" cellspacing="0" cellpadding="0" >
							
							<tr height="30px" bgcolor="#DCDCDC">
								  <td>申请人</td>
								  <td>开始时间</td>
							      <td>结束时间</td>
							      <td>天数</td>
							       <td>审核状态</td>
							        <td>原因</td>
							      
							</tr>
							<s:if test="holidayList!=null">
								<s:iterator value="holidayList"><s:if test="status==0">
							   <tr height="30px" bgcolor="#FAF0E6">
							</s:if>
								<s:else><tr height="30px"></s:else>
									<td><s:property value="#session.loginuser.realName"/></td>
								  <td><s:date name="beginTime" format="yyyy-MM-dd"/></td>
								   <td><s:date name="endTime" format="yyyy-MM-dd"/></td>
								   <td><s:property value="days"/></td>
								    <td><s:if test="status==0">已审核</s:if><s:elseif test="status==1">未审核</s:elseif>
								    <s:else>审核未通过</s:else>
								    </td>
							      <td><s:if test="reason!=''"><s:property value="reason"/></s:if><s:else>无</s:else></td>
								</tr></s:iterator></s:if>
								<tr>
									<td colspan="4"><input type="button" class="replyH" value="申请休假"/></td>
								</tr>
								
								</table>
								
						</div>
					</div></div>
	</body>
</html>
<script type="text/javascript">
$(function(){
  $(".replyH").click(function(){
        window.location.href="${ctx}/holiday/replyHoliday.action";
             
      });       
});

</script>
