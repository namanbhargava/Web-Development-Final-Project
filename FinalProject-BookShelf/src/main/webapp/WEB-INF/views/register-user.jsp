<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

<title>Register User</title>

</head>
<body ng-app>
<h1>Register User</h1>
<h4>Fill in the following details</h4>
<form action="register-user-success.dpk" method="post" id="userform" name="userform" novalidate>
		User id : <input type="text" id="userid" name="userid" placeholder="@husky.neu.edu" ng-model="user.userid" ng-pattern="/^[a-zA-Z][a-zA-Z_.0-9]+@husky.neu.edu$/" ng-required="true" /> 
		<span ng-show='userform.userid.$invalid && userform.userid.$touched'>Fill a valid UserID</span><br><br>
		
		Password : <input type="password" id="password" name="password" ng-model="user.password" ng-required="true"/>
		<span ng-show='userform.password.$invalid && userform.password.$touched'>Fill the password</span><br><br>
		
		First Name: <input type="text" name="fname" id="fname" ng-model="user.fname" ng-required="true"/>
		<span ng-show='userform.fname.$invalid && userform.fname.$touched'>Fill the firstName</span><br><br>
		
		Last Name: <input type="text" name="lname" id="lname" ng-model="user.lname" ng-required="true"/>
		<span ng-show='userform.lname.$invalid && userform.lname.$touched'>Fill the lastName</span><br><br>
		
		Address: <input type="text" name="address" id="address" ng-model="user.address" ng-required="true"/>
		<span ng-show='userform.address.$invalid && userform.address.$touched'>Fill the address</span><br><br>
		
		City: <input type="text" name="city" id="city" ng-model="user.city" ng-required="true"/>
		<span ng-show='userform.city.$invalid && userform.city.$touched'>Fill the city</span><br><br>
		
		State:<input type="text" name="state" id="state" ng-model="user.state" ng-required="true"/>
		<span ng-show='userform.state.$invalid && userform.state.$touched'>Fill the state</span><br><br>
		
		PhoneNumber:<input type="text" name="phonenumber" id="phonenumber" ng-model="user.phonenumber" ng-required="true"/>
		<span ng-show='userform.phonenumber.$invalid && userform.phonenumber.$touched'>Fill the password</span><br><br>
		
		<button type="submit" ng-disabled="userform.$invalid">Register</button>
</form> 
</body>
</html>