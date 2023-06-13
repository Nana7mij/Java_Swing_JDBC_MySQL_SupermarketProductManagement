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
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

public class  Addproduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtProductName;			// ��Ʒ��
	private JTextField txtProductSales;			// ��Ʒ����
	private JTextField txtProducer;				// ��Ʒ����
	private JTextField txtCode;					// ��Ʒ����
	private JTextField txtProductPrice;			// ��Ʒ�۸�
	private JComboBox Products_state;			// ��Ʒ״̬(����/�л�)
	private JComboBox Products_category;		// ��Ʒ����(ˮ��/��ʳ��)
	private JLabel codehint;
	private JLabel priceHite;
	ProductManageUI ProductUI = null;

	public static void main(String[] args) {
		try {
			Addproduct dialog = new Addproduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Addproduct() {
		showComponent();

	}

	public Addproduct(ProductManageUI ProductUI) {
		showComponent();
		this.ProductUI = ProductUI;
	}

	public void showComponent() {
		setTitle("�޸�");
		this.setResizable(false);
		// �޸�ͼ��
		Toolkit tk = Toolkit.getDefaultToolkit();
		// ��ȡͼƬ ����ͼƬ��ʽ������
		java.awt.Image img = tk.getImage("picture\\�޵µ�2.png");
		// ����������ͼ��
		this.setIconImage(img);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 786);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 669, 747);
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel LabproductName = new JLabel("��Ʒ����");
		LabproductName.setFont(new Font("������", Font.PLAIN, 12));
		LabproductName.setBounds(238, 141, 60, 25);
		contentPanel.add(LabproductName);

		JLabel LabproductAuthor = new JLabel("��Ʒ����");
		LabproductAuthor.setFont(new Font("������", Font.PLAIN, 12));
		LabproductAuthor.setBounds(238, 181, 60, 25);
		contentPanel.add(LabproductAuthor);

		JLabel products_press = new JLabel("��Ʒ����");
		products_press.setFont(new Font("������", Font.PLAIN, 12));
		products_press.setBounds(238, 222, 48, 25);
		contentPanel.add(products_press);

		JLabel Labcode = new JLabel("��Ʒ����");
		Labcode.setFont(new Font("������", Font.PLAIN, 12));
		Labcode.setBounds(238, 262, 60, 25);
		contentPanel.add(Labcode);

		JLabel Labproducts_category = new JLabel("��Ʒ����");
		Labproducts_category.setFont(new Font("������", Font.PLAIN, 12));
		Labproducts_category.setBounds(238, 302, 60, 25);
		contentPanel.add(Labproducts_category);

		JLabel LabProducts_state = new JLabel("��Ʒ״̬");
		LabProducts_state.setFont(new Font("������", Font.PLAIN, 12));
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

		JLabel LabproductPrice = new JLabel("��Ʒ�۸�");
		LabproductPrice.setFont(new Font("������", Font.PLAIN, 12));
		LabproductPrice.setBounds(238, 382, 60, 25);
		contentPanel.add(LabproductPrice);

		txtCode = new JTextField();
		txtCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				codehint.setText("");
			}
		});
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

		Products_category = new JComboBox();
		Products_category.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
//		CategoryService cs=new CategoryService();
//		ArrayList<Categorys> cate=cs.getAll();
//		for(Categorys c: cate) {
//			Products_category.addItem(c.getCategory_name());
//			System.out.println(c.getCategory_name());
//		}
		
		
		Products_category.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String code = txtCode.getText();
				if ("".equals(code) || !isNumeric(code)) {
					codehint.setText("��Ʒ���������һ������");
				}

			}
		});
		Products_category.setBackground(new Color(245, 245, 220));
		Products_category.setBounds(308, 304, 150, 20);
		contentPanel.add(Products_category);

		Products_state = new JComboBox();
		Products_state.setModel(new DefaultComboBoxModel(new String[] {"�л�", "����"}));
		Products_state.setBackground(new Color(245, 245, 220));
		Products_state.setBounds(308, 344, 150, 20);
		contentPanel.add(Products_state);

		codehint = new JLabel("");
		codehint.setFont(new Font("΢���ź� Light", Font.PLAIN, 12));
		codehint.setForeground(new Color(255, 69, 0));
		codehint.setBounds(475, 267, 150, 15);
		contentPanel.add(codehint);

		priceHite = new JLabel("");
		priceHite.setFont(new Font("΢���ź� Light", Font.PLAIN, 12));
		priceHite.setForeground(new Color(255, 69, 0));
		priceHite.setBounds(468, 387, 191, 15);
		contentPanel.add(priceHite);

		JButton btnCancel = new JButton("ȡ��");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBackground(new Color(100, 149, 237));
		btnCancel.setBounds(262, 430, 75, 35);
		contentPanel.add(btnCancel);

		JButton btnNewButton_1_1 = new JButton("���");
		btnNewButton_1_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnUpdateAction(ProductUI);

			}
		});
		btnNewButton_1_1.setBounds(383, 430, 75, 35);
		contentPanel.add(btnNewButton_1_1);
	}



	// ��ȡ�û����뵽������Ϣ�ٵ���ʾ�������
	public void btnUpdateAction(ProductManageUI ProductUI) {

		String productsprice = txtProductPrice.getText();
		if ("".equals(productsprice) || !isNumeric(productsprice)) {
			priceHite.setText("��Ʒ�۸������0-1000֮�����");
		}
		// ������е��û�������Ϣ
		int productscode = 0;
		int productprice = 0;
		int productsCategory = 0;
		String productname = txtProductName.getText();
		String productAuthor = txtProductSales.getText();
		String productpress = txtProducer.getText();
		String productcode = txtCode.getText();
		String productCategory = (String) Products_category.getSelectedItem();
		productsCategory = Integer.valueOf(productCategory);
		String productstate = (String) Products_state.getSelectedItem();
		String productsprices = txtProductPrice.getText();

		// �����Ϊ��д����Ϣ�������ʾ,����������
		if ("".equals(productname) || "".equals(productAuthor) || "".equals(productpress) || "".equals(productcode)
				|| "".equals(productstate) || "".equals(productsprices)) {
			JOptionPane.showMessageDialog(null, "����δ�����ѡ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// ������Ĵ���ͼ۸����ʶ��ʶ���Ƿ�������
		if (isNumeric(productcode) && isNumeric(productsprices)) {
			// �����ֽ���ת��
			productscode = Integer.valueOf(productcode);
			productprice = Integer.valueOf(productsprices);
		} else {
			// �������ֽ������Ѳ������÷���
			JOptionPane.showMessageDialog(null, "���������Ʒ���벻�����ֻ�����Ʒ�۸�������", "��ʾ", JOptionPane.ERROR_MESSAGE);
			return;
		}
		System.out.println(productCategory);
		System.out.println(productstate);
		// ��������ִ�����ˣ�˵������һ�пɲ�������,���в������
		// ���û���������ݽ��з�װ��products����
		products product = new products(productname, productAuthor, productpress, productscode, productsCategory, productstate, productprice);
		// ����service������ò������ݷ���
		productsService bs = new productsService();
		int result = bs.Addproducts(product);
		Icon icon=new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\hint2.png");
		if (result > 0) {
			txtProductName.setText("");
			txtProductSales.setText("");
			txtProducer.setText("");
			txtCode.setText("");
			Products_category.setSelectedIndex(0);
			Products_state.setSelectedIndex(0);
			txtProductPrice.setText("");
			JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ʾ", JOptionPane.ERROR_MESSAGE,icon);
		}
		ArrayList<products> products = bs.getAll();
		productTableModel btm = new productTableModel(products);
		System.out.println(btm);
		// 4.2 ��ģ�Ͱ��ڱ��ؼ�
		ProductUI.Tables.setModel(btm);

	}
	// �����ж�������Ƿ�������
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
