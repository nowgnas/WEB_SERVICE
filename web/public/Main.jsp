<%--
  Created by IntelliJ IDEA.
  User: leo50
  Date: 2020-05-19
  Time: 오후 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<nav>
    <div class="justify-center m-2">
        <p class="text-xl">위치를 입력하세요.</p>
    </div>
    <div class="m-2">
        <form action="RQ" method="post">
            <p>도로명 주소 선택</p>
            <select name="gil">
                <option>창신2길</option>
                <option>창신길</option>
                <option>창경궁로35길</option>
            </select><br>
            <input type="submit" value="전송" name="submitbtn">
        </form>
    </div>
</nav>
</body>
</html>