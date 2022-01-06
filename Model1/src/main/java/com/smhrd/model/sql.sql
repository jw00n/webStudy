-- 유저의 id, pw, nickname을 저장하는 table
create table jdbc_member
(

id varchar2(50),
pw varchar2(50) not null,
nickname varchar2(50) not null,
constraint jdbc_id_pk primary key(id)

)


-- 블럭+ alt+x
-- 가데이터
insert into JDBC_MEMBER
values('smhrd','123','스마트')

insert into JDBC_MEMBER
values('sue','123','수현')

insert into JDBC_MEMBER
values('sue2','123','수현')

select * from JDBC_MEMBER

delete from JDBC_MEMBER where nickname='수현'


