drop table if exists person;

create table person
(
 id integer not null primary key auto_increment,
 name varchar,
 last_name varchar,
 birth_date date
);

