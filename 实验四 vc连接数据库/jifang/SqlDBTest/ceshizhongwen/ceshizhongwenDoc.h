// ceshizhongwenDoc.h : interface of the CCeshizhongwenDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_CESHIZHONGWENDOC_H__A6F2E0F3_A3DA_4CEA_9BB2_AE599BB5A9AC__INCLUDED_)
#define AFX_CESHIZHONGWENDOC_H__A6F2E0F3_A3DA_4CEA_9BB2_AE599BB5A9AC__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
#include "ceshizhongwenSet.h"


class CCeshizhongwenDoc : public CDocument
{
protected: // create from serialization only
	CCeshizhongwenDoc();
	DECLARE_DYNCREATE(CCeshizhongwenDoc)

// Attributes
public:
	CCeshizhongwenSet m_ceshizhongwenSet;

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCeshizhongwenDoc)
	public:
	virtual BOOL OnNewDocument();
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CCeshizhongwenDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CCeshizhongwenDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CESHIZHONGWENDOC_H__A6F2E0F3_A3DA_4CEA_9BB2_AE599BB5A9AC__INCLUDED_)
