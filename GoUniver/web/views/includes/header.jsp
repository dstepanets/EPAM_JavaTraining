<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 11.02.2020
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages"/>

${pageContext.setAttribute("root", pageContext.request.contextPath)}

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title> ${title} </title>
        <meta name="description" content="University Admission Platform">
        <link rel="stylesheet" type="text/css" href="${root}/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${root}/assets/fonts/simple-line-icons.min.css">
        <link rel="stylesheet" type="text/css" href="${root}/assets/css/smoothproducts.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
        <script src="${root}/assets/js/jquery.min.js"></script>
        <script src="${root}/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="${root}/assets/js/smoothproducts.min.js"></script>
        <script src="${root}/assets/js/theme.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    </head>

<body>

    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
        <div class="container"><a class="navbar-brand logo" href="${root}home"><strong>GoUniver</strong></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                    class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation"><a class="nav-link ${homeButtonActive}" href="${root}home"><fmt:message key="nav.home"/></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link ${loginButtonActive}" href="${root}login"><fmt:message key="nav.log_in"/></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link ${registerButtonActive}" href="${root}register"><fmt:message key="nav.register"/></a></li>
                </ul>
                <a href="?locale=ua" style="font-size: 14px;">UA</a>
                <span class="navbar-text">&nbsp;/&nbsp;</span>
                <a href="?locale=en" style="font-size: 14px;">EN</a>
            </div>
        </div>
    </nav>
