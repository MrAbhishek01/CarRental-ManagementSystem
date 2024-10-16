<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="InfoCarBean.CarBean,java.util.*,CustomerBean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
	CarBean carBean = (CarBean) session.getAttribute("car");
	out.println("ProfileBelongs to : " + cb.getFirstName());
	
	
	%>
	<form action="checkBill" method="post">
		<table>
			<tr>
				<td><label>Name</label></td>
				<td><input type="text" name="customerName" value=<%=cb.getFirstName()+cb.getLastName() %>></td>
			</tr>
			<tr>
				<td><label>Phone No.</label></td>
				<td><input type="text" name="customernumber" value=<%=cb.getPhoneNumber()%>></td>
			</tr>

			<tr>
				<td><label>Email-Id</label></td>
				<td><input type="text" name="customerEmailId" value=<%=cb.getEmailId()%>></td>
			</tr>
			<tr>
				<td><label>Car Number</label></td>
				<td><input type="text" name="carNumber" value=<%=carBean.getCarNumber()%>></td>
			</tr>
			<tr>
				<td><label>Car Brand</label></td>
				<td><input type="text" name="brand"
					value=<%=carBean.getCarBrand()%>></td>
			</tr>
			<tr>
				<td><label>Car Model</label></td>
				<td><input type="text" name="model"
					value=<%=carBean.getCarModel()%>></td>
			</tr>
			<tr>
				<td><label>Car Price</label></td>
				<td><input type="text" name="carPrice"
					value=<%=carBean.getCarRent_PER_DAY()%>></td>
			</tr>

			<tr>
				<td><label>Enter journey Start Date</label></td>
				<td><input type="date" name="startDate"></td>
			</tr>
			<tr>
				<td><label>Enter journey End Date</label></td>
				<td><input type="date" name="endDate"></td>
			</tr>
		</table>
		<input type="submit" value="check">

	</form>
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
	<a href="checkallHistory">History</a>
	<br>
	<a href="Customerlogout">LogOut</a>
	<br>
</body>
</html>