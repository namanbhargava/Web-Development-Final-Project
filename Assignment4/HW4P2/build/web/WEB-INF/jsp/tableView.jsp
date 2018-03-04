<%-- 
    Document   : addMovies
    Created on : Feb 18, 2018, 9:38:27 PM
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
        <form action="redirectTableView.htm" method="post">
        <table>
            <tr>
            <th>isbn</th>
            <th>title</th>
            <th>author</th>
            <th>price</th>
            </tr>
               
                    <c:forEach var="i" begin="1" end="${sessionScope.numberofbooks}" >
                    <tr>
                        <td><input type="text" name="isbn" /></td>
                        <td><input type="text" name="title" /></td>
                        <td><input type="text" name="author" /></td>
                        <td><input type="text" name="price" /></td>
                    </tr>    
                    </c:forEach>
                     </table> 
                    <input type="submit" value="Add Books" />
                </form>
    </body>
</html>
