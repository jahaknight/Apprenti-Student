CREATE DATABASE IF NOT EXISTS movie_db;
USE movie_db;

DROP TABLE IF EXISTS movie_genres;   -- child (correct name)
DROP TABLE IF EXISTS movies_genres;  -- child (typo name from earlier)
DROP TABLE IF EXISTS credits;        -- child
DROP TABLE IF EXISTS genres;         -- parent of movie_genres
DROP TABLE IF EXISTS actors;         -- parent of credits
DROP TABLE IF EXISTS movies;         -- parent of credits & movie_genres        


-- Movies table

CREATE TABLE movies (
  movie_id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(150) NOT NULL,
  release_year YEAR,
  rating VARCHAR(10)
);

-- Actors Table 
CREATE TABLE actors (
  actor_id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL
);

-- Credits 
CREATE TABLE credits (
  credit_id INT PRIMARY KEY AUTO_INCREMENT,
  movie_id  INT NOT NULL,
  actor_id  INT NOT NULL,
  role_name VARCHAR(100),
  CONSTRAINT fk_credits_movie
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id) ON DELETE CASCADE,
  CONSTRAINT fk_credits_actor
    FOREIGN KEY (actor_id) REFERENCES actors(actor_id) ON DELETE CASCADE
);

-- Seed data
INSERT INTO movies (title, release_year, rating) VALUES
('The Fast and the Furious', 2009, 'PG-13'),
('Wonder Woman',              2017, 'PG-13'),
('Guardians of the Galaxy',   2014, 'PG-13'),
('Encanto',                   2021, 'PG');

INSERT INTO actors (first_name, last_name) VALUES
('Vin', 'Diesel'),
('Gal', 'Gadot'),
('Chris', 'Pratt'),
('Zoe', 'Saldana'),
('Stephanie', 'Beatriz'),
('John', 'Leguizamo'),
('Chris', 'Pine');

INSERT INTO credits (movie_id, actor_id, role_name) VALUES
(1, 1, 'Dominic Toretto'),
(1, 2, 'Gisele'),
(2, 2, 'Diana Prince / Wonder Woman'),
(2, 7, 'Steve Trevor'),
(3, 3, 'Peter Quill / Star-Lord'),
(3, 1, 'Groot'),
(3, 4, 'Gamora'),
(4, 5, 'Mirabel'),
(4, 6, 'Bruno');

-- (Step 1)
SELECT m.title, a.first_name, a.last_name, c.role_name
FROM credits c
JOIN movies m ON c.movie_id = m.movie_id
JOIN actors a ON c.actor_id = a.actor_id
ORDER BY m.title, a.last_name, a.first_name;

-- 
-- GENRES (STEP 2)
-- 
CREATE TABLE genres (
  genre_id   INT PRIMARY KEY AUTO_INCREMENT,
  genre_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE movie_genres (
  movie_id INT NOT NULL,
  genre_id INT NOT NULL,
  PRIMARY KEY (movie_id, genre_id),
  FOREIGN KEY (movie_id) REFERENCES movies(movie_id) ON DELETE CASCADE,
  FOREIGN KEY (genre_id) REFERENCES genres(genre_id) ON DELETE CASCADE
);

INSERT INTO genres (genre_name) VALUES
('Action'), ('Crime'), ('Thriller'),
('Adventure'), ('Fantasy'),
('Animation'), ('Comedy'), ('Family');

-- Map movies → genres
INSERT INTO movie_genres VALUES (1,1), (1,2), (1,3);  -- Fast & Furious
INSERT INTO movie_genres VALUES (2,1), (2,4), (2,5);  -- Wonder Woman
INSERT INTO movie_genres VALUES (3,1), (3,4), (3,5);  -- Guardians
INSERT INTO movie_genres VALUES (4,6), (4,7), (4,8);  -- Encanto

-- Verify genres
SELECT m.title, g.genre_name
FROM movie_genres mg
JOIN movies m ON mg.movie_id = m.movie_id
JOIN genres g ON mg.genre_id = g.genre_id
ORDER BY m.title, g.genre_name;