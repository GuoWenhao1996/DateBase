package com.gwh.PersonalMoneyMS.Frame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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

public class Panel_zcxq extends JPanel {
	
	private BigDecimal money_sum= new BigDecimal(Double.toString(0));
	private String money= null;

	private JTable table = new JTable();
	private JScrollPane scrollpane = null;
	private Vector rowData = new Vector();
	private Vector columName = new Vector();

	private JButton button_chaxun = new JButton("查询");
	private JLabel lable_rq = new JLabel("日期:");
	private JLabel lable = new JLabel("~");
	private JTextField textfield_rq1 = new JTextField(10);
	private JTextField textfield_rq2 = new JTextField(10);
	private JLabel lable_zje = new JLabel("总支出：");
	private JLabel lable_sum = new JLabel("");
	private JLabel lable_yuan = new JLabel(" 元");

	protected JPanel p = new JPanel();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();

	protected Panel_zcxq() {
		Information("select ZhiChuTime,ZhiChuMoney,ZhiChuInfo from T_ZhiChu "
				+ "where userName='"+MainFrame.USERNAME+"' "
				+ "order by ZhiChuTime");
		myEventListener();
		BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
		lable.setFont(new Font("Dialog", 0, 30));
		lable_zje.setFont(new Font("Dialog", 0, 30));
		lable_sum.setFont(new Font("Dialog", 0, 30));
		lable_yuan.setFont(new Font("Dialog", 0, 30));
		p.setLayout(horizontal);
		p1.add(lable_rq);
		p1.add(textfield_rq1);
		p1.add(lable);
		p1.add(textfield_rq2);
		p1.add(button_chaxun);
		p2.add(scrollpane);
		p3.add(lable_zje);
		p3.add(lable_sum);
		p3.add(lable_yuan);
		p.add(p1);
		p.add(p2);
		p.add(p3);
	}

	private void Information(String sql) {
		Connection dbConn = null;
		Statement dbState = null;
		ResultSet dbRs = null;
		DBHelper dbhelpr = new DBHelper();
		rowData.clear();
		columName.add("日期");
		columName.add("金额");
		columName.add("详情");
		// 查询收入信息表
		try {
			dbConn = dbhelpr.GetConnection();
			dbState = dbConn.createStatement();
			dbRs = dbState.executeQuery(sql);
			money_sum= new BigDecimal(Double.toString(0));
			while (dbRs.next()) {
				Vector vNext = new Vector();
				vNext.add(dbRs.getString("ZhiChuTime"));
				money=dbRs.getString("ZhiChuMoney");
				vNext.add(money);
				money_sum=money_sum.add(BigDecimal.valueOf(Double.parseDouble(money)));
				vNext.add(dbRs.getString("ZhiChuInfo"));
				rowData.add(vNext);
			}
			table = new JTable(rowData, columName);// 数据加到表格中
			money_sum=money_sum.setScale(2, BigDecimal.ROUND_HALF_UP);
			lable_sum.setText(money_sum.toString());
			dbRs.close();
			dbState.close();
			dbhelpr.Close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			if (ex.getMessage().equals("从字符串转换日期和/或时间时，转换失败。")) {
				JOptionPane.showMessageDialog(null, "查询失败！\n日期请输入yyyy-mm-dd格式", "消息", JOptionPane.ERROR_MESSAGE);
			} else if (ex.getMessage().equals("从 varchar 数据类型到 datetime 数据类型的转换产生一个超出范围的值。")) {
				JOptionPane.showMessageDialog(null, "查询失败！\n日期请输入yyyy-mm-dd格式", "消息", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "查询失败！\n" + ex.getMessage(), "消息", JOptionPane.ERROR_MESSAGE);
			}
		}

		table.setFont(new Font("Dialog", 0, 15));

		TableColumn column = null;
		column = table.getColumnModel().getColumn(0);
		column.setPreferredWidth(200);
		column = table.getColumnModel().getColumn(1);
		column.setPreferredWidth(100);
		column = table.getColumnModel().getColumn(2);
		column.setPreferredWidth(400);

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);

		table.setPreferredScrollableViewportSize(new Dimension(700, 350));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scrollpane = new JScrollPane(table);
	}

	private void myEventListener() {
		// 查询事件监听
		button_chaxun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String _rq1 = textfield_rq1.getText();
				String _rq2 = textfield_rq2.getText();
				if (textfield_rq1.getText().equals("")) {
					_rq1 = "1900-01-01";
				}
				if (textfield_rq2.getText().equals("")) {
					_rq2 = "9999-12-31";
				}
				Information("select ZhiChuTime,ZhiChuMoney,ZhiChuInfo from T_ZhiChu "
						+ "where userName='"+MainFrame.USERNAME+"' and ZhiChuTime between '" + _rq1 + "' and '" + _rq2 + "'"  
																	+"or ZhiChuTime between '"+ _rq2 + "' and '" + _rq1 + "'"
						+ "order by ZhiChuTime");
				MainFrame.mf.repaint();
			}
		});
	}
}
