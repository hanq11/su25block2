<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 7/23/2025
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua thong tin:
    <form action="/sach/update" method="post">
        Id: <input type="text" name="id" value="${sach.id}"> <br>
        Ten sach: <input type="text" name="tenSach" value="${sach.tenSach}"> <br>
        Tac gia: <input type="text" name="tacGia" value="${sach.tacGia}"> <br>
        Gia: <input type="text" name="gia" value="${sach.gia}"> <br>
        So luong: <input type="text" name="soLuong" value="${sach.soLuong}"> <br>
        Con hang:
        Con hang <input type="radio" name="conHang" value="true" ${sach.conHang == "true" ? "checked": ""}>
        Het hang: <input type="radio" name="conHang" value="false" ${!sach.conHang == "true" ? "checked": ""}>
        <br>
        The loai:
        <select name="theLoai">
            <c:forEach items="${listTheLoai}" var="theLoai">
                <option value="${theLoai.id}" label="${theLoai.tenTheLoai}"
                    ${sach.theLoai.id == theLoai.id ? "selected" : ""}
                ></option>
            </c:forEach>
        </select> <br>
        <button>Save</button>
        <br>
    </form>
</body>
</html>
