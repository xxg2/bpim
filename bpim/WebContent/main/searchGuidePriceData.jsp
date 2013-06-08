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
		var quotaClass = "<s:property value="condition.quotaClass"/>";
		if(quotaClass!="")
		document.getElementById("quotaClass").value=quotaClass;
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
<title>政府指导价查询</title>
</head>
<body onload="setSearchValue();changeTitleBackground();">
	<div id="main"><jsp:include page="mainHeader.jsp" />
		<s:form action="searchGuideData.do" method="post"
			name="searchCustomAndGuideDataForm" id="searchCustomAndGuideDataForm">
			<div class="content">
				<div class="content_resize">

					<div class="mainbar">
						<h3 class="title">政府指导价查询<img onmouseenter="displayHelp('helpDiv',searchGuideDataHelp)"
								onmouseleave="unDisplayHelp('helpDiv')"
								onmouseover="displayHelp('helpDiv',searchGuideDataHelp)"
								onmouseout="unDisplayHelp('helpDiv')" class="helpImg"
								src="../images/help.png">
							<div id="helpDiv" class="helpDiv"></div></h3>
						<div id="searchCondition">
							<ul>
								<li><label class="lb">从：</label><select id="fromYear"
									name="condition.fromYear" style="width: 90px;">
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
								<li style="margin-left: 40px;"><label class="lb">到：</label><select
									id="toYear" name="condition.toYear" style="width: 90px;">
										<option value="0">--请选择--</option>
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
								<li><input type="hidden" value="政府指导价"
									name="condition.priceSourceType">
								</li>
							</ul>
							<ul>
								<li style="width: 150px;">专业类别：<select id="quotaClass"
									name="condition.quotaClass" style="width: 80px;">
										<option value="0">--请选择--</option>
										<option value="土建">土建</option>
										<option value="市政">市政</option>
										<option value="公用">公用</option>
										<option value="水利">水利</option>
										<option value="人防">人防</option>
										<option value="房修">房修</option>
								</select>
								</li>
								<li><label class="lb">工料机类别：</label><select id="recordType"
									name="condition.recordType">
										<option value="0" selected="selected">全部</option>
										<option value="材料">材料</option>
										<option value="人工">人工</option>
										<option value="机械">机械</option>
								</select>
								</li>
								<li style="margin-left: 40px;"><label class="lb">编号：</label><input
									style="width: 60px" class="inputText"
									name="condition.recordCode" id="recordCode">
								</li>
								<li style="margin-left: 40px;"><label class="lb">工料机名称：</label><input
									style="width: 120px" class="inputText"
									name="condition.recordName" id="recordName">
								</li>
								<li style="margin-left: 40px;"><label class="lb">单位：</label><input
									style="width: 40px" class="inputText"
									name="condition.recordUnit" id="recordUnit">
								</li>
								<li style="margin-left: 40px;"><input
									name="searchUserButton" onclick="searchData()" type="button"
									id="searchButton" class="button" value="查询">
								</li>
							</ul>
						</div>

						<div class="searchResult" id="searchResult">
							<ul>
								<li style="width: 100px">时间</li>
								<li style="width: 115px">专业</li>
								<li style="width: 100px">类型</li>
								<li style="width: 280px">名称</li>
								<li style="width: 120px">单位</li>
								<li style="width: 80px">单价</li>

							</ul>
							<s:if test="datas==null || datas.size()==0">
							</s:if>
							<s:else>
								<s:iterator value="datas" status="st">
									<ul id="<s:property value='id'/>">
										<li style="width: 100px"><s:date name="recordDate"
												format="yyyy-MM" />
										</li>
										<li style="width: 115px"><s:property value="quotaClass" />
										</li>
										<li style="width: 100px"><s:property value="recordType" />
										</li>
										<li style="width: 280px"><s:property value='recordName' />
										</li>
										<li style="width: 120px"><s:property value='recordUnit' />
										</li>
										<li style="width: 80px"><s:property value='recordPrice' />
										</li>
										<s:if test="%{recordSource!='政府指导价'}">
											<li style="width: 50px"><a target="blank"
												href="viewCustomDataDetail.do?id=<s:property value='id'/>">查看</a>
											</li>
											<li style="width: 50px"><input type="button"
												class="button"
												onclick="deleteData(<s:property value='id'/>)" value="删除">
											</li>
										</s:if>

									</ul>
								</s:iterator>
								<ul>
									<jsp:include page="../common/pagination.jsp" flush="true">
										<jsp:param name="action_page" value="main/searchGuideData.do" />
									</jsp:include>
								</ul>
							</s:else>
						</div>
					</div>

					<!-- end #content -->


					<div class="clr"></div>
				</div>
			</div>
		</s:form>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>

</body>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript'
	src='../dwr/interface/CustomAndGuideDataService.js'></script>
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
	}
	function deleteCoupleDatas(){
		if(confirm("是否删除")){
			var checkBoxs = document.getElementsByName("deleteSign");
			var lenght = checkBoxs.length;
			var deleted = false;
			for(var j=0;j<lenght;j++){
				if(checkBoxs[j].checked){
					CustomAndGuideDataService.deleteCustomData(checkBoxs[j].id,deleteCoupleCallback);
					var ul = document.getElementById(checkBoxs[j].id);
					//var parent = ul.parentNode;
					//parent.removeChild(ul);
					ul.style.display = "none";
					deleted = true;
				}
			}if(deleted){
				alert("删除成功");
			}else{
				alert("至少选择一条");
			}
		}
	}
	function deleteCoupleCallback(msg){
		
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