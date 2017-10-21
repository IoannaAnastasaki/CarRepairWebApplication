CREATE DATABASE vehicleservice CHARACTER SET utf8;
SHOW DATABASES;
USE vehicleservice;
CREATE TABLE users (userid BIGINT AUTO_INCREMENT NOT NULL,taxno INT(9) UNIQUE NOT NULL, lastname NVARCHAR(30), firstname NVARCHAR(30),
			address NVARCHAR(30), email NVARCHAR(30) UNIQUE NOT NULL, userpassword NVARCHAR(30) NOT NULL, isadmin BIT, 
            PRIMARY KEY (userid));
CREATE TABLE repairs (repairid BIGINT AUTO_INCREMENT NOT NULL, description NVARCHAR(255), userid BIGINT, dayofrepair DATETIME,
			repairstatus NVARCHAR(30), repairtype NVARCHAR(30), 
            servicecost DOUBLE(10,2), platenumber NVARCHAR(8),
			PRIMARY KEY (repairid),FOREIGN KEY (userid) REFERENCES users(userid));
            
INSERT INTO users (taxno,lastname,firstname,address,email,userpassword,isadmin)   
			VALUES ("234589526","Admin","Admin","Home","admin@root.com","toor",1);
INSERT INTO users (taxno,lastname,firstname,address,email,userpassword,isadmin)   
			VALUES ("823479325","Papadopoulos","Mpampis","Evelpidon 23, Athina","papado@yahoo.com","pa123",0);
INSERT INTO users (taxno,lastname,firstname,address,email,userpassword,isadmin)   
			VALUES ("546783926","Xatzinikolaou","Afroksilanthi","Patision 47, Athina","xatzi@yahoo.com","xa123",0);

INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Alagi ladion",2,'2017-11-26 15:15:00','ToDo','Small',23.45,"TYX-2345");
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Alagi zantas",3,'2017-10-26 17:15:00','ToDo','Small',32.50,"TKX-2345");
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Spasimo dexiou fterou",2,'2017-10-20 16:15:00','ToDo','Big',65.00,"TYX-2345");

