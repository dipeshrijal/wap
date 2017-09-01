"use strict";

$(document).ready(function () {

    var puzzleArea = $('#puzzlearea').find('div');
    var shuffleBtn = $('#shufflebutton');
    var leftSpace = 300;
    var topSpace = 300;

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

        // action on hover.
        $(element).hover(function () {
            isMoveable(element) ? $(this).addClass("movablepiece") : $(this).removeClass("movablepiece");
        });

        // action when the puzzle piece is clicked.
        $(element).click(function () {
            if (isMoveable(element)) {
                move(element);
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
        var left = parseInt($(element).css("left"));
        var top = parseInt($(element).css("top"));

        var xGap = Math.abs(left - leftSpace);
        var yGap = Math.abs(top - topSpace);

        return (xGap + yGap) === 100;
    };

    //move to empty space
    var move = function (element) {
        var xTemp = parseInt($(element).css("left"));
        var yTemp = parseInt($(element).css("top"));

        $(element).css("left", leftSpace);
        $(element).css("top", topSpace);

        leftSpace = xTemp;
        topSpace = yTemp;
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
        move(elements[rand]);
    };
});

