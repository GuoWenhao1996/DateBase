// SqlDBTestSet.h : interface of the CSqlDBTestSet class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_SQLDBTESTSET_H__C382E607_2567_495F_B30E_DCD1D15AA916__INCLUDED_)
#define AFX_SQLDBTESTSET_H__C382E607_2567_495F_B30E_DCD1D15AA916__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

class CSqlDBTestSet : public CRecordset
{
public:
	CSqlDBTestSet(CDatabase* pDatabase = NULL);
	DECLARE_DYNAMIC(CSqlDBTestSet)

// Field/Param Data
	//{{AFX_FIELD(CSqlDBTestSet, CRecordset)
	CString	m_Title;
	CString	m_author;
	CString	m_t_no;
	CString	m_price;
	long	m_QTY;
	//}}AFX_FIELD

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CSqlDBTestSet)
	public:
	virtual CString GetDefaultConnect();	// Default connection string
	virtual CString GetDefaultSQL(); 	// default SQL for Recordset
	virtual void DoFieldExchange(CFieldExchange* pFX);	// RFX support
	//}}AFX_VIRTUAL

// Implementation
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_SQLDBTESTSET_H__C382E607_2567_495F_B30E_DCD1D15AA916__INCLUDED_)

