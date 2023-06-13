package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import team.nqnqmi.Service.productsService;
import team.nqnqmi.Service.CategoryService;
import team.nqnqmi.bean.products;
import team.nqnqmi.bean.Categorys;

public class UpdateproductsUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtProductName;// 书名
	private JTextField txtProductSales;// 作者
	private JTextField txtProducer;// 出版社
	private JTextField txtCode;// code码
	private JTextField txtProductPrice;// 商品价格
	private JComboBox Products_state;// 商品状态
	private JComboBox Products_category;// 商品类别
	private JLabel priceHite;
	ProductManageUI ProductUI = null;
	private products product = null;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateproductsUI dialog = new UpdateproductsUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public UpdateproductsUI() {
		showComponent();

	}

	public UpdateproductsUI(ProductManageUI ProductUI, int code) {
		this.ProductUI = ProductUI;
		showComponent();
		init(code);
	}

	public UpdateproductsUI(ProductManageUI ProductUI, String productname) {
		this.ProductUI = ProductUI;
		showComponent();
		init(productname);
	}

	public void showComponent() {

		setLOGO();

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 786);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 669, 747);
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel LabproductName = new JLabel("\u4E66\u7C4D\u540D\u79F0\uFF1A");
		LabproductName.setFont(new Font("新宋体", Font.PLAIN, 12));
		LabproductName.setBounds(238, 141, 60, 25);
		contentPanel.add(LabproductName);

		JLabel LabproductAuthor = new JLabel("\u4E66\u7C4D\u4F5C\u8005\uFF1A");
		LabproductAuthor.setFont(new Font("新宋体", Font.PLAIN, 12));
		LabproductAuthor.setBounds(238, 181, 60, 25);
		contentPanel.add(LabproductAuthor);

		JLabel products_press = new JLabel("\u51FA\u7248\u793E\uFF1A");
		products_press.setFont(new Font("新宋体", Font.PLAIN, 12));
		products_press.setBounds(238, 222, 48, 25);
		contentPanel.add(products_press);

		JLabel Labcode = new JLabel("code\u7F16\u7801\uFF1A");
		Labcode.setFont(new Font("新宋体", Font.PLAIN, 12));
		Labcode.setBounds(238, 262, 60, 25);
		contentPanel.add(Labcode);

		JLabel Labproducts_category = new JLabel("\u4E66\u7C4D\u7C7B\u522B\uFF1A");
		Labproducts_category.setFont(new Font("新宋体", Font.PLAIN, 12));
		Labproducts_category.setBounds(238, 302, 60, 25);
		contentPanel.add(Labproducts_category);

		JLabel LabProducts_state = new JLabel("\u4E66\u7C4D\u72B6\u6001\uFF1A");
		LabProducts_state.setFont(new Font("新宋体", Font.PLAIN, 12));
		LabProducts_state.setBounds(238, 342, 60, 25);
		contentPanel.add(LabProducts_state);

		txtProductName = new JTextField();
		txtProductName.setBounds(308, 143, 150, 20);
		contentPanel.add(txtProductName);
		txtProductName.setColumns(10);

		txtProductSales = new JTextField();
		txtProductSales.setColumns(10);
		txtProductSales.setBounds(308, 183, 150, 20);
		contentPanel.add(txtProductSales);

		txtProducer = new JTextField();
		txtProducer.setColumns(10);
		txtProducer.setBounds(308, 224, 150, 20);
		contentPanel.add(txtProducer);

		JLabel LabproductPrice = new JLabel("\u4E66\u7C4D\u4EF7\u683C\uFF1A");
		LabproductPrice.setFont(new Font("新宋体", Font.PLAIN, 12));
		LabproductPrice.setBounds(238, 382, 60, 25);
		contentPanel.add(LabproductPrice);

		txtCode = new JTextField();
		txtCode.setEditable(false);
		txtCode.setColumns(10);
		txtCode.setBounds(308, 264, 150, 20);
		contentPanel.add(txtCode);

		txtProductPrice = new JTextField();
		txtProductPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				priceHite.setText("");
			}
		});
		txtProductPrice.setColumns(10);
		txtProductPrice.setBounds(308, 384, 150, 20);
		contentPanel.add(txtProductPrice);

		Products_category = new JComboBox();//动态获取类别
		Products_category.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
//		CategoryService cs = new CategoryService();
//		ArrayList<Categorys> category = cs.getAll();
//		for (Categorys c : category) {
//			Products_category.addItem(c.getCategory_name());
//		}
		Products_category.setBackground(new Color(245, 245, 220));
		Products_category.setBounds(308, 304, 150, 20);
		contentPanel.add(Products_category);

		Products_state = new JComboBox();
		Products_state.setModel(new DefaultComboBoxModel(new String[] { "\u53EF\u501F", "\u501F\u51FA" }));
		Products_state.setBackground(new Color(245, 245, 220));
		Products_state.setBounds(308, 344, 150, 20);
		contentPanel.add(Products_state);

		priceHite = new JLabel("");
		priceHite.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		priceHite.setForeground(new Color(255, 69, 0));
		priceHite.setBounds(468, 387, 191, 15);
		contentPanel.add(priceHite);

		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductUI.txtproducteName.setText("");
				ProductUI.txtproductNumber.setText("");
				setVisible(false);
			}
		});
		btnCancel.setBackground(new Color(240, 230, 140));
		btnCancel.setBounds(262, 430, 75, 35);
		contentPanel.add(btnCancel);

		JButton btnAlter = new JButton("\u4FEE\u6539");
		btnAlter.setBackground(Color.GREEN);
		// 进行修改操作
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAlterComponent();// 调用修改操作的方法
			}
		});
		btnAlter.setBounds(383, 430, 75, 35);
		contentPanel.add(btnAlter);

	}

	// 回显的方法,就是通过用户输入的信息中的code进行显示
	public void init(int code) {
		productsService bs = new productsService();
		product = bs.getproductsBycode(code);
		if (product != null) {
			// 将通过code码获取到的数据添加入图形界面中
			txtProductName.setText(product.getproducts_name());
			txtProductSales.setText(product.getproducts_author());
			txtProducer.setText(product.getproducts_press());
			txtCode.setText(String.valueOf((product.getproducts_code())));
			Products_category.setSelectedItem(product.getCategory_id());
			Products_state.setSelectedItem(product.getProducts_state());
			txtProductPrice.setText(String.valueOf(product.getproducts_price()));
		} else {
			JOptionPane.showMessageDialog(null, "您输入code不存在", "修改", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	// 回显的方法,就是通过用户输入的信息中的书名在修改面板进行显示
	public void init(String productname) {
		productsService bs = new productsService();
		product = bs.getproductsByproductsName(productname);
		if (product != null) {
			// 将通过code码获取到的数据添加入图形界面中
			txtProductName.setText(product.getproducts_name());
			txtProductSales.setText(product.getproducts_author());
			txtProducer.setText(product.getproducts_press());
			txtCode.setText(String.valueOf((product.getproducts_code())));
			Products_category.setSelectedItem(product.getCategory_id());
			Products_state.setSelectedItem(product.getProducts_state());
			txtProductPrice.setText(String.valueOf(product.getproducts_price()));
		} else {
			JOptionPane.showMessageDialog(null, "您需要修改的商品不存在", "修改", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

	}

	public void getAlterComponent() {
		// 首先获取用户在界面上输入的值
		String productName = txtProductName.getText();// 书名
		String productAuthor = txtProductSales.getText();// 作者
		String productPress = txtProducer.getText();// 出版社
		int productcode = product.getproducts_code();// code码
		String productCategory = (String) Products_category.getSelectedItem();
		int booskCategory = Integer.valueOf(productCategory);// 商品类别
		String productstate = (String) Products_state.getSelectedItem();// 商品状态
		int productprice = 0;// 书本价格
		// 对用户输入的商品价格进行判断，不是数字则结束
		if (!"".equals(txtProductPrice.getText()) && isNumeric(txtProductPrice.getText())) {
			productprice = Integer.valueOf(txtProductPrice.getText());
			if (productprice < 0 || productprice > 1000) {
				priceHite.setText("商品价格必须是0-1000之间的数");
				return;
			}
		} else {
			txtProductPrice.setText("");
			priceHite.setText("商品价格必须是0-1000之间的数");
			return;
		}
		// 将从界面获取到的值进行封装成products对象
		products product = new products(productName, productAuthor, productPress, productcode, booskCategory, productstate, productprice);
		productsService bs = new productsService();// 创建service对象
		int result = bs.UpdateByproductName(product);// 执行修改操作
		if (result > 0) {// 表示插入成功
			JOptionPane.showMessageDialog(null, "修改成功", "添加", JOptionPane.INFORMATION_MESSAGE);
			// 释放窗口资源
			this.dispose();
			// 在页面上进行显示
//			构造新的表格模型
			// 将用户修改之后的信息显示到表格控件中
			ArrayList<products> products = new ArrayList<>();
			products.add(product);
			productTableModel etm = new productTableModel(products);// 创造product模型
			ProductUI.Tables.setModel(etm);
			ProductUI.txtproducteName.setText("");
			ProductUI.txtproductNumber.setText("");
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

	// 设置logo
	public void setLOGO() {
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以
		java.awt.Image img = tk.getImage("picture\\fox.png");
		// 给窗体设置图标
		this.setIconImage(img);

	}

}
