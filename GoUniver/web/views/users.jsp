<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 03.02.2020
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
${pageContext.setAttribute("title", "Register - GoUniver")}
<%@ include file="includes/header.jsp" %>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
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

    <%@ include file="includes/footer.jsp" %>
</body>
</html>
