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
public class MyComputersDao {
    
    public ArrayList<Products> getComputers(){
        
        ArrayList<Products> compList = new ArrayList();
        
        Products p1 = new Products();
        p1.setName("Dell");
        p1.setPrice("$629.20");
        compList.add(p1);

        Products p2 = new Products();
        p2.setName("HP");
        p2.setPrice("$500.20");
        compList.add(p2);
        
        return compList;
    }
    
}
