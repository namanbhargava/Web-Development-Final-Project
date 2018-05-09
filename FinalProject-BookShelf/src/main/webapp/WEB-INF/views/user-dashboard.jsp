<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>${user.fname}Dashboard</title>
<style type="text/css">
img {
	width: 200px;
	height: 200px;
	display: inline;
}

.div-product-data, .div-product-image {
	float: left;
	display: inline;
}

fieldset {
	padding: 10px;
}
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
	<a style="float: left" href="${contextPath}/user-home.dpk">Home &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/myInfo.dpk">My Profile &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/view-all-products.dpk?pageid=1	">View All Products &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/sell-products.dpk">Sell Here &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/see-more-books.dpk">See more Books &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/booksPurchased.dpk">Books Purchased &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/viewCart.dpk">View Cart</a><br />
<hr/>
	<div align="center">
		<h4>Welcome ${user.fname}</h4>
	
	<br/>
<div style="align: center;" >
	<form>
<b>Search here</b>:&nbsp;<input type="text" name="box" id="box" placeholder="Product Name" />
		<br />
	</form>
<br/>
	<div id="products_table">
	</div>
</div>
</div>
	<script>
	$(document).ready(function() {
		  $(window).keydown(function(event){
		    if(event.keyCode == 13) {
		      event.preventDefault();
		      return false;
		    }
		  });
		});


	
		$("#box").keyup(function() {
			var value = $(this).val();
			if (true) {
				var urlPath = "getProductList.dpk?val=" + value;
				$.ajax({
					url : urlPath,
					type : 'POST',
					success : function(response) {
						if (response.length==0) {
							$("#products_table").html("");
						}
						else {
							document.getElementById('products_table').innerHTML="";
							$("#products_table").html(response);
						}

					}

				});
			}
		});
	</script>
</body>
</html>