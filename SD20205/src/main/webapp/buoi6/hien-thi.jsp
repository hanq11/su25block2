<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 7/18/2025
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them thong tin:
    <form action="/chuot-gaming/add" method="post">
        Ten: <input type="text" name="ten"> <br>
        Mat doc: <input type="text" name="matDoc"> <br>
        Gia: <input type="text" name="gia">
        <br><button>Submit</button>
    </form>

    <br>
    Tim kiem thong tin:
    <form action="/chuot-gaming/search">
        Ten: <input type="text" name="ten"> <br>
        <button>Submit</button>
    </form>
    <br>
    Bang thong tin:
    <table>
        <thead>
            <tr>
                <td>Id</td>
                <td>Ten</td>
                <td>Mat doc</td>
                <td>Gia</td>
                <td>Hanh dong</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="chuot">
                <tr>
                    <td>${chuot.id}</td>
                    <td>${chuot.ten}</td>
                    <td>${chuot.matDoc}</td>
                    <td>${chuot.gia}</td>
                    <td>
                        <a href="/chuot-gaming/view-update?id=${chuot.id}">View update</a>
                        <a href="/chuot-gaming/delete?id=${chuot.id}">Xoa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/chuot-gaming/phan-trang?page=${page - 1}">Prev</a>
    <a href="/chuot-gaming/phan-trang?page=${page + 1}">Next</a>
</body>
</html>
