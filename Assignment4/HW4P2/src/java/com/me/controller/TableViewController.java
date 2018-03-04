/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.TableDao;
import com.me.pojo.TablePojo;
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
public class TableViewController extends AbstractController {
    
    public TableViewController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv= null;
        
      String[] isbnList = request.getParameterValues("isbn");
      String[] titleList = request.getParameterValues("title");
      String[] authorList = request.getParameterValues("author");
      String[] priceList = request.getParameterValues("price");
        
      for( int i=0; i<isbnList.length; i++)
      {
          TablePojo tp = (TablePojo)this.getApplicationContext().getBean("tablepojo");
          tp.setIsbn(isbnList[i]);
          tp.setTitle(titleList[i]);
          tp.setAuthor(authorList[i]);
          tp.setPrice(priceList[i]);
          TableDao td = (TableDao)this.getApplicationContext().getBean("tabledao");
          td.addToDb(tp);
      }
        
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("quantity", isbnList.length);
        mv = new ModelAndView("successView","map",map);
        return mv;
    }
    
}
