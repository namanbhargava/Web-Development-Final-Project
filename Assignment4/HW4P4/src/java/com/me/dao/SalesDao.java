/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;
import com.me.pojo.Sales;
import java.sql.*;
import org.relique.jdbc.csv.CsvDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 *
 * @author bharg
 */
public class SalesDao {
    
    public boolean addToDb(Sales s){
        
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
        
        String sql = "INSERT INTO salestbl (SalesOrderID,RevisionNumber,OrderDate,DueDate,ShipDate,Status,OnlineOrderFlag,SalesOrderNumber,PurchaseOrderNumber,"
                + "AccountNumber,CustomerID,SalesPersonID,TerritoryID,BillToAddressID,ShipToAddressID,ShipMethodID,CreditCardID,CreditCardApprovalCode,SubTotal,TaxAmt,Freight,TotalDue,Comment,ModifiedDate,CurrencyRateID)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
          
        try {
                    PreparedStatement preparedStmt = connection.prepareStatement(sql);
                    
                    
                        preparedStmt.setInt(1, s.getSalesOrderID());
                        preparedStmt.setInt(2, s.getRevisionNumber());
                        preparedStmt.setString(3, s.getOrderDate());
                        preparedStmt.setString(4, s.getDueDate());
                        preparedStmt.setString(5, s.getShipDate());
                        preparedStmt.setInt(6, s.getStatus());
                        preparedStmt.setInt(7, s.getOnlineOrderFlag());
                        preparedStmt.setString(8, s.getSalesOrderNumber());
                        preparedStmt.setString(9, s.getPurchaseOrderNumber());
                        preparedStmt.setString(10, s.getAccountNumber());
                        preparedStmt.setInt(11, s.getCustomerID());
                        preparedStmt.setInt(12, s.getSalesPersonID());
                        preparedStmt.setInt(13, s.getTerritoryID());
                        preparedStmt.setInt(14, s.getBillToAddressID());
                        preparedStmt.setInt(15, s.getShipToAddressID());
                        preparedStmt.setInt(16, s.getShipMethodID());
                        preparedStmt.setInt(17, s.getCreditCardID());
                        preparedStmt.setString(18, s.getCreditCardApprovalCode());
                        
                        preparedStmt.setDouble(19, s.getSubTotal());
                        preparedStmt.setDouble(20, s.getTaxAmt());
                        preparedStmt.setDouble(21, s.getFreight());
                        preparedStmt.setDouble(22, s.getTotalDue());
                        preparedStmt.setString(23, s.getComment());
                        preparedStmt.setString(24, s.getModifiedDate());
                        preparedStmt.setString(25, s.getCurrencyRateID());
                        
                        preparedStmt.addBatch();
                        preparedStmt.executeBatch();
                        // execute the preparedstatement
                    //preparedStmt.execute();
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