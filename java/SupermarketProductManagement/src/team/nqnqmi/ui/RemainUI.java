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

public class RemainUI extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RemainUI dialog = new RemainUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RemainUI(String title, String contentLogo, String write,int x ) {
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
		//��ʾ������
		JLabel LabWrite = new JLabel(write);
		LabWrite.setFont(new Font("΢���ź� Light", Font.BOLD, 12));
		LabWrite.setBounds(x, 113, 259, 38);
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
	public RemainUI(String title, String write) {
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
		//��ʾ������
		JLabel LabWrite = new JLabel(write);
		LabWrite.setFont(new Font("΢���ź� Light", Font.BOLD, 12));
		LabWrite.setBounds(174, 113, 207, 38);
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

	public RemainUI() {
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

		JLabel LabWrite = new JLabel("\u60A8\u8F93\u5165\u7684\u4FE1\u606F\u4E0D\u5B58\u5728");
		LabWrite.setFont(new Font("΢���ź� Light", Font.BOLD, 12));
		LabWrite.setBounds(174, 113, 207, 38);
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
