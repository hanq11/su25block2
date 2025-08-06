<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 8/6/2025
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        function getData() {
            $.ajax({
                url: "/api/ajax/hien-thi",
                type: "get",
                data: "json",
                success: function(response) {
                    console.log(response)
                    document.getElementById("data").innerText = response.ten + " " + response.monHoc;
                },
                error: function() {
                    console.log("Loi")
                }
            })
        }
    </script>
</head>
<body>
    <h2>Demo ajax</h2>
    <button onclick="getData()">Get data</button>
    <div id="data"></div>
</body>
</html>
