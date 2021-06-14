select c.name as "Model", b.name as "Body", e.name as "Engine", t.name as "Transmission"
from car as c
join body as b on c.body_id = b.id
join engine as e on c.engine_id = e.id
join transmission as t on c.transmission_id = t.id;