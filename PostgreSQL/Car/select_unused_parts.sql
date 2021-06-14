select b.name from car as c right join body as b on b.id = c.body_id where c.body_id is null
union
select e.name from car as c right join engine as e on e.id = c.engine_id where c.engine_id is null
union
select t.name from car as c right join transmission as t on t.id = c.transmission_id where c.transmission_id is null;