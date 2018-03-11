create table users(
   id number(4) primary key,
   name nvarchar2(50) not null,
   password nvarchar2(50),
   telephone nvarchar2(15),
   username nvarchar2(50),
   isadmin nvarchar2(5)   
);

create sequence users_seql_id;
create sequence type_seql_id;
create sequence district_seql_id;
create sequence street_seql_id;
create sequence house_seql_id;
   

insert into users(id,name,password,telephone,username,isadmin) values(users_seql_id.nextval,'zhangsan','123456','1564578123','ÕÅÈı','·ñ');


select * from users;

create table type(
   id number(4)primary key,
   name nvarchar2(50) not null
);


create table district(
   id number(4) primary key,
   name nvarchar2(50) not null   
);


create table street(
   id number(4) primary key,
   name nvarchar2(50) not null,
   district_id number(4)
);



create table house(
   id number(6) primary key,
   title nvarchar2(50),
   description nvarchar2(2000),
   price number(6),
   pubdate date,
   floorage number(4),
   contact nvarchar2(100),
   user_id number(4),
   type_id number(4),
   street_id number(4)
);




