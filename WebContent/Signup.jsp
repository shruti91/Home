<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
  #img {
  opacity:0.4;
  }
</style>
<script src="jquery-1.11.1.js" type="text/javascript"></script>
<script src="Validation.js" type="text/javascript"></script>
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
		</tr><tr>
	<td>
		<div>
			<form action="/ShoppingCart/app/customer/addCustomer">
					<table align="center">
						<tr>
							<td>Name *:</td>
							<td><input type="text" id="inputTextBox" name="txtName"
								class="ename" required="required" placeholder="Full Name">
								<span class="error">Enter Characters only!!!</span></td>
						</tr>
						<tr>
							<td colspan="2">
								<fieldset>
									<legend>Address Information:</legend>
									<table>
										<tr>
											<td>Flat No: :</td>
											<td><input type="text" name="txtflatNo" placeholder="Flate No"></td>
										</tr>
										<tr>
											<td>Street :</td>
											<td><input type="text" name="txtStreet" placeholder="Street"></td>
										</tr>
										<tr>
											<td>City :</td>
											<td><input type="text" name="txtCity" placeholder="City"></td>
										</tr>
										<tr>
											<td>PinCode :</td>
											<td><input type="number" name="txtPincode" placeholder="PinCode" class="pinname">
											<span class="pinerror">Enter 6 digits only!!!</span></td>
										</tr>
										<tr>
											<td>State :</td>
											<td><input type="text" name="txtState" placeholder="State" class="state">
											<span class="serror">Enter Characters Only!!!</span></td>
										</tr>
										<tr>
											<td>Country :</td>
											<td><input type="text" name="txtCountry" placeholder="Country" class="country">
											<span class="cerror">Enter Characters Only!!!</span></td>
										</tr>
									</table>
								</fieldset>
						</tr>
						<tr>
							<td>Phone No. *:</td>
							<td><input type="text" id="numeric" name="txtPhone"
								required="required"  placeholder="Phone No" class="phname"/>
								<span class="pherror">Enter a valid 10 digit Contact Number</span></td>
						</tr>
						<tr>
							<td>Email id *:</td>
							<td><input type="text" name="txtEmailId" required="required"
								 placeholder="Email Id" class="vemailId"/>
							 <span class="errorEmail"> Enter a valid email address eg.abc@domain.com</span></td>						</tr>
						
						<tr>
							<td>Password *:</td>
							<td><input type="text" name="txtPassword" required="required" placeholder="Password">
						</tr>
						<tr>
							<!-- <td align="right"><input type="reset" value="Clear"></td> -->
							<td colspan="2" align="center"><input type="submit" value="Save" class="submit"></td>
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