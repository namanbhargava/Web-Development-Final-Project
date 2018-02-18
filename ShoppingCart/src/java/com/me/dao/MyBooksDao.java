/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Products;
import java.util.ArrayList;


/**
 *
 * @author bharg
 */
public class MyBooksDao {

  public ArrayList<Products> getBooks() throws ClassNotFoundException{
      
      ArrayList<Products> bookList = new ArrayList<Products>();
      
      Products p1 = new Products();
      p1.setName("Java");
      p1.setPrice("$29.20");
      bookList.add(p1);
      
      Products p2 = new Products();
      p2.setName("C++");
      p2.setPrice("$42.20");
      bookList.add(p2);
      
      return bookList;
  }
    
}
