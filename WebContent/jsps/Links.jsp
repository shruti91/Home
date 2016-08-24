<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
ul {
	list-style: none;
	padding: 0px;
	margin: 0px;
	background: #197519;
}

ul li {
	display: block;
	position: relative;
	float: left;
	border: 1px solid #197519;
	width: 600
}

li ul {
	display: none;
}

ul li a {
	display: block;
	background: #197519;
	padding: 5px 10px 5px 10px;
	text-decoration: none;
	white-space: nowrap;
	color: #fff;
}

ul li a:hover {
	background: #00001F;
}

li:hover ul {
	display: block;
	position: absolute;
}

li:hover li {
	float: none;
}

li:hover a {
	background: #00001F;
}

li:hover li a:hover {
	background: #000;
}
/* #drop-nav li ul li {border-top: 0px;} */
</style>

</head>
<body>
	<ul class="clearfix">
		<li><a href="/ShoppingCart/Index.jsp">Home</a> 
			<s:if
				test="${sessionScope.user eq null}">
				<li><a href="/ShoppingCart/Login.jsp">Login</a></li>
				<li><a href="/ShoppingCart/Signup.jsp">SignUp</a></li>
			</s:if> 
			<s:if test="${sessionScope.user ne null }">
				<li><a href="/ShoppingCart/app/login/logout">Logout</a></li>
			</s:if> 
			<s:if test="${sessionScope.user.role eq 'customer'}">
				<li><a href="/ShoppingCart/app/item/getAllItems">View All Items</a></li>
				<li><a href="/ShoppingCart/app/order/viewAllOrder">View My Order</a></li>
				<li><a href="/ShoppingCart/Feedback.jsp">Feedback</a></li>
			</s:if> 
			<s:if test="${sessionScope.user.role eq 'admin'}">

				<li><a href="/ShoppingCart/AddItem.jsp">Add Item</a></li>

				<li><a href="/ShoppingCart/app/item/viewAllItemsAdmin">View
						or remove Items</a></li>

				<li><a href="/ShoppingCart/AddCategory.jsp">Add category</a></li>

				<li><a href="/ShoppingCart/app/item/getAllItems">View All
						Categories</a></li>

				<li><a href="/ShoppingCart/app/order/viewAllOrderAdmin">View All Orders</a></li>
				<li><a href="/ShoppingCart/app/feedback/viewFeedback">View
						All Feedback</a></li>

			</s:if>
				<li><a href="/ShoppingCart/AboutUs.jsp">Get to know us</a></li>
				<li><a href="/ShoppingCart/ContactUs.jsp">Contact Us</a></li>

	</ul>
</body>
</html>