select t.name as "Категория", count(p.name) as "Продуктов в категории"
from product as p join type as t on p.type_id = t.id
group by t.name;