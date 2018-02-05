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
		           <s:form name="searchForm" action="findMH" namespace="/holiday">
		           	<s:hidden name="pager.currentPage"></s:hidden>
					<s:hidden name="pager.pageSize"></s:hidden>
		           </s:form>
							<table width="100%" border="0" cellspacing="0" cellpadding="0" >
							
							<tr height="30px" bgcolor="#DCDCDC">
								  <td>申请人</td>
								  <td>开始时间</td>
							      <td>结束时间</td>
							      <td>天数</td>
							       <td>审核状态</td>
							        <td>原因</td>
							        <td>操作</td>
							      
							</tr>
							<s:if test="pager!=null">
								<s:iterator value="pager.pageRecords"><s:if test="status==0">
							   <tr height="30px" bgcolor="#FAF0E6">
							</s:if>
								<s:else><tr height="30px"></s:else>
									<td><s:property value="replyName"/></td>
								  <td><s:date name="beginTime" format="yyyy-MM-dd"/></td>
								   <td><s:date name="endTime" format="yyyy-MM-dd"/></td>
								   <td><s:property value="days"/>&nbsp;天</td>
								    <td><s:if test="status==0">已审核</s:if><s:elseif test="status==1">未审核</s:elseif>
								    <s:else>审核未通过</s:else>
								    </td>
							      <td><s:if test="reason!=''"><s:property value="reason"/></s:if><s:else>不详</s:else></td>
							      <td><s:if test="status==1"><a href="javascript:void(0);" class="audit" id="<s:property value="id"/>"><font color="blue">[审核]</font></a></s:if></td>
								</tr></s:iterator></s:if>
								<tr>
									<td colspan="4"><input type="button" class="replyH" value="申请休假"/></td>
								</tr>
								
								</table>
								
								<hr/>
								<%@include file="/common/page.jsp" %>
						</div>
					</div></div>
	</body>
</html>
<script type="text/javascript">
$(function(){
$(".audit").click(function(){
		var id = $(this).attr("id");
        window.location.href="${ctx}/holiday/audit.action?holiday.id="+id;
             
      }); 
  $(".replyH").click(function(){
        window.location.href="${ctx}/holiday/replyHoliday.action";
             
      });       
});


</script>
