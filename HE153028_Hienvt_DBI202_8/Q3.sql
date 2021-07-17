select o.order_id , o.order_date, o.required_date, o.shipped_date, o.store_id
from orders o
where Year(o.order_date) = 2018 and Month(o.order_date) = 3 and o.shipped_date > o.required_date
order by o.store_id asc