<%-- 
    Document   : browseMovies
    Created on : Feb 18, 2018, 9:38:06 PM
    Author     : bharg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Searching movies</h1>
        <form action="browse.htm" method='post' >
            <h4>KeyWord</h4>:<input type="text" name="keyword" />
            <input type="radio" name="radiobtn" value="title" />Search By Title <br />
            <input type="radio" name="radiobtn" value='actor' />Search By Actor <br />
            <input type="radio" name="radiobtn" value='actress' />Search By Actress <br />
            <input type="submit" value="Search" />
        </form>
    </body>
</html>
