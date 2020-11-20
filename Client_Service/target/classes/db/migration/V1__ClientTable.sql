CREATE TABLE client(
    id UUID NOT NULL PRIMARY KEY,
    fullName VARCHAR(50) NOT NULL,
    password VARCHAR(10) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
    balance FLOAT NOT NULL,
    creditCard VARCHAR(50) NOT NULL,
    startDate DATE NOT NULL
);