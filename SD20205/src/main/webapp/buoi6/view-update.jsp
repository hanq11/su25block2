<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 7/18/2025
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua thong tin:
    <form action="/chuot-gaming/update" method="post">
        Id: <input type="text" name="id" value="${chuot.id}"> <br>
        Ten: <input type="text" name="ten" value="${chuot.ten}"> <br>
        Mat doc: <input type="text" name="matDoc" value="${chuot.matDoc}"> <br>
        Gia: <input type="text" name="gia" value="${chuot.gia}">
        <br><button>Submit</button>
    </form>
</body>
</html>
