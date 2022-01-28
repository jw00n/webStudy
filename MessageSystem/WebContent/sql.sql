1. 회원가입한 정보를 저장할 수 있는 'web_member'테이블을 만드시오.
   컬럼명 : email / pw / tel / address

create table web_member(
email varchar2(100),
pw varchar2(100),
tel varchar2(100),
address varchar2(100),
constraint wm_email_pk primary key(email)
);

2. 가데이터 넣기 실행은 alt x

insert into web_member
values ('hello12@gmail.com','123','010-1234-5678','대한민국');

select * from WEB_MEMBER

--1. 메시지 저장용 테이블
create table web_message(
num number(36),
sendName varchar2(500),
receiveEmail varchar2(500),
message varchar2(500),
m_date date,
constraint wmss_num_pk primary key(num)
);

--2. num에 넣을 시퀀스 생성하시오.
-- 이름은 num_message
-- 시작숫자 1 증감숫자1
create sequence num_message
increment by 1
start with 1
;

--3. 가데이터
--num: 시퀀스
--m_date:현재시간

insert into web_message
values(num_message.nextval,'admin','smhrd@gmail.com','안내메시지 드립니다.',SYSDATE)

--4. 조회
select * from web_message order by num asc;


--

--1. 게시판 테이블
-- num,title, writer,fileName, content,b_date
create table web_board(
num number,
title varchar2(500),
writer varchar2(500),
filename varchar2(500),
content varchar2(500),
b_date date

);

create sequence num_board 
start with 1 
increment by 1

insert into web_board
values(num_board.nextval,'test','test','test','test',sysdate);

select * from WEB_BOARD