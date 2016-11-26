; CLW file contains information for the MFC ClassWizard

[General Info]
Version=1
LastClass=CAboutDlg
LastTemplate=CDialog
NewFileInclude1=#include "stdafx.h"
NewFileInclude2=#include "ceshizhongwen.h"
LastPage=0

ClassCount=9
Class1=CCeshizhongwenApp
Class2=CCeshizhongwenDoc
Class3=CCeshizhongwenView
Class4=CMainFrame
Class6=CCeshizhongwenSet
Class9=CAboutDlg

ResourceCount=7
Resource1=IDR_MAINFRAME
Resource2=IDD_ABOUTBOX
Resource7=IDD_CESHIZHONGWEN_FORM

[CLS:CCeshizhongwenApp]
Type=0
HeaderFile=ceshizhongwen.h
ImplementationFile=ceshizhongwen.cpp
Filter=N

[CLS:CCeshizhongwenDoc]
Type=0
HeaderFile=ceshizhongwenDoc.h
ImplementationFile=ceshizhongwenDoc.cpp
Filter=N

[CLS:CCeshizhongwenView]
Type=0
HeaderFile=ceshizhongwenView.h
ImplementationFile=ceshizhongwenView.cpp
Filter=D
BaseClass=CRecordView
VirtualFilter=RVWC


[CLS:CCeshizhongwenSet]
Type=0
HeaderFile=ceshizhongwenSet.h
ImplementationFile=ceshizhongwenSet.cpp
Filter=N

[DB:CCeshizhongwenSet]
DB=1
DBType=ODBC
ColumnCount=6
Column1=[学号], 1, 15
Column2=[姓名], -9, 20
Column3=[性别], -8, 2
Column4=[出生日期], 11, 16
Column5=[学生简历], -9, 1000
Column6=[社会关系], -9, 200


[CLS:CMainFrame]
Type=0
HeaderFile=MainFrm.h
ImplementationFile=MainFrm.cpp
Filter=T




[CLS:CAboutDlg]
Type=0
HeaderFile=ceshizhongwen.cpp
ImplementationFile=ceshizhongwen.cpp
Filter=D

[DLG:IDD_ABOUTBOX]
Type=1
Class=CAboutDlg
ControlCount=4
Control1=IDC_STATIC,static,1342177283
Control2=IDC_STATIC,static,1342308480
Control3=IDC_STATIC,static,1342308352
Control4=IDOK,button,1342373889

[MNU:IDR_MAINFRAME]
Type=1
Class=CMainFrame
Command1=ID_FILE_PRINT
Command2=ID_FILE_PRINT_PREVIEW
Command3=ID_FILE_PRINT_SETUP
Command4=ID_APP_EXIT
Command5=ID_EDIT_UNDO
Command6=ID_EDIT_CUT
Command7=ID_EDIT_COPY
Command8=ID_EDIT_PASTE
Command9=ID_RECORD_FIRST
Command10=ID_RECORD_PREV
Command11=ID_RECORD_NEXT
Command12=ID_RECORD_LAST
Command13=ID_VIEW_TOOLBAR
Command14=ID_VIEW_STATUS_BAR
Command15=ID_APP_ABOUT
CommandCount=15

[ACL:IDR_MAINFRAME]
Type=1
Class=CMainFrame
Command1=ID_FILE_PRINT
Command2=ID_EDIT_UNDO
Command3=ID_EDIT_CUT
Command4=ID_EDIT_COPY
Command5=ID_EDIT_PASTE
Command6=ID_EDIT_UNDO
Command7=ID_EDIT_CUT
Command8=ID_EDIT_COPY
Command9=ID_EDIT_PASTE
Command10=ID_NEXT_PANE
Command11=ID_PREV_PANE
CommandCount=11

[DLG:IDD_CESHIZHONGWEN_FORM]
Type=1
Class=CCeshizhongwenView
ControlCount=5
Control1=IDC_STATIC,static,1342308352
Control2=IDC_EDIT1,edit,1350631552
Control3=IDC_EDIT2,edit,1350631552
Control4=IDC_STATIC,static,1342308352
Control5=IDC_STATIC,static,1342308352

[TB:IDR_MAINFRAME]
Type=1
Class=?
Command1=ID_EDIT_CUT
Command2=ID_EDIT_COPY
Command3=ID_EDIT_PASTE
Command4=ID_FILE_PRINT
Command5=ID_RECORD_FIRST
Command6=ID_RECORD_PREV
Command7=ID_RECORD_NEXT
Command8=ID_RECORD_LAST
Command9=ID_APP_ABOUT
CommandCount=9

