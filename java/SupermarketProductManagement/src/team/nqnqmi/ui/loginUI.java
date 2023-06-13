package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;

import team.nqnqmi.Service.AdminService;
import team.nqnqmi.bean.Admin;

public class loginUI extends JPanel {

	private JLabel Labicon;
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	private JLayeredPane layeredPane;
	
	//��¼����
	public void paintComponent(Graphics g) {//��д�������ķ���
		super.paintComponent(g);
		ImageIcon image = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\background.jpg");//����ͼƬ
		image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));//����ͼƬ��С��������С
		g.drawImage(image.getImage(), 0, 0, this);//���»������
	}
	//��¼UI
	public loginUI() {
		setBackground(new Color(200, 234, 235));//��¼�����ϲ���ɫ
		setLayout(null);
		setSize(985, 550);//��¼�����ϲ��С
		// ��¼LOGO��ͼ��
		ImageIcon icon = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\Loginlogo1.png");
		Labicon = new JLabel(icon);
		Labicon.setBounds(180, 190, 200, 200);
		this.add(Labicon);
		// ��¼����ͼ��
		ImageIcon icos = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\login3.png");
		JLabel LabLoginicon = new JLabel(icos);
		LabLoginicon.setBounds(534, 189, 58, 32);
		this.add(LabLoginicon);
		// �˺�LOGO
		ImageIcon iconUser = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\user.png");
		JLabel LabAccount = new JLabel(iconUser);
		LabAccount.setBounds(425, 232, 32, 32);
		this.add(LabAccount);
		// ����LOGO
		ImageIcon iconPassword = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\lock.png");
		JLabel LabPassword = new JLabel(iconPassword);
		LabPassword.setBounds(425, 286, 32, 32);
		this.add(LabPassword);
		// �˺������
		txtLogin = new JTextField();
		txtLogin.setBounds(467, 231, 200, 35);
		this.add(txtLogin);
		txtLogin.setColumns(10);
		// �ı������
		txtPassword = new JPasswordField();
		txtPassword.setBounds(467, 285, 200, 35);
		this.add(txtPassword);

		// �ָ���
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);// ���÷ָ�����ֱ
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(400, 95, 1, 400);
		this.add(separator);
		// QQͼ��
		ImageIcon imageQQ = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\qq.png");
		JLabel LabQQ = new JLabel(imageQQ);
		LabQQ.setBounds(605, 375, 25, 25);
		this.add(LabQQ);
		// ΢��ͼ��
		ImageIcon imagewx = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\wx.png");
		JLabel Labwx = new JLabel(imagewx);
		Labwx.setBounds(640, 375, 25, 25);
		this.add(Labwx);
		// GitHubͼ��
		ImageIcon imagewb = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\github.png");
		JLabel Labwb = new JLabel(imagewb);
		Labwb.setBounds(570, 375, 25, 25);
		this.add(Labwb);

		// ��¼��ť
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String UserName = txtLogin.getText();
				String UserPwd = txtPassword.getText();
				int username = 0;
				System.out.println(isNumeric(UserName));
				boolean isNumber = isNumeric(UserName);

				if (isNumber && !"".equals(UserName)) {
					username = Integer.valueOf(UserName);
				}

				AdminService admin = new AdminService();
				Admin admins = admin.getAdminByid(username);

				if (admins == null) {
					RemainUI ra=new RemainUI("��ʾ","��������˺Ų���ȷ");
					ra.setVisible(true);
					txtLogin.setText("");
					txtPassword.setText("");
				} else if ("".equals(UserPwd)) {
					JOptionPane.showMessageDialog(null, "����������");
				} else if (!UserPwd.equals(admins.getAdmin_pwd())) {
					JOptionPane.showMessageDialog(null, "���������������,��������������");
					txtLogin.setText("");
					txtPassword.setText("");
				} else {
					new MainUI().setVisible(true);
			}

//				new MainUI().setVisible(true);

			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(154, 205, 50));
				btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(50, 205, 50));
			}
		});

		btnLogin.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(50, 205, 50));
		btnLogin.setBounds(467, 330, 200, 35);
		this.add(btnLogin);

	}

	// �ж��Ƿ�������
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
