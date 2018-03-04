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
        
        if(action.equals("showExcel")){
            String fname = request.getParameter("filename");
            SalesDao sd = (SalesDao)this.getApplicationContext().getBean("salesdao");
            Sales s = (Sales)this.getApplicationContext().getBean("sales");
            ArrayList<Sales> salesList = sd.connectDb(fname);
            System.out.println(salesList);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("salesList", salesList);
            map.put("newField", "tableView");
            return new ModelAndView("index", "map", map);
        }
        else if (action.equals("addToDb")){
            
            String[] SalesOrderID = request.getParameterValues("salesOrderID");
            String[] RevisionNumber = request.getParameterValues("revisionNumber");
            String[] OrderDate = request.getParameterValues("orderDate");
            String[] DueDate = request.getParameterValues("dueDate");
            String[] ShipDate = request.getParameterValues("shipDate");
            String[] Status = request.getParameterValues("status");
            String[] OnlineOrderFlag = request.getParameterValues("onlineOrderFlag");
            String[] SalesOrderNumber = request.getParameterValues("salesOrderNumber");
            String[] PurchaseOrderNumber = request.getParameterValues("purchaseOrderNumber");
            String[] AccountNumber = request.getParameterValues("accountNumber");
            String[] CustomerID = request.getParameterValues("customerID");
            String[] SalesPersonID = request.getParameterValues("salesPersonID");
            String[] TerritoryID = request.getParameterValues("territoryID");
            String[] BillToAddressID = request.getParameterValues("billToAddressID");
            String[] ShipToAddressID = request.getParameterValues("shipToAddressID");
            String[] ShipMethodID = request.getParameterValues("shipMethodID");
            String[] CreditCardID = request.getParameterValues("creditCardID");
            String[] CreditCardApprovalCode = request.getParameterValues("creditCardApprovalCode");
            String[] CurrencyRateID = request.getParameterValues("currencyRateID");
            String[] SubTotal = request.getParameterValues("subTotal");
            String[] TaxAmt = request.getParameterValues("taxAmt");
            String[] Freight = request.getParameterValues("freight");
            String[] TotalDue = request.getParameterValues("totalDue");
            String[] Comment = request.getParameterValues("comment");
            String[] ModifiedDate = request.getParameterValues("modifiedDate");
            
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
