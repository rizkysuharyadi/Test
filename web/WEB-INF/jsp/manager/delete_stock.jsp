<%-- 
    Document   : delete_stock
    Created on : May 13, 2017, 1:39:35 PM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Stock - Manage Stocks - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br> 
        <div class="form">
        <h2>Delete Stock</h2>
        <p>Warning!</p>
        <p>Stock Details:</p>
        <table class="table">
            <tr class="row"><td class="cell">ID:</td><td>${stock.getId()}</td></tr>
            <tr class="row"><td class="cell">Name:</td><td>${stock.getName()}</td></tr>
            <tr class="row"><td class="cell">Type:</td><td>${stock.getType()}</td></tr>
            <tr class="row"><td class="cell">Amount:</td><td>${stock.getAmount()}</td></tr>
        </table>
        
        <form method="post" action="delete_stock.htm?confirm=true">
            <input type="hidden" name="id" value="${stock.getId()}">
            <p>Confirm delete?</p>
            <button>Delete</button>
        </form>
        </div>
    </body>
</html>
