1. ȸ�������� ������ ������ �� �ִ� 'web_member'���̺��� ����ÿ�.
   �÷��� : email / pw / tel / address

create table web_member(
email varchar2(100),
pw varchar2(100),
tel varchar2(100),
address varchar2(100),
constraint wm_email_pk primary key(email)
);

2. �������� �ֱ� ������ alt x

insert into web_member
values ('hello12@gmail.com','123','010-1234-5678','���ѹα�');

select * from WEB_MEMBER

--1. �޽��� ����� ���̺�
create table web_message(
num number(36),
sendName varchar2(500),
receiveEmail varchar2(500),
message varchar2(500),
m_date date,
constraint wmss_num_pk primary key(num)
);

--2. num�� ���� ������ �����Ͻÿ�.
-- �̸��� num_message
-- ���ۼ��� 1 ��������1
create sequence num_message
increment by 1
start with 1
;

--3. ��������
--num: ������
--m_date:����ð�

insert into web_message
values(num_message.nextval,'admin','smhrd@gmail.com','�ȳ��޽��� �帳�ϴ�.',SYSDATE)

--4. ��ȸ
select * from web_message order by num asc;


--

--1. �Խ��� ���̺�
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