function makeGreeting(language) {
    // languages is free variable and has its own
    // execution context when it is created.
    return function (firstname, lastname) {
        if (language === 'en') {
            console.log("Hello " + firstname + ' ' + lastname);
        }

        if (language === 'es') {
            console.log("Hola " + firstname + ' ' + lastname);
        }
    }
}

// has its own execution context
var englishGreeting = makeGreeting('en');
// has its own execution context
//test
var spanishGreeting = makeGreeting('es');

englishGreeting("Dipesh", "Rijal"); // Hello Dipesh Rijal
spanishGreeting('Dipesh', 'Rijal'); // Hola Dipesh Rijal