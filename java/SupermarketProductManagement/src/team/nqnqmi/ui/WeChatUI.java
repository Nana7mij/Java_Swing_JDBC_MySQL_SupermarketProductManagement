package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class WeChatUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIP;
	private JTextField txtPort;
	private static final int DEFAULT_PORT = 6666;
	private DatagramSocket ds; // �շ���Ϣ�õ���socket
	private JTextArea txtContent;
	private JButton btnsend;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WeChatUI dialog = new WeChatUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WeChatUI(String title) {

		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("�û�:"+title);
		setBounds(100, 100, 807, 586);
		this.setResizable(false);// ��С���ɱ�
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 804, 571);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel panelRight = new JPanel();
		panelRight.setBounds(590, 54, 208, 503);
		contentPanel.add(panelRight);
		panelRight.setBackground(Color.WHITE);
		panelRight.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(0, 0, 2, 500);
		panelRight.add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);

		JPanel panelBody = new JPanel();
		panelBody.setBackground(Color.WHITE);
		panelBody.setBounds(0, 55, 590, 272);
		contentPanel.add(panelBody);
		panelBody.setLayout(null);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBounds(1, 270, 590, 2);
		panelBody.add(separator_2);

		txtContent = new JTextArea();
		txtContent.setEditable(false);
		txtContent.setBounds(1, 0, 590, 236);
		panelBody.add(txtContent);

		JPanel panelhead = new JPanel();
		panelhead.setBackground(Color.WHITE);
		panelhead.setBounds(0, 0, 802, 55);
		contentPanel.add(panelhead);
		panelhead.setLayout(null);

		JLabel LabNewLabel = new JLabel("\u804A\u5929");
		LabNewLabel.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel.setBounds(30, 15, 54, 15);
		panelhead.add(LabNewLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(0, 50, 800, 2);
		panelhead.add(separator);
		
		
		JLabel LabTongzhi = new JLabel("\u901A\u77E5\uFF1A");
		LabTongzhi.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		LabTongzhi.setBounds(10, 10, 54, 15);
		panelRight.add(LabTongzhi);
		
		JLabel LabFiel1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1.setBounds(20, 35, 55, 15);
		panelRight.add(LabFiel1);
		
		JLabel LabNewLabel_2 = new JLabel("֪ͨ��ϵͳ��������ȫ������");
		LabNewLabel_2.setForeground(Color.BLACK);
		LabNewLabel_2.setFont(new Font("΢���ź� Light", Font.PLAIN, 10));
		LabNewLabel_2.setBounds(78, 35, 120, 15);
		panelRight.add(LabNewLabel_2);
		
		JLabel LabFiel1_1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1_1.setBounds(20, 60, 55, 15);
		panelRight.add(LabFiel1_1);

		JLabel LabNewLabel_1 = new JLabel("\u516C\u544A");
		LabNewLabel_1.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel_1.setBounds(83, 15, 54, 15);
		panelhead.add(LabNewLabel_1);

		JLabel LabNewLabel_1_1 = new JLabel("\u76F8\u518C");
		LabNewLabel_1_1.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel_1_1.setBounds(147, 15, 54, 15);
		panelhead.add(LabNewLabel_1_1);

		JLabel LabNewLabel_1_2 = new JLabel("\u6587\u4EF6");
		LabNewLabel_1_2.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel_1_2.setBounds(211, 15, 54, 15);
		panelhead.add(LabNewLabel_1_2);

		JLabel LabNewLabel_1_2_1 = new JLabel("\u8BBE\u7F6E");
		LabNewLabel_1_2_1.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel_1_2_1.setBounds(275, 15, 54, 15);
		panelhead.add(LabNewLabel_1_2_1);
		
		JLabel LabNewLabel_2_1 = new JLabel("�����û������ѯ�ƻ�");
		LabNewLabel_2_1.setForeground(Color.BLACK);
		LabNewLabel_2_1.setFont(new Font("΢���ź� Light", Font.PLAIN, 10));
		LabNewLabel_2_1.setBounds(78, 60, 120, 15);
		panelRight.add(LabNewLabel_2_1);
		
		JLabel LabFiel1_1_1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1_1_1.setBounds(20, 85, 55, 15);
		panelRight.add(LabFiel1_1_1);
		
		JLabel LabNewLabel_2_1_1 = new JLabel("���ڼ���ͷ�Ͷ�߹��������ѯ��");
		LabNewLabel_2_1_1.setForeground(Color.BLACK);
		LabNewLabel_2_1_1.setFont(new Font("΢���ź� Light", Font.PLAIN, 10));
		LabNewLabel_2_1_1.setBounds(78, 85, 120, 15);
		panelRight.add(LabNewLabel_2_1_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.LIGHT_GRAY);
		separator_3.setBounds(0, 123, 208, 2);
		panelRight.add(separator_3);

		ImageIcon iamgephone = new ImageIcon("picture\\�绰.png");
		JLabel LabPhone = new JLabel(iamgephone);
		LabPhone.setBounds(628, 17, 33, 33);
		panelhead.add(LabPhone);

		ImageIcon iamgeView = new ImageIcon("picture\\��Ƶ.png");
		JLabel LabView = new JLabel(iamgeView);
		LabView.setBounds(664, 15, 33, 33);
		panelhead.add(LabView);

		ImageIcon iamgeClass = new ImageIcon("picture\\�α�.png");
		JLabel LabView_1 = new JLabel(iamgeClass);
		LabView_1.setBounds(703, 15, 33, 33);
		panelhead.add(LabView_1);

		ImageIcon iamgeMore = new ImageIcon("picture\\����.png");
		JLabel LabView_1_1 = new JLabel(iamgeMore);
		LabView_1_1.setBounds(737, 17, 33, 33);
		panelhead.add(LabView_1_1);

		ImageIcon imagePoint = new ImageIcon("picture\\point3.png");
		JLabel LabView_1_1_1 = new JLabel(imagePoint);
		LabView_1_1_1.setBounds(767, 20, 33, 20);
		panelhead.add(LabView_1_1_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 327, 590, 231);
		contentPanel.add(panel);
		panel.setLayout(null);

		textArea = new JTextArea();
		textArea.setBounds(0, 30, 590, 130);
		panel.add(textArea);

		ImageIcon image01 = new ImageIcon("picture\\����.png");
		JLabel Labicon1 = new JLabel(image01);
		Labicon1.setBounds(5, 5, 25, 20);
		panel.add(Labicon1);

		ImageIcon image02 = new ImageIcon("picture\\GIF.png");
		JLabel Labicon1_1 = new JLabel(image02);
		Labicon1_1.setBounds(30, 5, 25, 20);
		panel.add(Labicon1_1);

		ImageIcon image03 = new ImageIcon("picture\\�ü�.png");
		JLabel Labicon1_2 = new JLabel(image03);
		Labicon1_2.setBounds(55, 5, 25, 20);
		panel.add(Labicon1_2);

		ImageIcon image04 = new ImageIcon("picture\\�ļ�.png");
		JLabel Labicon1_3 = new JLabel(image04);
		Labicon1_3.setBounds(78, 5, 25, 20);
		panel.add(Labicon1_3);
		
		ImageIcon imageservice=new ImageIcon("picture\\����.png");
		JLabel LabNewLabel_3 = new JLabel(imageservice);
		LabNewLabel_3.setBounds(0, 286, 210, 214);
		panelRight.add(LabNewLabel_3);

		ImageIcon image05 = new ImageIcon("picture\\���.png");
		JLabel Labicon1_3_1 = new JLabel(image05);
		Labicon1_3_1.setBounds(113, 5, 25, 20);
		panel.add(Labicon1_3_1);

		btnsend = new JButton("\u53D1\u9001  | \u2193");
		btnsend.setForeground(new Color(255, 255, 255));
		btnsend.setBackground(new Color(18, 183, 245));
		btnsend.setBounds(490, 186, 90, 23);
		panel.add(btnsend);

		txtIP = new JTextField();
		txtIP.setText("127.0.0.1");
		txtIP.setBounds(30, 187, 90, 21);
		panel.add(txtIP);
		txtIP.setColumns(10);

		txtPort = new JTextField();
		txtPort.setText("6666");
		txtPort.setColumns(10);
		txtPort.setBounds(149, 187, 90, 21);
		panel.add(txtPort);

		initSocket1();
		setListener();

	}

	public WeChatUI() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("�ͷ�");
		setBounds(100, 100, 807, 586);
		this.setResizable(false);// ��С���ɱ�
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 804, 571);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel panelRight = new JPanel();
		panelRight.setBounds(590, 54, 208, 503);
		contentPanel.add(panelRight);
		panelRight.setBackground(Color.WHITE);
		panelRight.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(0, 0, 2, 500);
		panelRight.add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JLabel LabTongzhi = new JLabel("\u901A\u77E5\uFF1A");
		LabTongzhi.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		LabTongzhi.setBounds(10, 10, 54, 15);
		panelRight.add(LabTongzhi);
		
		JLabel LabFiel1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1.setBounds(20, 35, 55, 15);
		panelRight.add(LabFiel1);
		
		JLabel LabNewLabel_2 = new JLabel("\u5173\u4E8E2021-2022\u4F01\u4E1A\u89C4\u5212");
		LabNewLabel_2.setForeground(Color.BLACK);
		LabNewLabel_2.setFont(new Font("΢���ź� Light", Font.PLAIN, 10));
		LabNewLabel_2.setBounds(78, 35, 120, 15);
		panelRight.add(LabNewLabel_2);
		
		JLabel LabFiel1_1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1_1.setBounds(20, 60, 55, 15);
		panelRight.add(LabFiel1_1);
		
		JLabel LabNewLabel_2_1 = new JLabel("\u515A\u53F2\u5B66\u4E60\u6559\u80B2\u5F00\u59CB\u60C5\u51B5");
		LabNewLabel_2_1.setForeground(Color.BLACK);
		LabNewLabel_2_1.setFont(new Font("΢���ź� Light", Font.PLAIN, 10));
		LabNewLabel_2_1.setBounds(78, 60, 120, 15);
		panelRight.add(LabNewLabel_2_1);
		
		JLabel LabFiel1_1_1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1_1_1.setBounds(20, 85, 55, 15);
		panelRight.add(LabFiel1_1_1);
		
		JLabel LabNewLabel_2_1_1 = new JLabel("\u6559\u52A1\u7CFB\u7EDF\u5B66\u4E60\u6D4B\u8BC4");
		LabNewLabel_2_1_1.setForeground(Color.BLACK);
		LabNewLabel_2_1_1.setFont(new Font("΢���ź� Light", Font.PLAIN, 10));
		LabNewLabel_2_1_1.setBounds(78, 85, 120, 15);
		panelRight.add(LabNewLabel_2_1_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.LIGHT_GRAY);
		separator_3.setBounds(0, 123, 208, 2);
		panelRight.add(separator_3);
		
		ImageIcon imageservice=new ImageIcon("picture\\��.png");
		JLabel LabNewLabel_3 = new JLabel(imageservice);
		LabNewLabel_3.setBounds(0, 340, 210, 160);
		panelRight.add(LabNewLabel_3);

		JPanel panelBody = new JPanel();
		panelBody.setBackground(Color.WHITE);
		panelBody.setBounds(0, 55, 590, 272);
		contentPanel.add(panelBody);
		panelBody.setLayout(null);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBounds(1, 270, 590, 2);
		panelBody.add(separator_2);

		txtContent = new JTextArea();
		txtContent.setEditable(false);
		txtContent.setBounds(1, 0, 590, 236);
		panelBody.add(txtContent);

		JPanel panelhead = new JPanel();
		panelhead.setBackground(Color.WHITE);
		panelhead.setBounds(0, 0, 802, 55);
		contentPanel.add(panelhead);
		panelhead.setLayout(null);

		JLabel LabNewLabel = new JLabel("\u804A\u5929");
		LabNewLabel.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel.setBounds(30, 15, 54, 15);
		panelhead.add(LabNewLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(0, 50, 800, 2);
		panelhead.add(separator);

		JLabel LabNewLabel_1 = new JLabel("\u516C\u544A");
		LabNewLabel_1.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel_1.setBounds(83, 15, 54, 15);
		panelhead.add(LabNewLabel_1);

		JLabel LabNewLabel_1_1 = new JLabel("\u76F8\u518C");
		LabNewLabel_1_1.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel_1_1.setBounds(147, 15, 54, 15);
		panelhead.add(LabNewLabel_1_1);

		JLabel LabNewLabel_1_2 = new JLabel("\u6587\u4EF6");
		LabNewLabel_1_2.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel_1_2.setBounds(211, 15, 54, 15);
		panelhead.add(LabNewLabel_1_2);

		JLabel LabNewLabel_1_2_1 = new JLabel("\u8BBE\u7F6E");
		LabNewLabel_1_2_1.setFont(new Font("��Բ", Font.PLAIN, 17));
		LabNewLabel_1_2_1.setBounds(275, 15, 54, 15);
		panelhead.add(LabNewLabel_1_2_1);

		ImageIcon iamgephone = new ImageIcon("picture\\�绰.png");
		JLabel LabPhone = new JLabel(iamgephone);
		LabPhone.setBounds(628, 17, 33, 33);
		panelhead.add(LabPhone);

		ImageIcon iamgeView = new ImageIcon("picture\\��Ƶ.png");
		JLabel LabView = new JLabel(iamgeView);
		LabView.setBounds(664, 15, 33, 33);
		panelhead.add(LabView);

		ImageIcon iamgeClass = new ImageIcon("picture\\�α�.png");
		JLabel LabView_1 = new JLabel(iamgeClass);
		LabView_1.setBounds(703, 15, 33, 33);
		panelhead.add(LabView_1);

		ImageIcon iamgeMore = new ImageIcon("picture\\����.png");
		JLabel LabView_1_1 = new JLabel(iamgeMore);
		LabView_1_1.setBounds(737, 17, 33, 33);
		panelhead.add(LabView_1_1);

		ImageIcon imagePoint = new ImageIcon("picture\\point3.png");
		JLabel LabView_1_1_1 = new JLabel(imagePoint);
		LabView_1_1_1.setBounds(767, 20, 33, 20);
		panelhead.add(LabView_1_1_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 327, 590, 231);
		contentPanel.add(panel);
		panel.setLayout(null);

		textArea = new JTextArea();
		textArea.setBounds(0, 30, 590, 130);
		panel.add(textArea);

		ImageIcon image01 = new ImageIcon("picture\\����.png");
		JLabel Labicon1 = new JLabel(image01);
		Labicon1.setBounds(5, 5, 25, 20);
		panel.add(Labicon1);

		ImageIcon image02 = new ImageIcon("picture\\GIF.png");
		JLabel Labicon1_1 = new JLabel(image02);
		Labicon1_1.setBounds(30, 5, 25, 20);
		panel.add(Labicon1_1);

		ImageIcon image03 = new ImageIcon("picture\\�ü�.png");
		JLabel Labicon1_2 = new JLabel(image03);
		Labicon1_2.setBounds(55, 5, 25, 20);
		panel.add(Labicon1_2);

		ImageIcon image04 = new ImageIcon("picture\\�ļ�.png");
		JLabel Labicon1_3 = new JLabel(image04);
		Labicon1_3.setBounds(78, 5, 25, 20);
		panel.add(Labicon1_3);

		ImageIcon image05 = new ImageIcon("picture\\���.png");
		JLabel Labicon1_3_1 = new JLabel(image05);
		Labicon1_3_1.setBounds(113, 5, 25, 20);
		panel.add(Labicon1_3_1);

		btnsend = new JButton("\u53D1\u9001  | \u2193");
		btnsend.setForeground(new Color(255, 255, 255));
		btnsend.setBackground(new Color(18, 183, 245));
		btnsend.setBounds(490, 186, 90, 23);
		panel.add(btnsend);

		txtIP = new JTextField();
		txtIP.setText("127.0.0.1");
		txtIP.setBounds(30, 187, 90, 21);
		panel.add(txtIP);
		txtIP.setColumns(10);

		txtPort = new JTextField();
		txtPort.setText("");
		txtPort.setColumns(10);
		txtPort.setBounds(149, 187, 90, 21);
		panel.add(txtPort);


//
		initSocket();
		setListener();

	}

	// �ͷ���ʼ��
	public void initSocket() {
		int port = DEFAULT_PORT; // �����˿ڣ�Ĭ����6666�˿�
		String msg;
		while (true) {

			if (port < 1 || port > 65535) {// �����жϣ�����û��������Ϣ�ǲ����϶˿ڵķ�Χ��������ʾ��Ϣ����������ѭ��
				JOptionPane.showMessageDialog(this, "������Ķ˿ڲ���ȷ��������1-65535֮������֣�");
				continue;// ��������ѭ��������һ��ѭ��
			}

			try {// ��������������£�ʵ����DatagramSocket���󣬲��ҽ��û������Port������м���
				do {
					ds = new DatagramSocket(port);
				}while(port!=6666);
				
				startThread(); // ͨ���߳�����Ϣ
				this.setTitle("�ͷ���"+port+"Ϊ������");
//				this.LabState.setText("�Ѿ���" + port + "�˿ڽ��м���");// ��������ϵ���ʾ��Ϣ
				break;// ����ѭ��
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ��ʼ��1
	public void initSocket1() {
		int port = DEFAULT_PORT; // �����˿ڣ�Ĭ����6666�˿�
		String msg = null;
		while (true) {
			// ����Ի��򣬲���(��壬������Ϣ�����⣬��Ϣ����)�������û��������Ϣ
			msg = JOptionPane.showInputDialog(this, "�����������û����", "�û����", JOptionPane.QUESTION_MESSAGE);
			if(!"".equals(msg) && msg!=null) {
				port = Integer.parseInt(msg);// ���ַ���ת����int������Port��
			}else {
				return;
			}
			

			if (port < 1 || port > 65535) {// �����жϣ�����û��������Ϣ�ǲ����϶˿ڵķ�Χ��������ʾ��Ϣ����������ѭ��
				JOptionPane.showMessageDialog(this, "������Ķ˿ڲ���ȷ��������1-65535֮������֣�");
				continue;// ��������ѭ��������һ��ѭ��
			}

			try {// ��������������£�ʵ����DatagramSocket���󣬲��ҽ��û������Port������м���
				ds = new DatagramSocket(port);
				startThread(); // ͨ���߳�����Ϣ
				this.setTitle("�û���"+port+"������ѯ");// ���ı����ϵ���ʾ��Ϣ
				break;// ����ѭ��
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// ������Ϣ�ķ���
	public void startThread() {
		// ����һ���̣߳����н��ա�
		new Thread() {

			private DatagramPacket p;// ����DatagramPacket�������������ݵļ�װ��

			public void run() {
				byte[] buf = new byte[1024];// ����byte����������������
				p = new DatagramPacket(buf, buf.length);// ������ϢҪ�õļ�װ�䣬�������ݲ���ֻ��Ҫ �ֽ����� �� ���ݴ�С

				while (!ds.isClosed()) {// ��Socketû�йرյ��������ѭ����������
					try {

						ds.receive(p);// ����Ϣ,���Ĵ���,�����ݴ���DatagramSocket��

						// ���յ�����Ϣ��ʾ�������б�
						txtContent.append(p.getAddress().getHostAddress() + ":"
								+ ((InetSocketAddress) p.getSocketAddress()).getPort() + "����˵:\n"
								+ new String(p.getData(), 0, p.getLength()) + "\n\n");
						// �ѹ������̶��ڹ������ĵײ�,�������Ϊ0���̶��ڶ���
						txtContent.setCaretPosition(txtContent.getDocument().getLength());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	// ������Ϣ�ķ���
	public void setListener() {
		// ���Ͱ�ť���¼�����
		btnsend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ��ȡ�û��ڽ���������ĶԷ���IP��ַ�Ͷ˿�
				String ipAddress = txtIP.getText();// ����û������IP��ַ
				String remotePort = txtPort.getText();// ����û�����Ķ˿ں�
				// �ж��ַ����ķǿ��ԣ����IP����PortΪ�գ����ͷ������������ٴε����ʱ�򣬷������¿�ʼ
				if (ipAddress == null || "".equals(ipAddress) || remotePort == null || "".equals(remotePort)) {
					JOptionPane.showMessageDialog(WeChatUI.this, "������IP��ַ�Ͷ˿ں�");
					return;
				}

				if (ds.isClosed()) {// ���Socket���ڹر�״̬����ʾ�������ɹ�
					JOptionPane.showMessageDialog(WeChatUI.this, "�������ɹ�");
					return;
				}

				String sendContent = textArea.getText();// ����û����ı����е���Ϣ
				byte[] buf = sendContent.getBytes();// ���û���Ϣת�����ֽ�����
				DatagramPacket p;// ����һ��DatagramPacket�������ݵķ���
				try {
					p = new DatagramPacket(buf, buf.length, InetAddress.getByName(ipAddress),
							Integer.parseInt(remotePort));// ����DatagramPacket����=����(�ֽ����飬���ݴ�С,IP,�˿�)

					ds.send(p);// ������Ϣ�ĺ��Ĵ���

					// �����͵�����׷�ӵ��Լ��������б�
					txtContent.append("�Ҷ�" + ipAddress + ":" + remotePort + "˵:\n" + sendContent + "\n\n");
					// �ѹ������̶��ڹ������ĵײ�,�������Ϊ0���̶��ڶ���
					txtContent.setCaretPosition(txtContent.getDocument().getLength());
					textArea.setText("");// �Է������ݵ��ı���������
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
