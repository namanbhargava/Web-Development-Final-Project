/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author bharg
 */
public class MyCustomTag extends SimpleTagSupport {
    
    @Override
    public void doTag() throws IOException
    {
        
         String filename = (String) getJspContext().getAttribute("filename", PageContext.SESSION_SCOPE);
         System.out.println(filename);
         try {
           
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:\\Naman");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+ filename);
            JspWriter out = getJspContext().getOut();            
            out.println("<form action=\"home.htm\" method=\"post\">\n" +
"                        <input type=\"submit\" value=\"Submit\" name=\"Submit\"/>\n" +
"                        <input type=\"hidden\" name=\"action\" value=\"addToDb\" />\n" +
"                    <table border=\"1\">\n" +
"                    <tr>\n" +
"                        <td>SalesOrderID</td>\n" +
"                        <td>RevisionNumber</td>\n" +
"                        <td>OrderDate</td>\n" +
"                        <td>DueDate</td>\n" +
"                        <td>ShipDate</td>\n" +
"                        <td>Status</td>\n" +
"                        <td>OnlineOrderFlag</td>\n" +
"                        <td>SalesOrderNumber</td>\n" +
"                        <td>PurchaseOrderNumber</td>\n" +
"                        <td>AccountNumber</td>\n" +
"                        <td>CustomerID</td>\n" +
"                        <td>SalesPersonID</td>\n" +
"                        <td>TerritoryID</td>\n" +
"                        <td>BillToAddressID</td>\n" +
"                        <td>ShipToAddressID</td>\n" +
"                        <td>ShipMethodID</td>\n" +
"                        <td>CreditCardID</td>\n" +
"                        <td>CreditCardApprovalCode</td>\n" +
"                        <td>CurrencyRateID</td>\n" +
"                        <td>SubTotal</td>\n" +
"                        <td>TaxAmt</td>\n" +
"                        <td>Freight</td>\n" +
"                        <td>TotalDue</td>\n" +
"                        <td>Comment</td>\n" +
"                        <td>ModifiedDate</td>\n" +
"                    </tr>    ");
            //loop through rs
            while(rs.next()){    
                out.println("                       <tr>\n" +
"                            <td><input type=\"text\" name= \"SalesOrderID\" value=" + rs.getInt(1) + " readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"RevisionNumber\" value="+ rs.getInt(2)+ " readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"OrderDate\" value=" +rs.getString(3) +" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"DueDate\" value="+rs.getString(4)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"ShipDate\" value="+rs.getString(5)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"Status\" value="+rs.getInt(6)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"OnlineOrderFlag\" value="+rs.getInt(7)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"SalesOrderNumber\" value="+rs.getString(8)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"PurchaseOrderNumber\" value="+rs.getString(9)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"AccountNumber\" value="+rs.getString(10)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"CustomerID\" value="+rs.getInt(11)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"SalesPersonID\" value="+rs.getInt(12)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"TerritoryID\" value="+rs.getInt(13)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"BillToAddressID\" value="+rs.getInt(14)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"ShipToAddressID\" value="+rs.getInt(15)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"ShipMethodID\" value="+rs.getInt(16)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"CreditCardID\" value="+rs.getInt(17)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"CreditCardApprovalCode\" value="+rs.getString(18)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"CurrencyRateID\" value="+rs.getString(19)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"SubTotal\" value="+rs.getDouble(20)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"TaxAmt\" value="+rs.getDouble(21)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"Freight\" value="+rs.getDouble(22)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"TotalDue\" value="+rs.getDouble(23)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"Comment\" value="+rs.getString(24)+" readonly=\"\"/></td>\n" +
"                            <td><input type=\"text\" name= \"ModifiedDate\" value="+rs.getString(25)+" readonly=\"\"/></td>\n" +
"                        </tr>");
            }   
            
                out.println("</table>\n" +
"                    </form>");
                conn.close();
                stmt.close();
                rs.close();
            } catch (Exception e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }    
        
    }
}
