<%--main page--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    request.setCharacterEncoding("utf-8");
    /*로그인 성공 후 페이지 우측 상단에 표시할 사용자 ID를 받아온다.*/
    String name = (String) request.getAttribute("name");
%>
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
    <%--login 버튼, 환영 메세지--%>
    <nav class="m-1 w-2/12">
        <%if (name == null) {%>
        <form class="text-center" name="login" action="public/Login.jsp">
            <button class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">
                <p>LOGIN</p>
            </button>
        </form>
        <%} else {%>
        <div class="p-2 text-center border-blue-500 border-2 border-solid rounded-lg"><%=name%> 님 반갑습니다.</div>
        <%}%>
    </nav>

</section>
<section class="flex">
    <nav class="flex-1">
        <%--구, 도로명 선택, 검색한 결과--%>
        <section class="flex">
            <jsp:include page="Tabpage/Serchroadname.jsp" flush="false"/>
        </section>
    </nav>
    <%--카카오맵 API를 사용한 지도--%>
    <nav class="flex-1 w-3/5 p-1">
        <%--지도 --%>
        <div class="rounded-lg" id="map" style="width:100%;height:350px;"></div>
        <script language="JavaScript" type="text/javascript"
                src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f261be6511a4d3977d69ca432448bbd2&libraries=services"></script>
    </nav>
</section>
</body>
</html>