select * from T_User where userName='������' and userPwd='?????'
select * from T_User
delete from T_User where userName='qqq'
select loginIndex,loginTime from T_UserLogin where userName='������'
select loginIndex,loginTime from T_UserLogin where userName='������'and loginTime > '2016-12-27' and loginTime< '2016-12-28'
select loginIndex,loginTime from T_UserLogin where userName='������'and loginTime > min('2016-12-27','2016-12-28') and loginTime< max('2016-12-27','2016-12-28')
select loginIndex,loginTime from T_UserLogin where userName='������'and loginTime between '2016-12-27' and '2016-12-28'
select loginIndex,loginTime from T_UserLogin where userName='������'and loginTime between '2016-12-28' and '2016-12-27'
select loginIndex,loginTime from T_UserLogin where userName='������'and loginTime between '2016-12-27' and '2016-12-28' or loginTime between '2016-12-28' and '2016-12-27'
update T_User set userPwd='???',userPwdTiShi='111'  where userName='������'