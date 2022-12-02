create database QLDT
go
use QLDT
go

create table Account
(
	id int identity(1,1) primary key,
	[user] nchar(50) not null,
	pass nchar(50) not null,
	author nchar(50) not null,
	
)

go

insert into account values ('hs1', '123', 'Student')
insert into account values ('hs2', '123', 'Student')
insert into account values ('te1', '123', 'Teacher')
insert into account values ('te2', '123', 'Teacher')
insert into account values ('admin', '123', 'Admin')