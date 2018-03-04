<%-- 
    Document   : searchResult
    Created on : Feb 21, 2018, 9:18:11 PM
    Author     : bharg
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search Results</h1>
        <c:forEach items="${requestScope.map.movieList}" var="ml">
                <p>${ml.title}</p>
                <p>${ml.actor}</p>
                <p>${ml.actress}</p>
                <p>${ml.genre}</p>
                <p>${ml.year}</p>
        </c:forEach>
        
    </body>
</html>
