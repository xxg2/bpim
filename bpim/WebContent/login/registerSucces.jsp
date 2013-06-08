<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>注册成功</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/register.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../dwr/engine.js'></script>  
<script type='text/javascript' src='../dwr/util.js'></script> 
<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script> 
</head>
<body>
<div id="main"><jsp:include page="loginHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h2 class="title">注册结果</h2>
<div id="registerTable">
<ul>
	<li><s:if test="userInfo.password!=''"><label class="lb">您的用户名</label></s:if></li>
	<li><label class="lb"><s:property value="userInfo.userName"/></label></li>
</ul>

<ul>
	<li><s:if test="userInfo.password!=''"><label class="lb">您的密码是</label></s:if></li>
	<li> <label class="lb"><s:property value="userInfo.password"/></label> </li>
	<li><s:if test="userInfo.password==''"><input type="button" class="button" style="width:80px"
		onclick="history.back();" value="重新注册" /></s:if></li>
	<li><input type="button" class="button" style="width:80px"
		onclick="window.location.href ='../index.jsp';" value="返回首页" /></li>
</ul>
</div>


</div>

<jsp:include page="advertisement.jsp" />

<!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" />
</div>
</body>
<script type="text/javascript">


</script>
</html>
