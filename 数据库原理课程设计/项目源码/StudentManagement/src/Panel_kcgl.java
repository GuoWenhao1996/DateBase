
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
public class Panel_kcgl extends JPanel {

    private JTable table = new JTable();
    private JScrollPane scrollpane = null;
    private Vector rowData = new Vector();
    private Vector columName = new Vector();

    private JButton button_chaxun = new JButton("查询");
    private JLabel lable_xy = new JLabel("开课学院");
    private JTextField textfield_xy = new JTextField(10);

    private JButton button_zengjia = new JButton("添加");
    private JButton button_shanchu = new JButton("删除");
    private JButton button_xiugai = new JButton("修改");

    protected JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();

    protected Panel_kcgl() {
        Information("select xymc,kcdm,kcmc,xf from kc a,xy b where a.xydm=b.xydm");
        myEventListener();
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(horizontal);
        p1.add(lable_xy);
        p1.add(textfield_xy);
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
        columName.add("开课学院");
        columName.add("课程代码");
        columName.add("课程名称");
        columName.add("学分");
        //查询课程信息表
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                Vector vNext = new Vector();
                vNext.add(dbRs.getString("xymc"));
                vNext.add(dbRs.getString("kcdm"));
                vNext.add(dbRs.getString("kcmc"));
                vNext.add(dbRs.getString("xf"));
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
        column = table.getColumnModel().getColumn(2);
        column.setPreferredWidth(200);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, renderer);

        table.setPreferredScrollableViewportSize(new Dimension(700, 350));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        scrollpane = new JScrollPane(table);
    }

    private void myEventListener() {
        //查询事件监听
        button_chaxun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_xy.getText().equals("") || textfield_xy.getText().equals("学院不能为空！")) {
                    textfield_xy.setText("学院不能为空！");
                    MainFrame.mf.repaint();
                } else {
                    String _XY = textfield_xy.getText();
                    Information("select xymc,kcdm,kcmc,xf from kc a,xy b where a.xydm=b.xydm and xymc='" + _XY + "'");
                    MainFrame.mf.repaint();
                }
            }
        });
        //增加事件监听
        button_zengjia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_kc ak = new Add_kc();
                ak.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //删除事件监听
        button_shanchu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete_kc dk = new Delete_kc();
                dk.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
        //修改事件监听
        button_xiugai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update_kc uk = new Update_kc();
                uk.setVisible(true);
                MainFrame.mf.setVisible(false);
            }
        });
    }
}
