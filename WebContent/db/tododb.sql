create table todo(

	t_no number(3) primary key,
	t_title varchar2(3000 char) not null,
	t_priority number(3) not null,
	t_names varchar2(3000 char) not null
	
);



create table done(

	d_no number(3) primary key,
	d_title varchar2(3000 char) not null,
	d_priority number(3) not null,
	d_names varchar2(3000 char) not null
	
);


create sequence todo_seq;
create sequence done_seq;


select * from todo;
select * from done;

drop table todo cascade constraint purge;
drop table done cascade constraint purge;
