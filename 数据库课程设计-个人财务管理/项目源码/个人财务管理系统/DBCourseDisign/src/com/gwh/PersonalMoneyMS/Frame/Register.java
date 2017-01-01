package com.gwh.PersonalMoneyMS.Frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
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

public class Register extends JFrame {

	private JLabel lable_userName = new JLabel("用  户  名：");
	private JLabel lable_pwd1 = new JLabel("密       码：");
	private JLabel lable_pwd2 = new JLabel("确认密码：");
	private JLabel lable_pwdTiShi = new JLabel("密码提示：");

	private JTextField textfield_userName = new JTextField(10);
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

	public Register() {
		super("注册");
		setSize(340, 360);
		setResizable(false);
		setLocationRelativeTo(null);
		BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
		p.setLayout(horizontal);
		lable_userName.setFont(new Font("Dialog", 0, 20));
		lable_pwd1.setFont(new Font("Dialog", 0, 20));
		lable_pwd2.setFont(new Font("Dialog", 0, 20));
		lable_pwdTiShi.setFont(new Font("Dialog", 0, 20));
		textfield_userName.setFont(new Font("Dialog", 0, 20));
		textfield_pwd1.setFont(new Font("Dialog", 0, 20));
		textfield_pwd2.setFont(new Font("Dialog", 0, 20));
		textfield_pwd1.setFont(new Font("Dialog", 0, 20));
		textfield_pwdTiShi.setFont(new Font("Dialog", 0, 20));
		button_tijiao.setFont(new Font("Dialog", 0, 20));
		button_qingkong.setFont(new Font("Dialog", 0, 20));
		button_guanbi.setFont(new Font("Dialog", 0, 20));
		textfield_pwd1.setEchoChar('*');
		textfield_pwd2.setEchoChar('*');
		p1.add(lable_userName);
		p1.add(textfield_userName);
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
		textfield_userName.setText("");
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
		// 注册事件监听
		button_tijiao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textfield_userName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入用户名！", "消息", JOptionPane.WARNING_MESSAGE);
				} else if (textfield_pwd1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入密码！", "消息", JOptionPane.WARNING_MESSAGE);
				} else if (!(textfield_pwd1.getText().equals(textfield_pwd2.getText()))) {
					JOptionPane.showMessageDialog(null, "两次输入的密码不相同！", "消息", JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						DBHelper help = new DBHelper();
						Connection dbConn = null;
						Statement dbState = null;
						dbConn = help.GetConnection();
						dbState = dbConn.createStatement();
						String sql = "insert into T_User values('" + textfield_userName.getText() + "','"
								+ JiaMi.getMD5(textfield_pwd1.getText()) + "','" + textfield_pwdTiShi.getText() + "')";
						dbState.executeUpdate(sql);
						sql = "insert into T_UserInfo values('" + textfield_userName.getText() + "','','','','','')";
						dbState.executeUpdate(sql);
						dbState.close();
						help.Close();
						JOptionPane.showMessageDialog(null, "注册成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						MainFrame.mf.setVisible(true);
						MainFrame.mf.textfield_userName.setText(textfield_userName.getText());
					} catch (SQLException ex) {
						System.err.println(ex.getMessage());
						if (ex.getMessage().equals("违反了 PRIMARY KEY 约束 'PK_T_User'。不能在对象 'dbo.T_User' 中插入重复键。")) {
							JOptionPane.showMessageDialog(null, "注册失败！\n该用户名已存在！请重新输入！", "消息",
									JOptionPane.INFORMATION_MESSAGE);
							textfield_userName.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "操作失败！\n" + ex.getMessage(), "消息",
									JOptionPane.ERROR_MESSAGE);
						}
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
}
