<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a{
text-decoration: none;
}
</style>
</head>
<body>

<div align="center">
	<h1>BookShelf</h1>
	</div>
<hr />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a style="float: right;" href="${contextPath}/logout.dpk">Logout</a>
	<a style="float: left";" href="${contextPath}/user-home.dpk">Home &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left";" href="${contextPath}/myInfo.dpk">My Profile &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left;" href="${contextPath}/view-all-products.dpk?pageid=1	">View All Products &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left;" href="${contextPath}/sell-products.dpk">Sell Here &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left;" href="${contextPath}/see-more-books.dpk">See more Books &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left;" href="${contextPath}/booksPurchased.dpk">Books Purchased &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/viewCart.dpk">View Cart</a><br />
<hr />
<div align="center">

<h1>User - My Info</h1>
<form action="${contextPath}/myInfo.dpk" method="post" >
	<p>First Name: <input type="text" name="fname" value="${user.fname}" /></p>
	<p>Last Name: <input type="text" name="lname" value="${user.lname}" /></p>
  	<p>City: <input type="text" name="city" value="${user.city}" /></p>
	<p>State: <input type="text" name="state" value="${user.state}" /></p>
	<p>Phone Number: <input type="text" name="phoneNumber" value="${user.phoneNumber}" /></p> 
	<input type="hidden" name="id" value="${user.userid}" />
	<button type="submit">Update info</button>
</form>

</div>
</body>
</html>