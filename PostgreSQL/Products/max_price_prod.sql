select p.name as "Продукт с максимальной ценой", t.name as "Категория", p.price as "Цена"
from product as p join type as t on p.type_id = t.id
WHERE p.price = (SELECT max(price) FROM product);