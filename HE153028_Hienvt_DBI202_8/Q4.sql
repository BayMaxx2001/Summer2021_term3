with t as(
select distinct(p.product_id), p.product_name, p.model_year, p.brand_name, s.store_name
from products p inner join stocks sk on p.product_id = sk.product_id,
	stores s inner join stocks sk1 on s.store_id = sk1.store_id
where p.brand_name = 'Surly' and s.store_name = 'Baldwin Bikes'
)
select distinct t.*, sk1.quantity
from t inner join stocks sk1 on t.product_id = sk1.product_id
order by t.product_id asc
