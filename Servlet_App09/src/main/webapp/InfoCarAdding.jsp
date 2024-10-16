<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="AdminBeanClass.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="InfoCarAdding.css">
</head>
<body>
    <%
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    String msg = (String) request.getAttribute("msg");

    if (ab != null) {
        out.println("Profile Belonging to: " + ab.getFirstName() + "<br>");
    }
    
    if (msg != null) {
        out.println(msg + "<br>");
    }
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
    
    <main>
        <div class="form-container">
            <h3>Add Car Details</h3>
            <form action="addCar" method="post">
                <table>
                    <tr>
                        <td><label>Enter Car Number</label></td>
                        <td><input type="text" name="carNumber" required></td>
                    </tr>
                    <tr>
                        <td><label>Enter Car Brand</label></td>
                        <td><input type="text" name="carBrand" required></td>
                    </tr>
                    <tr>
                        <td><label>Enter Car Model</label></td>
                        <td><input type="text" name="carModel" required></td>
                    </tr>
                    <tr>
                        <td><label>Enter Car Charges (Per Day)</label></td>
                        <td><input type="text" name="dayPrice" required></td>
                    </tr>
                    <tr>
                        <td><label>Enter Car Location</label></td>
                        <td><input type="text" name="location" required></td>
                    </tr>
                </table>
                <input type="submit" value="Submit">
            </form>
        </div>
    </main>

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
                    <li><a href="https://selfregistration.cowin.gov.in/">COVID-19 and Car Rental</a></li>
                    <li><a href="AdminProfile">Your Account</a></li>
                    <li><a href="#">Car Rental App Download</a></li>
                    <li><a href="#">Help</a></li>
                </ul>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="footer-links">
                <a href="ViewCar">View Car</a>
                <a href="InfoCarDetails.html">Add Cars Web Services</a>
                <a href="RentedCar">Rented Cars History</a>
                <a href="InfoCarDetails.html">Add Now</a>
            </div>
            <div class="footer-country">
                <span>English</span>
                <span>India</span>
            </div>
        </div>
    </footer>
</body>
</html>
