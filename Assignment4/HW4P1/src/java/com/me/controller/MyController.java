/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author bharg
 */
public class MyController extends AbstractController {
    
    public MyController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    
        ModelAndView mv = null;
        String sname= request.getParameter("slct");
        
        if(sname.equals("BrowseMovies"))
        {
            return new ModelAndView("browseMovies");
        }
        else
            return new ModelAndView("addMovies");
        
    }
    
}
