<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>意见反馈</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<script language="javascript" type="text/javascript"
	src="../js/common.js"></script>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type="text/javascript">
	function showMsg()
	{
		var msg='<s:property value="msg" />';
		if(msg)
		{
			alert(msg);
		}		
	}
</script>
</head>
<body onload="showMsg()">
	<div id="main"><jsp:include page="mainHeader.jsp" />
		<s:form	action="addUserAdvice.do" method="post" name="addUserAdviceForm" id="addUserAdviceForm">
			<div class="content">
				<div class="content_resize">
					<div class="mainbar">
						<h3>意见反馈</h3>
						<div class="adviceDiv">
							<textarea name="userAdvice.adviceContent"></textarea>
							<input type="submit" class="button" value="提交">
						</div>
					</div>
					<!-- end #content -->
					<div class="clr"></div>
				</div>
			</div>
		</s:form>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" />
    </div>

</body>
</html>