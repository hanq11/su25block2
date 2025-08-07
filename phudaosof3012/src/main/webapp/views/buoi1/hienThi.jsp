<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 8/7/2025
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Id san pham</th>
                <th>Ma san pham</th>
                <th>Ten san pham</th>
                <th>Mo ta</th>
                <th>Ma loai san pham</th>
                <th>Ten loai san pham</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSanPham}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.moTa}</td>
                    <td>${sp.loaiSanPham.ma}</td>
                    <td>${sp.loaiSanPham.ten}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
