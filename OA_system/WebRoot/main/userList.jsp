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
							用户列表
						</div>
						<div class="pages">
		           <s:form name="searchForm" action="findUserList" namespace="/admin">
		           	<s:hidden name="pager.currentPage"></s:hidden>
					<s:hidden name="pager.pageSize"></s:hidden>
		           </s:form>
							<table width="100%" border="0" cellspacing="0" cellpadding="0" >
							
							<tr height="30px" bgcolor="#DCDCDC">
								  <td>用户名</td>
								  <td>用户昵称</td>
							      <td>手机</td>
							      <td>地址</td>
							      
							</tr>
							
								<s:iterator value="pager.pageRecords" status="s"><s:if test="#s.odd">
							   <tr height="30px" bgcolor="#FAF0E6">
							</s:if>
								<s:else><tr height="30px"></s:else>
									<td><s:property value="uname"/></td>
								  <td><s:property value="nickName" /></td>
								   <td><s:property value="mobile" /></td>
								    <td><s:property value="address" /><br /></td>
							      
								</tr></s:iterator>
								<tr>
									<td colspan="4"><input type="button" class="addBtn" value="添加用户"/></td>
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
  $(".addBtn").click(function(){
        window.location.href="${ctx}/main/addUser.jsp";
             
      });       
});

</script>
