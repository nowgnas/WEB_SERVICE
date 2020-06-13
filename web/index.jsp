<%--main page--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>WEBSERVICE</title>
    <link rel="stylesheet" href="public/build/tailwind.css">
    <link rel="stylesheet" href="public/build/custom.css">
    <script src="Apidata/MapJS.js" type="text/javascript"></script>
</head>
<body>
<!--title -->
<section class="m-2 flex">
    <nav class="w-11/12">
        <div class="text-4xl font-bold text-center text-blue-500">서울시 상권 분석 서비스</div>
    </nav>
    <%--title--%>
    <!--login button -->
    <nav class="w-2/12 flex">
        <form class="mr-3" name="login" action="About/About.jsp">
            <button class="bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded">
                <p>ABOUT</p>
            </button>
        </form>
        <form name="login" action="public/Login.jsp">
            <button class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">
                <p>LOGIN</p>
            </button>
        </form>
    </nav>
    <%--login--%>
</section>
<%--tab navigation--%>
<section class="flex">
    <nav class="flex-1">
        <section class="flex">
            <jsp:include page="Tabpage/Serchroadname.jsp" flush="false"/>
        </section>
    </nav>
    <nav class="flex-1 w-3/5 p-1">
        <%--지도 --%>
        <div class="rounded-lg" id="map" style="width:100%;height:350px;"></div>
        <script language="JavaScript" type="text/javascript"
                src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f261be6511a4d3977d69ca432448bbd2&libraries=services"></script>
        <!--Map javascript -->
        <%--지도--%>
    </nav>
</section>
</body>
</html>