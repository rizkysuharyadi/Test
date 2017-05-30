<%-- 
    Document   : factory_status
    Created on : Apr 30, 2017, 7:18:56 AM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="dbAccess" class="model.DatabaseAccess"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factory Status - Flow ERP</title>
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
        
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br> 
        <div class="form">
        <form method="post" action="factory_status.htm">
            Factory Time: <b>${factoryDatetime}</b><br><br>
            <input type="number" name="advanceTime">
            <button>Advance</button>
        </form>
        <h2>Processes</h2>
        <c:forEach items="${processes}" var="process" varStatus="counter">
            <!-- Text box color according to process status -->
            <c:choose>
                <c:when test="${!dbAccess.isProcessUsed(process.getId())}">
                    <div style="background-color: lightgrey">
                </c:when>
                <c:when test="${!dbAccess.isProcessAble(process.getId())}">
                    <div style="background-color: lightcoral">
                </c:when>
                <c:otherwise>
                    <div>
                </c:otherwise>
            </c:choose>
                <p><a href="process_details.htm?id=${process.getId()}">${process.getName()}</a><br>
                ${processMaterials.get(counter.index)} --> ${processResults.get(counter.index)}<br>
                Error: ${process.getErrorChance()*100}%</p>
            </div>
        </c:forEach>
                    </div>
    </body>
</html>
