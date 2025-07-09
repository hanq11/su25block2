<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 09-Jul-25
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Thong tin nuoc hoa:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>So luong</th>
                <th>Gia</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="nh">
                <tr>
                    <td>${nh.id}</td>
                    <td>${nh.ten}</td>
                    <td>${nh.soLuong}</td>
                    <td>${nh.gia}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
