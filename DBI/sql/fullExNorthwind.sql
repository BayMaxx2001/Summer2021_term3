use Northwind

--EX39
with ex39 as(
Select top 5 pd.ProductID , pd.ProductName , SUM(od.Quantity) as 'Total Ordered'
from Products pd left join [Order Details] od 
on pd.ProductID = od.ProductID
group by pd.ProductID , pd.ProductName
order by SUM(od.Quantity) desc)

SELECT TOP 5 ex39.*
FROM ex39
ORDER BY ex39.[Total Ordered] ASC

-- EX38[
with ex38 as(
Select top 3 pd.ProductID , pd.ProductName ,SUM(od.Quantity) as 'Total Ordered'
from Products pd left join [Order Details] od 
on pd.ProductID = od.ProductID
group by pd.ProductID , pd.ProductName
order by SUM(od.Quantity) desc)

select top 3 ex38.* from ex38 
order by ex38.[Total Ordered] asc
--]

--ex37[
with ex37 as(
Select e.EmployeeID , e.LastName , e.FirstName , COUNT(e.EmployeeID) as 'Delayed Orders' 
from Employees e left join Orders o on e.EmployeeID = o.EmployeeID
where o.ShippedDate - o.RequiredDate > 0
GROUP BY e.EmployeeID, e.LastName, e.FirstName)

SELECT ex37.*
FROM ex37
WHERE ex37.[Delayed Orders] = (SELECT MIN([Delayed Orders]) FROM ex37)
--]

--ex36
with ex36 as(
Select e.EmployeeID , e.LastName, e.FirstName , count(od.EmployeeID)as 'Delayed Orders' 
from Employees e inner join Orders od on e.EmployeeID = od.EmployeeID
where od.ShippedDate - od.RequiredDate > 0
group by e.EmployeeID , e.LastName , e.FirstName)

SELECT ex36.* from ex36
where ex36.[Delayed Orders] = (SELECT MAX([Delayed Orders]) from ex36)

--ex35
select p.ProductID , p.ProductName , p.SupplierID , p.CategoryID , p.ReorderLevel
from Products p
where p.ReorderLevel = (SELECT MAX([ReorderLevel]) from Products)

--ex34
select p.ProductID , p.ProductName , p.SupplierID , p.CategoryID , p.UnitsOnOrder
from Products p
where p.UnitsOnOrder = (SELECT MAX(UnitsOnOrder) from Products)


--ex33
select p.ProductID , p.ProductName , p.SupplierID , p.CategoryID , p.UnitsInStock
from Products p
where p.UnitsInStock = (SELECT MIN(UnitsInStock) from Products)

--ex32
select p.ProductID , p.ProductName , p.SupplierID , p.CategoryID , p.UnitsInStock
from Products p
where p.UnitsInStock = (SELECT MAX(UnitsInStock) from Products)

--ex31
with ex31 as(
select e.EmployeeID, e.LastName, e.Title , count(o.OrderID) as 'Total_Orders'
from Employees e inner join Orders o on e.EmployeeID = o.EmployeeID
group by e.EmployeeID , e.LastName, e.Title)

Select ex31.* from ex31
where ex31.Total_Orders = (Select MAX(Total_Orders) from ex31)

--ex30
WITH t AS(
SELECT o.EmployeeID, COUNT(o.OrderID) AS 'total orders'
FROM dbo.Orders o
GROUP BY o.EmployeeID)

SELECT e.EmployeeID, e.LastName, e.FirstName, e.Title, t.[total orders]
FROM dbo.Employees e
LEFT OUTER JOIN t
ON t.EmployeeID = e.EmployeeID
WHERE t.[total orders] = (SELECT MIN(t.[total orders]) FROM t)

--ex29
SELECT COUNT(e.EmployeeID) + (SELECT COUNT(c.CustomerID) FROM dbo.Customers c) as 'Total records'
FROM Employees e

--ex28
WITH t AS(
SELECT p.CategoryID, COUNT(p.ProductID) AS 'total products'
FROM dbo.Products p
GROUP BY p.CategoryID)
SELECT c.CategoryID, c.CategoryName, t.[total products]
FROM dbo.Categories c
LEFT OUTER JOIN t
ON t.CategoryID = c.CategoryID
WHERE t.[total products] = (SELECT MIN(t.[total products]) FROM t)

--ex27
WITH t AS(
SELECT p.CategoryID, COUNT(p.ProductID) AS 'total products'
FROM dbo.Products p
GROUP BY p.CategoryID)
SELECT c.CategoryID, c.CategoryName, t.[total products]
FROM dbo.Categories c
LEFT OUTER JOIN t
ON t.CategoryID = c.CategoryID
WHERE t.[total products] = (SELECT MAX(t.[total products]) FROM t)

--EX26
WITH t AS(
SELECT p.ProductID, p.ProductName, p.SupplierID, p.CategoryID, SUM(o.Quantity) AS 'Total ordered'
FROM dbo.Products p
LEFT OUTER JOIN dbo.[Order Details] o
ON o.ProductID = p.ProductID
GROUP BY p.ProductID, p.ProductName, p.SupplierID, p.CategoryID)
SELECT t.*
FROM t
WHERE t.[Total ordered] >=1400
ORDER BY t.[Total ordered] DESC

--EX25
WITH t AS (SELECT p.ProductID, p.ProductName, SUM(o.Quantity) AS 'Total ordered'
FROM dbo.Products p
LEFT OUTER JOIN dbo.[Order Details] o
ON o.ProductID = p.ProductID
GROUP BY p.ProductID, p.ProductName)
SELECT t.*
FROM t
WHERE t.[Total ordered] >=1200

--EX24
SELECT c.CustomerID, c.CompanyName, c.ContactName, c.ContactTitle
FROM dbo.Orders o
LEFT OUTER JOIN dbo.Customers c
ON c.CustomerID = o.CustomerID
WHERE o.OrderID ='10643'

--EX23
SELECT c.CompanyName, c.Phone
FROM dbo.Customers c
WHERE c.CompanyName LIKE 'W%'
UNION ALL
SELECT e.LastName +' '+e.FirstName, e.HomePhone
FROM dbo.Employees e

--EX22
SELECT e.EmployeeID, e.LastName, e.FirstName, o.OrderID, o.OrderDate, o.RequiredDate, o.ShippedDate
FROM dbo.Employees e
INNER JOIN dbo.Orders o
ON o.EmployeeID = e.EmployeeID
WHERE (o.ShippedDate-o.RequiredDate)>7
ORDER BY e.EmployeeID

--EX21
SELECT p.CategoryID, c.CategoryName, p.ProductID, p.ProductName, DAY(o.OrderDate) AS 'day', MONTH(o.OrderDate) AS 'month', YEAR(o.OrderDate) AS 'year',
od.Quantity*od.UnitPrice AS 'Revenue'
FROM dbo.Products p, dbo.Categories c, dbo.[Order Details] od, dbo.Orders o
WHERE p.CategoryID=c.CategoryID AND p.ProductID = od.ProductID AND od.OrderID=o.OrderID AND o.OrderDate BETWEEN '7/1/1996' AND '7/5/1996'
ORDER BY c.CategoryID, p.ProductID