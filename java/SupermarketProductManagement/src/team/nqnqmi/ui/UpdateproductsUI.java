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
	private JTextField txtProductName;// ����
	private JTextField txtProductSales;// ����
	private JTextField txtProducer;// ������
	private JTextField txtCode;// code��
	private JTextField txtProductPrice;// ��Ʒ�۸�
	private JComboBox Products_state;// ��Ʒ״̬
	private JComboBox Products_category;// ��Ʒ���
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
		LabproductName.setFont(new Font("������", Font.PLAIN, 12));
		LabproductName.setBounds(238, 141, 60, 25);
		contentPanel.add(LabproductName);

		JLabel LabproductAuthor = new JLabel("\u4E66\u7C4D\u4F5C\u8005\uFF1A");
		LabproductAuthor.setFont(new Font("������", Font.PLAIN, 12));
		LabproductAuthor.setBounds(238, 181, 60, 25);
		contentPanel.add(LabproductAuthor);

		JLabel products_press = new JLabel("\u51FA\u7248\u793E\uFF1A");
		products_press.setFont(new Font("������", Font.PLAIN, 12));
		products_press.setBounds(238, 222, 48, 25);
		contentPanel.add(products_press);

		JLabel Labcode = new JLabel("code\u7F16\u7801\uFF1A");
		Labcode.setFont(new Font("������", Font.PLAIN, 12));
		Labcode.setBounds(238, 262, 60, 25);
		contentPanel.add(Labcode);

		JLabel Labproducts_category = new JLabel("\u4E66\u7C4D\u7C7B\u522B\uFF1A");
		Labproducts_category.setFont(new Font("������", Font.PLAIN, 12));
		Labproducts_category.setBounds(238, 302, 60, 25);
		contentPanel.add(Labproducts_category);

		JLabel LabProducts_state = new JLabel("\u4E66\u7C4D\u72B6\u6001\uFF1A");
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

		JLabel LabproductPrice = new JLabel("\u4E66\u7C4D\u4EF7\u683C\uFF1A");
		LabproductPrice.setFont(new Font("������", Font.PLAIN, 12));
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

		Products_category = new JComboBox();//��̬��ȡ���
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
		priceHite.setFont(new Font("΢���ź� Light", Font.PLAIN, 12));
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
		// �����޸Ĳ���
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAlterComponent();// �����޸Ĳ����ķ���
			}
		});
		btnAlter.setBounds(383, 430, 75, 35);
		contentPanel.add(btnAlter);

	}

	// ���Եķ���,����ͨ���û��������Ϣ�е�code������ʾ
	public void init(int code) {
		productsService bs = new productsService();
		product = bs.getproductsBycode(code);
		if (product != null) {
			// ��ͨ��code���ȡ�������������ͼ�ν�����
			txtProductName.setText(product.getproducts_name());
			txtProductSales.setText(product.getproducts_author());
			txtProducer.setText(product.getproducts_press());
			txtCode.setText(String.valueOf((product.getproducts_code())));
			Products_category.setSelectedItem(product.getCategory_id());
			Products_state.setSelectedItem(product.getProducts_state());
			txtProductPrice.setText(String.valueOf(product.getproducts_price()));
		} else {
			JOptionPane.showMessageDialog(null, "������code������", "�޸�", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	// ���Եķ���,����ͨ���û��������Ϣ�е��������޸���������ʾ
	public void init(String productname) {
		productsService bs = new productsService();
		product = bs.getproductsByproductsName(productname);
		if (product != null) {
			// ��ͨ��code���ȡ�������������ͼ�ν�����
			txtProductName.setText(product.getproducts_name());
			txtProductSales.setText(product.getproducts_author());
			txtProducer.setText(product.getproducts_press());
			txtCode.setText(String.valueOf((product.getproducts_code())));
			Products_category.setSelectedItem(product.getCategory_id());
			Products_state.setSelectedItem(product.getProducts_state());
			txtProductPrice.setText(String.valueOf(product.getproducts_price()));
		} else {
			JOptionPane.showMessageDialog(null, "����Ҫ�޸ĵ���Ʒ������", "�޸�", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

	}

	public void getAlterComponent() {
		// ���Ȼ�ȡ�û��ڽ����������ֵ
		String productName = txtProductName.getText();// ����
		String productAuthor = txtProductSales.getText();// ����
		String productPress = txtProducer.getText();// ������
		int productcode = product.getproducts_code();// code��
		String productCategory = (String) Products_category.getSelectedItem();
		int booskCategory = Integer.valueOf(productCategory);// ��Ʒ���
		String productstate = (String) Products_state.getSelectedItem();// ��Ʒ״̬
		int productprice = 0;// �鱾�۸�
		// ���û��������Ʒ�۸�����жϣ��������������
		if (!"".equals(txtProductPrice.getText()) && isNumeric(txtProductPrice.getText())) {
			productprice = Integer.valueOf(txtProductPrice.getText());
			if (productprice < 0 || productprice > 1000) {
				priceHite.setText("��Ʒ�۸������0-1000֮�����");
				return;
			}
		} else {
			txtProductPrice.setText("");
			priceHite.setText("��Ʒ�۸������0-1000֮�����");
			return;
		}
		// ���ӽ����ȡ����ֵ���з�װ��products����
		products product = new products(productName, productAuthor, productPress, productcode, booskCategory, productstate, productprice);
		productsService bs = new productsService();// ����service����
		int result = bs.UpdateByproductName(product);// ִ���޸Ĳ���
		if (result > 0) {// ��ʾ����ɹ�
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "���", JOptionPane.INFORMATION_MESSAGE);
			// �ͷŴ�����Դ
			this.dispose();
			// ��ҳ���Ͻ�����ʾ
//			�����µı��ģ��
			// ���û��޸�֮�����Ϣ��ʾ�����ؼ���
			ArrayList<products> products = new ArrayList<>();
			products.add(product);
			productTableModel etm = new productTableModel(products);// ����productģ��
			ProductUI.Tables.setModel(etm);
			ProductUI.txtproducteName.setText("");
			ProductUI.txtproductNumber.setText("");
		}

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

	// ����logo
	public void setLOGO() {
		// �޸�ͼ��
		Toolkit tk = Toolkit.getDefaultToolkit();
		// ��ȡͼƬ ����ͼƬ��ʽ������
		java.awt.Image img = tk.getImage("picture\\fox.png");
		// ����������ͼ��
		this.setIconImage(img);

	}

}
