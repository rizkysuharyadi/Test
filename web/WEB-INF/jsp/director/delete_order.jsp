<%-- 
    Document   : delete_order
    Created on : May 13, 2017, 2:37:06 PM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Order - Manage Orders - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbardirector.html" /><br>  
        <div class="form">
        <h2>Delete Order</h2>
        <p>Warning!</p>
        <p>Order Details:</p>
        <table class="table">
            <tr class="row"><td class="cell">ID:</td><td>${order.getId()}</td></tr>
            <tr class="row"><td class="cell">Requester:</td><td>${order.getRequester()}</td></tr>
            <tr class="row"><td class="cell">Status:</td><td>${order.isFinished()}</td></tr>
            <tr class="row"><td class="cell">Target date:</td><td>${order.getTargetDate()}</td></tr>
        </table>
        
        <form method="post" class="registerForm" action="delete_order.htm?confirm=true">
            <input type="hidden" name="id" value="${order.getId()}">
            <p>Confirm delete?</p>
            <button>Delete</button>
        </form>
        </div>
    </body>
</html>

