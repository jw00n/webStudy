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




