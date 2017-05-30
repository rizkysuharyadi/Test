<%-- 
    Document   : new_process
    Created on : May 16, 2017, 10:21:09 AM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Process - Manage Processes - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br> 
        <div class="form">
        <h2>New Process Form</h2>
        <p>${message}</p>
        <form method="post" class="registerForm" action="new_process.htm" id="newProcessForm">
            <!--<table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" size="30" name="name" required/></td>
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
                    <td><input type="text" size="30" name="resultAmount" required/></td>
                </tr>
                <tr>
                    <td>Error Chance</td>
                    <td><input type="text" size="30" name="errorChance" required/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="Add New Process"></td>
                </tr>
            </table>-->
            <input type="text" name="name" placeholder="name" required/>
            <input type="text" name="materialId" placeholder="material ID" required/>
            <input type="text" name="materialAmount" placeholder="material amount" required/>
            <input type="text" name="resultId" placeholder="result ID" required/>
            <input type="text" name="resultAmount" placeholder="result amount" required/>
            <input type="text" name="errorChance" placeholder="error chance" required/>
            <input type="number" name="amount" placeholder="amount"  required/>
            <button>Add Process</button>
        </form>
        </div>
    </body>
</html>
