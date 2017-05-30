<%-- 
    Document   : newjsp
    Created on : May 9, 2017, 9:58:49 AM
    Author     : Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete User - Manage Users - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbaradmin.html" /><br>  
        <div class="form">
        <h2>Delete User</h2>
        <p>Warning!</p>
        <p>User Details:</p>
        <table class="table">
            <tr class="row"><td class="cell">ID:</td><td>${account.getId()}</td></tr>
            <tr class="row"><td class="cell">Name:</td><td>${account.getName()}</td></tr>
            <tr class="row"><td class="cell">Username:</td><td>${account.getUsername()}</td></tr>
            <tr class="row"><td class="cell">Type:</td><td>${account.getType()}</td></tr>
        </table>
        <form method="post" class="registerForm" action="delete_user.htm?confirm=true">
            <input type="hidden" name="id" value="${account.getId()}">
            <p>Confirm delete?</p>
            <button>Delete</button>
        </form>
        </div>
    </body>
</html>
