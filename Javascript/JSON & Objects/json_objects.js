// Task 1: Create a Car Object
const Car = {
    make: "Toyota",
    model: "Corolla",
    year: 2021,
    color: "red",
    drive: function() {
        console.log("The car is driving.");
    }
};

Car.drive();

// Task 2: Modify the Car Object
Car.color= "blue";
Car.fuelType="gasoline";
delete Car.year;

console.log("Car color:", Car.color);
console.log("Fuel ttype:", Car.fuelType);

// Task 3: Create a Driver object
const Driver = {
    name: "John",
    licenseNumber: "ABC123456",
    age: 30
};

// Add Driver object as a property of Car
Car.driver = Driver;

// Display driver’s name using dot notation
console.log("Driver name", Car.driver.name);

// Task 4: Convert the Car object to JSON
const carJSON = JSON.stringify(Car);
console.log("Car JSON:", carJSON);

// Task 5: Parse a JSON string into a Car object
const jsonString = '{"make":"Ford", "model":"Mustang", "year":2022, "color":"black", "fuelType":"electric"}';
const newCar = JSON.parse(jsonString);

// Print the new object to the console
console.log(newCar);











