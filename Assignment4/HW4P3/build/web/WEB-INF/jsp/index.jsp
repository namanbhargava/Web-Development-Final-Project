<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h3>Enter the name of the file</h3>
        <form action="home.htm" method="post" >
            <input type="text" name="filename" />
            <input type="submit" value="Submit" />
            <input type="hidden" name="action" value="showExcel" />
        </form>
        
        <c:if test= "${requestScope.map2.newField eq 'dbView'}" >
                <h1>Number of records added: ${requestScope.map2.quantity}</h1>
         </c:if>
        
        <c:if test = "${requestScope.map.newField eq 'tableView'}" >
            <form action="home.htm" method="post" >
                <input type="submit" value="Submit Form" />
                <input type="hidden" name="action" value="addToDb" />
                <table>
                    <tr>
                        <th>Sales Order ID</th>
                        <th>Revision Number</th>
                        <th>OrderDate</td>
                        <th>DueDate</th>
                        <th>ShipDate</th>
                        <th>Status</th>
                        <th>OnlineOrderFlag</th>
                        <th>SalesOrderNumber</th>
                        <th>PurchaseOrderNumber</th>
                        <th>AccountNumber</th>
                        <th>CustomerID</th>
                        <th>SalesPersonID</th>
                        <th>TerritoryID</th>
                        <th>BillToAddressID</th>
                        <th>ShipToAddressID</th>
                        <th>ShipMethodID</th>
                        <th>CreditCardID</th>
                        <th>CreditCardApprovalCode</th>
                        <th>CurrencyRateID</th>
                        <th>SubTotal</th>
                        <th>TaxAmt</th>
                        <th>Freight</th>
                        <th>TotalDue</th>
                        <th>Comment</th>
                        <th>ModifiedDate</th>
                    </tr>
                    <c:forEach items="${requestScope.map.salesList}" var="sales" >
                        <tr>
                            <td><input type="text" name="salesOrderID" value="${sales.salesOrderID}" /></td>
                            <td><input type="text" name="revisionNumber" value="${sales.revisionNumber}"</td>
                            <td><input type="text" name="orderDate" value="${sales.orderDate}" /></td>
                            <td><input type="text" name="dueDate" value="${sales.dueDate}"</td>
                            <td><input type="text" name="shipDate" value="${sales.shipDate}" /></td>
                            <td><input type="text" name="status" value="${sales.status}"</td>
                            <td><input type="text" name="onlineOrderFlag" value="${sales.onlineOrderFlag}" /></td>
                            <td><input type="text" name="salesOrderNumber" value="${sales.salesOrderNumber}"</td>
                            <td><input type="text" name="purchaseOrderNumber" value="${sales.purchaseOrderNumber}" /></td>
                            <td><input type="text" name="accountNumber" value="${sales.accountNumber}"</td>
                            <td><input type="text" name="customerID" value="${sales.customerID}" /></td>
                            <td><input type="text" name="salesPersonID" value="${sales.salesPersonID}"</td>
                            <td><input type="text" name="territoryID" value="${sales.territoryID}" /></td>
                            <td><input type="text" name="billToAddressID" value="${sales.billToAddressID}"</td>
                            <td><input type="text" name="shipToAddressID" value="${sales.shipToAddressID}" /></td>
                            <td><input type="text" name="shipMethodID" value="${sales.shipMethodID}"</td>
                            <td><input type="text" name="creditCardID" value="${sales.creditCardID}" /></td>
                            <td><input type="text" name="creditCardApprovalCode" value="${sales.creditCardApprovalCode}"</td>
                            <td><input type="text" name="currencyRateID" value="${sales.currencyRateID}" /></td>
                            <td><input type="text" name="subTotal" value="${sales.subTotal}"</td>
                            <td><input type="text" name="taxAmt" value="${sales.taxAmt}" /></td>
                            <td><input type="text" name="freight" value="${sales.freight}"</td>
                            <td><input type="text" name="totalDue" value="${sales.totalDue}" /></td>
                            <td><input type="text" name="comment" value="${sales.comment}"</td>
                            <td><input type="text" name="modifiedDate" value="${sales.modifiedDate}"</td>

                        </tr>
                    </c:forEach>           
                </table>
            </form>
        </c:if>
        
    </body>
</html>
