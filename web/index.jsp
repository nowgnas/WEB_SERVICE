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
<section class="grid grid-rows-4 grid-flow-col gap-2">
    <nav class="row-span-3 col-span-3">
        <jsp:include page="Apidata/Map.jsp" flush="false"/>
    </nav>

    <!--Input-->
    <nav class="row-span-2 col-span-2 bg-teal-200">
        <jsp:include page="public/Main.jsp" flush="false"/>
    </nav>
</section>
<section>
    <!--print-->
    <nav class="row-span-3 col-span-2">
        <div>User information</div>
        <br>
        <div>
            도로명 주소: <%=request.getParameter("gil")%>
            코드: <%= request.getParameter("code")%>
        </div>
    </nav>
</section>


</body>
</html>
