<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.util.*" %>

		<HTML>
		<BODY>
		<HEAD>
		<TITLE>PART3</TITLE>
		<style>
			table,td,th{border:1px solid #ccc}
		</style>
		
		</HEAD>
		<h3> Welcome to JSP page</h3>
		<b>Request Method:</b> <%= request.getMethod() %> 
		<br />
		<b>Request URI:</b> <%= request.getRequestURI() %>
		<br />
		<b>Request Protocol:</b> <%= request.getProtocol() %>
		<hr />
		<br />
		<table>
			<tr>
				<th>Header Name</th>
				<th>Header Value</th>
			</tr>
		<% Enumeration headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
		String headerName = (String)headerNames.nextElement();  %>
			<tr>
				<td><%= headerName %></td>
				<td><%= request.getHeader(headerName) %></td>
			</tr>
		
		<%} %>
		</table>
		
		
		
		</BODY>
		</HTML>
		
	