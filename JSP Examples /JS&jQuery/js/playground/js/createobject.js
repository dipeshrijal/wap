var person = {
    firstname: "default",
    lastname: "default",
    greet: function () {
        return "Hi " + this.firstname;
    }
};

var dipesh = Object.create(person);
dipesh.firstname = "dipesh";
dipesh.lastname = "rijal";
console.log(dipesh.greet());

// polyfill- code that adds a feture which engine may lack.