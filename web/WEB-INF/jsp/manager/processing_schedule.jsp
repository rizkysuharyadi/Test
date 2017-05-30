<%-- 
    Document   : processing_schedule
    Created on : May 17, 2017, 8:39:09 AM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing Schedule - Flow ERP</title>
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br> 
        <div class="form">
        <h2>Processing Schedule</h2>
        <table class="table">
            <tr class="row header"><th class="cell">Order</th><th class="cell">Requester</th><th class="cell">Ordered Products</th><th class="cell">Time Left</th></tr>
            <c:forEach items="${orders}" var="order" varStatus="counter">
                <tr class="row">
                    <td class="cell">${order.getProcessingOrder() + 1}</td>
                    <td class="cell">${order.getRequester()}</td>
                    <td class="cell">
                        <c:forEach items="${order.getOrderProductses()}" var="orderProduct">
                            ${orderProduct.getStocks().getName()} x${orderProduct.getAmount()}<br>
                        </c:forEach>
                    </td>
                    <td>${finishHours.get(counter.index)} Hours</td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>
