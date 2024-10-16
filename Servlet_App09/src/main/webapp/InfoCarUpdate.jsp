<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="AdminBeanClass.*,InfoCarBean.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	//AdminBean abean = (AdminBean) session.getAttribute("abean");
	out.println(msg);
	//out.println("Profile belongs to : " + abean.getFirstName()+"<br>");
	%>
	<%@include file="InfoCarViewToAdmin.jsp"%>
</body>
</html>