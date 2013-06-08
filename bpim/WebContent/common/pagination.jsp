<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%out.clear();%><table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">
		  <tr>
			<td width="1%"><div class="list_12">&nbsp;<% if("true".equals(request.getParameter("show_button"))){%><a href="javascript:deleteData(null)" class="change1">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:addData()" class="change1">添加</a><%} %></div></td>
			<td width="99%" align="right">共有记录:<s:property value="page.recordCount"/> 条&nbsp;&nbsp;当前:<s:property value="page.pageNo"/>/<s:property value="page.pageCount"/>页
				<input type="hidden" name="action_page" value="<%=request.getParameter("action_page")%>" id="action_page"/>
	          	<input type="hidden" name="action_add" value="<%=request.getParameter("action_add")%>" id="action_add"/>
	          	<input type="hidden" name="action_del" value="<%=request.getParameter("action_del")%>" id="action_del"/>
				<s:if test="page.recordCount eq 0 or page.pageCount eq 1">
				首页&nbsp;&nbsp;上页&nbsp;&nbsp;下页&nbsp;&nbsp;尾页
				</s:if>
				<s:elseif test="page.pageNo eq 1">
				首页&nbsp;&nbsp;上页&nbsp;&nbsp;<a href="javascript:movetoPage(<s:property value="page.pageNo + 1" />, <s:property value="page.pageSize" />)" class="change2" />下页</a>&nbsp;&nbsp;<a href="javascript:movetoPage(<s:property value="page.pageCount" />, <s:property value="page.pageSize" />)" class="change2" />尾页</a>
				</s:elseif>
				<s:elseif test="page.pageNo eq page.pageCount">
				<a href="javascript:movetoPage(1, <s:property value="page.pageSize" />)" class="change2" />首页</a>&nbsp;&nbsp;<a href="javascript:movetoPage(<s:property value="page.pageNo - 1" />, <s:property value="page.pageSize" />)" class="change2" />上页</a>&nbsp;&nbsp;下页&nbsp;&nbsp;尾页
				</s:elseif>
				<s:else>
				<a href="javascript:movetoPage(1, <s:property value="page.pageSize" />)" class="change2" />首页</a>&nbsp;&nbsp;<a href="javascript:movetoPage(<s:property value="page.pageNo - 1" />, <s:property value="page.pageSize" />)" class="change2" />上页</a>&nbsp;&nbsp;<a href="javascript:movetoPage(<s:property value="page.pageNo + 1" />, <s:property value="page.pageSize" />)" class="change2" />下页</a>&nbsp;&nbsp;<a href="javascript:movetoPage(<s:property value="page.pageCount" />, <s:property value="page.pageSize" />)" class="change2" />尾页</a>
				</s:else>
				&nbsp;&nbsp;&nbsp;&nbsp;每页行数&nbsp;
				<select name="ps" id="ps" onChange="changePageSize(this)">
					<option value="1"<s:if test="1 == page.pageSize"> selected</s:if>>1</option>
		            <option value="10"<s:if test="10 == page.pageSize"> selected</s:if>>10</option>
		            <option value="20"<s:if test="20 == page.pageSize"> selected</s:if>>20</option>
		            <option value="50"<s:if test="50 == page.pageSize"> selected</s:if>>50</option>
	          	</select>
				&nbsp;&nbsp;转到第&nbsp;
				<s:select list="page.pageList" value="page.pageNo" onchange="gotoPage(this)" name="pn" id="pn">
				</s:select>&nbsp;页
          	</td>
		  </tr>
	</table>