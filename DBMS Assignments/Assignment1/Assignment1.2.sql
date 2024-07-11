-- Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
SELECT p.productID, p.productName, c.Title, p.price FROM Product AS p
LEFT JOIN category AS c ON p.categoryID = c.categoryID WHERE p.Quantity > 0;

-- Display the list of products which don't have any images
SELECT P.productID, P.productName FROM Product AS P
LEFT JOIN Image AS I ON P.productID = I.productID WHERE I.productID IS NULL ORDER BY P.productID;

/* Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. 
   (If Category is top category then Parent Category Title column should display “Top Category” as value.) */
SELECT c1.categoryID, c1.Title, COALESCE(c2.Title, "Top Category", NULL) AS Parent_Category_Title FROM category AS c1
LEFT JOIN category AS c2 ON c1.ParentCategoryID = c2.categoryID ORDER BY COALESCE(c2.Title, 0), c1.Title;

-- Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
SELECT c1.categoryID, c1.Title, COALESCE(c2.Title, "Top Category") AS Parent_Category_Title FROM category AS c1
LEFT JOIN category AS c2 ON c1.ParentCategoryID = c2.categoryID
WHERE 0 = 
(
	SELECT COUNT(*) FROM category AS c3
    WHERE c1.categoryID = c3.ParentCategoryID
)
ORDER BY COALESCE(c2.Title, 0), c1.Title;

-- Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT p.productID, p.productName, p.price, p.Description, c.Title FROM product AS p
LEFT JOIN category AS c ON p.categoryID = c.categoryID 
WHERE c.Title = "T-Shirts" ORDER BY p.productName;

-- Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT productID, productName, price, Description FROM product
WHERE Quantity <= 50;