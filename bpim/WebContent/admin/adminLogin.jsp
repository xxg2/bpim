<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>建设工程综合信息管理系统</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/index.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="JavaScript">
function getFocus()
{
    document.getElementById("idInput").focus();
}
</script>
</head>
<body onload="getFocus();">
<div id="main"><jsp:include page="../login/indexHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar"><s:form action="adminl.do" name="login"
	method="post" id="loginForm">
	<h2 class="title">用户登录</h2> 
	<div id= "loginbar">
	<ul>
		<li><label>用户名</label></li>
		<li><input name="userName" maxlength="10" id="idInput" tabindex="1"></li>
	</ul>
	<ul>
		<li><label>密 码</label></li>
		<li><input type="password" name="password" tabindex="2"><s:fielderror theme="Struts"><s:param>validateCode</s:param></s:fielderror></li>
	</ul> 
	<s:fielderror theme="Struts">
		<ul>
			<li><input type="submit" class="button" style="width:70px" value="登 录"></li>
		</ul>
		<s:param>name</s:param>
	</s:fielderror>
	</div>
</s:form></div>
<jsp:include page="../login/advertisement.jsp" />

<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">


</script>
</html>
