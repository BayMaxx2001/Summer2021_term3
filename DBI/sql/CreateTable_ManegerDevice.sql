Create database ManegerDevice

use ManegerDevice
Create table Product(
	model int not null primary key,
	maker nvarchar(20) not null,
	[type] nvarchar(20) not null
);

Create table PC(
	model int not null foreign key references Product(model),
	speed float not null,
	ram int not null,
	hd int not null, 
	price int not null
);

Create table Laptop(
	model int not null foreign key references Product(model),
	speed float not null,
	ram int not null,
	hd int not null, 
	screen float not null,
	price int not null
);
Create table Printer(
	model int not null foreign key references Product(model),
	color bit not null,
	[type] nvarchar(20) not null,
	price int not null
);
alter table Printer
alter column [type] nvarchar(20) not null
-- INSERT PRODUCT

Insert into dbo.Product(maker, model, [type]) values ('A',1001,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('A',1002,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('A',1003,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('A',2004,'laptop') 
Insert into dbo.Product(maker, model, [type]) values ('A',2005,'laptop') 
Insert into dbo.Product(maker, model, [type]) values ('A',2006,'laptop') 
Insert into dbo.Product(maker, model, [type]) values ('B',1004,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('B',1005,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('B',1006,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('B',2007,'laptop') 
Insert into dbo.Product(maker, model, [type]) values ('C',1007,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('D',1008,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('D',1009,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('D',1010,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('D',3004,'printer') 
Insert into dbo.Product(maker, model, [type]) values ('D',3005,'printer')
Insert into dbo.Product(maker, model, [type]) values ('D',3003,'printer') 
Insert into dbo.Product(maker, model, [type]) values ('E',1011,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('E',1021,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('E',1031,'pc') 
Insert into dbo.Product(maker, model, [type]) values ('E',2001,'laptop') 
Insert into dbo.Product(maker, model, [type]) values ('E',2002,'laptop')
Insert into dbo.Product(maker, model, [type]) values ('E',2003,'laptop') 

-- INSERT PC
Insert into dbo.PC(model, speed, ram, hd, price) values (1001, 2.66, 1024,250,2114) 
Insert into dbo.PC(model, speed, ram, hd, price) values (1002, 2.10, 512, 250,995) 
Insert into dbo.PC(model, speed, ram, hd, price) values (1003, 1.42, 512, 80, 478) 
Insert into dbo.PC(model, speed, ram, hd, price) values (1004, 2.80, 1024,250,649) 
Insert into dbo.PC(model, speed, ram, hd, price) values (1005, 3.20, 512, 250,630) 
Insert into dbo.PC(model, speed, ram, hd, price) values (1006, 3.20, 1024,320,1049) 

-- INSERT LAPTOP
Insert into dbo.Laptop(model, speed, ram, hd, screen, price) 
values (2001, 2.00, 2048,240,20.1,3673)
Insert into dbo.Laptop(model, speed, ram, hd, screen, price) 
values (2002, 1.73, 1024,80 , 17.0, 949)
Insert into dbo.Laptop(model, speed, ram, hd, screen, price) 
values (2003, 1.80, 512,60 ,15.4, 549)
Insert into dbo.Laptop(model, speed, ram, hd, screen, price) 
values (2004, 2.00, 512,60 ,13.3, 1150)
Insert into dbo.Laptop(model, speed, ram, hd, screen, price) 
values (2005, 2.16, 1024,120,17.0, 2500)

-- INSERT PRINTER
Insert into dbo.Printer(model, [color], [type], price) values (3003,'true','laser',899) 
Insert into dbo.Printer(model, [color], [type], price) values (3004,'true','ink-jet',120) 
Insert into dbo.Printer(model, [color], [type], price) values (3005,'false','laser',120) 
