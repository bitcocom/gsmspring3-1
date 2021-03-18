create table member(
   num int primary key auto_increment, -- 번호(자동증가 컬럼)
   id varchar(20) not null,
   pass varchar(20) not null,
   name varchar(20) not null,
   age int not null,
   phone varchar(30) not null,
   email varchar(50) not null,
   unique key(id)
 );
 
insert into member(id,pass,name,age,phone,email)
values('admin','admin','관리자',30,'010-0000-0000','admin@gsm.kr');

insert into member(id,pass,name,age,phone,email)
values('bitcocom','12345','박매일',30,'010-0000-0000','admin@gsm.kr');

commit;
 
select * from member;
 --화-수(실습)/목-금(실습)