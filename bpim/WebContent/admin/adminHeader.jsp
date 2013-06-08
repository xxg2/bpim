<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bpim.common.Constants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String username = "";
if (session != null) {
	username = (String) session
			.getAttribute(Constants.ADMIN_LOGIN_USER_NAME);
}
%>
<html>
<script type="text/javascript">
function changeTitleBackground(){
	if(<%=username%>==null||<%=username%>==""){
		var index = "<%=request.getContextPath()%>"+"/admin/adminLogin.jsp";
		window.location.href = index;
	}
	 var sURL = window.location.href.toString();
	 var className= "active";
	 if(sURL.indexOf("listui.do")>0||sURL.indexOf("adminUser")>0){
		 document.getElementById("adminUser").className = className;
	 }else if(sURL.indexOf("adminOperation")>0||sURL.indexOf("lister")>0){
		 document.getElementById("adminOperation").className = className;
	 }else if(sURL.indexOf("listsp.do")>0||sURL.indexOf("adminScheme")>0){
		 document.getElementById("adminScheme").className = className;
	 }else if(sURL.indexOf("adminGovernmentGuidePriceImport")>0||sURL.indexOf("uploadGuideData")>0){
		 document.getElementById("adminGovernmentGuidePriceImport").className = className;
	 }else if(sURL.indexOf("adminDeleteGuideData")>0||sURL.indexOf("deleteGuideData")>0){
		 document.getElementById("adminDeleteGuideData").className = className;
	 }else if(sURL.indexOf("importGovernmentQuota")>0||sURL.indexOf("governmentQuotaOperating")>0||sURL.indexOf("deleteGovernmentQuota")>0||sURL.indexOf("importGovernmentQuota")>0 ){
		 document.getElementById("governmentQuotaOperating").className = className;
	 }else if(sURL.indexOf("adminGovernmentFileImport")>0||sURL.indexOf("importGovernmentFile")>0){
		 document.getElementById("adminGovernmentFileImport").className = className;
	 }else if(sURL.indexOf("listua.do")>0||sURL.indexOf("adminUserAdvice")>0){
		 document.getElementById("adminUserAdvice").className = className;
	 }
}
</script>
<body onload="changeTitleBackground();">
<div class="header">
    <div class="header_resize">
      <div class="nav_menu">
		<ul>
			<li id="adminUser"><a href="listui.do">用户操作</a></li>
			<li id="adminOperation"><a href="lister.do">充值查询</a></li>
			<li id="adminScheme"><a href="listsp.do">套餐修改</a></li>
			<li id="adminScheme"><a href="listnews.do">消息发布</a></li>
			<li id="adminGovernmentGuidePriceImport"><a href="adminGovernmentGuidePriceImport.jsp">政府指导价导入</a></li>
			<li id="adminDeleteGuideData"><a href="adminDeleteGuideData.jsp">政府指导价删除</a></li>
			<li id="governmentQuotaOperating"><a href="governmentQuotaOperating.jsp">2000定额操作</a></li>
			<li id="adminGovernmentFileImport"><a href="adminGovernmentFileImport.jsp">政府文件导入</a></li>
			<li id="adminUserAdvice"><a href="listua.do">用户反馈</a></li>
		 </ul>
      </div>
      <div class="logo"><h1>建设工程综合信息管理系统<small></small></h1></div>
    </div>
  </div>
</body>
</html>