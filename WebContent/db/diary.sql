create table Diary(
 	d_no number(5) primary key,
 	d_title varchar2(30char)  not null,
 	d_story varchar2(1000char) not null,
 	d_img varchar2(100char) not null,
 	d_writer varchar2(10char) not null,
 	d_date date not null
);


create sequence Diary_seq;


insert into Diary values(Diary_seq.nextval ,'제목','내용','사진','수민',sysdate);
insert into Diary values(Diary_seq.nextval ,'제목11','내용22','사진22','수민22',sysdate);

select * from Diary;

drop table Diary cascade constraint purge;

