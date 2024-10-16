<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="BillBeanClass.BillBean , InfoCarBean.CarBean,CustomerBean.CustomerBean, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
	out.println(msg + "<br>");
	out.println("Profile belongs to : " + cb.getFirstName() + "<br>");
	%>
	<a href="CustomerLoginSuccess.jsp">Home</a> 
	<br>
	<a href="CustomerProfile">View Profile</a>
	<br>
	<a href="ViewCarLocationWise.html">Book Or Check All Available Cars in Your Nearest Location</a>
	<br>
	<a href="ViewAvailableAllCars">Book Or Check All Available Cars</a>
	<br>
	<a href="CarReturn">Return Car</a>
	<br>
	<a href="checkallHistory">History</a>
	<br>
	<a href="Customerlogout">LogOut</a>
	<br>
</body>
</html>