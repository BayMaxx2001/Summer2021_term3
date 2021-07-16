create proc proc_numberOfEmployee
(
	@officeCode varchar(10),
	@NumberOfEmployees int output
)
as 
begin
	select @NumberOfEmployees= count(e.employeeNumber)
	from employees e
	where e.officeCode = @officeCode
end
