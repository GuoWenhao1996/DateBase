
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
public class Panel_xsjcgl extends JPanel {

    private JTable table = new JTable();
    private JScrollPane scrollpane = null;
    private Vector rowData = new Vector();
    private Vector columName = new Vector();

    private JButton button_chaxun_xh_jl = new JButton("奖励情况查询");
    private JLabel lable_xh = new JLabel("学号");
    private JTextField textfield_xh = new JTextField(10);
    private JButton button_chaxun_xh_cf = new JButton("惩罚情况查询");

    private JButton button_chaxun_xm_jl = new JButton("奖励情况查询");
    private JLabel lable_xm = new JLabel("姓名");
    private JTextField textfield_xm = new JTextField(10);
    private JButton button_chaxun_xm_cf = new JButton("惩罚情况查询");

    private JButton button_zengjia = new JButton("添加");
    private JButton button_shanchu = new JButton("删除");
    private JButton button_xiugai = new JButton("修改");

    protected JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();

    protected Panel_xsjcgl() {
        Information("select b.xh,xsxm,jldm,jlnr,jlsj from jlgl a,xs b where a.xh=b.xh union select b.xh,xsxm,cfdm,cfnr,cfsj from cfgl a,xs b where a.xh=b.xh");
        myEventListener();
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(horizontal);
        p1.add(lable_xh);
        p1.add(textfield_xh);
        p1.add(button_chaxun_xh_jl);
        p1.add(button_chaxun_xh_cf);
        p2.add(lable_xm);
        p2.add(textfield_xm);
        p2.add(button_chaxun_xm_jl);
        p2.add(button_chaxun_xm_cf);
        p3.add(scrollpane);
        p4.add(button_zengjia);
        p4.add(button_shanchu);
        p4.add(button_xiugai);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
    }

    protected  void Information(String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        DBHelper dbhelpr = new DBHelper();
        rowData.clear();
        columName.add("学号");
        columName.add("姓名");
        columName.add("编号");
        columName.add("详细信息");
        columName.add("日期");

        //查询奖惩表
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                Vector vNext = new Vector();
                vNext.add(dbRs.getString(1));
                vNext.add(dbRs.getString(2));
                vNext.add(dbRs.getString(3));
                vNext.add(dbRs.getString(4));
                vNext.add(dbRs.getString(5));
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

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, renderer);

        table.setPreferredScrollableViewportSize(new Dimension(850, 350));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        scrollpane = new JScrollPane(table);
    }

    private void myEventListener() {
        //学号奖励查询事件监听
        button_chaxun_xh_jl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_xm.setText("");
                if (textfield_xh.getText().equals("") || textfield_xh.getText().equals("学号不能为空！")) {
                    textfield_xh.setText("学号不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _XH = textfield_xh.getText();
                    Information("select b.xh,xsxm,jldm,jlnr,jlsj from jlgl a,xs b where a.xh=b.xh and a.xh='" + _XH + "'");
                    MainFrame.mf.repaint();
                }
            }
        });
        //学号惩罚查询事件监听
        button_chaxun_xh_cf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_xm.setText("");
                if (textfield_xh.getText().equals("") || textfield_xh.getText().equals("学号不能为空！")) {
                    textfield_xh.setText("学号不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _XH = textfield_xh.getText();
                    Information("select b.xh,xsxm,cfdm,cfnr,cfsj from cfgl a,xs b where a.xh=b.xh and b.xh='" + _XH + "'");
                    MainFrame.mf.repaint();
                }
            }
        });
        //姓名奖励查询事件监听
        button_chaxun_xm_jl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_xh.setText("");
                if (textfield_xm.getText().equals("") || textfield_xm.getText().equals("姓名不能为空！")) {
                    textfield_xm.setText("姓名不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _XM = textfield_xm.getText();
                    Information("select b.xh,xsxm,jldm,jlnr,jlsj from jlgl a,xs b where a.xh=b.xh and xsxm='" + _XM + "'");
                    MainFrame.mf.repaint();
                }
            }
        });
        //姓名惩罚查询事件监听
        button_chaxun_xm_cf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_xh.setText("");
                if (textfield_xm.getText().equals("") || textfield_xm.getText().equals("姓名不能为空！")) {
                    textfield_xm.setText("姓名不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _XM = textfield_xm.getText();
                    Information("select b.xh,xsxm,cfdm,cfnr,cfsj from cfgl a,xs b where a.xh=b.xh and xsxm ='" + _XM + "'");
                    MainFrame.mf.repaint();
                }
            }
        });
        //增加事件监听
        button_zengjia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_xsjc ax = new Add_xsjc();
                ax.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //删除事件监听
        button_shanchu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete_xsjc dx = new Delete_xsjc();
                dx.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //修改事件监听
        button_xiugai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update_xsjc ux = new Update_xsjc();
                ux.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
    }
}
