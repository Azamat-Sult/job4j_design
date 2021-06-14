create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into body(name) values ('Sedan');
insert into body(name) values ('Station wagon');
insert into body(name) values ('Hatchback');
insert into body(name) values ('Limousine');

insert into engine(name) values ('Gas engine');
insert into engine(name) values ('Diesel engine');
insert into engine(name) values ('Electrical engine');

insert into transmission(name) values ('Manual transmission');
insert into transmission(name) values ('Automatic transmission');
insert into transmission(name) values ('Robotic transmission');

insert into car(name, body_id, engine_id, transmission_id) values ('car1', 1, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('car2', 3, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('car3', 1, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('car4', 1, 1, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('car5', 3, 1, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('car6', 3, 2, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('car7', 1, 2, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('car8', 3, 1, 1);