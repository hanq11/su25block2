<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 24-Jul-25
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  Sua san pham:
  <form action="/san-pham/update" method="post">
    Id: <input type="text" name="id" value="${sanPham.id}"> <br>
    Ten san pham: <input type="text" name="tenSanPham" value="${sanPham.tenSanPham}"> <br>
    Nha san xuat: <input type="text" name="nhaSanXuat" value="${sanPham.nhaSanXuat}"> <br>
    Gia: <input type="text" name="gia" value="${sanPham.gia}"> <br>
    So luong: <input type="text" name="soLuong" value="${sanPham.soLuong}"> <br>
    Con hang:
    Con hang <input type="radio" name="conHang" value="true" ${sanPham.conHang == "true" ? "checked" : ""}>
    Het hang: <input type="radio" name="conHang" value="false" ${sanPham.conHang == "false" ? "checked" : ""}>
    <br>
    <button>Save</button>
  </form>
</body>
</html>
