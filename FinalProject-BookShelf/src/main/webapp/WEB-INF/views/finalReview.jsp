<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<br />

	<h1>Order :</h1>	 

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
<br />
Bill Total is : <c:out value="${tot}" ></c:out> 


<h1>Add Shipping address</h1>
<form action="${contextPath}/success.dpk" method="post" >

Full Name: <input type="text" name= "fname" value="${sessionScope.user.fname} ${sessionScope.user.lname}" /><br><br>
Street Address: <input type="text" name="address" value="${sessionScope.user.address}" /><br><br>
City: <input type="text" name="city" value="${sessionScope.user.city}" /><br><br>
State: <input type="text" name="state" value="${sessionScope.user.state}" /><br><br>
Phone Number: <input type="text" name="phonenumber" value="${sessionScope.user.phoneNumber}" /><br><br>
Email: <input type="text" name="email" value="${sessionScope.user.userid}" /><br><br>

<input type="submit" value="Deliver to this address" />

</form>


</body>
</html>