function myAlert() {
    alert("Hello, world!");
}

function change() {
    var abc = document.getElementById("text");
    var bli = document.getElementById("bling");
    var body = document.getElementById("body");

    if (bli.checked) {
        abc.style.color = "green";
        abc.style.textDecoration = "underline";
        abc.style.fontWeight = "bold";
        body.style.backgroundImage = "url('hundred-dollar-bill.jpg')";
    } else {
        abc.style.color = "black";
        abc.style.textDecoration = "none";
        abc.style.fontWeight = "normal";
    }

}

window.onload = function () {
    var text = document.getElementById("text");
    var decoration = document.getElementById("decoration");
    text.style.fontSize = "12pt";
    var timer = null;
    var igpay = document.getElementById("igpay");
    var malkovic = document.getElementById("malkovic");
    var malko = document.getElementById("malko");

    function increaseFont() {
        var size = parseInt(text.style.fontSize);
        text.style.fontSize = (size + 2) + "pt";
    }

    function chageWord() {
        var word = malkovic.value;
        var split = word.split(" ");
        //
        var val = " ";
        for (var i = 0; i < split.length; i++) {
            if (split[i].length >= 5) {
                val += "Malkovich" + " ";
                // val.concat("Malkovich");
            } else {
                // val.concat(split[i].toString());
                val += split[i] + " ";
            }
        }
        malkovic.value = val;
    }

    function convertIgpay() {
        var element = document.getElementById("pig");
        var word = element.value;

        if (word.charAt(0) === "a" || word.charAt(0) === "e" || word.charAt(0) === "i" || word.charAt(0) === "o" || word.charAt(0) === "u") {
            element.value = word + "ay";
        } else {
            var substr = word.substring(1);
            var char = word.charAt(0);
            element.value = substr + char + "ay";
        }
    }

    decoration.onclick = function () {
        if (timer === null) {
            timer = setInterval(increaseFont, 500);
        } else {
            clearInterval(timer);
            timer = null;
        }
    };

    igpay.onclick = convertIgpay;

    malko.onclick = chageWord;
};

