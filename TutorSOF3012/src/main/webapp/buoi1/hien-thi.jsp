<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 22-Jul-25
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  Thong tin san pham:
  <table>
    <thead>
      <tr>
        <th>Id</th>
        <th>Ten san pham</th>
        <th>Nha san xuat</th>
        <th>Gia</th>
        <th>So luong</th>
        <th>Con hang</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${danhSach}" var="sp">
        <tr>
          <td>${sp.id}</td>
          <td>${sp.tenSanPham}</td>
          <td>${sp.nhaSanXuat}</td>
          <td>${sp.gia}</td>
          <td>${sp.soLuong}</td>
          <td>${sp.conHang == "true" ? "Con hang" : "Het hang"}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
