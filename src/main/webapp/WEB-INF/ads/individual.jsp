<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2/14/22
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Individual Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>More Ad Info...</h1>

<%--    <c:forEach var="ad" items="${ads}">--%>
<%--        <div class="individual-ad">--%>
            <h2>${adInfo.title}</h2>
            <p>${adInfo.description}</p>
<%--            <p>${adInfo.user_id}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
</div>

</body>
</html>
