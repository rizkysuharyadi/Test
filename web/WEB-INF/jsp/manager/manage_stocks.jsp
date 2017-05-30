<%-- 
    Document   : manage_stocks
    Created on : Apr 30, 2017, 12:21:47 PM
    Author     : Adam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Stocks - Flow ERP</title>
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <jsp:include page="navbarmanager.html" /><br> 
        <div class="form">
        <h2>Manage Stocks</h2>
        <p>${message}</p>
        <p>
            <form method="post" action="search_stocks.htm">
                <input type="text" name="search" placeholder="name">
                <button>Search</button>
            </form>
        </p>
        <p>(Click the table header to sort.)</p>
        <table class="table" id="myTable">
            <tr class="row header"><th onclick="sortTable(0)" class="cell">ID</th><th onclick="sortTable(1)" class="cell">Name</th><th onclick="sortTable(2)" class="cell">Type</th><th onclick="sortTable(3)" class="cell">Amount</th><th class="cell">Modify</th><th class="cell">Delete</th></tr>
<%--            <c:forEach items="${materials}" var="material">
                <tr class="row"><td class="cell">${material.getId()}</td>
                    <td class="cell">${material.getName()}</td>
                    <td class="cell">${material.getType()}</td>
                    <td class="cell">${material.getAmount()}</td>
                    <td class="cell"><a href="edit_stock.htm?id=${material.getId()}">Edit</a></td>
                    <td class="cell"><a href="delete_stock.htm?id=${material.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
                
            <c:forEach items="${results}" var="result">
                <tr class="row"><td class="cell">${result.getId()}</td>
                    <td class="cell">${result.getName()}</td>
                    <td class="cell">${result.getType()}</td>
                    <td class="cell">${result.getAmount()}</td>
                    <td class="cell"><a href="edit_stock.htm?id=${result.getId()}">Edit</a></td>
                    <td class="cell"><a href="delete_stock.htm?id=${result.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
--%>
            
            <c:forEach items="${stocks}" var="stock">
                <tr class="row"><td>${stock.getId()}</td>
                    <td class="cell">${stock.getName()}</td>
                    <td class="cell">${stock.getType()}</td>
                    <td class="cell">${stock.getAmount()}</td>
                    <td class="cell"><a href="edit_stock.htm?id=${stock.getId()}">Edit</a></td>
                    <td class="cell"><a href="delete_stock.htm?id=${stock.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="new_stock.htm">Add new stock</a>
        
        <script>
            function sortTable(n) {
              var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
              table = document.getElementById("myTable");
              switching = true;
              //Set the sorting direction to ascending:
              dir = "asc";
              /*Make a loop that will continue until
              no switching has been done:*/
              while (switching) {
                //start by saying: no switching is done:
                switching = false;
                rows = table.getElementsByTagName("TR");
                /*Loop through all table rows (except the
                first, which contains table headers):*/
                for (i = 1; i < (rows.length - 1); i++) {
                  //start by saying there should be no switching:
                  shouldSwitch = false;
                  /*Get the two elements you want to compare,
                  one from current row and one from the next:*/
                  x = rows[i].getElementsByTagName("TD")[n];
                  y = rows[i + 1].getElementsByTagName("TD")[n];
                  /*check if the two rows should switch place,
                  based on the direction, asc or desc:*/
                  if (dir == "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                      //if so, mark as a switch and break the loop:
                      shouldSwitch= true;
                      break;
                    }
                  } else if (dir == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                      //if so, mark as a switch and break the loop:
                      shouldSwitch= true;
                      break;
                    }
                  }
                }
                if (shouldSwitch) {
                  /*If a switch has been marked, make the switch
                  and mark that a switch has been done:*/
                  rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                  switching = true;
                  //Each time a switch is done, increase this count by 1:
                  switchcount ++;
                } else {
                  /*If no switching has been done AND the direction is "asc",
                  set the direction to "desc" and run the while loop again.*/
                  if (switchcount == 0 && dir == "asc") {
                    dir = "desc";
                    switching = true;
                  }
                }
              }
            }
        </script>   
    </div>
    </body>
</html>
