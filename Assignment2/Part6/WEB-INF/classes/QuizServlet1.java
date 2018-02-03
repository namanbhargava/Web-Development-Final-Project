import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuizServlet1 extends HttpServlet {
    //Service method
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Quiz</title>");
        out.println("</head>");
        out.println("<body>");
		out.println("<form action = 'quizservlet1' method = 'post'>");
            out.println("<p>How many children do you have?</p>");
            out.println("<input type='text' name='ans'/><br />");
			out.println("<input type='hidden' name='page' value='p1' />");
            out.println("<input type  = 'submit' value ='Next' name = 'button'/>");
		out.println("</form>");
        out.println("</body>");
        out.println("</html>");
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
		
		String page = request.getParameter("page");
		if(page.equals("p1"))
		{
			String ans1= request.getParameter("ans");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Quiz</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Page 2</h2>");
			out.println("<form method = 'post'>");
			int ans = Integer.valueOf(ans1);
			for(int i=1; i<=ans; i++)
				{
					out.println("Please enter name of child"+i);
					out.println("<input type='text' name='child'>");
					out.println("<br />");
				}	
			out.println("<input type ='submit'  value='Next' name = 'button'/><br /></p>");
			out.println("<input type='hidden' name='page' value='p2' />");
			out.println("</form>");
			out.println("<form method = 'get'>");
			out.println("<input type='submit' value='Back' />");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}else if(page.equals("p2"))
		{
			String[] childNames = request.getParameterValues("child");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Quiz</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Your childen names are</h2>");
			out.println("<ul>");
			for(String name: childNames)
			{
				out.println("<li>"+name+"</li>");
			}
			out.println("</ul>");
			out.println("</body>");
			out.println("</html>");
			
		}
    }
}
