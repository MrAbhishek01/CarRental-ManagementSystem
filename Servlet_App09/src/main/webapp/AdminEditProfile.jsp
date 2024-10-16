<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="AdminBeanClass.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<%
	
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	out.println("Profile belong to : " + ab.getFirstName()+"<br>");
	%>
	
	<form action="AdminUpdate" method="post">
	
	Address  : <input type="text" name="Address" value=<%=ab.getAddress() %>><br>
	email-Id : <input type="text" name="eid" value=<%=ab.getEmailId() %>><br>
	Phone no.:<input type="text" name="phone" value=<%=ab.getPhoneNumber() %>><br>
	<input type="submit" value="Update"><br>
	</form>

</body>
</html>