window.onload = function () {
    geo1();

    function geo1() {
        var send = document.getElementById("geo").value;

        geo(send);
    }

    function geo(search) {
        var geocoder = new kakao.maps.services.Geocoder();

        var callback = function (result, status) {
            if (status === kakao.maps.services.Status.OK) {
                console.log(result);
            }
        };
        geocoder.addressSearch(search, callback);
    }

    geo();
}