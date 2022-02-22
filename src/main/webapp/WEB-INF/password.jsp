<%--
  Created by IntelliJ IDEA.
  User: alfonsocarrillo
  Date: 2/21/22
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password Change</title>
    <div class="containter">
        <form action="/password" method="post">
            <label for="password">Password</label>
            <input id="password" type="password" name="password">
            <br>
            <input id="update" type="hidden" name="id" value="${sessionScope.user.id}">
            <button>Submit</button>
        </form>
    </div>
</head>
<body>

</body>
</html>
