/*
Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
*/
DELIMITER $$
CREATE FUNCTION Calculate_orders_Between_Date_And_Year(month INT, year INT)
    RETURNS INT  
    DETERMINISTIC
    BEGIN
        DECLARE number_of_orders int;
        SELECT
        COUNT(i.product_id) INTO  number_of_orders FROM 
        orderitem I
        INNER JOIN
        orders O   
        ON
        DATE_FORMAT(o.Order_date, '%Y') = year AND 
        DATE_FORMAT(o.Order_date, '%m') = month AND
        o.Order_Id = i.Order_Id;
        RETURN (number_of_orders);
    END$$
SELECT Calculate_orders_Between_Date_And_Year(8, 2019) As Total_Order;

/*
Create a function to return month in a year having maximum orders. Year will be input parameter.
*/
DELIMITER $$
CREATE FUNCTION find_Month_have_max_Order(year INT)
    RETURNS INT  
    DETERMINISTIC
    BEGIN
        DECLARE month int;
        SELECT   EXTRACT(MONTH FROM O.Order_date) INTO month
        FROM
        ORDERS O
        LEFT JOIN
        orderItem I ON DATE_FORMAT(O.Order_date, '%Y') = year AND i.order_Id = o.order_Id
        GROUP BY EXTRACT(MONTH FROM O.Order_date)  DESC limit 1;
        RETURN  (month);
    END$$


SELECT find_Month_have_max_Order(2019) AS Max_Oder_Month;

/*
Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
*/
DELIMITER $$
CREATE PROCEDURE average_Sell_Of_Each_Product(year int(20) , month int(20))
  BEGIN
     SELECT
     COUNT(i.Product_Id) As TotalProduct,  COUNT(i.Product_Id) div P.Quntity Avg, i.Product_Id As Product_Id, P.Quantity, DATE_FORMAT(O.Order_date, '%Y') As Year , DATE_FORMAT(O.Order_date, '%M') As Month_Name FROM 
     Orders O
     INNER JOIN
     orderitem I
     ON
     DATE_FORMAT(o.Order_date, '%Y') = year AND 
     DATE_FORMAT(o.Order_date, '%m') = month AND
     o.Order_Id = i.Order_Id
     Right JOIN 
     PRODUCT P
     ON 
     i.Product_Id = p.id 
     GROUP BY i.Product_Id;
  END $$
CALL average_Sell_Of_Each_Product(2019, 8);

/*
Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date.
If start date is greater than end date take first date of month as start date.
*/
DELIMITER $$
CREATE PROCEDURE orders_Of_The_Given_Period(start_date DATE, end_date DATE)
   BEGIN
       IF start_date > end_date
           THEN SET start_date = DATE_ADD(DATE_ADD(LAST_DAY(end_date),INTERVAL 1 DAY),INTERVAL - 1 MONTH);
       END IF;
       SELECT p.name, p.price, i.Total, i.status, o.order_date
       FROM product p, orderitem i , orders o
       WHERE
           p.id = i.product_id AND
           o.order_date BETWEEN start_date AND end_date
       ORDER BY o.order_date DESC;
   END $$

   DROP PROCEDURE orders_Of_The_Given_Period;

call  orders_Of_The_Given_Period('2019-08-01', '2019-08-10');

# timestamp often called in where clause
CREATE INDEX by_order_date ON amazon.orders (order_date);
ALTER TABLE orders ADD INDEX  by_order_id(order_id);

# quantity must be checked before any order
CREATE INDEX by_quantity ON product(quantity);
ALTER TABLE product ADD INDEX  by_pro_id(id)
select * from product
# category_name is checked whenever we required category wise data
CREATE INDEX by_category_name ON categories(type);
ALTER TABLE categories ADD INDEX  by_category_Id(id)