"use strict";

$(document).ready(function () {

    var puzzleArea = $('#puzzlearea').find('div');
    var shuffleBtn = $('#shufflebutton');
    var xSpace = 300;
    var ySpace = 300;

    puzzleArea.each(function (i, element) {
        var x = ((i % 4) * 100);
        var y = (Math.floor(i / 4) * 100);

        $(element).addClass('puzzlepiece');
        $(element).css({
            'left': x,
            'top': y,
            'background-image': 'url("background.jpg")',
            'background-position': -x + 'px ' + (-y) + 'px'
        });
        $(element).x = x;
        $(element).y = y;

        //hover event
        $(element).hover(function () {
            if (isMoveable(element)) {
                $(this).addClass("movablepiece");
            } else {
                $(this).removeClass("movablepiece");
            }
        });


        $(element).click(function () {
            if (isMoveable(element)) {
                moveToEmptySpace(element);
            }
        });

    });


    shuffleBtn.on('click', function () {
        for (var i = 0; i < 300; i++) {
            randomMove();
        }
    });

    //check if element is movable
    var isMoveable = function (element) {
        var xThis = parseInt($(element).css("left"));
        var yThis = parseInt($(element).css("top"));

        var xGap = Math.abs(xThis - xSpace);
        var yGap = Math.abs(yThis - ySpace);

        return (xGap + yGap) === 100;
    };

    //move to empty space
    var moveToEmptySpace = function (element) {
        var xTemp = parseInt($(element).css("left"));
        var yTemp = parseInt($(element).css("top"));

        $(element).css("left", xSpace);
        $(element).css("top", ySpace);

        xSpace = xTemp;
        ySpace = yTemp;
    };

    //randomly move to 1 out of many possible moves
    var randomMove = function () {
        var elements = [];
        puzzleArea.each(function (idx, element) {
            if (isMoveable(element)) {
                elements.push(element);
            }
        });

        var rand = parseInt(Math.random() * elements.length);
        moveToEmptySpace(elements[rand]);
    };
});

