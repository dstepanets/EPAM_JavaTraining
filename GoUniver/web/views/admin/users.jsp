<%--
  Created by IntelliJ IDEA.
  User: Litavets
  Date: 03.02.2020
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
${pageContext.setAttribute("title", "Register - GoUniver")}
<%@ include file="../includes/header.jsp" %>

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
                            <c:forEach items="${usersList}" var = "u">
                            <tr>
                                <td style="width: 30px;">${u.id}</td>
                                <td style="height: 30px;">${u.email}</td>
                                <td style="height: 30px;">${u.firstName}</td>
                                <td style="height: 30px;">${u.lastName}</td>
                                <td style="height: 30px;">${u.role}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="text-body">
                <c:forEach var = "i" begin="1" end="${maxPage}">
                    <a href="?page=${i}">${i} </a>
                </c:forEach>
            </div>
        </div>

    </section>
</main>

    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
