(function () {
    var clicks = document.getElementsByTagName('div');

    console.log(clicks);
    for (var i = 0; i < clicks.length; i++) {
        clicks[i].onclick = function () {
            console.log('click successful');
        };
    }
}()); //does not pollute the global namespace.

// This return 3 in all cases because the free variable after
// execution is 3 i.e i = 3 after the loop is finished
// and the function is not executed so cannot remember the free variables
// to overcome this below function is created as buildFunctions.
function buildFunctionsOld() {
    var arr = [];

    for (var i = 0; i < 3; i++) {
        arr.push(
            function () {
                console.log(i);
            }
        )
    }

    return arr;
}

// classic example of closures.
function buildFunctions() {
    var arr = [];

    for (var i = 0; i < 3; i++) {
        arr.push(
            (function (j) {
                return function () {
                    console.log(j);
                }
            }(i))
        )
    }

    return arr;
}

var fs = buildFunctions();
fs[0]();
fs[1]();
fs[2]();

var ft = buildFunctionsOld();
ft[0]();
ft[1]();
ft[2]();