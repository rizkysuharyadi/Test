<%-- 
    Document   : delete_process
    Created on : May 20, 2017, 9:36:53 AM
    Author     : Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Process - Manage Processes - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br> 
        <div class="form">
        <h2>Delete Process</h2>
        <p>Warning!</p>
        <p>Process Details:</p>
        <table class="table">
            <tr class="row"><td class="cell">ID:</td><td>${process.getId()}</td></tr>
            <tr class="row"><td class="cell">Name:</td><td>${process.getName()}</td></tr>
        </table>
        
        <form method="post" action="delete_process.htm?confirm=true">
            <input type="hidden" name="id" value="${process.getId()}">
            <p>Confirm delete?</p>
            <button>Delete</button>
        </form>
        </div>
    </body>
</html>
