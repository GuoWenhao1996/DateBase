// ceshizhongwen.h : main header file for the CESHIZHONGWEN application
//

#if !defined(AFX_CESHIZHONGWEN_H__7569BA44_2046_4FE7_B39F_89954B7BA395__INCLUDED_)
#define AFX_CESHIZHONGWEN_H__7569BA44_2046_4FE7_B39F_89954B7BA395__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenApp:
// See ceshizhongwen.cpp for the implementation of this class
//

class CCeshizhongwenApp : public CWinApp
{
public:
	CCeshizhongwenApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCeshizhongwenApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CCeshizhongwenApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CESHIZHONGWEN_H__7569BA44_2046_4FE7_B39F_89954B7BA395__INCLUDED_)
