<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 09.02.2020
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages"/>

<html lang=${sessionScope.locale}>
<head>
    <title>GoUniver</title>
</head>
<body>
    <jsp:forward page="Home"/>
</body>
</html>
