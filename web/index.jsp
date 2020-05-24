<%--
  Created by IntelliJ IDEA.
  User: leo50
  Date: 2020-05-19
  Time: 오후 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>WEBSERVICE</title>
    <link rel="stylesheet" href="public/build/tailwind.css">
    <link rel="stylesheet" href="public/build/custom.css">
    <script src="Loginpopup.js" type="text/javascript"></script>
</head>
<body>
<!--title -->
<section class="m-2 flex">
    <nav class="w-11/12">
        <div class="text-4xl font-bold text-center text-blue-500">WEB SERVICE</div>
    </nav>
    <!--login button -->
    <nav class="w-1/12">
        <button class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded"
                id="login">
            <p>LOGIN</p>
        </button>
    </nav>
</section>
<!--print, input area-->
<section class="flex">
    <nav class=" p-1 w-3/5 h-map">
        <jsp:include page="Apidata/Map.jsp" flush="false"/>
    </nav>

    <!--Input-->
    <nav class="flex bg-teal-200">
        <div>
            <jsp:include page="public/Main.jsp" flush="false"/>
        </div>
        <div>
            <div>User information</div>
            <br>
            <div>
                기준 년 코드: <%=request.getAttribute("year")%><br>
                번지 = <%=request.getAttribute("bungi")%><br>
                상권 분류 코드 = <%=request.getAttribute("trdarcode")%><br>
                상권 이름 = <%=request.getAttribute("gil")%><br>
                상권 코드 = <%=request.getAttribute("code")%>
            </div>
        </div>
    </nav>
</section>
</body>
</html>
