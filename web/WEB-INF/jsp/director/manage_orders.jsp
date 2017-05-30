<%-- 
    Document   : manage_orders
    Created on : May 7, 2017, 4:21:46 PM
    Author     : Adam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Orders - Flow ERP</title>
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbardirector.html" /><br>  
        <div class="form">
        <h2>Orders</h2>
        <p>
            <form method="post" action="search_orders.htm">
                <input type="text" name="search" placeholder="name" >
                <button>Search</button>
            </form>
        </p>
        <table class="table">
            <tr class="row header"><th class="cell">ID</th><th class="cell">Target Date</th><th class="cell">Finished</th><th class="cell">Requester</th><th class="cell">Ordered Products</th><th class="cell">Actions</th><th class="cell">Delete</th></tr>
            <c:forEach items="${orders}" var="order" varStatus="counter">
                <tr class="row"><td>${order.getId()}</td>
                    <td class="cell">${order.getTargetDate()}</td>
                    <td class="cell">${order.isFinished()}</td>
                    <td class="cell">${order.getRequester()}</td>
                    <td class="cell">
                        <c:forEach items="${order.getOrderProductses()}" var="orderProduct">
                            ${orderProduct.getStocks().getName()} x${orderProduct.getAmount()}<br>
                        </c:forEach>
                    </td>
                    <td class="cell"><a href="edit_order.htm?id=${order.getId()}">Edit</a><br></td>
                    <td class="cell"><a href="delete_order.htm?id=${order.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <tr colspan="5">
            <td><a href="new_order.htm">Add new order</td>
        </tr>
    </div>
    </body>
</html>
