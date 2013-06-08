<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="javascript" type="text/javascript"
	src="../js/common.js">

</script>
<script type="text/javascript">
	function setSearchValue() {
		var provice = "<s:property value="condition.provice"/>";
		if(provice!="")
		document.getElementById("provice").value=provice;
		var fileType = "<s:property value="condition.fileType"/>";
		if(fileType!="")
		document.getElementById("fileType").value=fileType;
		var fileSubType = "<s:property value="condition.fileSubType"/>";
		if(fileSubType!="")
		document.getElementById("fileSubType").value=fileSubType;
		var filePublishYear = "<s:property value="condition.filePublishYear"/>";
		if(filePublishYear!="")
		document.getElementById("filePublishYear").value=filePublishYear;
		var filePublishMonth = "<s:property value="condition.filePublishMonth"/>";
		if(filePublishMonth!="")
		document.getElementById("filePublishMonth").value=filePublishMonth;
		var fileEffectiveYear = "<s:property value="condition.fileEffectiveYear"/>";
		if(fileEffectiveYear!="")
		document.getElementById("fileEffectiveYear").value=fileEffectiveYear;
		var fileEffectiveMonth = "<s:property value="condition.fileEffectiveMonth"/>";
		if(fileEffectiveMonth!="")
		document.getElementById("fileEffectiveMonth").value=fileEffectiveMonth;
		var fileName = "<s:property value="condition.fileName"/>";
		if(fileName!="")
		document.getElementById("fileName").value=fileName;
		var keyword = "<s:property value="condition.keyword"/>";
		if(keyword!="")
		document.getElementById("keyword").value= keyword;
		if(document.getElementById("fileType").value=="各类文件"){
			document.getElementById("fileSubTypeLi").style.display="BLOCK"; 
		}
		else if(document.getElementById("fileType").value=="地方性法规和规章"){
			document.getElementById("proviceLi").style.display="BLOCK";
		}else{
			document.getElementById("fileSubTypeLi").style.display="NONE";
			document.getElementById("proviceLi").style.display="NONE";
		}
		if(document.getElementById("fileSubType").value=="市建交委及相关部门"||document.getElementById("fileSubType").value=="市政府"||document.getElementById("fileSubType").value=="市建筑建材业管理部门"){
			document.getElementById("proviceLi").style.display="BLOCK";
		}else{
			document.getElementById("proviceLi").style.display="NONE";
		}
	}
	
	function clearPage(updateId){
		var ps = document.getElementById("ps");
		var pn = document.getElementById("pn");
		if(ps != null) {
			ps.options[1].selected = true;
		}
		if(pn != null) {
			pn.options[0].selected = true;
		}
		document.getElementById("searchGovernmentQuotaForm").submit();
	}
</script>
</head>
<title>文件查询</title>
</head>
<body onload="setSearchValue();changeTitleBackground();">
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize"><s:form
	action="searchGovernmentFile.do" method="post"
	name="searchGovernmentFileForm" id="searchGovernmentFileForm">
	<div class="mainbar">
	<h3 class="title">文件查询<img onmouseenter="displayHelp('helpDiv',searchGovernmentFileHelp)"
								onmouseleave="unDisplayHelp('helpDiv')"
								onmouseover="displayHelp('helpDiv',searchGovernmentFileHelp)"
								onmouseout="unDisplayHelp('helpDiv')" class="helpImg"
								src="../images/help.png">
							<div id="helpDiv" class="helpDiv"></div></h3>
	<div id="searchCondition">
	<ul>
		<li style="width: 160px;">发布时间：<select id="filePublishYear"
			name="condition.filePublishYear" style="width: 80px;">
			<option value="0">--请选择--</option>
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
		</select>年</li>
		<li style="width: 130px;"><label class="lb"></label><select
			id="filePublishMonth" name="condition.filePublishMonth"
			style="width: 90px;">
			<option value="0" selected="selected">--请选择--</option>
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
		</select>月</li>
		<li style="width: 160px;">生效时间：<select id="fileEffectiveYear"
			name="condition.fileEffectiveYear" style="width: 80px;">
			<option value="0">--请选择--</option>
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
		</select>年</li> 
		<li style="width: 140px;"><label class="lb"></label><select id="fileEffectiveMonth"
			name="condition.fileEffectiveMonth" style="width: 80px;">
			<option value="0" selected="selected">--请选择--</option>
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
		</select>月</li>
		<li style="width: 230px;">文件类别：<select id="fileType"
			name="condition.fileType" style="width: 150px;"
			onchange="changeType();">
			<option value="0">--全部--</option>
			<option value="法律">法律</option>
			<option value="行政法规">行政法规</option>
			<option value="地方性法规和规章">地方性法规和规章</option>
			<option value="部门规章">部门规章</option>
			<option value="各类文件">各类文件</option>
		</select></li>
	</ul>

<ul>
<li style="width: 230px; display: none" id="fileSubTypeLi">文件小类：<select
			id="fileSubType" name="condition.fileSubType" style="width: 150px;"
			onchange="changeSubType()">
			<option value="0">--全部--</option>
			<option value="国务院">国务院</option>
			<option value="部委">部委</option>
			<option value="市政府">市政府</option>
			<option value="市建交委及相关部门">市建交委及相关部门</option>
			<option value="市建筑建材业管理部门">市建筑建材业管理部门</option>
		</select></li>

		<li style="width: 200px; display: none" id="proviceLi"><label
			class="lb">省：</label><select id="provice" name="condition.provice"
			style="width: 150px;">
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
	

		
		<li><label class="lb">文件名：</label><input style="width: 160px"
			class="inputText" name="condition.fileName" id="fileName"></li>
		<li><label class="lb">关键字：</label><input style="width: 120px"
			class="inputText" name="condition.keyword" id="keyword"></li>
		<li><input name="searchButton" type="button" id="searchButton"
			onclick="searchGovernmentFile()" class="button" value="查询"></li>
	</ul>
	</div>

	<div class="searchResult" id="searchResult" style="margin-top: 15px;">
	<ul>
		<li style="width: 100px">文件类别</li>
		<li style="width: 120px">小类</li>
		<li style="width: 100px">地区</li>
		<li style="width: 360px">文件名</li>

		<li style="width: 90px">发布时间</li>
		<li style="width: 90px">生效时间</li>
		<li style="width: 50px">查看详情</li>
	</ul>
	<s:if test="datas==null || datas.size()==0">
	</s:if> <s:else>
		<s:iterator value="datas" status="st">
			<ul id="<s:property value='id'/>">
				<li style="width: 100px"><s:property value="fileType" /></li>
				<li style="width: 120px"><s:property value="fileSubType" /></li>
				<li style="width: 100px"><s:property value="area" /></li>
				<li style="width: 360px">
				<s:if
				test="%{null!=fileTitle&&fileTitle.length()>28}">
				<s:property value="fileTitle.substring(0, 27)+'...'" />
			</s:if> <s:else>
				<s:property value="fileTitle" />
			</s:else>
			</li>

				<li style="width: 90px"><s:date name="filePublishDate"
					format="yyyy-MM-dd" /></li>
				<li style="width: 90px"><s:date name="fileEffectiveDate"
					format="yyyy-MM-dd" /></li>
				<li style="width: 50px"><a target="blank" onclick="viewDetail(<s:property value="id" />)">查看</a></li>
			</ul>
		</s:iterator>
		<ul>
		<jsp:include page="../common/pagination.jsp" flush="true">
			<jsp:param name="action_page" value="main/searchGovernmentFile.do" />
		</jsp:include>
		</ul>
	</s:else></div>
	</div>
</s:form>  <!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>

</body>

<script type="text/javascript">
	function changeType(){
		if(document.getElementById("fileType").value=="各类文件"){
			document.getElementById("fileSubTypeLi").style.display="BLOCK"; 
		}
		else if(document.getElementById("fileType").value=="地方性法规和规章"){
			document.getElementById("proviceLi").style.display="BLOCK";
		}else{
			document.getElementById("fileSubTypeLi").style.display="NONE";
			document.getElementById("proviceLi").style.display="NONE";
		}
	}
	
	function changeSubType(){
		if(document.getElementById("fileSubType").value=="市建交委及相关部门"||document.getElementById("fileSubType").value=="市政府"){
			document.getElementById("proviceLi").style.display="BLOCK";
		}else{
			document.getElementById("proviceLi").style.display="NONE";
		}
	}
	function searchGovernmentFile(){
		
		document.getElementById("searchGovernmentFileForm").submit();
	}
	function getUniCodes(strDes){ 
		var res = ""; 
		for(var i = 0; i< strDes.length; i++){ 
		res += "\5" + strDes.charCodeAt(i) + ";"; 
		} 
		return res; 
		} 
	function viewDetail(id){
		var keyword = "<s:property value="condition.keyword"/>";
		keyword = getUniCodes(keyword);
		window.open("viewGovernmentFile.do?id="+id+"&keyword="+keyword);
	}
</script>
</html>