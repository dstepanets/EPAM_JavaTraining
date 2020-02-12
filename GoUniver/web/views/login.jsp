<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 02.02.2020
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
${pageContext.setAttribute("title", "Log In - GoUniver")}
<%@ include file="includes/header.jsp" %>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="${root}home"><strong>GoUniver</strong></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="${root}home"><fmt:message key="nav.home"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link active" href="${root}login"><fmt:message key="nav.log_in"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${root}register"><fmt:message key="nav.register"/></a></li>
            </ul>
            <a href="?locale=ua" style="font-size: 14px;">UA</a>
            <span class="navbar-text">&nbsp;/&nbsp;</span>
            <a href="?locale=en" style="font-size: 14px;">EN</a>
        </div>
    </div>
</nav>

<main class="page login-page">
    <section class="clean-block clean-form dark" style="height: 700px;">
        <div class="container">
            <div class="block-heading" style="padding: 20px;height: 40px;">
                <h2 class="text-info">Log In</h2>
            </div>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input class="form-control item" type="email" name="email" id="email" required="required">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input class="form-control" type="password" name="password" id="password" required="required">
                </div>
                <button class="btn btn-primary btn-block" type="submit">Log In</button>
            </form>
        </div>
        <div>
            <p align="center" style="color:darkred"> ${loginError} </p>
        </div>
    </section>
</main>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>