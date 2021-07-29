select s.staff_id, s.first_name, s.last_name, count(o.order_id) NumberOfOrders
from staffs s left join orders o on s.staff_id = o.staff_id
and Year(o.order_date) = 2017 and Month(o.order_date) <= 3
group by s.staff_id, s.first_name, s.last_name
having count(o.order_id) >= 0





