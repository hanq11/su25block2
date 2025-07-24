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
  Tim kiem thong tin:
  <form action="/san-pham/search">
    Ten san pham: <input type="text" name="tenSanPham"> <br>
    <button>Search</button>
  </form>
  <br>
  Them san pham:
  <form action="/san-pham/add" method="post">
    Ten san pham: <input type="text" name="tenSanPham"> <br>
    Nha san xuat: <input type="text" name="nhaSanXuat"> <br>
    Gia: <input type="text" name="gia"> <br>
    So luong: <input type="text" name="soLuong"> <br>
    Con hang:
      Con hang <input type="radio" name="conHang" value="true">
      Het hang: <input type="radio" name="conHang" value="false">
    <br>
    <button>Save</button>
  </form>
  <button><a href="/san-pham/sort">Sort by Nha San Xuat</a></button>
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
        <th>Hanh dong</th>
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
          <td>
            <a href="/san-pham/view-update?id=${sp.id}">View update</a>
            <a href="/san-pham/delete?id=${sp.id}">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
