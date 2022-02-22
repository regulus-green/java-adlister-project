<%--
  Created by IntelliJ IDEA.
  User: alfonsocarrillo
  Date: 2/17/22
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User </title>
</head>
<body>
    <dvi class="container">
        <h1>Update User Information</h1>
    </dvi>
    <div class="container">
        <h2>Username: ${user.username}</h2>
        <h3>Email: ${user.email}</h3>
        <h4>User Id#: ${sessionScope.user.id}</h4>
    </div>
    <div class="container">
        <form action="/updateUser" method="post">
            <label for="username">UserName</label>
            <input id="username" type="text" name="username" value="${user.username}">
            <br>
            <label for="email">Email</label>
            <input id="email" type="text" name="email" value="${user.email}">
            <br>
            <label for="password">Password</label>
            <input id="password" type="text" name="password" value="password">
            <br>
            <input id="update" type="hidden" name="id" value="${sessionScope.user.id}">
            <button>Submit</button>

        </form>
    </div>

</body>
</html>
