/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  guowh
 * Created: 2016-11-28
 */
 
--使用Link_DB_Student_631406010109数据库
use Link_DB_Student_631406010109
----alter table xk alter column cj numeric(4, 1) null
----alter table xk alter column bkcj numeric(4, 1) null
----向学校表插值
--insert into xx values('001','重庆交通大学') 
--insert into xx values('002','重庆大学') 
--insert into xx values('003','重庆工商大学') 
--insert into xx values('004','重庆师范大学') 
--insert into xx values('005','重庆医科大学') 
--insert into xx values('006','重庆邮电大学')
----select * from xx 

----向学院表插值
--insert into xy values('11','001','信息科学与工程学院')
--insert into xy values('12','001','土木学院')
--insert into xy values('13','001','数学与统计学院学院')
--insert into xy values('21','002','重大的一个学院')
--insert into xy values('31','003','工商的一个学院')
--insert into xy values('41','004','重师的一个学院')
----select xydm,xymc,xxmc from xy a,xx b where a.xxdm=b.xxdm

----向专业表插值
--insert into zy values('11','11','计算机科学与技术')
--insert into zy values('12','11','通信工程')
--insert into zy values('13','11','电子信息工程')
--insert into zy values('14','11','物联网')
--insert into zy values('21','12','土木造价专业')
--insert into zy values('31','13','齿轮设计专业')
----select zydm,zymc,xymc from zy a,xy b where a.xydm=b.xydm

----向班级表插值
--insert into bj values('11','11','计科1401班')
--insert into bj values('12','11','计科1402班')
--insert into bj values('13','11','计科1403班')
--insert into bj values('14','11','计科1404班')
--insert into bj values('21','12','通信1401班')
--insert into bj values('22','12','通信1402班')
--insert into bj values('23','12','通信1403班')
--insert into bj values('31','13','电子1401班')
--insert into bj values('32','13','电子1402班')
--insert into bj values('33','13','电子1403班')
--insert into bj values('41','14','物联1401班')
--insert into bj values('42','14','物联1402班')
--insert into bj values('43','14','物联1403班')
----select bjdm,bjmc,zymc from bj a,zy b where a.zydm=b.zydm

----向政治面貌表插值
--insert into zzmm values('01','共产党员')
--insert into zzmm values('02','共青团员')
--insert into zzmm values('03','群众')
--insert into zzmm values('04','其他')
----select * from zzmm

----向民族表插值
--insert into mz values('01','汉族')
--insert into mz values('02','藏族')
--insert into mz values('03','回族')
--insert into mz values('04','其它民族')
----select * from mz

----向亲属称谓表插值
--insert into qscw values('01','父亲')
--insert into qscw values('02','母亲')
--insert into qscw values('03','姐姐')
--insert into qscw values('04','哥哥')
--insert into qscw values('05','娘娘')
--insert into qscw values('06','姨夫')
----select * from qscw

----向教师表插值
--insert into js values('T000000001','王家伟')
--insert into js values('T000000002','曹建秋')
--insert into js values('T000000003','王勇')
--insert into js values('T000000004','蒋震')
--insert into js values('T000000005','娄路')
--insert into js values('T000000006','许强')
--insert into js values('T000000007','蒋伟')
----select * from js

----向课程表插值
--insert into kc values('11','C000000001','数据库原理B',3.5)
--insert into kc values('11','C000000002','操作系统原理A',4)
--insert into kc values('11','C000000003','计算机网络原理',3.5)
--insert into kc values('11','C000000004','软件需求分析',2.5)
--insert into kc values('11','C000000005','移动互联APP',2.5)
--insert into kc values('11','C000000006','嵌入式程序设计（WMARM）',2.5)
--insert into kc values('11','C000000007','数据库及应用课程设计',2)
--insert into kc values('13','C000000008','数学建模',2.5)
----select * from kc
----select xymc,kcdm,kcmc,xf from kc a,xy b where a.xydm=b.xydm

----向专业课程表插值
--insert into zykc values('11','C000000001','11',1)
--insert into zykc values('11','C000000002','11',1)
--insert into zykc values('11','C000000003','11',1)
--insert into zykc values('11','C000000004','11',1)
--insert into zykc values('11','C000000005','11',2)
--insert into zykc values('11','C000000006','11',2)
--insert into zykc values('11','C000000007','11',2)
--insert into zykc values('13','C000000008','11',2)
----select * from zykc
----select xymc,c.kcdm,kcmc,xf from xy a,zy b,kc c,zykc d where d.kcdm=c.kcdm and a.xydm=d.xydm and b.zydm=d.zydm and zymc='计算机科学与技术' and xq=2

----向上课安排表插值
--insert into skap values('11','C000000001','T000000001','周二上午3-4节&&周四上午1-2节','20406&&20406')
--insert into skap values('11','C000000002','T000000002','周一下午7-8节&&周二下午5-6节','20203&&20423')
--insert into skap values('11','C000000003','T000000003','周三下午5-6节&&周五上午3-4节','20312&&20312')
--insert into skap values('11','C000000004','T000000004','周二下午7-8节','20510')
--insert into skap values('11','C000000005','T000000005','周五上午1-2节','20505')
--insert into skap values('11','C000000006','T000000006','周一上午1-2节&&周三上午3-4节','20505&&20505')
--insert into skap values('11','C000000007','T000000001','暂定','暂定')
--insert into skap values('13','C000000008','T000000007','周三下午7-8节&&周五下午7-8节','20505&&20505')
----select kcmc,jsxm,sksj,skjs from skap a,kc b,js c where a.kcdm=b.kcdm and a.gh=c.gh

----向学生表插值
--insert into xs values('631406010109','01','02','11','郭文浩','男','20','1996-01-01','一个来自山西的帅小伙，超帅超耿直！')
--insert into xs values('631406010102','01','02','11','莫天金','男','19','1997-01-01','一个来自重庆市的小伙子')
--insert into xs values('631406010103','01','02','11','吴国平','男','20','1996-01-01','一个来自贵州省的小伙子')
--insert into xs values('631406010124','01','02','11','王增辉','男','20','1996-01-01','一个来自江苏省的小伙子')
--insert into xs values('631406010127','02','02','11','次拉姆','女','20','1996-01-01','一个来自西藏自治区的小姑娘')
--insert into xs values('631406010115','01','03','11','肖洒益','男','20','1996-01-01','一个来自重庆市的小伙子')
--insert into xs values('631406010201','01','02','12','肖霞','女','20','1996-01-01','一个来自重庆市的小姑娘')
--insert into xs values('631406010401','01','02','14','刘翠芳','女','20','1996-01-01','一个来自山西省的小姑娘')
----select xh,xsxm,bjmc,xb,nl,csrq,mzmc,zzmmmc,jtzz from xs a,mz b,zzmm c,bj d where a.mzdm=b.mzdm and a.zzmmdm=c.zzmmdm and a.bjdm=d.bjdm
----select xh,xsxm,xxmc,xymc,zymc,bjmc,xb,nl,csrq,mzmc,zzmmmc,jtzz 
----	from xs a,mz b,zzmm c,bj d,xx e,xy f,zy g 
----	where a.mzdm=b.mzdm and a.zzmmdm=c.zzmmdm and a.bjdm=d.bjdm and e.xxdm=f.xxdm and f.xydm=g.xydm and g.zydm=d.zydm
	
----向社会关系表插值
--insert into shgx values('01','631406010109','郭某某','139********')
--insert into shgx values('02','631406010109','任某某','139********')
--insert into shgx values('01','631406010102','莫某某','185********')
--insert into shgx values('02','631406010102','某某某','187********')
--insert into shgx values('01','631406010124','王某某','137********')
--insert into shgx values('02','631406010124','某某某','184********')
--insert into shgx values('01','631406010401','刘某某','130********')
--insert into shgx values('02','631406010401','某某某','131********')
----select * from shgx
----select xsxm,chmc,qsxm,qslxfs from xs a,qscw b,shgx c where a.xh=c.xh and b.chdm=c.chdm

----向惩罚管理表插值
--insert into cfgl values('CF00000001','631406010109','2016-11-10','长得太帅处罚')
--insert into cfgl values('CF00000002','631406010109','2016-11-29','为人耿直处罚')
--insert into cfgl values('CF00000003','631406010102','2016-11-10','太呆萌处罚')
--insert into cfgl values('CF00000004','631406010124','2016-5-1','长得太丑处罚')
--insert into cfgl values('CF00000005','631406010124','2016-11-29','眉毛太浓处罚')
--insert into cfgl values('CF00000006','631406010102','2016-11-29','某某某某处罚')
--insert into cfgl values('CF00000007','631406010109','2016-11-29','熬夜写数据库处罚')
--insert into cfgl values('CF00000008','631406010401','2016-11-29','长相太美处罚')
--insert into cfgl values('CF00000009','631406010401','2016-11-29','特别贴心处罚')
----select * from cfgl
----select cfdm,b.xh,xsxm,cfsj,cfnr from cfgl a,xs b where a.xh=b.xh
----select b.xh,xsxm,jldm,jlnr,jlsj from jlgl a,xs b where a.xh=b.xh union select b.xh,xsxm,cfdm,cfnr,cfsj from cfgl a,xs b where a.xh=b.xh

----向奖励管理表插值
--insert into jlgl values('JL00000001','631406010109','2016-11-10','程序设计大赛二等奖')
--insert into jlgl values('JL00000002','631406010109','2016-11-29','熬夜写数据库奖')
--insert into jlgl values('JL00000003','631406010102','2016-11-10','程序设计大赛二等奖')
--insert into jlgl values('JL00000004','631406010124','2016-5-1','重庆市跆拳道第二名')
--insert into jlgl values('JL00000005','631406010124','2016-11-29','某某某某奖')
--insert into jlgl values('JL00000006','631406010102','2016-11-29','某某某某奖')
--insert into jlgl values('JL00000007','631406010109','2016-11-29','某某某某奖')
--insert into jlgl values('JL00000008','631406010401','2016-11-29','最佳女友奖')
--insert into jlgl values('JL00000009','631406010401','2016-11-29','某某某某奖')
----select * from jlgl
----select jldm,b.xh,xsxm,jlsj,jlnr from jlgl a,xs b where a.xh=b.xh
update jlgl set xh='' ,jlsj='' where jldm=''
update jlgl set jlsj='' where jldm=''
update jlgl set jlnr='' where jldm=''

----向选课表插值
--insert into xk values('11','C000000001','631406010109',100,null)
--insert into xk values('11','C000000002','631406010109',99,null)
--insert into xk values('11','C000000003','631406010109',99,null)
--insert into xk values('11','C000000004','631406010109',100,null)
--insert into xk values('11','C000000005','631406010109',99,null)
--insert into xk values('11','C000000006','631406010109',99,null)
--insert into xk values('11','C000000007','631406010109',99,null)
--insert into xk values('13','C000000008','631406010109',99,null)
--insert into xk values('11','C000000001','631406010102',90,null)
--insert into xk values('11','C000000002','631406010102',90,null)
--insert into xk values('11','C000000003','631406010102',90,null)
--insert into xk values('11','C000000005','631406010102',90,null)
--insert into xk values('11','C000000007','631406010102',90,null)
--insert into xk values('13','C000000008','631406010102',90,null)
--insert into xk values('11','C000000001','631406010124',80,null)
--insert into xk values('11','C000000002','631406010124',50,100)
--insert into xk values('11','C000000003','631406010124',80,null)
--insert into xk values('11','C000000006','631406010124',80,null)
--insert into xk values('11','C000000007','631406010124',80,null)
--insert into xk values('13','C000000008','631406010124',80,null)
--insert into xk values('11','C000000001','631406010401',99,null)
--insert into xk values('11','C000000002','631406010401',99,null)
--insert into xk values('11','C000000003','631406010401',100,null)
--insert into xk values('11','C000000004','631406010401',99,null)
--insert into xk values('11','C000000005','631406010401',99,null)
--insert into xk values('11','C000000006','631406010401',100,null)
--insert into xk values('11','C000000007','631406010401',99,null)
--insert into xk values('13','C000000008','631406010401',99,null)
--select * from xk
--select a.xh,xsxm,a.kcdm,kcmc,cj,bkcj from xk a,xs b,kc c where a.xh=b.xh and a.kcdm=c.kcdm
--select a.xh,xsxm,a.kcdm,kcmc,cj,bkcj from xk a,xs b,kc c where a.xh=b.xh and a.kcdm=c.kcdm and b.xsxm='郭文浩'
--select a.xh,xsxm,a.kcdm,kcmc,cj,bkcj from xk a,xs b,kc c where a.xh=b.xh and a.kcdm=c.kcdm and b.xsxm='刘翠芳'