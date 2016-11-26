; CLW file contains information for the MFC ClassWizard

[General Info]
Version=1
LastClass=CAboutDlg
LastTemplate=CDialog
NewFileInclude1=#include "stdafx.h"
NewFileInclude2=#include "SqlDBTest.h"
LastPage=0

ClassCount=9
Class1=CSqlDBTestApp
Class2=CSqlDBTestDoc
Class3=CSqlDBTestView
Class4=CMainFrame
Class6=CSqlDBTestSet
Class9=CAboutDlg

ResourceCount=7
Resource1=IDR_MAINFRAME
Resource2=IDD_ABOUTBOX
Resource7=IDD_SQLDBTEST_FORM

[CLS:CSqlDBTestApp]
Type=0
HeaderFile=SqlDBTest.h
ImplementationFile=SqlDBTest.cpp
Filter=N

[CLS:CSqlDBTestDoc]
Type=0
HeaderFile=SqlDBTestDoc.h
ImplementationFile=SqlDBTestDoc.cpp
Filter=N

[CLS:CSqlDBTestView]
Type=0
HeaderFile=SqlDBTestView.h
ImplementationFile=SqlDBTestView.cpp
Filter=D
BaseClass=CRecordView
VirtualFilter=RVWC


[CLS:CSqlDBTestSet]
Type=0
HeaderFile=SqlDBTestSet.h
ImplementationFile=SqlDBTestSet.cpp
Filter=N

[DB:CSqlDBTestSet]
DB=1
DBType=ODBC
ColumnCount=5
Column1=[Title], 12, 40
Column2=[author], 12, 20
Column3=[t_no], 1, 5
Column4=[price], 3, 21
Column5=[QTY], 4, 4


[CLS:CMainFrame]
Type=0
HeaderFile=MainFrm.h
ImplementationFile=MainFrm.cpp
Filter=T




[CLS:CAboutDlg]
Type=0
HeaderFile=SqlDBTest.cpp
ImplementationFile=SqlDBTest.cpp
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

[DLG:IDD_SQLDBTEST_FORM]
Type=1
Class=CSqlDBTestView
ControlCount=11
Control1=IDC_STATIC,static,1342308352
Control2=IDC_STATIC,static,1342308352
Control3=IDC_EDIT1,edit,1350631552
Control4=IDC_EDIT2,edit,1350631552
Control5=IDC_STATIC,static,1342308352
Control6=IDC_STATIC,static,1342308352
Control7=IDC_EDIT3,edit,1350631552
Control8=IDC_STATIC,static,1342308352
Control9=IDC_STATIC,static,1342308352
Control10=IDC_EDIT4,edit,1350631552
Control11=IDC_EDIT5,edit,1350631552

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

