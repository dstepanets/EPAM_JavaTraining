<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 04.02.2020
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>

${pageContext.setAttribute("title", "Home - GoUniver")}
${pageContext.setAttribute("homeButtonActive", "active")}

<%@ include file="includes/header.jsp" %>

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