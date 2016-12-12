
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
public class Panel_xsxkgl extends JPanel {

    private JTable table = new JTable();
    private JScrollPane scrollpane = null;
    private Vector rowData = new Vector();
    private Vector columName = new Vector();

    private JButton button_chaxun_xh = new JButton("查询");
    private JLabel lable_xh = new JLabel("学号");
    private JTextField textfield_xh = new JTextField(10);
    private JButton button_chaxun_kch = new JButton("查询");
    private JLabel lable_kch = new JLabel("      课程号");
    private JTextField textfield_kch = new JTextField(10);
    private JButton button_chaxun_xm = new JButton("查询");
    private JLabel lable_xm = new JLabel("姓名");
    private JTextField textfield_xm = new JTextField(10);
    private JButton button_chaxun_kcm = new JButton("查询");
    private JLabel lable_kcm = new JLabel("      课程名");
    private JTextField textfield_kcm = new JTextField(10);

    private JButton button_zengjia = new JButton("添加");
    private JButton button_shanchu = new JButton("删除");
    private JButton button_xiugai = new JButton("修改");

    protected JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();

    protected Panel_xsxkgl() {
        Information("select a.xh,xsxm,a.kcdm,kcmc,xq "
                + "from xk a,xs b,kc c,zykc d "
                + "where a.xh=b.xh and a.kcdm=c.kcdm and d.kcdm=a.kcdm");
        myEventListener();
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(horizontal);
        p1.add(lable_xh);
        p1.add(textfield_xh);
        p1.add(button_chaxun_xh);
        p1.add(lable_kch);
        p1.add(textfield_kch);
        p1.add(button_chaxun_kch);
        p2.add(lable_xm);
        p2.add(textfield_xm);
        p2.add(button_chaxun_xm);
        p2.add(lable_kcm);
        p2.add(textfield_kcm);
        p2.add(button_chaxun_kcm);
        p3.add(scrollpane);
        p4.add(button_zengjia);
        p4.add(button_shanchu);
        p4.add(button_xiugai);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
    }

    private void Information(String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        DBHelper dbhelpr = new DBHelper();
        rowData.clear();
        columName.add("学号");
        columName.add("姓名");
        columName.add("课程号");
        columName.add("课程名");
        columName.add("学期");

        //查询学生选课表
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                Vector vNext = new Vector();
                vNext.add(dbRs.getString("xh"));
                vNext.add(dbRs.getString("xsxm"));
                vNext.add(dbRs.getString("kcdm"));
                vNext.add(dbRs.getString("kcmc"));
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

        column = table.getColumnModel().getColumn(3);
        column.setPreferredWidth(300);
        column = table.getColumnModel().getColumn(4);
        column.setPreferredWidth(20);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, renderer);

        table.setPreferredScrollableViewportSize(new Dimension(700, 350));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        scrollpane = new JScrollPane(table);
    }

    private void myEventListener() {
        //学号查询事件监听
        button_chaxun_xh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_kch.setText("");
                textfield_kcm.setText("");
                textfield_xm.setText("");
                if (textfield_xh.getText().equals("") || textfield_xh.getText().equals("学号不能为空！")) {
                    textfield_xh.setText("学号不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _XH = textfield_xh.getText();
                    Information("select a.xh,xsxm,a.kcdm,kcmc,xq "
                            + "from xk a,xs b,kc c,zykc d "
                            + "where a.xh=b.xh and a.kcdm=c.kcdm and d.kcdm=a.kcdm and a.xh='" + _XH + "'");
                    MainFrame.mf.repaint();
                }
            }
        });
        //课程号查询事件监听
        button_chaxun_kch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_xh.setText("");
                textfield_kcm.setText("");
                textfield_xm.setText("");
                if (textfield_kch.getText().equals("") || textfield_kch.getText().equals("课程号不能为空！")) {
                    textfield_kch.setText("课程号不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _KCH = textfield_kch.getText();
                    Information("select a.xh,xsxm,a.kcdm,kcmc,xq "
                            + "from xk a,xs b,kc c,zykc d "
                            + "where a.xh=b.xh and a.kcdm=c.kcdm and d.kcdm=a.kcdm and a.kcdm='" + _KCH + "'");
                    MainFrame.mf.repaint();
                }
            }
        });
        //姓名查询事件监听
        button_chaxun_xm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_xh.setText("");
                textfield_kcm.setText("");
                textfield_kch.setText("");
                if (textfield_xm.getText().equals("") || textfield_xm.getText().equals("姓名不能为空！")) {
                    textfield_xm.setText("姓名不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _XM = textfield_xm.getText();
                    Information("select a.xh,xsxm,a.kcdm,kcmc,xq "
                            + "from xk a,xs b,kc c,zykc d "
                            + "where a.xh=b.xh and a.kcdm=c.kcdm and d.kcdm=a.kcdm and xsxm='" + _XM + "'");
                    MainFrame.mf.repaint();
                }
            }
        });
        //课程名查询事件监听
        button_chaxun_kcm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_xh.setText("");
                textfield_kch.setText("");
                textfield_xm.setText("");
                if (textfield_kcm.getText().equals("") || textfield_kcm.getText().equals("课程名不能为空！")) {
                    textfield_kcm.setText("课程名不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _KCM = textfield_kcm.getText();
                    Information("select a.xh,xsxm,a.kcdm,kcmc,xq "
                            + "from xk a,xs b,kc c,zykc d "
                            + "where a.xh=b.xh and a.kcdm=c.kcdm and d.kcdm=a.kcdm and kcmc like'%" + _KCM + "%'");
                    MainFrame.mf.repaint();
                }
            }
        });
         //增加事件监听
        button_zengjia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_xsxk ax = new Add_xsxk();
                ax.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //删除事件监听
        button_shanchu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete_xsxk dx = new Delete_xsxk();
                dx.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //修改事件监听
        button_xiugai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update_xsxk ux = new Update_xsxk();
                ux.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
    }
}
