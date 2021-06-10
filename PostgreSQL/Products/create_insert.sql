create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
	expired_date date,
	price float
);

insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('МЯСО');
insert into type(name) values ('ФРУКТЫ');

insert into product(name, type_id, expired_date, price) values ('Голландский', 1, '2021-09-10', 180);
insert into product(name, type_id, expired_date, price) values ('Российский', 1, '2021-07-10', 210);
insert into product(name, type_id, expired_date, price) values ('Пармезан', 1, '2021-04-10', 1210);

insert into product(name, type_id, expired_date, price) values ('Веселый молочник', 2, '2021-07-10', 60);
insert into product(name, type_id, expired_date, price) values ('Простоквашино', 2, '2021-06-05', 65);
insert into product(name, type_id, expired_date, price) values ('Домик в деревне', 2, '2021-09-10', 100);
insert into product(name, type_id, expired_date, price) values ('Ванильное мороженое', 2, '2021-09-10', 60);
insert into product(name, type_id, expired_date, price) values ('Шоколадное мороженое', 2, '2021-06-20', 80);

insert into product(name, type_id, expired_date, price) values ('Говядина', 3, '2021-06-18', 450);
insert into product(name, type_id, expired_date, price) values ('Свинина', 3, '2021-05-12', 300);
insert into product(name, type_id, expired_date, price) values ('Баранина', 3, '2021-06-14', 550);

insert into product(name, type_id, expired_date, price) values ('Банан', 4, '2021-06-20', 80);
insert into product(name, type_id, expired_date, price) values ('Апельсин', 4, '2021-06-20', 70);
insert into product(name, type_id, expired_date, price) values ('Груша', 4, '2021-05-20', 120);