
-- Display the list of products (Id, Title, Count of Categories) which fall in more than one Category.
SELECT p.ProductID, p.productName, COUNT(p.ProductID) FROM Product AS p
INNER JOIN CategoryHierarchy AS ch ON p.categoryID = ch.DescendantCategoryID
GROUP BY p.ProductID, p.productName HAVING COUNT(p.ProductID) > 1;

-- Display Count of products as per below price range:
SELECT '0 - 100' AS PriceRange, COUNT(productID) AS ProductCount
FROM Product
WHERE price BETWEEN 0 AND 100
UNION
SELECT '101 - 500' AS PriceRange, COUNT(productID) AS ProductCount
FROM Product
WHERE price BETWEEN 101 AND 500
UNION
SELECT 'above 500' AS PriceRange, COUNT(productID) AS ProductCount
FROM Product
WHERE price BETWEEN 501 AND 1000;

-- Display the Categories along with number of products under each category.
SELECT c.categoryID, c.Title, COUNT(c.categoryID) FROM category AS c
INNER JOIN CategoryHierarchy AS ch ON c.categoryID = ch.AncestorCategoryID
INNER JOIN Product AS p ON p.categoryID = ch.DescendantCategoryID
GROUP BY c.categoryID, c.Title;

