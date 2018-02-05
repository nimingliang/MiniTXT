<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
		function jump(p,s){
			with(document.searchForm){
				elements["pager.currentPage"].value = p;
				elements["pager.pageSize"].value = s;
				submit();
			}
			//window.location.href="${ctx}/admin/findUserList.action?pager.currentPage="+p+"&pager.pageSize="+s;
		}
	</script>

 <table border="0" style="width:600px;margin:0 auto" >
    	<tr>
    		<td style="text-align:right">
    			第<font color="red"><s:property value="pager.currentPage" /></font>/<s:property value="pager.pageCount" />页
    			共<s:property value="pager.total" />条
    		</td>
    		<td style="text-align:right">
    			<s:if test="pager.currentPage == 1">
    				首页
    				上一页
    			</s:if>
    			<s:else>
    				<a href="javascript:jump(1,<s:property value="pager.pageSize" />)">首页</a>
    				<a href="javascript:jump(<s:property value="pager.currentPage-1" />,<s:property value="pager.pageSize" />)">上一页</a>
    			</s:else>
    			<s:if test="pager.currentPage == pager.pageCount">
    				下一页
    				末页
    			</s:if>
    			<s:else>
    				<a href="javascript:jump(<s:property value="pager.currentPage+1" />,<s:property value="pager.pageSize" />)">下一页</a>
    				<a href="javascript:jump(<s:property value="pager.pageCount" />,<s:property value="pager.pageSize" />)">末页</a>
    			</s:else>
    			转到<s:textfield id="gPage" name="pager.currentPage" cssStyle="width:20px"></s:textfield>
    			<input type="button" value="GO" onclick="jump(document.getElementById('gPage').value,<s:property value="pager.pageSize" />)" />
    			每页显示<s:select name="pager.pageSize"  list="#{3:'3',5:'5',10:'10',15:'15' }" onchange="jump(1,this.value);"></s:select>
    		</td>
    	</tr>
    </table>