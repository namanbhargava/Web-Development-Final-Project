<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<div align="center">
	<h1>BookShelf</h1>
	</div>
<hr />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a style="float: right;" href="${contextPath}/logout.dpk">Logout</a>
	<a style="float: left" href="${contextPath}/user-home.dpk">Home &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/myInfo.dpk">My Profile &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/view-all-products.dpk?pageid=1	">View All Products &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/sell-products.dpk">Sell Here &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/see-more-books.dpk">See more Books &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/booksPurchased.dpk">Books Purchased &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/viewCart.dpk">View Cart</a><br />
<hr/>
<h1>Order has been placed successfully! Please find details below</h1>	
	
<h1>Delivery Address</h1>

Name  	: ${sessionScope.user.fname} ${sessionScope.user.lname}<br>
Email 	: ${sessionScope.email}<br>
Phone 	: ${sessionScope.pnumber}<br>
Address	: ${sessionScope.address}<br>
City	: ${sessionScope.city}<br>
State	: ${sessionScope.state}<br>
	

<h1>Products to be delivered</h1>	
<table>
	<tr>
		<th>Product ID</th>
		<th>Product Name</th>
		<th>Product Price</th>
		<th>Quantity</th>
		<th>Total</th>
		
	</tr>
<c:set var="tot" value="${0}"/>
<c:forEach items="${listcart}" var="lc">
	<tr>
		<td>${lc.productpojo.productId}</td>
		<td>${lc.productpojo.productName}</td>
		<td>${lc.productpojo.productPrice}</td>
		<td>${lc.quantity}</td>
		<td>${lc.productpojo.productPrice * lc.quantity}</td>
		
		<c:set var="tot" value="${tot + (lc.productpojo.productPrice * lc.quantity)}"></c:set>
		
	</tr>
</c:forEach>
</table>
<br>
<b>Bill Total is : </b><c:out value="${tot}" ></c:out>
<br/><br/>
<form action="${contextPath}/report.pdf" method="post" >
	<input type="submit" value="Generate Receipt" />
</form>

</body>
</html>