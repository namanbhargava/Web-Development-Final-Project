<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>Welcome to our Movie Store</h1>
        
        <p>Please make your selection below</p>
        
            <form action="home.htm" method='post'>
            <select name='slct'>
                <option value="BrowseMovies">Browse Movies</option>
                <option value="AddMovies">Add New Movies in Database</option>
            </select>
            <input type='submit' value="Submit" />    
        </form>
        
    </body>
</html>
