<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 7/26/2025
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button><a href="/nhan-vien/sortLuong">Sort luong</a></button>
    <br>
    Tim kiem theo ten:
    <form action="/nhan-vien/search">
        Ten nhan vien: <input type="text" name="ten">
        <button>Search</button>
    </form>
    <br>
    Them thong tin:
    <form action="/nhan-vien/add" method="post">
        Ho ten: <input type="text" name="hoTen"> <br>
        Chuc vu: <input type="text" name="chucVu"> <br>
        Luong: <input type="text" name="luong"> <br>
        Dang lam viec:
            Dang lam viec <input type="radio" name="dangLamViec" value="true">
            Nghi viec <input type="radio" name="dangLamViec" value="false">
        <br>
        Phong ban: <select name="phongBan">
            <c:forEach items="${listPhongBan}" var="pb">
                <option value="${pb.id}" label="${pb.ten}"></option>
            </c:forEach>
        </select>
        <br>
        <button>Save</button>
    </form>
    <br>
    Bang thong tin nhan vien:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ho ten</th>
                <th>Chuc vu</th>
                <th>Luong</th>
                <th>Dang lam viec</th>
                <th>Phong ban</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="nv">
                <tr>
                    <td>${nv.id}</td>
                    <td>${nv.hoTen}</td>
                    <td>${nv.chucVu}</td>
                    <td>${nv.luong}</td>
                    <td>${nv.dangLamViec == "true" ? "Dang lam viec" : "Nghi viec"}</td>
                    <td>${nv.phongBan.ten}</td>
                    <td>
                        <a href="/nhan-vien/view-update?id=${nv.id}">View update</a>
                        <a href="/nhan-vien/delete?id=${nv.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/nhan-vien/phan-trang?page=${page-1}">Prev</a>
    <a href="/nhan-vien/phan-trang?page=${page+1}">Next</a>
</body>
</html>
