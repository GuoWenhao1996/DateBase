// ceshizhongwenSet.cpp : implementation of the CCeshizhongwenSet class
//

#include "stdafx.h"
#include "ceshizhongwen.h"
#include "ceshizhongwenSet.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenSet implementation

IMPLEMENT_DYNAMIC(CCeshizhongwenSet, CRecordset)

CCeshizhongwenSet::CCeshizhongwenSet(CDatabase* pdb)
	: CRecordset(pdb)
{
	//{{AFX_FIELD_INIT(CCeshizhongwenSet)
	m_column1 = _T("");
	m_column2 = 0;
	m_nFields = 6;
	//}}AFX_FIELD_INIT
	m_nDefaultType = snapshot;
}

CString CCeshizhongwenSet::GetDefaultConnect()
{
	return _T("ODBC;DSN=TestZhongWen");
}

CString CCeshizhongwenSet::GetDefaultSQL()
{
	return _T("[dbo].[学生信息管理表]");
}

void CCeshizhongwenSet::DoFieldExchange(CFieldExchange* pFX)
{
	//{{AFX_FIELD_MAP(CCeshizhongwenSet)
	pFX->SetFieldType(CFieldExchange::outputColumn);
	RFX_Text(pFX, _T("[学号]"), m_column1);
	RFX_Date(pFX, _T("[出生日期]"), m_column2);
	//}}AFX_FIELD_MAP
}

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenSet diagnostics

#ifdef _DEBUG
void CCeshizhongwenSet::AssertValid() const
{
	CRecordset::AssertValid();
}

void CCeshizhongwenSet::Dump(CDumpContext& dc) const
{
	CRecordset::Dump(dc);
}
#endif //_DEBUG
