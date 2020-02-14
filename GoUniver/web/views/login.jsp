<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 02.02.2020
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
${pageContext.setAttribute("title", "Log In - GoUniver")}
${pageContext.setAttribute("loginButtonActive", "active")}
<%@ include file="includes/header.jsp" %>

<main class="page login-page">
    <section class="clean-block clean-form dark" style="height: 700px;">
        <div class="container">
            <div class="block-heading" style="padding: 20px;height: 40px;">
                <h2 class="text-info"><fmt:message key="nav.log_in"/></h2>
            </div>
            <form action="${root}/login" method="post">
                <div class="form-group">
                    <label for="email"><fmt:message key="user.email"/></label>
                    <input class="form-control item" type="email" name="email" id="email" required="required">
                </div>
                <div class="form-group">
                    <label for="password"><fmt:message key="user.password"/></label>
                    <input class="form-control" type="password" name="password" id="password" required="required">
                </div>
                <button class="btn btn-primary btn-block" type="submit"><fmt:message key="nav.log_in"/></button>
            </form>
        </div>
        <div>
            <c:if test="${loginError == true}">
                <p align="center" style="color:darkred"><fmt:message key="nav.log_in.err"/></p>
            </c:if>
        </div>
    </section>
</main>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>