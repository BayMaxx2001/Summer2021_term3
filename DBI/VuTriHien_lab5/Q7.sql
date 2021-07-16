select month(o.orderDate) as Month , Year(orderDate) as Year
,p.productCategory,
count(*) as numberOfProducts
from orders o 
inner join orderdetails od on o.orderNumber = od.orderNumber
inner join products p on p.productCode = od.productCode
where MONTH(o.orderDate) between 1 and 3 and year(o.orderDate) = 2003
group by month(o.orderDate) , Year(orderDate) ,p.productCategory
order by MONTH(o.orderDate) asc , p.productCategory asc