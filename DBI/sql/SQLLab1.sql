create database ProductDB 

on primary
(
	name = ProductDB,
	filename = 'D:\Study\Term3_SUMMER_21\DBI202\database\ProductDB_dat.mdf',
	size = 10 MB,
	maxsize = 50 MB,
	filegrowth = 2
)
log on
(
	name = DB_Log,
	filename = 'D:\Study\Term3_SUMMER_21\DBI202\database\ProductDB_log.ldf',
	size = 5 MB,
	maxsize = 25 MB,
	filegrowth = 2
)

use ProductDB

create table Products 
(
	ProductId char(5) not null,
	ProductName nvarchar(100) not null ,
	Unit varchar(20),
	Price int,
	Quantity int,
	CreateDate Datetime
)

create table Categories
(
	CategoryId CHAR(5) not null,
	CategoryName nvarchar(50) not null,
	[Description] ntext null
)

Alter table Products
ALTER COLUMN ProductId char(5) not null
Alter table Products
ALTER COLUMN CreateDate Date null

ALTER TABLE Products
ADD PRIMARY KEY (ProductId);

ALTER TABLE Categories
ADD PRIMARY KEY (CategoryId);


ALTER TABLE Products
  ADD CategoryId char(5);


ALTER TABLE Products
ADD CONSTRAINT FK_CategoryId
FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId);


ALTER TABLE Products
DEFAULT current_timestamp FOR CreateDate;

alter table Products
drop COLUMN Unit


insert into Categories values ('1', 'Menu car', 'List car')
insert into Categories values ('2', 'Menu bike', 'List bike')
insert into Categories values ('3', 'Menu plane', 'List plane')

insert into Products values ('1', 'BMW', '1200000', '10','','1')
insert into Products values ('2', 'nike', '1100', '5','','2')
insert into Products values ('3', 'airbus', '1209990000', '5','','3')

