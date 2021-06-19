CREATE TABLE Product(
model INT NOT NULL PRIMARY KEY,
maker NVARCHAR(20) NOT NULL,
[type] NVARCHAR(20) NOT NULL
);

CREATE TABLE PC(

speed FLOAT NOT NULL,
ram INT NOT NULL,
hd INT NOT NULL,
price INT NOT NULL,
model INT NOT NULL FOREIGN KEY REFERENCES dbo.Product(model)
);

CREATE TABLE Laptop(
speed FLOAT NOT NULL,
ram INT NOT NULL,
hd INT NOT NULL,
screen  FLOAT NOT NULL,
price INT NOT NULL,
model INT NOT NULL FOREIGN KEY REFERENCES dbo.Product(model)
);

CREATE TABLE Printer(
color NVARCHAR(20) NOT NULL,
[type] NVARCHAR(20) NOT NULL,
price INT NOT NULL,
model INT NOT NULL FOREIGN KEY REFERENCES dbo.Product(model)
)
--INSERT Product
 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'A',
      1001 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'A',
      1002 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'A',
      1003 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'A',
      2004 , 
     'laptop'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'A',
      2005 , 
     'laptop'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'A',
      2006 , 
     'laptop'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'B',
      1004 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'B',
      1005 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'B',
      1006 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'B',
      2007 , 
     'laptop'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'C',
      1007 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'D',
      1008 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'D',
      1009 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'D',
      1010 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'D',
      3004 , 
     'printer'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'D',
      3005 , 
     'printer'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'E',
      1011 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'E',
      1012 , 
     'pc' 
	 
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'E',
      1013 , 
     'pc'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'E',
      2001 , 
     'laptop'  
     )

	 INSERT INTO dbo.Product
 (
     maker,
	 model,
     [type]
 )
 VALUES
 (   'E',
      2002 , 
     'laptop'  
     )
--INSERT PC
INSERT INTO dbo.PC
(
    model,
    speed,
    ram,
    hd,
    price
   
)
VALUES
(   1001, 
    2.66,   
    1024,   
    250,   
    2114   
    )

	INSERT INTO dbo.PC
(
    model,
    speed,
    ram,
    hd,
    price
   
)
VALUES
(   1002, 
    2.10,   
    512,   
    250,   
    995   
    )

	INSERT INTO dbo.PC
(
    model,
    speed,
    ram,
    hd,
    price
   
)
VALUES
(   1003, 
    1.42,   
    512,   
    80,   
    478   
    )

	INSERT INTO dbo.PC
(
    model,
    speed,
    ram,
    hd,
    price
   
)
VALUES
(   1004, 
    2.80,   
    1024,   
    250,   
    649   
    )

	INSERT INTO dbo.PC
(
    model,
    speed,
    ram,
    hd,
    price
   
)
VALUES
(   1005, 
    3.20,   
    512,   
    250,   
    630   
    )

	INSERT INTO dbo.PC
(
    model,
    speed,
    ram,
    hd,
    price
   
)
VALUES
(   1006, 
    3.20,   
    1024,   
    320,   
    1049   
    )
--INSERT Laptop
INSERT INTO dbo.Laptop
(
    model,
    speed,
    ram,
    hd,
    screen,
    price
    
)
VALUES
(   2001,    -- model - int
    2.00, -- speed - float
    2048,   -- ram - int
    240,   -- hd - int
    20.1, -- screen - float
    3673   -- price - int
    
    )

	INSERT INTO dbo.Laptop
(
    model,
    speed,
    ram,
    hd,
    screen,
    price
    
)
VALUES
(   2002,    -- model - int
    1.73, -- speed - float
    1024,   -- ram - int
    80,   -- hd - int
    17.0, -- screen - float
    949   -- price - int
    
    )

	INSERT INTO dbo.Laptop
(
    model,
    speed,
    ram,
    hd,
    screen,
    price
    
)
VALUES
(   2003,    -- model - int
    1.80, -- speed - float
    512,   -- ram - int
    60,   -- hd - int
    15.4, -- screen - float
    549   -- price - int
    
    )

	INSERT INTO dbo.Laptop
(
    model,
    speed,
    ram,
    hd,
    screen,
    price
    
)
VALUES
(   2004,    -- model - int
    2.00, -- speed - float
    512,   -- ram - int
    60,   -- hd - int
    13.3, -- screen - float
    1150   -- price - int
    
    )

	INSERT INTO dbo.Laptop
(
    model,
    speed,
    ram,
    hd,
    screen,
    price
    
)
VALUES
(   2005,    -- model - int
    2.16, -- speed - float
    1024,   -- ram - int
    120,   -- hd - int
    17.0, -- screen - float
    2500   -- price - int
    
    )
--INSERT Printer
INSERT INTO dbo.Printer
( 
    model,
    color,
    [type],
    price
   
)
VALUES
(   3001,     -- model - int
    'true', -- color - 
    'ink-jet',  -- type - nvarchar(20)
    99    -- price - int
    
    )

	INSERT INTO dbo.Printer
( 
    model,
    color,
    [type],
    price
   
)
VALUES
(   3002,     -- model - int
    'false', -- color - 
    'laser',  -- type - nvarchar(20)
    239    -- price - int
    
    )

	INSERT INTO dbo.Printer
( 
    model,
    color,
    [type],
    price
   
)
VALUES
(   3003,     -- model - int
    'true', -- color - 
    'laser',  -- type - nvarchar(20)
    899    -- price - int
    
    )

	INSERT INTO dbo.Printer
( 
    model,
    color,
    [type],
    price
   
)
VALUES
(   3004,     -- model - int
    'true', -- color -
    'ink-jet',  -- type - nvarchar(20)
    120    -- price - int
    
    )

	INSERT INTO dbo.Printer
( 
    model,
    color,
    [type],
    price
   
)
VALUES
(   3005,     -- model - int
    'false', -- color - 
    'laser',  -- type - nvarchar(20)
    120    -- price - int
    
    )