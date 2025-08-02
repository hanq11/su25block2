<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 02-Aug-25
  Time: 2:14 PM
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
        url: "/api/ajax/demo",
        type: "get",
        dataType: "json",
        success: function(response) {
          console.log(response)
          document.getElementById("data").innerHTML = "MSV: " + response.maSinhVien + " Ten: " + response.ten
        },
        error: function() {
          console.log("loi")
          document.getElementById("data").innerHTML = "Loi"
        }
      })
    }
  </script>
</head>
<body>
  <h1>Demo ajax</h1>
  <button onclick="getData()">Get data</button>
  <div id="data"></div>
</body>
</html>
