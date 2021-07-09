begin try
	begin Transaction
		INSERT INTO Orders(CustomerID, EmployeeID, OrderDate, RequiredDate)
		values ('ALFKI', 2, GETDATE(), GETDATE()+DAY(3))
		--CHEN ODER DETAILS
		-- LAY DU LIEU ORDERID TRONG ORDERS
		declare @lastOrderId int
		set @lastOrderId = (select max(OrderID) from Orders)
	
		insert into [Order Details](OrderID, ProductID, UnitPrice, Quantity)
		values(@lastOrderId, 1, 18, 5)

		update Products set UnitsOnOrder = UnitsOnOrder + 5, UnitsInStock = UnitsInStock -5
		where ProductID = 1
	commit Transaction
	print 'Transaction succesfull'
end try
begin catch
	rollback Transaction	
	print 'Transaction fail'
end catch