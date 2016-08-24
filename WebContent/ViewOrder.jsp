<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<body>
	<table align="center" border="1">
		<tr height="20%">
			<td colspan="2" align="center"><%@include file="jsps/Header.jsp"%></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><h4><%@include
						file="jsps/welcomemessage.jsp"%></h4></td>
		</tr>
		<tr height="60%">
			<td width="20%" valign="top"><%@include file="jsps/Links.jsp"%></td>
			</tr><tr>
			<td>
				<div>
					<table border="1">
						<tr>
							<td>Order Id</td>
							<td>Order Date</td>
							<td>Delivery Date</td>
							<td>Order Status</td>
							<td>Total Price</td>
							<td>Quantity</td>
						</tr>

						<s:forEach items="${OrderMaster}" var="OrderMaster">
							<tr>
								<td>${OrderMaster.orderId}</td>
								<td>${OrderMaster.orderDate}</td>
								<td>${OrderMaster.deliveryDate}</td>
								<td>${OrderMaster.orderStatus}</td>
								<td>${OrderMaster.totalPrice}</td>
								<td><a href="/ShoppingCart/app/order/viewOrderItem?orderId=${OrderMaster.orderId}">View All Items</a> </td>
							</tr>
						</s:forEach>
						</table>
						
				</div>
			</td>
		</tr>
		<tr height="20%">
			<td colspan="2" align="center"><%@include file="jsps/Footer.jsp"%></td>
		</tr>
	</table>
</body>
</html>