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
			VALUES ("234589526","Admin","Admin","Home","admin@root.com","toor25",1);
INSERT INTO users (taxno,lastname,firstname,address,email,userpassword,isadmin)   
			VALUES ("987456123","CarRepair","Admin","CarRepairWebApp","admin@cat.com","repair",1);
INSERT INTO users (taxno,lastname,firstname,address,email,userpassword,isadmin)   
			VALUES ("823479325","Papadopoulos","Mpampis","Evelpidon 23, Athina","papado@yahoo.com","pas123",0);
INSERT INTO users (taxno,lastname,firstname,address,email,userpassword,isadmin)   
			VALUES ("546783926","Xatzinikolaou","Afroksilanthi","Patision 47, Athina","xatzi@yahoo.com","xat123",0);
INSERT INTO users (taxno,lastname,firstname,address,email,userpassword,isadmin)   
			VALUES ("123456789","EasyUser","Rember","Leoforon Athinon 223, Athina","easy@yahoo.com","esy123",0);
INSERT INTO users (taxno,lastname,firstname,address,email,userpassword,isadmin)   
			VALUES ("321987654","Georgakopoulos","Antonis","Kifisias 145, Athina","geo@yahoo.com","geo123",0);

INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Alagi ladion",3,'2017-11-12 15:00:00','ToDo','Small',23.45,"TYX-2345");
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Alagi zantas",4,'2017-10-26 17:00:00','ToDo','Small',32.50,"TKX-2345");
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Spasimo dexiou fterou",3,'2017-10-25 15:00:00','ToDo','Big',65.00,"TYX-2345");
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Alagi takakia",3,'2017-11-12 15:15:00','ToDo','Small',57.45,"ITK-1236");
            
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Alagi diskoferno",4,'2017-10-26 18:00:00','ToDo','Small',23.45,"TKX-2345");
            
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Plisimo",4,'2017-10-26 16:30:00','Done','Small',10.00,"YXK-3356");
            
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Spasmenos katherftis kai alagh asfalion",5,'2017-10-25 15:00:00','Done','Small',45.00,"ABC-1234");
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Stauros Isostathmistis",5,'2017-6-25 15:00:00','Done','Big',145.00,"ABC-1234");  
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Spasmenos katherftis kai alagh asfalion",5,'2017-10-25 15:00:00','Done','Small',45.00,"ABC-1234");
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Hlekrika parathisou",5,'2017-11-27 15:00:00','InProgress','Big',45.00,"ABC-1234");
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Alagh Zantas",5,'2017-11-25 15:00:00','Done','Small',25.00,"XXK-3355");  
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Alagh Zantas",5,'2017-10-25 15:00:00','InProgress','Small',25.00,"KTI-7866");
INSERT INTO repairs (description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber)   
			VALUES ("Hlekrika parathisou",6,'2017-11-27 15:00:00','InProgress','Big',45.00,"YKI-2356");  
 
          

