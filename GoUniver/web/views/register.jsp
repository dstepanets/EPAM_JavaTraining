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
                <h2 class="text-info">Registration</h2>
            </div>
            <form>
                <div class="form-group"><label for="email">Email</label><input class="form-control item" type="email" id="email"></div>
                <div class="form-group"><label for="name">First Name</label><input class="form-control item" type="text" id="name"><label for="name">Last Name</label><input class="form-control item" type="text" id="name"></div>
                <div class="form-group"><label for="password">Password</label><input class="form-control item" type="password" id="password"><label for="password">Confirm Password</label><input class="form-control item" type="password" id="password"></div><button class="btn btn-primary btn-block"
                                                                                                                                                                                                                                                                        type="submit">Sign Up</button></form>
        </div>
    </section>
</main>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>
