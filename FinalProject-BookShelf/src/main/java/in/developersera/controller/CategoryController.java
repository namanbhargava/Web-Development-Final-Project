package in.developersera.controller;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import in.developersera.dao.CategoryDAO;
import in.developersera.exception.CategoryException;
import in.developersera.pojo.Category;
import in.developersera.validator.CategoryValidator;


@Controller
public class CategoryController {

		@Autowired
		@Qualifier("categoryValidator")
		CategoryValidator categoryValidator;
		
		@Autowired
		@Qualifier("categoryDao")
		CategoryDAO categoryDAO;

//		@InitBinder
//		private void initBinder(WebDataBinder binder) {
//			binder.setValidator(categoryValidator);
//		}

		@RequestMapping(value = "/addCategory.dpk", method = RequestMethod.POST)
		public ModelAndView addCategory(@ModelAttribute("category") Category category, BindingResult result, HttpServletRequest request,HttpServletResponse response) throws Exception {
			
			ModelAndView mv = null;
			
			String authorization = request.getHeader("Authorization");
	        if (authorization == null) {
	        	askForPassword(response);
	        	} 
	        else
	        {
			String userInfo = authorization.substring(5).trim();
			System.out.println(userInfo);
			String nameAndPassword = new String(Base64.getDecoder().decode(userInfo));
			//byte[] dec = DatatypeConverter.parseBase64Binary(userInfo);
			//String nameAndPassword = null;
//			try {
//				nameAndPassword = new String(dec,"UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(nameAndPassword);
			//BASE64Decoder decoder = new BASE64Decoder();
			//String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
			// Decoded part looks like "username:password".
			int index = nameAndPassword.indexOf(":");
			//System.out.println(index);
			String user = nameAndPassword.substring(0, index);
			String password = nameAndPassword.substring(index+1);
			 
			if(user.equals("admin")) {
				//categoryValidator.setCategoryDAO(this.categoryDAO);
				categoryValidator.validate(category, result);
				
				if (result.hasErrors()) {
					return new ModelAndView("category-form", "category", category);
				}

				try {
					Category cat = categoryDAO.get(category.getTitle());
					
					if(cat == null)
					{
						System.out.println("---------Creating new title---------");
						category = categoryDAO.create(category.getTitle());
					}
					else {
						return new ModelAndView("category-form", "errorMessage", "The name already exists");
					}
					
				} catch (CategoryException e) {
					System.out.println(e.getMessage());
				}
				return new ModelAndView("category-form", "success", "The category is successfully created");
			}
			else {
				mv = new ModelAndView("error");
			}
	        }
			return mv;
		}
		     
	        
	        private void askForPassword(HttpServletResponse response) {
	    		// SC_UNAUTHORIZED is 401
	    		response.setStatus(response.SC_UNAUTHORIZED); response.setStatus(response.SC_UNAUTHORIZED);
	    		response.setHeader
	    		("WWW-Authenticate",
	    		"BASIC realm BASIC realm=\"Insider Insider-Trading Trading\"");
	    		}

		@RequestMapping(value="/addCategory.dpk", method = RequestMethod.GET)
		public ModelAndView initializeForm() throws Exception {			
			return new ModelAndView("category-form", "category", new Category());
		}


}