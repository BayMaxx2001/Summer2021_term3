
--Q2 Write a query to display all SubCategories in category 3 as follows:
select s.CategoryID as ID, s.SubCategoryName , s.CategoryID
from SubCategory s
where s.CategoryID = 3

--Q3 Write a query to display the ID, CustomerName, City, State of all customers 
--who placed orders from 05 December 2017 to 10 December 2017 and their orders are shipped less than 3 days. 
--Display the result by ascending order of State and then by descending order of City.
select c.ID , c.CustomerName, c.City, c.State
from Customer c inner join Orders o on o.CustomerID = c.ID
where o.OrderDate between '20171205' and '20171210' and o.ShipDate- o.OrderDate < 3
order by City desc

--Q4 The Amount of each product in an order is calculated by Quantity*SalePrice*(1-Discount). 
--The TotalAmount of each order is the sum of the Amount of all product in the order
select sum(od.Quantity * od.SalePrice * (1-od.Discount)) , o.ID, o.OrderDate
from OrderDetails od join Orders o on o.ID = od.OrderID
group by o.ID, o.OrderDate
having sum(od.Quantity * od.SalePrice * (1-od.Discount)) > 8000
order by sum(od.Quantity * od.SalePrice * (1-od.Discount)) desc

-- Q5 Find all orders that were ordered on the same day as the latest order as follows
select o.ID, o.OrderDate, o.ShipDate, o.ShipMode, cs.ID
from Orders o inner join Customer cs on o.CustomerID = cs.ID
where o.OrderDate = (select max(o.OrderDate) from Orders o)

-- Q6 Find all the products which appeared in the smallest number of orders, order by ProductID. 
--The results should be displayed in the form of ProductID, ProductName, NumberOfOrders.
with t as(
select od.ProductID,  p.ProductName, count(od.ProductID) NumberOfOrder
from OrderDetails od inner join Product p on p.ID = od.ProductID
group by od.ProductID, p.ProductName
)
select t.*
from t
where t.NumberOfOrder = (
select min(t.NumberOfOrder) from t
)

-- Q7 5 max and 5 min\
with q as
(
select top 5 p.SubCategoryID, count(p.SubCategoryID) NumberOfProducts
from SubCategory s inner join Product p on s.ID = p.SubCategoryID
group by p.SubCategoryID 
order by count(p.SubCategoryID) desc
union
select top 5 p.SubCategoryID, count(p.SubCategoryID)NumberOfProducts
from SubCategory s inner join Product p on s.ID = p.SubCategoryID
group by p.SubCategoryID 
order by count(p.SubCategoryID) asc
)
select q.*
from q
order by q.NumberOfProducts desc