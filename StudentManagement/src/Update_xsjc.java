
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guowh
 */
public class Update_xsjc extends JFrame {

    int i = 0;//标记点击的是奖励还是惩罚 1奖励  2惩罚
    String NUMBER = "";
    Panel_xsjcgl p_xsjcgl = new Panel_xsjcgl();

    private JLabel lable_zhanwei_left = new JLabel("          ");
    private JLabel lable_zhanwei_right = new JLabel("          ");
    private JLabel lable_jlh = new JLabel("奖励编号：");
    private JLabel lable_xh_jl = new JLabel("学生学号：");
    private JLabel lable_jlsj = new JLabel("奖励时间：");
    private JLabel lable_jlnr = new JLabel("奖励内容：");

    private JTextField textfield_jlh = new JTextField(10);
    private JTextField textfield_xh_jl = new JTextField(10);
    private JTextField textfield_jlsj = new JTextField(10);
    private JTextField textfield_jlnr = new JTextField(10);

    private JLabel lable_cfh = new JLabel("                                   惩罚编号：");
    private JLabel lable_xh_cf = new JLabel("                                   学生学号：");
    private JLabel lable_cfsj = new JLabel("                                   惩罚时间：");
    private JLabel lable_cfnr = new JLabel("                                   惩罚内容：");

    private JTextField textfield_cfh = new JTextField(10);
    private JTextField textfield_xh_cf = new JTextField(10);
    private JTextField textfield_cfsj = new JTextField(10);
    private JTextField textfield_cfnr = new JTextField(10);

    private JButton button_chakan_jl = new JButton("查看");
    private JButton button_xiugai_jl = new JButton("提交修改");
    private JButton button_guanbi = new JButton("关闭");
    private JButton button_chakan_cf = new JButton("查看");
    private JButton button_xiugai_cf = new JButton("提交修改");

    private JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();

    public Update_xsjc() {
        super("提交修改学生奖惩信息");
        setSize(600, 300);
        setLocation(430, 290);
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        setResizable(false);
        setLocationRelativeTo(null);
        p.setLayout(horizontal);

        textfield_xh_jl.setEditable(false);
        textfield_xh_cf.setEditable(false);
        textfield_jlsj.setEditable(false);
        textfield_cfsj.setEditable(false);
        textfield_jlnr.setEditable(false);
        textfield_cfnr.setEditable(false);

        button_xiugai_jl.setEnabled(false);
        button_xiugai_cf.setEnabled(false);

        textfield_xh_jl.setText("此处不用填！！！");
        textfield_xh_cf.setText("此处不用填！！！");
        textfield_jlsj.setText("此处不用填！！！");
        textfield_cfsj.setText("此处不用填！！！");
        textfield_jlnr.setText("此处不用填！！！");
        textfield_cfnr.setText("此处不用填！！！");

        p1.add(lable_jlh);
        p1.add(textfield_jlh);
        p1.add(lable_cfh);
        p1.add(textfield_cfh);
        p2.add(lable_xh_jl);
        p2.add(textfield_xh_jl);
        p2.add(lable_xh_cf);
        p2.add(textfield_xh_cf);
        p3.add(lable_jlsj);
        p3.add(textfield_jlsj);
        p3.add(lable_cfsj);
        p3.add(textfield_cfsj);
        p4.add(lable_jlnr);
        p4.add(textfield_jlnr);
        p4.add(lable_cfnr);
        p4.add(textfield_cfnr);
        p5.add(button_chakan_jl);
        p5.add(button_xiugai_jl);
        p5.add(lable_zhanwei_left);
        p5.add(button_guanbi);
        p5.add(lable_zhanwei_right);
        p5.add(button_chakan_cf);
        p5.add(button_xiugai_cf);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        add(p);
        setVisible(true);
        myWindowListener();
    }

    private void Update_xsjc(String sql1,String sql2,String sql3) {
        Connection dbConn = null;
        Statement dbState = null;
        DBHelper dbhelpr = new DBHelper();
        //提交修改奖惩
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbState.executeUpdate(sql1);
            dbState.executeUpdate(sql2);
            dbState.executeUpdate(sql3);
            dbState.close();
            dbhelpr.Close();
            JOptionPane.showMessageDialog(null, "提交修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            textfield_xh_jl.setText("此处不用填！！！");
            textfield_xh_cf.setText("此处不用填！！！");
            textfield_jlsj.setText("此处不用填！！！");
            textfield_cfsj.setText("此处不用填！！！");
            textfield_jlnr.setText("此处不用填！！！");
            textfield_cfnr.setText("此处不用填！！！");
            button_xiugai_jl.setEnabled(false);
            button_xiugai_cf.setEnabled(false);
                    textfield_xh_jl.setEditable(false);
        textfield_xh_cf.setEditable(false);
        textfield_jlsj.setEditable(false);
        textfield_cfsj.setEditable(false);
        textfield_jlnr.setEditable(false);
        textfield_cfnr.setEditable(false);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());

        }
    }

    private void Look_xsjc(String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        DBHelper dbhelpr = new DBHelper();
        //查看奖惩
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbState = dbConn.createStatement();
            dbRs = dbState.executeQuery(sql);

            if (dbRs.next()) {
                if (i == 1) {
                    textfield_xh_jl.setText(dbRs.getString(2));
                    textfield_jlsj.setText(dbRs.getString(3));
                    textfield_jlnr.setText(dbRs.getString(4));
                    button_xiugai_jl.setEnabled(true);
                    textfield_xh_jl.setEditable(true);
                    textfield_jlsj.setEditable(true);
                    textfield_jlnr.setEditable(true);
                } else {
                    textfield_xh_cf.setText(dbRs.getString(2));
                    textfield_cfsj.setText(dbRs.getString(3));
                    textfield_cfnr.setText(dbRs.getString(4));
                    button_xiugai_cf.setEnabled(true);
                    textfield_xh_cf.setEditable(true);
                    textfield_cfsj.setEditable(true);
                    textfield_cfnr.setEditable(true);
                }
            } else if (i == 1) {
                JOptionPane.showMessageDialog(null, "查看失败！\n此奖励号不存在，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "查看失败！\n此惩罚号不存在，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            }
            dbRs.close();
            dbState.close();
            dbhelpr.Close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void myWindowListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                MainFrame.mf.setVisible(true);
            }
        });
        //查看奖励事件监听
        button_chakan_jl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_jlh.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "奖励号不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    i = 1;
                    NUMBER = textfield_jlh.getText();
                    Look_xsjc("select jldm,xh,jlsj,jlnr from jlgl where jldm='" + NUMBER + "'");
                }
            }
        });
        //查看惩罚事件监听
        button_chakan_cf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_cfh.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "惩罚号不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    i = 2;
                    NUMBER = textfield_cfh.getText();
                    Look_xsjc("select cfdm,xh,cfsj,cfnr from cfgl where cfdm='" + NUMBER + "'");
                }
            }
        });
        //关闭事件监听
        button_guanbi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainFrame.mf.setVisible(true);
            }
        });
        //奖励提交修改事件监听
        button_xiugai_jl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_jlh.getText().toString().equals(NUMBER)) {
                    Update_xsjc("update jlgl set xh='"+textfield_xh_jl.getText()+"' where jldm='" + NUMBER + "'",
                                "update jlgl set jlsj='"+textfield_jlsj.getText()+"' where jldm='" + NUMBER + "'",
                                "update jlgl set jlnr='"+textfield_jlnr.getText()+"' where jldm='" + NUMBER + "'");
                } else {
                    JOptionPane.showMessageDialog(null, "奖励号已改变，请重新查询！", "提示", JOptionPane.ERROR_MESSAGE);
                    button_xiugai_jl.setEnabled(false);
                }
            }
        });
        //惩罚提交修改监听
        button_xiugai_cf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_cfh.getText().toString().equals(NUMBER)) {
                    Update_xsjc("update cfgl set xh='"+textfield_xh_cf.getText()+"' where cfdm='" + NUMBER + "'",
                                "update cfgl set cfsj='"+textfield_cfsj.getText()+"' where cfdm='" + NUMBER + "'",
                                "update cfgl set cfnr='"+textfield_cfnr.getText()+"' where cfdm='" + NUMBER + "'");                } else {
                    JOptionPane.showMessageDialog(null, "惩罚号已改变，请重新查询！", "提示", JOptionPane.ERROR_MESSAGE);
                    button_xiugai_cf.setEnabled(false);
                }
            }
        });
    }
}
