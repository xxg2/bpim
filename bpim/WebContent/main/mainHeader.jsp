<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
int newMessageCount = 0;
String username = "";
if (session != null) {
	username = (String) session
			.getAttribute(Constants.LOGIN_USER_NAME);
	if(session.getAttribute(Constants.NEW_MESSAGE_COUNT)!= null){
		newMessageCount = (Integer) session.getAttribute(Constants.NEW_MESSAGE_COUNT);
	}
}
%>
<html>
<script language="javascript" type="text/javascript"
	src="../js/common.js"></script>
<script language="javascript" type="text/javascript"
	src="../js/displayHelp.js"></script>
<script type="text/javascript">
function changeTitleBackground(){
	if(<%=username%>==null||<%=username%>==""){
		var index = "<%=request.getContextPath()%>"+"/index.jsp";
		window.location.href = index;
	}
	 var sURL = window.location.href.toString();
	 var className= "active";
	 if(sURL.indexOf("userInfoManage")>0||sURL.indexOf("changePassword")>0){
		 document.getElementById("userInfoManage").className = className;
	 }else if(sURL.indexOf("rechargeMain")>0||sURL.indexOf("rechargeMain")>0){
		 document.getElementById("rechargeMain").className = className;
	 }else if(sURL.indexOf("messageMain")>0||sURL.indexOf("messageMain")>0){
		 document.getElementById("messageMain").className = className;
	 }else if(sURL.indexOf("index")>0||sURL.indexOf("messageMain")>0){
	 document.getElementById("index").className = className;
	}else if(sURL.indexOf("userAdvice")>0||sURL.indexOf("userAdvice")>0){
	 document.getElementById("userAdvice").className = className;
	}
	 
	 if(sURL.indexOf("templateDownload")>0||sURL.indexOf("templateDownload")>0){
		 document.getElementById("templateDownload").className = className;
	 }else if(sURL.indexOf("uploadData")>0||sURL.indexOf("uploadData")>0){
		 document.getElementById("uploadData").className = className;
	 }else if(sURL.indexOf("searchData")>0||sURL.indexOf("searchUserProjectData")>0){
		 document.getElementById("searchData").className = className;
	 }else if(sURL.indexOf("searchGovernmentQuota")>0||sURL.indexOf("searchGovernmentQuota")>0){
		 document.getElementById("searchGovernmentQuota").className = className;
	 }else if(sURL.indexOf("searchGovernmentInventory_2003")>0||sURL.indexOf("searchGovernmentInventory_2003")>0){
		 document.getElementById("searchGovernmentInventory_2003").className = className;
	 }else if(sURL.indexOf("searchGovernmentInventory_2008")>0||sURL.indexOf("searchGovernmentInventory_2008")>0){
		 document.getElementById("searchGovernmentInventory_2008").className = className;
	 }else if(sURL.indexOf("searchGovernmentFile")>0||sURL.indexOf("searchGovernmentFile")>0){
		 document.getElementById("searchGovernmentFile").className = className;
	 }else if(sURL.indexOf("uploadCustomPriceData")>0||sURL.indexOf("uploadCustomPriceData")>0){
		 document.getElementById("uploadCustomPriceData").className = className;  
	 }else if(sURL.indexOf("searchCustomPriceData")>0||sURL.indexOf("searchCustomData")>0){
		 document.getElementById("searchCustomPriceData").className = className;
	 }else if(sURL.indexOf("searchGuidePriceData")>0||sURL.indexOf("searchGuideData")>0){
		 document.getElementById("searchGuidePriceData").className = className;
	 }else if(sURL.indexOf("personalRecordAnalyse")>0||sURL.indexOf("personalRecordAnalyse")>0){
		 document.getElementById("personalRecordAnalyse").className = className;
	 }else if(sURL.indexOf("personalQuotaAnalyse")>0||sURL.indexOf("personalQuotaAnalyse")>0){
		 document.getElementById("personalQuotaAnalyse").className = className;
	 }
	 
	 
	 var messageCount = "<%=newMessageCount%>";
		if (messageCount > 0) {
			var message = document.getElementById("message");
			message.innerHTML = messageCount + "条新消息";
		}

	}
	function displayCategory(id) {
		document.getElementById(id).style.display = "BLOCK";
	}
	function unDisplayCategory(id) {
		document.getElementById(id).style.display = "NONE";
	}
</script>
<body onload="changeTitleBackground();">
	<div class="header">
		<div class="header_resize">
			<div class="nav_menu">
				<ul>
					<li id="userAdvice"><a href="userAdvice.jsp">用户反馈</a></li>
					<li id="backToMain"><a href="main.do">查看公告</a></li>
					<li id="userInfoManage"><a href="userInfoManage.do">用户管理</a></li>
					<!-- <li id="rechargeMain"><a href="rechargeMain.jsp">充值续费</a></li> -->
					<li id="messageMain"><a id="message" href="messageMain.do">消息</a>
					</li>
					<li id="help"><a href="../userGuide/user_guide.doc">用户手册</a></li>
					<li id="index"><a href="../login/logout.do">退出</a></li>
				</ul>
			</div>
			<div class="logo">
				<h1>
					建设工程综合信息管理系统
					<s:if test="#session.username != null">
						<small>欢迎您！尊敬的用户<s:property value="#session.username" />。您的有效期至<s:date
								name="#session.expireDate" format="yyyy年MM月dd日" /> </small>
					</s:if>
					<s:else>
						<small>尊敬的用户，您的用户登录超时，请重新登录。</small>
					</s:else>
				</h1>
			</div>
			<div class="categoryDiv">
				<ul class="category">
					<li onmouseenter="displayCategory('publicInfo');"
						onmouseleave="unDisplayCategory('publicInfo');"
						onmouseover="displayCategory('publicInfo');"
						onmouseout="unDisplayCategory('publicInfo');"><a>公共信息查询</a>
						<ul id="publicInfo" style="display: none">
							<li id="searchGovernmentQuota">	
								<a href="searchGovernmentQuota.jsp">定额查询 </a></li>
							<li id="searchGovernmentInventory_2003">
									<a href="searchGovernmentInventory_2003.jsp">2003清单查询</a></li>
							<li id="searchGovernmentInventory_2008"><a
								href="searchGovernmentInventory_2008.jsp">2008清单查询</a></li>
							<li id="searchGovernmentFile"><a
								href="searchGovernmentFile.jsp">文件查询</a></li>
							<li id="searchGuidePriceData"><a
								href="searchGuidePriceData.jsp">政府指导价查询</a></li>
						</ul>
					</li>
					<li onmouseenter="displayCategory('personData')"
						onmouseleave="unDisplayCategory('personData')"
						onmouseover="displayCategory('personData')"
						onmouseout="unDisplayCategory('personData')"><a>个人数据管理</a>
						<ul id="personData" style="display: none">
							<li id="templateDownload"><a href="templateDownload.jsp">下载模板</a>
							</li>
							<li id="uploadData"><a href="uploadData.jsp">历史数据导入</a></li>
							<li id="uploadCustomPriceData"><a
								href="uploadCustomPriceData.jsp">自定义价导入</a></li>
							<li id="searchData"><a href="searchData.jsp">历史数据管理</a></li>
							<li id="searchCustomPriceData"><a
								href="searchCustomPriceData.jsp">自定义价管理</a></li>
						</ul>
					</li>
					<li onmouseenter="displayCategory('personDataAnal')"
						onmouseleave="unDisplayCategory('personDataAnal')"
						onmouseover="displayCategory('personDataAnal')"
						onmouseout="unDisplayCategory('personDataAnal')"><a>数据分析</a>
						<ul id="personDataAnal" style="display: none">
							<li id="personalQuotaAnalyse"><a
								href="personalQuotaAnalyse.jsp">定额分析</a></li>
							<li id="personalRecordAnalyse"><a
								href="personalRecordAnalyse.jsp">工料机价格分析</a></li>
						</ul>
					</li>
					<li class="otherCategory"></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>