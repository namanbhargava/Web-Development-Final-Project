<%-- 
    Document   : books
    Created on : Feb 18, 2018, 1:30:56 PM
    Author     : bharg
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is Books page</h1>
        
        <form action="home.htm?action=addItem" method="post"> 
        <c:forEach items="${requestScope.booklist}" var="book">
            <input type='checkbox' name='bname' value='${book.name}' />
            ${book.name} | ${book.price} [<a href="home.htm?action=addItem&bname=${book.name}">Add to cart</a>]<br />
        </c:forEach>
            <input type="submit" value="Add to cart" />
        </form>
        
        <ul>
            <li><a href="home.htm?action=showBooks">Books</a></li>
            <li><a href="home.htm?action=showComputers">Computers</a></li>
        </ul>
        
        <a href="home.htm?action=showCart">View Cart</a>
        
        
        
    </body>
</html>
