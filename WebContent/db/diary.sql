create table Diary(
 	d_no number(5) primary key,
 	d_title varchar2(30char)  not null,
 	d_story varchar2(1000char) not null,
 	d_img varchar2(100char) not null,
 	d_writer varchar2(10char) not null,
 	d_date date not null
);


create sequence Diary_seq;


insert into Diary values(Diary_seq.nextval ,'����','����','����','����',sysdate);
insert into Diary values(Diary_seq.nextval ,'����11','����22','����22','����22',sysdate);

select * from Diary;

drop table Diary cascade constraint purge;

