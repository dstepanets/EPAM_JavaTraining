<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 04.02.2020
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
${pageContext.setAttribute("title", "Register - GoUniver")}
${pageContext.setAttribute("registerButtonActive", "active")}
<%@ include file="includes/header.jsp" %>

<main class="page registration-page">
    <section class="clean-block clean-form dark" style="height: 700px;">
        <div class="container">
            <div class="block-heading" style="padding: 20px;height: 40px;">
                <h2 class="text-info"><fmt:message key="nav.register"/></h2>
            </div>
            <form action="${root}/register" method="post">
                <div class="form-group">
                    <label for="email"><fmt:message key="user.email"/></label><input class="form-control item" type="email" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="firstName"><fmt:message key="user.firstName"/></label><input class="form-control item" type="text" id="firstName" name="firstName">
                    <label for="lastName"><fmt:message key="user.lastName"/></label><input class="form-control item" type="text" id="lastName" name="lastName">
                </div>
                <div class="form-group">
                    <label for="password1"><fmt:message key="user.password"/></label><input class="form-control item" type="password" id="password1" name="password1">
                    <label for="password2"><fmt:message key="nav.register.repeatPass"/></label><input class="form-control item" type="password" id="password2" name="password2">
                </div>
                <button class="btn btn-primary btn-block" type="submit"><fmt:message key="nav.register"/></button>
            </form>
            <div>
                <c:if test="${registerError == true}">
                    <p align="center" style="color:darkred"><fmt:message key="nav.register.err"/></p>
                    <p align="center" style="color:darkred">${exception}</p>
                </c:if>
            </div>
        </div>
    </section>
</main>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>
