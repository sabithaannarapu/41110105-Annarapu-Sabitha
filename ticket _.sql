show databases;
create database booking;
use booking;
create table passenger(
id int auto_increment primary key,
uname varchar(45) NOT NULL,
email varchar(45) NOT NULL,
pass varchar(45) NOT NULL,
phone int(10) NOT NULL
);
select*from passenger;

create table details(
id int auto_increment primary key,
bname varchar(45) not null,
bno int(10) not null,
cost int(20) not null,
seats int(20) not null,
board varchar(45) not null,
dest varchar(45) not null
);
select*from details;
alter table details add column jdate date NOT NULL;
insert into details values(4,"SriKrishna",102,800,40,"Hyderabad","Chennai","2024-06-24"),(5,"Ibm",103,1200,50,"Chennai","Banglore","2024-06-23");
insert into details values (6,"Vega",104,1250,50,"Chennai","Mumbai","2024-06-25"),(7,"SriKrishna",105,1500,60,"Chennai","Mumbai","2024-06-27"),(8,"Orange",106,1500,60,"Mumbai","Chennai","2024-06-26"),(9,"Orange",106,1200,50,"Banglore","Chennai","2024-06-25");


