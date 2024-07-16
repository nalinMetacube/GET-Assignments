CREATE DATABASE RegionInformatiom;
USE RegionInformatiom;

CREATE TABLE Country (
	countryID INT PRIMARY KEY,
    countryName VARCHAR(50) NOT NULL
);

CREATE TABLE City (
	cityID INT PRIMARY KEY,
    countryID INT,
    cityName VARCHAR(50) NOT NULL,
    FOREIGN KEY (countryID) REFERENCES Country(countryID)
);

CREATE TABLE ZipCodes (
	CodeID INT PRIMARY KEY AUTO_INCREMENT,
	Zipcode VARCHAR(50) NOT NULL,
    countryID INT,
    cityID INT,
    FOREIGN KEY (countryID) REFERENCES Country(countryID),
    FOREIGN KEY (cityID) REFERENCES City(cityID)
);

INSERT INTO Country (countryID, countryName) VALUES
(1, 'United States'),
(2, 'Canada'),
(3, 'Mexico'),
(4, 'Germany'),
(5, 'France');

INSERT INTO City (cityID, countryID, cityName) VALUES
(1, 1, 'New York'),
(2, 1, 'Los Angeles'),
(3, 2, 'Toronto'),
(4, 2, 'Vancouver'),
(5, 3, 'Mexico City'),
(6, 4, 'Berlin'),
(7, 4, 'Munich'),
(8, 5, 'Paris'),
(9, 5, 'Lyon');

INSERT INTO ZipCodes (Zipcode, countryID, cityID) VALUES
('10001', 1, 1),
('90001', 1, 2),
('M5A1A1', 2, 3),
('V6M1A1', 2, 4),
('01000', 3, 5),
('10115', 4, 6),
('80331', 4, 7),
('75001', 5, 8),
('69001', 5, 9);

SELECT z.ZipCode AS ZipCode, ci.cityName, co.countryName FROM Zipcodes AS z
INNER JOIN City AS ci ON ci.cityID = z.cityID
INNER JOIN Country AS co ON co.countryID = z.countryID;