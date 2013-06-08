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
<title>用户密码修改</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type="text/javascript">
function checkError(){
	document.getElementById("currentPassword").value = null;
	document.getElementById("password").value = null;
	document.getElementById("passwordConfirm").value = null;
	var msg = "<s:property value='msg'/>";
	if(msg!=null && msg!=""){
		alert(msg);
		window.location.href = 'userInfoManage.do'
	}
}
</script>
</head>
<body onload="checkError(); changeTitleBackground();">
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">密码修改</h3>
<form action="changePassword.do" name="changePasswordForm" method="post" id="changePasswordForm">
<div id="userInfoTable">
<ul>
	<li><label class="lb">当前密码:</label></li>
	<li><input name="currentPassword" maxlength="10" id="currentPassword" type="password"
		 /></li>
</ul>
<ul>
	<li><label class="lb">新&nbsp;&nbsp;密&nbsp;&nbsp;码:</label></li>
	<li><input name="password" maxlength="10" id="password" type="password"
		 /></li>
</ul>
<ul>
	<li><label class="lb">确认密码:</label></li>
	<li><input name="passwordConfirm" maxlength="10" id="passwordConfirm"  type="password"
		 /></li>
</ul>
<ul>
<li><input type="button" 
	onclick="changePassword()" class="button" value="确定" style="width:100px;"> </li>
</ul>
</div>

</form>


</div>



<!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" />
</div>

</body>
<script type="text/javascript">
function changePassword(){
	var regExp=/^[0-9a-zA-Z-]+$/;
	var password = document.getElementById("password").value;
	if(password==null||password==""){
		alert("密码不能为空");
		return removePassword();
	}
	if(password.length<6||password.length>10){
		alert("密码必须在6到10位之间");
		return removePassword();
	}
	if(!regExp.test(password)){
		alert("密码只能输入字母数字");
		return removePassword();
	}
	var passwordConfirm = document.getElementById("passwordConfirm").value;
	if(passwordConfirm==null||passwordConfirm==""){
		alert("确认密码不能为空");
		return removePassword();
	}
	if(passwordConfirm.length<6||passwordConfirm.length>10){
		alert("确认密码必须在6到10位之间");
		return removePassword();
	}
	if(!regExp.test(passwordConfirm)){
		alert("确认密码只能输入字母数字");
		return removePassword();
	}
	if(passwordConfirm!=password){
		alert("确认密码和密码不一致");
		return removePassword();
	}
	document.getElementById("changePasswordForm").submit();
}
 
</script>
</html>
