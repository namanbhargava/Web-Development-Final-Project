/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.AddMovies;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bharg
 */
public class MoviesDao {
    
    public boolean addToDb(AddMovies am){
        
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
        
        String sqlQuery = "INSERT INTO moviestbl (title, actor, actress, genre, year) "
                + "VALUES ('" + am.getTitle() + "', '" + am.getActor() + "','" + am.getActress() + "','" + am.getGenre() + "','" + am.getYear() + "')";
          
        try {
                 stmt.executeUpdate(sqlQuery);
                 System.out.println(sqlQuery);
                 System.err.println("Record Added Successfully!");
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
    
    public ArrayList<AddMovies> searchDb(String keyword, String option){
        
        java.sql.Connection connection = null;
        Statement stmt = null;
        ArrayList<AddMovies> movieList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "root");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        
        if(option.equals("title")){
            
            String sqlQuery = "SELECT * from moviestbl WHERE title = ?" ;
            
            try{
                PreparedStatement preparedStmt = connection.prepareStatement(sqlQuery);
                preparedStmt.setString(1, keyword);
                ResultSet rs = preparedStmt.executeQuery();
                
                while(rs.next())
                {
                    AddMovies am = new AddMovies();
                    am.setTitle(rs.getString(1));
                    am.setActor(rs.getString(2));
                    am.setActress(rs.getString(3));
                    am.setGenre(rs.getString(4));
                    am.setYear(rs.getString(5));
                    movieList.add(am);
                    
                    
                }
                
            }
            catch (SQLException ex) {
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
            
   }
        else if (option.equals("actor")){
        
            String sqlQuery = "SELECT * from moviestbl WHERE actor = ?" ;
            
            try{
                PreparedStatement preparedStmt = connection.prepareStatement(sqlQuery);
                preparedStmt.setString(1, keyword);
                ResultSet rs = preparedStmt.executeQuery();
                
                while(rs.next())
                {
                    AddMovies am = new AddMovies();
                    am.setTitle(rs.getString(1));
                    am.setActor(rs.getString(2));
                    am.setActress(rs.getString(3));
                    am.setGenre(rs.getString(4));
                    am.setYear(rs.getString(5));
                    movieList.add(am);
                    
                    
                }
                
            }
            catch (SQLException ex) {
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
            
            
        }
        else
        {
                String sqlQuery = "SELECT * from moviestbl WHERE actress = ?" ;
            
            try{
                PreparedStatement preparedStmt = connection.prepareStatement(sqlQuery);
                preparedStmt.setString(1, keyword);
                ResultSet rs = preparedStmt.executeQuery();
                
                while(rs.next())
                {
                    AddMovies am = new AddMovies();
                    am.setTitle(rs.getString(1));
                    am.setActor(rs.getString(2));
                    am.setActress(rs.getString(3));
                    am.setGenre(rs.getString(4));
                    am.setYear(rs.getString(5));
                    movieList.add(am);
                    
                    
                }
                
            }
            catch (SQLException ex) {
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
                }
        
        return movieList;
    }
    
    
    
}
