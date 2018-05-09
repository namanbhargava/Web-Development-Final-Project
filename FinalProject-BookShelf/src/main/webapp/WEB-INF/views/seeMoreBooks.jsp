<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
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
	<a style="float: left" href="${contextPath}/user-home.dpk">Home &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/myInfo.dpk">My Profile &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/view-all-products.dpk?pageid=1	">View All Products &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/sell-products.dpk">Sell Here &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/see-more-books.dpk">See more Books &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/booksPurchased.dpk">Books Purchased &nbsp;&nbsp;|&nbsp;&nbsp;</a>
	<a style="float: left" href="${contextPath}/viewCart.dpk">View Cart</a><br />
<hr/>
	<div align="center">
		<H3>Search here</H3>
		<input type="text" name="box" id="box" placeholder="keyword" />
		<button id="button" type="button">Search</button>	
		<br />
	<div id="results"></div>
	
	</div>
	<script>
	

	
		function booksearch(){
			console.log("This is working");
			
			var search = document.getElementById('box').value;
			document.getElementById('results').innerHTML="";
			console.log(search);

			$.ajax({

				url:"https://www.googleapis.com/books/v1/volumes?q="+search,
				dataType:"json",
				type:"GET",

				success: function(data){
					for(i=0; i < data.items.length; i++){
							results.innerHTML += "<hr />"							
							results.innerHTML += "<h1>"+data.items[i].volumeInfo.title+"</h1>"
							results.innerHTML += "<h1>"+data.items[i].volumeInfo.authors+"</h1>"
							results.innerHTML += '<img src='+data.items[i].volumeInfo.imageLinks.smallThumbnail +'/><br/><br />'
							results.innerHTML += '<a href='+ data.items[i].volumeInfo.infoLink + '><button>Read More</button></a>'
							results.innerHTML += "<hr />" 
						}
					},
				})
			}
		document.getElementById('button').addEventListener('click', booksearch, false);


	</script>
</body>
</html>