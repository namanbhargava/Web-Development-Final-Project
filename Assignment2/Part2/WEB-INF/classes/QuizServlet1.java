import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class QuizServlet1 extends HttpServlet {
    //Service method
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<HEAD><TITLE>PART1</TITLE></HEAD>");
		out.println("<b>Request Method:</b>  "+request.getMethod());
		out.println("<br />");
		out.println("<b>Request URI:</b>  "+request.getRequestURI()+"</b>");
		out.println("<br />");
		out.println("<b>Request Protocol:</b>  "+request.getProtocol());
		out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
						 "<TR BGCOLOR=\"#ccc\">\n" +
						 "<TH>Header Name<TH>Header Value");
		Enumeration headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
		String headerName = (String)headerNames.nextElement();
		out.println("<TR><TD>" + headerName);
		out.println(" <TD>" + request.getHeader(headerName));
		}
		
		
		out.println("</TABLE>");
		out.println("</BODY>");
		out.println("</HTML>");
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
}
}