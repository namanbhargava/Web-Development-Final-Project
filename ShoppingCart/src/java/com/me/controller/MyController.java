/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.MyBooksDao;
import com.me.dao.MyComputersDao;
import com.me.pojo.Products;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author bharg
 */
public class MyController extends AbstractController {
    
    
    public MyController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
            
            
            String page = request.getParameter("action");
            HttpSession session = request.getSession();
            if(page.equals("showBooks"))
            {
                //LoginDAO loginDAO = (LoginDAO) this.getApplicationContext().getBean("loginDAO");
                MyBooksDao mbd = (MyBooksDao)this.getApplicationContext().getBean("mybooksdao");
                ArrayList<Products> booklist = mbd.getBooks();
                ModelAndView mv= new ModelAndView("books","booklist",booklist);
                return mv;
            }
            else if(page.equals("showComputers"))
            {
                MyComputersDao mcd = (MyComputersDao)this.getApplicationContext().getBean("mycomputerdao");
                ArrayList<Products> complist = mcd.getComputers();
                ModelAndView mv= new ModelAndView("computers","compList",complist);
                return mv;
            }
            else if(page.equals("addItem"))
            {
                String[] bName = request.getParameterValues("bname");
                HashSet<String> Cart;
                if (null != session.getAttribute("Cart")) 
                    {
                        Cart = (HashSet<String>) session.getAttribute("Cart");
                    } 
                    else 
                    {
                        Cart = new HashSet<String>();
                    }
                
                for(String books: bName)
                {
                    Cart.add(books);
                }
                   session.setAttribute("Cart", Cart);
                   return new ModelAndView("viewcart","Cart",Cart); 
            }
            else if(page.equals("showCart"))
            {
                HashSet<String> Cart ;
                if ( null != session.getAttribute("Cart")){
                Cart = (HashSet<String>)session.getAttribute("Cart");
                return new ModelAndView("viewcart","Cart", Cart);
            }
            }
            
            return null;
     }
}
