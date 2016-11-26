// ceshizhongwenDoc.cpp : implementation of the CCeshizhongwenDoc class
//

#include "stdafx.h"
#include "ceshizhongwen.h"

#include "ceshizhongwenSet.h"
#include "ceshizhongwenDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenDoc

IMPLEMENT_DYNCREATE(CCeshizhongwenDoc, CDocument)

BEGIN_MESSAGE_MAP(CCeshizhongwenDoc, CDocument)
	//{{AFX_MSG_MAP(CCeshizhongwenDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenDoc construction/destruction

CCeshizhongwenDoc::CCeshizhongwenDoc()
{
	// TODO: add one-time construction code here

}

CCeshizhongwenDoc::~CCeshizhongwenDoc()
{
}

BOOL CCeshizhongwenDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenDoc diagnostics

#ifdef _DEBUG
void CCeshizhongwenDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CCeshizhongwenDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenDoc commands
