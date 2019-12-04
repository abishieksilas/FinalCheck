/*Script to insert data into movie table-TYUC001*/
insert into movie values(default,'Avatar',2787965087,'Yes','2017-03-15','Science Fiction','Yes'),
(default,'The Avengers',1518812988,'Yes','2017-12-23','Superhero','No'),
(default,'Titanic',2187463944,'Yes','2018-08-21','Romance','No'),
(default,'Jurassic World',1671713208,'No','2017-07-02','Science Fiction','Yes'),
(default,'Avengers:End Game',2750760348,'Yes','2022-11-02','Superhero','Yes');

/*Script to fetch data from movie table-TYUC001*/
select * from movie;

/*Script to fetch data from movie table-TYUC002*/
select mo_title,mo_has_teaser,mo_box_office,mo_genre,mo_active from movie where mo_date_of_launch <= now() and mo_active='Yes';

/*Script to fetch data from movie table-TYUC003*/
select mo_title,mo_has_teaser,mo_box_office,mo_genre,mo_active from movie where mo_id=1;

/*Script to fetch data from movie table-TYUC003*/
update movie set mo_title='Joker',mo_has_teaser='Yes',mo_box_office=3750760348,mo_genre='Thriller' where mo_id=1;

/*Script to fetch data from movie table-TYUC004*/
insert into user values(default,'Abi'),(default,'Abishiek');

/*Script to fetch data from movie table-TYUC004*/
insert into favorites values(default,1,null),(default,2,1),(default,2,2),(default,2,3);

/*Script to fetch data from movie table-TYUC005*/
SELECT movie.mo_id AS 'Id', movie.mo_title AS 'Title',movie.mo_has_teaser AS 'Has Teaser',movie.mo_box_office AS 'BoxOffice',movie.mo_genre AS 'Genre'
FROM movie INNER JOIN favorites ON movie.mo_id = favorites.fa_mo_id WHERE favorites.fa_us_id = 2;

/*Script to fetch data from menu_item table-TYUC005*/
SELECT count(movie.mo_id) FROM movie INNER JOIN favorites ON movie.mo_id = favorites.fa_mo_id WHERE favorites.fa_us_id = 2;

/*Script to fetch data from menu_item table-TYUC006*/
delete from favorites where fa_us_id=2 and  fa_mo_id=2;
