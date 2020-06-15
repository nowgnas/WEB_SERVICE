<%--  도로명으로 검색하기--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    request.setCharacterEncoding("utf-8");
    /*API servlet에서 데이터를 받아온다.*/
    /*도로명*/
    String gil = (String) request.getAttribute("gil");
    /*남자 직장인구*/
    String man = (String) request.getAttribute("man");
    /*여자 직장인구*/
    String women = (String) request.getAttribute("women");

    /*남자 상주인구*/
    String manlive = (String) session.getAttribute("manlive");
    /*여자 상주인구*/
    String womenlive = (String) session.getAttribute("womenlive");

    /*초기 페이지 로딩시 모든 값이 null*/
    if (gil == null) {
        gil = "도로명";
        man = "0";
        women = "0";
        manlive = "0";
        womenlive = "0";
    }
%>
<html>
<head>
    <title>WEBSERVICE</title>
    <link rel="stylesheet" href="public/build/tailwind.css">
    <link rel="stylesheet" href="public/build/custom.css">
</head>
<body>
<section class="flex w-full">
    <nav class="p-1 h-map bg-indigo-400 rounded-lg bg">
        <%--구 도로명 선택 --%>
        <section class="justify-center">
            <jsp:include page="../Select/Gu.jsp" flush="false"/>
        </section>
    </nav>

    <%--검색 한 데이터--%>
    <nav class="flex justify-center rounded-lg bg-blue-300 w-1/2 p-1">
        <div class="pt-5">
            <div><span id="gilname"><%=gil%>
            </span>의 정보
            </div>
            <br>
            <div>
                남자 직장 인구수 : <%=man%> 명
            </div>
            <br>
            <div>
                여자 직장 인구수 : <%=women%> 명
            </div>
            <br>
            <div>
                남자 상주 인구수 : <%=manlive%> 명
            </div>
            <br>
            <div>
                여자 상주 인구수 : <%=womenlive%> 명
            </div>
        </div>
    </nav>
</section>
</body>
</html>