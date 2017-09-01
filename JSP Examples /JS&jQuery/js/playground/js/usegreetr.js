

// g.greet().greet(true).setLang('es').greet().log();


$('#login').on('click', function () {
    var lang = $('#lang').val();
    var g = G$('Dipesh', 'Rijal', lang);
    g.HTMLGreeting('#greeting', true);
});