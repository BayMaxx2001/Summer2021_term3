create trigger tr_insertProduct
on products
for INSERT 
as
begin 
	select i.productCode, i.productName, i.productCategory,p.textDescription
	from inserted i inner join productCategories p on p.productCategory = i.productCategory
end
