<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="InfoCarBean.*,AdminBeanClass.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	ArrayList<CarBean> al = (ArrayList<CarBean>) session.getAttribute("al");
	out.println("Profile belongs to : " + ab.getFirstName()+"<br>");

	if (al.size() == 0) {
		out.println("Not Cars Rented");
	} else {

		Iterator<CarBean> it = al.iterator();
		while (it.hasNext()) {
			CarBean cb= (CarBean)it.next();
			out.println(
				    cb.getCarNumber()+"&nbsp&nbsp"+
				    cb.getCarBrand()+"&nbsp&nbsp"+
				    cb.getCarModel()+"&nbsp&nbsp"+
				    cb.getLocation()+"&nbsp&nbsp"+
				    cb.getCarRent_PER_DAY()+"&nbsp&nbsp"+
				    "Rented");
		}
	}
	%>
	<br>
	<a href="AdminLoginSuccess.jsp">Home</a>
	<br>
	<a href="ViewCar">View Cars</a>
	<br>
	<a href="Adminlogout">Logout</a>
</body>
</html>