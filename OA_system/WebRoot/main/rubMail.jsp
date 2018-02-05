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
							垃圾邮件列表
						</div>
						<div class="pages">
						<s:form name="searchForm" action="findRubMail" namespace="/mail">
		           	<s:hidden name="pager.currentPage"></s:hidden>
					<s:hidden name="pager.pageSize"></s:hidden>
					<s:hidden name="mail.to_uid" id="myId"></s:hidden>
					<s:hidden name="mail.toStatu" id="toStatu"></s:hidden>
		           </s:form>
		           
							<table width="100%" border="0" cellspacing="0" cellpadding="0" >
							
							<tr bgcolor="#DCDCDC" height="30px">
								  <td>邮件标题</td>
								  <td>邮件内容</td>
							      <td>是否已读</td>
							      <td>时间</td>
							      <td>操作</td>
							</tr>
							<s:if test="pager!=null">
							<s:iterator value="pager.pageRecords">
							
								<s:if test="isread==0">
							   <tr bgcolor="#FAF0E6" height="30px">
							  </s:if>
							 <s:else>
							   <tr height="30px">
							 </s:else>
								
									<td><%-- <a href="javascript:void(0);" class="emailInfo" id="<s:property value="id"/>"> <font color="blue"> --%><s:property value="title" /><!-- </font></a> --></td>
								  <td><s:property value="content" /></td>
							      <td>
							      <s:if test="isread==0">未读</s:if> 
							      <s:else> 已读  </s:else></td>
							      <td><s:date name="sendTime" format="yyyy-MM-dd"/> </td>
							      <td><a href="javascript:void(0);" class="reduction" id="<s:property value="id"/>">还原</a>|
							      <a href="javascript:void(0);" class="delete" id="<s:property value="id"/>">删除</a></td>
								</tr>
								
								
								</s:iterator></s:if>
								
								</table>
								<hr/>
								<%@include file="/common/page.jsp" %>
						</div>
					</div></div>
	</body>
</html>
 <script type="text/javascript">$(function(){

   $(".reduction").click(function() {
		    var id = $(this).attr("id");
			var uid = $("#myId").val();
			var ts = $("#toStatu").val();
			if(confirm("你确认要还原为正常邮件吗？")){
			var url = "${ctx}/mail/updateStatus.action?mail.id="+id;	
		 $.get(
          url,
        {"mail.to_uid":uid,
         "mail.toStatu":1,
        },
         function(data){ 
        if(data.retcode=="0"){
        window.location.href="${ctx}/mail/findRubMail.action?mail.to_uid="+uid+"&mail.toStatu="+ts;
        }else{
          alert(data.retmsg);
        }
      }
      );
      }
 });

$(".delete").click(function(){
    var id = $(this).attr("id");
    if(confirm("你确认要删除吗？")){
   var url="${ctx}/mail/deleteMail.action";
      $.get(
      url,
      {"mail.id":id},
      function(data){
        if(data.retcode=="0"){
        location.reload();
        }else{
          alert(data.retmsg);
        }
      }
      );
   }
});

});

</script>