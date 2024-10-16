<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="AdminBeanClass.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="AdminViewProfile.css">

</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	out.println("Profile belong to : " + ab.getFirstName() + "<br>");

	/*out.println("Name     : " + ab.getFirstName() + " " + ab.getLastName() + "<br>");
	out.println("Gender   : " + ab.getGender() + "<br>");
	out.println("Address  : " + ab.getAddress() + "<br>");
	out.println("Email-Id : " + ab.getEmailId() + "<br>");
	out.println("Phone no : " + ab.getPhoneNumber() + "<br>");*/
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
	
	
	
	<div class="profile-container">
		<header class="profile-header">
			<img src="profile-pic.jpg" alt="Profile Picture" class="profile-pic">
		</header>
		<section class="profile-details">
			<h2>Details</h2>
			<ul>
				<li><strong>Name:</strong> <%=ab.getFirstName() + " " + ab.getLastName()%></li>
				<li><strong>Gender:</strong> <%=ab.getGender()%></li>
				<li><strong>DOB:</strong> <%=ab.getDateOfBirth()%></li>
				<li><strong>Email:</strong> <%=ab.getEmailId()%></li>
				<li><strong>Phone:</strong> <%=ab.getPhoneNumber()%></li>
				<li><strong>Location:</strong> <%=ab.getAddress()%></li>
			</ul>
			<a href="AdminEdit">Edit Profile</a> <br> 
		</section>

	</div>
	
	
	
	
	
	
	
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
</body>
</html>