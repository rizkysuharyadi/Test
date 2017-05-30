<%-- 
    Document   : details_process
    Created on : May 8, 2017, 5:48:28 PM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Details - Flow ERP</title>
        <link rel="stylesheet" href="css/edit.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br> 
        <div class="form">
        <h2>Process Details</h2>
        Process Name: ${process.getName()}<br>
        <form method="post" class="registerForm" action="process_details.htm">
            <input type="hidden" name="id" value="${process.getId()}">
            <input type="text" name="rename" placeholder="name"><br>
            <button>Rename</button>
        </form>
        <br>
        
        <table class="table">
            <tr class="row header"><th class="cell">No</th><th class="cell">Procedure Name</th></tr>
            <c:forEach items="${processStages}" var="processStage">
                <tr><td>${processStage.getId().getStageIndex() + 1}</td><td>${processStage.getName()}</td></tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>
