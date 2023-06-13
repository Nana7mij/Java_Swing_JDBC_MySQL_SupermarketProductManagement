package team.nqnqmi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginMainUI extends JFrame {

	public JPanel contentPane;
	public JPanel panelUI;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginMainUI frame = new loginMainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public loginMainUI() {
		this.setResizable(false);
		setLOGO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 630);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 169, 169));//登录界面底色
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelUI = new JPanel();
		panelUI.setBounds(0, 0, 984, 519);
		// 将登陆面板加入
		panelUI.setVisible(false);
		panelUI = new loginUI();
		panelUI.setLocation(0, 0);
		contentPane.add(panelUI);

		ImageIcon register = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\right.png");
		JLabel LabResigter = new JLabel(register);
		LabResigter.setBounds(870, 560, 50, 20);
		contentPane.add(LabResigter);

		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(238, 232, 170));
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(245, 255, 250));
			}
		});
		btnNewButton.setBackground(new Color(245, 255, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnNewButton.getText().equals("注册")) {
					contentPane.setBackground(new Color(255, 240, 245));
					panelUI.setVisible(false);
					panelUI = new registerUI1();
					panelUI.setBounds(0, 0, 985, 550);
					contentPane.add(panelUI);
					repaint();
					btnNewButton.setText("登陆");

				} else if (btnNewButton.getText().equals("登陆")) {
					contentPane.setBackground(new Color(75, 169, 169));
					panelUI.setVisible(false);
					panelUI = new loginUI();
					panelUI.setLocation(0, 0);
					contentPane.add(panelUI);
					repaint();
					btnNewButton.setText("注册");

				}

			}
		});
		btnNewButton.setBounds(915, 555, 60, 30);
		contentPane.add(btnNewButton);
	}

	// 设置窗体图标
	public void setLOGO() {
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以
		java.awt.Image img = tk.getImage("picture\\罗德岛2.png");
		// 设置窗体图标
		this.setIconImage(img);

	}
}
