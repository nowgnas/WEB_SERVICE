<%--카카오 맵 파싱--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="public/build/tailwind.css">
    <link rel="stylesheet" href="public/build/custom.css">
    <link rel="stylesheet" href="Apidata/Map.css">
    <script src="Apidata/Map.js"></script>

</head>
<body>
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
<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white">
        <div class="option">
            <div>
                <form onsubmit="searchPlaces(); return false;">
                    키워드 : <input type="text" value="이태원 맛집" id="keyword" size="15">
                    <button type="submit">검색하기</button>
                </form>
            </div>
        </div>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
</div>
<script language="JavaScript" type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f261be6511a4d3977d69ca432448bbd2&libraries=services"></script>
<!--Map javascript -->
</body>
</html>
