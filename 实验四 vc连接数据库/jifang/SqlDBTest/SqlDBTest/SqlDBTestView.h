// SqlDBTestView.h : interface of the CSqlDBTestView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_SQLDBTESTVIEW_H__EC1F0F70_DE6D_450C_B848_D5A358BB82E0__INCLUDED_)
#define AFX_SQLDBTESTVIEW_H__EC1F0F70_DE6D_450C_B848_D5A358BB82E0__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

class CSqlDBTestSet;

class CSqlDBTestView : public CRecordView
{
protected: // create from serialization only
	CSqlDBTestView();
	DECLARE_DYNCREATE(CSqlDBTestView)

public:
	//{{AFX_DATA(CSqlDBTestView)
	enum { IDD = IDD_SQLDBTEST_FORM };
	CSqlDBTestSet* m_pSet;
	//}}AFX_DATA

// Attributes
public:
	CSqlDBTestDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CSqlDBTestView)
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
	virtual ~CSqlDBTestView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CSqlDBTestView)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in SqlDBTestView.cpp
inline CSqlDBTestDoc* CSqlDBTestView::GetDocument()
   { return (CSqlDBTestDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_SQLDBTESTVIEW_H__EC1F0F70_DE6D_450C_B848_D5A358BB82E0__INCLUDED_)
