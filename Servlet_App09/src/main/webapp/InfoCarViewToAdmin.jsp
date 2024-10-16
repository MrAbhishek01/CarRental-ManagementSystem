<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="AdminBeanClass.*,InfoCarBean.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Profile</title>
<link rel="stylesheet" href="InfoCarViewToAdmi.css">
</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	ArrayList<CarBean> al = (ArrayList<CarBean>) session.getAttribute("al");
	if (al.size() == 0) {
		out.println("<p>No cars available.</p>");
	} else {
	%>

	<nav class="navbar">
        <div class="logo">Logo</div>
        <ul>
            <li><a href="AdminViewProfile.jsp">profile</a></li>
            <li><a href="AdminLoginSuccess.jsp">Home</a></li>
            <li><a href="InfoCarAdding.jsp">Add Car</a></li>
            <li><a href="ViewCar">View Car</a></li>
            <li><a href="RentedCar">View Rented Car History</a></li>
            <li><a href="#menu">Menu</a></li>
            <li><a href="#contact-us">Contact Us</a></li>
            <li><a href="#about-us">About Us</a></li>
        </ul>
        <div class="user-info">
            Welcome-<%=ab.getFirstName()%>
            <a href="Adminlogout">Logout</a>
        </div>
    </nav>

	<table>
		<thead>
			<tr>
				<th>Car Number</th>
				<th>Car Brand</th>
				<th>Car Model</th>
				<th>Location</th>
				<th>Rent per Day</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			Iterator<CarBean> it = al.iterator();
			while (it.hasNext()) {
				CarBean cb = it.next();
			%>
			<tr>
				<td><%=cb.getCarNumber()%></td>
				<td><%=cb.getCarBrand()%></td>
				<td><%=cb.getCarModel()%></td>
				<td><%=cb.getLocation()%></td>
				<td><%=cb.getCarRent_PER_DAY()%></td>
				<td><a href="editCarDetails?cNumber=<%=cb.getCarNumber()%>">Edit</a>
					|<a href="deleteCarDetails?cNumber=<%=cb.getCarNumber()%>">Delete</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	}
	%>

	<footer>
		<div class="footer-container">
			<div class="footer-column">
				<h3>Get to Know Us</h3>
				<ul>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Careers</a></li>
				</ul>
			</div>
			<div class="footer-column">
				<h3>Connect with Us</h3>
				<ul>
					<li><a href="https://www.facebook.com/">Facebook</a></li>
					<li><a href="https://x.com/">Twitter</a></li>
					<li><a href="https://www.instagram.com/">Instagram</a></li>
				</ul>
			</div>

			<div class="footer-column">
				<h3>Let Us Help You</h3>
				<ul>
					<li><a href="https://selfregistration.cowin.gov.in/">COVID-19
							and CarRentral</a></li>
					<li><a href="AdminProfile">Your Account</a></li>
					<li><a href="#">Car Rental App Download</a></li>
					<li><a href="#">Help</a></li>
				</ul>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="footer-links">
				<a href="ViewCar">ViewCar</a> <a href="InfoCarDetails.html">Add
					Cars Web Services</a> <a href="RentedCar">Rented Cars History</a> <a
					href="InfoCarDetails.html">add Now</a>
			</div>
			<div class="footer-country">
				<span>English</span> <span>India</span>
			</div>
		</div>
	</footer>

	<%--
	<a href="AdminLoginSuccess.jsp">Home</a>
	<br>
	<a href="InfoCarDetails.html">Add Car</a>
	<br>
	<a href="ViewCar">View Cars</a>
	<br>
	<a href="RentedCar">Rented Cars History</a>
	<br>
	<a href="Adminlogout">Logout</a>
	 --%>

</body>
</html>
