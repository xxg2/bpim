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

<script type="text/javascript">
	function setSearchValue() {
		var provice = "<s:property value="condition.provice"/>";
		if (provice != "")
			document.getElementById("provice").value = provice;
		var quotaNum = "<s:property value="condition.quotaNum"/>";
		if (quotaNum != "")
			document.getElementById("quotaNum").value = quotaNum;
		var quotaName = "<s:property value="condition.quotaName"/>";
		if (quotaName != "")
			document.getElementById("quotaName").value = quotaName;
		var quotaClass = "<s:property value="condition.quotaClass"/>";
		if (quotaClass != "")
			document.getElementById("quotaClass").value = quotaClass;
	}
	function clearPage(updateId) {
		var ps = document.getElementById("ps");
		var pn = document.getElementById("pn");
		if (ps != null) {
			ps.options[1].selected = true;
		}
		if (pn != null) {
			pn.options[0].selected = true;
		}
		document.getElementById("searchGovernmentQuotaForm").submit();
	}
</script>
</head>
<title>定额查询</title>
</head>
<body onload="setSearchValue();changeTitleBackground();">
	<div id="main"><jsp:include page="mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<s:form action="searchGovernmentQuota.do" method="post"
					name="searchGovernmentQuota" id="searchGovernmentQuotaForm">
					<div class="mainbar">
						<h3 class="title">
							定额查询<img onmouseenter="displayHelp('helpDiv',searchQuotaHelp)"
								onmouseleave="unDisplayHelp('helpDiv')"
								onmouseover="displayHelp('helpDiv',searchQuotaHelp)"
								onmouseout="unDisplayHelp('helpDiv')" class="helpImg"
								src="../images/help.png">
							<div id="helpDiv" class="helpDiv"></div>
						</h3>

						<div id="searchCondition">
							<ul>
								<li style="width: 200px;"><label class="lb">省：</label><select
									id="provice" name="condition.provice" style="width: 150px;">
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
								</select>
								</li>

								<li style="width: 150px;">定额类别：<select id="quotaClass"
									name="condition.quotaClass" style="width: 80px;">
										<option value="0">--请选择--</option>
										<option value="2000土建装饰">土建</option>
										<option value="2000园林">园林</option>
										<option value="2000市政">市政</option>
										<option value="2000安装">安装</option>
										<option value="2000公用">公用</option>
										<option value="2000水利">水利</option>
										<option value="2000人防">人防</option>
										<option value="2000房修">房修</option>
								</select>
								</li>

								<li><label class="lb">编号：</label><input style="width: 60px"
									class="inputText" name="condition.quotaNum" id="quotaNum">
								</li>
								<li><label class="lb">名称：</label><input
									style="width: 120px" class="inputText"
									name="condition.quotaName" id="quotaName">
								</li>
								<li><input name="searchButton" onclick="clearPage()"
									type="button" id="searchButton" class="button" value="查询">
								</li>
							</ul>
						</div>

						<div class="searchResult" id="searchResult"
							style="margin-top: 15px;">
							<ul>
								<li style="width: 100px">定额大类</li>
								<li style="width: 140px">分部工程名称</li>
								<li style="width: 100px">编号</li>
								<li style="width: 330px">名称</li>
								<li style="width: 60px">规格</li>
								<li style="width: 60px">单位</li>
								<li style="width: 60px">数量</li>
								<li style="width: 50px">查看详情</li>
							</ul>
							<s:if test="datas==null || datas.size()==0">
							</s:if>
							<s:else>
								<s:iterator value="datas" status="st">
									<ul id="<s:property value='id'/>">
										<li style="width: 100px"><s:property
												value="governmentQuotaClass" />
										</li>
										<li style="width: 140px"><s:property
												value="governmentQuotaType" />
										</li>
										<li style="width: 100px"><s:property
												value="governmentQuotaNum" />
										</li>
										<li style="width: 330px"><s:if
												test="%{null!=governmentQuotaName&&governmentQuotaName.length()>24}">
												<s:property
													value="governmentQuotaName.substring(0, 23)+'...'" />
											</s:if> <s:else>
												<s:property value="governmentQuotaName" />
											</s:else>
										</li>
										<li style="width: 60px"><s:property
												value="governmentQuotaModel" />
										</li>
										<li style="width: 60px"><s:property
												value="governmentQuotaUnit" />
										</li>
										<li style="width: 60px"><s:property
												value='governmentQuotaAmount' />
										</li>
										<li style="width: 50px"><a target="blank"
											href="viewGovernmentQuotaDetail.do?id=<s:property value='id'/>">查看</a>
										</li>
									</ul>
								</s:iterator>
								<ul>
									<jsp:include page="../common/pagination.jsp" flush="true">
										<jsp:param name="action_page"
											value="main/searchGovernmentQuota.do" />
									</jsp:include>
								</ul>
							</s:else>
						</div>
					</div>
				</s:form>

				<!-- end #content -->


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>

</body>
</html>