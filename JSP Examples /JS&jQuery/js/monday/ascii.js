"use strict";
(function () {
    window.onload = function () {
        var start = document.getElementById("start");
        var stop = document.getElementById("stop");
        var textarea = document.getElementById("textarea");
        var select = document.getElementById("select");
        var size = document.getElementById("size");
        var speed = document.getElementById("speed");
        var timer = null;
        var animationText;
        var time = 250;

        start.onclick = interval;
        stop.onclick = clearInt;
        size.addEventListener("change", increaseSize);
        select.addEventListener("change", doAnimation);
        speed.onclick = turboMode;

        function interval() {
            start.disabled = true;
            select.disabled = true;
            var index = 0;
            var splitted = animationText.split("=====\n");
            clearInterval(timer);
            timer = setInterval(function () {
                if (splitted.length - 1 < index) {
                    index = 0;
                } else {
                    textarea.value = splitted[index];
                    index++;
                }
            }, time);
        }

        function turboMode () {
            if (this.checked === true) {
                time = 50;
            } else {
                time = 250;
            }
            interval();
        }

        function doAnimation() {
            animationText = ANIMATIONS[select.value];
            textarea.value = animationText;
        }

        function clearInt() {
            clearInterval(timer);
            timer = null;
            start.disabled = false;
            select.disabled = false;
            doAnimation();
        }

        function increaseSize() {
            textarea.style.fontSize = size.value + "pt";
        }
    };
})();



