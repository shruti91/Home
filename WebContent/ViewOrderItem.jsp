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
		</tr>
		<tr>
			<td>
				<s:forEach items="${OrderMaster.items}" var="cartMap">
					<table border="1">
						<tr>
							<td>Item Name</td>
							<td>${cartMap.key.itemName }</td>

						</tr>
						<tr>
							<td>Item Price</td>
							<td>${cartMap.key.price }</td>
						</tr>
						<tr>
							<td>Item Description</td>
							<td>${cartMap.key.itemDescription }</td>
						</tr>
						<tr>
							<td>Image</td>
							<td><img src="/ShoppingCart/images/${cartMap.key.imagePath}"
								height="50" width="50" /></td>
						</tr>
						<tr>
							<td>Quantity</td>
							<td>${cartMap.value}</td>
						</tr>
					</table>
				</s:forEach></td>
		</tr>
		<tr height="20%">
			<td colspan="2" align="center"><%@include file="jsps/Footer.jsp"%></td>
		</tr>
	</table>
</body>
</html>