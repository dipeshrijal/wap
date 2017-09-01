"use strict";

var rudyTimer = (function () {
    var timer = null;
    function rudy() {
        document.getElementById("show").innerHTML += "Rudy!";
    }

    return function () {
        if (timer === null) {
            timer = setInterval(rudy, 1000);
        } else {
            clearInterval(timer);
            timer = null;
        }
    }
})();