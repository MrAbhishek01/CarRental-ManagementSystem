<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="CustomerBean.CustomerBean, BillBeanClass.BillBean, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
	ArrayList<BillBean> bill = (ArrayList<BillBean>) session.getAttribute("ShowBill");
	out.println("Profile Belongs to : " + cb.getFirstName() + "<br>");
	if (bill == null) {
		out.println("Currently Car Not Rented<br>");
	} else {
		Iterator<BillBean> it = bill.iterator();
		while (it.hasNext()) {
			BillBean billBean = it.next();
			out.println("Bill Number : " + billBean.getOrderbill() + "<br>");
			out.println("User-ID : " + billBean.getCustomerUserID() + "<br>");
			out.println("Number : " + billBean.getCustomerName() + "<br>");
			out.println("Mobil Number : " + billBean.getCustomerMobileNumber() + "<br>");
			out.println("Email-Id : " + billBean.getCustomerEmailId() + "<br>");
			out.println("Brand : " + billBean.getCarBrand() + "<br>");
			out.println("Model : " + billBean.getCarModel() + "<br>");
			out.println("Car Number : " + billBean.getCarNumber() + "<br>");
			out.println("Journey Start Date : " + billBean.getJourneyStartDate() + "<br>");
			out.println("Journey End Date : " + billBean.getJourneyEndDate() + "<br>");
			out.println("Total Days : " + billBean.getTotalDays() + "<br>");
			out.println("Status : " + billBean.getRentedStatus() + "<br>");
			out.println("Total bill : " + billBean.getTotalBill() + "<br>");
			out.println("<a href='ReturnRentedCar?CarNumber="+billBean.getCarNumber()+"'>Return Car</a><br><br>");
			
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