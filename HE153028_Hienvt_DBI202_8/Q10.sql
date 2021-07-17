update stocks 
set quantity = 30
from products p, stocks s
where p.category_name like 'Cruisers%' and s.store_id = 1 and p.product_id = s.product_id

