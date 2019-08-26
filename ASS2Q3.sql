/*
Display Recent 50 Orders placed (Id, Order Date, Order Total).
*/
SELECT 
    o.Order_Id,
    o.Order_date,
    (SELECT 
        sum(Total)
    FROM
        orderItem
    WHERE
        Order_Id = o.Order_Id
    GROUP BY order_id) As Total_Price
FROM
    Orders o
ORDER BY o.order_date DESC
LIMIT 2;

/*
Display 10 most expensive Orders
*/
SELECT 
    order_id,
    (SELECT 
        sum(Total)
    FROM
        orderItem
    WHERE
        Order_Id = o.Order_Id) As Total_Price
FROM
    orderItem o
GROUP BY order_id
ORDER BY Total_Price DESC
LIMIT 3;

/*
Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
*/
SELECT 
    o1.Order_Id, o1.Product_Id, o.Order_date, o1.Total
FROM
    ORDERS o,
    orderItem o1
WHERE
    o.Order_Id = o1.Order_Id AND o1.Total BETWEEN 3002 AND 3004; 

/*
Display list of shoppers which haven't ordered anything since last month
*/
SELECT 
    *
FROM
    user
WHERE
    ID NOT IN ((SELECT 
        user_id
    FROM
        orders
    WHERE
        DATEDIFF(now(), order_date) < 30
    GROUP BY user_id));

/*
Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
*/
SELECT 
    U.ID, U.name, U.Email, U.phone
FROM
    orders,
    User U
WHERE
    DATEDIFF(now(), orders.order_date) > 10 AND orders.Status = 'P' AND U.Id = orders.user_id;
           
/*
Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
*/
SELECT
    *
FROM
    product
WHERE
    id IN (SELECT 
        product_id
    FROM
        orderItem
    WHERE
        order_id = 2);
        
/*
Display list of shopper along with orders placed by them in last 15 days. 
*/
SELECT 
    user_id, user.name, user.phone, COUNT(orders.order_id)
FROM
    orders,
    user
WHERE
    DATEDIFF(now(), orders.order_date) > 15 AND user.id = orders.user_id
GROUP BY user_id  ;
   
   

