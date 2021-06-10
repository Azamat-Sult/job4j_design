select t.name as "Категория", p.name as "Продукт"
from product as p join type as t on p.type_id = t.id;