-- What types of product made by manufacturer A?
Select * from Product as PrD
where PrD.maker like 'A'

-- What PC models have a speed of at least 3.00?
Select PC.model , Pc.speed from  PC 
where PC.speed >= 3.00

-- What types of product made by both manufacturers A and D?
Select Product.type from Product
where Product.maker like 'A' 
intersect 
Select Product.type from Product
where Product.maker like 'D' 

-- What types of product made by manufacturer A but not by manufacturer D?
Select Product.type from Product
where Product.maker like 'A' 
Except 
Select Product.type from Product
where Product.maker like 'D' 

-- Which manufacturers make laptops with a hard disk of at least 100GB
SELECT Pr.maker
      ,Pr.model
FROM dbo.Product Pr
JOIN dbo.Laptop Lp
ON Pr.model=Lp.model
WHERE Lp.hd>=100 

--Find the model numbers and price of all products (of any type) made by manufacturer B?
Select distinct Pr.maker, count(Pr.model)
From dbo.Product Pr
where Pr.maker like 'B%'
Group by Pr.maker

SELECT
Pr.maker
,Pc.price
FROM dbo.PC Pc
INNER JOIN dbo.Product Pr
ON Pc.model=Pr.model
WHERE Pr.maker LIKE 'B%';

-- Find the model number of all color laser printers?
SELECT 
       COUNT( Prt.model) AS Count_model
FROM dbo.Printer Prt
WHERE Prt.[type] IN ('laser') 
GROUP BY Prt.[type];

--Find those manufacturers that sell Laptops, but not PC’s
SELECT
Pr.maker
,Lp.model
FROM dbo.Laptop Lp
INNER JOIN dbo.Product Pr
ON Lp.model=Pr.model
WHERE Lp.price != 0 ;

--Find those hard-disk sizes that occur in two or more PC’s.
SELECT Pc.hd
      ,COUNT(Pc.hd)
from PC 
Group by Pc.hd 
Having COUNT(PC.hd) >=2

-- Find the manufacturers of the computer with the highest available speed.
SELECT DISTINCT maker
FROM dbo.Product, ((SELECT model, speed FROM dbo.PC) UNION (SELECT model, speed FROM dbo.Laptop)) AS models_speed
WHERE dbo.Product.model = models_speed.model
  AND speed >= ALL((SELECT speed FROM dbo.PC) UNION (SELECT speed FROM dbo.Laptop));

 -- Find those manufacturers of at least two different computers (PC or laptop) with speeds of at least 2.80.
SELECT DISTINCT maker
FROM product, ((SELECT model, speed FROM pc) UNION (SELECT model, speed FROM laptop)) AS models_speed
WHERE product.model = models_speed.model
  AND models_speed.speed >= 2.80;