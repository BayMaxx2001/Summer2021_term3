Create database QLBongDa

use QLBongDa

create table CAUTHU(
	MACT NVARCHAR(50) NOT NULL PRIMARY KEY,
	HOTEN NVARCHAR(50) NOT NULL,
	NGAYSINH DATE,
	DIACHI NVARCHAR(200), 
	MACLB NVARCHAR(50) NOT NULL,
	VITRI NVARCHAR(50) NOT NULL, 
	SO INT NOT NULL,
	ID int identity(1,1)
)
create table QUOCGIA(
	MAQG NVARCHAR(50) NOT NULL PRIMARY KEY,
	TENQG NVARCHAR(50) NOT NULL,
	ID int identity(1,1)
)
create table CAULACBO(
	MACLB NVARCHAR(50) NOT NULL PRIMARY KEY,
	TENCLB NVARCHAR(100) NOT NULL,
	MASAN NVARCHAR(50) NOT NULL,
	MATINH NVARCHAR(50) NOT NULL
)
create table TINH(
	MATINH NVARCHAR(50) NOT NULL PRIMARY KEY,
	TENTINH NVARCHAR(50) NOT NULL,
)

CREATE table SANVD(
	MASAN NVARCHAR(50) NOT NULL PRIMARY KEY,
	TENSAN NVARCHAR(100) NOT NULL,
	DIACHI NVARCHAR(50) 
)

