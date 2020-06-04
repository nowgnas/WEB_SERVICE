<%--main page--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>WEBSERVICE</title>
    <link rel="stylesheet" href="public/build/tailwind.css">
    <link rel="stylesheet" href="public/build/custom.css">
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
<!--title -->
<section class="m-2 flex">
    <nav class="w-11/12">
        <div class="text-4xl font-bold text-center text-blue-500">WEB SERVICE</div>
    </nav>
    <%--title--%>
    <!--login button -->
    <nav class="w-1/12">
        <form name="login" action="public/Login.jsp">
            <button class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">
                <p>LOGIN</p>
            </button>
        </form>
    </nav>
    <%--login--%>
</section>
<%--tab navigation--%>
<section>
    <div class="w-full overflow-hidden  bg-purple-100">
        <button class="border-4 border-solid" onclick="openCity('London')">도로명으로 찾아보기</button>
        <button class="border-4 border-solid" onclick="openCity('Paris')">유동인구로 찾아보기</button>
    </div>

    <%--첫번째 텝--%>
    <section id="London" class="city">
        <jsp:include page="Tabpage/Serchroadname.jsp" flush="false"/>
    </section>

    <%--두번째 탭--%>
    <section id="Paris" class="city" style="display:none">
        <jsp:include page="Tabpage/Searchpopulation.jsp" flush="false"/>
    </section>
</section>
</body>
</html>