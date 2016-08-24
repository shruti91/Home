<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
			</tr><tr>
			<td>
				<div>
					<table>
						<tr>
							<td colspan="6"><a href="/ShoppingCart/app/cart/viewAllCart">View
									cart</a></td>
						</tr>
						<tr>
							<td>Item Id</td>
							<td>Item Name</td>
							<td>Item Price</td>
							<td>Item Stock</td>
							<td>Item Description</td>
							<td>Image</td>
						</tr>
						<s:forEach items="${itemList}" var="items">
							<tr>
								<td>${items.itemId }</td>
								<td>${items.itemName }</td>
								<td>${items.price }</td>
								<td>${items.stock }</td>
								<td>${items.itemDescription }</td>
								<td><img src="/ShoppingCart/images/${items.imagePath}"
									height="50" width="50" /></td>
								<td><a href="/ShoppingCart/app/item/removeItem?itemId=${items.itemId}">Delete</a></td>
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