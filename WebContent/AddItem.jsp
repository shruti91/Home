<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery-1.11.1.js" type="text/javascript"></script>
<script src="Validation.js" type="text/javascript"></script>
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
		<tr>
			<td width="20%" valign="top"><%@include file="jsps/Links.jsp"%></td>
		</tr>
		<tr>
			<td>
				<div>
					<form action="/ShoppingCart/app/item/addItem">
						<table align="center">
							<tr>
								<td>Item Name *:</td>
								<td><input type="text" id="inputTextBox" name="txtName"
									required="required" placeholder="Item Name"></td>
							</tr>
							<tr>
								<td>Item Price:</td>
								<td><input type="number" id="numeric" name="txtPrice"
									required="required" placeholder="Item Price"></td>
							</tr>
							<tr>
								<td>Stock *:</td>
								<td><input type="number" name="txtStock"
									required="required" class="stkname" placeholder="Stock">
									<span class="stkerror">Enter number only!!!</span></td>
							</tr>

							<tr>
								<td>Item Description *:</td>
								<td><input type="text" name="txtDescription"
									required="required"></td>
							</tr>
							<tr>
								<td>Item Image *:</td>
								<td><input type="text" name="txtImage" required="required"></td>
							</tr>
							<!-- <tr>
							<td>Item category *:</td>
							<td><input type="text" name="txtPassword" required="required"></td>
						</tr> -->
							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="Save" class="submit"></td>
							</tr>
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