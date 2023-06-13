package team.nqnqmi.ui;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JTextArea;

public class marketManagerPanel extends JPanel {

	int index = 0;
	private paneDate panedate;
	ImageIcon[] imageicon = { new ImageIcon("picture\\中国共产党.png"), new ImageIcon("picture\\提琴.png"),
			new ImageIcon("picture\\大海.png"), new ImageIcon("picture\\环游地球.jpg"), new ImageIcon("picture\\你的名字.png"),
			new ImageIcon("picture\\背景1.png") };

	/**
	 * Create the panel.
	 */
	public marketManagerPanel() {
		setBackground(new Color(255, 255, 255));
		setSize(1670, 982);
		setLayout(null);

		JPanel panel_two = new JPanel();
		panel_two.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_two.setBackground(Color.WHITE);
		panel_two.setBounds(343, 10, 310, 100);
		this.add(panel_two);
		panel_two.setLayout(null);

		ImageIcon imageTwo = new ImageIcon("picture\\LabTwo1.png");
		JLabel LabTwo = new JLabel(imageTwo);
		LabTwo.setBackground(Color.WHITE);
		LabTwo.setBounds(36, 20, 60, 60);
		panel_two.add(LabTwo);

		JLabel LabNumber1_1 = new JLabel("16");
		LabNumber1_1.setForeground(new Color(0, 191, 255));
		LabNumber1_1.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		LabNumber1_1.setBounds(184, 31, 40, 25);
		panel_two.add(LabNumber1_1);

		JLabel Labmessage_1 = new JLabel("Date");
		Labmessage_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		Labmessage_1.setBounds(187, 66, 35, 15);
		panel_two.add(Labmessage_1);

		JPanel panel_one = new JPanel();
		panel_one.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_one.setBackground(Color.WHITE);
		panel_one.setBounds(20, 10, 310, 100);
		this.add(panel_one);
		panel_one.setLayout(null);

		ImageIcon imageOne = new ImageIcon("picture\\LabOne.png");
		JLabel LabOne = new JLabel(imageOne);
		LabOne.setBackground(Color.WHITE);
		LabOne.setBounds(52, 20, 60, 60);
		panel_one.add(LabOne);

		JLabel LabNumber1 = new JLabel("23");
		LabNumber1.setForeground(new Color(220, 20, 60));
		LabNumber1.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		LabNumber1.setBounds(184, 31, 54, 25);
		panel_one.add(LabNumber1);

		JLabel Labmessage = new JLabel("Message");
		Labmessage.setFont(new Font("Calibri", Font.PLAIN, 13));
		Labmessage.setBounds(178, 66, 66, 15);
		panel_one.add(Labmessage);

		JPanel panel_Three = new JPanel();
		panel_Three.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_Three.setBackground(Color.WHITE);
		panel_Three.setBounds(675, 10, 310, 100);
		this.add(panel_Three);
		panel_Three.setLayout(null);

		ImageIcon imageThree = new ImageIcon("picture\\LabThree.png");
		JLabel LabThree = new JLabel(imageThree);
		LabThree.setBackground(Color.WHITE);
		LabThree.setBounds(43, 20, 60, 60);
		panel_Three.add(LabThree);

		JLabel LabNumber1_2 = new JLabel("118");
		LabNumber1_2.setForeground(new Color(32, 178, 170));
		LabNumber1_2.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		LabNumber1_2.setBounds(173, 31, 47, 25);
		panel_Three.add(LabNumber1_2);

		JLabel Labmessage_2 = new JLabel("Phone");
		Labmessage_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		Labmessage_2.setBounds(176, 66, 40, 15);
		panel_Three.add(Labmessage_2);

		JPanel panel_Four = new JPanel();
		panel_Four.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_Four.setBackground(Color.WHITE);
		panel_Four.setBounds(1008, 10, 310, 100);
		this.add(panel_Four);
		panel_Four.setLayout(null);

		ImageIcon imageFour = new ImageIcon("picture\\LabFour1.png");
		JLabel LabFive = new JLabel(imageFour);
		LabFive.setBackground(Color.WHITE);
		LabFive.setBounds(36, 20, 60, 60);
		panel_Four.add(LabFive);

		JLabel LabNumber1_3 = new JLabel("51");
		LabNumber1_3.setForeground(new Color(153, 50, 204));
		LabNumber1_3.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		LabNumber1_3.setBounds(164, 31, 26, 25);
		panel_Four.add(LabNumber1_3);

		JLabel Labmessage_3 = new JLabel("Path");
		Labmessage_3.setFont(new Font("Calibri", Font.PLAIN, 13));
		Labmessage_3.setBounds(161, 66, 32, 15);
		panel_Four.add(Labmessage_3);

		JPanel panel_Five = new JPanel();
		panel_Five.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_Five.setBackground(Color.WHITE);
		panel_Five.setBounds(1334, 10, 310, 100);
		this.add(panel_Five);
		panel_Five.setLayout(null);

		ImageIcon imageSix = new ImageIcon("picture\\LabSix.png");
		JLabel LabSix = new JLabel(imageSix);
		LabSix.setBackground(Color.WHITE);
		LabSix.setBounds(32, 20, 60, 60);
		panel_Five.add(LabSix);

		JLabel LabNumber1_4 = new JLabel("163");
		LabNumber1_4.setForeground(new Color(72, 61, 139));
		LabNumber1_4.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		LabNumber1_4.setBounds(152, 31, 54, 25);
		panel_Five.add(LabNumber1_4);

		JLabel Labmessage_4 = new JLabel("Order");
		Labmessage_4.setFont(new Font("Calibri", Font.PLAIN, 13));
		Labmessage_4.setBounds(159, 66, 40, 15);
		panel_Five.add(Labmessage_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel_2.setBounds(20, 120, 1625, 280);
		this.add(panel_2);
		panel_2.setLayout(null);

		ImageIcon imagePicture = new ImageIcon("picture/pictures.png");
		JLabel Labpicture = new JLabel(imagePicture);
		Labpicture.setBounds(25, 10, 1600, 248);
		panel_2.add(Labpicture);

		JLabel Lablegend = new JLabel("Legend 1");
		Lablegend.setFont(new Font("宋体", Font.PLAIN, 14));
		Lablegend.setBackground(Color.GREEN);
		Lablegend.setBounds(796, 258, 66, 15);
		panel_2.add(Lablegend);

		ImageIcon imagePoint = new ImageIcon("picture\\point.png");
		JLabel Labpoint = new JLabel(imagePoint);
		Labpoint.setBounds(775, 255, 25, 25);
		panel_2.add(Labpoint);

		JPanel panel_right = new JPanel();
		panel_right.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_right.setBackground(Color.WHITE);
		panel_right.setBounds(1374, 416, 280, 535);
		this.add(panel_right);
		panel_right.setLayout(null);

		JPanel panel_Green = new JPanel();
		panel_Green.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Green.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_Green.setBackground(new Color(0, 139, 139));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_Green.setBackground(new Color(60, 179, 113));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru = new RemainUI("未开放提示", "picture\\兔子1.png", "功能暂未开放，敬请期待", 170);
				ru.setVisible(true);
			}
		});
		panel_Green.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_Green.setBackground(new Color(60, 179, 113));
		panel_Green.setBounds(26, 57, 105, 60);
		panel_right.add(panel_Green);
		panel_Green.setLayout(null);

		ImageIcon imageOrder = new ImageIcon("picture\\orderMessage1.png");
		JLabel LabOrdermessage = new JLabel(imageOrder);
		LabOrdermessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Green.setBackground(new Color(0, 139, 139));
				LabOrdermessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		LabOrdermessage.setBounds(24, 6, 55, 50);
		panel_Green.add(LabOrdermessage);

		JPanel panel_yellow = new JPanel();
		panel_yellow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_yellow.setBackground(new Color(154, 223, 191));
				panel_yellow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_yellow.setBackground(new Color(173, 255, 47));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru = new RemainUI("未开放提示", "picture\\兔子1.png", "功能暂未开放，敬请期待", 170);
				ru.setVisible(true);
			}
		});
		panel_yellow.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_yellow.setBackground(new Color(173, 255, 47));
		panel_yellow.setBounds(26, 176, 105, 60);
		panel_right.add(panel_yellow);
		panel_yellow.setLayout(null);

		ImageIcon imageNote = new ImageIcon("picture\\note.png");
		JLabel LabNote = new JLabel(imageNote);
		LabNote.setBounds(25, 5, 55, 50);
		panel_yellow.add(LabNote);

		JPanel panel_blue = new JPanel();
		panel_blue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_blue.setBackground(new Color(160, 192, 240));
				panel_blue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_blue.setBackground(new Color(0, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru = new RemainUI("未开放提示", "picture\\兔子1.png", "功能暂未开放，敬请期待", 170);
				ru.setVisible(true);
			}
		});
		panel_blue.setBackground(new Color(0, 255, 255));
		panel_blue.setBounds(26, 295, 105, 60);
		panel_right.add(panel_blue);
		panel_blue.setLayout(null);

		ImageIcon imageLogistics = new ImageIcon("picture\\logisticsManageMent.png");
		JLabel LabLogistics = new JLabel(imageLogistics);
		LabLogistics.setBounds(24, 5, 55, 50);
		panel_blue.add(LabLogistics);

		JPanel panel_Cyan = new JPanel();
		panel_Cyan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Cyan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_Cyan.setBackground(new Color(219, 112, 147));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_Cyan.setBackground(new Color(187, 234, 213));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru = new RemainUI("未开放提示", "picture\\兔子1.png", "功能暂未开放，敬请期待", 170);
				ru.setVisible(true);
			}
		});

		panel_Cyan.setBackground(new Color(187, 234, 213));
		panel_Cyan.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_Cyan.setBounds(26, 414, 105, 60);
		panel_right.add(panel_Cyan);
		panel_Cyan.setLayout(null);

		ImageIcon imageblacklist = new ImageIcon("picture\\blacklist.png");
		JLabel LabBackList = new JLabel(imageblacklist);
		LabBackList.setBounds(27, 5, 55, 50);
		panel_Cyan.add(LabBackList);

		ImageIcon imagegreenWire = new ImageIcon("picture\\greenwire.png");
		JLabel LabGreenwire = new JLabel(imagegreenWire);
		LabGreenwire.setBackground(Color.RED);
		LabGreenwire.setBounds(26, 127, 235, 4);
		panel_right.add(LabGreenwire);

		JLabel LabOrder = new JLabel("Orders");
		LabOrder.setForeground(SystemColor.windowBorder);
		LabOrder.setBackground(Color.WHITE);
		LabOrder.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		LabOrder.setBounds(168, 67, 60, 25);
		panel_right.add(LabOrder);

		JLabel LabOeders_users = new JLabel("Orders Message of Users");
		LabOeders_users.setForeground(SystemColor.windowBorder);
		LabOeders_users.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		LabOeders_users.setBounds(76, 132, 150, 15);
		panel_right.add(LabOeders_users);

		ImageIcon imageyellowWire = new ImageIcon("picture\\yellowwire.png");
		JLabel LabYellowWire = new JLabel(imageyellowWire);
		LabYellowWire.setBackground(Color.RED);
		LabYellowWire.setBounds(26, 246, 235, 4);
		panel_right.add(LabYellowWire);

		JLabel LabInform = new JLabel("Inform");
		LabInform.setForeground(SystemColor.windowBorder);
		LabInform.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		LabInform.setBackground(Color.WHITE);
		LabInform.setBounds(168, 186, 60, 25);
		panel_right.add(LabInform);

		JLabel LabInform_users = new JLabel("Inform Message of Users");
		LabInform_users.setForeground(SystemColor.windowBorder);
		LabInform_users.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		LabInform_users.setBounds(76, 255, 150, 15);
		panel_right.add(LabInform_users);

		ImageIcon imageBlue = new ImageIcon("picture\\bluewrie.png");
		JLabel Labbluewire = new JLabel(imageBlue);
		Labbluewire.setBackground(Color.WHITE);
		Labbluewire.setBounds(26, 365, 235, 4);
		panel_right.add(Labbluewire);

		ImageIcon imagepurple = new ImageIcon("picture\\greenWries.png");
		JLabel LabPurple = new JLabel(imagepurple);
		LabPurple.setBackground(Color.WHITE);
		LabPurple.setBounds(26, 484, 235, 4);
		panel_right.add(LabPurple);

		JLabel Labtransportation = new JLabel("Logistics");
		Labtransportation.setForeground(SystemColor.windowBorder);
		Labtransportation.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		Labtransportation.setBackground(Color.WHITE);
		Labtransportation.setBounds(161, 306, 75, 25);
		panel_right.add(Labtransportation);

		JLabel LabLogistjics = new JLabel("Logistics Message of Users");
		LabLogistjics.setForeground(SystemColor.windowBorder);
		LabLogistjics.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		LabLogistjics.setBounds(78, 374, 150, 15);
		panel_right.add(LabLogistjics);

		JLabel LabBlackList = new JLabel("BlackList");
		LabBlackList.setForeground(SystemColor.windowBorder);
		LabBlackList.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		LabBlackList.setBackground(Color.WHITE);
		LabBlackList.setBounds(161, 422, 75, 25);
		panel_right.add(LabBlackList);

		JLabel LabBlacklistMessageOf = new JLabel("BlackList Message of Users");
		LabBlacklistMessageOf.setForeground(SystemColor.windowBorder);
		LabBlacklistMessageOf.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		LabBlacklistMessageOf.setBounds(76, 491, 150, 15);
		panel_right.add(LabBlacklistMessageOf);

		panedate = new paneDate();
		panedate.setBounds(724, 410, 640, 310);
		panedate.setBorder(new LineBorder(Color.blue));
		add(panedate);
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panedate.repaint();
			}
		});
		timer.start();

		JPanel panelUser = new JPanel();
		panelUser.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelUser.setBackground(Color.WHITE);
		panelUser.setBounds(724, 725, 640, 226);
		this.add(panelUser);
		panelUser.setLayout(null);
		
		ImageIcon images=new ImageIcon("picture\\动漫.png");
		
		ImageIcon imagehema=new ImageIcon("picture\\河马.png");
		JLabel LabNewLabel_1_1 = new JLabel(imagehema);
		LabNewLabel_1_1.setBounds(430, 61, 210, 165);
		panelUser.add(LabNewLabel_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("楷体", Font.PLAIN, 13));
		textArea.setText("\u70ED\u7231\u4E66\u5427\u2014\u2014\u8FD9\u662F\u77E5\u8BC6\u7684\u6CC9\u6E90\uFF01\r\n\u53EA\u6709\u77E5\u8BC6\u624D\u662F\u6709\u7528\u7684\r\n\u53EA\u6709\u5B83\u624D\u80FD\u591F\u4F7F\u6211\u4EEC\u5728\u7CBE\u795E\u4E0A\u6210\u4E3A\u575A\u5F3A\r\n\u5FE0\u8BDA\u548C\u6709\u7406\u667A\u7684\u4EBA\uFF0C\u6210\u4E3A\u80FD\u591F\u771F\u6B63\u7231\u4EBA\u7C7B\r\n\u5C0A\u91CD\u4EBA\u7C7B\u52B3\u52A8\u3001\u8877\u5FC3\u5730\u6B23\u8D4F\u4EBA\u7C7B\u90A3\u4E0D\u95F4\u65AD\u7684\u4F1F\u5927\u52B3\u52A8\u6240\u4EA7\u751F\u7684\u7F8E\u597D\u679C\u5B9E\u7684\u4EBA\u3002\r\n\t\t\t\t\t\t--\u9AD8\u5C14\u57FA");
		textArea.setBounds(5, 34, 437, 100);
		panelUser.add(textArea);

		JPanel pane_Main = new JPanel();
		pane_Main.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pane_Main.setBackground(Color.WHITE);
		pane_Main.setBounds(20, 410, 694, 409);
		this.add(pane_Main);
		pane_Main.setLayout(null);

		ImageIcon ims = new ImageIcon("picture\\统计图.png");
		JLabel LabNewLabel = new JLabel(ims);
		LabNewLabel.setBounds(0, 0, 694, 409);
		pane_Main.add(LabNewLabel);

		JPanel panel_friend = new JPanel();
		panel_friend.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_friend.setBackground(Color.WHITE);
		panel_friend.setBounds(20, 829, 694, 122);
		this.add(panel_friend);
		panel_friend.setLayout(null);
		
		ImageIcon imageheader=new ImageIcon("picture\\圆头.png");
		JLabel LabNewLabel_2 = new JLabel(imageheader);
		LabNewLabel_2.setBounds(84, 15, 100, 100);
		panel_friend.add(LabNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 0));
		panel.setBounds(253, 57, 120, 5);
		panel_friend.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(370, 57, 70, 5);
		panel_friend.add(panel_1);
		
		JLabel LabNewLabel_3 = new JLabel("Jean");
		LabNewLabel_3.setForeground(new Color(112, 128, 144));
		LabNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 17));
		LabNewLabel_3.setBounds(253, 25, 70, 25);
		panel_friend.add(LabNewLabel_3);
		
		ImageIcon imagePerple=new ImageIcon("picture\\动漫.png");
		JLabel LabNewLabel_4 = new JLabel(imagePerple);
		LabNewLabel_4.setBounds(535, 0, 159, 122);
		panel_friend.add(LabNewLabel_4);

	}

	class paneDate extends JPanel {
		/**
		 * 
		 */
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(imageicon[index % imageicon.length].getImage(), 0, 0, this);
			index++;
		}

	}
}
