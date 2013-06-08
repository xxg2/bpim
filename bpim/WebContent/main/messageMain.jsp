<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建设工程综合信息管理系统</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<script language="javascript" type="text/javascript" src="../js/common.js"></script>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
</head>
<body>
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">全部消息</h3>
<div id="messageMain">
	<ul style="height: 35px; width: 900px;">
		<li style="width: 60px;">选择</li>
		<li style="width: 100px">发件人</li>
		<li style="width: 80px">时间</li>
		<li style="width: 460px">内容</li>
		<li style="width: 100px">查看详情</li>
		<li style="width: 70px">操作</li>
	</ul>
	<s:if test="userMessages==null || userMessages.size()==0">
		<ul>
			<li style="width: 100px">
			<h3>没消息</h3>
			</li>
		</ul>
	</s:if> <s:else>
		<s:iterator value="userMessages" status="st">
			<ul style="height: 35px; width: 900px;" id="<s:property value='id'/>"
				style="height:6px;">
				<li style="width: 60px; height: 35px;"><input type="checkbox"
					name="deleteSign" id="<s:property value='id'/>"></li>
				<li style="width: 100px"><s:if test="readed==false">
					<p style="font-weight: bold;"><s:property value="senderName" /></p>
				</s:if><s:else>
					<s:property value="senderName" />
				</s:else></li>
				<li style="width: 80px"><s:if test="readed==false">
					<p style="font-weight: bold;"><s:date name="sendTime"
						format="yyyy-MM-dd" /></p>
				</s:if><s:else>
					<s:date name="sendTime" format="yyyy-MM-dd" />
				</s:else></li>
				<li style="width: 460px"><s:if test="readed==false">
					<p style="font-weight: bold;"><s:property value="messageContent" /></p>
				</s:if><s:else>
					<s:property value="messageContent" />
				</s:else></li>
				<li style="width: 100px"><input type="button" class="button"
					onclick="window.location.href = 'viewMessageDetail.do?id=<s:property value='id'/>'"
					style="width: 80px" value="查看详情"></li>
				<li style="width: 70px"><input type="button" class="button"
					onclick="deleteMessage(<s:property value='id'/>)" value="删除"></li>
			</ul>
		</s:iterator>
		<ul>
			<li><input type="button" class="button"  style="width: 90px"
				onclick="deleteCoupleMessage()" value="批量删除"></li>
		</ul>
		<ul>
			<jsp:include page="../common/pagination.jsp" flush="true">
				<jsp:param name="action_page" value="main/messageMain.do" />
			</jsp:include>
		</ul>
	</s:else>
</div>
</div>

 <!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>

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
function deleteCoupleMessage(){
	if(confirm("是否删除")){
		var checkBoxs = document.getElementsByName("deleteSign");
		var deleted = false;
		var ids = new Array();
		var i=0;
		for(var j=0;j<checkBoxs.length;j++){
			if(checkBoxs[j].checked){
				ids[i] = checkBoxs[j].id;
				deleted = true;
				i++;
			}
		}if(deleted){
			MessageService.deleteMessages(ids,deleteCoupleCallback);
		}else{
			alert("至少选择一条");
		}
	}
}
function deleteCoupleCallback(msg){
	alert("删除成功");
	location=location;
}
function deleteCallback(msg){
	alert(msg);
	location=location;
}
</script>
</html>