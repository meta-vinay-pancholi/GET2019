/*
Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
*/
SELECT 
    p.Id As Product_ID,
    p.Name AS Product_Title,
    p.Price AS Product_Price,
    p.quantity,
    c.Type As Category_Type
FROM
    product p,
    categories c,
    product_category pc
WHERE
    p.Id = pc.product_id AND c.Id = pc.product_id
ORDER BY p.Date DESC;

/*
Display the list of products which don't have any images.
*/

SELECT
    p1.name
FROM
    product p1
WHERE
    NOT EXISTS( SELECT 
        *
    FROM
        images i
    WHERE
        p1.id = i.product_id);
        
/*
Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)
*/
SELECT 
    c.id,
    c.type AS LeafNode,
    IFNULL((SELECT
                type
            FROM
                category
            WHERE
                id = c.parent_id),
            'TOP')
FROM
    categories c
WHERE
    NOT EXISTS( SELECT 
        *
    FROM
        categories c1
    WHERE
        c.id = c1.parent_id);
        
/*
Display the list of Products whose Quantity on hand (Inventory) is under 50.
*/
SELECT 
    *
FROM
    product
WHERE
    quantity <= 50;
    
/*
Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
*/
    
SELECT 
    p.name, p.price, p.quantity
FROM
    product p,
    product_category pc
WHERE
    pc.category_id = (SELECT 
        id
    FROM
        categories
    WHERE
        type = 'shirt') AND pc.product_id = p.id;


              