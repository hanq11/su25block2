<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 8/1/2025
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Thong tin</p>
    <p>Xin chao: ${sessionScope.username}</p>
    <p>Ban dang dang nhap voi role la: ${sessionScope.role}</p>
    <button><a href="/demo-filter/logout">Dang xuat</a></button>
</body>
</html>
