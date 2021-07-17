create table Customers(
CID varchar(20) primary key,
[name] nvarchar(200),
address nvarchar(100),
)
create table Loans(
LoansNumber varchar(20) primary key,
Date Date,
Amount float,
CID varchar(20) FOREIGN KEY REFERENCES dbo.Customers(CID)
)
create table Payments(
paymentNumber int primary key,
Date Date,
Amount float,
LoansNumber varchar(20) FOREIGN KEY REFERENCES dbo.Loans(LoansNumber)
)


