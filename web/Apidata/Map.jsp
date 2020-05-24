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
</head>
<body>
<%--구 도로명 선택 --%>
<section class="flex">
    <form class="flex bg-purple-100 w-3/5" action="00" name="doroname">
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
    </form>
</section>

<%--지도 --%>
<div id="map" style="width:100%;height:100%;"></div>
<script language="JavaScript" type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f261be6511a4d3977d69ca432448bbd2"></script>
<script language="JavaScript">
    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(37.592128, 126.97942),
        level: 7
    };

    var map = new kakao.maps.Map(container, options);
</script>
</body>
</html>
