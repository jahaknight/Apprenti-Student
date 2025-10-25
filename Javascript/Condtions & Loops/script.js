/* Part 1: If statement (Even or Odd checker) */

const randomNumber = Math.floor(Math.random() * 50) + 1;
console.log("Random Number", randomNumber);

if (randomNumber % 2 === 0) {
    console.log(randomNumber + " is even.");
} else {
    console.log(randomNumber + " is odd.");
}

/* Part 2: Switch Statement (Day of the Week) */

const userDay = prompt("Enter a number (0-6) to get the day of the week:");

switch (Number(userDay)) {
    case 0:
        console.log("Sunday");
        break;

    case 1:
        console.log("Monday");
        break;

    case 2:
        console.log("Tuesday");
        break;
        
    case 3:   
        console.log("Wednesday");
        break; 

    case 4:
        console.log("Thursday");
        break;
    
    case 5:
        console.log("Friday");
        break;
        
    case 6:
        console.log("Saturday");
        break;
        
    default:
        console.log("Error: Please enter a number between 0 and 6.");  
    
}

/* Part 3: While Loop (Rolling Dice Until a 6 Appears) */

let roll = 0;

while (roll !== 6) {
    roll = Math.floor(Math.random() * 6) + 1;
    console.log("Rolled:", roll);
}

/* Part 4: For Loop (Counting Down) */
const startNumber = prompt("Enter a starting number to count down from:");

for (let i = Number(startNumber); i >= 0; i--) {
    console.log(i);
}

/* Bonus: Reverse a Word Using a For Loop */

const word = prompt("Enter a word to reverse:")
let reversed = "";

for (let i = word.length - 1; i >= 0; i-- ) {
    reversed += word[i];
}

console.log("Reversed word:", reversed);






