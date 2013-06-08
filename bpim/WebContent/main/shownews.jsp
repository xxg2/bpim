<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>公告信息</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/register.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script>
</head>
<body onload="createCode();">
<div id="main"><jsp:include page="../login/loginHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
	<div id="registerTable">
	<h3 align="center"><s:hidden name="id" /><s:property value="title"/></h3>
	<h4 align="center"><s:date name="addTimeTemp" format="yyyy-MM-dd" /><s:hidden
			name="addTime" /></h4>
	<p><s:property value="content"/></p>
	<ul>
		<li></li>
		<li><input type="button" onclick="window.location.href = 'main.do'" value="返回"></li>
	</ul>
	</div>
</div>
<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
</html>
