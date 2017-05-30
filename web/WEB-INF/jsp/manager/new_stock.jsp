<%-- 
    Document   : new_stock
    Created on : May 13, 2017, 12:39:10 PM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Stock - Manage Stocks - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br> 
        <div class="form">
        <h2>New Stock Form</h2>
        <p>${message}</p>
        <form method="post" class="registerForm" action="new_stock.htm" id="newStockForm">
            <!--<table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" size="30" name="name" required/></td>
                </tr>
                <tr>
                    <td>Type:</td>
                 <td><input type="radio" name="type" value="material"> Material  
                        <input type="radio" name="type" value="result"> Result </td>  
                    <td><input type="text" size="30" name="type" required/></td>
                </tr>
                <tr>
                    <td>Amount:</td>
                    <td><input type="number" size="30" name="amount" required/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="Add New Stock"></td>
                </tr>
            </table>-->
            <input type="text" name="name" placeholder="name" required/>
            <input type="text" name="type" placeholder="type" required/>
            <input type="number" name="amount" placeholder="amount"  required/>
            <button>Add Stock</button>
        </form>
        </div>
    </body>
</html>

