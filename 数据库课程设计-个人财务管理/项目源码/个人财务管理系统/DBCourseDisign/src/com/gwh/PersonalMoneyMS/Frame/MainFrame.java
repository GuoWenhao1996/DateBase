package com.gwh.PersonalMoneyMS.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.gwh.PersonalMoneyMS.DBLink.DBHelper;
import com.gwh.PersonalMoneyMS.Util.JiaMi;
import com.gwh.PersonalMoneyMS.Util.ShiJian;

public class MainFrame extends JFrame {

	protected static MainFrame mf = new MainFrame();
	protected static String USERNAME = "";

	private JButton button_grxx = new JButton("   个 人 信 息   ");
	private JButton button_szjl = new JButton("   收 支 记 录   ");
	private JButton button_srmx = new JButton("   收 入 明 细   ");
	private JButton button_zcmx = new JButton("   支 出 明 细   ");
	private JButton button_zhyaq = new JButton("   账户与安全   ");
	private JButton button_zx = new JButton("注销");

	private JLabel lable_huanying = new JLabel("欢迎使用此个人财务管理系统，请登录！");
	private JLabel lable_userName = new JLabel("用户名:");
	private JLabel lable_passworld = new JLabel("密    码:");

	private JTextField textfield_userName = new JTextField(15);
	private JPasswordField textfield_passworld = new JPasswordField(15);
	private JButton button_login = new JButton("登录");
	private JButton button_register = new JButton("注册 ");
	private JButton button_exit = new JButton("退出");

	FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
	private JPanel panel_choose = new JPanel(flow);
	private JPanel panel_info = new JPanel();

	public MainFrame() {
		super("个人财务管理系统");
		 DBHelper dbhelpr = new DBHelper();
		 dbhelpr.TestConn();
		setSize(980, 540);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myLayout();
		myEventListener();
		setVisible(true);
	}

	private void myLayout() {
		button_grxx.setFont(new Font("Dialog", 0, 20));
		button_szjl.setFont(new Font("Dialog", 0, 20));
		button_srmx.setFont(new Font("Dialog", 0, 20));
		button_zcmx.setFont(new Font("Dialog", 0, 20));
		button_zhyaq.setFont(new Font("Dialog", 0, 20));
		button_zx.setFont(new Font("Dialog", 0, 20));
		button_grxx.setBackground(Color.GRAY);
		button_szjl.setBackground(Color.GRAY);
		button_srmx.setBackground(Color.GRAY);
		button_zcmx.setBackground(Color.GRAY);
		button_zhyaq.setBackground(Color.GRAY);
		button_zx.setBackground(Color.GRAY);
		button_grxx.setForeground(Color.WHITE);
		button_szjl.setForeground(Color.WHITE);
		button_srmx.setForeground(Color.WHITE);
		button_zcmx.setForeground(Color.WHITE);
		button_zhyaq.setForeground(Color.WHITE);
		button_zx.setForeground(Color.WHITE);

		button_grxx.setEnabled(false);
		button_szjl.setEnabled(false);
		button_srmx.setEnabled(false);
		button_zcmx.setEnabled(false);
		button_zhyaq.setEnabled(false);
		button_zx.setEnabled(false);
		panel_choose.add(button_grxx);
		panel_choose.add(button_szjl);
		panel_choose.add(button_srmx);
		panel_choose.add(button_zcmx);
		panel_choose.add(button_zhyaq);
		panel_choose.add(button_zx);

		lable_huanying.setFont(new Font("Dialog", 0, 30));
		lable_userName.setFont(new Font("Dialog", 0, 20));
		lable_passworld.setFont(new Font("Dialog", 0, 20));
		textfield_userName.setFont(new Font("Dialog", 0, 20));
		textfield_passworld.setFont(new Font("Dialog", 0, 20));
		textfield_passworld.setEchoChar('*');
		button_login.setFont(new Font("Dialog", 0, 20));
		button_register.setFont(new Font("Dialog", 0, 20));
		button_exit.setFont(new Font("Dialog", 0, 20));
		// textfield_passworld.
		GridLayout grid = new GridLayout(4, 1);
		panel_info.setLayout(grid);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p1.add(lable_huanying);
		p2.add(lable_userName);
		p3.add(lable_passworld);
		p2.add(textfield_userName);
		p3.add(textfield_passworld);
		p4.add(button_login);
		p4.add(button_register);
		p4.add(button_exit);
		panel_info.add(p1);
		panel_info.add(p2);
		panel_info.add(p3);
		panel_info.add(p4);
		// BorderLayout border = new BorderLayout();
		// this.setLayout(border);
		add(panel_choose, BorderLayout.NORTH);
		add(panel_info, BorderLayout.CENTER);
	}

	private void myEventListener() {
		// 个人信息管理
		button_grxx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭当前button，打开其他4个button
				button_grxx.setEnabled(false);
				button_szjl.setEnabled(true);
				button_srmx.setEnabled(true);
				button_zcmx.setEnabled(true);
				button_zhyaq.setEnabled(true);
				// 隐藏其余4个panel

				// 添加个人信息管理Panel

			}
		});
		// 收支记录管理
		button_szjl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭当前button，打开其他4个button
				button_grxx.setEnabled(true);
				button_szjl.setEnabled(false);
				button_srmx.setEnabled(true);
				button_zcmx.setEnabled(true);
				button_zhyaq.setEnabled(true);
				// 隐藏其余4个panel

				// 添加收支记录管理Panel

			}
		});
		// 收入明细管理
		button_srmx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭当前button，打开其他4个button
				button_grxx.setEnabled(true);
				button_szjl.setEnabled(true);
				button_srmx.setEnabled(false);
				button_zcmx.setEnabled(true);
				button_zhyaq.setEnabled(true);
				// 隐藏其余4个panel

				// 添加收入明细管理Panel

			}
		});
		// 支出明细管理
		button_zcmx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭当前button，打开其他4个button
				button_grxx.setEnabled(true);
				button_szjl.setEnabled(true);
				button_srmx.setEnabled(true);
				button_zcmx.setEnabled(false);
				button_zhyaq.setEnabled(true);
				// 隐藏其余4个panel

				// 添加支出明细管理Panel

			}
		});
		// 账户与安全管理
		button_zhyaq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭当前button，打开其他4个button
				button_grxx.setEnabled(true);
				button_szjl.setEnabled(true);
				button_srmx.setEnabled(true);
				button_zcmx.setEnabled(true);
				button_zhyaq.setEnabled(false);
				// 隐藏其余4个panel

				// 添加账户与安全管理Panel

			}
		});
		// 注销
		button_zx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭所有button
				button_grxx.setEnabled(false);
				button_szjl.setEnabled(false);
				button_srmx.setEnabled(false);
				button_zcmx.setEnabled(false);
				button_zhyaq.setEnabled(false);
				button_zx.setEnabled(false);
				button_zx.setBackground(Color.GRAY);
				// 隐藏5个panel

				// 添加登录Panel
				panel_info.setVisible(true);

			}
		});
		button_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 验证登录
				if (login()) {
					// 打开6个button
					button_grxx.setEnabled(true);
					button_szjl.setEnabled(true);
					button_srmx.setEnabled(true);
					button_zcmx.setEnabled(true);
					button_zhyaq.setEnabled(true);
					button_zx.setEnabled(true);
					button_zx.setBackground(new Color(232, 17, 35));
					// 隐藏登录页
					panel_info.setVisible(true);

				} else {

				}
			}
		});
		button_register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Register r = new Register();
                r.setVisible(true);
                mf.setVisible(false);
			}
		});

	}

	private boolean login() {
		USERNAME = textfield_userName.getText();
		String PASSWORLD = "";
		PASSWORLD = JiaMi.getMD5(USERNAME);
		textfield_passworld.setText(PASSWORLD);
		textfield_userName.setText(ShiJian.getTime());
		if (textfield_passworld.equals("123"))
			return true;
		else
			return false;
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
		// MainFrame mf=new MainFrame();
		mf.setVisible(true);
	}
}
