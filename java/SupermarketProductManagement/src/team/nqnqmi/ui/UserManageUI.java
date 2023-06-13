package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import team.nqnqmi.Service.UserService;
import team.nqnqmi.bean.Reader;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserManageUI extends JPanel {
	public JTable table1;
	private JTextField txtid;
	private JTextField txtname;

	/**
	 * Create the panel.
	 */
	public UserManageUI() {
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
		panelBig_Header.setBounds(21, 10, 1600, 172);
		panelBig.add(panelBig_Header);
		panelBig_Header.setLayout(null);

		JButton btnAdd = new JButton("添加");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zhuche tj = new zhuche();
				tj.setVisible(true);
				UserService sj = new UserService();
				ArrayList<Reader> e2 = sj.getAllreader();
				UserTableModel etm = new UserTableModel(e2);
				table1.setModel(etm);

			}
		});
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(219, 121, 147));
				btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(221, 160, 221));
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(221, 160, 221));
		btnAdd.setBounds(637, 104, 100, 40);
		panelBig_Header.add(btnAdd);

		JButton btnAlter = new JButton("\u4FEE\u6539");
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTable();

			}
		});
		btnAlter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlter.setBackground(new Color(160, 82, 45));
				btnAlter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAlter.setBackground(new Color(210, 180, 140));
			}
		});
		btnAlter.setForeground(Color.WHITE);
		btnAlter.setBackground(new Color(210, 180, 140));
		btnAlter.setBounds(796, 104, 100, 40);
		panelBig_Header.add(btnAlter);

		JButton btnShanchu = new JButton("\u522A\u9664");
		btnShanchu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteAction();
			}
		});
		btnShanchu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnShanchu.setBackground(new Color(255, 140, 0));
				btnShanchu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnShanchu.setBackground(new Color(255, 215, 0));
			}
		});
		btnShanchu.setForeground(Color.WHITE);
		btnShanchu.setBackground(new Color(255, 215, 0));
		btnShanchu.setBounds(951, 104, 100, 40);
		panelBig_Header.add(btnShanchu);

		JButton btnAdd_1 = new JButton("\u67E5\u8BE2");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				String name = txtname.getText();
				UserService es = new UserService();
				if (id != null && !"".equals(id)) {
					Reader e1 = es.getAllreader(id);
					ArrayList<Reader> user = new ArrayList<Reader>();
					user.add(e1);
					UserTableModel etm = new UserTableModel(user);
					table1.setModel(etm);
				} else if (name != null && !"".equals(name)) {
					UserTableModel etm = new UserTableModel(es.getReaderByName(name));
					table1.setModel(etm);
				}
			}
		});
		btnAdd_1.setForeground(Color.WHITE);
		btnAdd_1.setBackground(new Color(221, 160, 221));
		btnAdd_1.setBounds(495, 104, 100, 40);
		panelBig_Header.add(btnAdd_1);

		txtid = new JTextField();
		txtid.setBounds(563, 25, 152, 21);
		panelBig_Header.add(txtid);
		txtid.setColumns(10);

		JLabel LabNewLabel = new JLabel("\u6839\u636E\u7F16\u53F7\u67E5\u8BE2\uFF1A");
		LabNewLabel.setBounds(453, 28, 100, 15);
		panelBig_Header.add(LabNewLabel);

		JLabel LabNewLabel_1 = new JLabel("\u6839\u636E\u540D\u5B57\u67E5\u8BE2\uFF1A");
		LabNewLabel_1.setBounds(776, 28, 100, 15);
		panelBig_Header.add(LabNewLabel_1);

		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(886, 25, 152, 21);
		panelBig_Header.add(txtname);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 182, 1600, 779);
		panelBig.add(scrollPane);

		table1 = new JTable();
		table1.setFillsViewportHeight(true);
		UserService sj = new UserService();
		ArrayList<Reader> e = sj.getAllreader();
		// ArrayList<Reader> product=new ArrayList<Reader>();
		// product.add(e);
		UserTableModel etm = new UserTableModel(e);
		table1.setModel(etm);
		scrollPane.setViewportView(table1);
		scrollPane.setViewportView(table1);
		
		//美化表格
		table1.setFillsViewportHeight(true);//表格高度充满
		table1.setToolTipText("");
		table1.setForeground(new Color(0, 0, 0));
		table1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		table1.setBackground(new Color(248, 248, 255));
		table1.setBorder(null);
		table1.setShowGrid(false);// 是否展示网格
		table1.setSelectionBackground(new Color(0, 191, 255));// 设置所选单元格的背景色
		table1.setSelectionForeground(Color.white);// 设置所选单元格的前景色
		table1.setRowHeight(40);// 设置所有单元格的高度
		
		// 设置内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 单元格渲染器
		tcr.setHorizontalAlignment(JLabel.CENTER);// 居中显示
		table1.setDefaultRenderer(Object.class, tcr);// 设置渲染器
		scrollPane.setViewportView(table1);
		table1.setBorder(null);
		
		// 获得表格头
		JTableHeader header = table1.getTableHeader();
		header.setBackground(new Color(255, 255, 255));// 设置表格头的背景色
		header.setReorderingAllowed(false);// 设置用户不可拖动表格头
		header.setResizingAllowed(false);// 用户不可拖动表格头

	}

	public void btnDeleteAction() {
		int rowIndex = table1.getSelectedRow();
		if (rowIndex < 0) {
			return;
		}
		if (table1.getModel().getColumnCount() == 6) {
			UserTableModel etm = (UserTableModel) table1.getModel();
			String id = etm.getValueAt(rowIndex, 0).toString();
			int option = JOptionPane.showConfirmDialog(null, "你确定删除编号为" + id + "的用户吗？", "删除提示",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				UserService es = new UserService();
				int result = es.deleteUser(id);
				if (result > 0) {
					ArrayList re = etm.getReader();
					re.remove(rowIndex);
					etm = new UserTableModel(re);
					ArrayList<Reader> e = es.getAllreader();
					UserTableModel a = new UserTableModel(e);
					table1.setModel(a);
					// Tables.setModel(etm);
				}
			}

		}
	}

	public void btnTable() {
		// 获取行数
		int rowIndex = table1.getSelectedRow();
		if (rowIndex < 0) {
			return;
		}
		// 获取表格模型
		UserTableModel tm = (UserTableModel) table1.getModel();
		String id = tm.getValueAt(rowIndex, 0).toString();
		txgreader ueui = new txgreader(this, id);
		ueui.setVisible(true);

	}
}
