create proc pr1
(
	@store_id int,
	@numberOfStaff int output
)
as 
begin
	select @numberOfStaff =count(staff_id)
	from staffs st
	where st.store_id = @store_id
end


