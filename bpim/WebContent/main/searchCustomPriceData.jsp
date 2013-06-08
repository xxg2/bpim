<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="javascript" type="text/javascript" src="../js/common.js">

</script>
<script type="text/javascript">
	function setSearchValue() {
		var fromYear = "<s:property value="condition.fromYear"/>";
		if(fromYear!="")
		document.getElementById("fromYear").value=fromYear;
		var fromMonth = "<s:property value="condition.fromMonth"/>";
		if(fromMonth!="")
		document.getElementById("fromMonth").value=fromMonth;
		var toMonth = "<s:property value="condition.toMonth"/>";
		if(toMonth!="")
		document.getElementById("toMonth").value=toMonth;
		var toYear = "<s:property value="condition.toYear"/>";
		if(toYear!="")
		document.getElementById("toYear").value=toYear;
		var recordName = "<s:property value="condition.recordName"/>";
		if(recordName!="")
		document.getElementById("recordName").value=recordName;
		var recordUnit = "<s:property value="condition.recordUnit"/>";
		if(recordUnit!="")
		document.getElementById("recordUnit").value=recordUnit;
		var recordType = "<s:property value="condition.recordType"/>";
		if(recordType!="")
		document.getElementById("recordType").value=recordType;
		var recordCode = "<s:property value="condition.recordCode"/>";
		if(recordCode!="")
		document.getElementById("recordCode").value=recordCode;
		var recordUnit = "<s:property value="condition.recordUnit"/>";
		if(recordUnit!="")
		document.getElementById("recordUnit").value=recordUnit;
	}
</script>
</head>
<title>自定义价查询</title>
</head>
<body onload="setSearchValue();changeTitleBackground();">
<div id="main"><jsp:include page="mainHeader.jsp" />
<s:form	action="searchCustomData.do" method="post"
	name="searchCustomAndGuideDataForm" id="searchCustomAndGuideDataForm">
<div class="content">
<div class="content_resize">

<div class="mainbar">
<h3 class="title">自定义价查询</h3>
<div id="searchCondition">

		<ul>
			<li><label class="lb">从：</label><select id="fromYear" 
				name="condition.fromYear" style="width: 90px;">
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
			<li><label class="lb"></label><select id="fromMonth"
				name="condition.fromMonth" style="width: 90px;">
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
			</select>月</li>
			<li><label class="lb">到：</label><select id="toYear"
				name="condition.toYear" style="width: 90px;">
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
			<li><label class="lb"></label><select id="toMonth"
				name="condition.toMonth" style="width: 90px;">
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
			</select>月 &nbsp;&nbsp;&nbsp;</li>
			<li><input type="hidden" value="用户自定义价" name="condition.priceSourceType"></li>
		</ul>
		<ul>
			<li><label class="lb">工料机类别：</label><select id="recordType"
				name="condition.recordType">
				<option value="0" selected="selected">全部</option>
				<option value="材料">材料</option>
				<option value="人工">人工</option>
				<option value="机械">机械</option>
			</select></li>
			<li><label class="lb">编号：</label><input style="width: 60px"
				class="inputText" name="condition.recordCode" id="recordCode"></li>
			<li><label class="lb">工料机名称：</label><input
				style="width: 120px" class="inputText" name="condition.recordName"
				id="recordName"></li>
			<li><label class="lb">单位：</label><input style="width: 40px"
				class="inputText" name="condition.recordUnit" id="recordUnit"></li>
			<li><input name="searchUserButton" onclick="searchData()"
				type="button" id="searchButton" class="button" value="查询"></li>
		</ul>
</div>

<div class="searchResult" id="searchResult">
<ul>
	<li style="width: 30px;"><input type="checkbox" onclick = "checkAllBox();"
				id="checkAll"></li>
	<li style="width: 60px">时间</li>
	<li style="width: 75px">数据来源</li>
	<li style="width: 60px">类型</li>
	<li style="width: 60px">编码</li>
	<li style="width: 390px">名称</li>
	<li style="width: 50px">单位</li>
	<li style="width: 70px">单价</li>
	<li style="width: 50px">查看详情</li>
	<li style="width: 50px">删除</li>

</ul>
<s:if test="datas==null || datas.size()==0">
</s:if> <s:else>
	<s:iterator value="datas" status="st">
		<ul id="<s:property value='id'/>">
			<li style="width: 30px;"><s:if test="%{recordSource!='政府指导价'}" ><input type="checkbox" name="deleteSign"
				id="<s:property value='id'/>"></s:if></li>
			<li style="width: 60px"><s:date name="recordDate"
				format="yyyy-MM" /></li>
			<li style="width: 75px"><s:property value="recordSource" /></li>
			<li style="width: 60px"><s:property value="recordType" /></li>
			<li style="width: 60px"><s:property value="recordNum" /></li>
			<li style="width: 390px"><s:property value='recordName' /></li>
			<li style="width: 50px"><s:property value='recordUnit' /></li>
			<li style="width: 70px"><s:property value='recordPrice' /></li>
			<s:if test="%{recordSource!='政府指导价'}" ><li style="width: 50px"><a target="blank" href="viewCustomDataDetail.do?id=<s:property value='id'/>">查看</a>
			<li style="width: 50px"><input type="button" class="button"
				onclick="deleteData(<s:property value='id'/>)" value="删除"></li></s:if>

		</ul>
	</s:iterator>
	<ul>
				<jsp:include page="../common/pagination.jsp" flush="true">
				 	<jsp:param name="action_page" value="main/searchCustomData.do"/>
				</jsp:include>
				</ul>
		<ul>
			<li><input type="button" class="button"  style="width: 90px"
			onclick="deleteCoupleDatas()" value="批量删除"></li>
		</ul>
</s:else></div>
</div>

 <!-- end #content -->


<div class="clr"></div>
</div>
</div>
</s:form>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>

</body>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/CustomAndGuideDataService.js'></script>
<script type="text/javascript">
	function searchData(){
		var fromYear = document.getElementById("fromYear").value;
		var fromMonth = document.getElementById("fromMonth").value;
		var toYear = document.getElementById("toYear").value;
		var toMonth = document.getElementById("toMonth").value;
		var ps = document.getElementById("ps");
		var pn = document.getElementById("pn");
		if(fromMonth != 0&&fromYear==0){
			alert("请选择年之后在选择月份");
			return false;
		}
		if(toMonth != 0&&toYear==0){
			alert("请选择年之后在选择月份");
			return false;
		}
		if(ps != null) {
			ps.options[1].selected = true;
		}
		if(pn != null) {
			pn.options[0].selected = true;
		}
		document.getElementById("searchCustomAndGuideDataForm").submit();
	}
	function deleteData(id){
		if(confirm("是否删除？")){
			CustomAndGuideDataService.deleteCustomData(id,deleteCallback);
			var ul = document.getElementById(id);
			var parent = ul.parentNode;
			parent.removeChild(ul);
		}
	}
	function deleteCallback(msg){
		alert(msg);
		document.getElementById("searchCustomAndGuideDataForm").submit();
	}
	var ids = new Array();
	
	function deleteCoupleDatas(){
		if(confirm("是否删除")){
			var checkBoxs = document.getElementsByName("deleteSign");
			var lenght = checkBoxs.length;
			var deleted = false;
			var i=0;
			for(var j=0;j<lenght;j++){
				if(checkBoxs[j].checked){
					ids[i] = checkBoxs[j].id;
					deleted = true;
					i++;
				}
			}if(deleted){
				CustomAndGuideDataService.deleteCustomDatas(ids,deleteCoupleCallback);
			}else{
				alert("至少选择一条");
			}
		}
	}
	function deleteCoupleCallback(msg){
		alert("删除成功");
		document.getElementById("searchCustomAndGuideDataForm").submit();
	}
	
	function checkAllBox(){
		var checkAllBox = document.getElementById("checkAll");
		var checkBoxs = document.getElementsByName("deleteSign");
		var length = checkBoxs.length;
		for(var i=length;i--;){ 
			checkBoxs[i].checked = checkAllBox.checked;
		}
	}
</script>
</html>