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
        <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
        <c:redirect url = "redirectAddMovies.htm" />
    </body>
</html>
