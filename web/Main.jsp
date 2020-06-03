<%--
  Created by IntelliJ IDEA.
  User: leo50
  Date: 2020-06-03
  Time: 오후 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="public/build/tailwind.css">
    <title>Document</title>
    <script>
        function openCity(cityName) {
            var i;
            var x = document.getElementsByClassName("city");
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            document.getElementById(cityName).style.display = "block";
        }
    </script>
</head>
<body>
<section>
    <div class="w-full overflow-hidden  bg-purple-100">
        <button class="border-4 border-solid" onclick="openCity('London')">도로명으로 찾아보기</button>
        <button class="border-4 border-solid" onclick="openCity('Paris')">유동인구로 찾아보기</button>
    </div>

    <div id="London" class="city">
        <h2>London</h2>
        <p>도로명</p>
    </div>

    <div id="Paris" class="city" style="display:none">
        <h2>Paris</h2>
        <p>유동인구</p>
    </div>

</section>

</body>
</html>