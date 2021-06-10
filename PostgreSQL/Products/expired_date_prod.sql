select p.name as "Просроченный продукт", t.name as "Категория", p.expired_date as "Срок годности"
from product as p join type as t on p.type_id = t.id
where p.expired_date < current_date;