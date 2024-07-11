-- Display Recent 5 Orders placed (Id, Order Date, Order Total).
SELECT O.orderID, O.orderDate, O.totalAmount FROM orders AS O
ORDER BY O.orderDate DESC
LIMIT 5;

-- Display 5 most expensive Orders.
SELECT O.orderID, O.orderDate, O.totalAmount FROM orders AS O
ORDER BY O.totalAmount DESC
LIMIT 5;

-- Display all the Orders which are placed more than 5 days old and one or more items from those orders are still not shipped.
SELECT DISTINCT O.orderID, O.orderDate, O.totalAmount FROM orders AS O
LEFT JOIN orderItem AS T ON O.orderID = T.orderID
WHERE ABS(DATEDIFF(O.orderDate, CURDATE())) >= 5
AND T.itemStatus <> "Shipped";

-- Display list of shoppers which haven't ordered anything since last month.
SELECT userID, name FROM user
WHERE userID NOT IN
(
	SELECT DISTINCT O.userID FROM orders AS O
	WHERE ABS(DATEDIFF(O.orderDate, CURDATE())) <= 5
);

-- Display list of shopper along with orders placed by them in last 15 days.
SELECT u.userID, u.username, O.orderID, O.orderDate FROM user AS u
INNER JOIN orders AS O ON u.userID = O.userID 
WHERE ABS(DATEDIFF(O.orderDate, CURDATE())) <= 5 ORDER BY u.userID;

-- Display list of order items which are in “shipped” state for particular Order Id 
SELECT I.itemID, I.quantity FROM orderItem AS I
WHERE I.orderID = 9 AND I.itemStatus = "Shipped";

-- Display list of order items along with order placed date which fall between Rs 100 to Rs 700 price.
SELECT I.itemID, p.productName, p.productID, p.price, O.orderDate, O.orderID
FROM orderItem AS I
INNER JOIN orders AS O ON I.orderID = O.orderID
INNER JOIN Product AS p ON I.productID = p.productID
WHERE p.price BETWEEN 100.00 AND 700.00;