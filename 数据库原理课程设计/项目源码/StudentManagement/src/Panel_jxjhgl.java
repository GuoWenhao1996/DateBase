
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guowh
 */
public class Panel_jxjhgl extends JPanel {

    private JTable table = null;
    private JScrollPane scrollpane = null;
    private Vector rowData = new Vector();
    private Vector columName = new Vector();

    private JButton button_chaxun = new JButton("查询");
    private JLabel lable_zy = new JLabel("专业");
    private JLabel lable_xq = new JLabel("     学期");
    private JTextField textfield_zy = new JTextField(10);
    private JTextField textfield_xq = new JTextField(3);
    
    private JButton button_zengjia = new JButton("添加");
    private JButton button_shanchu = new JButton("删除");
    private JButton button_xiugai = new JButton("修改");

    protected JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();

    protected Panel_jxjhgl() {
        Information("select zymc,xymc,c.kcdm,kcmc,xf,xq from xy a,zy b,kc c,zykc d "
                + "where d.kcdm=c.kcdm and a.xydm=d.xydm and b.zydm=d.zydm ");
        myEventListener();
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(horizontal);
        p1.add(lable_zy);
        p1.add(textfield_zy);
        p1.add(lable_xq);
        p1.add(textfield_xq);
        p1.add(button_chaxun);
        p2.add(scrollpane);
        p3.add(button_zengjia);
        p3.add(button_shanchu);
        p3.add(button_xiugai);
        p.add(p1);
        p.add(p2);
        p.add(p3);
    }

    private void Information(String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        DBHelper dbhelpr = new DBHelper();
        columName.add("专业名称");
        columName.add("开课学院");
        columName.add("课程代码");
        columName.add("课程名称");
        columName.add("学分");
        columName.add("学期");
        rowData.clear();
        //查询专业课程管理表
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                Vector vNext = new Vector();
                vNext.add(dbRs.getString("zymc"));
                vNext.add(dbRs.getString("xymc"));
                vNext.add(dbRs.getString("kcdm"));
                vNext.add(dbRs.getString("kcmc"));
                vNext.add(dbRs.getString("xf"));
                vNext.add(dbRs.getString("xq"));
                rowData.add(vNext);
            }
            table = new JTable(rowData, columName);//数据加到表格中
            dbRs.close();
            dbState.close();
            dbhelpr.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        table.setFont(new Font("Dialog", 0, 15));

        TableColumn column = null;
        column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);
        column = table.getColumnModel().getColumn(1);
        column.setPreferredWidth(130);
        column = table.getColumnModel().getColumn(3);
        column.setPreferredWidth(200);
        column = table.getColumnModel().getColumn(5);
        column.setPreferredWidth(20);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, renderer);

        table.setPreferredScrollableViewportSize(new Dimension(800, 350));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        scrollpane = new JScrollPane(table);
    }

    private void myEventListener() {
        //查询事件监听
        button_chaxun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_zy.getText().equals("") || textfield_zy.getText().equals("专业不能为空！")) {
                    textfield_zy.setText("专业不能为空！");
                    MainFrame.mf.repaint();
                } else if (textfield_xq.getText().equals("") || textfield_xq.getText().equals("-1")) {
                    textfield_xq.setText("-1");
                    MainFrame.mf.repaint();
                } else {
                    String _ZY = textfield_zy.getText();
                    int _XQ = Integer.parseInt(textfield_xq.getText());
                    Information("select zymc,xymc,c.kcdm,kcmc,xf,xq from xy a,zy b,kc c,zykc d "
                            + "where d.kcdm=c.kcdm and a.xydm=d.xydm and b.zydm=d.zydm "
                            + "and zymc='" + _ZY + "' and xq=" + _XQ);
                    MainFrame.mf.repaint();
                }
            }
        });
         //增加事件监听
        button_zengjia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_jxjh aj = new Add_jxjh();
                aj.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //删除事件监听
        button_shanchu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete_jxjh dj = new Delete_jxjh();
                dj.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //修改事件监听
        button_xiugai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update_jxjh uj = new Update_jxjh();
                uj.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
    }
}
