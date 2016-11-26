// ceshizhongwenView.h : interface of the CCeshizhongwenView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_CESHIZHONGWENVIEW_H__6A803C48_E904_4C25_B941_3A2AE599E054__INCLUDED_)
#define AFX_CESHIZHONGWENVIEW_H__6A803C48_E904_4C25_B941_3A2AE599E054__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

class CCeshizhongwenSet;

class CCeshizhongwenView : public CRecordView
{
protected: // create from serialization only
	CCeshizhongwenView();
	DECLARE_DYNCREATE(CCeshizhongwenView)

public:
	//{{AFX_DATA(CCeshizhongwenView)
	enum { IDD = IDD_CESHIZHONGWEN_FORM };
	CCeshizhongwenSet* m_pSet;
	//}}AFX_DATA

// Attributes
public:
	CCeshizhongwenDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCeshizhongwenView)
	public:
	virtual CRecordset* OnGetRecordset();
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	virtual void OnInitialUpdate(); // called first time after construct
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CCeshizhongwenView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CCeshizhongwenView)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in ceshizhongwenView.cpp
inline CCeshizhongwenDoc* CCeshizhongwenView::GetDocument()
   { return (CCeshizhongwenDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CESHIZHONGWENVIEW_H__6A803C48_E904_4C25_B941_3A2AE599E054__INCLUDED_)
