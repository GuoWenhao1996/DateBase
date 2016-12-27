package com.gwh.PersonalMoneyMS.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

	private JLabel lable_huanying = new JLabel("欢迎使用此个人财务管理系统，请登录！\n\n\n");
	private JLabel lable_userName = new JLabel("用户名:");
	private JLabel lable_passworld = new JLabel("密    码:");
	private JLabel lable_passworldTiShi = new JLabel("");

	protected JTextField textfield_userName = new JTextField(15);
	private JPasswordField textfield_passworld = new JPasswordField(15);
	private JButton button_login = new JButton("登录");
	private JButton button_register = new JButton("注册 ");
	private JButton button_exit = new JButton("退出");

	FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
	private JPanel panel_choose = new JPanel(flow);
	private JPanel panel_info = new JPanel();
	private JPanel panel_Login = new JPanel();

	Panel_zhyaq p_zhyaq = new Panel_zhyaq();

	public MainFrame() {
		super("个人财务管理系统");
		DBHelper dbhelpr = new DBHelper();
		dbhelpr.TestConn();
		setSize(980, 580);
		//setResizable(false);
		setLocationRelativeTo(null);
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
		GridLayout grid = new GridLayout(5, 1);
		panel_Login.setLayout(grid);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		p1.add(lable_huanying);
		p2.add(lable_userName);
		p3.add(lable_passworld);
		p2.add(textfield_userName);
		p3.add(textfield_passworld);
		p4.add(lable_passworldTiShi);
		p5.add(button_login);
		p5.add(button_register);
		p5.add(button_exit);
		panel_Login.add(p1);
		panel_Login.add(p2);
		panel_Login.add(p3);
		panel_Login.add(p4);
		panel_Login.add(p5);
		panel_info.add(panel_Login);
		// BorderLayout border = new BorderLayout();
		// this.setLayout(border);
		add(panel_choose, BorderLayout.NORTH);
		add(panel_info, BorderLayout.CENTER);
	}

	private void myEventListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "系统即将安全退出！", "消息", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
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
				p_zhyaq.p.setVisible(false);

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
				p_zhyaq.p.setVisible(false);

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
				p_zhyaq.p.setVisible(false);

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
				p_zhyaq.p.setVisible(false);

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
				p_zhyaq = new Panel_zhyaq();
				panel_info.add(p_zhyaq.p);
				setVisible(true);
			}
		});
		// 注销
		button_zx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "是否退出当前用户？", "提示", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					// 关闭所有button
					button_grxx.setEnabled(false);
					button_szjl.setEnabled(false);
					button_srmx.setEnabled(false);
					button_zcmx.setEnabled(false);
					button_zhyaq.setEnabled(false);
					button_zx.setEnabled(false);
					button_zx.setBackground(Color.GRAY);
					// 隐藏5个panel
					p_zhyaq.p.setVisible(false);
					// 添加登录Panel
					panel_Login.setVisible(true);
				}
			}
		});
		button_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textfield_userName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入用户名！", "消息", JOptionPane.WARNING_MESSAGE);
				} else if (textfield_passworld.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入密码！", "消息", JOptionPane.WARNING_MESSAGE);
				} else {
					// 验证登录
					if (login()) {
						// 上传登录时间
						updateLoginDate();
						JOptionPane.showMessageDialog(null, "登录成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
						// 清空密码框与密码提示框
						textfield_passworld.setText("");
						lable_passworldTiShi.setText("");
						// 打开6个button
						button_grxx.setEnabled(true);
						button_szjl.setEnabled(true);
						button_srmx.setEnabled(true);
						button_zcmx.setEnabled(true);
						button_zhyaq.setEnabled(true);
						button_zx.setEnabled(true);
						button_zx.setBackground(new Color(232, 17, 35));
						// 隐藏登录页
						panel_Login.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "登录失败！\n用户名或密码错误！", "消息", JOptionPane.ERROR_MESSAGE);
					}
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
		button_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "是否退出系统？", "提示", JOptionPane.YES_NO_OPTION);
				if (n == 0)
					System.exit(0);
			}
		});

	}

	private void updateLoginDate() {
		DBHelper help = new DBHelper();
		Connection dbConn = null;
		Statement dbState = null;
		ResultSet dbRs = null;
		String sql = null;	
		int index=getIndex();
		index++;
		// 查询userLogin表
		try {
			dbConn = help.GetConnection();
			dbState = dbConn.createStatement();
			sql = "insert into T_userLogin values('"+USERNAME+"', "
													  +index+" ,'"
													  +ShiJian.getTime()+"')";
			dbState.executeUpdate(sql);
			dbState.close();
			help.Close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	private int getIndex(){
		DBHelper help = new DBHelper();
		Connection dbConn = null;
		Statement dbState = null;
		ResultSet dbRs = null;
		String sql = null;	
		int index=0;
		// 查询userLogin表
		try {
			dbConn = help.GetConnection();
			dbState = dbConn.createStatement();
			sql = "select loginIndex from T_userLogin where userName='" + USERNAME + "'";
			dbRs = dbState.executeQuery(sql);
			while (dbRs.next()) {
				index=Integer.parseInt(dbRs.getString(1));
			}
			dbRs.close();
			dbState.close();
			help.Close();
			return index;
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			return 0;
		}
	}
	private boolean login() {
		DBHelper help = new DBHelper();
		Connection dbConn = null;
		Statement dbState = null;
		ResultSet dbRs = null;
		
		String sql = null;
		String PASSWORLD = "";

		USERNAME = textfield_userName.getText();
		PASSWORLD = JiaMi.getMD5(textfield_passworld.getText());

		// 查询user表
		try {
			dbConn = help.GetConnection();
			dbState = dbConn.createStatement();
			sql = "select * from T_User where userName='" + USERNAME + "' and userPwd='" + PASSWORLD + "'";
			dbRs = dbState.executeQuery(sql);
			if (dbRs.next()) {
				dbRs.close();
				dbState.close();
				help.Close();
				return true;
			} else {
				sql = "select userPwdTiShi from T_User where userName='" + USERNAME + "'";
				dbRs = dbState.executeQuery(sql);
				if (dbRs.next()) {
					lable_passworldTiShi.setText("密码提示:" + dbRs.getString(1));
				} else {
					lable_passworldTiShi.setText("密码提示:");
				}
				dbRs.close();
				dbRs.close();
				dbState.close();
				help.Close();
				return false;
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			return false;
		}
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
