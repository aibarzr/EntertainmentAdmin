create table IF NOT EXISTS CONSOLES(
	id int auto_increment PRIMARY KEY,
	name varchar(25),
	brand int
);

create table IF NOT EXISTS VIDEOGAMES(
	id int auto_increment PRIMARY KEY,
	name varchar(25),
	launch date,
	PEGI varchar(3),
);

create table IF NOT EXISTS BRANDS(
	id int auto_increment PRIMARY KEY,
	name varchar(25),
	constitution date,
);