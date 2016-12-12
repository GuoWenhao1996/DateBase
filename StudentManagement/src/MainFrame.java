
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guowh
 */
public class MainFrame extends JFrame {

    protected static MainFrame mf = new MainFrame();
    private JButton button_xsxxgl = new JButton("学生信息管理模块");
    private JButton button_kcgl = new JButton("课程管理模块");
    private JButton button_jxjhgl = new JButton("教学计划管理模块");
    private JButton button_xsxkgl = new JButton("学生选课管理模块");
    private JButton button_xscjgl = new JButton("学生成绩管理模块");
    private JButton button_xsjcgl = new JButton("学生奖惩管理模块");
    private JLabel lable_huanying = new JLabel("欢迎使用此系统，点击上面某个模块开始！");
    FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
    private JPanel panel_choose = new JPanel(flow);
    private JPanel panel_info = new JPanel();

    Panel_xsxxgl p_xsxxgl = new Panel_xsxxgl();
    Panel_kcgl p_kcgl = new Panel_kcgl();
    Panel_jxjhgl p_jxjhgl = new Panel_jxjhgl();
    Panel_xsxkgl p_xsxkgl = new Panel_xsxkgl();
    Panel_xscjgl p_xscjgl = new Panel_xscjgl();
    Panel_xsjcgl p_xsjcgl = new Panel_xsjcgl();

    public MainFrame() {
        super("信息管理系统");
        DBHelper dbhelpr = new DBHelper();
        //dbhelpr.TestConn();
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        myLayout();
        myEventListener();
        setVisible(true);
    }

    private void myLayout() {
        lable_huanying.setFont(new Font("Dialog", 0, 40));
        button_xsxxgl.setFont(new Font("Dialog", 0, 20));
        button_kcgl.setFont(new Font("Dialog", 0, 20));
        button_jxjhgl.setFont(new Font("Dialog", 0, 20));
        button_xsxkgl.setFont(new Font("Dialog", 0, 20));
        button_xscjgl.setFont(new Font("Dialog", 0, 20));
        button_xsjcgl.setFont(new Font("Dialog", 0, 20));
        button_xsxxgl.setBackground(Color.GRAY);
        button_kcgl.setBackground(Color.GRAY);
        button_jxjhgl.setBackground(Color.GRAY);
        button_xsxkgl.setBackground(Color.GRAY);
        button_xscjgl.setBackground(Color.GRAY);
        button_xsjcgl.setBackground(Color.GRAY);
        panel_choose.add(button_xsxxgl);
        panel_choose.add(button_kcgl);
        panel_choose.add(button_jxjhgl);
        panel_choose.add(button_xsxkgl);
        panel_choose.add(button_xscjgl);
        panel_choose.add(button_xsjcgl);
        panel_info.add(lable_huanying);
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        add(panel_choose, BorderLayout.NORTH);
        add(panel_info, BorderLayout.CENTER);
    }

    private void myEventListener() {
        //学生信息管理
        button_xsxxgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭当前button，打开其他5个button
                button_xsxxgl.setEnabled(false);
                button_kcgl.setEnabled(true);
                button_jxjhgl.setEnabled(true);
                button_xsxkgl.setEnabled(true);
                button_xscjgl.setEnabled(true);
                button_xsjcgl.setEnabled(true);
                //隐藏其余5个panel以及欢迎页
                p_kcgl.p.setVisible(false);
                p_jxjhgl.p.setVisible(false);
                p_xsxkgl.p.setVisible(false);
                p_xscjgl.p.setVisible(false);
                p_xsjcgl.p.setVisible(false);
                lable_huanying.setVisible(false);
                //添加学生信息管理Panel
                p_xsxxgl = new Panel_xsxxgl();
                panel_info.add(p_xsxxgl.p);
                setVisible(true);
            }
        });
        //课程管理
        button_kcgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭当前button，打开其他5个button
                button_xsxxgl.setEnabled(true);
                button_kcgl.setEnabled(false);
                button_jxjhgl.setEnabled(true);
                button_xsxkgl.setEnabled(true);
                button_xscjgl.setEnabled(true);
                button_xsjcgl.setEnabled(true);
                //隐藏其余5个panel以及欢迎页
                p_xsxxgl.p.setVisible(false);
                p_jxjhgl.p.setVisible(false);
                p_xsxkgl.p.setVisible(false);
                p_xscjgl.p.setVisible(false);
                p_xsjcgl.p.setVisible(false);
                lable_huanying.setVisible(false);
                //添加课程管理Panel
                p_kcgl = new Panel_kcgl();
                panel_info.add(p_kcgl.p);
                setVisible(true);
            }
        });
        //教学计划管理
        button_jxjhgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭当前button，打开其他5个button
                button_xsxxgl.setEnabled(true);
                button_kcgl.setEnabled(true);
                button_jxjhgl.setEnabled(false);
                button_xsxkgl.setEnabled(true);
                button_xscjgl.setEnabled(true);
                button_xsjcgl.setEnabled(true);
                //隐藏其余5个panel以及欢迎页
                p_xsxxgl.p.setVisible(false);
                p_kcgl.p.setVisible(false);
                p_xsxkgl.p.setVisible(false);
                p_xscjgl.p.setVisible(false);
                p_xsjcgl.p.setVisible(false);
                lable_huanying.setVisible(false);
                //添加教学计划管理Panel
                p_jxjhgl = new Panel_jxjhgl();
                panel_info.add(p_jxjhgl.p);
                setVisible(true);
            }
        });
        //学生选课管理
        button_xsxkgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭当前button，打开其他5个button
                button_xsxxgl.setEnabled(true);
                button_kcgl.setEnabled(true);
                button_jxjhgl.setEnabled(true);
                button_xsxkgl.setEnabled(false);
                button_xscjgl.setEnabled(true);
                button_xsjcgl.setEnabled(true);
                //隐藏其余5个panel以及欢迎页
                p_xsxxgl.p.setVisible(false);
                p_jxjhgl.p.setVisible(false);
                p_kcgl.p.setVisible(false);
                p_xscjgl.p.setVisible(false);
                p_xsjcgl.p.setVisible(false);
                lable_huanying.setVisible(false);
                //添加学生选课管理Panel
                p_xsxkgl = new Panel_xsxkgl();
                panel_info.add(p_xsxkgl.p);
                setVisible(true);
            }
        });
        //学生成绩管理
        button_xscjgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭当前button，打开其他5个button
                button_xsxxgl.setEnabled(true);
                button_kcgl.setEnabled(true);
                button_jxjhgl.setEnabled(true);
                button_xsxkgl.setEnabled(true);
                button_xscjgl.setEnabled(false);
                button_xsjcgl.setEnabled(true);
                //隐藏其余5个panel以及欢迎页
                p_xsxxgl.p.setVisible(false);
                p_jxjhgl.p.setVisible(false);
                p_xsxkgl.p.setVisible(false);
                p_kcgl.p.setVisible(false);
                p_xsjcgl.p.setVisible(false);
                lable_huanying.setVisible(false);
                //添加学生成绩管理Panel
                p_xscjgl = new Panel_xscjgl();
                panel_info.add(p_xscjgl.p);
                setVisible(true);
            }
        });
        //学生奖惩管理
        button_xsjcgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭当前button，打开其他5个button
                button_xsxxgl.setEnabled(true);
                button_kcgl.setEnabled(true);
                button_jxjhgl.setEnabled(true);
                button_xsxkgl.setEnabled(true);
                button_xscjgl.setEnabled(true);
                button_xsjcgl.setEnabled(false);
                //隐藏其余5个panel以及欢迎页
                p_xsxxgl.p.setVisible(false);
                p_jxjhgl.p.setVisible(false);
                p_xsxkgl.p.setVisible(false);
                p_xscjgl.p.setVisible(false);
                p_kcgl.p.setVisible(false);
                lable_huanying.setVisible(false);
                //添加课程管理Panel
                p_xsjcgl = new Panel_xsjcgl();
                panel_info.add(p_xsjcgl.p);
                setVisible(true);
            }
        });

    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] args) {
        setLookAndFeel();
        mf.setVisible(true);
    }
}
