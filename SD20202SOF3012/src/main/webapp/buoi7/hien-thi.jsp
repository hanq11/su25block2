<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 21-Jul-25
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them sach:
    <form action="/buoi7/add" method="post">
        Ten sach: <input type="text" name="tenSach"> <br>
        Tac gia: <input type="text" name="tacGia"> <br>
        Gia: <input type="text" name="gia"> <br>
        So luong: <input type="text" name="soLuong"> <br>
        Con hang: Con hang <input type="radio" name="conHang" value="true">
        Het hang <input type="radio" name="conHang" value="false"> <br>
        The loai:
        <select name="theLoai">
            <c:forEach items="${listTheLoai}" var="theLoai">
                <option value="${theLoai.id}" label="${theLoai.tenTheLoai}"></option>
            </c:forEach>
        </select>
        <br>
        <button>Save</button>
    </form>
    <br>
    Thong tin sach:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten sach</th>
                <th>Tac gia</th>
                <th>Gia</th>
                <th>So luong</th>
                <th>Con hang</th>
                <th>The loai</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSach}" var="sach">
                <tr>
                    <td>${sach.id}</td>
                    <td>${sach.tenSach}</td>
                    <td>${sach.tacGia}</td>
                    <td>${sach.gia}</td>
                    <td>${sach.soLuong}</td>
                    <td>${sach.conHang == "true" ? "Con hang" : "Het hang"}</td>
                    <td>${sach.theLoai.tenTheLoai}</td>
                    <td>
                        <a href="/buoi7/view-update?id=${sach.id}">View update</a>
                        <a href="/buoi7/delete?id=${sach.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
