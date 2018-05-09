<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Shelf</title>





<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link href="./assets/css/user-login.css" rel="stylesheet">
<Style>

body {
	
	background-image: url("http://blog.sewellgardner.com/wp-content/uploads/2011/07/pile-of-books.jpg");
	background-size: 100%;
	background-repeat: no-repeat;
}



#container {
	padding: 160px;
	text-align: center;
	margin-left: auto;
	
}

#login-container {
	padding-top: 140px;
	width: 380px;
	padding: 3px;
	background: #fff;
	border-radius: 10px;
	border: 5px solid #ff9900;
}
fieldset{	
	padding: 30px;
	border-radius: 10px;
}
h2{
	color: #ff9900;
	text-align: center;
}
 input {
 	width: 100%;
 }
 
</Style>


</head>
<body>
	<div id="container">
		<center>
			<div id="login-container">
				<h2>BookShelf</h2>
				<fieldset>
					<form action="user-login.dpk" method="post">
						<input type="email" id="user-email" class="form-control" placeholder="Husky e-mail required" name="user-email" value="" required><br> 
							<input type="password" id="user-email" class="form-control" placeholder="password" name="user-password"	value="" required><br> 
							<c:if test="${errorMessage==true}" >
								<p>Userid/Password not valid</p>
							</c:if>
							<a href="employee-login.dpk">Employee Login</a><br> 
							<a href="register-user.dpk">Haven't registered yet?</a><br><br> 
							<input id="btn-submit" type="submit" class="btn btn-primary" name="submit" value="Let me in">
					</form>
				</fieldset>
			</div>
		</center>
	</div>
</body>
</html>