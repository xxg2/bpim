<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
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
<script language="javascript" type="text/javascript"
	src="../js/common.js"></script>
<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script>
<script type='text/javascript'
	src='../dwr/interface/ExpenseRecordService.js'></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script language="javascript">
function update(updateId){
	var obj = document.getElementById(updateId);
	var id = obj.children[0].childNodes[0].value;
	var servicePlanId = obj.children[6].childNodes[0].value;
	var data = {id:id, servicePlanId:servicePlanId};
	UserInfoService.update(data,callback);
}
function updatePassword(updateId){
	var obj = document.getElementById(updateId);
	var id = obj.children[0].childNodes[0].value;
	var data = {id:id};
	UserInfoService.updatePassword(data,callbackpass);
}
function insertRepenseRecord(updateId){
	var obj = document.getElementById(updateId);
	var servicePlanId = obj.children[6].childNodes[0].value;
	if(servicePlanId > 0) {
		var id = obj.children[0].childNodes[0].value;
		var data = {id:id, servicePlanId:servicePlanId};
		ExpenseRecordService.insertRepenseRecord(data,callbackexpense);
	} else {
		alert("请先选择充值套餐");
	}
}
function callbackexpense(msg){
	if(msg) {
		alert("充值成功");
	} else {
		alert("充值失败");
	}
    //dwr.util.setValue('result',msg);
}

function callbackpass(msg){
	if(msg) {
		alert("更新成功, 您的新密码是:"+msg);
	} else {
		alert("更新失败");
	}
    //dwr.util.setValue('result',msg);
}
function callback(msg){
	if(msg) {
		alert("更新成功");
	} else {
		alert("更新失败");
	}
    //dwr.util.setValue('result',msg);
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
}
</script>
</head>
<body>
<div id="main"><jsp:include page="adminHeader.jsp" /> <s:form>
	<div class="content">
	<div class="content_resize">
	<div class="mainbar">
	<div id="searchCondition">
	<ul>
		<li>
		<ul>
			<li><select id="category">
				<option value="2">全部用户</option>
				<option value="1">只有组长</option>
			</select></li>
			<li><label class="lb">用户名：</label><s:textfield name="userName"
				maxlength="10" /></li>
			<li><label class="lb">所在组名：</label><input name="groupName"
				maxlength="10" id="groupName"></li>
			<li><label class="lb">只查询过期用户：</label><s:checkbox
				name="checkExpire" /></li>
			<li><input name="searchUserButton" type="submit" maxlength="10"
				id="searchUserButton" class="button" value="查询"
				onclick="clearPage();"></li>
		</ul>
		</li>
	</ul>
	</div>
	<!-- end #searchCondition -->
	<div id="adminContent">
	<div class="searchResult">
	<h2 class="title">查询结果:</h2>
	<div class="entry">
	<table>
		<tr>
			<td style="width: 80px;">用户名</td>
			<td style="width: 120px">注册日期</td>
			<td style="width: 120px">过期日期</td>
			<td style="width: 150px">邮箱地址</td>
			<td style="width: 180px">所在公司</td>
			<td style="width: 90px">手机号</td>
			<td style="width: 70px">选择套餐</td>
			<td style="width: 80px">初始化密码</td>
			<td style="width: 80px">用户充值</td>
			<td style="width: 70px">操作</td>
		</tr>
		<s:if test="userInfos==null || userInfos.size()==0">
			<tr>
				<td>
				<h3>没数据</h3>
				</td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="userInfos" status="st">
				<tr id="<s:property value='#st.index+1'/>">
					<td><s:hidden name="id" /><s:property value="userName" /></td>
					<td><s:date name="registerDateTmp" format="yyyy-MM-dd" /><s:hidden
						name="registerDate" /></td>
					<td><s:date name="expireDateTmp" format="yyyy-MM-dd" /><s:hidden
						name="expireDate" /></td>
					<td><s:property value="email" /></td>
					<td><s:property value="company" /></td>
					<td><s:property value="phone" /></td>
					<td><s:select name="servicePlanId" list="servicePlans"
						listKey="id" listValue="serviceName" multiple="false"
						required="true" onchange="" headerKey="0"
						headerValue="--请选择--" /></td>
					<td><input type="button" class="button"
						onclick='updatePassword(<s:property value="#st.index+1"/>);'
						value="初始化"></td>
					<td><input type="button" class="button"
						onclick='insertRepenseRecord(<s:property value="#st.index+1"/>);'
						value="充值"></td>
				</tr>
			</s:iterator>
			<jsp:include page="../common/pagination.jsp" flush="true">
				<jsp:param name="action_page" value="admin/listui.do" />
			</jsp:include>
		</s:else>
	</table>
	</div>
	</div>
	</div>
	<!-- end #adminContent -->
	<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>
</s:form> <!-- end #content --> <jsp:include page="../common/footer.jsp"></jsp:include>

</div>
<!-- end #footer -->
</body>
</html>
