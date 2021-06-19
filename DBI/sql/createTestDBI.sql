use master;
go
create database TestDBI;
go
use TestDBI;
go
CREATE TABLE CUSTOMERS (
   ID   INT              NOT NULL,
   NAME VARCHAR (20)     NOT NULL,
   AGE  INT              NOT NULL,
   ADDRESS  CHAR (25),
   SALARY   DECIMAL (18, 2),
   PRIMARY KEY (ID)
);

go

CREATE TABLE ORDERS (
   OID  INT              NOT NULL,
   DATE VARCHAR (20)     NOT NULL,
   CUSTOMER_ID INT       NOT NULL,
   AMOUNT INT,
   PRIMARY KEY (OID)
);

go

INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (1, 'Ha Anh', 32, 'Da Nang', 2000.00 );
INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (2, 'Van Ha', 25, 'Ha Noi', 1500.00 );
INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (3, 'Vu Bang', 23, 'Vinh', 2000.00 );
INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (4, 'Thu Minh', 25, 'Ha Noi', 6500.00 );
INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (5, 'Hai An', 27, 'Ha Noi', 8500.00 );
INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (6, 'Hoang', 22, 'Ha Noi', 4500.00 );
INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (7, 'Binh', 24, 'Ha Noi', 10000.00 );

INSERT INTO ORDERS (OID, DATE, CUSTOMER_ID, AMOUNT)
    VALUES (102, '2009-10-08 00:00:00', 3, 10);
INSERT INTO ORDERS (OID, DATE, CUSTOMER_ID, AMOUNT)
    VALUES (100, '2009-10-08 00:00:00', 3, 15);
INSERT INTO ORDERS (OID, DATE, CUSTOMER_ID, AMOUNT)
    VALUES (101, '2009-11-20 00:00:00', 2, 5);
INSERT INTO ORDERS (OID, DATE, CUSTOMER_ID, AMOUNT)
    VALUES (103, '2008-05-20 00:00:00', 4, 20);