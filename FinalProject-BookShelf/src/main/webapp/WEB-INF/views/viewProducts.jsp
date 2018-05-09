<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<title>Insert title here</title>
<style type="text/css">
	
	
	img{
	
		width: 140px;
		height:140px;
		display: inline;
	}
	
	#div-product-data, #div-product-image{
		float: left;
		display: inline;
		padding: 10px;
	}
	
	#div-product-image{
		width: 150px;
		height: 150px;
	}
	
	fieldset{
		padding: 10px;
	}
	
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
<div style="text-align:center">
  <div>
  	<c:if test="${requestScope.map.successMessage==true}" >
			<p>Product added to cart</p>
	</c:if>
	<br /><br />
    <a href="${contextPath}/view-previous-products.dpk?option=back">&laquo;Back</a>|
    <a href="${contextPath}/view-next-products.dpk?option=next">Next&raquo;</a>
    
  </div>
</div>
<br >
<!--    <form action="${contextPath}/categorySpecificResult.dpk">
	<select name="selectedCategory" >
		<option value="All Category">All Category</option>
		<c:forEach items="${sessionScope.catList }" var="cl">
			<option value="${cl }">${cl}</option>
		</c:forEach>
	</select>	
	<input type="submit" valur="submit"/>

</form>  -->


<c:forEach items="${requestScope.map.products}" var="pl">

		<div id="data-container">	
			<fieldset> 
				<div id="div-product-image">
					<img src="${pl.imageFilePath }">
				</div>
				
				<div id="div-product-data">
	                <p>Product ID   : ${pl.productId}</p>
	                <p>Product Name : ${pl.productName}</p>
	                <p>Product Price: ${pl.productPrice}</p>
	                <p>Status   	: ${pl.status}</p>
	                <form action="${contextPath}/toCart.dpk" method="get">
	                	<input type="hidden" name="id" value= ${pl.productId} />
	             	   	Quantity	:<input type="number" id="qty" name="qty" min=1 max=2 required/> 
	              		<input type="submit" id="submit" value="Add to cart" />
	                </form>          
	            </div>
			</fieldset>
		</div>  
		
        </c:forEach>    
 
</body>
</html>