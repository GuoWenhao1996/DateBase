use student
print '��ǰΪstudent��'
go

--������T631406010109
create table T631406010109(	Title	varchar(30) not null,
							author	varchar(20) not null,
							t_no	char(5)		not null primary key,
							price	money		not null,
							QTY		int			not null)
print '����T631406010109�ɹ�'

--�ڱ�T631406010109�в�������
insert T631406010109 values('�����ԭ��','��һƽ','S3092',20.80,200)
insert T631406010109 values('C���Գ������','�','H1298',15.30,300)
insert T631406010109 values('���ݿ�ԭ��','������','D1007',22.70,150)
insert T631406010109 values('���������','����','S5690',18.90,230)
insert T631406010109 values('Artificial intelligence','P.Winston','D2008',20.50,400)
insert T631406010109 values('Expert systems','R.Ullman','H3067',17.00,370)
insert T631406010109 values('�������','³͢�','S2005',35.00,200)
insert T631406010109 values('Fortran�������','��ѩ��','S5006',18.00,180)
print '8�����ݲ���ɹ�'

--��һ�²��������
select * from T631406010109

--������S631406010109
create table S631406010109(	T_no		char(5)	not null primary key,
							Page		int		not null,
							pub_data	date	not null)
print '����S631406010109�ɹ�'

--�ڱ�S631406010109�в�������
insert S631406010109 values('S3092',304,'1986')
insert S631406010109 values('D1007',280,'1993')
insert S631406010109 values('S5006',315,'1987')
insert S631406010109 values('S5690',300,'1993')
insert S631406010109 values('H1298',210,'1989')
insert S631406010109 values('D2008',358,'1994')
insert S631406010109 values('S2005',298,'1995')
insert S631406010109 values('H3067',307,'1995')
print '8�����ݲ���ɹ�'

--��һ�²��������
select * from S631406010109


--�������  �Ѿ�����QTY�����һ��qqq����֮��ɾ��
alter table T631406010109 add qqq char(10) null

--��2����alter table.alter column.�ı�����title �ĳ��ȡ� 
alter table T631406010109 alter column title varchar(40) not null

--��3�����Ӳ�ѯ��ʽ���±�������ST ��ͷ, ����Ϊ������ѧ��(���ΪST** )��(�±��������title��price �������ԡ�) 
select title,price into ST631406010109 from T631406010109
select * from ST631406010109

--��4����t_no ��������������ΪIT** ��**��ʾ�����˵�ѧ�ţ���ͬ����
create index IT631406010109 on T631406010109(t_no)

--��5�����Ӳ�ѯ��ʽ����ͼ����ͼ��ΪVT** , ������ͼ�ϲ���������Ϣ�� 
create view VT631406010109 as select * from T631406010109

--��6��ɾ����VT** ��������ͼ��
drop view VT631406010109

--��7��ɾ����ST** �����ı� 
drop table ST631406010109

--2����¼�Ĳ��롢ɾ������� 
--��1��ͬǰ�����Ӳ�ѯ��ʽ������ST** ���ñ������Ӧ��t_no, title, price�� 
select t_no,title,price into ST631406010109 from T631406010109

--��2����ST** ���в���һԪ��: S7028, Digital Image Processing, 36.00 
insert ST631406010109 values('S7028','Digital Image Processing',36.00)
select * from ST631406010109

--��3��ɾ������Ϊ��Fortran ������ơ����Ǹ�Ԫ�顣 
delete from ST631406010109 where title='Fortran�������'
select * from ST631406010109

--��4��ɾ�������H ��ͷ��Ԫ�顣 
delete from ST631406010109 where t_no like 'H%'
select * from ST631406010109

--��5������۵�����ԭ���۸��95% �� 
update ST631406010109 set price=price*0.95
select * from ST631406010109

--��6���������D ��ͷ����Щ�����ۼ���2.00Ԫ��
update ST631406010109 set price=price-2 where t_no like 'D%'
select * from ST631406010109

--��7�����������ԭ������Ÿ�ΪS1135�� 
update ST631406010109 set t_no='S1135' where title='�����ԭ��'
select * from ST631406010109

--��8���������ı����и��ֲ��롢ɾ�������²����� 
--��9��ÿ���޸ı�󣬿���select �鿴һ���޸ĺ���е����ݣ����Ƿ�����Ҫ�� 
--����һԪ��: hhhhh,һ���ܹ����, 99999.99 
insert ST631406010109 values('hhhhh','һ���ܹ����',99999.99)
select * from ST631406010109

--����һԪ��: lllll,һ���ܱ��˵���, 0.99 
insert ST631406010109 values('lllll','һ���ܱ��˵���',0.99)
select * from ST631406010109

--��'һ���ܹ����'�۸����Ϊԭ�۵�200%
update ST631406010109 set price=price*2 where title='һ���ܹ����'
select * from ST631406010109

--��'һ���ܱ��˵���'�۸񽵵�Ϊԭ�۵�50%
update ST631406010109 set price=price*0.5 where title='һ���ܱ��˵���'
select * from ST631406010109

--3��ͳ�� 
--��1������T** ������Щ�鼮�������ۡ������ۼ�ƽ����ۡ� 
select max(price) ������,min(price) ������,avg(price) ƽ����� from T631406010109
select price from T631406010109

--��2������T** ���е���������Ƕ��١�
select COUNT(t_no) ������� from T631406010109
 
--��3������S** ����1990����������ж��١�
select COUNT(T_no) '1990���������ĸ���' from S631406010109 where pub_data>'1990'
 
--��4�������ܹ��ж��ٱ��顣 
select sum(QTY) ������� from T631406010109

--��5�������������ͳ��Ҫ�󣬻�ø���ͳ������
--��ѯ����Щ�����һ������Ǯ
select sum(price) �ܼ� from T631406010109

--��ѯ����������е���һ����������Ǯ
select sum(QTY*price) ����ܼ� from T631406010109

--��ѯ����Щ�鼮������ҳ�������ٵ�ҳ����ƽ��ҳ��
select MAX(Page) ���ҳ��,min(Page) ����ҳ��,avg(Page) ƽ��ҳ�� from S631406010109

--��ѯ�����ҳ�����顢����ҳ����������
select T_no from S631406010109 
where Page in(select MAX(Page) from S631406010109)
	or Page in(select min(Page) from S631406010109)

--��ѯ�����ҳ�����顢����ҳ�����������
select title ���� from T631406010109 
where t_no in (select T_no from S631406010109 
				where Page in(select MAX(Page) from S631406010109)
					or Page in(select min(Page) from S631406010109))
