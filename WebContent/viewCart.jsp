<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
		<td colspan="2" align="center"><h4><%@include file="jsps/welcomemessage.jsp" %></h4></td>
	</tr>
	<tr height="60%">
		<td width="20%" valign="top"><%@include file="jsps/Links.jsp"%></td>
	</tr>
	<tr>
	<td>
		<div>
			<table>
<tr>
<td>Item Id</td>
<td>Item Name</td>
<td>Item Price</td>
<td>Item Description</td>
<td>Image</td>
<td>Quantity</td>
 </tr>
  <s:forEach items="${cartItemMap}" var="cartItemEntry">
 <tr>
 	<td>${cartItemEntry.key.itemId }</td>
	<td>${cartItemEntry.key.itemName }</td>
	<td>${cartItemEntry.key.price }</td>
	<td>${cartItemEntry.key.itemDescription }</td>
	<td><img src="/ShoppingCart/images/${cartItemEntry.key.imagePath}" height="50" width="50"/></td>
	<td>${cartItemEntry.value}</td>
	<td><a href="/ShoppingCart/app/cart/removeCart?itemId=${cartItemEntry.key.itemId}">Remove From Cart</a></td>
 </tr>
 </s:forEach>
</table>

<a href="/ShoppingCart/app/item/getAllItems">Shop Again</a>

<a href="/ShoppingCart/app/order/placeOrder">Check Out</a>
		</div>
	</td>
	</tr>
	<tr height="20%">
	<td colspan="2" align="center"><%@include file="jsps/Footer.jsp"%></td>
</tr>
</table>

</body>
</html>