<%-- 
    Document   : edit_order
    Created on : May 19, 2017, 1:22:06 PM
    Author     : Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Order - Manage Orders - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbardirector.html" /><br>  
        <div class="form">
        <h2>Edit Order</h2>
        <p>${message}</p>
        <form method="post" class="registerForm" action="edit_order.htm" id="editOrderForm">
            
            <input type="hidden" name="id" value="${order.getId()}">
            <!--<table class="table">
                <tr>
                    <td>Target date:</td>
                    <td><input type="date" size="30" name="targetDate" value="${order.getTargetDate()}" required/></td>
                </tr>
                <tr>
                    <td>Requester</td>
                    <td><input type="text" size="30" name="requester" value="${order.getRequester()}" required/></td>
                </tr>
                <tr>
                    <td>Finished:</td>
                    <td><input type="checked" name="finished" value="${order.isFinished()}"required/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="Edit Order"></td>
                </tr>
            </table>-->
            <input type="date" name="targetDate" placeholder="targetDate" value="${order.getTargetDate()}" required/>
            <input type="text" name="requester" placeholder="requester" value="${order.getRequester()}" required/>
            <input type="checked" name="finished"  placeholder="finished" value="${order.isFinished()}"required/>
            <button>Edit Order</button>
        </form>
        </div>
    </body>
</html>
