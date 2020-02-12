<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 04.02.2020
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>

${pageContext.setAttribute("title", "Home - GoUniver")}
<%@ include file="includes/header.jsp" %>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="${root}home"><strong>GoUniver</strong></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link active" href="${root}home"><fmt:message key="nav.home"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${root}login"><fmt:message key="nav.log_in"/></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${root}register"><fmt:message key="nav.register"/></a></li>
            </ul>
            <a href="?locale=ua" style="font-size: 14px;">UA</a>
            <span class="navbar-text">&nbsp;/&nbsp;</span>
            <a href="?locale=en" style="font-size: 14px;">EN</a>
        </div>
    </div>
</nav>

<main class="page landing-page">
    <section class="clean-block clean-hero" style="background-image: url(&quot;assets/img/tech/image4.jpg&quot;);color: rgba(9, 162, 255, 0.85);">
        <div class="text">
            <h2>Go study, you lazy little prick!</h2>
            <p>Seriously, choose your proffession and take exams. It's easy, and mom will be proud of you. If you pass.</p>
            <p>Web Application Context Path = ${pageContext.request.contextPath}</p>
            <p>Real Path = ${pageContext.request.getRealPath("")}</p>
            <p>Path Info = ${pageContext.request.pathInfo}</p>
        </div>
    </section>
</main>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>