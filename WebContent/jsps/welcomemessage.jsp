<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h4>Welcome
	<s:if test="${sessionScope.user ne null }">
	<s:if test="${sessionScope.user.role eq 'customer'}">
		${sessionScope.user.custName}
	</s:if>
	<s:if test="${sessionScope.user.role eq 'admin'}">
		Admin
	</s:if>
	</s:if>
	<s:if test="${sessionScope.user eq null}">
		Guest
	</s:if>
	</h4>
</body>
</html>