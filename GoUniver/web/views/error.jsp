<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 11.02.2020
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
${pageContext.setAttribute("title", "Error - GoUniver")}
<%@ include file="includes/header.jsp" %>

<body>
<%--<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="${root}home"><strong>GoUniver</strong></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="${root}home"><fmt:message key="nav.home"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${root}login"><fmt:message key="nav.log_in"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${root}register"><fmt:message key="nav.register"/></a></li>
            </ul>
            <a href="?locale=ua" style="font-size: 14px;">UA</a>
            <span class="navbar-text">&nbsp;/&nbsp;</span>
            <a href="?locale=en" style="font-size: 14px;">EN</a>
        </div>
    </div>
</nav>--%>

<main class="text-body">
    <section class="clean-block clean-form dark" style="height: 700px;">
        <div class="text">
            <p> Request from ${pageContext.errorData.requestURI} is failed </p>
            <p>Servlet name: ${pageContext.errorData.servletName}</p>
            <p> Status code: ${pageContext.errorData.statusCode}</p>
            <p>Exception: ${pageContext.exception}</p>
            <p> Message from exception: ${pageContext.exception.message}</p>
        </div>
    </section>
</main>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>
