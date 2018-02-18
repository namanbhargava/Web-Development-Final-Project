<%-- 
    Document   : viewcart
    Created on : Feb 18, 2018, 3:35:15 PM
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
        <h1>Following items are added to your cart</h1>
        <c:forEach items='${requestScope.Cart}' var='cart'>
            <c:out value="${cart}" />
        </c:forEach>
        
        <ul>
            <li><a href="home.htm?action=showBooks">Books</a></li>
            <li><a href="home.htm?action=showComputers">Computers</a></li>
        </ul>
    </body>
</html>
