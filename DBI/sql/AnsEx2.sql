--Q1:Những loại sản phẩm nào của nhà sản xuất A?
SELECT  Pr.maker
      ,Pr.model
	  ,Pr.[type]
FROM dbo.Product Pr
WHERE(Pr.maker LIKE 'A%');
--Q2:Những kiểu máy tính nào có tốc độ ít nhất là 3,00?
SELECT Pc.model
      ,Pc.speed

FROM dbo.PC Pc
WHERE (Pc.speed>=3.00);
--Q3:Những loại sản phẩm nào được sản xuất bởi cả hai nhà sản xuất A và D?

SELECT
	Pr.[type]
FROM dbo.Product Pr
WHERE(Pr.maker LIKE 'A%')
INTERSECT
SELECT   
	Pr.[type]
FROM dbo.Product Pr
WHERE(Pr.maker LIKE 'D%');
--Q4:Những loại sản phẩm nào của nhà sản xuất A mà không phải của nhà sản xuất D?
SELECT
   Pr.[type]
FROM dbo.Product Pr
WHERE(Pr.maker LIKE 'A%')
EXCEPT
SELECT 
   Pr.[type]  
FROM dbo.Product Pr
WHERE (Pr.maker  LIKE 'D%');

--Q5:Nhà sản xuất nào sản xuất máy tính xách tay có đĩa cứng ít nhất 100GB?

SELECT Pr.maker
      ,Pr.model

FROM dbo.Product Pr
LEFT  JOIN dbo.Laptop Lp
ON Pr.model=Lp.model
WHERE Lp.hd>=100 
--Q6:Tìm số kiểu và giá của tất cả các sản phẩm (thuộc loại bất kỳ) do nhà sản xuất B sản xuất?
SELECT Pr.maker 
      ,COUNT(Pr.model) AS Count_model
FROM dbo.Product Pr
WHERE Pr.maker LIKE 'B%'
GROUP BY Pr.maker;

SELECT
Pr.maker
,Pc.price
FROM dbo.PC Pc
INNER JOIN dbo.Product Pr
ON Pc.model=Pr.model
WHERE Pr.maker LIKE 'B%';
--Q7:Tìm số kiểu máy của tất cả các máy in laser màu?
SELECT 
       COUNT( Prr.model) AS Count_model
FROM dbo.Printer Prr
WHERE Prr.[type] IN ('laser') 
GROUP BY Prr.[type];
--Q8:Tìm những nhà sản xuất bán Máy tính xách tay, nhưng không bán Máy tính cá nhân.
SELECT
Pr.maker
,Lp.model

FROM dbo.Laptop Lp
INNER JOIN dbo.Product Pr
ON Lp.model=Pr.model
WHERE Lp.price>0 ;
--Q9:Tìm những kích thước đĩa cứng xảy ra trong hai hoặc nhiều PC.
SELECT Pc.hd
      ,COUNT(Pc.hd) AS Count_hd

FROM dbo.PC Pc
GROUP BY Pc.hd
HAVING COUNT(Pc.hd)>=2;
--Q10:Tìm nhà sản xuất máy tính có tốc độ cao nhất hiện có.
SELECT DISTINCT maker
FROM dbo.Product, ((SELECT model, speed FROM dbo.PC) UNION (SELECT model, speed FROM dbo.Laptop)) AS models_speed
WHERE dbo.Product.model = models_speed.model
  AND speed >= ALL((SELECT speed FROM dbo.PC) UNION (SELECT speed FROM dbo.Laptop));
--Q11:Tìm nhà sản xuất đó của ít nhất hai máy tính khác nhau (PC hoặc máy tính xách tay) có tốc độ ít nhất là 2,80.
SELECT DISTINCT maker
FROM product, ((SELECT model, speed FROM pc) UNION (SELECT model, speed FROM laptop)) AS models_speed
WHERE product.model = models_speed.model
  AND models_speed.speed >= 2.80;
 
  


