
-- Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.userID, u.name, COUNT(u.userID) AS NumberOFOrders FROM User AS u
INNER JOIN Orders AS o ON u.userID = o.userID
WHERE ABS(DATEDIFF(CURDATE(), o.orderDate)) >= 30
GROUP BY u.userID;

-- Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.userID, u.name, SUM(o.totalAmount) AS Total_Revenue FROM User AS u
INNER JOIN Orders AS o ON u.userID = o.userID
WHERE ABS(DATEDIFF(CURDATE(), o.orderDate)) >= 30
GROUP BY u.userID
ORDER BY SUM(o.totalAmount) DESC LIMIT 10;

-- Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.ProductID, p.productName, COUNT(t.itemID) AS ProductCount FROM Product AS p
INNER JOIN orderItem AS t ON p.ProductID = t.productID
INNER JOIN Orders AS o ON t.orderID = o.orderID
WHERE ABS(DATEDIFF(CURDATE(), o.orderDate)) >= 60
GROUP BY p.ProductID
ORDER BY COUNT(t.itemID) DESC LIMIT 20;

-- Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT MONTH(orderDate) AS month, SUM(totalAmount) FROM Orders
WHERE orderDate < (CURDATE() - INTERVAL 6 MONTH)
GROUP BY month;

-- Mark the products as Inactive which are not ordered in last 90 days.
UPDATE Product
SET productStatus = 'InActive'
WHERE ProductID NOT IN
(
	SELECT t.productID FROM orderItem AS t
	INNER JOIN Orders AS o ON o.orderID = t.orderID
	WHERE ABS(DATEDIFF(CURDATE(), o.orderDate)) <= 90
	GROUP BY t.ProductID
);

-- Given a category search keyword, display all the Products present in this category/categories. 
SELECT p.productID, p.productName FROM Category AS c
INNER JOIN CategoryHierarchy AS ch ON c.categoryID = ch.AncestorCategoryID
INNER JOIN Product AS p ON p.categoryID = ch.DescendantCategoryID
WHERE c.Title = "Electronic";

-- Display top 10 Items which were cancelled most.
SELECT p.productID, p.productName, COUNT(t.itemID) AS CancelledCount FROM Product AS p
INNER JOIN orderItem AS t ON p.productID = t.productID
WHERE t.itemStatus = "Cancelled"
GROUP BY p.productID, p.productName
ORDER BY COUNT(t.itemID) DESC LIMIT 10;