<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 11.02.2020
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
${pageContext.setAttribute("title", "Error - GoUniver")}
<%@ include file="includes/header.jsp" %>

<main class="page landing-page">
    <section class="clean-block clean-hero" style="background-image: url(&quot;assets/img/tech/broken-glass.jpg&quot;);color: rgba(0,51,127,0);">
        <div class="text-monospace text" style="height: 560px;background-color: rgba(58,117,196,0.38);">
            <h2 style="margin: 0;height: 38px;margin-bottom: 10px;"><strong>SOMETHING WRONG</strong></h2>
            <p class="text-center" style="height: 58px;"><em>And this is your fault! What have you done with my beautiful web application?!</em></p>
            <div class="text-left" style="height: 412px;margin: 10px;font-size: 12px;">
                <p>Request from ${pageContext.errorData.requestURI} is failed </p>
                <p>Servlet name: ${pageContext.errorData.servletName}</p>
                <p>Status code: ${pageContext.errorData.statusCode}</p>
                <p>Exception: ${pageContext.exception}</p>
                <p>Message from exception: ${pageContext.exception.message}</p>
            </div>
        </div>
    </section>
</main>

    <%@ include file="includes/footer.jsp" %>
</body>
</html>
