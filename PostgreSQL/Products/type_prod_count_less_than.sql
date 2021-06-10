select t.name as "Категория", count(p.name) as "Продуктов осталось меньше 5"
from product as p join type as t on p.type_id = t.id
group by t.name
having count(p.name) < 5;