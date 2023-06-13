//Nana7mij第三次修改
package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import team.nqnqmi.ui.marketManagerPanel.paneDate;

public class MainUI extends JFrame {


	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtproducteName;
	private JTextField txtproductNamber;
	private JTable Tables;
	private JPanel panelBigerMain;
	private JLabel txtheader;
	private JLabel LabMarketMessage;
	private JLabel LabMainMenu;
	private JLabel LablendManager;
	private JLabel LabUserManae;
	private JPanel panelIcon;
	private JPanel panelheadIcon;
	private MessageBar mb = new MessageBar();;
	private boolean isShow = false;// 定义是否显示，默认不显示
	private MessageBar3 mb3=new MessageBar3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public MainUI() {
//		this.setVisible(true);
		setBackground(new Color(255, 255, 255));


		setLogo();

		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
//		setExtendedState(JFrame.MAXIMIZED_BOTH); //最大化
		this.setVisible(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 250, 1031);
		contentPane.add(panel);
		panel.setLayout(null);

		panelheadIcon = new JPanel();
		panelheadIcon.setBackground(Color.WHITE);
		panelheadIcon.setBounds(15, 10, 218, 241);
		panel.add(panelheadIcon);
		panelheadIcon.setLayout(null);


		JLabel Labadmin = new JLabel("admin");
		Labadmin.setBounds(80, 196, 54, 15);
		panelheadIcon.add(Labadmin);
		Labadmin.setForeground(SystemColor.windowBorder);
		Labadmin.setFont(new Font("宋体", Font.PLAIN, 13));

		JButton btnImage01 = new JButton("");
		btnImage01.setBounds(38, 221, 20, 20);
		panelheadIcon.add(btnImage01);
		btnImage01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnImage01.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnImage01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelIcon.setVisible(false);
				panelIcon = new headerIcon3();
				panelIcon.setBounds(20, 10, 175, 175);
				panelheadIcon.add(panelIcon);
				repaint();
			}
		});
		btnImage01.setBackground(new Color(0, 255, 255));

		JButton btnImage02 = new JButton("");
		btnImage02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelIcon.setVisible(false);
				panelIcon = new headerIcon1();
				panelIcon.setBounds(20, 10, 175, 175);
				panelheadIcon.add(panelIcon);
				repaint();

			}
		});
		btnImage02.setBounds(91, 221, 20, 20);
		panelheadIcon.add(btnImage02);
		btnImage02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnImage02.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnImage02.setBackground(new Color(144, 238, 144));

		JButton btnImage03 = new JButton("");
		btnImage03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelIcon.setVisible(false);
				panelIcon = new headerIcon2();
				panelIcon.setBounds(20, 10, 175, 175);
				panelheadIcon.add(panelIcon);
				repaint();

			}
		});
		btnImage03.setBounds(147, 221, 20, 20);
		panelheadIcon.add(btnImage03);
		btnImage03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnImage03.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnImage03.setBackground(new Color(250, 128, 114));

		panelIcon = new JPanel();
		panelIcon.setBackground(null);
		panelIcon.setBounds(20, 10, 175, 175);
		panelheadIcon.add(panelIcon);
		panelIcon.setLayout(null);

		ImageIcon images01 = new ImageIcon("picture\\header.png");
		JLabel iconHeader = new JLabel(images01);
		iconHeader.setBounds(0, 0, 175, 175);
		panelIcon.add(iconHeader);

		txtSearch = new JTextField();
		txtSearch.setText("\u641C\u7D22..");
		txtSearch.setBackground(new Color(240, 255, 240));
		txtSearch.setBounds(0, 280, 218, 30);
		panel.add(txtSearch);
		txtSearch.setColumns(10);

		ImageIcon image = new ImageIcon("picture\\search.png");
		JLabel Labicon = new JLabel(image);
		Labicon.setBounds(215, 285, 25, 25);
		panel.add(Labicon);

		JPanel panelMenu = new JPanel();
		panelMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMenu.setBackground(new Color(43, 187, 173));
				panelMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelMenu.setBackground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtheader.setText(LabMainMenu.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new marketManagerPanel();
				panelBigerMain.setBounds(250, 45, 1670, 996);
				contentPane.add(panelBigerMain);
				repaint();
			}
		});
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 320, 249, 44);
		panel.add(panelMenu);
		panelMenu.setLayout(null);

		LabMainMenu = new JLabel("\u4E3B\u9875");
		LabMainMenu.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		LabMainMenu.setForeground(Color.BLACK);
		LabMainMenu.setBounds(47, 13, 45, 20);
		panelMenu.add(LabMainMenu);

		ImageIcon imageMenu = new ImageIcon("picture\\LabMenu.png");
		JLabel LabMenu1 = new JLabel(imageMenu);
		LabMenu1.setBounds(15, 12, 22, 22);
		panelMenu.add(LabMenu1);

		JPanel paneMarketmanage = new JPanel();
		paneMarketmanage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneMarketmanage.setBackground(new Color(43, 187, 173));
				paneMarketmanage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				paneMarketmanage.setBackground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtheader.setText(LabMarketMessage.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new ProductManageUI();
				panelBigerMain.setBounds(250, 5, 1645, 996);
				contentPane.add(panelBigerMain);
				repaint();

			}
		});
		paneMarketmanage.setLayout(null);
		paneMarketmanage.setBackground(Color.WHITE);
		paneMarketmanage.setBounds(0, 365, 249, 44);
		panel.add(paneMarketmanage);

		LabMarketMessage = new JLabel("\u56FE\u4E66\u7BA1\u7406");
		LabMarketMessage.setForeground(Color.BLACK);
		LabMarketMessage.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		LabMarketMessage.setBounds(47, 13, 74, 20);
		paneMarketmanage.add(LabMarketMessage);

		ImageIcon imageManager = new ImageIcon("picture\\MarketManage.png");
		JLabel LabManager = new JLabel(imageManager);
		LabManager.setBounds(15, 12, 22, 22);
		paneMarketmanage.add(LabManager);

		JPanel paneLendManage = new JPanel();
		paneLendManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneLendManage.setBackground(new Color(43, 187, 173));
				paneLendManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				paneLendManage.setBackground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtheader.setText(LablendManager.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new LendManageUI();
				panelBigerMain.setBounds(250, 45, 1670, 996);
				contentPane.add(panelBigerMain);
				repaint();

			}
		});
		paneLendManage.setLayout(null);
		paneLendManage.setBackground(Color.WHITE);
		paneLendManage.setBounds(0, 410, 249, 44);
		panel.add(paneLendManage);

		LablendManager = new JLabel("\u501F\u9605\u7BA1\u7406");
		LablendManager.setForeground(Color.BLACK);
		LablendManager.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		LablendManager.setBounds(47, 13, 74, 20);
		paneLendManage.add(LablendManager);

		ImageIcon imagelend = new ImageIcon("picture\\lendManager.png");
		JLabel LabManager_1 = new JLabel(imagelend);
		LabManager_1.setBounds(15, 12, 22, 22);
		paneLendManage.add(LabManager_1);

		JPanel panelUsermanage = new JPanel();
		panelUsermanage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUsermanage.setBackground(new Color(43, 187, 173));
				panelUsermanage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelUsermanage.setBackground(Color.white);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtheader.setText(LabUserManae.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new UserManageUI();
				panelBigerMain.setBounds(250, 45, 1670, 996);
				contentPane.add(panelBigerMain);
				repaint();

			}
		});
		panelUsermanage.setLayout(null);
		panelUsermanage.setBackground(Color.WHITE);
		panelUsermanage.setBounds(0, 455, 249, 44);
		panel.add(panelUsermanage);

		LabUserManae = new JLabel("\u7528\u6237\u7BA1\u7406");
		LabUserManae.setForeground(Color.BLACK);
		LabUserManae.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		LabUserManae.setBounds(47, 13, 74, 20);
		panelUsermanage.add(LabUserManae);

		ImageIcon imageUsermanger = new ImageIcon("picture\\UserManage.png");
		JLabel LabManager_1_1 = new JLabel(imageUsermanger);
		LabManager_1_1.setBounds(15, 12, 22, 22);
		panelUsermanage.add(LabManager_1_1);

		JPanel panelstatisticsManage = new JPanel();
		panelstatisticsManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelstatisticsManage.setBackground(new Color(43, 187, 173));
				panelstatisticsManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelstatisticsManage.setBackground(Color.WHITE);
			}
		});
		panelstatisticsManage.setLayout(null);
		panelstatisticsManage.setBackground(Color.WHITE);
		panelstatisticsManage.setBounds(0, 499, 249, 44);
		panel.add(panelstatisticsManage);

		JLabel Labstatistics = new JLabel("\u4F11\u95F2\u5A31\u4E50");
		Labstatistics.setForeground(Color.BLACK);
		Labstatistics.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		Labstatistics.setBounds(47, 13, 74, 20);
		panelstatisticsManage.add(Labstatistics);

		ImageIcon imagestatistics = new ImageIcon("picture\\游戏.png");
		JLabel LabManager_1_1_1 = new JLabel(imagestatistics);
		LabManager_1_1_1.setText("");
		LabManager_1_1_1.setBounds(15, 12, 22, 22);
		panelstatisticsManage.add(LabManager_1_1_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(211, 211, 211));
		separator.setBounds(250, 45, 1670, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(211, 211, 211));
		separator_1.setBounds(250, 1, 1670, 2);
		contentPane.add(separator_1);

		ImageIcon images = new ImageIcon("picture\\menu.png");
		JLabel LabMenu = new JLabel(images);
		LabMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		LabMenu.setBounds(253, 8, 32, 32);
		contentPane.add(LabMenu);

		txtheader = new JLabel("\u4E3B\u9875");
		txtheader.setFont(new Font("宋体", Font.BOLD, 12));
		txtheader.setForeground(new Color(105, 105, 105));
		txtheader.setBounds(290, 7, 73, 30);
		contentPane.add(txtheader);

		ImageIcon imageInform = new ImageIcon("picture\\inform.png");
		JLabel LabInform = new JLabel(imageInform);
		LabInform.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {// 鼠标悬浮时变成手
				LabInform.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}

			// 鼠标点击事件
			@Override
			public void mouseClicked(MouseEvent e) {
				mb.setTitle("Message");
				mb.contentPanel.setVisible(false);
				mb.contentPanel = new MessageBar1();
				mb.getContentPane().add(mb.contentPanel);
				if (isShow == false) {
					mb.setVisible(false);
					isShow = !isShow;
				} else if (isShow) {
					mb.setVisible(true);
					mb.setBounds(1520, 80, 300, 300);
					isShow = !isShow;
				}

			}

			// 鼠标移除事件
			@Override
			public void mouseExited(MouseEvent e) {
//				mb.setVisible(false);
			}
		});
		LabInform.setBounds(1804, 3, 32, 32);
		contentPane.add(LabInform);

		ImageIcon imageMessage = new ImageIcon("picture\\message.png");
		JLabel LabMessage = new JLabel(imageMessage);
		LabMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LabMessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				mb.setTitle("Inform");
				mb.contentPanel.setVisible(false);
				mb.contentPanel = new MessageBar2();
				mb.getContentPane().add(mb.contentPanel);
				if (isShow == false) {
					mb.setVisible(false);
					isShow = !isShow;
				} else if (isShow) {
					mb.setVisible(true);
					mb.setBounds(1550, 80, 300, 300);
					isShow = !isShow;
				}

			}

		});
		LabMessage.setBounds(1837, 3, 32, 32);
		contentPane.add(LabMessage);

		ImageIcon imageSomany = new ImageIcon("picture\\soMany.png");
		JLabel LabSoMany = new JLabel(imageSomany);
		LabSoMany.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LabSoMany.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (isShow == false) {
					mb3.setVisible(false);
					isShow = !isShow;
				} else if (isShow) {
					mb3.setVisible(true);
					mb3.setBounds(1570, 80, 300, 280);
					isShow = !isShow;
				}
				
			}
		});
		LabSoMany.setBounds(1869, 7, 25, 25);
		contentPane.add(LabSoMany);

		panelBigerMain = new JPanel();
		panelBigerMain.setBackground(new Color(255, 255, 255));
		panelBigerMain.setBounds(250, 45, 1654, 996);
		contentPane.add(panelBigerMain);
		panelBigerMain.setLayout(null);

		panelBigerMain.setVisible(false);
		panelBigerMain = new marketManagerPanel();
		panelBigerMain.setBounds(250, 45, 1670, 996);
		getContentPane().add(panelBigerMain);

//		content();
//		content2();

	}

//	class paneDate extends JPanel {
//
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//
//		@Override
//		public void paint(Graphics g) {
//			super.paint(g);
//			g.drawImage(imageicon[index % imageicon.length].getImage(), 1, 1, this);
//			index++;
//		}
//
//	}
//设置LOGO
	public void setLogo() {
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以
		java.awt.Image img = tk.getImage("picture\\fox.png");
		// 给窗体设置图标
		this.setIconImage(img);
	}
	

	
	
}
