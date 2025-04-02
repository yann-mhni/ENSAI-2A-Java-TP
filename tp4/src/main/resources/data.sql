----------------------------------------------
-- Athletes
----------------------------------------------

DROP TABLE IF EXISTS athlete;

CREATE TABLE athlete (
    id           SERIAL PRIMARY KEY,
    first_name   VARCHAR(255),
    last_name    VARCHAR(255),
    age          INTEGER,
    gender       VARCHAR(255)
);

INSERT INTO athlete (id, first_name, last_name, age, gender) VALUES
(99990, 'Bowie', 'Kent', 25, 'Female'),
(99991, 'Amour', 'Hire De Rire', 30, 'Male'),
(99992, 'Aubin', 'Sahalor', 22, 'Male'),
(99993, 'Aude', 'Hébussavabien', 35, 'Female'),
(99994, 'Bart', 'Haba', 28, 'Male'),
(99995, 'Bernadette', 'Dejeu', 21, 'Female'),
(99996, 'André', 'Céouver', 40, 'Male'),
(99997, 'Aphonse', 'Kelpeuv', 27, 'Female'),
(99998, 'Bill', 'Hattérahl', 32, 'Male'),
(99999, 'Bianca', 'Lamine', 24, 'Female');


----------------------------------------------
-- Competitions
----------------------------------------------

DROP TABLE IF EXISTS competition;

CREATE TABLE competition (
    id             SERIAL PRIMARY KEY,
    designation    VARCHAR(255),
    city           VARCHAR(255),
    event_date     DATE,
    distance       FLOAT,
    maxAthletes    INTEGER
);

INSERT INTO competition (designation, city, event_date, distance, maxAthletes) VALUES
('Semi-marathon de Liffré', 'Liffré', '2024-04-06', 21.1, 500),
('100km de Crevin', 'Crevin', '2024-04-05', 100, 100),
('Rennes Urban Trail', 'Rennes', '2024-04-27', 24, 750),
('Tour de l''île d''Arz', 'Île d''Arz', '2024-05-17', 10, 300),
('Trail de l''Enfer', 'Plouguiel', '2024-07-06', 18, 200);
