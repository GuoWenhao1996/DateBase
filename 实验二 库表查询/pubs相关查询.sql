--1����������ѯ 
----1) ����pub����authors���ȫ����Ϣ��
select * from authors 
----2) ����������������ȫ����Ϣ�� 
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

--2����������ѯ 
----1) ����titles����ȫ����ż������� 
select title_id ���,title ���� from titles
----2) ����titles ���м۸���$15��18 Ԫ֮������������ 
select title ���� from titles where price >=15 and price<=18
----3) ����titles ����������T ��ͷ�����, ������
select title_id ���,title ���� from titles where title like 'T%'
----4) ����������������ּ򵥲�ѯ���������в�ѯ�� 
select * from authors where au_fname like 'C%'
select * from authors where au_fname like 'c%'
select au_lname ��,au_fname �� from authors where state='CA'
select * from employee where job_id=11

--3����������ѯ 
----1) ����������ʼ�ַ�ΪT���۸�С��$16Ԫ���������۸�
select title ����, price �۸� from titles where title like 'T%' and price>16
----2) ����������ʼ�ַ���ΪT��, �۸����$16Ԫ�����, �������۸� 
select title_id ���, title ����,price �۸� from titles where title not like'T%' and price>16
----3) ������������������ѯ���������в�ѯ�� 
select * from stores
select stor_name ���� from stores where stor_name like 'B%' and city ='Tustin'
select stor_name ���� from stores where stor_id like '7___' and state='CA'

--4�������Ӳ�������Ƕ�ײ�ѯ�����в�ѯ 
----1) ʹ��������titles, publishers ���в�ѯ: ���ҳ�����������Լ�������������
select A.pub_name ������, B.title ���� from publishers A, titles B where A.pub_id=B.pub_id
----2) ʹ��������authors, titleauthor, titles���в�ѯ: �������ߵ��ա�������д�������� 
select A.au_lname ��,A.au_fname ��,C.title from authors A, titleauthor B, titles C where A.au_id=B.au_id and B.title_id=C.title_id
----3) �Թ������������������������������н��в�ѯ�� 
select A.stor_name ����, C.discounttype �ۿ����� from stores A,sales B,discounts C where A.stor_id=B.stor_id and B.stor_id=C.stor_id

--5���õ�����Ĳ�ѯ��� 
----�������ߵ��ա������绰���룬���������ա������С�
select au_lname ��,au_fname ��,phone �绰 from authors order by au_lname,au_fname
----������������ļ۸񣬰�����ɴ�С�Ĵ������С�
select title ����,price �۸� from titles order by price desc
----���������������ѯ����������Ҫ�󣬸�����ѯ����� 
select * from authors order by zip
select * from authors order by zip desc

--6��ʹ�ú������в��� 
----�г��ж������顣 
select COUNT(distinct type)����������� from titles
----�г���Ķ����ж����֡�
select COUNT (distinct price)���������� from titles
----�г������͵���������ۡ� 
select title ����,price ��� from titles where price=(select MIN(price)from titles)
----��������ߵ���������ۡ�
select title ����,price ��� from titles where price=(select MAX(price)from titles)
----�г������������ܺ͡� 
select sum(ytd_sales) from titles
----����������ѯ������ͳ��Ҫ�󣬸�����ѯ�����
select count(au_id) from authors
select count(distinct au_id) from authors
select au_id from authors
select sum(price)from titles