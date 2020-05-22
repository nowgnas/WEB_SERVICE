<%--카카오 맵 파싱--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
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
