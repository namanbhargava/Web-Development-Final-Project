<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Category Form</title>
<style>
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
	<a style="float: right;" href="${contextPath}/logout.dpk">Logout</a>
	<a href="${contextPath}/addCategory.dpk">Add Category </a>
<hr/>
<br />

<div align="center">

	<h2>Add a New Category</h2>


	<form:form action="${contextPath}/addCategory.dpk" method="post" commandName="category">

		<table>
			<tr>
				<td>Category Title:</td>
				<td><form:input path="title" size="30"  /> <font color="red"><form:errors
							path="title" /></font></td>
			</tr>

			<tr>
				<td colspan="2"></td>
			</tr>
		</table><br/>
		<input type="submit" value="Create Category" />
		<c:if test="${errorMessage!=null}">
			<p>${errorMessage}</p>
		</c:if>
		<c:if test="${success!=null}">
			<p>${success}</p>
		</c:if>
	</form:form>
</div>
</body>
</html>