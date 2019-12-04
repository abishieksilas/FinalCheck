/*Script to create moviecruiser database*/
create database if not exists moviecruiser;

/*Script to use the moviecruiser database*/
use moviecruiser;

/*Script to create table user*/
create table if not exists user(
us_id int primary key not null auto_increment,
us_name varchar(100));

/*Script to create table movie*/
create table if not exists movie(
mo_id int primary key not null auto_increment,
mo_title varchar(100),
mo_box_office bigint,
mo_active varchar(3),
mo_date_of_launch date,
mo_genre varchar(45),
mo_has_teaser varchar(3));

/*Script to create table favorites*/
	create table if not exists favorites(
	fa_id int primary key not null auto_increment,
	fa_us_id int,
	fa_mo_id int,
	foreign key(fa_us_id) references user(us_id),
	foreign key(fa_mo_id) references movie(mo_id));