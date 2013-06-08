<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理员管理界面</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/admin.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="javascript" type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript">
 function checkError(msg){
	 var msg = "<s:property value='msg'/>";
		if(msg!=null && msg!=""){
			alert(msg);
		}
 }
</script>
<style>
.WithBreaks {
	word-wrap: break-word;
}
</style>
</head>
<body onload="checkError();changeTitleBackground();">
<div id="main"><jsp:include page="adminHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">


<div id="adminContent">

<h2 class="title">2000定额操作:</h2>
<div class="entry">
<ul>
	<li><input type="button"
		onclick="window.location.href ='deleteGovernmentQuota.do';"
		class="button" style="width: 70px;" value="删除"></li>
	<li><input type="button"
		onclick="window.location.href ='importGovernmentQuota.do';"
		class="button" style="width: 70px;" value="导入"></li>
</ul>

</div>
</div>

<div class="clr"></div>
</div>
</div>
<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>

</html>