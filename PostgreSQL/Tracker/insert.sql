insert into rules(rule) values ('create');
insert into rules(rule) values ('read');
insert into rules(rule) values ('update');
insert into rules(rule) values ('delete');

insert into role(role) values ('guest');
insert into role(role) values ('user');
insert into role(role) values ('admin');

insert into role_rules(role_id, rules_id) values (1, 2);
insert into role_rules(role_id, rules_id) values (2, 1);
insert into role_rules(role_id, rules_id) values (2, 2);
insert into role_rules(role_id, rules_id) values (2, 3);
insert into role_rules(role_id, rules_id) values (3, 1);
insert into role_rules(role_id, rules_id) values (3, 2);
insert into role_rules(role_id, rules_id) values (3, 3);
insert into role_rules(role_id, rules_id) values (3, 4);

insert into users(name, role_id) values ('Bob', 2);
insert into users(name, role_id) values ('Jake', 2);
insert into users(name, role_id) values ('John', 3);

insert into category(category) values ('junior');
insert into category(category) values ('middle');
insert into category(category) values ('senior');

insert into state(state) values ('new');
insert into state(state) values ('in progress');
insert into state(state) values ('done');

insert into item(task, users_id, category_id, state_id) values ('Make own HashMap', 1, 1, 2);
insert into item(task, users_id, category_id, state_id) values ('Sort LinkedList', 2, 2, 3);
insert into item(task, users_id, category_id, state_id) values ('Install PostgreSQL', 1, 1, 1);
insert into item(task, users_id, category_id, state_id) values ('Collections exam', 2, 1, 1);

insert into comments(comment, item_id) values ('You can do it', 2);
insert into comments(comment, item_id) values ('Well done', 2);
insert into comments(comment, item_id) values ('I don`t understand, help me please!', 1);

insert into attachs(attach, item_id) values ('sorted_linked_list_v2.java', 2);