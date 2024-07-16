INSERT INTO CategoryHierarchy (AncestorCategoryID, DescendantCategoryID)
WITH RECURSIVE Hierarchy AS (
	SELECT categoryID AS Ancestor, categoryID AS Descendant
    FROM category
    UNION
    SELECT h.Ancestor, c.categoryID FROM Hierarchy AS h
    INNER JOIN category AS c ON h.Descendant = c.ParentCategoryID
)
SELECT Ancestor, Descendant FROM Hierarchy;


SELECT c1.Title AS ParentCategory, c2.Title AS ChildCategory FROM CategoryHierarchy AS ch
INNER JOIN Category AS c1 ON ch.AncestorCategoryID = c1.categoryID
INNER JOIN Category AS c2 ON ch.DescendantCategoryID = c2.categoryID;