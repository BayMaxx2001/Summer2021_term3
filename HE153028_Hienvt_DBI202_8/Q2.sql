select p.product_id, p.product_name,  p.model_year, p.list_price, p.brand_name, p.category_name
from products p
where p.category_name = 'Cyclocross Bicycles'