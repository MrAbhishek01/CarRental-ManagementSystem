<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="AdminBeanClass.*,InfoCarBean.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	CarBean cb = (CarBean) request.getAttribute("carBean");

	out.println("ProfileBelongs to : " + ab.getFirstName());
	%>
	
	<form action="updateCarDetails" method="post">

		<input type="hidden" name="carNumber" value=<%=cb.getCarNumber()%>><br>
		Car Price <input type="text" name="carPrice" value=<%=cb.getCarRent_PER_DAY()%>><br>
		Location<input type="text" name="location" value=<%=cb.getLocation()%>><br>
		<input type="submit" value="Update">
	</form>

</body>
</html>