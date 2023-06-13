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
	
	//登录背景
	public void paintComponent(Graphics g) {//重写绘制面板的方法
		super.paintComponent(g);
		ImageIcon image = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\background.jpg");//导入图片
		image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));//设置图片大小跟随面板大小
		g.drawImage(image.getImage(), 0, 0, this);//重新绘制面板
	}
	//登录UI
	public loginUI() {
		setBackground(new Color(200, 234, 235));//登录界面上层颜色
		setLayout(null);
		setSize(985, 550);//登录界面上层大小
		// 登录LOGO大图标
		ImageIcon icon = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\Loginlogo1.png");
		Labicon = new JLabel(icon);
		Labicon.setBounds(180, 190, 200, 200);
		this.add(Labicon);
		// 登录字体图标
		ImageIcon icos = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\login3.png");
		JLabel LabLoginicon = new JLabel(icos);
		LabLoginicon.setBounds(534, 189, 58, 32);
		this.add(LabLoginicon);
		// 账号LOGO
		ImageIcon iconUser = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\user.png");
		JLabel LabAccount = new JLabel(iconUser);
		LabAccount.setBounds(425, 232, 32, 32);
		this.add(LabAccount);
		// 密码LOGO
		ImageIcon iconPassword = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\lock.png");
		JLabel LabPassword = new JLabel(iconPassword);
		LabPassword.setBounds(425, 286, 32, 32);
		this.add(LabPassword);
		// 账号输入框
		txtLogin = new JTextField();
		txtLogin.setBounds(467, 231, 200, 35);
		this.add(txtLogin);
		txtLogin.setColumns(10);
		// 文本输入框
		txtPassword = new JPasswordField();
		txtPassword.setBounds(467, 285, 200, 35);
		this.add(txtPassword);

		// 分隔线
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);// 设置分割线竖直
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(400, 95, 1, 400);
		this.add(separator);
		// QQ图标
		ImageIcon imageQQ = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\qq.png");
		JLabel LabQQ = new JLabel(imageQQ);
		LabQQ.setBounds(605, 375, 25, 25);
		this.add(LabQQ);
		// 微信图标
		ImageIcon imagewx = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\wx.png");
		JLabel Labwx = new JLabel(imagewx);
		Labwx.setBounds(640, 375, 25, 25);
		this.add(Labwx);
		// GitHub图标
		ImageIcon imagewb = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\github.png");
		JLabel Labwb = new JLabel(imagewb);
		Labwb.setBounds(570, 375, 25, 25);
		this.add(Labwb);

		// 登录按钮
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
					RemainUI ra=new RemainUI("提示","您输入的账号不正确");
					ra.setVisible(true);
					txtLogin.setText("");
					txtPassword.setText("");
				} else if ("".equals(UserPwd)) {
					JOptionPane.showMessageDialog(null, "请输入密码");
				} else if (!UserPwd.equals(admins.getAdmin_pwd())) {
					JOptionPane.showMessageDialog(null, "您输入的密码有误,请重新输入密码");
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

		btnLogin.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(50, 205, 50));
		btnLogin.setBounds(467, 330, 200, 35);
		this.add(btnLogin);

	}

	// 判断是否是数字
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
