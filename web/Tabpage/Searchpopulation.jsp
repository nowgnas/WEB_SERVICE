<%-- 유동인구로 검색하기--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <nav class="p-1 w-3/6 h-map">
        <%--지도 --%>
        <%--구 도로명 선택 --%>
        <section class="flex">
            <jsp:include page="../Select/Gu.jsp" flush="false"/>
        </section>
    </nav>

</section>
</body>
</html>