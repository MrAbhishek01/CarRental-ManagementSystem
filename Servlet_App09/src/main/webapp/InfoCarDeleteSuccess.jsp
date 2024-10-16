<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="InfoCarBean.CarBean,java.util.*,AdminBeanClass.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	
	String msg=(String)request.getAttribute("msg");
	out.println(msg+"<br>");
	
	%>
	<a href="AdminLoginSuccess.jsp">Home</a>
	<br>
	<a href="InfoCarDetails.html">Add Car</a>
	<br>
	<a href="ViewCar">View Cars</a>
	<br>
	<a href="RentedCar">Rented Cars History</a>
	<br>
	<a href="Adminlogout">Logout</a>
</body>
</html>