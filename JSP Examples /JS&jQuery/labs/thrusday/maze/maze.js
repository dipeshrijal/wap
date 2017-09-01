"use strict";

$(document).ready(function () {
    var started = false;
    var touchedWall = false;
    var boundry = $('#maze').find('.boundary');
    var status = $('#status');

    function loseMessage() {
        touchedWall = true;
        boundry.addClass('youlose');
        status.text("Sorry, You lost. :[");
    }

    function lose() {
        $('.boundary').mouseover(function () {
            loseMessage();
        });

        $("#maze").mouseleave(function () {
            loseMessage();
        });
    }

    $('#start').on('click', function () {
        started = true;
        touchedWall = false;
        status.text("Click the \"S\" to begin.");
        boundry.removeClass('youlose');
        lose();
    });

    $('#end').on('click', function () {
        if (started && !touchedWall) {
            $('.boundary').off('mouseover');
            $('#maze').off('mouseleave');
            status.text("You win! :]");
        }
    });
});