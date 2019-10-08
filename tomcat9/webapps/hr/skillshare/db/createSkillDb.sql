create table user_account
(id int primary key generated always as identity(start with 1,increment by 1),user_name varchar(100) not null unique,email varchar(254) not null unique,password varchar(100)  not null unique,created_at timestamp default current_timestamp);
create table user_profile
(user_id int references user_account(id),city varchar(35), age int,profile_picture varchar(100) unique,designation varchar(25));
create table thread
(id int primary key generated always as identity (start with 1,increment by 1),subject varchar(150) not null,heading varchar(350) not null,content varchar(15000) not null,link varchar(150),image_path varchar(150) not null,type varchar(150) not null,created_at timestamp default current_timestamp,user_id int references user_account(id));
create table comment
(id int primary key generated always as identity(start with 1,increment by 1),content varchar(1000),created timestamp,parent_id int references thread(id),user_id int references user_account(id));





