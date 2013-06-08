<%@ page contentType="image/jpeg" import="javax.imageio.ImageIO" %>
<%@ page import="com.bpim.helper.GenerateValidate" %>
<%@ page import="java.io.OutputStream" %>
<%
	OutputStream os = response.getOutputStream();
	GenerateValidate gen = new GenerateValidate(request);
	gen.genValidateImage(com.bpim.common.Constants.VALIDATE_IMG);
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);
	ImageIO.write(gen.getValidateImage(), "JPEG", os);
	os.flush();
	os.close();
	os = null;
	response.flushBuffer();
	out.clear();
	out = pageContext.pushBody();
%>
