/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.TablePojo;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bharg
 */
public class TableDao {
    
    public boolean addToDb(TablePojo tp){
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "root");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        //stem.out.println(login.getUsername());
        
        String sqlQuery = "INSERT INTO bookstbl (isbn, title, author, price) "
                + "VALUES (?,?,?,?)";
          
        try {
                    PreparedStatement preparedStmt = connection.prepareStatement(sqlQuery);
                    preparedStmt.setString (1, tp.getIsbn());
                    preparedStmt.setString (2, tp.getTitle());
                    preparedStmt.setString (3, tp.getAuthor());
                    preparedStmt.setString (4, tp.getPrice());
                    
                    // execute the preparedstatement
                    preparedStmt.execute();
                    connection.close();
                    System.out.println("Record inserted!!");
                    return true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }

        return false;
    }
    
}
