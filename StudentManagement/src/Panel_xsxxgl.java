
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
public class Panel_xsxxgl extends JPanel {

    private JTable table = null;
    private JScrollPane scrollpane = null;
    private Vector rowData = new Vector();
    private Vector columName = new Vector();

    private JButton button_chaxun = new JButton("查询");
    private JLabel lable_xh = new JLabel("学号");
    private JTextField textfield_xh = new JTextField(10);

    private JButton button_zengjia = new JButton("添加");
    private JButton button_shanchu = new JButton("删除");
    private JButton button_xiugai = new JButton("修改");

    protected JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();

    protected Panel_xsxxgl() {
        Information("select xh,xsxm,xb,bjmc,csrq,mzmc,zzmmmc,xsjl"
                + " from xs a,mz b,zzmm c,bj d"
                + " where a.mzdm=b.mzdm and a.zzmmdm=c.zzmmdm and a.bjdm=d.bjdm");
        myEventListener();
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(horizontal);
        p1.add(lable_xh);
        p1.add(textfield_xh);
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
        rowData.clear();
        columName.add("学号");
        columName.add("姓名");
        columName.add("性别");
        columName.add("班级");
        columName.add("出生日期");
        columName.add("民族");
        columName.add("政治面貌");
        columName.add("个人简历");
        //查询学生信息管理表
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                Vector vNext = new Vector();
                vNext.add(dbRs.getString("xh"));
                vNext.add(dbRs.getString("xsxm"));
                vNext.add(dbRs.getString("xb"));
                vNext.add(dbRs.getString("bjmc"));
                vNext.add(dbRs.getString("csrq"));
                vNext.add(dbRs.getString("mzmc"));
                vNext.add(dbRs.getString("zzmmmc"));
                vNext.add(dbRs.getString("xsjl"));
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
        column = table.getColumnModel().getColumn(7);
        column.setPreferredWidth(300);

        table.setPreferredScrollableViewportSize(new Dimension(1000, 350));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        scrollpane = new JScrollPane(table);
    }

    private void myEventListener() {
        //查询事件监听
        button_chaxun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_xh.getText().equals("") || textfield_xh.getText().equals("学号不能为空！")) {
                    textfield_xh.setText("学号不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _XH = textfield_xh.getText();
                    Information("select xh,xsxm,xb,bjmc,csrq,mzmc,zzmmmc,xsjl"
                            + " from xs a,mz b,zzmm c,bj d"
                            + " where a.mzdm=b.mzdm and a.zzmmdm=c.zzmmdm and a.bjdm=d.bjdm and xh='" + _XH + "'");
                    MainFrame.mf.repaint();
                }
            }
        });
        //增加事件监听
        button_zengjia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Student as = new Add_Student();
                as.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //删除事件监听
        button_shanchu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete_Student ds = new Delete_Student();
                ds.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //修改事件监听
        button_xiugai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update_Student us = new Update_Student();
                us.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
    }
}
