package in.developersera.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import in.developersera.dao.CartDao;
import in.developersera.dao.CategoryDAO;
import in.developersera.dao.EmployeeDAO;
import in.developersera.dao.ProductDao;
import in.developersera.dao.UserDao;
import in.developersera.encryption.MyEncryption;
import in.developersera.pojo.Cart;
import in.developersera.pojo.Category;
import in.developersera.pojo.Employee;
import in.developersera.pojo.ProductPojo;
import in.developersera.pojo.UserPojo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	Employee employee;	
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserPojo userPojo;
	
	@Autowired
	ProductPojo productPojo;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDao	cartDao;
	
	@Autowired
	CategoryDAO categoryDao;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.dpk", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "home";
	}
	
	@RequestMapping(value = "/register-user.dpk", method = RequestMethod.GET)
	public String registerUser(Locale locale, Model model) {		
		return "register-user";
	}
	
	@RequestMapping(value = "/user-home.dpk", method = RequestMethod.GET)
	public String userHome(Locale locale, Model model) {		
		return "user-dashboard";
	}
	
	@RequestMapping(value = "/employee-login.dpk", method = RequestMethod.GET)
	public String employeeLogin(Locale locale, Model model) {
		return "employee-login";
	}
	
	@RequestMapping(value = "/dashboard.dpk", method = RequestMethod.GET)
	public String userDashboard(Locale locale, Model model) {		
		return "user-dashboard";
	}
	
	@RequestMapping(value = "/rejectProduct.dpk", method = RequestMethod.GET)
	public ModelAndView rejectProduct(HttpServletRequest request) {
		//int result = 0;
		List<ProductPojo>result = productDao.rejectProduct(Integer.parseInt(request.getParameter("id")));
		if(result.size() > 0)
			return new ModelAndView("home-access-control", "underReviewedProductsList", result);
		else {
			return new ModelAndView("home-access-control", "underReviewedProductsList", result);
		}
	}
	
	@RequestMapping(value = "/approveProduct.dpk", method = RequestMethod.GET)
	public ModelAndView approveProduct(HttpServletRequest request) {
		//int result = 0;
		List<ProductPojo> result = productDao.approveProduct(Integer.parseInt(request.getParameter("id")));
		if(result.size() > 0)
		{
			return new ModelAndView("home-access-control", "underReviewedProductsList", result);
		}
		else {
			return new ModelAndView("home-access-control", "underReviewedProductsList", result);
		}
		
	}
	
	
	@RequestMapping(value= "/employee-login-request.dpk", method = RequestMethod.POST)
	protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
		/* 
		 * Admin Credentials
		 * 
		 * INSERT INTO `employeeTable` (`employeeId`,`firstName`,`lastName`, `userName`, `password`, `role`) VALUES 
		 * (1,'Deepak','Chandwani', 'admin@husky.neu.edu', 'Admin', 'Admin'),
		 * (2,'Naman','Bhagrava', 'accesscontrol@husky.neu.edu', 'AccessControl', 'Access Control');
		 */
		 
		
        ModelAndView mv = null;
		HttpSession mySession = request.getSession(true);
        //String action = request.getParameter("action"); 
        String userName = request.getParameter("employee-email");
        String pas = request.getParameter("employee-password");
        String role = request.getParameter("employee-role");
        
        System.out.println("------------ User Entered----------------");
        System.out.println("email -> "+userName);
        System.out.println("role -> "+role);
        String encrytpPassword = MyEncryption.encPas(pas);        
        System.out.println("encrytpPassword -> "+encrytpPassword);//	1123499946 1123499946
        System.out.println("------------ User Entered----------------");
        
        
        Employee employeeCredentials = new Employee();
        employeeCredentials.setUserName(userName);
        employeeCredentials.setPassword(encrytpPassword);
        employeeCredentials.setRole(role);
        
        boolean success = false;
        Employee employeeResult = EmployeeDAO.checkEmployee(employeeCredentials);    
        
        try {
        if(!(employeeResult.equals(null)))
        {
        	System.out.println("------------DB User----------------");
            System.out.println("email -> "+employeeResult.getUserName());
            System.out.println("role -> "+employeeResult.getRole());
            System.out.println("------------DB User----------------");
        	
        	mySession.setAttribute("employee", employeeResult);
        	if("Admin".equalsIgnoreCase(employeeResult.getRole()))
        	{
        		mv = new ModelAndView("home-admin");
        	}else if("Access Control".equalsIgnoreCase(employeeResult.getRole()))
        	{
        		List<ProductPojo> productsList = productDao.getUnderReviewedProducts();
        		System.out.println("------------productList size----------------");
        		System.out.println("productListSize -> "+productsList.size());
        		System.out.println("------------productList size----------------");
        		mv = new ModelAndView("home-access-control", "underReviewedProductsList", productsList);
        	}	
        	
        }else
        {
        	mv = new ModelAndView("employee-login", "invalidCredentials", "true");
        }
        }catch(NullPointerException e)
        {
        	System.out.println("Nullpointer Exception "+ e.toString());
        	mv = new ModelAndView("employee-login", "invalidCredentials", "true");
        }
        
        return mv;
	}
	
	@RequestMapping(value= "user-login.dpk", method = RequestMethod.POST)
	protected ModelAndView loginUser(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        
        String userid = request.getParameter("user-email");
        String password = request.getParameter("user-password");
        System.out.println("userEmail -> "+userid);
        System.out.println("password -> "+password);
        
        //String pass = encPas(password);
        String encrytpPassword = MyEncryption.encPas(password); 
        System.out.println("password -> "+encrytpPassword);
        UserPojo userp = userDao.getUser(userid, encrytpPassword);
        
        if(userp == null)
        {
        	return new ModelAndView("home","errorMessage",true);
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("user", userp);
        session.setAttribute("role", "student");
        
        List<ProductPojo> prod = productDao.getProducts();
		//mv = new ModelAndView("user-dashboard", "prodList", prod);
		mv = new ModelAndView("user-dashboard");
        return mv;
        
	}
	
	
	
	@RequestMapping(value="/myInfo.dpk" , method=RequestMethod.GET)
	public ModelAndView getMyInfo(HttpServletRequest request) 
						throws Exception{
		ModelAndView mv = null;
	   
		
		try{
			mv= new ModelAndView("user-info");
		}
		catch(Exception e){
			System.out.println("AdopterController - getMyInfo");
		}
		return mv;
	}
	
	@RequestMapping(value="/myInfo.dpk" , method=RequestMethod.POST)
	public ModelAndView updateMyInfo(HttpServletRequest request) 
						throws Exception{
		ModelAndView mv = null;
	   
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
//		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
//		System.out.println(state);
		String phoneNumber = request.getParameter("phoneNumber");
//		System.out.println(phoneNumber);
		UserPojo usp = (UserPojo)request.getSession().getAttribute("user");
		
		//UserPojo usp = userDao.getUserDetails(userid);
		System.out.println("--------------fname--------------"+ usp.getFname());
		usp.setFname(fname);
		usp.setLname(lname);
//		usp.setAddress(address);
		usp.setCity(city);
		usp.setState(state);
		usp.setPhoneNumber(phoneNumber);
		
		UserPojo usp1 = (UserPojo)request.getSession().getAttribute("user");
		System.out.println("--------------New fname--------------"+usp1.getFname());
		
		userDao.updateUserDetails(usp);
		
		List<ProductPojo> prod = productDao.getProducts();
		
		mv = new ModelAndView("user-dashboard", "prodList", prod);
		//mv = new ModelAndView("sample","user",usp);
		return mv;
	}
	
	@RequestMapping(value="/logout.dpk", method = RequestMethod.GET)
	public String goToLoginPage(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value="/logout.dpk", method = RequestMethod.POST)
	public String goToLogin(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value="/getProductList.dpk", method=RequestMethod.POST, produces = MediaType.ALL_VALUE)
	public @ResponseBody String getProductListKeyword(HttpServletRequest request,HttpServletResponse response)
	{
		String keyword = request.getParameter("val");
		String tmp ="";
		if(!keyword.isEmpty())
		{
			List<ProductPojo> productList = productDao.getProductList(keyword);
			if(productList.size()==0)
			{
				tmp = "<table><tr><td><h3>Product is not available</h3></td></tr></table>";
			}
			else
			{
				tmp="<h3>Products available</h3>";
				tmp += "<table style='border: 1px solid black'>";
				for(int i=0;i<productList.size();i++)
				{
					
					tmp += "<tr><td><b>Product Id</b>:"+productList.get(i).getProductId()+"</td></tr>";
					tmp += "<tr><td><b>Product Name</b>:"+productList.get(i).getProductName()+"</td></tr>";
					tmp += "<tr><td><b>Product Price</b>:"+productList.get(i).getProductPrice()+"</td></tr>";
					tmp += "<tr><td><hr/></td></tr>";
				}
				
				tmp+="</table>";
			}
		}
				
		return tmp;
	}
	
	@RequestMapping(value="/view-all-products.dpk" , method=RequestMethod.GET)
	public ModelAndView viewAllProducts(HttpServletRequest request) 
						throws Exception{
		ModelAndView mv = null;
		
		int pagenumber= Integer.parseInt(request.getParameter("pageid"));
		HttpSession session = request.getSession();
		session.setAttribute("pageid", pagenumber);
		
		List<ProductPojo> prod = productDao.getLimitedProducts(pagenumber);
		List<Category> catList = categoryDao.getCategory();;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("products", prod);
		map.put("catList", catList);
		
		mv = new ModelAndView("viewProducts", "map", map);
		
		return mv;
		
	}	
	
//	@RequestMapping(value="/categorySpecificResult.dpk" , method=RequestMethod.GET)
//	public ModelAndView categorySpecificResult(HttpServletRequest request) 
//						throws Exception{
//		ModelAndView mv = null;
//		String selectedCategory = request.getParameter("selectedCategory");
//		System.out.println("selectedCategory "+selectedCategory);
//		Map<String, Object> map = new HashMap<String, Object>();
//		if(selectedCategory.equalsIgnoreCase("All Category")){
//			List<ProductPojo> filteredProducts = productDao.getProducts();
//			map.put("products", filteredProducts);		
//		}else if(selectedCategory != null){
//			List<ProductPojo> filteredProducts = productDao.getCategoryProducts(selectedCategory);
//			map.put("products", filteredProducts);
//		}
//		mv = new ModelAndView("viewProducts", "map", map);
//		return mv;		
//	}	
	
	@RequestMapping(value="/view-next-products.dpk" , method=RequestMethod.GET)
	public ModelAndView viewNextProducts(HttpServletRequest request) 
						throws Exception{
		ModelAndView mv = null;
		
		HttpSession session = request.getSession();
		int pagenumber = (Integer) session.getAttribute("pageid");
		pagenumber++;
		
		session.setAttribute("pageid", pagenumber);
		List<ProductPojo> prod = productDao.getLimitedProducts(pagenumber);
		if(prod.size() == 0)
		{
			System.out.println("Setting pageid to 1");
			session.setAttribute("pageid", 1);
			prod = productDao.getLimitedProducts(1);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("products", prod);
		mv = new ModelAndView("viewProducts", "map", map);
		System.out.println(session.getAttribute("pageid"));
		return mv;
		
	}	
	
	
	@RequestMapping(value="/view-previous-products.dpk" , method=RequestMethod.GET)
	public ModelAndView viewPreviousProducts(HttpServletRequest request) 
						throws Exception{
		ModelAndView mv = null;
		
		List<ProductPojo> prod = null;
		HttpSession session = request.getSession();
		int pagenumber = (Integer) session.getAttribute("pageid");
		if(pagenumber == 1)
		{
			prod = productDao.getLimitedProducts(1);
			
		}
		else
		{
			pagenumber--;
			session.setAttribute("pageid", pagenumber);
			prod = productDao.getLimitedProducts(pagenumber);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("products", prod);
		mv = new ModelAndView("viewProducts", "map", map);
		System.out.println(session.getAttribute("pageid"));
		return mv;
		
	}	
	
	@RequestMapping(value="/sell-products.dpk", method=RequestMethod.GET)
	public ModelAndView sellProducts(HttpServletRequest request, Model model) 
						throws Exception{		
		List<Category> categoryList = categoryDao.getCategory();
		System.out.println("categoryList -> "+categoryList.size());
		//Map<String, List<ProductPojo>> map = new HashMap<String, List<ProductPojo>>();
		//request.getSession().setAttribute("catList", categoryList);
		ModelAndView mv = new ModelAndView();
		mv.addObject("catList", categoryList);
		mv.addObject("product", new ProductPojo());
		mv.setViewName("seller-addProducts");
		return mv;
	}	
	
	@RequestMapping(value="/sell-products.dpk", method=RequestMethod.POST)
	public String handleUpload(@ModelAttribute("product") ProductPojo product, HttpServletRequest request) {
		String UPLOAD_PATH = "C:\\uploads\\";
		try {
			
			System.out.println("name-> "+product.getProductName());
			System.out.println("price-> "+product.getProductPrice());
			System.out.println("description-> "+product.getDescription());
			System.out.println("cat-> "+product.getCategory());
			
			
			//if (product.getTitle().trim() != "" || product.getTitle() != null) 
			{
				{					// We need to transfer to a file
					CommonsMultipartFile photoInMemory = product.getPhoto();

					String fileName = photoInMemory.getOriginalFilename();
					// could generate file names as well

					File localFile = new File(UPLOAD_PATH, fileName);

					// move the file from memory to the file

					photoInMemory.transferTo(localFile);
					product.setImageFilePath(UPLOAD_PATH+fileName);
					product.setStatus("under review");
					HttpSession session = request.getSession();
					UserPojo user = (UserPojo) session.getAttribute("user");
			        product.setUserPojo(user);
			        //session.getAttribute("role");
					System.out.println("File is stored at" + localFile.getPath());

					
					//product.setFilename(fileName);
					boolean success = productDao.create(product);
					System.out.println("---Product has been added.---");
					if(success)
						return "success";

				} 
			}

		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Inside FileController POST method");
		return "error";
	}
	
	@RequestMapping(value="/see-more-books.dpk", method=RequestMethod.GET)
	public ModelAndView seeMoreBooks(HttpServletRequest request) 
			throws Exception{
		return new ModelAndView("seeMoreBooks");
	}
	
	@RequestMapping(value="/toCart.dpk", method=RequestMethod.GET)
	public ModelAndView addToCart(HttpServletRequest request, @ModelAttribute("cart") Cart cart) 
			throws Exception{
		
		ModelAndView mv = null;
		ProductPojo pj = productDao.getProductFromId(Integer.parseInt(request.getParameter("id")));
		UserPojo up = (UserPojo)request.getSession().getAttribute("user");
		cart.setUserpojo(up);
		cart.setProductpojo(pj);
		cart.setQuantity(Integer.parseInt(request.getParameter("qty")));
		
		boolean status = cartDao.checkInCart(up.getUserid(), pj.getProductId());
		if(status)
		{
			cartDao.updateQuantity(cart);
		}
		else {
		
		cartDao.addProducttoCart(cart);
		}
		int pagenumber = (Integer)request.getSession().getAttribute("pageid");
		List<ProductPojo> prod = productDao.getLimitedProducts(pagenumber);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("products", prod);
		map.put("successMessage", "true");
		
		return new ModelAndView("viewProducts", "map", map);
	}
	
	@RequestMapping(value="/viewCart.dpk", method=RequestMethod.GET)
	public ModelAndView viewCart(HttpServletRequest request) 
			throws Exception{
		
		ModelAndView mv = null;
		UserPojo up = (UserPojo)request.getSession().getAttribute("user");
		System.out.println(up.getUserid());
		List<Cart> listcart = cartDao.getProductListFromId(up.getUserid());
		System.out.println("Size is"+listcart.size());
		return new ModelAndView("viewCart", "listcart", listcart);
	}
	
	@RequestMapping(value="/deleteFromCart.dpk", method=RequestMethod.GET)
	public ModelAndView deleteProductsFromCart(HttpServletRequest request) 
			throws Exception{
		
		ModelAndView mv = null;
		UserPojo pj = (UserPojo)request.getSession().getAttribute("user");
		String prodid = request.getParameter("id");
		List<Cart> listcart = cartDao.deleteProductsFromCart(pj.getUserid(),Integer.parseInt(prodid));
		return new ModelAndView("viewCart", "listcart", listcart);
	}
	
	@RequestMapping(value="/addOrder.dpk", method=RequestMethod.POST)
	public ModelAndView addOrder(HttpServletRequest request) 
			throws Exception{
		
		ModelAndView mv = null;
		UserPojo up = (UserPojo)request.getSession().getAttribute("user");
		List<Cart> listcart = cartDao.getProductListFromId(up.getUserid());
		System.out.println("Size is"+listcart.size());
		return new ModelAndView("finalReview", "listcart", listcart);
	}
	
	@RequestMapping(value="/success.dpk", method=RequestMethod.POST)
	public ModelAndView success(HttpServletRequest request) 
			throws Exception{
		
		ModelAndView mv = null;
		UserPojo up = (UserPojo)request.getSession().getAttribute("user");
		List<Cart> listcart = cartDao.getProductListFromId(up.getUserid());
		System.out.println("Size is"+listcart.size());
		String streetAddress = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pnumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		request.getSession().setAttribute("address", streetAddress);
		request.getSession().setAttribute("city", city);
		request.getSession().setAttribute("state", state);
		request.getSession().setAttribute("pnumber", pnumber);
		request.getSession().setAttribute("email", email);
		request.getSession().setAttribute("listcart", listcart);
		cartDao.updateStatus(up.getUserid());
		
		return new ModelAndView("orderSuccess", "listcart", listcart);
	}
	
	@RequestMapping(value="/booksPurchased.dpk", method=RequestMethod.GET)
	public ModelAndView booksPurchased(HttpServletRequest request) 
			throws Exception{
		
		
		ModelAndView mv = null;
		
		UserPojo up= (UserPojo) request.getSession().getAttribute("user");
		List<Cart> listCart = cartDao.getOrderedProducts(up);
		Set<String> cartSet = new HashSet<String>();
		for(Cart lc : listCart)
		{
			cartSet.add(lc.getProductpojo().getProductName());
		}
		
		List<String> newList = new ArrayList<String>(cartSet);
		request.getSession().setAttribute("newList", newList);
		
		return new ModelAndView("orderedProducts","newList", newList);
	}
	
	@RequestMapping(value = "/export.dpk", method = RequestMethod.POST)
	public ModelAndView exportData(HttpServletRequest request, ExcelSalesListReportView excel) {
		List<String> newList = (List<String>)request.getSession().getAttribute("newList");
		return new ModelAndView(excel, "newList", newList);
	}
	
	@RequestMapping(value = "/report.pdf", method = RequestMethod.POST)
	public ModelAndView generateReport(HttpServletRequest request, ExcelSalesListReportView excel) {
		Map<String,Object> model = new HashMap<String, Object>();
		model.put("listcart", request.getSession().getAttribute("listcart"));
		model.put("address", request.getSession().getAttribute("address"));
		model.put("city", request.getSession().getAttribute("city"));
		model.put("state", request.getSession().getAttribute("state"));
		model.put("pnumber", request.getSession().getAttribute("pnumber"));
		model.put("email", request.getSession().getAttribute("email"));
		model.put("user", request.getSession().getAttribute("user"));
		return new ModelAndView(new PdfReportView(), model);
	}
	
	
	
	
}




