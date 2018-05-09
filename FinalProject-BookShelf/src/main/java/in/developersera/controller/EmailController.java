package in.developersera.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.developersera.dao.UserDao;
import in.developersera.encryption.MyEncryption;
import in.developersera.pojo.UserPojo;

@Controller
public class EmailController {
	
	@Autowired
	UserPojo userPojo;
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/register-user-success.dpk", method = RequestMethod.POST)
	protected ModelAndView registerUser(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
		ModelAndView mv = null;
		
        String userid = request.getParameter("userid");
        String password = request.getParameter("password"); 
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String city = request.getParameter("city");
        String state= request.getParameter("state");
        String phoneNumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        
        //String pass = encPas(password);
        String encrytpPassword = MyEncryption.encPas(password);
        
        
        userPojo.setUserid(userid);
        userPojo.setPassword(encrytpPassword);
        userPojo.setFname(fname);
        userPojo.setLname(lname);
        userPojo.setAddress(address);
        userPojo.setCity(city);
        userPojo.setState(state);
        userPojo.setPhoneNumber(phoneNumber);
        
        userDao.addToDb(userPojo);
        String message = "Welcome to the NU Market Place family "+fname+" "+lname+" you are successfully registered";
        sendEmail(userid, message);
        System.out.println("------------------ Register New USer---------------");
        System.out.println("userEmail -> "+userid);
        System.out.println("password -> "+password);
        System.out.println("password -> "+encrytpPassword);
        System.out.println("------------------ Register New USer---------------");
        
		mv = new ModelAndView("home");
        return mv;
     
    }
	
	public void sendEmail(String useremail, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			//String no_reply = "no-reply@numarketplace.com";
			String no_reply = "northeasternbookshelf@gmail.com";
			String pas = "janardan2";
			email.setAuthenticator(new DefaultAuthenticator(no_reply, pas));
			email.setSSLOnConnect(true);
			email.setFrom(no_reply); // This user email does not
													// exist
			email.setSubject("Northeastern Book-Shelf registeration is Successful");
			email.setMsg(message); // Retrieve email from the DAO and send this
			email.addTo(useremail);
			email.send();
		} catch (EmailException e) {
			System.out.println("Email cannot be sent");
		}
	}
	
	
}
