CREATE DATABASE StoreFront;
USE StoreFront;

CREATE TABLE category (
	categoryID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(255) NOT NULL,
    ParentCategoryID INT,
    FOREIGN KEY (ParentCategoryID) REFERENCES category(categoryID) ON DELETE CASCADE
);

CREATE TABLE Product (
	productID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    Description TEXT,
    Brand TEXT,
    Quantity INT NOT NULL,
    categoryID INT,
    FOREIGN KEY(categoryID) REFERENCES category(categoryID) ON DELETE CASCADE 
);

CREATE TABLE Image (
	imageID INT PRIMARY KEY NOT NULL,
    productID INT,
    imageURL VARCHAR(255),
    FOREIGN KEY (productID) REFERENCES Product(productID) ON DELETE CASCADE
);

CREATE TABLE User (
	userID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    emailID VARCHAR(255) NOT NULL,
    dateOfBirth DATE NOT NULL,
    phoneNumber VARCHAR(255) NOT NULL,
    userType ENUM("Shopper", "Administrator") NOT NULL
);

CREATE TABLE ShippingAddress (
	ShippingAddressID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL, 
    state VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    zipCode INT NOT NULL,
    FOREIGN KEY (userID) REFERENCES User(userID) ON DELETE CASCADE
);

CREATE TABLE Orders (
	orderID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT,
    shippingAddressID INT,
    orderDate DATE NOT NULL,
    totalAmount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (userID) REFERENCES User(UserID) ON DELETE CASCADE,
    FOREIGN KEY (shippingAddressID) REFERENCES ShippingAddress(shippingAddressID) ON DELETE CASCADE
);

CREATE TABLE orderItem (
	itemID INT PRIMARY KEY AUTO_INCREMENT,
    productID INT,
    orderID INT,
    quantity INT NOT NULL,
    itemStatus ENUM("Shipped", "Placed", "Cancelled", "Returned") NOT NULL,
    FOREIGN KEY (orderID) REFERENCES orders(orderID) ON DELETE CASCADE,
    FOREIGN KEY (productID) REFERENCES Product(productID) ON DELETE CASCADE
);
