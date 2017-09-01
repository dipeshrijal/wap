function Person(firstname, lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
}

Person.prototype.getFullName = function () {
    return this.firstname + ' ' + this.lastname;
};

var dipesh = new Person("Dipesh", "Rijal");
var jane = new Person("Jane", "Doe");

console.log(dipesh.firstname);
console.log(dipesh.getFullName());
console.log(jane.getFullName());