<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 02.02.2020
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>GoUniver</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;
            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {
                font-size: 15px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="login-form">
            <form action="login" method="post">
                <h2 class="text-center">GoUniver</h2>
                <div class="form-group">
                    <input name="email" type="text" class="form-control" placeholder="email" required="required">
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" placeholder="password" required="required">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block" value="login">Log in</button>
                </div>
                <div class="clearfix">
<%--                    <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>--%>
<%--                    <a href="#" class="pull-right">Forgot Password?</a>--%>
                     <p class="text-center"><a href="#">REGISTER</a></p>
                </div>
            </form>

        </div>
    </body>
</html>
