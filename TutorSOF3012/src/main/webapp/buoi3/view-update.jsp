<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 7/31/2025
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua thong tin:
    <form action="/nhan-vien/update" method="post">
        Id: <input type="text" name="id" value="${nhanVien.id}"> <br>
        Ho ten: <input type="text" name="hoTen" value="${nhanVien.hoTen}"> <br>
        Chuc vu: <input type="text" name="chucVu" value="${nhanVien.chucVu}"> <br>
        Luong: <input type="text" name="luong" value="${nhanVien.luong}"> <br>
        Dang lam viec:
        Dang lam viec <input type="radio" name="dangLamViec" value="true" ${nhanVien.dangLamViec == "true" ? "checked" : ""}>
        Nghi viec <input type="radio" name="dangLamViec" value="false" ${!nhanVien.dangLamViec == "true" ? "checked" : ""}>
        <br>
        Phong ban: <select name="phongBan">
        <c:forEach items="${listPhongBan}" var="pb">
            <option value="${pb.id}" label="${pb.ten}" ${pb.id == nhanVien.phongBan.id ? "selected" : ""}></option>
        </c:forEach>
    </select>
        <br>
        <button>Save</button>
    </form>
</body>
</html>
