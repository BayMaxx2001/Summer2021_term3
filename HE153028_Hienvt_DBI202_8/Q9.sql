create trigger Tr1
on staffs 
for INSERT 
as
begin 
	Select i.staff_id, i.first_name , i.last_name, i.store_id, stores.store_name
	from inserted i inner join stores on i.store_id = stores.store_id
end 
