/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     2016/12/1 22:24:08                           */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('bj') and o.name = 'FK_BJ_ZYTOBJ_ZY')
alter table bj
   drop constraint FK_BJ_ZYTOBJ_ZY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('cfgl') and o.name = 'FK_CFGL_XSTOCF_XS')
alter table cfgl
   drop constraint FK_CFGL_XSTOCF_XS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('jlgl') and o.name = 'FK_JLGL_XSTOJL_XS')
alter table jlgl
   drop constraint FK_JLGL_XSTOJL_XS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('kc') and o.name = 'FK_KC_XYTOKC_XY')
alter table kc
   drop constraint FK_KC_XYTOKC_XY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('shgx') and o.name = 'FK_SHGX_QSCWTOSHG_QSCW')
alter table shgx
   drop constraint FK_SHGX_QSCWTOSHG_QSCW
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('shgx') and o.name = 'FK_SHGX_XSTOSHGX_XS')
alter table shgx
   drop constraint FK_SHGX_XSTOSHGX_XS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('skap') and o.name = 'FK_SKAP_JSTOSKAP_JS')
alter table skap
   drop constraint FK_SKAP_JSTOSKAP_JS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('skap') and o.name = 'FK_SKAP_KCTOSKAP_KC')
alter table skap
   drop constraint FK_SKAP_KCTOSKAP_KC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('xk') and o.name = 'FK_XK_KCTOXK_KC')
alter table xk
   drop constraint FK_XK_KCTOXK_KC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('xk') and o.name = 'FK_XK_XSXK_XS')
alter table xk
   drop constraint FK_XK_XSXK_XS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('xs') and o.name = 'FK_XS_BJTOXS_BJ')
alter table xs
   drop constraint FK_XS_BJTOXS_BJ
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('xs') and o.name = 'FK_XS_XSTOMZ_MZ')
alter table xs
   drop constraint FK_XS_XSTOMZ_MZ
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('xs') and o.name = 'FK_XS_XSTOZZMM_ZZMM')
alter table xs
   drop constraint FK_XS_XSTOZZMM_ZZMM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('xy') and o.name = 'FK_XY_XXTOXY_XX')
alter table xy
   drop constraint FK_XY_XXTOXY_XX
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('zy') and o.name = 'FK_ZY_XYTOZY_XY')
alter table zy
   drop constraint FK_ZY_XYTOZY_XY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('zykc') and o.name = 'FK_ZYKC_KCTOZYKC_KC')
alter table zykc
   drop constraint FK_ZYKC_KCTOZYKC_KC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('zykc') and o.name = 'FK_ZYKC_ZYTOZYKC_ZY')
alter table zykc
   drop constraint FK_ZYKC_ZYTOZYKC_ZY
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('bj')
            and   name  = 'zytobj_FK'
            and   indid > 0
            and   indid < 255)
   drop index bj.zytobj_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('bj')
            and   type = 'U')
   drop table bj
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('cfgl')
            and   name  = 'xstocf_FK'
            and   indid > 0
            and   indid < 255)
   drop index cfgl.xstocf_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('cfgl')
            and   type = 'U')
   drop table cfgl
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('jlgl')
            and   name  = 'xstojl_FK'
            and   indid > 0
            and   indid < 255)
   drop index jlgl.xstojl_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('jlgl')
            and   type = 'U')
   drop table jlgl
go

if exists (select 1
            from  sysobjects
           where  id = object_id('js')
            and   type = 'U')
   drop table js
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('kc')
            and   name  = 'xytokc_FK'
            and   indid > 0
            and   indid < 255)
   drop index kc.xytokc_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('kc')
            and   type = 'U')
   drop table kc
go

if exists (select 1
            from  sysobjects
           where  id = object_id('mz')
            and   type = 'U')
   drop table mz
go

if exists (select 1
            from  sysobjects
           where  id = object_id('qscw')
            and   type = 'U')
   drop table qscw
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('shgx')
            and   name  = 'qscwtoshgx_FK'
            and   indid > 0
            and   indid < 255)
   drop index shgx.qscwtoshgx_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('shgx')
            and   name  = 'xstoshgx_FK'
            and   indid > 0
            and   indid < 255)
   drop index shgx.xstoshgx_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('shgx')
            and   type = 'U')
   drop table shgx
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('skap')
            and   name  = 'kctoskap_FK'
            and   indid > 0
            and   indid < 255)
   drop index skap.kctoskap_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('skap')
            and   name  = 'jstoskap_FK'
            and   indid > 0
            and   indid < 255)
   drop index skap.jstoskap_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('skap')
            and   type = 'U')
   drop table skap
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('xk')
            and   name  = 'kctoxk_FK'
            and   indid > 0
            and   indid < 255)
   drop index xk.kctoxk_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('xk')
            and   name  = 'xsxk_FK'
            and   indid > 0
            and   indid < 255)
   drop index xk.xsxk_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('xk')
            and   type = 'U')
   drop table xk
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('xs')
            and   name  = 'bjtoxs_FK'
            and   indid > 0
            and   indid < 255)
   drop index xs.bjtoxs_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('xs')
            and   name  = 'xstozzmm_FK'
            and   indid > 0
            and   indid < 255)
   drop index xs.xstozzmm_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('xs')
            and   name  = 'xstomz_FK'
            and   indid > 0
            and   indid < 255)
   drop index xs.xstomz_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('xs')
            and   type = 'U')
   drop table xs
go

if exists (select 1
            from  sysobjects
           where  id = object_id('xx')
            and   type = 'U')
   drop table xx
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('xy')
            and   name  = 'xxtoxy_FK'
            and   indid > 0
            and   indid < 255)
   drop index xy.xxtoxy_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('xy')
            and   type = 'U')
   drop table xy
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('zy')
            and   name  = 'xytozy_FK'
            and   indid > 0
            and   indid < 255)
   drop index zy.xytozy_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('zy')
            and   type = 'U')
   drop table zy
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('zykc')
            and   name  = 'kctozykc_FK'
            and   indid > 0
            and   indid < 255)
   drop index zykc.kctozykc_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('zykc')
            and   name  = 'zytozykc_FK'
            and   indid > 0
            and   indid < 255)
   drop index zykc.zytozykc_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('zykc')
            and   type = 'U')
   drop table zykc
go

if exists (select 1
            from  sysobjects
           where  id = object_id('zzmm')
            and   type = 'U')
   drop table zzmm
go

/*==============================================================*/
/* Table: bj                                                    */
/*==============================================================*/
create table bj (
   bjdm                 char(2)              not null,
   zydm                 char(2)              not null,
   bjmc                 varchar(50)          not null,
   constraint PK_BJ primary key nonclustered (bjdm)
)
go

/*==============================================================*/
/* Index: zytobj_FK                                             */
/*==============================================================*/
create index zytobj_FK on bj (
zydm ASC
)
go

/*==============================================================*/
/* Table: cfgl                                                  */
/*==============================================================*/
create table cfgl (
   cfdm                 char(10)             not null,
   xh                   char(12)             not null,
   cfsj                 date	             not null,
   cfnr                 varchar(200)         not null,
   constraint PK_CFGL primary key nonclustered (cfdm)
)
go

/*==============================================================*/
/* Index: xstocf_FK                                             */
/*==============================================================*/
create index xstocf_FK on cfgl (
xh ASC
)
go

/*==============================================================*/
/* Table: jlgl                                                  */
/*==============================================================*/
create table jlgl (
   jldm                 char(10)             not null,
   xh                   char(12)             not null,
   jlsj                 date	             not null,
   jlnr                 varchar(200)         not null,
   constraint PK_JLGL primary key nonclustered (jldm)
)
go

/*==============================================================*/
/* Index: xstojl_FK                                             */
/*==============================================================*/
create index xstojl_FK on jlgl (
xh ASC
)
go

/*==============================================================*/
/* Table: js                                                    */
/*==============================================================*/
create table js (
   gh                   char(10)             not null,
   jsxm                 varchar(50)          not null,
   constraint PK_JS primary key nonclustered (gh)
)
go

/*==============================================================*/
/* Table: kc                                                    */
/*==============================================================*/
create table kc (
   xydm                 char(2)              not null,
   kcdm                 char(10)             not null,
   kcmc                 varchar(60)          not null,
   xf                   numeric(4,2)         not null,
   constraint PK_KC primary key nonclustered (xydm, kcdm)
)
go

/*==============================================================*/
/* Index: xytokc_FK                                             */
/*==============================================================*/
create index xytokc_FK on kc (
xydm ASC
)
go

/*==============================================================*/
/* Table: mz                                                    */
/*==============================================================*/
create table mz (
   mzdm                 char(2)              not null,
   mzmc                 varchar(20)          not null,
   constraint PK_MZ primary key nonclustered (mzdm)
)
go

/*==============================================================*/
/* Table: qscw                                                  */
/*==============================================================*/
create table qscw (
   chdm                 char(2)              not null,
   chmc                 varchar(50)          not null,
   constraint PK_QSCW primary key nonclustered (chdm)
)
go

/*==============================================================*/
/* Table: shgx                                                  */
/*==============================================================*/
create table shgx (
   chdm                 char(2)              not null,
   xh                   char(12)             not null,
   qsxm                 varchar(50)          null,
   qslxfs               char(11)             null,
   constraint PK_SHGX primary key nonclustered (chdm, xh)
)
go

/*==============================================================*/
/* Index: xstoshgx_FK                                           */
/*==============================================================*/
create index xstoshgx_FK on shgx (
xh ASC
)
go

/*==============================================================*/
/* Index: qscwtoshgx_FK                                         */
/*==============================================================*/
create index qscwtoshgx_FK on shgx (
chdm ASC
)
go

/*==============================================================*/
/* Table: skap                                                  */
/*==============================================================*/
create table skap (
   xydm                 char(2)              not null,
   kcdm                 char(10)             not null,
   gh                   char(10)             not null,
   sksj                 varchar(40)          not null,
   skjs                 varchar(40)          not null,
   constraint PK_SKAP primary key nonclustered (xydm, kcdm, gh)
)
go

/*==============================================================*/
/* Index: jstoskap_FK                                           */
/*==============================================================*/
create index jstoskap_FK on skap (
gh ASC
)
go

/*==============================================================*/
/* Index: kctoskap_FK                                           */
/*==============================================================*/
create index kctoskap_FK on skap (
xydm ASC,
kcdm ASC
)
go

/*==============================================================*/
/* Table: xk                                                    */
/*==============================================================*/
create table xk (
   xydm                 char(2)              not null,
   kcdm                 char(10)             not null,
   xh                   char(12)             not null,
   cj                   numeric(3,1)         null,
   bkcj                 numeric(3,1)         null,
   constraint PK_XK primary key nonclustered (xydm, kcdm, xh)
)
go

/*==============================================================*/
/* Index: xsxk_FK                                               */
/*==============================================================*/
create index xsxk_FK on xk (
xh ASC
)
go

/*==============================================================*/
/* Index: kctoxk_FK                                             */
/*==============================================================*/
create index kctoxk_FK on xk (
xydm ASC,
kcdm ASC
)
go

/*==============================================================*/
/* Table: xs                                                    */
/*==============================================================*/
create table xs (
   xh                   char(12)             not null,
   mzdm                 char(2)              not null,
   zzmmdm               char(2)              not null,
   bjdm                 char(2)              not null,
   xsxm                 varchar(50)          not null,
   xb                   char(2)              not null,
   nl                   char(2)              null,
   csrq                 date	             null,
   xsjl                 varchar(1000)        null,
   constraint PK_XS primary key nonclustered (xh)
)
go

/*==============================================================*/
/* Index: xstomz_FK                                             */
/*==============================================================*/
create index xstomz_FK on xs (
mzdm ASC
)
go

/*==============================================================*/
/* Index: xstozzmm_FK                                           */
/*==============================================================*/
create index xstozzmm_FK on xs (
zzmmdm ASC
)
go

/*==============================================================*/
/* Index: bjtoxs_FK                                             */
/*==============================================================*/
create index bjtoxs_FK on xs (
bjdm ASC
)
go

/*==============================================================*/
/* Table: xx                                                    */
/*==============================================================*/
create table xx (
   xxdm                 char(3)              not null,
   xxmc                 varchar(50)          not null,
   constraint PK_XX primary key nonclustered (xxdm)
)
go

/*==============================================================*/
/* Table: xy                                                    */
/*==============================================================*/
create table xy (
   xydm                 char(2)              not null,
   xxdm                 char(3)              not null,
   xymc                 char(50)             not null,
   constraint PK_XY primary key nonclustered (xydm)
)
go

/*==============================================================*/
/* Index: xxtoxy_FK                                             */
/*==============================================================*/
create index xxtoxy_FK on xy (
xxdm ASC
)
go

/*==============================================================*/
/* Table: zy                                                    */
/*==============================================================*/
create table zy (
   zydm                 char(2)              not null,
   xydm                 char(2)              not null,
   zymc                 varchar(50)          not null,
   constraint PK_ZY primary key nonclustered (zydm)
)
go

/*==============================================================*/
/* Index: xytozy_FK                                             */
/*==============================================================*/
create index xytozy_FK on zy (
xydm ASC
)
go

/*==============================================================*/
/* Table: zykc                                                  */
/*==============================================================*/
create table zykc (
   xydm                 char(2)              not null,
   kcdm                 char(10)             not null,
   zydm                 char(2)              not null,
   xq                   smallint             not null,
   constraint PK_ZYKC primary key nonclustered (xydm, kcdm, zydm)
)
go

/*==============================================================*/
/* Index: zytozykc_FK                                           */
/*==============================================================*/
create index zytozykc_FK on zykc (
zydm ASC
)
go

/*==============================================================*/
/* Index: kctozykc_FK                                           */
/*==============================================================*/
create index kctozykc_FK on zykc (
xydm ASC,
kcdm ASC
)
go

/*==============================================================*/
/* Table: zzmm                                                  */
/*==============================================================*/
create table zzmm (
   zzmmdm               char(2)              not null,
   zzmmmc               varchar(30)          not null,
   constraint PK_ZZMM primary key nonclustered (zzmmdm)
)
go

alter table bj
   add constraint FK_BJ_ZYTOBJ_ZY foreign key (zydm)
      references zy (zydm)
go

alter table cfgl
   add constraint FK_CFGL_XSTOCF_XS foreign key (xh)
      references xs (xh)
go

alter table jlgl
   add constraint FK_JLGL_XSTOJL_XS foreign key (xh)
      references xs (xh)
go

alter table kc
   add constraint FK_KC_XYTOKC_XY foreign key (xydm)
      references xy (xydm)
go

alter table shgx
   add constraint FK_SHGX_QSCWTOSHG_QSCW foreign key (chdm)
      references qscw (chdm)
go

alter table shgx
   add constraint FK_SHGX_XSTOSHGX_XS foreign key (xh)
      references xs (xh)
go

alter table skap
   add constraint FK_SKAP_JSTOSKAP_JS foreign key (gh)
      references js (gh)
go

alter table skap
   add constraint FK_SKAP_KCTOSKAP_KC foreign key (xydm, kcdm)
      references kc (xydm, kcdm)
go

alter table xk
   add constraint FK_XK_KCTOXK_KC foreign key (xydm, kcdm)
      references kc (xydm, kcdm)
go

alter table xk
   add constraint FK_XK_XSXK_XS foreign key (xh)
      references xs (xh)
go

alter table xs
   add constraint FK_XS_BJTOXS_BJ foreign key (bjdm)
      references bj (bjdm)
go

alter table xs
   add constraint FK_XS_XSTOMZ_MZ foreign key (mzdm)
      references mz (mzdm)
go

alter table xs
   add constraint FK_XS_XSTOZZMM_ZZMM foreign key (zzmmdm)
      references zzmm (zzmmdm)
go

alter table xy
   add constraint FK_XY_XXTOXY_XX foreign key (xxdm)
      references xx (xxdm)
go

alter table zy
   add constraint FK_ZY_XYTOZY_XY foreign key (xydm)
      references xy (xydm)
go

alter table zykc
   add constraint FK_ZYKC_KCTOZYKC_KC foreign key (xydm, kcdm)
      references kc (xydm, kcdm)
go

alter table zykc
   add constraint FK_ZYKC_ZYTOZYKC_ZY foreign key (zydm)
      references zy (zydm)
go

