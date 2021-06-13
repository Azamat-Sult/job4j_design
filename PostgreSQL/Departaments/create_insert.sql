create table departments(
	id serial primary key,
	name varchar(255)
);

create table emploees(
	id serial primary key,
	name varchar(255),
	departments_id int references departments(id)
);

insert into departments(name) values ('Finance department');
insert into departments(name) values ('Legal department');
insert into departments(name) values ('Production department');
insert into departments(name) values ('Logistics department');

insert into emploees(name, departments_id) values ('Noah', 3);
insert into emploees(name, departments_id) values ('Emma', 1);
insert into emploees(name, departments_id) values ('Liam', null);
insert into emploees(name, departments_id) values ('Olivia', 3);
insert into emploees(name, departments_id) values ('William', 2);
insert into emploees(name, departments_id) values ('Ava', 1);
insert into emploees(name, departments_id) values ('Mason', null);
insert into emploees(name, departments_id) values ('Sophia', 2);
insert into emploees(name, departments_id) values ('James', 3);