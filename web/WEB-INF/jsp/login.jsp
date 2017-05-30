<%-- 
    Document   : login
    Created on : Apr 26, 2017, 9:47:45 AM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Flow ERP</title>
        <link rel="stylesheet" href="css/login.css">
        <link rel="shortcut icon" href="css/img/flowerp-icon.png" />
        <!--<link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <link rel="stylesheet" href="css/form-elements.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.css">-->
    </head>
    <body>
         <!-- <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Bootstrap</strong> Login Form</h1>
                            
                            </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Login to our site</h3>
                                                
                            		<p>Enter your username and password to log on:</p>
                                        
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="login.htm" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="username" placeholder="Username..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
			                        </div>
			                        <button type="submit" class="btn">Sign in!</button>
                                                <div class="form-group has-error">
            <label class="control-label" for="inputError1">${message}</label></div>
			                    </form>
		                    </div>
                        </div>
                    </div> -->
         <div class="login-page">
		    <br>
	<div class="form">
            <img src="img/flowerp.png" height="100"><br>
            <div class="has-error"><p>${message}</p></div>
         <form class="loginForm" method="post" action="login.htm">
	      <input type="text" name="username" placeholder="username"/>
	      <input type="password" name="password" placeholder="password"/>
	      <button>login</button>
	      <p></p>
	    </form>
	  </div>
	
	
        <!--<form method="post" action="login.htm"> 
            <table>
                <tr><td>Username:</td><td><input type="text" name="username"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password"></td></tr>
                <tr><td><input type="submit" value="Login"></td><td></td></tr>
            </table>-->
            <!--<a href="manage_users.htm">Manage Users</a><br>
            <a href="factory_status.htm">Factory Status</a><br>
            <a href="manage_stocks.htm">Manage Stocks</a><br>
            <a href="manage_orders.htm">Manage Orders</a><br>
            <a href="processing_schedule.htm">Processing Schedule</a><br>
            <a href="manage_processes.htm">Manage Processes</a><br>
            <a href="read_logs.htm">See all logs</a><br>
       -->
               
            
        </div>
                            
        <!--<script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.backstretch.min.js"></script>
        <script src="js/scripts.js"></script>-->

    </body>
</html>
