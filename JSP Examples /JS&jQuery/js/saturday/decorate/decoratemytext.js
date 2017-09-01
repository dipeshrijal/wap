function myAlert() {
    alert("Hello, world!");
}

function change() {
    var abc = document.getElementById("text");
    var bli = document.getElementById("bling");

    if (bli.checked) {
        abc.style.color = "green";
        abc.style.textDecoration = "underline";
        abc.style.fontWeight = "bold";
        document.getElementById("body").style.backgroundImage = "url('hundred-dollar-bill.jpg')";
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

    function increaseFont() {
        var size = parseInt(text.style.fontSize);
        text.style.fontSize = (size + 2) + "pt";
    }

    decoration.onclick = function () {
        if (timer === null) {
            timer = setInterval(increaseFont, 500);
        } else {
            clearInterval(timer);
            timer = null;
        }
    }
};

