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




