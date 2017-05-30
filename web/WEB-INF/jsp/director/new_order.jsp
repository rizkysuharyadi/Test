<%-- 
    Document   : new_order
    Created on : May 13, 2017, 2:54:52 PM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Order - Manage Orders - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbardirector.html" /><br>  
        <div class="form">
        <h2>New Order Form</h2>
        <p>${message}</p>
        <form method="post" class="registerForm" action="new_order.htm" id="newOrderForm">
            <!--<table>
                <tr>
                    <td>Target date:</td>
                    <td><input type="date" name="targetDate" required/></td>
                </tr>
                <tr>
                    <td>Requester</td>
                    <td><input type="text" size="30" name="requester" required/></td>
                </tr>
                <tr>
                    <td>Finished:</td>
                    <td><input type="checked" name="finished" required/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="Add New Order"></td>
                </tr>
            </table>-->
            <input type="date" name="targetDate" placeholder="target date" required/>
            <input type="text" name="requester" placeholder="requester" required/>
            <input type="checked" name="finished" placeholder="finished" required/>
            <button>Add Order</button>
        </form>
        </div>
    </body>
</html>
