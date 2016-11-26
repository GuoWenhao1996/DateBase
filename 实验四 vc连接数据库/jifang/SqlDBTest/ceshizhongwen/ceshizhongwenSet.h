// ceshizhongwenSet.h : interface of the CCeshizhongwenSet class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_CESHIZHONGWENSET_H__FFA8078D_CF4D_4194_BF0E_DDEDA9158D86__INCLUDED_)
#define AFX_CESHIZHONGWENSET_H__FFA8078D_CF4D_4194_BF0E_DDEDA9158D86__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

class CCeshizhongwenSet : public CRecordset
{
public:
	CCeshizhongwenSet(CDatabase* pDatabase = NULL);
	DECLARE_DYNAMIC(CCeshizhongwenSet)

// Field/Param Data
	//{{AFX_FIELD(CCeshizhongwenSet, CRecordset)
	CString	m_column1;
	CTime	m_column2;
	//}}AFX_FIELD

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCeshizhongwenSet)
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

#endif // !defined(AFX_CESHIZHONGWENSET_H__FFA8078D_CF4D_4194_BF0E_DDEDA9158D86__INCLUDED_)

