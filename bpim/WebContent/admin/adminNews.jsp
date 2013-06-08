<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理员管理界面</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/admin.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="javascript" type="text/javascript" src="../js/common.js"></script>
</head>
<body>
<div id="main"><jsp:include page="adminHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar"></div>
<div class="adminContent">
<div class="entry">
			<table>
			<tr>
				<td style="width:520px;"><s:form action="insertnews.jsp"><input type="submit" class="button" value="新增"></s:form></td>
				<td style="width:180px"></td>
				<td style="width:200px"></td>
			</tr>
			<tr>
				<td style="width:520px;">标题</td>
				<td style="width:180px">创建时间</td>
				<td style="width:200px">操作</td>
			</tr>
			<s:if test="newsAnnounces==null || newsAnnounces.size()==0">
			</s:if>
			<s:else>
			 	<s:iterator value="newsAnnounces" status="st">
			    <tr>
			      <td><s:hidden name="id" /><a href="getnews.do?id=<s:property value="id" />"><s:property value="newsTitle"/></a></td>
			      <td><s:date name="addTimeTemp" format="yyyy-MM-dd" /><s:hidden name="addTime" /></td>
			      <td><form action="deletenews.do" id='<s:property value='id'/>' ><s:hidden name="id" /><input type="button" onclick="deleteNews(<s:property value='id'/>);" class="button" value="删除"></form></td>
			    </tr>
			    </s:iterator>
			</s:else>
			</table>
		</div>
</div>
</div>
<!-- end #content -->
</div>
</div>
<!-- end #page -->
<jsp:include page="../common/footer.jsp"></jsp:include>

<!-- end #footer -->
</body>
<script type="text/javascript">
	function deleteNews(id){
		if(confirm("是否删除?")){
			document.getElementById(id).submit();
		}
	}
</script>
</html>