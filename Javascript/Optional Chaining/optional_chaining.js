// Task 1: Create the book object
const book = {
    title: "JavaScript Basics",
    author: {
        name: "John Doe",
        social: {
            twitter: "@johndoe"
        }
    }
};

// optional chaining to access the Twitter handle
console.log(book.author?.social?.twitter);

// Try accessing a non-existent property using optional chaining
console.log(book.publisher?.name);

book.edition = {
    year: 2024
};

if (book.edition?.year) {
    console.log(`Edition year: ${book.edition.year}`);
} else {
    console.log("Edition information not available.");
}

// Test a version of the book without edition
const book2 = {
    title: "Advanced JavaScript"
};

console.log(book2.edition?.year ?? "Edition information not available.");
