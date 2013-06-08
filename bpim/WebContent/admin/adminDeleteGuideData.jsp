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

<h2 class="title">政府指导价删除:</h2>
<div class="entry">

<s:form action="deleteGuideData.do" method="post" name="deleteGuideDataForm" id="deleteGuideDataForm" >
	<ul>
	<li style="width:200px;"><label class="lb">省：</label><select id="provice" name="provice"
		style="width: 150px;">
		<option value="0">---------请选择---------</option>
		<option value="北京市">北京市</option>
		<option value="上海市">上海市</option>
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
	<li><label class="lb">年：</label><select id="year" 
				name="year" style="width: 90px;">
				<option value="0">--请选择--</option>
				<option value="1980">1980</option>
				<option value="1981">1981</option>
				<option value="1982">1982</option>
				<option value="1983">1983</option>
				<option value="1984">1984</option>
				<option value="1985">1985</option>
				<option value="1986">1986</option>
				<option value="1987">1987</option>
				<option value="1988">1988</option>
				<option value="1989">1989</option>
				<option value="1990">1990</option>
				<option value="1991">1991</option>
				<option value="1992">1992</option>
				<option value="1993">1993</option>
				<option value="1994">1994</option>
				<option value="1995">1995</option>
				<option value="1996">1996</option>
				<option value="1997">1997</option>
				<option value="1998">1998</option>
				<option value="1999">1999</option>
				<option value="2000">2000</option>
				<option value="2001">2001</option>
				<option value="2002">2002</option>
				<option value="2003">2003</option>
				<option value="2004">2004</option>
				<option value="2005">2005</option>
				<option value="2006">2006</option>
				<option value="2007">2007</option>
				<option value="2008">2008</option>
				<option value="2009">2009</option>
				<option value="2010">2010</option>
				<option value="2011">2011</option>
				<option value="2012">2012</option>
				<option value="2013">2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
				<option value="2020">2020</option>
			</select></li>
			<li><label class="lb">月：</label><select id="month"
				name="month" style="width: 90px;">
				<option value="0">--请选择--</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select></li>
	</ul>
	<ul>
	<li><input type="button"
		onclick="deleteData();"
		class="button" style="width: 70px;" value="删除"></li>
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
function deleteData(){
	if(validate()){
		document.getElementById("deleteGuideDataForm").submit();
	}
}

function validate(){
	
	var provice = document.getElementById("provice").value;
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	if(provice == 0){
		alert("请选择地区");
		return false;
	}
	if(year == 0||month==0){
		alert("请选择具体日期");
		return false;
	}
	return true;
}

</script>
</html>