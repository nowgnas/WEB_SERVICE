"use strict";
(function () {
    function load() {

        const login = document.querySelector("#login");
        login.addEventListener("click", loginpop);
    }

    function loginpop() {
        const url = "public/Login.jsp";
        const name = "popup";
        window.open(url, name, "width=330,height=330");
    }

    window.onload = load;
})();