use student
print '当前为student库'
go

--创建表T631406010109
create table T631406010109(	Title	varchar(30) not null,
							author	varchar(20) not null,
							t_no	char(5)		not null primary key,
							price	money		not null,
							QTY		int			not null)
print '建表T631406010109成功'

--在表T631406010109中插入数据
insert T631406010109 values('计算机原理','张一平','S3092',20.80,200)
insert T631406010109 values('C语言程序设计','李华','H1298',15.30,300)
insert T631406010109 values('数据库原理','王家树','D1007',22.70,150)
insert T631406010109 values('计算机网络','高明','S5690',18.90,230)
insert T631406010109 values('Artificial intelligence','P.Winston','D2008',20.50,400)
insert T631406010109 values('Expert systems','R.Ullman','H3067',17.00,370)
insert T631406010109 values('软件工程','鲁廷璋','S2005',35.00,200)
insert T631406010109 values('Fortran程序设计','顾雪峰','S5006',18.00,180)
print '8条数据插入成功'

--看一下插入的数据
select * from T631406010109

--创建表S631406010109
create table S631406010109(	T_no		char(5)	not null primary key,
							Page		int		not null,
							pub_data	date	not null)
print '建表S631406010109成功'

--在表S631406010109中插入数据
insert S631406010109 values('S3092',304,'1986')
insert S631406010109 values('D1007',280,'1993')
insert S631406010109 values('S5006',315,'1987')
insert S631406010109 values('S5690',300,'1993')
insert S631406010109 values('H1298',210,'1989')
insert S631406010109 values('D2008',358,'1994')
insert S631406010109 values('S2005',298,'1995')
insert S631406010109 values('H3067',307,'1995')
print '8条数据插入成功'

--看一下插入的数据
select * from S631406010109


--添加属性  已经有了QTY，添加一个qqq测试之后删除
alter table T631406010109 add qqq char(10) null

--（2）用alter table.alter column.改变属性title 的长度。 
alter table T631406010109 alter column title varchar(40) not null

--（3）用子查询方式建新表。表名以ST 开头, 后面为建表人学号(简记为ST** )。(新表内须包括title和price 两个属性。) 
select title,price into ST631406010109 from T631406010109
select * from ST631406010109

--（4）按t_no 建索引，索引名为IT** （**表示建表人的学号，下同）。
create index IT631406010109 on T631406010109(t_no)

--（5）用子查询方式建视图，视图名为VT** , 并在视图上查找所需信息。 
create view VT631406010109 as select * from T631406010109

--（6）删除以VT** 命名的视图。
drop view VT631406010109

--（7）删除以ST** 命名的表。 
drop table ST631406010109

--2、记录的插入、删除与更新 
--（1）同前，用子查询方式建立表ST** 。该表的属性应有t_no, title, price。 
select t_no,title,price into ST631406010109 from T631406010109

--（2）在ST** 表中插入一元组: S7028, Digital Image Processing, 36.00 
insert ST631406010109 values('S7028','Digital Image Processing',36.00)
select * from ST631406010109

--（3）删除书名为“Fortran 程序设计”的那个元组。 
delete from ST631406010109 where title='Fortran程序设计'
select * from ST631406010109

--（4）删除书号以H 开头的元组。 
delete from ST631406010109 where t_no like 'H%'
select * from ST631406010109

--（5）把书价调整到原来价格的95% 。 
update ST631406010109 set price=price*0.95
select * from ST631406010109

--（6）把书号以D 开头的那些书的书价减掉2.00元。
update ST631406010109 set price=price-2 where t_no like 'D%'
select * from ST631406010109

--（7）将“计算机原理”的书号改为S1135。 
update ST631406010109 set t_no='S1135' where title='计算机原理'
select * from ST631406010109

--（8）对所建的表，进行各种插入、删除、更新操作。 
--（9）每次修改表后，可用select 查看一下修改后表中的内容，看是否满足要求。 
--插入一元组: hhhhh,一本很贵的书, 99999.99 
insert ST631406010109 values('hhhhh','一本很贵的书',99999.99)
select * from ST631406010109

--插入一元组: lllll,一本很便宜的书, 0.99 
insert ST631406010109 values('lllll','一本很便宜的书',0.99)
select * from ST631406010109

--把'一本很贵的书'价格提高为原价的200%
update ST631406010109 set price=price*2 where title='一本很贵的书'
select * from ST631406010109

--把'一本很便宜的书'价格降低为原价的50%
update ST631406010109 set price=price*0.5 where title='一本很便宜的书'
select * from ST631406010109

--3、统计 
--（1）计算T** 表中这些书籍的最高书价、最低书价及平均书价。 
select max(price) 最高书价,min(price) 最低书价,avg(price) 平均书价 from T631406010109
select price from T631406010109

--（2）计算T** 表中的书的种类是多少。
select COUNT(t_no) 书的种类 from T631406010109
 
--（3）计算S** 表中1990年后出版的书有多少。
select COUNT(T_no) '1990年后出版的书的个数' from S631406010109 where pub_data>'1990'
 
--（4）计算总共有多少本书。 
select sum(QTY) 书的总数 from T631406010109

--（5）对样例表，设计统计要求，获得各种统计量。
--查询出这些书各买一本多少钱
select sum(price) 总价 from T631406010109

--查询出库存中所有的书一共能卖多少钱
select sum(QTY*price) 书的总价 from T631406010109

--查询出这些书籍中最多的页数、最少的页数、平均页数
select MAX(Page) 最多页数,min(Page) 最少页数,avg(Page) 平均页数 from S631406010109

--查询出最多页数的书、最少页数的书的书号
select T_no from S631406010109 
where Page in(select MAX(Page) from S631406010109)
	or Page in(select min(Page) from S631406010109)

--查询出最多页数的书、最少页数的书的书名
select title 书名 from T631406010109 
where t_no in (select T_no from S631406010109 
				where Page in(select MAX(Page) from S631406010109)
					or Page in(select min(Page) from S631406010109))
