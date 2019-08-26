/*
Display Shopper’s information along with number of orders he/she placed during last 30 days.
*/
SELECT 
    user.*, COUNT(orders.order_id)
from
    orders,
    user
WHERE
    (DATEDIFF(now(), orders.order_date) < 30 AND user.id = orders.user_id)
GROUP BY orders.user_id;

/*
Display the top 10 Shoppers who generated maximum number of revenue in last 30 days
*/
select * from orderitem;
select * from orders;

SELECT 
    user.*, SUM(orderitem.total) AS MAX_REVENUE
from
    orders,
    user,
    orderitem
WHERE
    DATEDIFF(now(), orders.order_date) < 30 AND orderitem.order_id = orders.order_id AND user.id = orders.user_id GROUP BY orders.user_id DESC limit 10;
    
/*
    Display top 20 Products which are ordered most in last 60 days along with numbers.
*/
SELECT 
    p.Name, SUM(oi.quantity) AS No_Of_Units_Ordered 
FROM
    product p
        LEFT JOIN
    orderitem oi ON p.id = oi.product_id
        LEFT JOIN
    orders o ON oi.order_id = o.order_id
WHERE
    DATEDIFF(now(),
        o.order_date) < 60
GROUP BY p.id
ORDER BY Revenue DESC
LIMIT 20;

/*
Given a category search keyword, display all the Products present in this category/categories
*/
SELECT product.* 
FROM product , product_category,categories
Where product.id = product_category.product_id AND categories.type = 't-shirt' AND categories.id = product_category.category_id;

/*
Mark the products as Inactive which are not ordered in last 90 days.
*/
SELECT 
   *
FROM
   PRODUCT
WHERE
   ID NOT IN (SELECT DISTINCT
       PRODUCT_ID
   FROM
       ORDERITEM I
           LEFT JOIN
       ORDERS O ON O.ORDER_ID = I.ORDER_ID AND DATEDIFF(now(), O.order_Date) < 90);

/*
Display top 10 Items which were cancelled most.
*/
SELECT 
    p.id, p.Name, count(p.id) AS No_Of_Cancellations
FROM
    product p
        LEFT JOIN
    orderitem i ON p.id = i.product_id
WHERE
    status = 'C'
GROUP BY p.id
ORDER BY No_Of_Cancellations DESC;
/*
Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
*/
SELECT 
    SUM(oi.quantity) AS No_Of_Units_Ordered,
    SUM(oi.total) AS MAX_REVENUE,
    MONTH(o.order_date) AS Month
FROM
    product p,
    orderitem oi,
    orders o
WHERE
    DATEDIFF(now(),
        o.order_date) < 180 AND oi.order_id = o.order_id And p.id = oi.product_id
GROUP BY MONTH(o.order_date) ;




