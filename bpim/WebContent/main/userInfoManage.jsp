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
<title>用户信息修改</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type="text/javascript">
function checkError(){
	var msg = "<s:property value='msg'/>";
	if(msg!=null && msg!=""){
		alert(msg);
	}
}
</script>
</head>
<body onload="createCode(); changeTitleBackground(); checkError()">
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">用户信息修改</h3>
<form action="modifyUserInfo.do" name="modifyUserInfoForm" method="post" id="modifyUserInfoForm">
<div id="userInfoTable">
<ul>
	<li><label class="lb">用户名:</label></li>
	<li><label class="lb"><s:property value="userInfo.userName"/></label></li>
	<li><input type="hidden" name="userName" id="userName" value="<s:property value='userInfo.userName'/>"
		 /></li>
</ul>

<ul>
	<li><label class="lb">密码:</label></li>
	<li><input type="button" class="button" style="width:100px;" onclick="window.location.href ='changePassword.jsp';" value="修改密码"></li>
</ul>
<ul>
	<li><label class="lb">邮箱:</label></li>
	<li><input name="mailAddress"  id="mailAddress" value="<s:property value='userInfo.email'/>"
		 /></li>
</ul>
<ul>
	<li><label class="lb">公司:</label></li>
	<li><input name="company"   id="company" value="<s:property value='userInfo.company'/>"
		 /></li>
</ul>
<ul>
	<li><label class="lb">手机:</label></li>
	<li><input name="mobile"  id="mobile" value="<s:property value='userInfo.phone'/>"
		 /></li>
</ul>

<ul>
	<li><label class="lb">密码找回问题:</label></li>
	<li><input name="question"   id="question" value="<s:property value='userInfo.question'/>"
		 /></li>
</ul>

<ul>
	<li><label class="lb">密码找回答案:</label></li>
	<li><input name="answer"   id="answer" value="<s:property value='userInfo.answer'/>"
		 /></li>
</ul>


<ul>
<li><input type="button" 
	onclick="modifyUserInfo()" class="button" value="确定" style="width:100px;"> </li>
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
var code ; //在全局 定义验证码  
function createCode()  
{   
  code = "";  
  var codeLength = 4;//验证码的长度  
  var checkCode = document.getElementById("checkCode");  
  var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的     
  for(var i=0;i<codeLength;i++)  
  {  
   var charIndex = Math.floor(Math.random()*36);  
   code +=selectChar[charIndex];  
  }   
  if(checkCode)  
  {  
    checkCode.className="code";  
    checkCode.value = code;
    checkCode.blur();  
  }       
}    
function validate ()   {  
	  var inputCode = document.getElementById("validateCode").value;  
	  if(inputCode.length <=0)  
	  {  
	      alert("请输入验证码！");  
	  }  
	  else if(inputCode.toUpperCase() != code )  
	  {  
	     alert("验证码输入错误！");  
	     createCode();//刷新验证码  
	  }  
	  else  
	  {  
		  return true; 
	  }  
	}   

function displayProtocal(){
	var displayProtocal = document.getElementById("displayProtocal");
	displayProtocal.style.display = "block";
}

function modifyUserInfo(){
/*	if(!validate()){
		return false;
	}*/
	var mobileRegExp=/^[0-9]+$/;
	var mailAddress = document.getElementById("mailAddress").value;
	if(mailAddress.indexOf("@")<0){
		alert("邮箱格式不对");
		return false;
	}
	var mobile = document.getElementById("mobile").value;
	if(!mobileRegExp.test(mobile)){
		alert("电话号码只能包括数字");
		return false;
	}
	var question = document.getElementById("question").value;
	if(question==null){
		alert("问题不能为空");
		return false;
	}
	if(question.length>20){
		alert("问题不能超过20个字");
		return false;
	}
	var answer = document.getElementById("answer").value;
	if(answer==null){
		alert("答案不能为空");
		return false;
	}
	if(question.length>20){
		alert("答案不能超过20个字");
		return false;
	}
	document.getElementById("modifyUserInfoForm").submit();
}
</script>
</html>
