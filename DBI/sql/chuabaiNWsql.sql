--Q1
select e.EmployeeID,e.LastName + e.FirstName as EmployeeName , e.HomePhone, 
year(getdate()) - year(e.BirthDate)
from Employees e

--Q2
Select * 
from Employees e
Where YEAR(e.BirthDate) <= 1960  
