create table employee
(
code int primary key generated always as identity(start with 1,increment by 1), first_name char(20) not null, last_name char(20) not null, gender char(1) not null, is_permanent char(1) not null, city char(35) not null );