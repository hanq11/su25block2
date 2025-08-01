<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 8/1/2025
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>${message}</p>
    <p>Nhap thong tin</p>
    <form action="/demo-filter/login" method="post">
        Username: <input type="text" name="username"> <br>
        Password: <input type="text" name="password"> <br>
        <button>Dang nhap</button>
    </form>
</body>
</html>
