// Original object
const book = {
    title: "The Great Gatsby",
    author: "F. Scott Fitzgerald",
    year: 1925,
};

// 1) Without destructuring (original way)
console.log(book.title, book.author, book.year);

// 2) With object destructuring (refactor)
const { title, author, year } = book;
console.log(title, author, year);

// 3) Challenge: rename while destructuring
const {
    title: bookTitle,
    author: writer,
    year: publishedYear,
} = book;

console.log(bookTitle, writer, publishedYear);


