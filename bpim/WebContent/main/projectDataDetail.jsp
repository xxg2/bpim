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
<script language="javascript" type="text/javascript" src="../js/common.js"></script>
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
<h3 class="title">项目数据详情</h3>
<div id="detail">
<s:form action="modifyProjectData.do" method="post" name="modifyProjectData" id="modifyProjectDataForm">
	<ul>
	<li><label class="label1">项目名称</label></li>
	<li><label class="label3"><s:property value='data.projectName'/></label></li>
	<li><label class="label1">项目日期</label></li>
	<li><label class="label3"><s:date name="data.projectDate" format="yyyy-MM" /></label></li>
	<li><label class="label1">地区</label></li>
	<li><label class="label3"><s:property value='data.area'/></label></li>
	<li><label class="label1">数据类型</label></li>
	<li><label class="label3"><s:property value='data.dataType'/></label></li>
	<li><label class="label1">分部名称</label></li>
	<li><input type="text" id="projectSubName" name="data.projectSubName" value ="<s:property value='data.projectSubName'/>"></li>
	<li><label class="label1">定额编号</label></li>
	<li><input type="text" id="governmentQuotaNum" name="data.governmentQuotaNum" value ="<s:property value='data.governmentQuotaNum'/>"></li>
	<li><label class="label1">定额名称</label></li>
	<li><input type="text" id="governmentQuotaName" name="data.governmentQuotaName" value ="<s:property value='data.governmentQuotaName'/>"></li>
	<li><label class="label1">定额类型</label></li>
	<li><input type="text" id="governmentQuotaType" name="data.governmentQuotaType" value ="<s:property value='data.governmentQuotaType'/>"></li>
	<li><label class="label1">定额工程量</label></li>
	<li><input type="text" id="governmentQuotaGross" name="data.governmentQuotaGross" value ="<s:property value='data.governmentQuotaGross'/>"></li>
	<li><label class="label1">定额总价</label></li>
	<li><input type="text" id="governmentQuotaTotalPrice" name="data.governmentQuotaTotalPrice" value ="<s:property value='data.governmentQuotaTotalPrice'/>"></li>
	<li><label class="label1">数据编号</label></li>
	<li><input type="text" id="recordNum" name="data.recordNum" value ="<s:property value='data.recordNum'/>"></li>
	<li><label class="label1">工料机名称</label></li>
	<li><input type="text" id="recordName" name="data.recordName" value ="<s:property value='data.recordName'/>"></li>
	<li><label class="label1">定额类型</label></li>
	<li><input type="text" id="recordType" name="data.recordType" value ="<s:property value='data.recordType'/>"></li>
	<li><label class="label1">单位</label></li>
	<li><input type="text" id="recordUnit" name="data.recordUnit" value ="<s:property value='data.recordUnit'/>"></li>
	<li><label class="label1">单价</label></li>
	<li><input type="text" id="recordPrice" name="data.recordPrice" value ="<s:property value='data.recordPrice'/>"></li>
	<li><label class="label1">总量</label></li>
	<li><input type="text" id="recordTotalGross" name="data.recordTotalGross" value ="<s:property value='data.recordTotalGross'/>"></li>
	<li><label class="label1">总价</label></li>
	<li><input type="text" id="recordTotalPrice" name="data.recordTotalPrice" value ="<s:property value='data.recordTotalPrice'/>"></li>
	<li><label class="label1">数据导入时间</label></li>
	<li><label class="label3"><s:date name="data.recordImportDate" format="yyyy-MM-dd hh:mm:ss" /></label></li>
	<li><label class="label1">数据修改时间</label></li>
	<li><label class="label3"><s:date name="data.recordModifyDate" format="yyyy-MM-dd hh:mm:ss" /></label></li>
	<li><input type="hidden" style="width:120px;" name="data.id" value="<s:property value='data.id'/>"></li>
	<li><input type="hidden" style="width:120px;" name="data.projectDate" value="<s:date name="data.projectDate" />"></li>
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
 		var projectSubName = document.getElementById("projectSubName").value.trim();
 		if(""==projectSubName&&null==projectSubName){
 			alert("分部名称不能为空");
 			return false;
 		}
 		var governmentQuotaNum = document.getElementById("governmentQuotaNum").value.trim();
 		if(""==governmentQuotaNum&&null==governmentQuotaNum){
 			alert("定额编号不能为空");
 			return false;
 		}
 		var governmentQuotaName = document.getElementById("governmentQuotaName").value.trim();
 		if(""==governmentQuotaName&&null==governmentQuotaName){
 			alert("定额名称不能为空");
 			return false;
 		}
 		var governmentQuotaType = document.getElementById("governmentQuotaType").value.trim();
 		if(""==governmentQuotaType&&null==governmentQuotaType){
 			alert("定额类型不能为空");
 			return false;
 		}
 		var governmentQuotaGross = document.getElementById("governmentQuotaGross").value.trim();
 		if(""==governmentQuotaGross&&null==governmentQuotaGross){
 			alert("定额工程量不能为空");
 			return false;
 		}
 		var governmentQuotaTotalPrice = document.getElementById("governmentQuotaTotalPrice").value.trim();
 		if(""==governmentQuotaTotalPrice&&null==governmentQuotaTotalPrice){
 			alert("定额总价不能为空");
 			return false;
 		}
 		var recordNum = document.getElementById("recordNum").value.trim();
 		if(""==recordNum&&null==recordNum){
 			alert("数据编号不能为空");
 			return false;
 		}
 		var recordName = document.getElementById("recordName").value.trim();
 		if(""==recordName&&null==recordName){
 			alert("数据名称不能为空");
 			return false;
 		}
 		var recordType = document.getElementById("recordType").value.trim();
 		if(""==recordType&&null==recordType){
 			alert("定额类型不能为空");
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
 		var recordTotalGross = document.getElementById("recordTotalGross").value.trim();
 		if(""==recordTotalGross&&null==recordTotalGross){
 			alert("总量不能为空");
 			return false;
 		}
 		var recordTotalPrice = document.getElementById("recordTotalPrice").value.trim();
 		if(""==recordTotalPrice&&null==recordTotalPrice){
 			alert("总价不能为空");
 			return false;
 		}
 		document.getElementById("modifyProjectDataForm").submit();
 	}
</script>
</html>