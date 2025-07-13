<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 7/13/2025
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua thong tin:
    <form action="/buoi3/update" method="post">
        Id: <input type="text" name="id" value="${phong.id}"> <br>
        Ten phong: <input type="text" name="tenPhong" value="${phong.tenPhong}"> <br>
        Gia: <input type="text" name="gia" value="${phong.gia}"> <br>
        Trang thai: Trong <input type="radio" name="conTrong" value="true" ${phong.conTrong == "true" ? "checked" : ""}>
        Khong trong <input type="radio" name="conTrong" value="false" ${phong.conTrong == "false" ? "checked" : ""}>
        <br>
        Khach san:
        <select name="khachSan">
            <c:forEach items="${listKhachSan}" var="khachSan">
                <option value="${khachSan.id}" label="${khachSan.tenKhachSan}" ${phong.khachSan.id == khachSan.id ? "selected" : ""}></option>
            </c:forEach>
        </select>
        <button>Submit</button>
    </form>
</body>
</html>
