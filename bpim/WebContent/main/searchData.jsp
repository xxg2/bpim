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
		
		var fromYear = "<s:property value="fromYear"/>";
		if(fromYear!="")
		document.getElementById("fromYear").value=fromYear;
		var fromMonth = "<s:property value="fromMonth"/>";
		if(fromMonth!="")
		document.getElementById("fromMonth").value=fromMonth;
		var toMonth = "<s:property value="toMonth"/>";
		if(toMonth!="")
		document.getElementById("toMonth").value=toMonth;
		var toYear = "<s:property value="toYear"/>";
		if(toYear!="")
		document.getElementById("toYear").value=toYear;
		var projectName = "<s:property value="projectName"/>";
		if(projectName!="")
		document.getElementById("projectName").value=projectName;
		var quotaNum = "<s:property value="quotaNum"/>";
		if(quotaNum!="")
		document.getElementById("quotaNum").value=quotaNum;
		var quotaName = "<s:property value="quotaName"/>";
		if(quotaName!="")
		document.getElementById("quotaName").value=quotaName;
		var recordName = "<s:property value="recordName"/>";
		if(recordName!="")
		document.getElementById("recordName").value=recordName;
		var recordUnit = "<s:property value="recordUnit"/>";
		if(recordUnit!="")
		document.getElementById("recordUnit").value=recordUnit;
		var dataType = "<s:property value="dataType"/>";
		if(dataType!="")
		document.getElementById("dataType").value=dataType;
		var recordType = "<s:property value="recordType"/>";
		if(recordType!="")
		document.getElementById("recordType").value=recordType;
	}
</script>
</head>
<title>历史数据查询</title>
</head>
<body onload="setSearchValue();changeTitleBackground();">

<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">历史数据查询</h3>
<s:form
	action="searchUserProjectData.do" method="post"
	name="searchUserProjectData" id="searchUserProjectDataForm">
<div id="searchCondition">
		<ul>
			<li><label class="lb">从：</label><select id="fromYear" 
				name="fromYear" style="width: 90px;">
				<option value="0" selected="selected">--请选择--</option>
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
				name="fromMonth" style="width: 90px;">
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
			<li><label class="lb">到：</label><select id="toYear"
				name="toYear" style="width: 90px;">
				<option value="0" selected="selected">--请选择--</option>
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
				name="toMonth" style="width: 90px;">
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
			</select>月 &nbsp;&nbsp;&nbsp;</li>
			<li><label class="lb">数据类别：</label><select id="dataType"
				name="dataType">
				<option value="0" selected="selected">全部</option>
				<option value="预算">预算</option>
				<option value="决算">决算</option>
			</select></li>
		</ul>
		<ul>
			<li><label class="lb">项目名称：</label><input style="width: 140px"
				class="inputText" name="projectName" id="projectName"></li>
			<li><label class="lb">工料机类别：</label><select id="recordType"
				name="recordType">
				<option value="0" selected="selected">全部</option>
				<option value="材料">材料</option>
				<option value="人工">人工</option>
				<option value="机械">机械</option>
			</select></li>
			<li><label class="lb">定额编号：</label><input style="width: 60px"
				class="inputText" name="quotaNum" id="quotaNum"></li>
			<li><label class="lb">定额名称：</label><input style="width: 120px"
				class="inputText" name="quotaName" id="quotaName"></li>
		</ul>
		<ul>

			<li><label class="lb">工料机名称：</label><input
				style="width: 120px" class="inputText" name="recordName"
				id="recordName"></li>
			<li><label class="lb">单位：</label><input style="width: 40px"
				class="inputText" name="recordUnit" id="recordUnit"></li>
			<li><input name="searchUserButton" onclick="searchData()"
				type="button" id="searchButton" class="button" value="查询"></li>

		</ul>
</div>

<div class="searchResult">
<ul>
	<li style="width: 30px;"><input type="checkbox" onclick = "checkAllBox();"
				id="checkAll"></li>
	<li style="width: 60px">项目日期</li>
	<li style="width: 100px">项目名称</li>
	<li style="width: 80px">分部名称</li>
	<li style="width: 110px">定额编号</li>
	<li style="width: 250px">定额名称</li>
	<li style="width: 170px">工料机名称</li>
	<li style="width: 50px">查看详情</li>
	<li style="width: 50px">删除</li>

</ul>
<s:if test="datas==null || datas.size()==0">
</s:if> <s:else>
	<s:iterator value="datas" status="st">
		<ul id="<s:property value='id'/>">
			<li style="width: 30px;"><input type="checkbox" name="deleteSign"
				id="<s:property value='id'/>"></li>
			<li style="width: 60px"><s:date name="projectDate"
				format="yyyy-MM" /></li>
			<li style="width: 100px"><s:if
				test="%{null!=projectName&&projectName.length()>8}">
				<s:property value="projectName.substring(0, 7)+'...'" />
			</s:if> <s:else>
				<s:property value="projectName" />
			</s:else></li>
			<li style="width: 80px"><s:if
				test="%{null!=projectSubName&&projectSubName.length()>6}">
				<s:property value="projectSubName.substring(0, 5)+'...'" />
			</s:if> <s:else>
				<s:property value="projectSubName" />
			</s:else></li>
			<li style="width: 110px"><s:property value='governmentQuotaNum' /></li>
			<li style="width: 250px">
			<s:if
				test="%{null!=governmentQuotaName&&governmentQuotaName.length()>25}">
				<s:property value="governmentQuotaName.substring(0, 24)+'...'" />
			</s:if> <s:else>
				<s:property value="governmentQuotaName" />
			</s:else></li>
			<li style="width: 170px">
			<s:if
				test="%{null!=recordName&&recordName.length()>14}">
				<s:property value="recordName.substring(0, 13)+'...'" />
			</s:if> <s:else>
				<s:property value="recordName" />
			</s:else></li>
			<li style="width: 50px"><a target="blank" href="viewProjectDataDetail.do?id=<s:property value='id'/>">查看</a></li>
			<li style="width: 50px"><input type="button" class="button"
				onclick="deleteData(<s:property value='id'/>)" value="删除"></li>

		</ul>
	</s:iterator>
	<ul>
	<jsp:include page="../common/pagination.jsp" flush="true">
		<jsp:param name="action_page" value="main/searchUserProjectData.do"/>
	</jsp:include>
	</ul>
	<ul>
			<li><input type="button" class="button"  style="width: 90px"
			onclick="deleteCoupleDatas()" value="批量删除"></li>
		</ul>
</s:else></div>
</s:form>
</div>

 <!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>

</body>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/ProjectDataService.js'></script>
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
		document.getElementById("searchUserProjectDataForm").submit();
	}
	function deleteData(id){
		if(confirm("是否删除？")){
			ProjectDataService.deleteData(id,deleteCallback);
			var ul = document.getElementById(id);
			var parent = ul.parentNode;
			parent.removeChild(ul);
		}
	}
	function deleteCallback(msg){
		alert(msg);
		document.getElementById("searchUserProjectDataForm").submit();
	}
	function deleteCoupleDatas(){
		if(confirm("是否删除")){
			var checkBoxs = document.getElementsByName("deleteSign");
			var lenght = checkBoxs.length;
			var deleted = false;
			var ids = new Array();
			var i=0;
			for(var j=0;j<lenght;j++){
				if(checkBoxs[j].checked){
					ids[i] = checkBoxs[j].id;
					deleted = true;
					i++;
				}
			}if(deleted){
				ProjectDataService.deleteDatas(ids,deleteCoupleCallback);
			}else{
				alert("至少选择一条");
			}
		}
	}
	function deleteCoupleCallback(msg){
		alert("删除成功");
		document.getElementById("searchUserProjectDataForm").submit();
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