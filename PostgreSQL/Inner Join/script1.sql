create table author(
	id serial primary key,
	name varchar(255)
);

create table book(
	id serial primary key,
	title varchar(255),
	release_date date,
	author_id int references author(id)
);

insert into author(name) values ('John Ronald Reuel Tolkien');
insert into author(name) values ('Herbert George Wells');

insert into book(title, release_date, author_id) values('The Hobbit, or There and Back Again', '1937-09-21', 1);
insert into book(title, release_date, author_id) values('The Lord of the Rings', '1954-07-29', 1);
insert into book(title, release_date, author_id) values('The War of the Worlds', '1897-01-01', 2);
insert into book(title, release_date, author_id) values('The Invisible Man', '1897-01-01', 2);

select * from book join author a on book.author_id = a.id;