/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.MoviesDao;
import com.me.pojo.AddMovies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author bharg
 */
public class AddMoviesController extends SimpleFormController {
    
    public AddMoviesController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(AddMovies.class);
        setCommandName("movies");
        setSuccessView("successView");
        setFormView("redirectAddMovies");
    }
    
//    @Override
//    protected void doSubmitAction(Object command) throws Exception {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        ModelAndView mv = null;
        
        AddMovies am = (AddMovies)command;
        MoviesDao md = (MoviesDao)this.getApplicationContext().getBean("moviesdao");
        
        if(md.addToDb(am))
        {
            System.out.println("Move to success page");
            mv = new ModelAndView(getSuccessView());
        }
        //Do something...
      return mv;
    }
     
}
