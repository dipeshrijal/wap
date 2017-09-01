function greetings(name) {
    var greeting = "Hello";

    setTimeout(function () {
        console.log(greeting + ' ' + name);
    }, 3000);
}

function callbackFunction(callback) {
    callback();
}

greetings('Dipesh');

callbackFunction(function () {
    console.log("This is callback function");
});

callbackFunction(function () {
    var hello = "try";
    console.log(hello);
});