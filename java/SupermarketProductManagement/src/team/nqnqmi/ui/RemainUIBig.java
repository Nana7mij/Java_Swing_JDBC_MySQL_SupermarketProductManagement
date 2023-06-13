package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class RemainUIBig extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RemainUIBig dialog = new RemainUIBig();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RemainUIBig(String title, String contentLogo, String write) {
		this.setVisible(true);

		setTitle(title);

		setLOGO();// ����ͼ��
		setBackground(new Color(253, 245, 230));
		setBounds(100, 100, 490, 280);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 474, 241);
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel LabWrite = new JLabel(write);
		LabWrite.setFont(new Font("΢���ź� Light", Font.BOLD, 12));
		LabWrite.setBounds(191, 114, 117, 38);
		contentPanel.add(LabWrite);

		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton.setBackground(new Color(0, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(127, 255, 212));
			}
		});
		btnNewButton.setFont(new Font("������ͨ����", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setBounds(171, 175, 153, 45);
		contentPanel.add(btnNewButton);

		ImageIcon imageLOGO = new ImageIcon(contentLogo);
		JLabel LabLOGO = new JLabel(imageLOGO);
		LabLOGO.setBounds(0, 0, 474, 103);
		contentPanel.add(LabLOGO);

	}
	public RemainUIBig(String title, String write) {
		this.setVisible(true);

		setTitle(title);

		setLOGO();// ����ͼ��
		setBackground(new Color(253, 245, 230));
		setBounds(100, 100, 490, 280);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 474, 241);
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel LabWrite = new JLabel(write);
		LabWrite.setFont(new Font("΢���ź� Light", Font.BOLD, 12));
		LabWrite.setBounds(129, 113, 222, 38);
		contentPanel.add(LabWrite);

		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton.setBackground(new Color(0, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(127, 255, 212));
			}
		});
		btnNewButton.setFont(new Font("������ͨ����", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setBounds(171, 175, 153, 45);
		contentPanel.add(btnNewButton);

		ImageIcon imageLOGO = new ImageIcon("picture\\YellowHIte.jpg");
		JLabel LabLOGO = new JLabel(imageLOGO);
		LabLOGO.setBounds(0, 0, 474, 103);
		contentPanel.add(LabLOGO);

	}

	public RemainUIBig() {
		setComponent();
		
	}

	// �������
	public void setComponent() {
		


		setTitle("\u63D0\u793A");

		setLOGO();// ����ͼ��
		setBackground(new Color(253, 245, 230));
		setBounds(100, 100, 490, 280);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 474, 241);
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel LabWrite = new JLabel("\u60A8\u786E\u5B9A\uFF1F");
		LabWrite.setFont(new Font("΢���ź� Light", Font.BOLD, 12));
		LabWrite.setBounds(161, 101, 222, 38);
		contentPanel.add(LabWrite);

		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton.setBackground(new Color(0, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(127, 255, 212));
			}
		});
		btnNewButton.setFont(new Font("������ͨ����", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setBounds(72, 175, 153, 45);
		contentPanel.add(btnNewButton);

		ImageIcon imageLOGO = new ImageIcon("picture\\YellowHIte.jpg");
		JLabel LabLOGO = new JLabel(imageLOGO);
		LabLOGO.setBounds(0, 0, 474, 103);
		contentPanel.add(LabLOGO);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("������ͨ����", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(127, 255, 212));
		btnNewButton_1.setBounds(290, 175, 153, 45);
		contentPanel.add(btnNewButton_1);

	
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
