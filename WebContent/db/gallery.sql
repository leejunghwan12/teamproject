create table photo(
p_no number(3) primary key,
p_title varchar2(30 char) not null,
p_img varchar2(100 char) not null,
p_date date not null
);



create sequence photo_seq;

insert into photo values (photo_seq.nextval,'����1','�̹���1', sysdate);
insert into photo values (photo_seq.nextval,'����2','�̹���2', sysdate);
insert into photo values (photo_seq.nextval,'����3','�̹���3', sysdate);

select * from photo order by p_no desc ;

DROP SEQUENCE photo_seq;
drop table photo cascade constraint purge;
