create table teens(
    id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('William', 'male');
insert into teens(name, gender) values ('Mason', 'male');
insert into teens(name, gender) values ('James', 'male');
insert into teens(name, gender) values ('Benjamin', 'male');

insert into teens(name, gender) values ('Olivia', 'female');
insert into teens(name, gender) values ('Sophia', 'female');
insert into teens(name, gender) values ('Charlotte', 'female');
insert into teens(name, gender) values ('Emily', 'female');

select t1.name as a, t2.name as b from teens t1 cross join teens t2 where t1.gender != t2.gender;