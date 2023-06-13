package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class MessageBar1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public MessageBar1() {
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(294, 271);
		setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 21, 294, 2);
		add(separator);
		
		
		
		JPanel panelMessage = new JPanel();
		panelMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMessage.setBackground(new Color(127, 255, 212));
				panelMessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelMessage.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		panelMessage.setBackground(new Color(255, 255, 255));
		panelMessage.setBounds(0, 21, 294, 50);
		this.add(panelMessage);
		panelMessage.setLayout(null);

		ImageIcon imageMessage = new ImageIcon("picture\\公告.png");
		JLabel LabMessageIcon = new JLabel(imageMessage);
		LabMessageIcon.setBounds(22, 10, 54, 30);
		panelMessage.add(LabMessageIcon);

		JLabel LabMessage01 = new JLabel("Inform");
		LabMessage01.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		LabMessage01.setBounds(101, 10, 54, 13);
		panelMessage.add(LabMessage01);

		JLabel LabMessageunder = new JLabel("You have a new message");
		LabMessageunder.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		LabMessageunder.setBounds(101, 25, 148, 15);
		panelMessage.add(LabMessageunder);

		JPanel panelNotice = new JPanel();
		panelNotice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelNotice.setBackground(new Color(127, 255, 212));
				panelNotice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelNotice.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		panelNotice.setLayout(null);
		panelNotice.setBackground(new Color(255, 255, 255));
		panelNotice.setBounds(0, 71, 294, 50);
		this.add(panelNotice);

		ImageIcon imageInform = new ImageIcon("picture\\通知.png");
		JLabel LabMessageIcon_1 = new JLabel(imageInform);
		LabMessageIcon_1.setBounds(22, 10, 54, 30);
		panelNotice.add(LabMessageIcon_1);

		JLabel Labremind = new JLabel("Remind");
		Labremind.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		Labremind.setBounds(100, 10, 54, 13);
		panelNotice.add(Labremind);

		JLabel LabYouHaveA = new JLabel("You have a Remind");
		LabYouHaveA.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		LabYouHaveA.setBounds(100, 25, 148, 15);
		panelNotice.add(LabYouHaveA);

		JPanel panelResfresh = new JPanel();
		panelResfresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelResfresh.setBackground(new Color(127, 255, 212));
				panelResfresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelResfresh.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		panelResfresh.setLayout(null);
		panelResfresh.setBackground(new Color(255, 255, 255));
		panelResfresh.setBounds(0, 121, 294, 50);
		this.add(panelResfresh);

		ImageIcon iamgeflush = new ImageIcon("picture/刷新.png");
		JLabel LabMessageIcon_2 = new JLabel(iamgeflush);
		LabMessageIcon_2.setBounds(22, 10, 54, 30);
		panelResfresh.add(LabMessageIcon_2);

		JLabel LabRefresh = new JLabel("Refresh");
		LabRefresh.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		LabRefresh.setBounds(99, 10, 54, 13);
		panelResfresh.add(LabRefresh);

		JLabel LabClean = new JLabel("Clear the Rubbish");
		LabClean.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		LabClean.setBounds(99, 25, 148, 15);
		panelResfresh.add(LabClean);

		JPanel panelUpdate = new JPanel();
		panelUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUpdate.setBackground(new Color(127, 255, 212));
				panelUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelUpdate.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		panelUpdate.setLayout(null);
		panelUpdate.setBackground(new Color(255, 255, 255));
		panelUpdate.setBounds(0, 171, 294, 50);
		this.add(panelUpdate);

		ImageIcon upDate = new ImageIcon("picture/上传.png");
		JLabel LabMessageIcon_2_1 = new JLabel(upDate);
		LabMessageIcon_2_1.setBounds(22, 10, 54, 30);
		panelUpdate.add(LabMessageIcon_2_1);

		JLabel LabUpdate = new JLabel("Upload");
		LabUpdate.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		LabUpdate.setBounds(97, 10, 54, 13);
		panelUpdate.add(LabUpdate);

		JLabel LabUpdates = new JLabel("Upload data to the server");
		LabUpdates.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		LabUpdates.setBounds(99, 25, 148, 15);
		panelUpdate.add(LabUpdates);

		JPanel paneldownDate = new JPanel();
		paneldownDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneldownDate.setBackground(new Color(127, 255, 212));
				paneldownDate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				paneldownDate.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		paneldownDate.setLayout(null);
		paneldownDate.setBackground(new Color(255, 255, 255));
		paneldownDate.setBounds(0, 221, 294, 50);
		this.add(paneldownDate);

		ImageIcon downDate = new ImageIcon("picture/下载.png");
		JLabel LabMessageIcon_2_2 = new JLabel(downDate);
		LabMessageIcon_2_2.setBounds(22, 10, 54, 30);
		paneldownDate.add(LabMessageIcon_2_2);

		JLabel Labdwonload = new JLabel("Download");
		Labdwonload.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		Labdwonload.setBounds(98, 10, 67, 13);
		paneldownDate.add(Labdwonload);

		JLabel LabDownloadTheData = new JLabel("Download the data to the client");
		LabDownloadTheData.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		LabDownloadTheData.setBounds(99, 25, 185, 15);
		paneldownDate.add(LabDownloadTheData);

	}

}
