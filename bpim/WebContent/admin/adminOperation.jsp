<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理员管理界面</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/admin.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="javascript" type="text/javascript" src="../js/common.js"></script>
</head>
<body>
<div id="main"><jsp:include page="adminHeader.jsp" />
<s:form>
<div class="content">
<div class="content_resize">
<div class="mainbar">
	<div id="searchCondition">
		<ul>
			<li>
			<ul>
			
				<li><s:select name="selection"
					       list="#{'1':'过去一周','2':'过去一个月','3':'过去全部'}"
					       listKey="key"
					       listValue="value"
					       multiple="false"
					       onchange=""/>
				</li>
				<li>
				<input name="searchUserButton" type="submit" maxlength="10" id="searchUserButton" class="button" value="查询"></li>
			
				
			</ul>
			</li>
		</ul>
	</div>
<!-- end #sidebar -->

<div id="adminContent">
	<div class="searchResult">
	<h2 class="title">查询结果:</h2>
		<div class="entry">
			<table>
			<tr>
				<td style="width:180px;">用户名</td>
				<td style="width:180px">所在组</td>
				<td style="width:180px">充值金额</td>
				<td style="width:180px">充值时间</td>
				<td style="width:180px">过期日期</td>
			</tr>
			<s:if test="expenseRecords==null || expenseRecords.size()==0">
				<h2>没数据</h2>
			</s:if>
			<s:else>
			 	<s:iterator value="expenseRecords" status="st">
			    <tr>               
			      <td><s:hidden name="id" /><s:property value="userInfo.userName"/></td>
			      <td></td>
			      <td><s:text name="{0,number,###.00}"><s:param value="money"/></s:text></td>
			      <td><s:date name="payDateTmp" format="yyyy-MM-dd" /><s:hidden name="payDate" /></td>
			      <td><s:date name="expireDateTmp" format="yyyy-MM-dd" /><s:hidden name="expireDate" /></td>
			    </tr>
			    </s:iterator>
					<jsp:include page="../common/pagination.jsp" flush="true">
					  	<jsp:param name="action_page" value="admin/lister.do"/>
					</jsp:include>
			</s:else>
			</table>
		</div>
	</div>
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #content -->
</div>
</div>
</div>
</s:form>
<!-- end #page -->
<jsp:include page="../common/footer.jsp"></jsp:include>

</div>
<!-- end #footer -->
</body>
</html>