CREATE TABLE event(
e_no number(4) PRIMARY KEY,
e_name varchar2(50) not null,
e_startDate date not null,
e_endDate date not null
);

create sequence event_seq;

select * from event;




drop sequence event_seq;

drop table event cascade constraint purge;