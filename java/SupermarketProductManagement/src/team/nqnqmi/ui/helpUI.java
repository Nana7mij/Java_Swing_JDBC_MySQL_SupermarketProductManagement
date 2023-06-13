//package team.nqnqmi.ui;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//
//import team.nqnqmi.Service.productsService;
//import team.nqnqmi.bean.products;
//import javax.swing.JEditorPane;
//
//public class helpUI extends JDialog {
//
//	private final JPanel contentPanel = new JPanel();
//	ProductManageUI ProductUI = null;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			AddproductsUI dialog = new AddproductsUI();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 */
//	public helpUI() {
//		showComponent();
//	}
//
//	public helpUI(ProductManageUI ProductUI) {
//		showComponent();
//		this.ProductUI = ProductUI;
//	}
//
//	public void showComponent() {
//		setTitle("\u4FEE\u6539");
//		setResizable(false);
//		setIcon();
//		setBounds(100, 100, 685, 786);
//		this.setLocationRelativeTo(null);
//		getContentPane().setLayout(null);
//		contentPanel.setBounds(0, 0, 669, 747);
//		contentPanel.setBackground(new Color(248, 248, 255));
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel);
//		contentPanel.setLayout(null);
//
//		JButton btnExit = new JButton("\u9000\u51FA");
//		btnExit.setBackground(new Color(0, 255, 255));
//		btnExit.setBounds(265, 438, 75, 35);
//		contentPanel.add(btnExit);
//		
//		JEditorPane edHelp = new JEditorPane();
//		edHelp.setBounds(52, 34, 564, 367);
//		contentPanel.add(edHelp);
//	}
//
//	// ����ͼ��
//	public void setIcon() {
//		// �޸�ͼ��
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		// ��ȡͼƬ ����ͼƬ��ʽ������
//		java.awt.Image img = tk.getImage("picture\\fox.png");
//		// ����������ͼ��
//		this.setIconImage(img);
//	}
//
//	// �����ж�������Ƿ�������
//	public static boolean isNumeric(String str) {
//		for (int i = str.length(); --i >= 0;) {
//			if (!Character.isDigit(str.charAt(i))) {
//				return false;
//			}
//		}
//		return true;
//	}
//}
