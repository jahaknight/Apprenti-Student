/* Part 1: Function Basics */

function greetUser(name) {
    console.log(`Hello, ${name}!`);
}
// Example calls
greetUser("Jaha");
greetUser("Anthony");

/* Part 2: Returning Values */
function squareNumber(n) {
    return n * n;
  }
  const squareOf4 = squareNumber(4);
  const squareOf7 = squareNumber(7);
  console.log("squareNumber(4) =", squareOf4);
  console.log("squareNumber(7) =", squareOf7);

/* Part 3: Multiple Parameters */
function addNumbers(a, b) {
    return a + b;
  }
  console.log("addNumbers(10, 5) =", addNumbers(10, 5));
  console.log("addNumbers(3, 8)  =", addNumbers(3, 8));

/* Part 4: Random Color Generator */
const colors = ["red", "blue", "green", "yellow", "purple", "orange"];
function getRandomColor() {
  const index = Math.floor(Math.random() * colors.length);
  return colors[index];
}
console.log("Random color 1:", getRandomColor());
console.log("Random color 2:", getRandomColor());
console.log("Random color 3:", getRandomColor());


/* Part 5: Random Fortune Teller */
const fortunes = [
    "You will have a great day!",
    "A surprise is waiting for you.",
    "Something exciting is coming soon.",
    "Be cautious with your decisions today.",
    "Happiness is around the corner."
  ];
  function tellFortune() {
    const index = Math.floor(Math.random() * fortunes.length);
    return fortunes[index];
  }
  console.log("Your fortune:", tellFortune());











