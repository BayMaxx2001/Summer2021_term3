select c.customerNumber, c.customerName , c.city, c.[state] , c.country 
from customers c inner join payments p on c.customerNumber = p.customerNumber
where (p.amount) = 
(
select max(p.amount)
from payments p
)