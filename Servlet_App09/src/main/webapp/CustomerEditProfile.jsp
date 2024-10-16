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
	CustomerBean cb = (CustomerBean) application.getAttribute("cbean");
	out.println("Profile Belongs to : " + cb.getFirstName());
	%>

	<form action="CustomerUpdate" method="post">

		Address : <input type="text" name="Address" value=<%=cb.getAddress()%>><br>
		email-Id : <input type="text" name="eid" value=<%=cb.getEmailId()%>><br>
		Phone no.:<input type="text" name="phone" value=<%=cb.getPhoneNumber()%>><br> 
		<input type="submit" value="Update"><br>
	</form>

</body>
</html>