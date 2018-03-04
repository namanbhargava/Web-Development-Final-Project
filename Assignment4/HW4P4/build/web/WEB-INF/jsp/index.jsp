<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mytaglib" uri="/WEB-INF/tlds/myTaglib.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
       <h3>Enter the name of the file</h3>
        <form action="home.htm" method="post" >
            <input type="text" name="filename" />
            <input type="submit" value="Submit" />
            <input type="hidden" name="action" value="showExcel" />
        </form>
       
    <c:if test = "${requestScope.map.newField eq 'tableView'}" >
        <mytaglib:mytag/>
    </c:if>
       
       <c:if test= "${requestScope.map2.newField eq 'dbView'}" >
                <h1>Number of records added: ${requestScope.map2.quantity}</h1>
         </c:if>
       
    </body>
</html>
