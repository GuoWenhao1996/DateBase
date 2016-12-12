
import java.awt.Font;
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
public class Add_Student extends JFrame {

    Panel_xsjcgl p_xsjcgl = new Panel_xsjcgl();

    private JLabel lable_xh = new JLabel("学生学号：");
    private JLabel lable_xm = new JLabel("学生姓名：");
    private JLabel lable_xb = new JLabel("学生性别：");
    private JLabel lable_nl = new JLabel("学生年龄：");
    private JLabel lable_csrq = new JLabel("出生日期：");
    private JLabel lable_bj = new JLabel("所在班级：");
    private JLabel lable_mz = new JLabel("您的民族：");
    private JLabel lable_zzmm = new JLabel("政治面貌：");
    private JLabel lable_jl = new JLabel("个人简历：");

    private JLabel lable_bj1 = new JLabel("例：11:计科1班 23:通信3班 32:电子2班 41:物联1班 ");
    private JLabel lable_mz1 = new JLabel("例：01:汉族  02:藏族  03:回族  04:其它");
    private JLabel lable_zzmm1 = new JLabel("例：01:共产党员  02:共青团员  03:群众  04:其它");

    private JTextField textfield_xh = new JTextField(10);
    private JTextField textfield_xm = new JTextField(10);
    private JTextField textfield_xb = new JTextField(10);
    private JTextField textfield_nl = new JTextField(10);
    private JTextField textfield_csrq = new JTextField(10);
    private JTextField textfield_bj = new JTextField(10);
    private JTextField textfield_mz = new JTextField(10);
    private JTextField textfield_zzmm = new JTextField(10);
    private JTextField textfield_jl = new JTextField(10);

    private JButton button_tijiao = new JButton("提交");
    private JButton button_qingkong = new JButton("清空");
    private JButton button_guanbi = new JButton("关闭");

    private JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();
    private JPanel p6 = new JPanel();
    private JPanel p7 = new JPanel();
    private JPanel p8 = new JPanel();
    private JPanel p9 = new JPanel();
    private JPanel p10 = new JPanel();

    private JPanel p6_1 = new JPanel();
    private JPanel p7_1 = new JPanel();
    private JPanel p8_1 = new JPanel();

    public Add_Student() {
        super("添加学生基本信息");
        setSize(320, 500);
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        setResizable(false);
        setLocationRelativeTo(null);
        p.setLayout(horizontal);
        lable_bj1.setFont(new Font("Dialog", 0, 12));
        lable_mz1.setFont(new Font("Dialog", 0, 12));
        lable_zzmm1.setFont(new Font("Dialog", 0, 12));
        p1.add(lable_xh);
        p1.add(textfield_xh);
        p2.add(lable_xm);
        p2.add(textfield_xm);
        p3.add(lable_xb);
        p3.add(textfield_xb);
        p4.add(lable_nl);
        p4.add(textfield_nl);
        p5.add(lable_csrq);
        p5.add(textfield_csrq);
        p6.add(lable_bj);
        p6.add(textfield_bj);
        p7.add(lable_mz);
        p7.add(textfield_mz);
        p8.add(lable_zzmm);
        p8.add(textfield_zzmm);
        p9.add(lable_jl);
        p9.add(textfield_jl);
        p10.add(button_tijiao);
        p10.add(button_qingkong);
        p10.add(button_guanbi);
        p6_1.add(lable_bj1);
        p7_1.add(lable_mz1);
        p8_1.add(lable_zzmm1);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6_1);
        p.add(p6);
        p.add(p7_1);
        p.add(p7);
        p.add(p8_1);
        p.add(p8);
        p.add(p9);
        p.add(p10);
        add(p);
        setVisible(true);
        myWindowListener();
    }

    private void clearAll() {
        textfield_xh.setText("");
        textfield_xm.setText("");
        textfield_xb.setText("");
        textfield_nl.setText("");
        textfield_csrq.setText("");
        textfield_bj.setText("");
        textfield_mz.setText("");
        textfield_zzmm.setText("");
        textfield_jl.setText("");
    }

    private void Add_xs(String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        DBHelper dbhelpr = new DBHelper();
        //插入学生
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbState.executeUpdate(sql);
            dbState.close();
            dbhelpr.Close();
            JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            if (ex.getMessage().equals("从字符串转换日期和/或时间时，转换失败。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n日期请输入yyyy-mm-dd格式", "提示", JOptionPane.ERROR_MESSAGE);
            } else if (ex.getMessage().equals("违反了 PRIMARY KEY 约束 'PK_XS'。不能在对象 'dbo.xs' 中插入重复键。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n该学号已存在，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            } else if (ex.getMessage().equals("INSERT 语句与 FOREIGN KEY 约束\"FK_XS_BJTOXS_BJ\"冲突。该冲突发生于数据库\"Link_DB_Student_631406010109\"，表\"dbo.bj\", column 'bjdm'。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n该班级不存在，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            } else if (ex.getMessage().equals("INSERT 语句与 FOREIGN KEY 约束\"FK_XS_XSTOMZ_MZ\"冲突。该冲突发生于数据库\"Link_DB_Student_631406010109\"，表\"dbo.mz\", column 'mzdm'。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n该民族不存在，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            } else if (ex.getMessage().equals("INSERT 语句与 FOREIGN KEY 约束\"FK_XS_XSTOZZMM_ZZMM\"冲突。该冲突发生于数据库\"Link_DB_Student_631406010109\"，表\"dbo.zzmm\", column 'zzmmdm'。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n该政治面貌不存在，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
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
        //学生增加事件监听
        button_tijiao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_xh.getText().length() != 12) {
                    JOptionPane.showMessageDialog(null, "请输入12位学号！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_xm.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (!(textfield_xb.getText().toString().equals("男") || textfield_xb.getText().toString().equals("女"))) {
                    JOptionPane.showMessageDialog(null, "性别有误，请输入男/女！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_nl.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "年龄不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_csrq.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "出生日期不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_bj.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "班级不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_mz.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "民族不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_zzmm.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "政治面貌不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else if (textfield_jl.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "简历不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    Add_xs("insert into xs values('"
                            + textfield_xh.getText() + "','"
                            + textfield_mz.getText().substring(0, 2) + "','"
                            + textfield_zzmm.getText().substring(0, 2) + "','"
                            + textfield_bj.getText().substring(0, 2) + "','"
                            + textfield_xm.getText() + "','"
                            + textfield_xb.getText() + "','"
                            + textfield_nl.getText().substring(0, 2) + "','"
                            + textfield_csrq.getText() + "','"
                            + textfield_jl.getText() + "')");
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
        button_qingkong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAll();
            }
        });

    }
}
