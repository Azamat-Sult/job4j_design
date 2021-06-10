create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Smartphone', 20000);
insert into devices(name, price) values ('Notebook', 60000);
insert into devices(name, price) values ('Smart watch', 10000);
insert into devices(name, price) values ('Powerbank', 5000);

insert into people(name) values ('Bob');
insert into people(name) values ('Jane');
insert into people(name) values ('Drake');
insert into people(name) values ('John');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (1, 2);
insert into devices_people(device_id, people_id) values (1, 3);
insert into devices_people(device_id, people_id) values (1, 4);
insert into devices_people(device_id, people_id) values (2, 4);
insert into devices_people(device_id, people_id) values (3, 1);
insert into devices_people(device_id, people_id) values (3, 4);
insert into devices_people(device_id, people_id) values (4, 2);