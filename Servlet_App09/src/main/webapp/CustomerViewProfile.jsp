<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="CustomerBean.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	CustomerBean cb = (CustomerBean)application.getAttribute("cbean");
	out.println("Profile belongs to : " + cb.getFirstName() + "<br>");

	out.println("Name     : " + cb.getFirstName() + " " + cb.getLastName() + "<br>");
	out.println("Gender   : " + cb.getGender() + "<br>");
	out.println("Address  : " + cb.getAddress() + "<br>");
	out.println("Email-Id : " + cb.getEmailId() + "<br>");
	out.println("Phone no : " + cb.getPhoneNumber() + "<br>");
	%>
	<a href="CustomerEdit">Edit Profile</a>
	<br>
	<br>
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
	<a href="checkRentedBill">Current Rented Car Bill</a>
	<br>
	<a href="checkallHistory">History</a>
	<br>
	<a href="Customerlogout">LogOut</a>
	<br>
	

</body>
</html>