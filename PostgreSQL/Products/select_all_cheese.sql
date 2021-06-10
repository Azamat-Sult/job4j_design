select p.name as "Продукт", t.name as "Категория" from product as p join type as t on p.type_id = t.id
where t.name = 'СЫР';