package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import team.nqnqmi.Service.LendService;
import team.nqnqmi.bean.Record_item;

public class LendManageUI extends JPanel {

	private JTable Tables;
	private JTextField txtproducteName;
	private JTextField txtproductNamber;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public LendManageUI() {
		setSize(1670, 982);
		setLayout(null);

		JPanel panelBig = new JPanel();
		panelBig.setBackground(new Color(255, 255, 255));
		panelBig.setBounds(0, 0, 1644, 986);
		this.add(panelBig);
		panelBig.setLayout(null);

		JPanel panelBig_Header = new JPanel();
		panelBig_Header.setBorder(null);
		panelBig_Header.setBackground(new Color(255, 250, 250));
		panelBig_Header.setBounds(21, 10, 1600, 240);
		panelBig.add(panelBig_Header);
		panelBig_Header.setLayout(null);

		JLabel LabBoookName = new JLabel("\u4E66\u7C4D\u7F16\u53F7\uFF1A");
		LabBoookName.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		LabBoookName.setBounds(462, 108, 73, 20);
		panelBig_Header.add(LabBoookName);

		txtproducteName = new JTextField();
		txtproducteName.setBounds(545, 106, 150, 25);
		panelBig_Header.add(txtproducteName);
		txtproducteName.setColumns(10);

		JLabel LabproductNumber = new JLabel("\u8BFB\u8005\u7F16\u53F7\uFF1A");
		LabproductNumber.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		LabproductNumber.setBounds(705, 108, 65, 20);
		panelBig_Header.add(LabproductNumber);

		txtproductNamber = new JTextField();
		txtproductNamber.setColumns(10);
		txtproductNamber.setBounds(780, 106, 150, 25);
		panelBig_Header.add(txtproductNamber);

		JButton btnSearch = new JButton("\u67E5\u8BE2");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtproducteName.getText();
				String id1 = txtproductNamber.getText();
				LendService tj = new LendService();
				if (id != null && !"".equals(id)) {
					Record_item e1 = tj.getitembyproductid(id);
					ArrayList<Record_item> rec = new ArrayList<Record_item>();
					rec.add(e1);
					tjyTableModel etm = new tjyTableModel(rec);
					table.setModel(etm);
				} else if (id1 != null && !"".equals(id1)) {
					Record_item e2 = tj.getitembyReaderid(id1);
					ArrayList<Record_item> rec1 = new ArrayList<Record_item>();
					rec1.add(e2);
					tjyTableModel etm = new tjyTableModel(rec1);
					table.setModel(etm);

				}
			}
		});
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setBackground(new Color(255, 182, 193));
				btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setBackground(new Color(221, 160, 221));
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(221, 160, 221));
		btnSearch.setBounds(545, 171, 100, 40);
		panelBig_Header.add(btnSearch);

		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnDeleteAction();
			}
		});
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setBackground(new Color(30, 144, 255));
				btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setBackground(new Color(0, 255, 255));
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(0, 255, 255));
		btnDelete.setBounds(830, 171, 100, 40);
		panelBig_Header.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 250, 1600, 672);
		panelBig.add(scrollPane);

		table = new JTable();
		LendService tjie = new LendService();
		ArrayList<Record_item> e = tjie.getAllitem();
		System.out.println(e);
		tjyTableModel etm = new tjyTableModel(e);
		table.setModel(etm);
		table.setBackground(new Color(255, 255, 255));
		table.setBorder(null);
		scrollPane.setViewportView(table);
		//美化表格
		table.setFillsViewportHeight(true);
		table.setToolTipText("");
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		table.setBackground(new Color(248, 248, 255));
		table.setBorder(null);
		table.setShowGrid(false);// 是否展示网格
		table.setSelectionBackground(new Color(0, 191, 255));// 设置所选单元格的背景色
		table.setSelectionForeground(Color.white);// 设置所选单元格的前景色
		table.setRowHeight(40);// 设置所有单元格的高度
		
		// 设置内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 单元格渲染器
		tcr.setHorizontalAlignment(JLabel.CENTER);// 居中显示
		table.setDefaultRenderer(Object.class, tcr);// 设置渲染器
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(255, 250, 250)));
		
		// 获得表格头
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(255, 255, 255));// 设置表格头的背景色
		header.setReorderingAllowed(false);// 设置用户不可拖动表格头
		header.setResizingAllowed(false);// 用户不可拖动表格头

	}

	// 删除方法
	public void btnDeleteAction() {
		int rowIndex = table.getSelectedRow();
		if (rowIndex < 0) {
			return;
		}
		tjyTableModel etm = (tjyTableModel) table.getModel();
		String id = etm.getValueAt(rowIndex, 0).toString();
		int option = JOptionPane.showConfirmDialog(null, "你确定删除商品编号为" + id + "的商品吗？", "删除提示",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			LendService es = new LendService();
			int result = es.deleteLend(id);
			if (result > 0) {
				ArrayList jy = etm.getReade();
				jy.remove(rowIndex); // 移除选中这一行的记录
				etm = new tjyTableModel(jy);
				ArrayList<Record_item> e = es.getAllitem(); // 查询全部信息
				tjyTableModel a = new tjyTableModel(e);
				table.setModel(a);
				// Tables.setModel(etm);
			}
		} else {

		}

	}
}
