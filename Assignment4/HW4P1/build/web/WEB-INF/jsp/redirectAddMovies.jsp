<%-- 
    Document   : redirectAddMovies
    Created on : Feb 19, 2018, 2:02:29 PM
    Author     : bharg
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>You are redirected to Movies add page</h1>
        
    <form:form commandName ="movies" >
        Title: <form:input path='title' /><br />
        Actor: <form:input path='actor' /><br />
        Actress: <form:input path='actress' /><br />
        Genre: <form:input path='genre' /><br />
        Year: <form:input path='year' /><br />
        <input type="submit" value="Add movie" />
        <input type="hidden" value="add" />
    </form:form>
        
    </body>
</html>
