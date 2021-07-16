select c.customerNumber, c.customerName, c.city, c.country, c.salesRepEmployeeNumber, e.lastName as employeeLastName, e.firstName as employeeFirstName
from customers c inner join employees e on e.employeeNumber = c.salesRepEmployeeNumber
where c.city = 'Paris' or c.city = 'NYC' or c.city = 'Brickhaven'
order by c.country asc, c.city asc