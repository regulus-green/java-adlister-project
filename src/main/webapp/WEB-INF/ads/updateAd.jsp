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

<h1>Ad</h1>
<div>
    <form action="/updateAd" method="post">
        <label for="title">Title</label>
        <input id="title" type="text" name="title">
        <br>
        <label for="description">Description</label>
        <input id="description" type="text" name="description">
        <br>
        <div>
            <button type="button">Submit</button>
        </div>
    </form>
</div>


</body>
</html>
