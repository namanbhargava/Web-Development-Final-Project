/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.SalesDao;
import com.me.pojo.Sales;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author bharg
 */
public class HomeController extends AbstractController {
    
    public HomeController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if(action.equals("showExcel")){
            String filename = request.getParameter("filename");
            Map<String, Object> map = new HashMap<String, Object>();
            session.setAttribute("filename", filename);
            map.put("filename",filename);
            map.put("newField", "tableView");
            return new ModelAndView("index", "map", map);
        }
        else if(action.equals("addToDb"))
        {
            String[] SalesOrderID = request.getParameterValues("SalesOrderID");
            String[] RevisionNumber = request.getParameterValues("RevisionNumber");
            String[] OrderDate = request.getParameterValues("OrderDate");
            String[] DueDate = request.getParameterValues("DueDate");
            String[] ShipDate = request.getParameterValues("ShipDate");
            String[] Status = request.getParameterValues("Status");
            String[] OnlineOrderFlag = request.getParameterValues("OnlineOrderFlag");
            String[] SalesOrderNumber = request.getParameterValues("SalesOrderNumber");
            String[] PurchaseOrderNumber = request.getParameterValues("PurchaseOrderNumber");
            String[] AccountNumber = request.getParameterValues("AccountNumber");
            String[] CustomerID = request.getParameterValues("CustomerID");
            String[] SalesPersonID = request.getParameterValues("SalesPersonID");
            String[] TerritoryID = request.getParameterValues("TerritoryID");
            String[] BillToAddressID = request.getParameterValues("BillToAddressID");
            String[] ShipToAddressID = request.getParameterValues("ShipToAddressID");
            String[] ShipMethodID = request.getParameterValues("ShipMethodID");
            String[] CreditCardID = request.getParameterValues("CreditCardID");
            String[] CreditCardApprovalCode = request.getParameterValues("CreditCardApprovalCode");
            String[] CurrencyRateID = request.getParameterValues("CurrencyRateID");
            String[] SubTotal = request.getParameterValues("SubTotal");
            String[] TaxAmt = request.getParameterValues("TaxAmt");
            String[] Freight = request.getParameterValues("Freight");
            String[] TotalDue = request.getParameterValues("TotalDue");
            String[] Comment = request.getParameterValues("Comment");
            String[] ModifiedDate = request.getParameterValues("ModifiedDate");
            
            for(int i = 0; i < SalesOrderID.length; i++){
                SalesDao sd = (SalesDao)this.getApplicationContext().getBean("salesdao");
                Sales s = (Sales)this.getApplicationContext().getBean("sales");
                s.setSalesOrderID(Integer.parseInt(SalesOrderID[i]));
                s.setRevisionNumber(Integer.parseInt(RevisionNumber[i]));
                s.setOrderDate(OrderDate[i]);
                s.setDueDate(DueDate[i]);
                s.setShipDate(ShipDate[i]);
                s.setStatus(Integer.parseInt(Status[i]));
                s.setOnlineOrderFlag(Integer.parseInt(OnlineOrderFlag[i]));
                s.setSalesOrderNumber(SalesOrderNumber[i]);
                s.setPurchaseOrderNumber(PurchaseOrderNumber[i]);
                s.setAccountNumber(AccountNumber[i]);
                s.setCustomerID(Integer.parseInt(CustomerID[i]));
                s.setSalesPersonID(Integer.parseInt(SalesPersonID[i]));
                s.setTerritoryID(Integer.parseInt(TerritoryID[i]));
                s.setBillToAddressID(Integer.parseInt(BillToAddressID[i]));
                s.setShipToAddressID(Integer.parseInt(ShipToAddressID[i]));
                s.setShipMethodID(Integer.parseInt(ShipMethodID[i]));
                s.setCreditCardID(Integer.parseInt(CreditCardID[i]));
                s.setCreditCardApprovalCode(CreditCardApprovalCode[i]);
                s.setCurrencyRateID(CurrencyRateID[i]);
                s.setSubTotal(Double.parseDouble(SubTotal[i]));
                s.setTaxAmt(Double.parseDouble(TaxAmt[i]));
                s.setFreight(Double.parseDouble(Freight[i]));
                s.setTotalDue(Double.parseDouble(TotalDue[i]));
                s.setComment(Comment[i]);
                s.setModifiedDate(ModifiedDate[i]);           
                boolean result = sd.addToDb(s);
            }
             
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("quantity", SalesOrderID.length);
            map2.put("newField", "dbView");
            return new ModelAndView("index", "map2", map2);
            
        }
        
        return mv;
    }
    
}
