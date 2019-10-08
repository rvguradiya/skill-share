create table status 
(id int primary key generated always as identity(start with 1,increment by 1),name varchar(100)not null);
create table user_status
(id int primary key generated always as identity(start with 1,increment by 1),name varchar(100));




create table user_account
(id int primary key generated always as identity(start with 1,increment by 1),user_name varchar(100) not null,password varchar(100)  not null,first_name varchar(100) not null,last_name varchar(100) not null,email varchar(254) not null,created timestamp,picture blob not null,last_activity timestamp,status int references user_status(id));


create table thread
(id int primary key generated always as identity (start with 1,increment by 1),subject varchar(250) not null,created_at timestamp default current_timestamp,user_id int references user_account(id),status int references status(id));
create table post
(id int primary key generated always as identity(start with 1,increment by 1),content varchar(1000),created timestamp,thread_id int references thread(id),user_id int references user_account(id),status int references status(id));