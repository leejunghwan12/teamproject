create table commentD (
c_no number primary key, 
c_board number not null,
c_id varchar2(50) not null,     
c_text varchar2(300) not null, 
c_rdate date not null    
);

create table commentG (
c_no number primary key, 
c_board number not null,
c_id varchar2(50) not null,     
c_text varchar2(300) not null, 
c_rdate date not null    
);


create sequence commentD_seq; 
create sequence commentG_seq; 

insert into commentD values(commentD_seq.nextval,10,'jh', '정환',sysdate);
insert into commentG values(commentG_seq.nextval,10,'jh', '정환',sysdate);

select * from commentD;
select * from commentG;



drop table commentD cascade constraint purge;
drop table commentG cascade constraint purge;
drop sequence commentD_seq;
drop sequence commentG_seq;

