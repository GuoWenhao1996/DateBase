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

public class Panel_szjl extends JPanel {
	private int MAXINDEX=999999;
	private BigDecimal money_sum = new BigDecimal(Double.toString(0));
	private String money = null;
	private int[] index=new int[MAXINDEX];
	private JTable table = new JTable();
	private JScrollPane scrollpane = new JScrollPane();
	private Vector rowData = new Vector();
	private Vector columName = new Vector();

	private JButton button_chaxun = new JButton("查询");
	private JLabel lable_rq = new JLabel("日期:");
	private JLabel lable = new JLabel("~");
	private JTextField textfield_rq1 = new JTextField(11);
	private JTextField textfield_rq2 = new JTextField(11);

	private JLabel lable_zje = new JLabel("净收入：");
	private JLabel lable_sum = new JLabel("");
	private JLabel lable_yuan = new JLabel(" 元");

	private JButton button_zengjia = new JButton("增加记录");
	private JButton button_shanchu = new JButton("删除记录");
	private JButton button_xiugai = new JButton("修改记录");

	protected JPanel p = new JPanel();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();

	protected Panel_szjl() {
		Information("select ShouRuIndex,ShouRuTime,ShouRuMoney,ShouRuInfo from T_ShouRu " + "where userName='" + MainFrame.USERNAME
				+ "' " + "union select ZhiChuIndex,ZhiChuTime,ZhiChuMoney=-ZhiChuMoney,ZhiChuInfo from T_ZhiChu "
				+ "where userName='" + MainFrame.USERNAME + "' " + "order by ShouRuTime");
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
		p4.add(button_zengjia);
		p4.add(button_shanchu);
		p4.add(button_xiugai);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
	}

	protected void Information(String sql) {
		Connection dbConn = null;
		Statement dbState = null;
		ResultSet dbRs = null;
		DBHelper dbhelpr = new DBHelper();
		int szindex=0;
		rowData.clear();
		columName.clear();
		columName.add("日期");
		columName.add("金额");
		columName.add("详情");
		// 查询收入信息表和支出信息表
		try {
			dbConn = dbhelpr.GetConnection();
			dbState = dbConn.createStatement();
			dbRs = dbState.executeQuery(sql);
			money_sum = new BigDecimal(Double.toString(0));
			while (dbRs.next()) {
				index[szindex]=dbRs.getInt("ShouRuIndex");
				szindex++;
				if(szindex==MAXINDEX)
					szindex=0;
				Vector vNext = new Vector();
				vNext.add(dbRs.getString("ShouRuTime"));
				money = dbRs.getString("ShouRuMoney");
				vNext.add(money);
				money_sum = money_sum.add(BigDecimal.valueOf(Double.parseDouble(money)));
				vNext.add(dbRs.getString("ShouRuInfo"));
				rowData.add(vNext);
			}
			table = new JTable(rowData, columName);// 数据加到表格中
			money_sum = money_sum.setScale(2, BigDecimal.ROUND_HALF_UP);
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

		table.setPreferredScrollableViewportSize(new Dimension(700, 320));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scrollpane.setViewportView(table);
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
				Information("select ShouRuIndex,ShouRuTime,ShouRuMoney,ShouRuInfo from T_ShouRu " + "where userName='"
						+ MainFrame.USERNAME + "' and ShouRuTime between '" + _rq1 + "' and '" + _rq2 + "'"
						+ "or ShouRuTime between '" + _rq2 + "' and '" + _rq1 + "'"
						+ "union select ZhiChuIndex,ZhiChuTime,ZhiChuMoney=-ZhiChuMoney,ZhiChuInfo from T_ZhiChu "
						+ "where userName='" + MainFrame.USERNAME + "' and ZhiChuTime between '" + _rq1 + "' and '"
						+ _rq2 + "'" + "or ZhiChuTime between '" + _rq2 + "' and '" + _rq1 + "'"
						+ "order by ShouRuTime");
				MainFrame.mf.repaint();
			}
		});

		// 增加事件监听
		button_zengjia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "收入记录", "支出记录", "取消" };
				int m = JOptionPane.showOptionDialog(null, "请问您要添加收入记录还是支出记录：", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (m == 0) {
					AddShouRu asr = new AddShouRu();
					asr.setVisible(true);
					MainFrame.mf.setVisible(false);
				} else if (m == 1) {
					AddZhiChu azc = new AddZhiChu();
					azc.setVisible(true);
					MainFrame.mf.setVisible(false);
				} else {
					// 什么都不做
				}
			}
		});
		// 删除事件监听
		button_shanchu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] selectRows = table.getSelectedRows();
				System.out.println("选中了："+selectRows.length+" 行");
				for (int i = 0; i < selectRows.length; i++) {
					System.out.print("id="+index[selectRows[i]]+"  ");
					System.out.println(selectRows[i] + " ");
				}
			}
		});
		// 修改事件监听
		button_xiugai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
}
