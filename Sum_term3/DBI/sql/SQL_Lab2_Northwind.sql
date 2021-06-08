use Northwind
-- 1 Danh sách các employees. Thông tin bao gồm EmployeeId, EmployeeName, Phone, Age. 
--Trong đó EmployeeName được ghép từ LastName và FirstName; Age là tuổi được tính 
--từ năm hiện hành (GetDate()) và năm của Birthdate.

Select  e.EmployeeID, 
	concat(e.LastName,e.FirstName) EmployeeName,
	e.HomePhone,
	year(GETDATE()) - year(e.BirthDate) Age
from Employees e

-- 2 Danh sách employees có năm sinh <=1960
Select * 
from Employees e
Where YEAR(e.BirthDate) <= 1960  

--3 Danh sách các products có từ ‘Boxes’ trong cột QuantityPerUnit
Select * 
From Products 
where QuantityPerUnit like '%Boxes%'

--4 Danh sách các products có Unitprice lớn hớn 10 và nhỏ hơn 15
Select * 
From Products 
where UnitPrice > 10 and UnitPrice < 15;

-- 5 Danh sách các orders có OrderDate được lập trong tháng 9 năm 1996
Select *
From orders od 
where year(od.OrderDate) = 1996 and month(od.OrderDate) = 9

-- 6 Danh sách các products ứng với tiền tồn vốn. Thông tin bao gồm ProductId, 
--ProductName, Unitprice, UnitsInStock, TotalAccount. Trong đó TotalAccount= 
--UnitsInStock * Unitprice.

Select pd.ProductID, pd.ProductName, pd.UnitPrice
		, pd.UnitsInStock, UnitsInStock * Unitprice TotalACCOUNT 

from Products pd

-- 7 Danh sách 5 customers có city bắt đầu ‘M’
Select top 5 cs.*
From Customers cs
where cs.City like 'M%'

-- 8 Danh sách 2 employees có tuổi lớn nhất. Thông tin bao gồm EmployeeID, 
--EmployeeName, Age. Trong đó, EmployeeName được ghép từ LastName và FirstName; 
--Age là năm hiện hành từ cho năm sinh
Select top 2 E.EmployeeID, 
concat(e.FirstName,e.LastName) EmployeeName, 
year(GETDATE())-year(e.BirthDate) Age
from Employees e
order by e.BirthDate asc


--9 Danh sách 2 employees có tuổi lớn nhất. Thông tin bao gồm EmployeeID, 
--EmployeeName, Age. Trong đó, EmployeeName được ghép từ LastName và FirstName; 
--Age là năm hiện hành từ cho năm sinh
Select distinct od.ProductID, 
pd.ProductName, pd.UnitPrice
from [Order Details] od inner join Products pd
on pd.ProductID = od.ProductID
where pd.ProductID = od.ProductID

--10 Cho biết những Customers chưa từng lập hóa đơn
Select distinct cs.* from Customers cs
where not EXISTS
(Select od.CustomerID from Orders od
where od.CustomerID = cs.CustomerID)

--11 Các customer không lập hóa đơn trong tháng 7/1997
Select distinct cs.* from Customers cs
where not EXISTS
(Select od.CustomerID from Orders od
where od.CustomerID = cs.CustomerID and year(od.OrderDate)=1997 and 
month(od.OrderDate)=7);

-- 12 Các customer có lập hóa đơn trong 15 ngày đầu tiên của 7/1997
Select distinct cs.* from Customers cs, Orders od
where cs.CustomerID = od.CustomerID
	and year(od.OrderDate)=1997 and MONTH(od.OrderDate)=7 
	and day(od.OrderDate)<=15;

--13 Danh sách các product, thông tin bao gồm: Productname, CategoryName, Unitprice
Select  pd.ProductName, ct.CategoryName, UnitPrice
from Categories ct inner join Products pd
on ct.CategoryID = pd.CategoryID

--14 Liệt kê danh sách các City có Customers hoặc Employee (dùng Union)
Select DISTINCT City From Customers cs 
Union
Select DISTINCT City from Employees e

--15 Liệt kê danh sách các Country có Customers hoặc Employee (dùng Union)
Select Country From Customers cs 
Union
Select Country from Employees e

--16 Hợp danh sách các Customer và Employee lại với nhau. Thông tin gồm CodeID, Name, 
--Address, Phone. Trong đó CodeID là CustomerID/EmployeeID, Name là 
--Companyname/LastName + FirstName, Phone là Homephone.
Select distinct
	(EmployeeID) AS CodeId
      ,(CONCAT(LastName,' ',FirstName)) AS [Name]
	  ,(e.Address) AS [Address]
	  ,HomePhone AS [Phone]
From Employees e FULL OUTER join Customers cs 
on cs.Address = cs.Address 
ORDER BY CodeId;
