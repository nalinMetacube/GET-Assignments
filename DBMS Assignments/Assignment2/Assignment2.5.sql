/*
	Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
    with latest ordered items should be displayed first for last 60 days.
*/
CREATE VIEW latest_ordered_items AS
SELECT P.productID, P.productName, P.price, U.name, u.emailID, O.orderDate, T.itemStatus FROM orderItem AS T
INNER JOIN Orders AS O ON T.orderID = O.orderID
INNER JOIN User AS U ON U.userID = O.userID
INNER JOIN Product AS P ON P.productID = T.productID
WHERE ABS(DATEDIFF(CURDATE(), O.orderDate)) >= 60
ORDER BY O.orderDate DESC;

SELECT * FROM latest_ordered_items;

-- Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT productName, price FROM latest_ordered_items
WHERE itemStatus = 'Shipped';

-- Use the above view to display the top 5 most selling products.
SELECT productID, productName, COUNT(productID) FROM latest_ordered_items
GROUP BY productID, productName
ORDER BY COUNT(productID) DESC LIMIT 5;