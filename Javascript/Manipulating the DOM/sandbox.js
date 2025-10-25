/* References to DOM elements */

const changeColorBtn = document.getElementById("changeColorBtn");
const addItemBtn = document.getElementById("addItemBtn"); 
const itemList       = document.getElementById("itemList");

/* Data */
const bgPalette = ["#f5f3ee", "#e6dfd3", "#faf9f6", "#efe9df", "#f2eee7"];
let colorIndex = 0;

// Outfit ideas
const fits = [
  "Stone cargos + white tee + clean sneakers",
  "Navy knit + tapered denim + loafers",
  "Black tee + tailored trousers + minimal trainers",
  "Cream hoodie + slate joggers + runners",
  "Boxy oxford + pleated shorts + crew socks"
];

let nextFit = 0;

/* Event: Change background color on click */
changeColorBtn.addEventListener("click", () => {
    colorIndex = (colorIndex + 1) % bgPalette.length;
    document.body.style.backgroundColor = bgPalette[colorIndex];
    console.log("Background changed to:", bgPalette[colorIndex]);
  });


/* Event: Add a new <li> on each click */
addItemBtn.addEventListener("click", () => {
    const li = document.createElement("li");
    li.textContent = fits[nextFit];
    console.log("Added outfit:", li.textContent);                 
    nextFit = (nextFit + 1) % fits.length;
    itemList.appendChild(li);
  });


/* Event: Start page with a hint */
console.log("DOM ready. Click the buttons to see changes.");








