<%--
  Created by IntelliJ IDEA.
  User: alfonsocarrillo
  Date: 2/16/22
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>one</title>
</head>
<body>
<h1>Ad</h1>
<div class="container">
<%--  <h2>${searchId.id}</h2>--%>
    <h2>${searchId.title}</h2>
    <h2>${searchId.description}</h2>
</div>
<div class="container">
    <form action="/searchById" method="post">
        <label for="search">find by id</label>
        <input id="search" type="text" name="id" value="${searchId.id}">
        <button>search</button>
    </form>
</div>

</body>
</html>
