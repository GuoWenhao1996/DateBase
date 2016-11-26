// SqlDBTestSet.cpp : implementation of the CSqlDBTestSet class
//

#include "stdafx.h"
#include "SqlDBTest.h"
#include "SqlDBTestSet.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestSet implementation

IMPLEMENT_DYNAMIC(CSqlDBTestSet, CRecordset)

CSqlDBTestSet::CSqlDBTestSet(CDatabase* pdb)
	: CRecordset(pdb)
{
	//{{AFX_FIELD_INIT(CSqlDBTestSet)
	m_Title = _T("");
	m_author = _T("");
	m_t_no = _T("");
	m_price = _T("");
	m_QTY = 0;
	m_nFields = 5;
	//}}AFX_FIELD_INIT
	m_nDefaultType = snapshot;
}

CString CSqlDBTestSet::GetDefaultConnect()
{
	return _T("ODBC;DSN=student_0109_gwh");
}

CString CSqlDBTestSet::GetDefaultSQL()
{
	return _T("[dbo].[T631406010109]");
}

void CSqlDBTestSet::DoFieldExchange(CFieldExchange* pFX)
{
	//{{AFX_FIELD_MAP(CSqlDBTestSet)
	pFX->SetFieldType(CFieldExchange::outputColumn);
	RFX_Text(pFX, _T("[Title]"), m_Title);
	RFX_Text(pFX, _T("[author]"), m_author);
	RFX_Text(pFX, _T("[t_no]"), m_t_no);
	RFX_Text(pFX, _T("[price]"), m_price);
	RFX_Long(pFX, _T("[QTY]"), m_QTY);
	//}}AFX_FIELD_MAP
}

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestSet diagnostics

#ifdef _DEBUG
void CSqlDBTestSet::AssertValid() const
{
	CRecordset::AssertValid();
}

void CSqlDBTestSet::Dump(CDumpContext& dc) const
{
	CRecordset::Dump(dc);
}
#endif //_DEBUG
