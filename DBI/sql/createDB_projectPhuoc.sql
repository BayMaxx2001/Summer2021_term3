--CREATE DATABASE ProjectDBI202
--GO
--USE ProjectDBI202


--Students table

create table Students(
StudentID varchar(8) primary key,
Name nvarchar(50),
gender char(1) check (gender = 'M' or gender = 'F'),
Email nvarchar(255),
ClassID varchar(6)
)

--Class table

create table Class(
ClassID varchar(6) primary key,
Name nvarchar(100)
)

-- Courses table 

create table Courses(
CourseID varchar(6) primary key,
Name nvarchar(100),
NoCredits int check(NoCredits >0)
)

--Room table 

create table Room(
RoomNo varchar(10) primary key,
Type nvarchar(20)
)

--Teacher table

create table Teachers(
TeacherID varchar(10) primary key,
Name nvarchar(100),
Email nvarchar(255) unique check (Email like '%fpt.edu.vn' or Email like '%fe.edu.vn'),
gender char(1) not null check (gender = 'M' or gender = 'F')
)

--Slot table

create table Slot(
SlotNo int primary key check (SlotNo between 1 and 8),
Start time(0),
[End] time(0)
)

--Timetable table

create table TimeTable(
Date date not null,
ClassID varchar(6) not null,
SlotNo int not null,
RoomNo varchar(10),
TeacherID varchar(10),
CourseID varchar(6)
)











