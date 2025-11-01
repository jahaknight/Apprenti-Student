// Step 1: define some variables
const firstName = "Jaha";
const role = "Software Engineer Apprentice";
const location = "Philadelphia, PA";
const active = true;

// Step 2: regular object (no shorthand)
const userRegular = {
    firstName: firstName,
    role: role,
    location: location,
    active: active
};

console.log("Regular objects:", userRegular);

// Step 3: object shorthand (keys match variable names)
const userShorthand = {
    firstName,
    role,
    location,
    active
};

console.log("Shorthand object:", userShorthand);

// Step 4: method shorthand
const account = {
    owner: firstName,
    // long way:
    // showInfo: function () {
    //   console.log(`Account owner: ${this.owner}`);
    // },
    // shorthand way:
    showInfo() {
        console.log(`Account owner: ${this.owner}`);
    }
};

account.showInfo();

// Step 5: shorthand inside a function (common pattern)
function createTask(title, completed = false, priority = "normal") {
    return {
        title,
        completed,
        priority,
        creaetedAt: new Date().toISOString()
    };
}

const task1 = createTask("Finish Object Shorthand exercise");
console.log("Task 1:", task1);





