<%-- 
    Document   : new_user
    Created on : May 7, 2017, 8:26:11 AM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User - Manage Users - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbaradmin.html" /><br>  
        <div class="form">
        <h2>New User Form</h2>
        <p>${message}</p>
        <form method="post" class="registerForm" action="new_user.htm" id="newUserForm">
            <!--<table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" size="30" name="name" required/></td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" size="30" name="username" required/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" size="30" name="password" required/></td>
                </tr>
                <tr>
                    <td>Confirm Password:</td>
                    <td><input type="password" size="30" name="confirmPassword" required/></td>
                </tr>-->
            <input type="text" name="name" placeholder="fullname" required/>
            <input type="text" name="username" placeholder="username" required/>
            <input type="password" name="password" placeholder="password" required/>
            <input type="password" name="confirmPassword" placeholder="confirm password" required/>
                <!--<tr>
                    <td>Type</td>
                    <td>
                        <select name="type" form="newUserForm">
                            <option value="Administrator">Administrator</option>
                            <option value="Manager">Manager</option>
                            <option value="Director">Director</option>
                        </select>
                    </td>
                </tr>
                
                <tr colspan="2">
                    <td><input type="submit" value="Add New User"></td>
                </tr>
            </table>-->
                <br>
                <select name="type" form="newUserForm">
                    <option value="Administrator">Administrator</option>
                    <option value="Manager">Manager</option>
                    <option value="Director">Director</option>
                </select>
                <br><br>
                <button>Add New User</button>
        </form>
        </div>
    </body>
</html>
