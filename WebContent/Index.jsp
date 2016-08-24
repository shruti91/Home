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
			<img src="/ShoppingCart/images/olshopping.jpg" alt="GoShopping.com" width="678"/>
		</div>
	</td>
	</tr>
	<tr height="20%">
	<td colspan="2" align="center"><%@include file="jsps/Footer.jsp"%></td>
</tr>
</table>
</body>
</html>