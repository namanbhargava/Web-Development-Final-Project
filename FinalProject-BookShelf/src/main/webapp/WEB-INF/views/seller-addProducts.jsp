<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<style>
		
		h3{
			color: red;
		}
		
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
	<a style="float: right" href="${contextPath}/logout.dpk">Logout</a>
	<a style="float: left" href="${contextPath}/user-home.dpk">Home &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/myInfo.dpk">My Profile &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/view-all-products.dpk?pageid=1	">View All Products &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/sell-products.dpk">Sell Here &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/see-more-books.dpk">See more Books &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/booksPurchased.dpk">Books Purchased &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/viewCart.dpk">View Cart</a><br />
<hr/>
	<div align="center">
	<h1>Add Products to sell</h1>	
	
	<form:form method="post" commandName="product" action="${contextPath}/sell-products.dpk" enctype="multipart/form-data" data-toggle="validator">

		
		<table>
			

			<tr>
				<td>Category:</td>
				<td><form:select path="category" items="${catList}" multiple="false" required="required" /></td>
			</tr>

			<tr>
				<td>Product Title:</td>
				<td><form:input type="text" path="productName" size="30" required="required" pattern="[a-zA-z0-9 ]{1,}"/></td>
			</tr>

			<tr>
				<td>Decription:</td>
				<td><form:textarea type="text" path="description" size="100" required="required" pattern="[a-zA-z0-9,. ]{1,}"/></td>
			</tr>

			<tr>
				<td>Price:</td>
				<td><form:input type="number"  path="productPrice" size="30" required="required" pattern="[0-9]{1,4}"/></td>
			</tr>
			
			<tr>
			<td>Select photo: </td><td><input type="file" name="photo" required="required"/></td>
			</tr>
			
		</table><br />
	<input type="submit" value="Submit Product" />
	</form:form>
	
	</div>

</body>
</html>