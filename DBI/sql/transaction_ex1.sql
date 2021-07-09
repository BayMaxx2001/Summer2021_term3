BEGIN TRY
    BEGIN TRANSACTION 
		insert into Orders(CustomerID,EmployeeID) values('ALFKI',2)

	insert into [Order Details](OrderID,ProductID,Quantity,UnitPrice) values(
		(select OrderID 
			from Orders
			where CustomerID = 'ALFKI' and EmployeeID=2
		),1,5,18
	)
	update Products
	set UnitsInStock = UnitsInStock-5 , UnitsOnOrder = UnitsOnOrder+5
	where ProductID = 1
    COMMIT TRAN
	PRINT('Commit Complete')
END TRY
BEGIN CATCH
    IF @@TRANCOUNT > 0
        ROLLBACK TRAN
	PRINT('Commit Fail')
END CATCH
