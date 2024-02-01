CREATE TABLE IF NOT EXISTS userTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL
);

INSERT INTO userTable(firstName, lastName) VALUES ('Ivan', 'Ivanov');
INSERT INTO userTable(firstName, lastName) VALUES ('Petr', 'Petrov');