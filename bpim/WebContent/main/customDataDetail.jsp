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
<script language="javascript" type="text/javascript" src="../js/common.js"></script>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type="text/javascript">
	function checkError(){
		var msg = "<s:property value='msg'/>";
		if(""!=msg&&null!=msg){
			alert(msg);
		}
	}
</script>
</head>
<body onload="checkError();changeTitleBackground();">
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">自定义价详情</h3>
<div id="detail">
<s:form action="modifyCustomData" method="post" name="modifyCustomData" id="modifyCustomDataForm">
	<ul>
	<li><label class="label1">名称</label></li>
	<li><label class="label3"><s:property value='data.recordName'/></label></li>
	<li><label class="label1">日期</label></li>
	<li><input type="text" id="recordDate" name="recordDate" value ="<s:date name="data.recordDate" format="yyyy-MM" />"></li>
	<li><label class="label1">地区</label></li>
	<li><label class="label3"><s:property value='data.area'/></label></li>
	<li><label class="label1">类型</label></li>
	<li><label class="label3"><s:property value='data.recordType'/></label></li>
	<li><label class="label1">编号</label></li>
	<li><label class="label3"><s:property value='data.recordNum'/></label></li>
	<li><label class="label1">规格</label></li>
	<li><input type="text" id="recordModel" name="data.recordModel" value ="<s:property value='data.recordModel'/>"></li>
	<li><label class="label1">单位</label></li>
	<li><input type="text" id="recordUnit" name="data.recordUnit" value ="<s:property value='data.recordUnit'/>"></li>
	<li><label class="label1">单价</label></li>
	<li><input type="text" id="recordPrice" name="data.recordPrice" value ="<s:property value='data.recordPrice'/>"></li>
	<li><label class="label1">数量</label></li>
	<li><input type="text" id="recordGross" name="data.recordGross" value ="<s:property value='data.recordGross'/>"></li>
	<li><label class="label1">合价</label></li>
	<li><input type="text" id="recordTotalPrice" name="data.recordTotalPrice" value ="<s:property value='data.recordTotalPrice'/>"></li>
	<li><label class="label1">百分比</label></li>
	<li><input type="text" id="recordPercent" name="data.recordPercent" value ="<s:property value='data.recordPercent'/>"></li>
	<li><label class="label1">数据导入时间</label></li>
	<li><label class="label3"><s:date name="data.recordImportDate" format="yyyy-MM-dd hh:mm:ss" /></label></li>
	<li><label class="label1">数据修改时间</label></li>
	<li><label class="label3"><s:date name="data.recordModifyDate" format="yyyy-MM-dd hh:mm:ss" /></label></li>
	<li><input type="hidden" style="width:120px;" name="data.id" value="<s:property value='data.id'/>"></li>
</ul>
</s:form>
<ul>
	<li><input type="button" class="button" onclick="modifyData()" style="width:80px;" value="确定修改" ></li>
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
 	function modifyData(){
 		if(!confirm("是否修改")){
 			return false;
 		}
 		var recordDate =document.getElementById("recordDate").value.trim();
 		if(""==recordDate&&null==recordDate){
 			alert("日期不能为空");
 			return false;
 		}
 		var recordUnit = document.getElementById("recordUnit").value.trim();
 		if(""==recordUnit&&null==recordUnit){
 			alert("单位不能为空");
 			return false;
 		}
 		var recordPrice = document.getElementById("recordPrice").value.trim();
 		if(""==recordPrice&&null==recordPrice){
 			alert("单价不能为空");
 			return false;
 		}
 		var recordGross = document.getElementById("recordGross").value.trim();
 		if(""==recordGross&&null==recordGross){
 			alert("数量不能为空");
 			return false;
 		}
 		var recordTotalPrice = document.getElementById("recordTotalPrice").value.trim();
 		if(""==recordTotalPrice&&null==recordTotalPrice){
 			alert("总价不能为空");
 			return false;
 		}
 		document.getElementById("modifyCustomDataForm").submit();
 	}
</script>
</html>