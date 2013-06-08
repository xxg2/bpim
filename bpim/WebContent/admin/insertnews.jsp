<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>公告信息</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/admin.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
</head>
<body>
<div id="main"><jsp:include page="../admin/adminHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<s:form action="insertnews.do" name="insertnews" method="post" id="insertnews">
	<div>
	<ul>
		<li class="labelLi"><label>标题:</label></li>
		<li class=""><s:textfield name="title" cssStyle="width:270px;" maxLength="100"/></li>
		<li><label class="comments">输入在100个字符以内</label></li>
	</ul>
	<ul>
		<li class="labelLi"><label>内容:</label></li>
		<li class=""><s:textarea name="content" cssStyle="width:270px;"/></li>
		<li></li>
	</ul>
	<ul>
		<li><s:submit cssClass="button" value="新增"/></li>
		<li><input type="button" class="button" value="返回" onclick="window.location.href = 'listnews.do'"></li>
	</ul>
	</div>
</s:form></div>
<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
</html>
