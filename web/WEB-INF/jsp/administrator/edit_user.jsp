<%-- 
    Document   : edit_user
    Created on : May 7, 2017, 8:26:01 AM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User - Manage Users - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbaradmin.html" /><br>  
        <div class="form">
        <h2>Edit User</h2>
        <p>${message}</p>
        <form method="post" class="registerForm" action="edit_user.htm" id="editUserForm">
            
            <input type="hidden" name="id" value="${account.getId()}">
            <!--<table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${account.getName()}" required/></td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" value="${account.getUsername()}" required/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" required/></td>
                </tr>
                <tr>
                    <td>Confirm Password:</td>
                    <td><input type="password" name="confirmPassword" required/></td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td>
                        <select name="type" form="editUserForm" required/>
                            <option value="Administrator">Administrator</option>
                            <option value="Manager">Manager</option>
                            <option value="Director">Director</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Default Type:</td>
                    <td>${account.getType()}</td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="Edit User"></td>
                </tr>
            </table>-->
            <input type="text" name="name" placeholder="fullname" value="${account.getName()}" required/>
            <input type="text" name="username" placeholder="username" value="${account.getUsername()}" required/>
            <input type="password" placeholder="password" name="password" required/>
            <input type="password" placeholder="confirm password" name="confirmPassword" required/>
            <br>
            <select name="type" form="editUserForm" required/>
                <option value="Administrator">Administrator</option>
                <option value="Manager">Manager</option>
                <option value="Director">Director</option>
            </select><br>
            <p>Default Type: ${account.getType()}</p>
            <button>Edit User</button>
            
            
        </form>
        </div>
    </body>
</html>
