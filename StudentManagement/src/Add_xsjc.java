
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Add_xsjc extends JFrame {

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

    private JButton button_tijiao_jl = new JButton("提交");
    private JButton button_qingkong_jl = new JButton("清空");
    private JButton button_guanbi = new JButton("关闭");
    private JButton button_tijiao_cf = new JButton("提交");
    private JButton button_qingkong_cf = new JButton("清空");

    private JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();

    public Add_xsjc() {
        super("添加学生奖惩信息");
        setSize(600, 300);
        setLocation(430, 290);
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        setResizable(false);
        setLocationRelativeTo(null);
        p.setLayout(horizontal);

        textfield_jlh.setEditable(false);
        textfield_cfh.setEditable(false);

        Get_jlh_cfh(textfield_jlh, "select jldm from jlgl");
        Get_jlh_cfh(textfield_cfh, "select cfdm from cfgl");

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
        p5.add(button_tijiao_jl);
        p5.add(button_qingkong_jl);
        p5.add(lable_zhanwei_left);
        p5.add(button_guanbi);
        p5.add(lable_zhanwei_right);
        p5.add(button_tijiao_cf);
        p5.add(button_qingkong_cf);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        add(p);
        setVisible(true);
        myWindowListener();
    }

    private void Get_jlh_cfh(JTextField JT, String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        DBHelper dbhelpr = new DBHelper();
        String NUM = null;
        //查询 奖励管理表 或 惩罚管理表
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                NUM = dbRs.getString(1);
            }
            String temp = NUM.substring(0, 2);
            Integer a = Integer.parseInt(NUM.substring(3)) + 1;
            for (int i = 0; i < 8 - a.toString().length(); i++) {
                temp = temp + "0";
            }
            JT.setText(temp + a);
            dbRs.close();
            dbState.close();
            dbhelpr.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void Add_xsjc(String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        DBHelper dbhelpr = new DBHelper();
        //插入奖惩
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbState.executeUpdate(sql);
            dbState.close();
            dbhelpr.Close();
            JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            Get_jlh_cfh(textfield_jlh, "select jldm from jlgl");
            Get_jlh_cfh(textfield_cfh, "select cfdm from cfgl");
            textfield_xh_jl.setText("");
            textfield_jlsj.setText("");
            textfield_jlnr.setText("");
            textfield_xh_cf.setText("");
            textfield_cfsj.setText("");
            textfield_cfnr.setText("");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            if (ex.getMessage().equals("从字符串转换日期和/或时间时，转换失败。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n日期请输入yyyy-mm-dd格式", "提示", JOptionPane.ERROR_MESSAGE);
            } else if (ex.getMessage().equals("INSERT 语句与 FOREIGN KEY 约束\"FK_JLGL_XSTOJL_XS\"冲突。该冲突发生于数据库\"Link_DB_Student_631406010109\"，表\"dbo.xs\", column 'xh'。")
                    || ex.getMessage().equals("INSERT 语句与 FOREIGN KEY 约束\"FK_CFGL_XSTOCF_XS\"冲突。该冲突发生于数据库\"Link_DB_Student_631406010109\"，表\"dbo.xs\", column 'xh'。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n该学号不存在，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "操作失败！\n" + ex.getMessage(), "提示", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void myWindowListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                MainFrame.mf.setVisible(true);
            }
        });
        //奖励增加事件监听
        button_tijiao_jl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_xh_jl.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "学号不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_jlsj.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "时间不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_jlnr.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "内容不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    Add_xsjc("insert into jlgl values('" + textfield_jlh.getText() + "','" + textfield_xh_jl.getText() + "','" + textfield_jlsj.getText() + "','" + textfield_jlnr.getText() + "')");
                }
            }
        });
        //惩罚增加事件监听
        button_tijiao_cf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_xh_cf.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "学号不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_cfsj.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "时间不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_cfnr.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "内容不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    Add_xsjc("insert into cfgl values('" + textfield_cfh.getText() + "','" + textfield_xh_cf.getText() + "','" + textfield_cfsj.getText() + "','" + textfield_cfnr.getText() + "')");
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
        //清空事件监听
        button_qingkong_jl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_xh_jl.setText("");
                textfield_jlsj.setText("");
                textfield_jlnr.setText("");
            }
        });
        //清空事件监听
        button_qingkong_cf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfield_xh_cf.setText("");
                textfield_cfsj.setText("");
                textfield_cfnr.setText("");
            }
        });

    }
}
