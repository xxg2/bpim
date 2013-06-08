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
<script type='text/javascript' src='../dwr/interface/ServicePlanService.js'></script>  
<script type='text/javascript' src='../dwr/engine.js'></script>  
<script type='text/javascript' src='../dwr/util.js'></script> 
<script type="text/javascript">

function getObject(id){
	return document.getElementById(id);
}
function checkError(){
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

<h2 class="title">政府指导价导入:</h2>
<div class="entry">

<s:form action="importGovernmentFile.do" method="post" name="importGovernmentFileForm" id="importGovernmentFileForm"  enctype="multipart/form-data">
	<ul> 
		<li style="width: 230px;">文件类别：<select id="fileType"
			name="fileType" style="width: 150px;" onchange="changeType();">
			<option value="0">--全部--</option>
			<option value="法律">法律</option>
			<option value="行政法规">行政法规</option>
			<option value="地方性法规和规章">地方性法规和规章</option>
			<option value="部门规章">部门规章</option>
			<option value="各类文件">各类文件</option>
		</select></li> 
		
		<li style="width: 230px; display:none" id="fileSubTypeLi">文件小类：<select id="fileSubType"
			name="fileSubType" style="width: 150px;" onchange="changeSubType()">
			<option value="0">--全部--</option>
			<option value="国务院">国务院</option>
			<option value="部委">部委</option>
			<option value="市政府">市政府</option>
			<option value="市建交委及相关部门">市建交委及相关部门</option>
		</select></li>
		
		<li style="width: 200px; display:none" id="proviceLi"><label class="lb">省：</label><select
			id="provice" name="provice" style="width: 150px;">
			<option value="0">---------请选择---------</option>
			<option value="北京市">北京市</option>
			<option value="上海市" selected="selected">上海市</option>
			<option value="天津市">天津市</option>
			<option value="重庆市">重庆市</option>
			<option value="河北省">河北省</option>
			<option value="山西省">山西省</option>
			<option value="内蒙古自治区">内蒙古自治区</option>
			<option value="辽宁省">辽宁省</option>
			<option value="吉林省">吉林省</option>
			<option value="黑龙江省">黑龙江省</option>
			<option value="江苏省">江苏省</option>
			<option value="浙江省">浙江省</option>
			<option value="安徽省">安徽省</option>
			<option value="福建省">福建省</option>
			<option value="江西省">江西省</option>
			<option value="山东省">山东省</option>
			<option value="河南省">河南省</option>
			<option value="湖北省">湖北省</option>
			<option value="湖南省">湖南省</option> 
			<option value="广东省">广东省</option>
			<option value="广西壮族自治区">广西壮族自治区</option>
			<option value="海南省">海南省</option>
			<option value="四川省">四川省</option>
			<option value="贵州省">贵州省</option>
			<option value="云南省">云南省</option>
			<option value="西藏自治区">西藏自治区</option>
			<option value="陕西省">陕西省</option>
			<option value="甘肃省">甘肃省</option>
			<option value="宁夏回族自治区">宁夏回族自治区</option>
			<option value="青海省">青海省</option>
			<option value="新疆维吾尔族自治区">新疆维吾尔族自治区</option>
			<option value="香港特别行政区">香港特别行政区</option>
			<option value="澳门特别行政区">澳门特别行政区</option>
			<option value="台湾省">台湾省</option>
			<option value="其它">其它</option>
		</select></li>
	</ul>
	<ul>
	<li><label class="lb">文件上传：</label></li>
	<li>
		<s:file name="importGovernmentFile"  id="importGovernmentFile" onchange="getObject('importGovernmentFileInput').value=this.value" />	
		<input type="text" class="file" name="importGovernmentFileInput" style="display:none"
		id="importGovernmentFileInput">	
		<!-- <input type="button" value="选择" class="button"
		onClick="getObject('uploadUserCustomDataFile').click()"> -->
	</li>
	</ul>
	<ul>
	<li><input type="button"
		onclick="submit();"
		class="button" style="width: 70px;" value="上传"></li>
</ul>
</s:form>


</div>
</div>

<div class="clr"></div>
</div>
</div>
<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
<script>


</script>
</html>