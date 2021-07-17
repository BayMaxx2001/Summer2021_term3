select p.product_id, p.product_name, p.model_year, sum(s.quantity) TotalStockQuantity
from products p inner join stocks s on p.product_id = s.product_id
group by p.product_id, p.product_name, p.model_year
having sum(s.quantity) = 
(select top 1 sum(s.quantity) 
	from products p inner join stocks s on p.product_id = s.product_id
group by p.product_id, p.product_name, p.model_year
order by sum(s.quantity)  desc
)
