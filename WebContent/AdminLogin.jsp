<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
				<form action="/ShoppingCart/app/login/authenticateAdmin">
					<table align="center" border="0">
						<tr>
							<td colspan="2">
								<h2>Login Information:</h2>
								<table align="center">
									<tr>
										<td>User Name* :</td>
										<td><input type="text" name="txtUser" required="required"  placeholder="User Name" class="vemailId"/>
										</td>
									</tr>
									<tr>
										<td>Password* :</td>
										<td><input type="password" name="txtPassword"
											required="required" placeholder="Password"/></td>
									</tr>
									<tr>
										<td colspan="2" align="right"><input type="submit"
											value="Login"></td>
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