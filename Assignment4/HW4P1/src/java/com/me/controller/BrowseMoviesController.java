/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.MoviesDao;
import com.me.pojo.AddMovies;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author bharg
 */
public class BrowseMoviesController extends AbstractController {
    
    public BrowseMoviesController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            ModelAndView mv = null;
        
        String keyword= request.getParameter("keyword");
        String option = request.getParameter("radiobtn");
        
        MoviesDao md = (MoviesDao)this.getApplicationContext().getBean("moviesdao");
        
        ArrayList<AddMovies> movieList = md.searchDb(keyword, option);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("movieList", movieList);
        return new ModelAndView("searchResult", "map", map);
        
    }
    
}
