<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home-access-control</title>

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
	
</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div align="center">
	<h1>BookShelf</h1>
	</div>
<hr />
	
	<a align="center" href="${contextPath}/logout.dpk">Logout</a>
<hr/>

<div align="center">
<h2>Welcome ${employee.firstName}</h2>
<h3>Products to be Reviewed</h3>
</div>




<c:choose>

<c:when test="${underReviewedProductsList.size() > 0}">
    <table>
	<c:forEach items="${underReviewedProductsList}" var="productList">
		<div id="data-container">
			<fieldset>
				<div id="div-product-image">
					<img src="${productList.imageFilePath }">
				</div>
				<div id="div-product-data">
				
					Product ID   : ${productList.productId}<br>
	                Product Name : ${productList.productName}<br>
	                Product Price: ${productList.productPrice}<br>
	                Category		:${productList.category}<br>
	                description: ${productList.description}<br>
	                Status   	 : ${productList.status}<br>
	                <a href="${contextPath}/rejectProduct.dpk?id=${productList.productId}">Reject</a>
	                &nbsp;&nbsp;&nbsp;
	                <a href="${contextPath}/approveProduct.dpk?id=${productList.productId}">Approve</a>
				</div>
			</fieldset>
		</div>                
    </c:forEach>
    </table>
  </c:when>
  
  <c:otherwise>
    <h3>No products in queue</h3>
  </c:otherwise>
</c:choose>

</body>
</html>