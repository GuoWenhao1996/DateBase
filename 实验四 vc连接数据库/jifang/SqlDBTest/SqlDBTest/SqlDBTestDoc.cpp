// SqlDBTestDoc.cpp : implementation of the CSqlDBTestDoc class
//

#include "stdafx.h"
#include "SqlDBTest.h"

#include "SqlDBTestSet.h"
#include "SqlDBTestDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestDoc

IMPLEMENT_DYNCREATE(CSqlDBTestDoc, CDocument)

BEGIN_MESSAGE_MAP(CSqlDBTestDoc, CDocument)
	//{{AFX_MSG_MAP(CSqlDBTestDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestDoc construction/destruction

CSqlDBTestDoc::CSqlDBTestDoc()
{
	// TODO: add one-time construction code here

}

CSqlDBTestDoc::~CSqlDBTestDoc()
{
}

BOOL CSqlDBTestDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestDoc diagnostics

#ifdef _DEBUG
void CSqlDBTestDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CSqlDBTestDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestDoc commands
