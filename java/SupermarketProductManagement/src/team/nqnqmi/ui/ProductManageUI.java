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
	private String productname;// ���������
	private String productNumber;// code�����

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
		LabBoookName.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LabBoookName.setBounds(490, 108, 45, 20);
		panelBig_Header.add(LabBoookName);

		txtproducteName = new JTextField();
		txtproducteName.setBounds(545, 106, 150, 25);
		panelBig_Header.add(txtproducteName);
		txtproducteName.setColumns(10);

		JLabel LabproductNumber = new JLabel("code\uFF1A");
		LabproductNumber.setFont(new Font("΢���ź�", Font.PLAIN, 13));
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
				int results = 0;// ɾ���������ֵ
				// ���Ȼ������������е���Ϣ
				productname = txtproducteName.getText();// ��Ʒ����
				productNumber = txtproductNumber.getText();// code��
				// �������������ǿգ�����û��ѡ�б���е��κ�һ�У����������
				if ("".equals(productname) && "".equals(productNumber) && Tables.getSelectedRow() < 0) {
					RemainUI ru=new RemainUI();
					ru.setVisible(true);
					return;
				}
				// ���������Ϊ��������ж��û��������Ʒ�Ƿ���������ݿ���
				if (!"".equals(productname)) {
					// ���û��������Ʒ�����ж�
					bs = new productsService();
					products product = bs.getproductsByproductsName(productname);
					if (product == null) {
						JOptionPane.showMessageDialog(null, "����Ҫɾ������Ʒ�����ڣ�");
						return;
					} else {
						int option = JOptionPane.showConfirmDialog(null, "��ȷ��ɾ����" + productname + "����", "ɾ����ʾ",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							results = bs.deleteproduct(productname);
						}

						if (results > 0) {
							txtproducteName.setText("");
							txtproductNumber.setText("");
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
							Tables.setModel(new DefaultTableModel());// ���ÿյı��ģ��
							btl = new productTableModel(bs.getAll());// ����service���еĲ�ѯ�������ݵķ������в�ѯ
							Tables.setModel(btl);// ����ѯ���Ľ������Ϊ���ģ��
						}
					}
				} else if (!"".equals(productNumber) && isNumeric(productNumber)) {
					int productnumber = Integer.valueOf(productNumber);
					bs = new productsService();
					products product = bs.getproductsBycode(productnumber);
					if (product == null) {
						JOptionPane.showMessageDialog(null, "����Ҫɾ������Ʒ�����ڣ�");
					} else {
						int option = JOptionPane.showConfirmDialog(null, "��ȷ��ɾ��codeΪ" + productnumber + "��", "ɾ����ʾ",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							results = bs.deleteproduct(productnumber);
						}
						System.out.println(results);
						if (results > 0) {
							txtproducteName.setText("");
							txtproductNumber.setText("");
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
							txtproducteName.setText("");
							Tables.setModel(new DefaultTableModel());// ���ÿյı��ģ��
							btl = new productTableModel(bs.getAll());// ����service���еĲ�ѯ�������ݵķ������в�ѯ
							Tables.setModel(btl);// ����ѯ���Ľ������Ϊ���ģ��
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

		// ��Ʒ��Ϣ�޸�
		JButton btnAlter = new JButton("\u4FEE\u6539");
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���Ȼ������������е���Ϣ
				productname = txtproducteName.getText();
				productNumber = txtproductNumber.getText();
				// �������������ǿգ�����û��ѡ�б���е��κ�һ�У����������
				if ("".equals(productname) && "".equals(productNumber) && Tables.getSelectedRow() < 0) {
					RemainUI ru=new RemainUI();
					ru.setVisible(true);
					return;
				}
				// ��������������ֵ,ͨ���������л���,������������û��ֵ�������code�޸�
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

		// ��Ʒ��Ϣ��ѯ
		JButton btnSearch = new JButton("\u67E5\u8BE2");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productname = txtproducteName.getText();// ����û����������
				productNumber = txtproductNumber.getText();// ����û������code��
				// ������������û����Ϣ��ʱ��,�����ݿ������е��鱾ȫ����ѯ����
				if ("".equals(productname) && "".equals(productNumber) || productname == null || productNumber == null) {
					Tables.setModel(new DefaultTableModel());// ���ÿյı��ģ��
					productsService bs = new productsService();
					btl = new productTableModel(bs.getAll());// ����service���еĲ�ѯ�������ݵķ������в�ѯ
					Tables.setModel(btl);// ����ѯ���Ľ������Ϊ���ģ��

					// ���û������������в�ѯ��ʱ��
				} else if (!"".equals(productname) && productname != null) {
					Tables.setModel(new DefaultTableModel());// ���ÿձ��ģ��
					productsService bs = new productsService();
					products product = bs.getproductsByproductsName(productname);// ͨ�����ֽ��в�ѯ��Ʒ������ѯ�����װ��products����
					if (product == null) {// ���product�ǿգ�˵�����ݿ���û���û����������,������ʾ,������Ϣ������Ϊ��
						JOptionPane.showMessageDialog(null, "�����������������,����������");
						txtproducteName.setText("");
						txtproductNumber.setText("");
						return;
					} else {// �в�ѯ�����ʱ�򣬽�������������գ��������ݴ���ɱ��ģ��,��ʾ�ڱ����
						txtproducteName.setText("");
						txtproductNumber.setText("");
						// ������ģ��
						ArrayList<products> products = new ArrayList<>();
						products.add(product);
						btl = new productTableModel(products);
						Tables.setModel(btl);
					}

					// �������ִ�е��˴�˵���û�û����������������code���ѯ��Ʒ
				} else if (!"".equals("productNumber") && productNumber != null) {
					int code = 0;
					Tables.setModel(new DefaultTableModel());// �Ƚ�ģ������Ϊ��

					// ����û����������������װ����int����,�������Ĳ���int��ʾ���Ϸ�
					if (isNumeric(productNumber)) {// ����������ж��û���code�����������������Ϣ�Ƿ�������
						code = Integer.parseInt(productNumber);
					} else {// �û����벻�����ֵ����
						JOptionPane.showMessageDialog(null, "�������code���Ϸ�������������");
						txtproducteName.setText("");
						return;
					}
					System.out.println(code);
					productsService bs = new productsService();
					products product = bs.getproductsBycode(code);// �������ݿ��л�ȡ��ֵ��װ�ɶ���֮��洢��product������
					System.out.println(product);

					// ���productΪ��˵����û�д����ݿ�������
					if (product == null) {
						JOptionPane.showMessageDialog(null, "�������code���������������");
						txtproductNumber.setText("");
						return;
					} else {
						// ������ģ��
						ArrayList<products> products = new ArrayList<>();
						products.add(product);
						btl = new productTableModel(products);
						Tables.setModel(btl);
						txtproductNumber.setText("");
					}

				}

			}
		});
		// ��ť�������Ƴ�Ч��
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setBackground(new Color(255, 182, 193));
				btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			// �Ƴ�Ч��
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

		// ���
		Tables = new JTable();
		// �����ģ�����������¼�
		Tables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ��ȡ������Ĵ���
				if (e.getClickCount() == 2) {// ������˫������ִ�з���
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
		Tables.setFont(new Font("΢���ź� Light", Font.PLAIN, 14));
		Tables.setBackground(new Color(248, 248, 255));
		Tables.setBorder(null);
		Tables.setShowGrid(false);// �Ƿ�չʾ����
		Tables.setSelectionBackground(new Color(0, 191, 255));// ������ѡ��Ԫ��ı���ɫ
		Tables.setSelectionForeground(Color.white);// ������ѡ��Ԫ���ǰ��ɫ
//		Tables.setRowMargin(2);���õ�Ԫ��֮��Ŀհ׼��
//		Tables.setRowHeight(20, 20);//����ָ����Ԫ��ĸ߶�
		Tables.setRowHeight(40);// �������е�Ԫ��ĸ߶�

//		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
//
//	       render.setHorizontalAlignment(SwingConstants.CENTER);
//
//	       Tables.getColumn("��Ʒ���").setCellRenderer(render);

		scrollPane.setViewportView(Tables);
		Tables.setModel(new DefaultTableModel());
		productsService bs = new productsService();
		productTableModel btl = new productTableModel(bs.getAll());
		Tables.setModel(btl);
		// ��ñ��ͷ
		JTableHeader header = Tables.getTableHeader();
		header.setBackground(new Color(255, 255, 255));// ���ñ��ͷ�ı���ɫ
		header.setReorderingAllowed(false);// �����û������϶����ͷ
		header.setResizingAllowed(false);// �û������϶����ͷ

		// �������ݾ���
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// ��Ԫ����Ⱦ��
		tcr.setHorizontalAlignment(JLabel.CENTER);// ������ʾ
		Tables.setDefaultRenderer(Object.class, tcr);// ������Ⱦ��
		scrollPane.setViewportView(Tables);
		Tables.setBorder(new LineBorder(new Color(255, 250, 250)));
	}

	// ���˫���ķ���
	public void MouseClick() {
		// ������˫���ı����
		// getSelectedRow()���ص�һ��ѡ���е����������û��ѡ���У��򷵻�-1��
		int rowIndex = Tables.getSelectedRow();
		System.out.println(rowIndex);
		if (rowIndex < 0) {// û��ѡ�б����
			return;// ��������
		}

		// ��ñ��ģ��
		productTableModel btm = (productTableModel) Tables.getModel();
		// ���ѡ������Ʒ������,(�к�,�к�)
		String productName = btm.getValueAt(rowIndex, 1).toString();
		System.out.println(productName);
		// ��ҳ���޸���Ϣ
		UpdateproductsUI ubu = new UpdateproductsUI(ProductManageUI.this, productName);
		ubu.setVisible(true);

	}

	// ����Ҽ�ɾ������
	public void btnDelete() {
		int results=0;//��ɾ���������
		// ������˫���ı����
		// getSelectedRow()���ص�һ��ѡ���е����������û��ѡ���У��򷵻�-1��
		int rowIndex = Tables.getSelectedRow();
		System.out.println(rowIndex);
		if (rowIndex < 0) {// û��ѡ�б����
			return;// ��������
		}
		// ��ñ��ģ��
		productTableModel btm = (productTableModel) Tables.getModel();
		// ���ѡ������Ʒ������
		String productName = btm.getValueAt(rowIndex, 1).toString();
		// ͨ����Ʒ���ƽ���ɾ������
		productsService bs=new productsService();
		int option = JOptionPane.showConfirmDialog(null, "��ȷ��ɾ����" + productName + "����", "ɾ����ʾ",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			results=bs.deleteproduct(productName);
		}
		if(results>0) {//ɾ���ɹ�
			JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			//��ɾ��֮�����Ʒ��ʾ�ڱ��ؼ���
			Tables.setModel(new DefaultTableModel());// ���ÿյı��ģ��
			btl = new productTableModel(bs.getAll());// ����service���еĲ�ѯ�������ݵķ������в�ѯ
			Tables.setModel(btl);// ����ѯ���Ľ������Ϊ���ģ��
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

}
