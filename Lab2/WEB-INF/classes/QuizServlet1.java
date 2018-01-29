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
        out.println("<h2>Page 1</h2>");
		out.println("<form action = 'quizservlet1' method = 'post'>");
            out.println("<p>Question 1: Which method doesn't exist in HttpServlet class:</p>");
            out.println("<input type='radio' name='ans' value='post'/>Post<br />");
            out.println("<input type='radio' name='ans' value='init' />Init<br />");
            out.println("<input type='radio' name='ans' value='get' />Get<br />");
            out.println("<input type='radio' name='ans' value='option' />Option<br />");
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
			session.setAttribute("answer1",ans1);
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Quiz</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Page 2</h2>");
			out.println("<form method = 'post'>");
			out.println("<p>Question 2 : Which method is called when client request came?</p>"
					+ "<input type='radio' name='ans' value='post' />Post<br />"
					+ "<input type='radio' name='ans' value='init' />Init<br />"
					+ "<input type='radio' name='ans' value='get' />Get<br />"
					+ "<input type='radio' name='ans' value='option' />Option<br />");
			out.println("<input type='hidden' name='page' value='p2' />");
			out.println("<input type =  'submit' value = 'Next' name = 'button'/><br /></p>");
			out.println("</form>");
			out.println("<form method = 'get'>");
			out.println("<input type='submit' value='Back' />");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}else if(page.equals("p2"))
		{
			String ans2= request.getParameter("ans");
			session.setAttribute("answer2",ans2);
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Quiz</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Page 3</h2>");
			out.println("<form method = 'post'>");
			out.println("<p>Question 3: Which HTTP method is idempotent ?</p>"
					+ "<input type='radio' name='ans' value='post' />Post<br />"
					+ "<input type='radio' name='ans' value='init' />Init<br />"
					+ "<input type='radio' name='ans' value='get' />Get<br />"
					+ "<input type='radio' name='ans' value='option' />Option<br />");
			out.println("<input type='hidden' name='page' value='p3' />");
			out.println("<input type ='submit' value = 'Next' name = 'button'/><br /></p>");
			out.println("</form>");
			out.println("<form method = 'post'>");
			out.println("<input type='hidden' name='page' value='p1' />");
			out.println("<input type='submit' value='Back' />");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
		}else if(page.equals("p3"))
		{
			String ans3= request.getParameter("ans");
			session.setAttribute("answer3",ans3);
			
			String a1= (String)session.getAttribute("answer1");
			String a2= (String)session.getAttribute("answer2");
			String a3= (String)session.getAttribute("answer3");
		
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Quiz</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Results here:</h2>");
			out.println("<h3>Answer1"+a1+"</h3>");
			out.println("<h3>Answer2"+a2+"</h3>");
			out.println("<h3>Answer3"+a3+"</h3>");
			out.println("</body>");
			out.println("</html>");
		}
    }
}
