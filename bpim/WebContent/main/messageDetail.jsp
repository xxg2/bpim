<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建设工程综合信息管理系统</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
</head>
<body>
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">消息详情</h3>
<div id="detail">
	<ul>
	<li><label class="label1">发件人:</label></li>
	<li><label class="label2"><s:property value="userMessage.senderName"/></label></li>
</ul>
<ul>
	<li><label class="label1">时间:</label></li>
	<li><label class="label2"><s:date name="userMessage.sendTime" format="yyyy-MM-dd" /></label></li>
</ul>
<ul>
	<li><label class="label1">内容:</label></li>
	<li><label class="label2"><s:property value="userMessage.messageContent"/></label></li>
</ul>
<ul>
	<li><input type="button" style="width:60px;" class="button" onclick="window.location.href = 'messageMain.do'" value="返回" ></li>
	<li><input type="button" style="width:60px;" class="button" onclick="deleteMessage(<s:property value='userMessage.id'/>)" value="删除" ></li>
</ul>
	
</div>
</div>



<!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" />
</div>

</body>
<script type='text/javascript' src='../dwr/engine.js'></script>  
<script type='text/javascript' src='../dwr/util.js'></script> 
<script type='text/javascript' src='../dwr/interface/MessageService.js'></script> 
<script type="text/javascript">
function deleteMessage(id){
	if(confirm("是否删除？")){
		MessageService.deleteMessage(id,deleteCallback);
	}
	
}
function deleteCallback(msg){
	alert(msg);
	window.location.href = "messageMain.do";
}
</script>
</html>