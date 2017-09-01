// everything has prototype except the base object
var a = {};
var b = function () {
};
var c = [];

// console.log(a.__proto__);
// console.log(b.__proto__);
// console.log(c.__proto__);

// reflection and extend.

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
// console.log(dipesh.getFullName());
// console.log(dipesh.firstname);

for (var prop in dipesh) {
    if (dipesh.hasOwnProperty(prop))
        console.log(prop + ': ' + dipesh[prop]);
}


var jane = {
    address: "1000 N 4th Street",
    getFormalFullName: function () {
        return this.lastname + ", " + this.firstname;
    }
};

var jim = {
    getFirstName: function () {
        return this.firstname;
    }
};

_.extend(dipesh, jane, jim);

console.log(dipesh);
console.log(dipesh.getFormalFullName());
console.log(dipesh.getFirstName());

