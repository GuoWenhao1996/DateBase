--1、无条件查询 
----1) 查找pub库中authors表的全部信息。
select * from authors 
----2) 查找其他样例表中全部信息。 
select * from discounts
select * from employee
select * from jobs
select * from pub_info
select * from publishers
select * from roysched
select * from sales
select * from stores
select * from titleauthor
select * from titles

--2、简单条件查询 
----1) 查找titles表中全部书号及书名。 
select title_id 书号,title 书名 from titles
----2) 查找titles 表中价格在$15～18 元之间的书的书名。 
select title 书名 from titles where price >=15 and price<=18
----3) 查找titles 表中书名以T 开头的书号, 书名。
select title_id 书号,title 书名 from titles where title like 'T%'
----4) 对其他样例表构造各种简单查询条件，进行查询。 
select * from authors where au_fname like 'C%'
select * from authors where au_fname like 'c%'
select au_lname 姓,au_fname 名 from authors where state='CA'
select * from employee where job_id=11

--3、多条件查询 
----1) 查找书名起始字符为T，价格小于$16元的书名及价格。
select title 书名, price 价格 from titles where title like 'T%' and price>16
----2) 查找书名起始字符不为T的, 价格大于$16元的书号, 书名及价格。 
select title_id 书号, title 书名,price 价格 from titles where title not like'T%' and price>16
----3) 对其他样例表构造多个查询条件，进行查询。 
select * from stores
select stor_name 店名 from stores where stor_name like 'B%' and city ='Tustin'
select stor_name 店名 from stores where stor_id like '7___' and state='CA'

--4、用连接操作（或嵌套查询）进行查询 
----1) 使用样例表titles, publishers 进行查询: 查找出版社的名称以及所出的书名。
select A.pub_name 出版社, B.title 书名 from publishers A, titles B where A.pub_id=B.pub_id
----2) 使用样例表authors, titleauthor, titles进行查询: 查找作者的姓、名和所写的书名。 
select A.au_lname 姓,A.au_fname 名,C.title from authors A, titleauthor B, titles C where A.au_id=B.au_id and B.title_id=C.title_id
----3) 对构造其他条件，在两个以上样例表中进行查询。 
select A.stor_name 店名, C.discounttype 折扣类型 from stores A,sales B,discounts C where A.stor_id=B.stor_id and B.stor_id=C.stor_id

--5、得到排序的查询结果 
----查找作者的姓、名、电话号码，并按作者姓、名排列。
select au_lname 姓,au_fname 名,phone 电话 from authors order by au_lname,au_fname
----查找书名和书的价格，按书价由大到小的次序排列。
select title 书名,price 价格 from titles order by price desc
----对其他样例表构造查询条件、排序要求，给出查询结果。 
select * from authors order by zip
select * from authors order by zip desc

--6、使用函数进行查找 
----列出有多少类书。 
select COUNT(distinct type)书类别种类数 from titles
----列出书的定价有多少种。
select COUNT (distinct price)定价种类数 from titles
----列出书价最低的书名和书价。 
select title 书名,price 书价 from titles where price=(select MIN(price)from titles)
----查出书价最高的书名及书价。
select title 书名,price 书价 from titles where price=(select MAX(price)from titles)
----列出当年销量的总和。 
select sum(ytd_sales) from titles
----构造其他查询条件和统计要求，给出查询结果。
select count(au_id) from authors
select count(distinct au_id) from authors
select au_id from authors
select sum(price)from titles