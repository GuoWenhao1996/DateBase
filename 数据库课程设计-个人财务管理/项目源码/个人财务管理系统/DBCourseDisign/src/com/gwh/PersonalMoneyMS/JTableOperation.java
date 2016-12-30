package com.gwh.PersonalMoneyMS;
import java.awt.BorderLayout;
//Code highlighting produced by Actipro CodeHighlighter (freeware)http://www.CodeHighlighter.com/-->import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class JTableOperation extends JFrame {
    public JTableOperation()
    {
        super();
        setTitle("表格");
        setBounds(100,100,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane();   //支持滚动
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        String[] columnNames = {"A","B","C","D","E","F","G"};
        Vector columnNameV = new Vector();    //获得表头
        for(int column = 0;column<columnNames.length;column++)
        {
            columnNameV.add(columnNames[column]);
        }
        Vector tableValueV = new Vector();
        for(int row = 1;row<21;row++)    //获得数据
        {
            Vector rowV = new Vector();
            for(int column = 0;column<columnNames.length;column++)
            {
                rowV.add(columnNames[column]+row);  //数据
            }
            tableValueV.add(rowV);
        }
        final JTable table = new JTable(tableValueV,columnNameV);   //自定义的表格
        table.setRowSelectionInterval(1, 3); //设置选择中行
        table.addRowSelectionInterval(5, 5);  //追加
        scrollPane.setViewportView(table);
        JPanel buttonPanel =new JPanel();   //按钮面板
        getContentPane().add(buttonPanel,BorderLayout.SOUTH);  //在下方。
        JButton selectAllButton = new JButton("全部选择");
        selectAllButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                table.selectAll();    //选中所有的行
            }
        });
        
        buttonPanel.add(selectAllButton);
        JButton clearSelectionButton = new JButton("取消选择");
        clearSelectionButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                table.clearSelection();  //取消选择
            }
        });
        buttonPanel.add(clearSelectionButton);
        System.out.println("表格共有："+table.getRowCount()+"行 "+ table.getColumnCount()+"列");
        System.out.println("共有："+table.getSelectedRowCount()+"行被选中");
        System.out.println("第三行的状态："+table.isRowSelected(2)); //第三行
        System.out.println("第5行的状态："+table.isRowSelected(4));//第5行
        System.out.println("被选中的第一行的索引："+table.getSelectedRow());   //被选中的第一行的索引,没有选中返回-1
        int [] selectRows = table.getSelectedRows();  //获得所有被选中的索引
        System.out.println("以下为所有被选中的行:");
        for(int i=0;i<selectRows.length;i++){
            System.out.println(selectRows[i]+" ");
        }
        
        System.out.println();
        System.out.println("列移动前第2列的名称是："+table.getColumnName(1));  //第2列
        System.out.println("列移动前第2行第2列的值："+table.getValueAt(1, 1)); //2,2
        table.moveColumn(1, 5);
        System.out.println("列移动后第2列的名称："+table.getColumnName(1));
        System.out.println("列移动后第2行第2列的值："+table.getValueAt(1, 1));
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //JTableOperation
        JTableOperation jTableOperation= new JTableOperation();
        jTableOperation.setVisible(true);
    }

}