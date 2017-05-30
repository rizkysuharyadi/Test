<%-- 
    Document   : manage_processes
    Created on : May 19, 2017, 9:37:06 AM
    Author     : Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Processes - Flow ERP</title>
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br>  
        <div class="form">
        <h2>Processes Table</h2>
        <p>
            <form method="post" action="search_processes.htm">
                <input type="text" name="search" placeholder="name">
                <button>Search</button>
            </form>
        </p>
        <table class="table">
            <tr class="row header">
                <th class="cell">ID</th>
                <th class="cell">Name</th>
                <th class="cell">Delete</th>
            </tr>
            <c:forEach items="${processes}" var="process">
                <tr class="row"><td>${process.getId()}</td>
                    <td class="cell">${process.getName()}</td>
                    <td class="cell"><a href="delete_process.htm?id=${process.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="new_process.htm">Add new process</a>
    </div>
    </body>
</html>

