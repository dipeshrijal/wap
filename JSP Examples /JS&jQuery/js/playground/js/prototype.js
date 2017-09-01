var person = {
    firstname: "Default",
    lastname: "Default",
    getFullName: function () {
        return this.firstname + " " + this.lastname;
    }
};

var dipesh = {
    firstname: "Dipesh",
    lastname: "Rijal"
};

dipesh.__proto__ = person;
console.log(dipesh.getFullName());
console.log(dipesh.firstname);

var jane = {
    firstname: "Jane"
};

jane.__proto__ = person;
console.log(jane.getFullName());
console.log(jane.lastname);

var empty = {};

empty.__proto__ = person;
console.log(empty.getFullName());