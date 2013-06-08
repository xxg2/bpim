<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>密码找回</title>
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
<h2 class="title">密码找回</h2>
<div id="registerTable">
<ul>
	<li class="labelLi"><label>用户名</label></li>
	<li class="inputLi"><input name="username" maxlength="10" id="userName" /></li>
	<li><input type="button" class="button" style="width:50px"
		onclick="displayQuestion()" value="确定" /></li>
</ul>

<ul id="displayQuestion" style="display:none">
	<li class="labelLi"><label>问题</label></li>
	<li class="labelLi" id="showQuestion"></li>
</ul>

<ul id="displayAnswer" style="display:none">
	<li class="labelLi"><label class="lb">答案</label></li>
	<li class="inputLi"><input name="answer" maxlength="10" id="answer" /></li>
	<li><input type="button" class="button" style="width:100px"
		onclick="displayPassword()" value="初始化密码" /></li>
</ul>

<ul id="displayPassword" style="display:none">
	<li class="labelLi"><label>密码</label></li> 
	<li class="labelLi"><label id="newpass"></label></li>
	<li>请注意保存您的密码。下次登录将不再显示该密码</li>
</ul>
<ul style="display:none">
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
var user = "";
function displayQuestion(){
	
	var userName = document.getElementById("userName").value;
	user = userName;
	if(userName == null || userName == "") {
		alert("请输入用户名");
		return;
	}
	var data = {userName:userName};
	UserInfoService.getByName(data, callback);
	
}
function callback(msg){
	if(msg.question) {
		var question = document.getElementById("showQuestion");
		var displayQuestion = document.getElementById("displayQuestion");
		var displayAnswer = document.getElementById("displayAnswer");
		question.innerHTML = msg.question;
		displayQuestion.style.display = "block";
		displayAnswer.style.display = "block";
	} else {
		alert("未找到该用户，请重新输入");
	}
}
function displayPassword(){
	var answer = document.getElementById("answer").value;
	if(answer == null || answer == "") {
		alert("请回答您设置的答案");
		return;
	}
	var data = {userName:user,answer:answer};
	UserInfoService.initialPassword(data,callbackpass);
}
function callbackpass(msg){
	if(msg) {
		var newpass = document.getElementById("newpass");
		newpass.innerHTML = msg;
		var displayPassword = document.getElementById("displayPassword");
		displayPassword.style.display = "block";
	} else {
		alert("初始化失败");
	}
}


</script>
</html>
