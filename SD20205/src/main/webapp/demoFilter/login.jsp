<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 8/1/2025
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${message} <br>
    Dang nhap:
    <form action="/demo-filter/login" method="post">
        username: <input type="text" name="username"> <br>
        password: <input type="text" name="password"> <br>
        <button>Login</button>
    </form>
</body>
</html>
