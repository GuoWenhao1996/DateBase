package com.gwh.PersonalMoneyMS.Frame;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.gwh.PersonalMoneyMS.DBLink.DBHelper;
import com.gwh.PersonalMoneyMS.Util.JiaMi;

public class UpdatePwd extends JFrame {

	private JLabel lable_oldPwd = new JLabel("旧  密  码：");
	private JLabel lable_pwd1 = new JLabel("新  密  码：");
	private JLabel lable_pwd2 = new JLabel("确认密码：");
	private JLabel lable_pwdTiShi = new JLabel("密码提示：");

	private JPasswordField textfield_oldPwd = new JPasswordField(10);
	private JPasswordField textfield_pwd1 = new JPasswordField(10);
	private JPasswordField textfield_pwd2 = new JPasswordField(10);
	private JTextField textfield_pwdTiShi = new JTextField(10);

	private JButton button_tijiao = new JButton("提交");
	private JButton button_qingkong = new JButton("清空");
	private JButton button_guanbi = new JButton("关闭");

	private JPanel p = new JPanel();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();

	public UpdatePwd() {
		super("修改密码");
		setSize(340, 360);
		setResizable(false);
		setLocationRelativeTo(null);
		BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
		p.setLayout(horizontal);
		lable_oldPwd.setFont(new Font("Dialog", 0, 20));
		lable_pwd1.setFont(new Font("Dialog", 0, 20));
		lable_pwd2.setFont(new Font("Dialog", 0, 20));
		lable_pwdTiShi.setFont(new Font("Dialog", 0, 20));
		textfield_oldPwd.setFont(new Font("Dialog", 0, 20));
		textfield_pwd1.setFont(new Font("Dialog", 0, 20));
		textfield_pwd2.setFont(new Font("Dialog", 0, 20));
		textfield_pwd1.setFont(new Font("Dialog", 0, 20));
		textfield_pwdTiShi.setFont(new Font("Dialog", 0, 20));
		button_tijiao.setFont(new Font("Dialog", 0, 20));
		button_qingkong.setFont(new Font("Dialog", 0, 20));
		button_guanbi.setFont(new Font("Dialog", 0, 20));
		textfield_oldPwd.setEchoChar('*');
		textfield_pwd1.setEchoChar('*');
		textfield_pwd2.setEchoChar('*');
		p1.add(lable_oldPwd);
		p1.add(textfield_oldPwd);
		p2.add(lable_pwd1);
		p2.add(textfield_pwd1);
		p3.add(lable_pwd2);
		p3.add(textfield_pwd2);
		p4.add(lable_pwdTiShi);
		p4.add(textfield_pwdTiShi);
		p5.add(button_tijiao);
		p5.add(button_qingkong);
		p5.add(button_guanbi);

		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);

		add(p);
		setVisible(true);
		myWindowListener();
	}

	private void clearAll() {
		textfield_oldPwd.setText("");
		textfield_pwd1.setText("");
		textfield_pwd2.setText("");
		textfield_pwdTiShi.setText("");

	}

	private void myWindowListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainFrame.mf.setVisible(true);
			}
		});
		// 修改事件监听
		button_tijiao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textfield_oldPwd.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入旧密码！", "消息", JOptionPane.WARNING_MESSAGE);
				} else if (textfield_pwd1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入新密码！", "消息", JOptionPane.WARNING_MESSAGE);
				} else if (!(textfield_pwd1.getText().equals(textfield_pwd2.getText()))) {
					JOptionPane.showMessageDialog(null, "两次输入的密码不相同！", "消息", JOptionPane.WARNING_MESSAGE);
				} else {
					if (login()) {
						try {
							DBHelper help = new DBHelper();
							Connection dbConn = null;
							Statement dbState = null;
							dbConn = help.GetConnection();
							dbState = dbConn.createStatement();
							String sql = "update T_User set userPwd='"+JiaMi.getMD5(textfield_pwd1.getText())+"',userPwdTiShi='"+textfield_pwdTiShi.getText()+"' where userName='"+MainFrame.USERNAME+"'";
							dbState.executeUpdate(sql);
							dbState.close();
							help.Close();
							JOptionPane.showMessageDialog(null, "密码修改成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
							MainFrame.mf.setVisible(true);
						} catch (SQLException ex) {
							System.err.println(ex.getMessage());
							JOptionPane.showMessageDialog(null, "操作失败！\n" + ex.getMessage(), "消息",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "旧密码有误！", "消息", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// 关闭事件监听
		button_guanbi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainFrame.mf.setVisible(true);
			}
		});
		// 清空事件监听
		button_qingkong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});

	}

	private boolean login() {
		DBHelper help = new DBHelper();
		Connection dbConn = null;
		Statement dbState = null;
		ResultSet dbRs = null;

		String sql = null;
		String PASSWORLD = "";

		PASSWORLD = JiaMi.getMD5(textfield_oldPwd.getText());

		// 查询user表
		try {
			dbConn = help.GetConnection();
			dbState = dbConn.createStatement();
			sql = "select * from T_User where userName='" + MainFrame.USERNAME + "' and userPwd='" + PASSWORLD + "'";
			dbRs = dbState.executeQuery(sql);
			if (dbRs.next()) {
				dbRs.close();
				dbState.close();
				help.Close();
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}

}
