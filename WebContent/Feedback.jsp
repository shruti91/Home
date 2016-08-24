<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery-1.11.1.js" type="text/javascript"></script>
<script src="Validation.js" type="text/javascript"></script>
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
	<tr>
		<td colspan="2" align="center"><h4><%@include file="jsps/Links.jsp" %></h4></td>
	</tr>
	 <tr height="60%">
	<td>
		<div>
			<form action="/ShoppingCart/app/feedback/custFeedback">
					<table align="center" border="0">
						<tr>
							<td colspan="2">
								<h2>Feedback: </h2>
								<table align="center">
									<tr>
										<td>Customer Name:</td>
										<td><input type="text" name="txtUser" required="required" placeholder="Customer Name" class="ename"/>
										<span class="error">Enter Characters Only!!!</span></td>
									</tr>
									<tr>
									<td>E-Mail Id: </td>
									<td><input type="text" name="txtemail" required="required" placeholder="Email Id" class="vemailId"/>
									<span class="errorEmail">Enter Valid Email Id eg.abc@domain.com</span></td>
									</tr>
									<tr>
									<td>Feedback: </td>
									<td> <textarea name="txtcomments" rows=2 cols=25 placeholder="Your Comments"></textarea></td>
									</tr>
									<tr>
										<td colspan="2" align="right"><input type="submit"
											value="Submit"></td>
									</tr>
									</table>
</table>
</form>
		</div>
	</td>
	</tr>
	<tr height="20%">
	<td colspan="2" align="center"><%@include file="jsps/Footer.jsp"%></td>
</tr>
</table>
</body>
</html>