<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 7/30/2025
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("message", "FROM JSP");
    String message = (String) pageContext.getAttribute("message");
%>
<body>
    Request scope: ${name} <br>
    Session scope: ${sessionScope.role} <br>
    Application scope: ${applicationScope.scope} <br>
    Page scope: ${message}
</body>
</html>
