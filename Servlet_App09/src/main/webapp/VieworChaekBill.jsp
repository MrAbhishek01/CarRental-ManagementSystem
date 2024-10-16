<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="CustomerBean.CustomerBean,InfoCarBean.CarBean,BillBeanClass.BillBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
	CarBean carBen = (CarBean) session.getAttribute("carBean");
	BillBean bill = (BillBean) session.getAttribute("bill");
	out.println("profile belonf to : " + cb.getFirstName() + "<br><br>");
	if (bill == null) {

	} else {
	%>
	<form action="insertBill" method="post">
	 <input type="hidden" name="carNumber" value="<%=bill.getCarNumber()%>">
		<table border="1">
			<tr>
				<td><label>Customer Bill No</label></td>
				<td><%=bill.getOrderbill()%></td>
			</tr>
			<tr>
				<td><label>Customer Name</label></td>
				<td><%=bill.getCustomerName()%></td>
			</tr>
			<tr>
				<td><label>Phone no.</label></td>
				<td><%=bill.getCustomerMobileNumber()%></td>
			</tr>
			<tr>
				<td><label>Email.Id</label></td>
				<td><%=bill.getCustomerEmailId()%></td>
			</tr>
			<tr>
				<td><label>Car Number</label></td>
				<td><%=bill.getCarNumber()%></td>
			</tr>
			<tr>
				<td><label>Car Brand</label></td>
				<td><%=bill.getCarBrand()%></td>
			</tr>
			<tr>
				<td><label>Car Model</label></td>
				<td><%=bill.getCarModel()%></td>
			</tr>
			<tr>
				<td><label>Journey Start Date</label></td>
				<td><%=bill.getJourneyStartDate()%></td>
			</tr>
			<tr>
				<td><label>Journey End Date</label></td>
				<td><%=bill.getJourneyEndDate()%></td>
			</tr>
			<tr>
				<td><label>Total Days</label></td>
				<td><%=bill.getTotalDays()%></td>
			</tr>
			<tr>
				<td><label>Rented Status</label></td>
				<td><%=bill.getRentedStatus()%></td>
			</tr>
			<tr>
				<td><label>Total Bill</label></td>
				<td><%=bill.getTotalBill()%></td>
			</tr>
		</table>
		<input type="submit" value="Confirm">
	</form>
	<%
	}
	%>

</body>
</html>