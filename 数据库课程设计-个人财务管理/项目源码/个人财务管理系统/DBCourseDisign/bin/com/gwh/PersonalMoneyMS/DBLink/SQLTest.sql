select * from T_User where userName='郭大神' and userPwd='?????'
select * from T_User
delete from T_User where userName='qqq'
select loginIndex,loginTime from T_UserLogin where userName='郭大神'
select loginIndex,loginTime from T_UserLogin where userName='郭大神'and loginTime > '2016-12-27' and loginTime< '2016-12-28'
select loginIndex,loginTime from T_UserLogin where userName='郭大神'and loginTime > min('2016-12-27','2016-12-28') and loginTime< max('2016-12-27','2016-12-28')
select loginIndex,loginTime from T_UserLogin where userName='郭大神'and loginTime between '2016-12-27' and '2016-12-28'
select loginIndex,loginTime from T_UserLogin where userName='郭大神'and loginTime between '2016-12-28' and '2016-12-27'
select loginIndex,loginTime from T_UserLogin where userName='郭大神'and loginTime between '2016-12-27' and '2016-12-28' or loginTime between '2016-12-28' and '2016-12-27'
update T_User set userPwd='???',userPwdTiShi='111'  where userName='郭大神'
select * from T_ZhiChu
select * from T_ShouRu

select ShouRuTime,ShouRuMoney,ShouRuInfo from T_ShouRu where userName='郭大神' 
	union select ZhiChuTime,ZhiChuMoney=-ZhiChuMoney,ZhiChuInfo from T_ZhiChu where userName='郭大神' 
	order by ShouRuTime

insert into T_ShouRu values('郭大神','2016-12-29 13:11:46',999.99,'测试增加收入')	

ShouRuIndex
ZhiChuIndex
select ShouRuIndex,ShouRuTime,ShouRuMoney,ShouRuInfo from T_ShouRu where userName='郭大神' 
	union select ZhiChuIndex,ZhiChuTime,ZhiChuMoney=-ZhiChuMoney,ZhiChuInfo from T_ZhiChu where userName='郭大神' 
	order by ShouRuTime