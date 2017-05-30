<%-- 
    Document   : see_logs
    Created on : May 25, 2017, 11:49:44 AM
    Author     : Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Logs - Flow ERP</title>
        <link rel="stylesheet" href="css/manageuser.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
    </head>
    <body>
        <div class="form">
        <h2>Logs Table</h2>
<!--        <p>
            <form method="post" action="search_logs.htm">
                <input type="text" name="search">
                <input type="submit" value="Search">
            </form>
        </p>-->
        <p>(Click the table header to sort.)</p>
        <table class="table" id="myTable">
            <tr class="row header">
                <th onclick="sortTable(0)" class="cell">Log ID</th>
                <th class="cell">Name</th>
                <th onclick ="sortTable(2)" class="cell">Action</th>
                <th class="cell">Date and Time</th>
            </tr>
            <c:forEach items="${logs}" var="log">
                <tr class="row"><td>${log.getId()}</td>
                    <td class="cell">${log.getAccounts().getName()} (${log.getAccounts().getUsername()})</td>
                    <td class="cell">${log.getAction()}</td>
                    <td class="cell">${log.getTime()}</td>
                </tr>
            </c:forEach>
        </table>
        
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
