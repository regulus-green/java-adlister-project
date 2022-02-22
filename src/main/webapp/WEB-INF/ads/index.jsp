<%--Reza--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">

    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>

    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div style="margin: 5px">
            <div style="border: black 3px solid" class="col-md-6">
                <h2><c:out value="${ad.title}" /></h2>
                <p><c:out value="${ad.description}" /></p>
                <c:forEach var="cat" items="${cats}">
                    <c:if test="${ad.id==cat.ad_id}">
                        <p>${cat.category}</p>
                    </c:if>
                </c:forEach>
                <form action="/ads" method="post">
                    <button type="submit" name="viewad" value="${ad.id}">View Ad</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>