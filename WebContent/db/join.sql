CREATE TABLE join(
j_id varchar2(20 char) PRIMARY KEY,
j_pw varchar2(20 char) not null,
j_name varchar2(30 char) not null,
j_add varchar2(100 char) not null,
j_phoneNum varchar2(20) not null,
j_gender varchar2(20 char) not null,
j_birth date not null
);

select * from join;
select j_name from join;

insert into join values ('Admin','Admin','Admin','����','010-3768-0032','��','1991-10-23');
insert into join values ('pred2','pred','����','����','010-3768-0032','��','1991-10-23');
insert into join values ('pred3','pred','����','����','010-3768-0032','��','1991-10-23');
insert into join values ('pred4','pred','����','����','010-3768-0032','��','1991-10-23');
insert into join values ('pred5','pred','��ȯ','����','010-3768-0032','��','1991-10-23');
insert into join values ('pred6','pred','���','����','010-3768-0032','��','1991-10-23');
insert into join values ('pred7','pred','����','����','010-3768-0032','��','1991-10-23');
insert into join values ('pred8','pred','����','����','010-3768-0032','��','1991-10-23');
insert into join values ('pred9','pred','����','����','010-3768-0032','��','1991-10-23');
insert into join values ('pred10','pred','�ܿ�','����','010-3768-0032','��','1991-10-23');


drop table join cascade constraint purge;
