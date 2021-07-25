create table travel_Act(

	t_no number(3) primary key,
	t_placeNo number(3) not null,
	t_title varchar2(1000 char) not null,
	t_titleName varchar2(1000 char) not null,
	t_address varchar2(1000 char) not null,     
	t_restaurant varchar2(1000 char) not null,
	t_restaurantName varchar2(1000 char) not null,
	t_famous varchar2(1000 char) not null,
	t_famousName varchar2(1000 char) not null
);


create sequence travel_Act_seq;



select * from travel_Act;

drop table travel_Act cascade constraint purge;
DROP SEQUENCE travel_Act;


create table travel_Hot(

	t_no number(3) primary key,
	t_placeNo number(3) not null,
	t_title varchar2(1000 char) not null,
	t_titleName varchar2(1000 char) not null,
	t_address varchar2(1000 char) not null,     
	t_restaurant varchar2(1000 char) not null,
	t_restaurantName varchar2(1000 char) not null,
	t_famous varchar2(1000 char) not null,
	t_famousName varchar2(1000 char) not null
);

create sequence travel_Hot_seq;

select * from travel_Hot;

drop table travel_Hot cascade constraint purge;
DROP SEQUENCE travel_Hot;



create table travel_Rel(
	t_no number(3) primary key,
	t_placeNo number(3) not null,
	t_title varchar2(1000 char) not null,
	t_titleName varchar2(1000 char) not null,
	t_address varchar2(1000 char) not null,     
	t_restaurant varchar2(1000 char) not null,
	t_restaurantName varchar2(1000 char) not null,
	t_famous varchar2(1000 char) not null,
	t_famousName varchar2(1000 char) not null
	
);

create sequence travel_Rel_seq;
select * from travel_Rel;



drop table travel_Rel cascade constraint purge;
DROP sequence travel_Rel;


create table travel_Sen(

	t_no number(3) primary key,
	t_placeNo number(3) not null,
	t_title varchar2(1000 char) not null,
	t_titleName varchar2(1000 char) not null,
	t_address varchar2(1000 char) not null,     
	t_restaurant varchar2(1000 char) not null,
	t_restaurantName varchar2(1000 char) not null,
	t_famous varchar2(1000 char) not null,
	t_famousName varchar2(1000 char) not null
	
);

create sequence travel_Sen_seq;


select * from travel_Sen;

drop table travel_Sen cascade constraint purge;
DROP SEQUENCE travel_Sen;

