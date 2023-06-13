package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MessageBar3 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean isOpenServer=false;
	private WeChatUI  wc=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MessageBar3 dialog = new MessageBar3();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MessageBar3() {
		getContentPane().setBackground(Color.GREEN);
		setLogo();
		setBounds(100, 100, 300, 280);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 294, 251);
		contentPanel.setBackground(Color.YELLOW);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panelSet = new JPanel();
		panelSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSet.setBackground(new Color(0,255,255));
				panelSet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelSet.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru=new RemainUI("δ������ʾ","picture\\����1.png","������δ���ţ������ڴ�",170);
				ru.setVisible(true);
			}
		});
		panelSet.setBackground(Color.WHITE);
		panelSet.setBounds(0, 0, 294, 50);
		contentPanel.add(panelSet);
		panelSet.setLayout(null);
		
		ImageIcon imageSet=new ImageIcon("picture\\�� ��1.png");
		JLabel LabSet = new JLabel(imageSet);
		LabSet.setBounds(10, 10, 54, 30);
		panelSet.add(LabSet);
		
		JLabel LabSet1 = new JLabel("Set");
		LabSet1.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LabSet1.setBounds(94, 10, 33, 15);
		panelSet.add(LabSet1);
		
		JLabel LabSethint = new JLabel("Set up the System");
		LabSethint.setFont(new Font("΢���ź� Light", Font.PLAIN, 12));
		LabSethint.setBounds(94, 30, 109, 15);
		panelSet.add(LabSethint);
		
		
		JPanel panelmeeting = new JPanel();
		panelmeeting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelmeeting.setBackground(new Color(0,255,255));
				panelmeeting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelmeeting.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru=new RemainUI("δ������ʾ","picture\\����1.png","������δ���ţ������ڴ�",170);
				ru.setVisible(true);
			}
		});
		panelmeeting.setBackground(Color.WHITE);
		panelmeeting.setBounds(0, 50, 294, 50);
		contentPanel.add(panelmeeting);
		panelmeeting.setLayout(null);
		
		ImageIcon imageMeeting=new ImageIcon("picture\\����1.png");
		JLabel LabMeeting = new JLabel(imageMeeting);
		LabMeeting.setBounds(10, 10, 54, 30);
		panelmeeting.add(LabMeeting);
		
		JLabel LabMeeting1 = new JLabel("Meeting");
		LabMeeting1.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LabMeeting1.setBounds(95, 10, 54, 15);
		panelmeeting.add(LabMeeting1);
		
		JLabel LabMeetinghint = new JLabel("Enter the conference room");
		LabMeetinghint.setFont(new Font("΢���ź� Light", Font.PLAIN, 12));
		LabMeetinghint.setBounds(94, 25, 172, 15);
		panelmeeting.add(LabMeetinghint);
		
		JPanel panelUnit = new JPanel();
		panelUnit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUnit.setBackground(new Color(0,255,255));
				panelUnit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelUnit.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru=new RemainUI("δ������ʾ","picture\\����1.png","������δ���ţ������ڴ�",170);
				ru.setVisible(true);
			}
		});
		panelUnit.setBackground(Color.WHITE);
		panelUnit.setBounds(0, 100, 294, 50);
		contentPanel.add(panelUnit);
		panelUnit.setLayout(null);
		
		ImageIcon imageUnit=new ImageIcon("picture\\��λ1.png");
		JLabel LabUnit = new JLabel(imageUnit);
		LabUnit.setBounds(10, 10, 54, 30);
		panelUnit.add(LabUnit);
		
		JLabel LabUnit_1 = new JLabel("Unit");
		LabUnit_1.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LabUnit_1.setBounds(99, 10, 54, 15);
		panelUnit.add(LabUnit_1);
		
		JLabel LabUnithint = new JLabel("Set up the system unit");
		LabUnithint.setFont(new Font("΢���ź� Light", Font.PLAIN, 12));
		LabUnithint.setBounds(94, 25, 172, 15);
		panelUnit.add(LabUnithint);
		
		JPanel panelAccessory = new JPanel();
		panelAccessory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAccessory.setBackground(new Color(0,255,255));
				panelAccessory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelAccessory.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
//				wc.setVisible(false);
				if(isOpenServer==false) {
					 wc=new WeChatUI();
					 wc.setVisible(true);
					isOpenServer=!isOpenServer;
				}else if(isOpenServer) {
					wc=new WeChatUI("����");
					wc.setVisible(true);
					wc.setBounds(500, 400, 807, 586);
//					isOpenServer=!isOpenServer;
				}
				
			}
		});
		panelAccessory.setBackground(Color.WHITE);
		panelAccessory.setBounds(0, 150, 294, 50);
		contentPanel.add(panelAccessory);
		panelAccessory.setLayout(null);
		
		ImageIcon imageAccessory=new ImageIcon("picture\\�ͷ�1.png");
		JLabel LabAccessory = new JLabel(imageAccessory);
		LabAccessory.setBounds(10, 10, 54, 30);
		panelAccessory.add(LabAccessory);
		
		JLabel LabAcceessoryhint = new JLabel("Service");
		LabAcceessoryhint.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LabAcceessoryhint.setBounds(99, 10, 70, 15);
		panelAccessory.add(LabAcceessoryhint);
		
		JLabel LabAccessoryHint = new JLabel("contact the customer service");
		LabAccessoryHint.setFont(new Font("΢���ź� Light", Font.PLAIN, 12));
		LabAccessoryHint.setBounds(94, 25, 172, 15);
		panelAccessory.add(LabAccessoryHint);
		
		JPanel panelSerive = new JPanel();
		panelSerive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSerive.setBackground(new Color(0,255,255));
				panelSerive.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelSerive.setBackground(Color.WHITE);
			}
			//����˳�
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru=new RemainUI("δ������ʾ","picture\\����1.png","������δ���ţ������ڴ�",170);
				ru.setVisible(true);
				
			}
		});
		panelSerive.setBackground(Color.WHITE);
		panelSerive.setBounds(0, 200, 294, 50);
		contentPanel.add(panelSerive);
		panelSerive.setLayout(null);
		
		ImageIcon imageService=new ImageIcon("picture\\�˳�.png");
		JLabel LabSerive = new JLabel(imageService);
		LabSerive.setBounds(10, 10, 54, 30);
		panelSerive.add(LabSerive);
		
		JLabel LabExit = new JLabel("Exit");
		LabExit.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LabExit.setBounds(93, 10, 70, 15);
		panelSerive.add(LabExit);
		
		JLabel LabServiceHint = new JLabel("Exiting the operating system");
		LabServiceHint.setFont(new Font("΢���ź� Light", Font.PLAIN, 12));
		LabServiceHint.setBounds(93, 25, 179, 15);
		panelSerive.add(LabServiceHint);
	}
	
	public void setLogo() {
		this.setResizable(false);// ���ڴ�С���ɱ�
		// �޸�ͼ��
		Toolkit tk = Toolkit.getDefaultToolkit();
		// ��ȡͼƬ ����ͼƬ��ʽ������
		java.awt.Image img = tk.getImage("picture\\�հ�.png");
		// ����������ͼ��
		this.setIconImage(img);
	}
}
