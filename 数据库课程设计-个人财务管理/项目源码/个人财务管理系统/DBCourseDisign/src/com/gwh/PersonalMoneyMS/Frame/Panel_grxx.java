package com.gwh.PersonalMoneyMS.Frame;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import com.gwh.PersonalMoneyMS.DBLink.DBHelper;

public class Panel_grxx extends JPanel {

	private JLabel lable_zhanwei1 = new JLabel(" ");
	private JLabel lable_zhanwei2 = new JLabel(" ");
	private JLabel lable_xm = new JLabel("姓       名:");
	private JLabel lable_xb = new JLabel("性       别:");
	private JLabel lable_nl = new JLabel("年       龄:");
	private JLabel lable_gzdw = new JLabel("工作单位:");
	private JLabel lable_zw = new JLabel("职       位:");
	private JTextField textfield_xm = new JTextField(15);
	private JTextField textfield_xb = new JTextField(15);
	private JTextField textfield_nl = new JTextField(15);
	private JTextField textfield_gzdw = new JTextField(15);
	private JTextField textfield_zw = new JTextField(15);

	private JButton button_xiugai = new JButton("要修改？点这里！");

	protected JPanel p = new JPanel();
	private JPanel p1_1 = new JPanel();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();
	private JPanel p6 = new JPanel();
	private JPanel p6_2 = new JPanel();

	protected Panel_grxx() {
		Information("select xm,xb,nl,gzdw,zw from T_UserInfo where userName='" + MainFrame.USERNAME + "'");
		myEventListener();
		BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
		lable_zhanwei1.setFont(new Font("Dialog", 0, 80));
		lable_zhanwei2.setFont(new Font("Dialog", 0, 80));
		lable_xm.setFont(new Font("Dialog", 0, 20));
		lable_xb.setFont(new Font("Dialog", 0, 20));
		lable_nl.setFont(new Font("Dialog", 0, 20));
		lable_gzdw.setFont(new Font("Dialog", 0, 20));
		lable_zw.setFont(new Font("Dialog", 0, 20));
		textfield_xm.setFont(new Font("Dialog", 0, 20));
		textfield_xb.setFont(new Font("Dialog", 0, 20));
		textfield_nl.setFont(new Font("Dialog", 0, 20));
		textfield_gzdw.setFont(new Font("Dialog", 0, 20));
		textfield_zw.setFont(new Font("Dialog", 0, 20));
		textfield_xm.setEditable(false);
		textfield_xb.setEditable(false);
		textfield_nl.setEditable(false);
		textfield_gzdw.setEditable(false);
		textfield_zw.setEditable(false);
		p.setLayout(horizontal);
		p1_1.add(lable_zhanwei1);
		p1.add(lable_xm);
		p1.add(textfield_xm);
		p2.add(lable_xb);
		p2.add(textfield_xb);
		p3.add(lable_nl);
		p3.add(textfield_nl);
		p4.add(lable_gzdw);
		p4.add(textfield_gzdw);
		p5.add(lable_zw);
		p5.add(textfield_zw);
		p6.add(button_xiugai);
		p6_2.add(lable_zhanwei2);
		p.add(p1_1);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		p.add(p6_2);
	}

	private void Information(String sql) {
		Connection dbConn = null;
		Statement dbState = null;
		ResultSet dbRs = null;
		DBHelper dbhelpr = new DBHelper();

		// 查询个人信息表
		try {
			dbConn = dbhelpr.GetConnection();
			dbState = dbConn.createStatement();
			dbRs = dbState.executeQuery(sql);
			while (dbRs.next()) {
				textfield_xm.setText(dbRs.getString("xm"));
				textfield_xb.setText(dbRs.getString("xb"));
				textfield_nl.setText(dbRs.getString("nl"));
				textfield_gzdw.setText(dbRs.getString("gzdw"));
				textfield_zw.setText(dbRs.getString("zw"));
			}
			dbRs.close();
			dbState.close();
			dbhelpr.Close();
			if (textfield_xm.getText().isEmpty()) {
				textfield_xm.setText("空");
			}
			if (textfield_xb.getText().isEmpty()) {
				textfield_xb.setText("空");
			}
			if (textfield_nl.getText().isEmpty()) {
				textfield_nl.setText("空");
			}
			if (textfield_gzdw.getText().isEmpty()) {
				textfield_gzdw.setText("空");
			}
			if (textfield_zw.getText().isEmpty()) {
				textfield_zw.setText("空");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "查询失败！\n" + ex.getMessage(), "消息", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void myEventListener() {

		// 修改事件监听
		button_xiugai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (button_xiugai.getText().equals("要修改？点这里！")) {
					JOptionPane.showMessageDialog(null, "编辑已开启！", "消息", JOptionPane.INFORMATION_MESSAGE);
					button_xiugai.setText("提交");
					textfield_xm.setEditable(true);
					textfield_xb.setEditable(true);
					textfield_nl.setEditable(true);
					textfield_gzdw.setEditable(true);
					textfield_zw.setEditable(true);
				} else if (button_xiugai.getText().equals("提交")) {
					try {
						if (textfield_xm.getText().isEmpty()) {
							textfield_xm.setText("空");
						} if (textfield_xb.getText().isEmpty()) {
							textfield_xb.setText("空");
						} if (textfield_nl.getText().isEmpty()) {
							textfield_nl.setText("空");
						} if (textfield_gzdw.getText().isEmpty()) {
							textfield_gzdw.setText("空");
						} if (textfield_zw.getText().isEmpty()) {
							textfield_zw.setText("空");
						} if (!(textfield_xb.getText().equals("男") || textfield_xb.getText().equals("女")
								|| textfield_xb.getText().equals("空"))) {
							JOptionPane.showMessageDialog(null, "提交失败！\n性别请输入 男 或 女 ！\n或不填！", "消息",
									JOptionPane.INFORMATION_MESSAGE);
							textfield_xb.setText("");
						} else if (!(textfield_nl.getText().equals("空")
								|| (Integer.parseInt(textfield_nl.getText()) <= 100
										&& Integer.parseInt(textfield_nl.getText()) >= 0))) {
							JOptionPane.showMessageDialog(null, "提交失败！\n请输入正确的年龄（0-100） ！\n或不填！", "消息",
									JOptionPane.INFORMATION_MESSAGE);
							textfield_nl.setText("");
						} else {
							DBHelper help = new DBHelper();
							Connection dbConn = null;
							Statement dbState = null;
							dbConn = help.GetConnection();
							dbState = dbConn.createStatement();
							String sql = "update T_UserInfo set xm='" + textfield_xm.getText() + "',xb='"
									+ textfield_xb.getText() + "',nl='" + textfield_nl.getText() + "',gzdw='"
									+ textfield_gzdw.getText() + "',zw='" + textfield_zw.getText()
									+ "' where userName='" + MainFrame.USERNAME + "'";
							dbState.executeUpdate(sql);
							dbState.close();
							help.Close();
							JOptionPane.showMessageDialog(null, "修改成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
							button_xiugai.setText("要修改？点这里！");
							textfield_xm.setEditable(false);
							textfield_xb.setEditable(false);
							textfield_nl.setEditable(false);
							textfield_gzdw.setEditable(false);
							textfield_zw.setEditable(false);
							JOptionPane.showMessageDialog(null, "编辑已关闭！", "消息", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (Exception ex) {
						System.err.println(ex.getMessage());
						if (ex.getMessage().substring(0, 17).equals("For input string:")) {
							JOptionPane.showMessageDialog(null, "提交失败！\n请输入正确的年龄（0-100） ！\n或不填！", "消息",
									JOptionPane.INFORMATION_MESSAGE);
							textfield_nl.setText("");
						}
						else{
							System.err.println(ex.getMessage());
						}
					}
				} else {
					// 未知错误
				}
			}
		});
	}
}
