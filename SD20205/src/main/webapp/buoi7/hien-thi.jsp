<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 21-Jul-25
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  Thong tin sach: <br>
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
        <td>Hanh dong</td>
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
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
