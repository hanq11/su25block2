<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 7/12/2025
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid;
        }
    </style>
</head>
<body>
    Thong tin phong:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten phong</th>
                <th>Gia</th>
                <th>Con trong</th>
                <th>Ten khach san</th>
                <th>Dia chi</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listPhong}" var="phong">
                <tr>
                    <td>${phong.id}</td>
                    <td>${phong.tenPhong}</td>
                    <td>${phong.gia}</td>
                    <td>${phong.conTrong == "true" ? "Trong" : "Khong trong"}</td>
                    <td>${phong.khachSan.tenKhachSan}</td>
                    <td>${phong.khachSan.diaChi}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
