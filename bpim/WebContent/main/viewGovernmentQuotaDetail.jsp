<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="javascript" type="text/javascript" src="../js/common.js">

</script>

</head>
<title>定额详情</title>
</head>
<body onload=";changeTitleBackground();">
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">定额详情</h3>
<h3 class="title"><s:property value="quota.governmentQuotaClass" />&nbsp;&nbsp;&nbsp;编号：<s:property value="quota.governmentQuotaNum" />&nbsp;&nbsp;&nbsp;名称：<s:property value="quota.governmentQuotaName" />&nbsp;&nbsp;&nbsp;单位：<s:property value="quota.governmentQuotaUnit" />&nbsp;&nbsp;&nbsp;数量：<s:property value="quota.governmentQuotaAmount" /><br>说明：<s:property value="quota.governmentQuotaDesc" /></h3>
<div class="searchResult" id="searchResult">
<ul>
	<li style="width: 50px">类型</li>
	<li style="width: 300px">名称</li>
	<li style="width: 100px">规格</li>
	<li style="width: 60px">单位</li>
	<li style="width: 60px">数量</li>
</ul>

	<s:iterator value="datas" status="st">
		<ul id="<s:property value='id'/>">
			<li style="width: 50px"><s:property value="recordType" /></li>
			<li style="width: 300px"><s:if
				test="%{null!=recordName&&recordName.length()>30}">
				<s:property value="recordName.substring(0, 29)+'...'" />
			</s:if> <s:else>
				<s:property value="recordName" />
			</s:else></li>
			<li style="width: 100px"><s:property value="recordModel" /></li>
			<li style="width: 60px"><s:property value="recordUnit" /></li>
			<li style="width: 60px"><s:property value='recordAmount' /></li>
		</ul>
	</s:iterator>
</div>
</div>

 <!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>

</body>
</html>