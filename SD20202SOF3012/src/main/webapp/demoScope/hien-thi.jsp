<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 7/30/2025
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("message", "page scope");
    String message = (String) pageContext.getAttribute("message");
%>
<body>
    Request scope: ${name} <br>
    Session scope: ${sessionScope.truong} <br>
    Application scope: ${applicationScope.diaChi} <br>
    Page scope: ${message}
</body>
</html>
