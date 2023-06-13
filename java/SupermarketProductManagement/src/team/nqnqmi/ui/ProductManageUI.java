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
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import team.nqnqmi.Service.productsService;
import team.nqnqmi.bean.products;

public class ProductManageUI extends JPanel {

	public JTable Tables;
	public JTextField txtproducteName;
	public JTextField txtproductNumber;
	private productTableModel btl;
	private String productname;// 书名输入框
	private String productNumber;// code输入框

	/**
	 * Create the panel.
	 */
	public ProductManageUI() {
		showComponent();
	}

	public void showComponent() {

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

		JLabel LabBoookName = new JLabel("\u4E66\u540D\uFF1A");
		LabBoookName.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		LabBoookName.setBounds(490, 108, 45, 20);
		panelBig_Header.add(LabBoookName);

		txtproducteName = new JTextField();
		txtproducteName.setBounds(545, 106, 150, 25);
		panelBig_Header.add(txtproducteName);
		txtproducteName.setColumns(10);

		JLabel LabproductNumber = new JLabel("code\uFF1A");
		LabproductNumber.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		LabproductNumber.setBounds(725, 108, 45, 20);
		panelBig_Header.add(LabproductNumber);

		txtproductNumber = new JTextField();
		txtproductNumber.setColumns(10);
		txtproductNumber.setBounds(780, 106, 150, 25);
		panelBig_Header.add(txtproductNumber);

		JButton btnLend = new JButton("\u5E2E\u52A9");
		btnLend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLend.setBackground(new Color(153, 50, 204));
				btnLend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLend.setBackground(new Color(255, 0, 255));
			}
		});
		btnLend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpDocUI hd=new HelpDocUI();
				hd.setVisible(true);
			}
		});
		btnLend.setForeground(new Color(255, 255, 255));
		btnLend.setBackground(new Color(255, 0, 255));
		btnLend.setBounds(934, 179, 100, 40);
		panelBig_Header.add(btnLend);

		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productsService bs = null;
				int results = 0;// 删除结果返回值
				// 首先获得两个输入框中的信息
				productname = txtproducteName.getText();// 商品名称
				productNumber = txtproductNumber.getText();// code码
				// 如果两个输入框是空，并且没有选中表格中的任何一行，则结束方法
				if ("".equals(productname) && "".equals(productNumber) && Tables.getSelectedRow() < 0) {
					RemainUI ru=new RemainUI();
					ru.setVisible(true);
					return;
				}
				// 如果书名不为空则进行判断用户输入的商品是否存在于数据库中
				if (!"".equals(productname)) {
					// 对用户输入的商品进行判断
					bs = new productsService();
					products product = bs.getproductsByproductsName(productname);
					if (product == null) {
						JOptionPane.showMessageDialog(null, "您需要删除的商品不存在！");
						return;
					} else {
						int option = JOptionPane.showConfirmDialog(null, "你确定删除《" + productname + "》吗？", "删除提示",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							results = bs.deleteproduct(productname);
						}

						if (results > 0) {
							txtproducteName.setText("");
							txtproductNumber.setText("");
							JOptionPane.showMessageDialog(null, "删除成功");
							Tables.setModel(new DefaultTableModel());// 设置空的表格模型
							btl = new productTableModel(bs.getAll());// 调用service类中的查询所有数据的方法进行查询
							Tables.setModel(btl);// 将查询到的结果设置为表格模型
						}
					}
				} else if (!"".equals(productNumber) && isNumeric(productNumber)) {
					int productnumber = Integer.valueOf(productNumber);
					bs = new productsService();
					products product = bs.getproductsBycode(productnumber);
					if (product == null) {
						JOptionPane.showMessageDialog(null, "您需要删除的商品不存在！");
					} else {
						int option = JOptionPane.showConfirmDialog(null, "你确定删除code为" + productnumber + "吗？", "删除提示",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							results = bs.deleteproduct(productnumber);
						}
						System.out.println(results);
						if (results > 0) {
							txtproducteName.setText("");
							txtproductNumber.setText("");
							JOptionPane.showMessageDialog(null, "删除成功");
							txtproducteName.setText("");
							Tables.setModel(new DefaultTableModel());// 设置空的表格模型
							btl = new productTableModel(bs.getAll());// 调用service类中的查询所有数据的方法进行查询
							Tables.setModel(btl);// 将查询到的结果设置为表格模型
						}
					}

				}

			}
		});
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setBackground(new Color(255, 140, 0));
				btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setBackground(new Color(255, 160, 122));
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(255, 160, 122));
		btnDelete.setBounds(814, 179, 100, 40);
		panelBig_Header.add(btnDelete);

		JButton btnAdd = new JButton("\u589E\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addproduct ubu = new Addproduct(ProductManageUI.this);
				ubu.setVisible(true);
			}
		});
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0, 191, 255));
				btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(0, 255, 255));
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(0, 255, 255));
		btnAdd.setBounds(694, 179, 100, 40);
		panelBig_Header.add(btnAdd);

		// 商品信息修改
		JButton btnAlter = new JButton("\u4FEE\u6539");
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 首先获得两个输入框中的信息
				productname = txtproducteName.getText();
				productNumber = txtproductNumber.getText();
				// 如果两个输入框是空，并且没有选中表格中的任何一行，则结束方法
				if ("".equals(productname) && "".equals(productNumber) && Tables.getSelectedRow() < 0) {
					RemainUI ru=new RemainUI();
					ru.setVisible(true);
					return;
				}
				// 如果书名输入框有值,通过书名进行回显,如果书名输入框没有值，则进行code修改
				if (!"".equals(productname)) {
					UpdateproductsUI ubu = new UpdateproductsUI(ProductManageUI.this, productname);
					ubu.setVisible(true);
				} else if (!"".equals(productNumber)) {
					int productsnumber = Integer.valueOf(productNumber);
					UpdateproductsUI ubu = new UpdateproductsUI(ProductManageUI.this, productsnumber);
					ubu.setVisible(true);
				}

			}
		});
		btnAlter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlter.setBackground(new Color(46, 139, 87));
				btnAlter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAlter.setBackground(new Color(0, 255, 127));
			}
		});
		btnAlter.setForeground(Color.WHITE);
		btnAlter.setBackground(new Color(0, 255, 127));
		btnAlter.setBounds(574, 179, 100, 40);
		panelBig_Header.add(btnAlter);

		// 商品信息查询
		JButton btnSearch = new JButton("\u67E5\u8BE2");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productname = txtproducteName.getText();// 获得用户输入的书名
				productNumber = txtproductNumber.getText();// 获得用户输入的code码
				// 如果两个输入框都没有信息的时候,将数据库中所有的书本全部查询出来
				if ("".equals(productname) && "".equals(productNumber) || productname == null || productNumber == null) {
					Tables.setModel(new DefaultTableModel());// 设置空的表格模型
					productsService bs = new productsService();
					btl = new productTableModel(bs.getAll());// 调用service类中的查询所有数据的方法进行查询
					Tables.setModel(btl);// 将查询到的结果设置为表格模型

					// 当用户输入书名进行查询的时侯
				} else if (!"".equals(productname) && productname != null) {
					Tables.setModel(new DefaultTableModel());// 设置空表格模型
					productsService bs = new productsService();
					products product = bs.getproductsByproductsName(productname);// 通过名字进行查询商品，将查询结果封装成products对象
					if (product == null) {// 如果product是空，说明数据库中没有用户输入的书名,给出提示,并将信息栏设置为空
						JOptionPane.showMessageDialog(null, "您输入的书名不存在,请重新输入");
						txtproducteName.setText("");
						txtproductNumber.setText("");
						return;
					} else {// 有查询结果的时候，将两个输入栏清空，并将数据打包成表格模型,显示在表格中
						txtproducteName.setText("");
						txtproductNumber.setText("");
						// 构造表格模型
						ArrayList<products> products = new ArrayList<>();
						products.add(product);
						btl = new productTableModel(products);
						Tables.setModel(btl);
					}

					// 如果代码执行到此处说明用户没有输入书名，进行code码查询商品
				} else if (!"".equals("productNumber") && productNumber != null) {
					int code = 0;
					Tables.setModel(new DefaultTableModel());// 先将模型设置为空

					// 如果用户输入的是数字则将其装换成int类型,如果输入的不是int提示不合法
					if (isNumeric(productNumber)) {// 这个方法是判断用户在code码输入栏中输入的信息是否是数字
						code = Integer.parseInt(productNumber);
					} else {// 用户输入不是数字的情况
						JOptionPane.showMessageDialog(null, "您输入的code不合法，请重新输入");
						txtproducteName.setText("");
						return;
					}
					System.out.println(code);
					productsService bs = new productsService();
					products product = bs.getproductsBycode(code);// 将从数据库中获取的值封装成对象之后存储在product变量中
					System.out.println(product);

					// 如果product为空说明并没有从数据库获得数据
					if (product == null) {
						JOptionPane.showMessageDialog(null, "您输入的code码错误，请重新输入");
						txtproductNumber.setText("");
						return;
					} else {
						// 构造表格模型
						ArrayList<products> products = new ArrayList<>();
						products.add(product);
						btl = new productTableModel(products);
						Tables.setModel(btl);
						txtproductNumber.setText("");
					}

				}

			}
		});
		// 按钮的移入移除效果
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setBackground(new Color(255, 182, 193));
				btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			// 移出效果
			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setBackground(new Color(147, 112, 219));
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(147, 112, 219));
		btnSearch.setBounds(454, 179, 100, 40);
		panelBig_Header.add(btnSearch);

		UIManager.put("ScrollBar.thumb", Color.black);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(21, 251, 1600, 672);
		panelBig.add(scrollPane);

		// 表格
		Tables = new JTable();
		// 给表格模型添加鼠标点击事件
		Tables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 获取鼠标点击的次数
				if (e.getClickCount() == 2) {// 如果鼠标双击两次执行方法
					MouseClick();
				}
				if (e.getButton() == MouseEvent.BUTTON3 && e.getClickCount() == 1) {
					btnDelete();
				}

			}
		});
		Tables.setFillsViewportHeight(true);
		Tables.setToolTipText("");
		Tables.setForeground(new Color(0, 0, 0));
		Tables.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		Tables.setBackground(new Color(248, 248, 255));
		Tables.setBorder(null);
		Tables.setShowGrid(false);// 是否展示网格
		Tables.setSelectionBackground(new Color(0, 191, 255));// 设置所选单元格的背景色
		Tables.setSelectionForeground(Color.white);// 设置所选单元格的前景色
//		Tables.setRowMargin(2);设置单元格之间的空白间距
//		Tables.setRowHeight(20, 20);//设置指定单元格的高度
		Tables.setRowHeight(40);// 设置所有单元格的高度

//		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
//
//	       render.setHorizontalAlignment(SwingConstants.CENTER);
//
//	       Tables.getColumn("商品编号").setCellRenderer(render);

		scrollPane.setViewportView(Tables);
		Tables.setModel(new DefaultTableModel());
		productsService bs = new productsService();
		productTableModel btl = new productTableModel(bs.getAll());
		Tables.setModel(btl);
		// 获得表格头
		JTableHeader header = Tables.getTableHeader();
		header.setBackground(new Color(255, 255, 255));// 设置表格头的背景色
		header.setReorderingAllowed(false);// 设置用户不可拖动表格头
		header.setResizingAllowed(false);// 用户不可拖动表格头

		// 设置内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 单元格渲染器
		tcr.setHorizontalAlignment(JLabel.CENTER);// 居中显示
		Tables.setDefaultRenderer(Object.class, tcr);// 设置渲染器
		scrollPane.setViewportView(Tables);
		Tables.setBorder(new LineBorder(new Color(255, 250, 250)));
	}

	// 鼠标双击的方法
	public void MouseClick() {
		// 获得鼠标双击的表格行
		// getSelectedRow()返回第一个选定行的索引，如果没有选择行，则返回-1。
		int rowIndex = Tables.getSelectedRow();
		System.out.println(rowIndex);
		if (rowIndex < 0) {// 没有选中表格行
			return;// 结束方法
		}

		// 获得表格模型
		productTableModel btm = (productTableModel) Tables.getModel();
		// 获得选中行商品的书名,(行号,列号)
		String productName = btm.getValueAt(rowIndex, 1).toString();
		System.out.println(productName);
		// 打开页面修改信息
		UpdateproductsUI ubu = new UpdateproductsUI(ProductManageUI.this, productName);
		ubu.setVisible(true);

	}

	// 鼠标右键删除操作
	public void btnDelete() {
		int results=0;//受删除的语句行
		// 获得鼠标双击的表格行
		// getSelectedRow()返回第一个选定行的索引，如果没有选择行，则返回-1。
		int rowIndex = Tables.getSelectedRow();
		System.out.println(rowIndex);
		if (rowIndex < 0) {// 没有选中表格行
			return;// 结束方法
		}
		// 获得表格模型
		productTableModel btm = (productTableModel) Tables.getModel();
		// 获得选中行商品的书名
		String productName = btm.getValueAt(rowIndex, 1).toString();
		// 通过商品名称进行删除操作
		productsService bs=new productsService();
		int option = JOptionPane.showConfirmDialog(null, "你确定删除《" + productName + "》吗？", "删除提示",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			results=bs.deleteproduct(productName);
		}
		if(results>0) {//删除成功
			JOptionPane.showMessageDialog(null, "删除成功");
			//将删除之后的商品显示在表格控件中
			Tables.setModel(new DefaultTableModel());// 设置空的表格模型
			btl = new productTableModel(bs.getAll());// 调用service类中的查询所有数据的方法进行查询
			Tables.setModel(btl);// 将查询到的结果设置为表格模型
		}

	}

	// 用于判断输入的是否是数字
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
