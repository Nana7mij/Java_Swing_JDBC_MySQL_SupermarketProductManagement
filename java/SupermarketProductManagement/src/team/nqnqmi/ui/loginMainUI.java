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
		contentPane.setBackground(new Color(75, 169, 169));//��¼�����ɫ
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelUI = new JPanel();
		panelUI.setBounds(0, 0, 984, 519);
		// ����½������
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

				if (btnNewButton.getText().equals("ע��")) {
					contentPane.setBackground(new Color(255, 240, 245));
					panelUI.setVisible(false);
					panelUI = new registerUI1();
					panelUI.setBounds(0, 0, 985, 550);
					contentPane.add(panelUI);
					repaint();
					btnNewButton.setText("��½");

				} else if (btnNewButton.getText().equals("��½")) {
					contentPane.setBackground(new Color(75, 169, 169));
					panelUI.setVisible(false);
					panelUI = new loginUI();
					panelUI.setLocation(0, 0);
					contentPane.add(panelUI);
					repaint();
					btnNewButton.setText("ע��");

				}

			}
		});
		btnNewButton.setBounds(915, 555, 60, 30);
		contentPane.add(btnNewButton);
	}

	// ���ô���ͼ��
	public void setLOGO() {
		// �޸�ͼ��
		Toolkit tk = Toolkit.getDefaultToolkit();
		// ��ȡͼƬ ����ͼƬ��ʽ������
		java.awt.Image img = tk.getImage("picture\\�޵µ�2.png");
		// ���ô���ͼ��
		this.setIconImage(img);

	}
}
