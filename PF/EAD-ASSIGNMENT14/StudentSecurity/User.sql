Drop database User;
CREATE DATABASE User;

USE User;

CREATE TABLE Users (
username VARCHAR(20) NOT NULL,
password VARCHAR(100) NOT NULL,
enabled INT NOT NULL DEFAULT 1,
PRIMARY KEY(username)
);

CREATE TABLE User_Role (
username VARCHAR(20) NOT NULL,
userRole VARCHAR(20) NOT NULL,
FOREIGN KEY(username) REFERENCES Users(username)
);

INSERT INTO Users (username, password) values ("Khushi", "$2a$10$tgijhm1aGbdggVH2Cr1IP.Zm8x3cZ4m1PDA0kc1T1rhBMwHg.ZFda"),
("Yatika", "$2a$10$8tzwCyJnqPpZZpnXMwx.aetXaP969uh4XtimtitYCmDPIWQpZxipK");

INSERT INTO User_Role(username, userRole) 
values("Khushi", "Admin"),
("Khushi", "User"),
("Yatika", "User");

