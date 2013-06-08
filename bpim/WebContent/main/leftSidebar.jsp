<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body >
<div id="leftPanel" class="leftPanel">
<ul>
	<li><h3 class="title">公共信息</h3></li>
	<li id="searchGovernmentQuota"><a href="searchGovernmentQuota.jsp">定额查询</a></li>
	<li id="searchGovernmentInventory"><a href="searchGovernmentInventory.jsp">清单查询</a></li>
	<li id="searchGovernmentFile"><a href="searchGovernmentFile.jsp">文件查询</a></li>
	<li id="searchGuidePriceData"><a href="searchGuidePriceData.jsp">指导价查询</a></li>
	<li><h3 class="title">个人数据</h3></li>
	<li id="templateDownload"><a href="templateDownload.jsp">下载模板</a></li>
	<li id="uploadData"><a  href="uploadData.jsp">历史数据导入</a></li>
	<li id="uploadCustomPriceData"><a href="uploadCustomPriceData.jsp">自定义价导入</a></li>
	<li id="searchData"><a href="searchData.jsp">历史数据管理</a></li>
	<li id="searchCustomPriceData"><a href="searchCustomPriceData.jsp">自定义价管理</a></li>
	<li><h3 class="title">数据分析</h3></li>
	<li id="personanlDataAnalyse"><a onclick="displaySubBar('personanlDataAnalyseSub')">个人数据分析</a>
		<div id="personanlDataAnalyseSub" style="display:none"> 
		<ul>
			<li id="personalQuotaAnalyse"><a href="personalQuotaAnalyse.jsp">定额分析</a></li>
			<li id="personalRecordAnalyse"><a href="personalRecordAnalyse.jsp">工料机价格分析</a></li>
		</ul>
		</div>
	</li>
		
	<!-- 
	<li><h3 class="title">组数据管理</h3></li>
	<li><a target="_self" href="#">组管理</a></li>
	<li><a target="_self" href="#">项目管理</a></li>
	<li><a target="_self" href="#">造价指标</a></li> -->
</ul>
</div>
</body>
<script type="text/javascript">
	function displaySubBar(id){
		var bar = document.getElementById(id);
		if(bar.style.display == "block"){
			bar.style.display = "none";
		}else{
			bar.style.display = "block";
		}
			
	}
</script>
</html>