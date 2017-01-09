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
import javax.swing.JTextField;

import com.gwh.PersonalMoneyMS.DBLink.DBHelper;
import com.gwh.PersonalMoneyMS.Util.JiaMi;
import com.gwh.PersonalMoneyMS.Util.ShiJian;

public class UpdateZhiChu extends JFrame {

	private int index = 0;
	private JLabel lable_zhanwei = new JLabel("     ");
	private JLabel lable_time = new JLabel("时       间：");
	private JLabel lable_money = new JLabel("支出 (元)：");
	private JLabel lable_info = new JLabel("备       注：");

	private JTextField textfield_time = new JTextField(14);
	private JTextField textfield_money = new JTextField(14);
	private JTextField textfield_info = new JTextField(21);

	private JButton button_gettime = new JButton("获取当前时间");
	private JButton button_tijiao = new JButton("提交");
	private JButton button_qingkong = new JButton("清空");
	private JButton button_guanbi = new JButton("关闭");

	private JPanel p = new JPanel();
	private JPanel p0 = new JPanel();
	private JPanel p1 = new JPanel();
	private JPanel p1_1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();

	public UpdateZhiChu(String str1, String str2, String str3, int i) {
		super("修改支出信息");
		index = i;
		setSize(550, 350);
		setResizable(false);
		setLocationRelativeTo(null);
		BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
		p.setLayout(horizontal);
		lable_zhanwei.setFont(new Font("Dialog", 0, 2));
		lable_time.setFont(new Font("Dialog", 0, 20));
		lable_money.setFont(new Font("Dialog", 0, 20));
		lable_info.setFont(new Font("Dialog", 0, 20));
		textfield_time.setFont(new Font("Dialog", 0, 20));
		textfield_money.setFont(new Font("Dialog", 0, 20));
		textfield_info.setFont(new Font("Dialog", 0, 14));
		button_gettime.setFont(new Font("Dialog", 0, 12));
		button_tijiao.setFont(new Font("Dialog", 0, 20));
		button_qingkong.setFont(new Font("Dialog", 0, 20));
		button_guanbi.setFont(new Font("Dialog", 0, 20));
		textfield_time.setText(str1);
		textfield_money.setText(str2.substring(1));
		textfield_info.setText(str3);
		p0.add(lable_zhanwei);
		p1_1.add(button_gettime);
		p1.add(lable_time);
		p1.add(textfield_time);
		p2.add(lable_money);
		p2.add(textfield_money);
		p3.add(lable_info);
		p3.add(textfield_info);
		p4.add(button_tijiao);
		p4.add(button_qingkong);
		p4.add(button_guanbi);

		p.add(p0);
		p.add(p1_1);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);

		add(p);
		setVisible(true);
		myWindowListener();
	}

	private void clearAll() {
		textfield_time.setText("");
		textfield_money.setText("");
		textfield_info.setText("");

	}

	private void myWindowListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainFrame.mf.setVisible(true);
			}
		});
		// 提交事件监听
		button_tijiao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (textfield_time.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入时间！", "消息", JOptionPane.WARNING_MESSAGE);
					} else if (textfield_money.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入支出金额！", "消息", JOptionPane.WARNING_MESSAGE);
					} else if (Double.parseDouble(textfield_money.getText()) == 0) {
						JOptionPane.showMessageDialog(null, "支出0元就不存了吧，没必要！", "消息", JOptionPane.WARNING_MESSAGE);
					} else if (textfield_info.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入备注！", "消息", JOptionPane.WARNING_MESSAGE);
					} else {
						DBHelper help = new DBHelper();
						Connection dbConn = null;
						Statement dbState = null;
						dbConn = help.GetConnection();
						dbState = dbConn.createStatement();
						String sql = "update T_ZhiChu set ZhiChuTime='" + textfield_time.getText() + "',ZhiChuMoney="
								+ Math.abs(Double.parseDouble(textfield_money.getText())) + ",ZhiChuInfo='"
								+ textfield_info.getText() + "' where ZhiChuIndex=" + index;
						dbState.executeUpdate(sql);
						dbState.close();
						help.Close();
						JOptionPane.showMessageDialog(null, "修改成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						MainFrame.mf.reshowPanel_szjl();
						MainFrame.mf.setVisible(true);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "提交失败！\n请输入正确的金额！请重新输入！", "消息",
							JOptionPane.INFORMATION_MESSAGE);
					textfield_money.setText("");
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
					if (ex.getMessage().equals("从字符串转换日期和/或时间时，转换失败。")) {
						JOptionPane.showMessageDialog(null, "提交失败！\n日期请输入yyyy-mm-dd hh-mm-ss格式", "消息",
								JOptionPane.INFORMATION_MESSAGE);
						textfield_time.setText("");
					} else if (ex.getMessage().substring(0, 17).equals("For input string:")) {
						JOptionPane.showMessageDialog(null, "提交失败！\n请输入正确的金额！请重新输入！", "消息",
								JOptionPane.INFORMATION_MESSAGE);
						textfield_money.setText("");
					} else if (ex.getMessage().substring(0, 21).equals("类型 money 发生算术溢出错误，值 =")) {
						JOptionPane.showMessageDialog(null, "提交失败！\n您一次支出了这么多钱？请重新输入！", "消息",
								JOptionPane.INFORMATION_MESSAGE);
						textfield_money.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "操作失败！\n" + ex.getMessage(), "消息",
								JOptionPane.ERROR_MESSAGE);
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

		// 获取时间事件监听
		button_gettime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textfield_time.setText(ShiJian.getTime());
			}
		});

	}
}
