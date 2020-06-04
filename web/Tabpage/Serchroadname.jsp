<%--  도로명으로 검색하기--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    request.setCharacterEncoding("utf-8");
    String gil = (String) request.getAttribute("gil");
    String year = (String) request.getAttribute("year");
    String bungi = (String) request.getAttribute("bungi");
    String trdarcode = (String) request.getAttribute("trdarcode");
    String code = (String) request.getAttribute("code");
%>
<html>
<head>
    <title>WEBSERVICE</title>
    <link rel="stylesheet" href="public/build/tailwind.css">
    <link rel="stylesheet" href="public/build/custom.css">
</head>
<body>
<!--print, input area-->
<section class="flex">
    <nav class="p-1 h-map">
        <%--지도 --%>
        <%--구 도로명 선택 --%>
        <section class="flex">
            <jsp:include page="../Select/Gu.jsp" flush="false"/>
        </section>
    </nav>

    <!--Input-->
    <nav class="flex bg-teal-200">
        <div>
            <div>User information</div>
            <br>
            <div>
                기준 년 코드: <%=year%>
            </div>
            <div>
                번지 = <%=bungi%><br>
            </div>
            <div>
                상권 분류 코드 = <%=trdarcode%><br>
            </div>
            <div>
                상권 이름 = <span id="gilname"><%=gil%>
            </span> <br>
            </div>
            <div>
                상권 코드 = <%=code%>
            </div>
        </div>
    </nav>
</section>
</body>
</html>