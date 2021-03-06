<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
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
		</tr>
		<tr>
			<td>
				<div>
					<table>
						<tr>
						<s:if test="${sessionScope.user.role eq 'customer'}">
							<td colspan="6"><a href="/ShoppingCart/app/cart/viewAllCart">View
									cart</a></td>
						</s:if>
							<td>
								<form action="/ShoppingCart/app/item/searchByCategory">
									<select name="cat">
										<option>Sports</option>
										<option>Mobile</option>
										<option>Kitchen Appl</option>
										<option>Home Appl</option>
									</select> <input type="submit" value="Search" />
								</form>
							</td>
						</tr>
						<tr>
							<td>Item Id</td>
							<td>Item Name</td>
							<td>Item Price</td>
							<td>Item Description</td>
							<td>Image</td>
						</tr>
						<s:forEach items="${itemList}" var="items">
							<tr>
								<td>${items.itemId }</td>
								<td>${items.itemName }</td>
								<td>${items.price }</td>
								<td>${items.itemDescription }</td>
								<td><img src="/ShoppingCart/images/${items.imagePath}"
									height="50" width="50" /></td>
									
									<s:if test="${sessionScope.user.role eq 'customer'}">
								<td><a
									href="/ShoppingCart/app/cart/addToCart?itemId=${items.itemId}">Add
										To Cart</a></td>
											</s:if>
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