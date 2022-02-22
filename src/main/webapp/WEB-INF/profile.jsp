<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <form action="/updateUser" method="get">
            <button id="id" value="${user.id}">Edit Profile</button>
        </form>
        <form action="/password" method="get">
            <button id="password" value="${user.id}" >Change Password</button>
        </form>
    </div>

    <div>
    <c:forEach var="ad" items="${userAds}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <li><a href="/ad?id=${ad.id}">More Info...</a></li>
        </div>
    </c:forEach>
    </div>

</body>
</html>
