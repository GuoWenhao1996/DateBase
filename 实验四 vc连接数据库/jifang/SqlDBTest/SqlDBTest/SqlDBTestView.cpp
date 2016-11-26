// SqlDBTestView.cpp : implementation of the CSqlDBTestView class
//

#include "stdafx.h"
#include "SqlDBTest.h"

#include "SqlDBTestSet.h"
#include "SqlDBTestDoc.h"
#include "SqlDBTestView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestView

IMPLEMENT_DYNCREATE(CSqlDBTestView, CRecordView)

BEGIN_MESSAGE_MAP(CSqlDBTestView, CRecordView)
	//{{AFX_MSG_MAP(CSqlDBTestView)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CRecordView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CRecordView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CRecordView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestView construction/destruction

CSqlDBTestView::CSqlDBTestView()
	: CRecordView(CSqlDBTestView::IDD)
{
	//{{AFX_DATA_INIT(CSqlDBTestView)
	m_pSet = NULL;
	//}}AFX_DATA_INIT
	// TODO: add construction code here

}

CSqlDBTestView::~CSqlDBTestView()
{
}

void CSqlDBTestView::DoDataExchange(CDataExchange* pDX)
{
	CRecordView::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CSqlDBTestView)
	DDX_FieldText(pDX, IDC_EDIT1, m_pSet->m_t_no, m_pSet);
	DDX_FieldText(pDX, IDC_EDIT2, m_pSet->m_Title, m_pSet);
	DDX_FieldText(pDX, IDC_EDIT3, m_pSet->m_author, m_pSet);
	DDX_FieldText(pDX, IDC_EDIT4, m_pSet->m_price, m_pSet);
	DDX_FieldText(pDX, IDC_EDIT5, m_pSet->m_QTY, m_pSet);
	//}}AFX_DATA_MAP
}

BOOL CSqlDBTestView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CRecordView::PreCreateWindow(cs);
}

void CSqlDBTestView::OnInitialUpdate()
{
	m_pSet = &GetDocument()->m_sqlDBTestSet;
	CRecordView::OnInitialUpdate();
	GetParentFrame()->RecalcLayout();
	ResizeParentToFit();

}

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestView printing

BOOL CSqlDBTestView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CSqlDBTestView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CSqlDBTestView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestView diagnostics

#ifdef _DEBUG
void CSqlDBTestView::AssertValid() const
{
	CRecordView::AssertValid();
}

void CSqlDBTestView::Dump(CDumpContext& dc) const
{
	CRecordView::Dump(dc);
}

CSqlDBTestDoc* CSqlDBTestView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CSqlDBTestDoc)));
	return (CSqlDBTestDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestView database support
CRecordset* CSqlDBTestView::OnGetRecordset()
{
	return m_pSet;
}


/////////////////////////////////////////////////////////////////////////////
// CSqlDBTestView message handlers
