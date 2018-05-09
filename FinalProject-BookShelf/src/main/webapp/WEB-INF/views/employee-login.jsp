<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookShelf</title>


<link href="" rel="stylesheet">
<script src=""></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<Style>
	body {
		
		background-image: url("https://msenterprise.global.ssl.fastly.net/wordpress/2017/04/Hospitatlity_EPAC-01-1500-672.jpg");
		background-size: 100%;
		background-repeat: no-repeat;
	}
	
	
	
	#container {
		align-items: center;
		padding: 160px;
		align-content: center;
	}
	
	#login-container {
		padding-top: 140px;
		width: 450px;
		padding: 3px;
		background: #fff;
		border-radius: 10px;
		border: 5px solid #ff9900;
	}
	fieldset{
		
		padding: 30px;
		border-radius: 10px;
	}
	h2, h3{
		color: #ff9900;
		text-align: center;
	}
	 input, select {
	 	width: 100%;
	 }
	 
</Style>

 
</head>
<body>
	<div id="container"><center>
		<div id="login-container">
		<h2>BookShelf</h2>
		<h3>Employee Login</h3>
			<fieldset>
				<form action="employee-login-request.dpk" method="post">
					<input type="email" id="user-email" class="form-control" placeholder="Husky e-mail required" name="employee-email" value="" required><br> 
					<input type="password" id="user-password" class="form-control"	placeholder="password" name="employee-password" value="" required><br>
					<select name="employee-role" class="form-control">
						<option >Admin</option>
						<option >Access Control</option>
					</select><br>
					
					<c:if test="${invalidCredentials==true}" >
								<p>Userid/Password not valid</p>
							</c:if>
					<input id="btn-submit" type="submit" class="btn btn-primary" name="submit" value="Let me in">
				</form>
			</fieldset>
		</div></center>
	</div>
	
	<c:if test="invalidCredentials">
		<script type="text/javascript">
			var userInput = document.getElementById("user-email");
			var userPassword = document.getElementById("user-password");
			userInput.setAttribute("value", "");
			userPassword.setAttribute("value", "");
			alert("Incorrect username and password, please check it again");
		</script>
	
	</c:if>
</body>
</html>