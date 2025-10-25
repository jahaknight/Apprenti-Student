/* Decided to use Music instead of fruit */

/* Part 1: Declaring and Accessing Arrays */

let playlist = ["Summer Walker", "Jazmine Sullivan", "BossManDlow", "K CAMP"];
console.log("Full playlist:", playlist);

// Accessing first and last element by index
console.log("First artist:", playlist[0]);
console.log("Last artist", playlist[playlist.length - 1]);


/* Part 2: Modifying Arrays */
playlist[1] = "Drake";
// Add to end
playlist.push("H.E.R.");
// Add to beginning
playlist.unshift("Kendrick Lamar");

// Remove first element and print removed value
let removedFirst = playlist.shift();
console.log("Removed first artist:", removedFirst);

// Remove last element and print removed value
let removedLast = playlist.pop();
console.log("Removed last artist:", removedLast);

// Print updated playlist
console.log("Updated playlistL=:", playlist);


/* Part 3: Looping Through the Array */
console.log("Every artist in playlist:");
for (let i = 0; i < playlist.length; i++) {
    console.log(playlist[i]);
}

console.log("Skipping every other artist:");
for (let i = 0; i < playlist.length; i += 2) {
     console.log(playlist[i]);
}

/* Part 4: Advanced Array Methods */
// Find index of BossManDlow 
let index = playlist.indexOf("BossManDlow ");
console.log("Index of BossManDlow ", index);

// Remove "BossManDlow " using splice (1 item at found index)
if (index !== -1) playlist.splice(index, 1);

// Concatenate with another array of new artists
let newArtists = ["Frank Ocean", "Kehlani", "Giveon"];
let finalPlaylist = playlist.concat(newArtists);

console.log("Final combined playlist:", finalPlaylist);

/* Bonus: Most Frequent Random Number */
let randomNumbers = [];
for (let i = 0; i < 10; i++) {
    randomNumbers.push(Math.floor(Math.random() * 5) + 1);
}
console.log("Random numbers:", randomNumbers);

// Count frequency
let counts = {};
for (let num of randomNumbers) {
    counts[num] = (counts[num] || 0) + 1;
}

// Find number with max frequency
let mostFrequent = null;
let highestCount = 0;
for (let num in counts) {
    if (counts[num] > highestCount) {
        highestCount = counts[num];
        mostFrequent = num;
    }
}

console.log(`Most frequent number: ${mostFrequent} (appeared ${highestCount} times)`);





















