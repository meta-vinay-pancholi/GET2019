/*
Insert sample data in StoreFront tables by using SQL files.
*/

INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(1,'Cloth',"Clothing for men and women",NULL);
INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(2,'Electronic',"Electronic aplliances for your home and office",NULL);
INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(3,'Home',"Design your home with us",NULL);
INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(4,'T-shirt',"T-Shirt for men and women",1);
INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(5,'Shirt',"Shirt from popular brands",1);
INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(6,'TV',"All type of television",2);
INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(7,'Headphones',"Headphones for you",2);
INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(8,'Home furnishing',"Furnish your home",3);
INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(9,'Home Decor',"Decor your home",3);
INSERT INTO categories (id,type,desciption,parent_id) 
VALUES(10,'Bluetooth headphones',"Decor your home",7);

select 
    *
from
    categories;



INSERT INTO PRODUCT
(
Name,
Id,
Color,
Price,
Quantity
)
VALUES
("Reebok" , 1 , "RED" , "2000" , "200"),
("Puma" , 2 , "GREEN" , "3000" , "240"),
("RoadStar",3 , "BLACK" , "4000" , "210"),
("Arrow" , 4 , "WHITE" , "5000" , "100"),
("SonyTv" , 5 , "black" , "500" , "10"),
("SamsungTv" , 6 , "Blue" , "500" , "10"),
("Jbl" , 7 , "venom" , "500" , "10"),
("Boss" , 8 , "iron" , "500" , "10"),
("DoorMats" ,9 ,  "gold" , "500" , "10"),
("WallClock" , 10 , "silver" , "500" , "10"),
("Pantings" , 11 , "platinum" , "500" , "10"),
("SofaCover" ,12  , "copper" , "500" , "10");

INSERT INTO product_category
(
category_id,
product_id
)
VALUES
(4,1),
(4,2),
(5,3),
(5,4),
(6,5),
(6,6),
(7,7),
(7,8),
(8,9),
(8,10),
(9,11),
(9,12),
(2,13);

INSERT INTO images
(
product_id,
name
)
VALUES
(1,"Rivak.png"),
(1,"vinay.png"),
(2,"vinod.png"),
(3,"surendra.png"),
(2,"Rakesh.png"),
(4,"Raju.png"),
(3,"Ram.png"),
(5,"pankaj.png"),
(3,"jugal.png"),
(3,"upendra.png"),
(6,"bhupendra.png"),
(1,"ss.png"),
(7,"Rivak.png"),
(1,"vinay.png"),
(8,"vinod.png"),
(3,"surendra.png"),
(9,"Rakesh.png"),
(10,"Raju.png"),
(3,"Ram.png"),
(10,"pankaj.png"),
(9,"jugal.png"),
(5,"upendra.png"),
(11,"bhupendra.png"),
(11,"ss.png");

INSERT INTO user (name, email, password,phone) 
VALUES ('VINAY',"vinay.pancholi@gmail.com","123456",941493997);

INSERT INTO user (name, email, password,phone) 
VALUES ('RIVAK',"rivak.shah@gmail.com","123456",774892758);

INSERT INTO user (name, email, password,phone) 
VALUES ('AJAY',"ajay11@gmail.com","123456",941499997);

INSERT INTO user (name, email, password,phone) 
VALUES ('VINOD',"vinod112@gmail.com","123456",941493944);


INSERT INTO user (name, email, password,phone) 
VALUES ('VIKAS',"vikas090@gmail.com","123496",941493397);

INSERT INTO address
(
city,
pin,
state,
user_id
)
VALUES
("jaipur" , 23212, "Raj" ,1),
("Udaipur" , 23211, "Raj" ,1),
("Ajmer" , 23221, "Raj" ,2),
("Dungarpur" , 232112 ,"Raj" ,2),
("pali" , 232112 ,"UP" ,4),
("patel" , 212112 ,"KUX" ,5),
("Ahmedabad" , 233321 , "GUJ" ,3);

INSERT INTO orders (
user_id , order_date) VALUES (1,2019-01-05),(2,2019-02-15),(3,2019-08-25),(4 ,2019-04-11),(5,2019-03-22);

ALTER TABLE orders
ADD COLUMN order_date DATETIME;

ALTER TABLE orders
ADD COLUMN status CHAR;


select 
    *
from
    orders;
INSERT INTO orderItem(
order_id,product_id
) VALUES(1,2),(1,3),(1,4),(2,5),(2,12),(2,11);

ALTER TABLE orderItem
ADD COLUMN quantity INT;

ALTER TABLE orderItem
ADD COLUMN Total INT;

select 
    *
from
    orders;
select 
    *
from
    orderItem;

UPDATE  orderItem set quantity = 11, Total = 3001 Where Order_Id = 1 and product_id = 3;
UPDATE  orderItem set quantity = 12, Total = 3002 Where Order_Id = 1 and product_id = 4;
UPDATE  orderItem set quantity = 13, Total = 3003 Where Order_Id = 2 and product_id = 5;
UPDATE  orderItem set quantity = 14, Total = 3004 Where Order_Id = 2 and product_id = 12;
UPDATE  orderItem set quantity = 7,  Total = 3099 Where Order_Id = 2 and product_id = 11;


DELETE FROM orderItem WHERE Order_Id = 1 and product_id = 2;

INSERT INTO orderItem(
order_id,product_id,quantity,total
) VALUES(3,4,40,4000),(4,12,50,50000);

INSERT INTO orderItem(
order_id,product_id,quantity,total
) VALUES(3,5,40,4000),(3,6,50,500);


INSERT INTO orderItem(
order_id,product_id,quantity,total
) VALUES(5,11,5,4000),(5,3,6,500);




