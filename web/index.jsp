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
    <script src="Loginpopup.js" type="text/javascript"></script>
    <script src="Apidata/MapJS.js"></script>
</head>
<body>
<!--title -->
<section class="m-2 flex">
    <nav class="w-11/12">
        <div class="text-4xl font-bold text-center text-blue-500"><a
                href="http://localhost:8080/WEB_SERVICE1_war_exploded/">WEB SERVICE</a>
        </div>
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
        <%--지도 --%>
        <%--구 도로명 선택 --%>
        <section class="flex">
            <form class="flex bg-purple-100 w-3/5" action="RQ" method="post" name="doroname">
                <div class="flex-1  w-1/5">
                    <p>구 선택</p>
                    <select name="gu">
                        <option>종로구</option>
                        <option>강서구</option>
                    </select>
                </div>
                <%--submit을 버튼으로 만들기--%>
                <div class="flex-1 w-1/5">
                    <p>도로명 선택</p>
                    <input class="rounded border-solid border-2 w-full" list="gil" name="gil">
                    <datalist id="gil">
                        <option value="창신길">창신길</option>
                        <option value="창신2길">창신2길</option>
                    </datalist>
                </div>
                <input type="submit" value="전송" name="submitbtn">
            </form>
        </section>
        <%--지도 --%>

        <div id="map" style="width:100%;height:350px;"></div>
        <script language="JavaScript" type="text/javascript"
                src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f261be6511a4d3977d69ca432448bbd2&libraries=services"></script>
        <!--Map javascript -->
        <%--지도--%>
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
