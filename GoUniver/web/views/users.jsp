<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 03.02.2020
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages"/>

<html lang=${sessionScope.locale}>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Users List - GoUniver</title>
    <meta name="description" content="University admission platform">
    <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="../assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="../assets/css/smoothproducts.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="home.jsp"><strong>GoUniver</strong></a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="home.jsp"><fmt:message
                        key="nav.home"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="login.jsp"><fmt:message
                        key="nav.log_in"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="registration.jsp"><fmt:message
                        key="nav.register"/></a></li>
            </ul>
            <a href="?locale=ua" style="font-size: 14px;">UA</a>
            <span class="navbar-text">&nbsp;/&nbsp;</span>
            <a href="?locale=en" style="font-size: 14px;">EN</a>
        </div>
    </div>
</nav>
<main class="page catalog-page" style="height: 800px;">
    <section class="clean-block clean-catalog dark" style="height: 601px;">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Users List</h2>
            </div>
            <div class="content">
                <div class="table-responsive" style="font-size: 14px;">
                    <table class="table">
                        <thead>
                        <tr>
                            <th style="width: 73px;height: 30px;">ID</th>
                            <th style="width: 180px;height: 30px;">Email</th>
                            <th style="width: 180px;height: 30px;">First Name</th>
                            <th style="width: 180px;height: 30px;">Last Name</th>
                            <th style="width: 150px;height: 30px;">Role</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td style="width: 30px;">Cell 1</td>
                            <td style="height: 30px;">Cell 2</td>
                            <td style="height: 30px;">Cell 2</td>
                            <td style="height: 30px;">Cell 2</td>
                            <td style="height: 30px;">Cell 2</td>
                        </tr>
                        <tr></tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</main>

<footer class="page-footer dark" style="padding: 0;height: 51px;">
    <div class="footer-copyright" style="padding: 0;margin: 0;">
        <p>© 2020 All is borrowed, not stolen!</p>
    </div>
</footer>
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="../assets/js/smoothproducts.min.js"></script>
<script src="../assets/js/theme.js"></script>
</body>

</html>
