var person = {
    firstname: "default",
    lastname: "default",
    fullname: function () {
        return this.firstname + ' ' + this.lastname;
    }
};


var dipesh = function(para1, para2) {
    console.log(this.fullname());
    console.log(para1 + ' ' + para2);
    console.log("---------------------------------");
};

var binding = dipesh.bind(person, "h", "z");
binding();

dipesh.call(person, "h", "z");

dipesh.apply(person, ["h", "z"]);


// function borrowing

var person2 = {
    firstname: "Dipesh",
    lastname: "Rijal"
};

console.log(person.fullname.apply(person2));

console.log(person.fullname.call(person2));

var borrow = person.fullname.bind(person2);
console.log(borrow());


// function currying
console.log("-----function currying----");

function multiply(a, b) {
    return a * b;
}

// setting default parameters to always 2.
// can also both both default values.
var multiplyByTwo = multiply.bind(this, 2);
console.log(multiplyByTwo(4));