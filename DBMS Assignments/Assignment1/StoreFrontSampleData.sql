INSERT INTO category (Title, ParentCategoryID)
VALUES
    ('Electronics', NULL),
    ('Clothing', NULL),
    ('Laptops', 1),
    ('Smartphones', 1),
    ('Men''s Clothing', 2),
    ('Women''s Clothing', 2),
    ('Dresses', 6),
    ('T-Shirts', 5),
    ('Accessories', NULL),
    ('Bags', 9);

INSERT INTO Product (productName, price, Description, Brand, Quantity, categoryID)
VALUES
    ('Smartphone A', 599.99, 'High-end smartphone with advanced features', 'Brand A', 50, 4),
    ('Laptop X', 1299.99, 'Powerful laptop with great performance', 'Brand B', 30, 3),
    ('Dress Z', 79.99, 'Elegant evening dress for special occasions', 'Brand C', 20, 7),
    ('T-Shirt M', 29.99, 'Comfortable cotton t-shirt for everyday wear', 'Brand D', 100, 8),
    ('Bag B', 149.99, 'Stylish leather backpack for travel and work', 'Brand E', 40, 10),
    ('Smartphone B', 699.99, 'Premium smartphone with dual cameras', 'Brand A', 30, 4),
    ('Laptop Y', 899.99, 'Thin and lightweight laptop with long battery life', 'Brand B', 25, 3),
    ('Dress X', 59.99, 'Casual dress perfect for summer outings', 'Brand C', 50, 7),
    ('T-Shirt N', 19.99, 'Basic t-shirt available in multiple colors', 'Brand D', 150, 8),
    ('Bag A', 99.99, 'Functional and durable backpack for daily use', 'Brand E', 60, 10);


INSERT INTO Image (imageID, productID, imageURL)
VALUES
    (1, 1, 'https://example.com/images/smartphone_a.jpg'),
    (2, 2, 'https://example.com/images/laptop_x.jpg'),
    (3, 3, 'https://example.com/images/dress_z.jpg'),
    (4, 4, 'https://example.com/images/tshirt_m.jpg'),
    (5, 5, 'https://example.com/images/bag_b.jpg'),
    (6, 6, 'https://example.com/images/smartphone_b.jpg'),
    (7, 7, 'https://example.com/images/laptop_y.jpg'),
    (8, 8, 'https://example.com/images/dress_x.jpg'),
    (9, 9, 'https://example.com/images/tshirt_n.jpg'),
    (10, 10, 'https://example.com/images/bag_a.jpg');

DELETE FROM Image WHERE imageID IN (5, 6, 9, 3);

INSERT INTO User (name, username, password, emailID, dateOfBirth, phoneNumber, userType)
VALUES
    ('John Doe', 'johndoe', 'password123', 'john.doe@example.com', '1990-05-15', '+1234567890', 'Shopper'),
    ('Jane Smith', 'janesmith', 'password456', 'jane.smith@example.com', '1985-08-20', '+1987654321', 'Administrator'),
    ('Michael Johnson', 'michaelj', 'pass789', 'michael.johnson@example.com', '1987-10-10', '+1654321890', 'Shopper'),
    ('Emily Brown', 'embrown', 'pass1a2b', 'emily.brown@example.com', '1992-04-25', '+1234567890', 'Shopper'),
    ('David Miller', 'dmiller', 'dm1234', 'david.miller@example.com', '1995-12-01', '+1987654321', 'Shopper'),
    ('Sarah Wilson', 'swilson', 'swilson567', 'sarah.wilson@example.com', '1988-07-18', '+1654321890', 'Shopper'),
    ('Chris Lee', 'chrisl', 'chris456', 'chris.lee@example.com', '1993-09-30', '+1234567890', 'Shopper'),
    ('Anna Taylor', 'ataylor', 'anna789', 'anna.taylor@example.com', '1991-02-12', '+1987654321', 'Shopper'),
    ('Kevin Davis', 'kdavis', 'kd1234', 'kevin.davis@example.com', '1989-11-05', '+1654321890', 'Shopper'),
    ('Rachel Clark', 'rclark', 'rachelc1', 'rachel.clark@example.com', '1994-06-28', '+1234567890', 'Shopper');


INSERT INTO ShippingAddress (userID, address, city, state, country, zipCode)
VALUES
    (1, '123 Main St', 'Anytown', 'CA', 'USA', 12345),
    (2, '456 Elm St', 'Othertown', 'NY', 'USA', 54321),
    (3, '789 Maple Ave', 'Anycity', 'TX', 'USA', 67890),
    (4, '321 Oak Dr', 'Sometown', 'FL', 'USA', 98765),
    (5, '654 Pine Ln', 'Cityville', 'IL', 'USA', 13579),
    (6, '987 Cedar Rd', 'Newtown', 'GA', 'USA', 24680),
    (7, '654 Birch Blvd', 'Somecity', 'WA', 'USA', 97531),
    (8, '321 Walnut St', 'Anothercity', 'MA', 'USA', 86420),
    (9, '987 Cherry Ave', 'Townsville', 'OR', 'USA', 35791),
    (10, '456 Spruce Dr', 'Smalltown', 'MI', 'USA', 80246);

INSERT INTO Orders (userID, shippingAddressID, orderDate, totalAmount)
VALUES
    (1, 1, '2024-07-01', 699.99),
    (2, 2, '2024-07-02', 1299.99),
    (3, 3, '2024-07-03', 79.99),
    (4, 4, '2024-07-04', 29.99),
    (5, 5, '2024-07-05', 149.99),
    (6, 6, '2024-07-06', 699.99),
    (7, 7, '2024-07-07', 899.99),
    (8, 8, '2024-07-08', 59.99),
    (9, 9, '2024-07-09', 19.99),
    (10, 10, '2024-07-10', 99.99);

INSERT INTO orderItem (productID, orderID, quantity, itemStatus)
VALUES
    (1, 1, 1, 'Shipped'),
    (2, 1, 2, 'Shipped'),
    (3, 2, 1, 'Shipped'),
    (4, 2, 1, 'Shipped'),
    (5, 2, 3, 'Shipped'),
    (6, 3, 2, 'Placed'),
    (7, 4, 1, 'Shipped'),
    (8, 5, 1, 'Shipped'),
    (9, 6, 2, 'Placed'),
    (10, 7, 1, 'Shipped'),
    (1, 8, 1, 'Shipped'),
    (2, 8, 1, 'Shipped'),
    (3, 8, 2, 'Shipped'),
    (4, 9, 1, 'Shipped'),
    (5, 9, 1, 'Shipped'),
    (6, 9, 3, 'Placed'),
    (7, 10, 1, 'Shipped'),
    (8, 10, 1, 'Shipped'),
    (9, 10, 1, 'Shipped'),
    (10, 10, 1, 'Shipped');

