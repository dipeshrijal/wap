// 1st class functions
// functional programming
"use strict";

var arr1 = [1, 2, 3];
console.log(arr1);

console.log("-------------------------------");

// double the value and create a new array

//traditional method

var arr2 = [];

for(var i = 0; i < arr1.length; i++) {
    arr2.push(
        arr1[i] * 2
    );
}

console.log(arr2);
console.log("-------------------------------");

// functional approach

function mapForEach(arr, fn) {
    var newArr = [];
    for(var i = 0; i < arr1.length; i++) {
        newArr.push(
            fn(arr[i])
        );
    }

    return newArr;
}

var arr3 = mapForEach(arr1, function (item) {
    return item * 2;
});
console.log(arr3);
console.log("-------------------------------");

// return a boolean array with the result greater than 2.
var arr4 = mapForEach(arr1, function (item) {
    return item > 2;
});
console.log(arr4);
console.log("-------------------------------");

var checkPastLimit = function (limiter, item) {
    return item > limiter;
};

var arr5 = mapForEach(arr1, checkPastLimit.bind(this, 1));
console.log(arr5);
console.log("-------------------------------");

function checkPastLimitBind(limiter) {
    return function (limiter, item) {
        return item > limiter;
    }.bind(this, limiter);
}

var arr6 = mapForEach(arr1, checkPastLimitBind(4));
console.log(arr6);
console.log("-------------------------------");




