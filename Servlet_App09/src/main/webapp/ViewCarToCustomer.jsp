<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="CustomerBean.CustomerBean,InfoCarBean.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
	ArrayList<CarBean> al = (ArrayList<CarBean>) session.getAttribute("al");
	out.println("Profile belongs to : " + cb.getFirstName()+"<br><br>");

	if (al.size() == 0) 
	{
		out.println("Car Not Available for the rent");
	} else 
	{
		Iterator<CarBean>it=al.iterator();
		while(it.hasNext()){
			CarBean carBean=(CarBean)it.next();
			 out.println(carBean.getCarNumber() + "&nbsp&nbsp"
	                 + carBean.getCarBrand() + "&nbsp&nbsp"
	                 + carBean.getCarModel() + "&nbsp&nbsp"
	                 + carBean.getCarRent_PER_DAY() + "&nbsp&nbsp"
	                 + carBean.getLocation() + "<br>"
	                 + "<a href='BookServlet?carNumber=" + carBean.getCarNumber() + "'>Book Car</a><br><br>");
		
		}
	}
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