<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<style>

	a{
		text-decoration: none;
	}
</style>
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<div align="center">
	<h1>BookShelf</h1>
	</div>
<hr />

	<a style="float: right;" href="${contextPath}/logout.dpk">Logout</a>
	<a href="${contextPath}/addCategory.dpk">Add Category</a>
	
<hr/>
<div align="center">
	<h2>Welcome ${employee.firstName}</h2>
	<h3>Role: ${employee.role}</h3>
</div>



<br>


</body>
</html>