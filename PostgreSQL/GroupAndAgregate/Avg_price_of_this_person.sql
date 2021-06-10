select p.name as "Person", avg(price) as "Average price of this person's devices" from people as p
join devices_people as dp on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name;