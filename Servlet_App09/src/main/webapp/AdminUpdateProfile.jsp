<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="AdminBeanClass.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	String msg = (String) request.getAttribute("msg");
	out.println("Profile belongs to : " + ab.getFirstName() + "<br>");
	out.println(msg + "<br>");
	%>
	<a href="AdminProfile">View Profile</a>
	<br>
	<a href="Adminlogout">Logout</a>
	<br>
</body>
</html>