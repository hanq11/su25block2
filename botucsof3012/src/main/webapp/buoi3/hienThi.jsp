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
    Them thong tin:
    <form action="/buoi3/them" method="post">
        Ten phong: <input type="text" name="tenPhong"> <br>
        Gia: <input type="text" name="gia"> <br>
        Trang thai: Trong <input type="radio" name="conTrong" value="true">
            Khong trong <input type="radio" name="conTrong" value="false">
        <br>
        Khach san:
            <select name="khachSan">
                <c:forEach items="${listKhachSan}" var="khachSan">
                    <option value="${khachSan.id}" label="${khachSan.tenKhachSan}"></option>
                </c:forEach>
            </select>
        <button>Submit</button>
    </form>
    <br>
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
                    <td>
                        <a href="/buoi3/view-update?id=${phong.id}">View update</a>
                        <a href="/buoi3/xoa?id=${phong.id}">Xoa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
