package in.developersera.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UpdateFilterRequestWrapper extends HttpServletRequestWrapper {

	public UpdateFilterRequestWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getParameter(String name){
         String data = super.getParameter(name);
         data = data.replaceAll("[^dA-Za-z0-9]", "");
         System.out.println("This is filtered data"+data);
         return data;
     }

	
	
}
