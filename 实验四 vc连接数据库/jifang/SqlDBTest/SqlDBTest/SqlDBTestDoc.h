// SqlDBTestDoc.h : interface of the CSqlDBTestDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_SQLDBTESTDOC_H__3610EFDD_8668_4329_82DA_32AE7B0CCBF5__INCLUDED_)
#define AFX_SQLDBTESTDOC_H__3610EFDD_8668_4329_82DA_32AE7B0CCBF5__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
#include "SqlDBTestSet.h"


class CSqlDBTestDoc : public CDocument
{
protected: // create from serialization only
	CSqlDBTestDoc();
	DECLARE_DYNCREATE(CSqlDBTestDoc)

// Attributes
public:
	CSqlDBTestSet m_sqlDBTestSet;

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CSqlDBTestDoc)
	public:
	virtual BOOL OnNewDocument();
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CSqlDBTestDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CSqlDBTestDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_SQLDBTESTDOC_H__3610EFDD_8668_4329_82DA_32AE7B0CCBF5__INCLUDED_)
