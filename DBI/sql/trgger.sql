create trigger T_insertOrder
on Orders 
for INSERT 
as
begin 
	Select i.OrderID
	from inserted i
end 