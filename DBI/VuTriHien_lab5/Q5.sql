select c.customerNumber, c.customerName, c.city ,c.country , sum(p.amount)
from customers c right join payments p on p.customerNumber = c.customerNumber
where c.country = 'Germany'
group by c.customerNumber, c.customerName, c.city ,c.country 
order by sum(p.amount) asc