<%-- 
    Document   : search 
    Created on : May 17, 2017, 9:07:57 PM
    Author     : Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search - Flow ERP</title>
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <h2>Search</h2>
        <p>${message}</p>
        <p>
            <form method="post" action="search.htm">
                <input type="text" name="search">
                <input type="submit" value="Search">
            </form>
        </p>
        
        <table border="1">
            <tr><th>ID</th><th>Name</th><th>Username</th><th>Password</th><th>Type</th></tr>
            <c:forEach items="${accounts}" var="account">
                <tr><td>${account.getId()}</td>
                    <td>${account.getName()}</td>
                    <td>${account.getUsername()}</td>
                    <td>${account.getPassword()}</td>
                    <td>${account.getType()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
