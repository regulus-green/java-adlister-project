// updatedAd.jsp

<%--
  Created by IntelliJ IDEA.
  User: alfonsocarrillo
  Date: 2/15/22
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Updating Ad" />
    </jsp:include>
    <title>Update Ad</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Ad</h1>
    <div>
        <h1>${id}</h1>
        <h1>${updatedAd.title}</h1>
        <h2>${updatedAd.description}</h2>
        <form action="/updateAd" method="post">
            <label for="title">Title</label>
            <input id="title" type="text" name="title" value="${updatedAd.title}">
            <br>
            <label for="description">Description</label>
            <input id="description" type="text" name="description" value="${updatedAd.description}">
            <br>
            <div>
                <input id="update" type="hidden" name="id" value="${id}">
                <button>Submit</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
