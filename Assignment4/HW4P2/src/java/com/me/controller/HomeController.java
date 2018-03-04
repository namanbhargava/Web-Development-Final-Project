/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author bharg
 */
public class HomeController extends AbstractController {
    
    public HomeController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mv = null;
        
        String value = request.getParameter("booksno");
        
        HttpSession session = request.getSession();
        session.setAttribute("numberofbooks", value);
        
        mv = new ModelAndView("tableView","val",value);
        
        return mv;
    }
    
}
