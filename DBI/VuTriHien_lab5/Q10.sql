delete FROM products
where products.productCode not in ( select o.productCode
									from orderdetails o)