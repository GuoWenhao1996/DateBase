// ceshizhongwenView.cpp : implementation of the CCeshizhongwenView class
//

#include "stdafx.h"
#include "ceshizhongwen.h"

#include "ceshizhongwenSet.h"
#include "ceshizhongwenDoc.h"
#include "ceshizhongwenView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenView

IMPLEMENT_DYNCREATE(CCeshizhongwenView, CRecordView)

BEGIN_MESSAGE_MAP(CCeshizhongwenView, CRecordView)
	//{{AFX_MSG_MAP(CCeshizhongwenView)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CRecordView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CRecordView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CRecordView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenView construction/destruction

CCeshizhongwenView::CCeshizhongwenView()
	: CRecordView(CCeshizhongwenView::IDD)
{
	//{{AFX_DATA_INIT(CCeshizhongwenView)
	m_pSet = NULL;
	//}}AFX_DATA_INIT
	// TODO: add construction code here

}

CCeshizhongwenView::~CCeshizhongwenView()
{
}

void CCeshizhongwenView::DoDataExchange(CDataExchange* pDX)
{
	CRecordView::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CCeshizhongwenView)
	DDX_FieldText(pDX, IDC_EDIT2, m_pSet->m_column1, m_pSet);
	//}}AFX_DATA_MAP
}

BOOL CCeshizhongwenView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CRecordView::PreCreateWindow(cs);
}

void CCeshizhongwenView::OnInitialUpdate()
{
	m_pSet = &GetDocument()->m_ceshizhongwenSet;
	CRecordView::OnInitialUpdate();
	GetParentFrame()->RecalcLayout();
	ResizeParentToFit();

}

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenView printing

BOOL CCeshizhongwenView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CCeshizhongwenView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CCeshizhongwenView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenView diagnostics

#ifdef _DEBUG
void CCeshizhongwenView::AssertValid() const
{
	CRecordView::AssertValid();
}

void CCeshizhongwenView::Dump(CDumpContext& dc) const
{
	CRecordView::Dump(dc);
}

CCeshizhongwenDoc* CCeshizhongwenView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CCeshizhongwenDoc)));
	return (CCeshizhongwenDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenView database support
CRecordset* CCeshizhongwenView::OnGetRecordset()
{
	return m_pSet;
}


/////////////////////////////////////////////////////////////////////////////
// CCeshizhongwenView message handlers
