<%-- 
    Document   : edit_stock
    Created on : May 13, 2017, 1:45:52 PM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Stock - Manage Stocks - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br>  
        <div class="form">
        <h2>Edit Stock</h2>
        <p>${message}</p>
        <form method="post" class="registerForm" action="edit_stock.htm" id="editStockForm">
            
            <input type="hidden" name="id" value="${stock.getId()}">
            <!--<table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${stock.getName()}" required/></td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td><input type="text" name="type" value="${stock.getType()}" required/></td>
                </tr>
                <tr>
                    <td>Amount:</td>
                    <td><input type="number" name="amount" required/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="Edit Stock"></td>
                </tr>
            </table>-->
            <input type="text" name="name" placeholder="name" value="${stock.getName()}" required/>
            <input type="text" name="type" placeholder="type" value="${stock.getType()}" required/>
            <input type="number" name="amount" placeholder="amount"  required/>
            <button>Edit Stock</button>
        </form>
        </div>
    </body>
</html>
