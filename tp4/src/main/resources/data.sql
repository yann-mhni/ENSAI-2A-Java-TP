DROP TABLE IF EXISTS athlete;

-- Create the table
CREATE TABLE athlete (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    age INTEGER,
    gender VARCHAR(255)
);

-- Insert 10 rows into the table
INSERT INTO athlete (id, first_name, last_name, age, gender) VALUES
(99990, 'Alice', 'Smith', 25, 'Female'),
(99991, 'Bob', 'Johnson', 30, 'Male'),
(99992, 'Charlie', 'Brown', 22, 'Male'),
(99993, 'Diana', 'Davis', 35, 'Female'),
(99994, 'Ethan', 'Wilson', 28, 'Male'),
(99995, 'Fiona', 'Taylor', 21, 'Female'),
(99996, 'George', 'Anderson', 40, 'Male'),
(99997, 'Hannah', 'Thomas', 27, 'Female'),
(99998, 'Ian', 'White', 32, 'Male'),
(99999, 'Jane', 'Moore', 24, 'Female');


DROP TABLE IF EXISTS competition;

CREATE TABLE competition (
    id               SERIAL PRIMARY KEY,
    designation      VARCHAR(255) NOT NULL,
    event_date       DATE,
    distance         FLOAT,
    max_athletes INTEGER
);

INSERT INTO competition (id, designation, event_date, distance, max_athletes) VALUES
(880, 'Spring Sprint', '2024-03-20', 5.0, 100),
(881, 'Summer Marathon', '2024-06-15', 42.2, 500),
(882, 'Autumn Half', '2024-09-22', 21.1, 300),
(883, 'Winter 10K', '2024-12-10', 10.0, 200),
(884, 'New Year Run', '2025-01-01', 5.0, 150);
