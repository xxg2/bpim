<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
<script language="javascript">
function update(updateId){
	if(confirm("是否更新")){
	var obj = document.getElementById(updateId);
	var id = obj.children[0].childNodes[0].value;
	var serviceName = obj.children[0].childNodes[1].value;
	var payDate = obj.children[1].childNodes[0].value;
	var money = obj.children[2].childNodes[0].value;
	var remark = obj.children[3].childNodes[0].value;
	var data = {id:id, serviceName:serviceName,money:money,payDate:payDate,remark:remark};
	ServicePlanService.update(data,callback);
	}
}
function insert(updateId){
	if(confirm("是否新增")){
	var obj = document.getElementById(updateId);
	//var id = obj.children[0].childNodes[0].value;
	var serviceName = obj.children[0].childNodes[0].value;
	var payDate = obj.children[1].childNodes[0].value;
	var money = obj.children[2].childNodes[0].value;
	var remark = obj.children[3].childNodes[0].value;
	var data = {serviceName:serviceName,money:money,payDate:payDate,remark:remark};
	ServicePlanService.insert(data,callback);
	}
}
var delId = 0;
function deleteData(deleteId){
	if(confirm("是否删除")){
	delId = deleteId;
	var obj = document.getElementById(deleteId);
	var id = obj.children[0].childNodes[0].value;
	var data = {id:id};
	ServicePlanService.deleteData(data,remove);
	}
}
function remove(msg) {
	if(msg) {
		alert("删除成功");
		location=location;
	} else {
		alert("删除失败");
	}
	/*if(msg) {
		var obj = document.getElementById(delId);
		obj.parentNode.removeChild(obj);
		alert("删除成功");
	}*/
}
function callback(msg){
	if(msg) {
		alert("更新成功");
		location=location;
	} else {
		alert("更新失败");
	}
    //dwr.util.setValue('result',msg);
}
</script>
<style>
.WithBreaks {
	word-wrap: break-word;
}
</style>
</head>
<body>
<div id="main"><jsp:include page="adminHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">


<div id="adminContent">

<h2 class="title">套餐修改:</h2>
<div class="entry">
<table id="tbody">
<tbody>
<tr>
	<td style="width:100px;">套餐名称</td>
	<td style="width:70px">套餐时间</td>
	<td style="width:70px">套餐金额</td>
	<td style="width:520px">套餐说明</td>
	<td style="width:50px">操作</td>
	<td style="width:50px">操作</td>
</tr>
<s:if test="servicePlans==null || servicePlans.size()==0">
		   <tr>
		     	<td><h3>没数据</h3></td>
		    </tr>
		</s:if>
		<s:else>
		 	<s:iterator value="servicePlans" status="st">
		    <tr id="<s:property value='#st.index+1'/>">
		      <td><s:hidden name="id"/><s:textfield name="serviceName" cssStyle="width:100px;"/></td>
		      <td><s:textfield name="payDate" cssStyle="width:70px;"/></td>
		      <td><input type="text" style="width:70px;" value="<s:text name="{0,number,###.00}"><s:param value="money"/></s:text>"></td>
		      <td><s:textfield name="remark" cssStyle="width:520px;"/></td>
		      <td><input type="button" class='button' onclick='update(<s:property value="#st.index+1"/>);' value="更新"></td>
		      <td><input type="button" class='button' onclick='deleteData(<s:property value="#st.index+1"/>);' value="删除"></td>
		    </tr>
		    </s:iterator>
		</s:else>
	</tbody>
</table>
<input type="button" style="width: 80px;" class="button"
	onclick="addNewScheme()" value="新增套餐"></div>

<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #content -->

</div>
</div>
</div>
<!-- end #page -->
<jsp:include page="../common/footer.jsp"></jsp:include>

</div>
<!-- end #footer -->
</body>
<script type="text/javascript">
function addNewScheme(){
  var tbody = document.getElementById("tbody");
  var tr = document.createElement("tr");
  var index = tbody.rows.length;
  tr.setAttribute("id", index);
  var td1 = document.createElement("td");
  td1.innerHTML = "<input type='text' style='width:100px;'>";
  var td2 = document.createElement("td"); 
  td2.innerHTML = "<input type='text' style='width:70px;'>";
  var td3 = document.createElement("td"); 
  td3.innerHTML = "<input type='text' style='width:70px;'>";
  var td4 = document.createElement("td"); 
  td4.innerHTML = "<input type='text' style='width:520px;'>";
  var td5 = document.createElement("td"); 
  td5.innerHTML = "<input type='button' class='button' onclick='insert("+index+");' value='新增'>";
  var td6 = document.createElement("td"); 
  td6.innerHTML = "<input type='button' class='button' onclick='deleteTr("+index+");' value='删除'>";
 
  tr.appendChild(td1); 
  tr.appendChild(td2);
  tr.appendChild(td3);
  tr.appendChild(td4);
  tr.appendChild(td5);
  tr.appendChild(td6);
  tbody.appendChild(tr);
}
function deleteTr(id){
	var tbody = document.getElementById("tbody");
	tbody.deleteRow(id);
}
</script>

</html>
