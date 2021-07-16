select p.productCode, p.productName, p.productCategory , p.buyPrice, p.suggestedRetailPrice
from products p
where p.suggestedRetailPrice >= 2 * p.buyPrice and p.productCategory = 'Classic Cars'
order by suggestedRetailPrice desc