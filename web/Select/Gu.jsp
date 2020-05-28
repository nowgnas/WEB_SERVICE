<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.reflect.Array" %>
<%--
  Created by IntelliJ IDEA.
  User: leo50
  Date: 2020-05-27
  Time: 오후 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
    String name = (String) request.getAttribute("cdname");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="public/build/tailwind.css">
</head>
<body>
<%--지도 --%>
<%--구 도로명 선택 --%>

<form class="flex bg-purple-100 w-3/5" action="RQ" method="post" name="Guselect">
    <div class="flex-1  w-1/5">
        <select name="Guselect" onchange="this.form.submit()">
            <option>구 선택</option>
            <option value="11110">종로구</option>
            <option value="11500">강서구</option>
        </select>
    </div>
    <div class="flex-1 w-1/5">
        <p>도로명 선택</p>
        <input class="rounded border-solid border-2 w-full" list="gil" name="gil">
        <datalist id="gil">
            <option value="창신길"/>
            <option value="창신2길"/>
            <%--name11값 1개 가져올수 있음--%>
            <option><%=name%>
            </option>
        </datalist>
    </div>
    <input type="submit" value="전송" name="submitbtn">
</form>
</body>
</html>