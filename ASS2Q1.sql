SHOW DATABASES;
USE amazon;
/*
Create all tables of eCommerce Application: StoreFront covered in Session 1 Assignments.
(Write all CREATE commands in a SQL file and run that SQL File).

*/
CREATE TABLE product(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name CHAR(30),
    color CHAR(20),
    price FLOAT,
    quantity INT,
    date DATETIME
);

CREATE TABLE images(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    FOREIGN KEY (product_id)
        REFERENCES product (id),
    name VARCHAR(200)
);

CREATE TABLE user(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name CHAR(30),
    email VARCHAR(30),
    password VARCHAR(30),
    phone INT(10)
);

CREATE TABLE address(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    city CHAR(30),
    pin INT(6),
    state CHAR(30),
    user_id INT,
    FOREIGN KEY (user_id)
        REFERENCES user (id)
);

CREATE TABLE categories(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type CHAR(100),
    desciption VARCHAR(200),
    parent_id INT
);

CREATE TABLE product_category(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    category_id INT,
    FOREIGN KEY (product_id)
        REFERENCES product (id),
    FOREIGN KEY (category_id)
        REFERENCES category (id)
);

CREATE TABLE admin(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT,
    FOREIGN KEY (user_id)
        REFERENCES user (id)
);

CREATE TABLE orders(
    order_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    quantity INT,
    FOREIGN KEY (user_id)
        REFERENCES user (id)
);

CREATE TABLE orderItem(
    order_id INT,
    product_id INT,
    FOREIGN KEY (order_id)
        REFERENCES orders (order_id),
    FOREIGN KEY (product_id)
        REFERENCES product (id)
);

/*
Write a command to display all the table names present in StoreFront.
*/
SHOW tables;

/*
Write a command to remove Product table of the StoreFront database.
*/
DROP TABLE product;

/*
Create the Product table again.
*/
CREATE TABLE product(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name CHAR(30),
    color CHAR(20),
    price FLOAT,
    quantity INT,
    date DATETIME
);