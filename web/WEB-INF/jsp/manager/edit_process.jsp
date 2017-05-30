<%-- 
    Document   : edit_process
    Created on : May 21, 2017, 5:53:20 PM
    Author     : Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Process - Manage Processes - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br> 
        <div class="form">
        <h2>Edit Process</h2>
        <p>${message}</p>
        <form method="post" class="registerForm" action="edit_process.htm" id="editProcessForm">
            <input type="hidden" name="id" value="${process.getId()}">
            <!--<table class="table">
                <tr>
                    <td>Name</td>
                    <td><input type="text" size="30" name="name" value="${process.getName()}" required/></td>
                </tr>
                <tr>
                    <td>Material ID</td>
                    <td><input type="text" size="30" name="materialId" required/></td>
                </tr>
                <tr>
                    <td>Material Amount</td>
                    <td><input type="text" size="30" name="materialAmount" required/></td>
                </tr>
                <tr>
                    <td>Result ID</td>
                    <td><input type="text" size="30" name="resultId" required/></td>
                </tr>
                <tr>
                    <td>Result Amount</td>
                    <td><input type="text" size="30" name="resultAmount" value="${order.getResultAmount()}" required/></td>
                </tr>
                <tr>
                    <td>Error Chance</td>
                    <td><input type="text" size="30" name="errorChance" value="${process.getErrorChance()}" required/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="Edit Process"></td>
                </tr>
            </table>-->
            <input type="text" name="name" placeholder="name" value="${process.getName()}" required/>
            <input type="text" name="materialId" placeholder="material ID" required/>
            <input type="text" name="materialAmount" placeholder="material amount" required/>
            <input type="text" name="resultId" placeholder="result ID" required/>
            <input type="text" name="resultAmount" placeholder="result amount" value="${order.getResultAmount()}" required/>
            <input type="text" name="errorChance" placeholder="error chance" value="${process.getErrorChance()}" required/>
            <input type="number" name="amount" placeholder="amount"  required/>
            <button>Edit Process</button>
        </form>
        </div>
    </body>
</html>
