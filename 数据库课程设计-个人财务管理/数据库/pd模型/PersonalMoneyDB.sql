/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     2017/1/4 20:35:37                            */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('T_ShouRu') and o.name = 'FK_T_SHOURU_YH2YHSR_T_USER')
alter table T_ShouRu
   drop constraint FK_T_SHOURU_YH2YHSR_T_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('T_UserInfo') and o.name = 'FK_T_USERIN_YH2YHXX_T_USER')
alter table T_UserInfo
   drop constraint FK_T_USERIN_YH2YHXX_T_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('T_UserLogin') and o.name = 'FK_T_USERLO_YH2YHDLXX_T_USER')
alter table T_UserLogin
   drop constraint FK_T_USERLO_YH2YHDLXX_T_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('T_ZhiChu') and o.name = 'FK_T_ZHICHU_YH2YHZC_T_USER')
alter table T_ZhiChu
   drop constraint FK_T_ZHICHU_YH2YHZC_T_USER
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('T_ShouRu')
            and   name  = 'yh2yhsr_FK'
            and   indid > 0
            and   indid < 255)
   drop index T_ShouRu.yh2yhsr_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_ShouRu')
            and   type = 'U')
   drop table T_ShouRu
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_User')
            and   type = 'U')
   drop table T_User
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_UserInfo')
            and   type = 'U')
   drop table T_UserInfo
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('T_UserLogin')
            and   name  = 'yh2yhdlxx_FK'
            and   indid > 0
            and   indid < 255)
   drop index T_UserLogin.yh2yhdlxx_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_UserLogin')
            and   type = 'U')
   drop table T_UserLogin
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('T_ZhiChu')
            and   name  = 'yh2yhzc_FK'
            and   indid > 0
            and   indid < 255)
   drop index T_ZhiChu.yh2yhzc_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('T_ZhiChu')
            and   type = 'U')
   drop table T_ZhiChu
go

/*==============================================================*/
/* Table: T_ShouRu                                              */
/*==============================================================*/
create table T_ShouRu (
   ShouRuIndex          int                  not null,
   userName             nvarchar(50)         not null,
   ShouRuTime           datetime             not null,
   ShouRuMoney          money                not null,
   ShouRuInfo           nvarchar(4000)       null,
   constraint PK_T_SHOURU primary key nonclustered (userName, ShouRuIndex)
)
go

/*==============================================================*/
/* Index: yh2yhsr_FK                                            */
/*==============================================================*/
create index yh2yhsr_FK on T_ShouRu (
userName ASC
)
go

/*==============================================================*/
/* Table: T_User                                                */
/*==============================================================*/
create table T_User (
   userName             nvarchar(50)         not null,
   userPwd              char(32)             not null,
   userPwdTiShi         text                 null,
   constraint PK_T_USER primary key nonclustered (userName)
)
go

/*==============================================================*/
/* Table: T_UserInfo                                            */
/*==============================================================*/
create table T_UserInfo (
   userName             nvarchar(50)         not null,
   xm                   nvarchar(50)         null,
   xb                   varchar(2)           null,
   nl                   varchar(3)           null,
   gzdw                 nvarchar(50)         null,
   zw                   nvarchar(50)         null,
   constraint PK_T_USERINFO primary key nonclustered (userName)
)
go

/*==============================================================*/
/* Table: T_UserLogin                                           */
/*==============================================================*/
create table T_UserLogin (
   userName             nvarchar(50)         not null,
   loginIndex           int                  not null,
   loginTime            datetime             not null,
   constraint PK_T_USERLOGIN primary key nonclustered (userName, loginIndex)
)
go

/*==============================================================*/
/* Index: yh2yhdlxx_FK                                          */
/*==============================================================*/
create index yh2yhdlxx_FK on T_UserLogin (
userName ASC
)
go

/*==============================================================*/
/* Table: T_ZhiChu                                              */
/*==============================================================*/
create table T_ZhiChu (
   ZhiChuIndex          int                  not null,
   userName             nvarchar(50)         not null,
   ZhiChuTime           datetime             not null,
   ZhiChuMoney          money                not null,
   ZhiChuInfo           nvarchar(4000)       null,
   constraint PK_T_ZHICHU primary key nonclustered (userName, ZhiChuIndex)
)
go

/*==============================================================*/
/* Index: yh2yhzc_FK                                            */
/*==============================================================*/
create index yh2yhzc_FK on T_ZhiChu (
userName ASC
)
go

alter table T_ShouRu
   add constraint FK_T_SHOURU_YH2YHSR_T_USER foreign key (userName)
      references T_User (userName)
go

alter table T_UserInfo
   add constraint FK_T_USERIN_YH2YHXX_T_USER foreign key (userName)
      references T_User (userName)
go

alter table T_UserLogin
   add constraint FK_T_USERLO_YH2YHDLXX_T_USER foreign key (userName)
      references T_User (userName)
go

alter table T_ZhiChu
   add constraint FK_T_ZHICHU_YH2YHZC_T_USER foreign key (userName)
      references T_User (userName)
go

