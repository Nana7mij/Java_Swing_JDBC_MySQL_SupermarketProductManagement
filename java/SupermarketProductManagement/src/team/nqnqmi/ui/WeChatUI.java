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
	private DatagramSocket ds; // 收发消息用到的socket
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
		setTitle("用户:"+title);
		setBounds(100, 100, 807, 586);
		this.setResizable(false);// 大小不可变
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
		LabNewLabel.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel.setBounds(30, 15, 54, 15);
		panelhead.add(LabNewLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(0, 50, 800, 2);
		panelhead.add(separator);
		
		
		JLabel LabTongzhi = new JLabel("\u901A\u77E5\uFF1A");
		LabTongzhi.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		LabTongzhi.setBounds(10, 10, 54, 15);
		panelRight.add(LabTongzhi);
		
		JLabel LabFiel1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1.setBounds(20, 35, 55, 15);
		panelRight.add(LabFiel1);
		
		JLabel LabNewLabel_2 = new JLabel("通知！系统升级带来全新体验");
		LabNewLabel_2.setForeground(Color.BLACK);
		LabNewLabel_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 10));
		LabNewLabel_2.setBounds(78, 35, 120, 15);
		panelRight.add(LabNewLabel_2);
		
		JLabel LabFiel1_1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1_1.setBounds(20, 60, 55, 15);
		panelRight.add(LabFiel1_1);

		JLabel LabNewLabel_1 = new JLabel("\u516C\u544A");
		LabNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel_1.setBounds(83, 15, 54, 15);
		panelhead.add(LabNewLabel_1);

		JLabel LabNewLabel_1_1 = new JLabel("\u76F8\u518C");
		LabNewLabel_1_1.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel_1_1.setBounds(147, 15, 54, 15);
		panelhead.add(LabNewLabel_1_1);

		JLabel LabNewLabel_1_2 = new JLabel("\u6587\u4EF6");
		LabNewLabel_1_2.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel_1_2.setBounds(211, 15, 54, 15);
		panelhead.add(LabNewLabel_1_2);

		JLabel LabNewLabel_1_2_1 = new JLabel("\u8BBE\u7F6E");
		LabNewLabel_1_2_1.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel_1_2_1.setBounds(275, 15, 54, 15);
		panelhead.add(LabNewLabel_1_2_1);
		
		JLabel LabNewLabel_2_1 = new JLabel("关于用户意见咨询计划");
		LabNewLabel_2_1.setForeground(Color.BLACK);
		LabNewLabel_2_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 10));
		LabNewLabel_2_1.setBounds(78, 60, 120, 15);
		panelRight.add(LabNewLabel_2_1);
		
		JLabel LabFiel1_1_1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1_1_1.setBounds(20, 85, 55, 15);
		panelRight.add(LabFiel1_1_1);
		
		JLabel LabNewLabel_2_1_1 = new JLabel("关于加入客服投诉功能意见征询书");
		LabNewLabel_2_1_1.setForeground(Color.BLACK);
		LabNewLabel_2_1_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 10));
		LabNewLabel_2_1_1.setBounds(78, 85, 120, 15);
		panelRight.add(LabNewLabel_2_1_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.LIGHT_GRAY);
		separator_3.setBounds(0, 123, 208, 2);
		panelRight.add(separator_3);

		ImageIcon iamgephone = new ImageIcon("picture\\电话.png");
		JLabel LabPhone = new JLabel(iamgephone);
		LabPhone.setBounds(628, 17, 33, 33);
		panelhead.add(LabPhone);

		ImageIcon iamgeView = new ImageIcon("picture\\视频.png");
		JLabel LabView = new JLabel(iamgeView);
		LabView.setBounds(664, 15, 33, 33);
		panelhead.add(LabView);

		ImageIcon iamgeClass = new ImageIcon("picture\\课表.png");
		JLabel LabView_1 = new JLabel(iamgeClass);
		LabView_1.setBounds(703, 15, 33, 33);
		panelhead.add(LabView_1);

		ImageIcon iamgeMore = new ImageIcon("picture\\更多.png");
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

		ImageIcon image01 = new ImageIcon("picture\\表情.png");
		JLabel Labicon1 = new JLabel(image01);
		Labicon1.setBounds(5, 5, 25, 20);
		panel.add(Labicon1);

		ImageIcon image02 = new ImageIcon("picture\\GIF.png");
		JLabel Labicon1_1 = new JLabel(image02);
		Labicon1_1.setBounds(30, 5, 25, 20);
		panel.add(Labicon1_1);

		ImageIcon image03 = new ImageIcon("picture\\裁剪.png");
		JLabel Labicon1_2 = new JLabel(image03);
		Labicon1_2.setBounds(55, 5, 25, 20);
		panel.add(Labicon1_2);

		ImageIcon image04 = new ImageIcon("picture\\文件.png");
		JLabel Labicon1_3 = new JLabel(image04);
		Labicon1_3.setBounds(78, 5, 25, 20);
		panel.add(Labicon1_3);
		
		ImageIcon imageservice=new ImageIcon("picture\\狗人.png");
		JLabel LabNewLabel_3 = new JLabel(imageservice);
		LabNewLabel_3.setBounds(0, 286, 210, 214);
		panelRight.add(LabNewLabel_3);

		ImageIcon image05 = new ImageIcon("picture\\相册.png");
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
		setTitle("客服");
		setBounds(100, 100, 807, 586);
		this.setResizable(false);// 大小不可变
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
		LabTongzhi.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		LabTongzhi.setBounds(10, 10, 54, 15);
		panelRight.add(LabTongzhi);
		
		JLabel LabFiel1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1.setBounds(20, 35, 55, 15);
		panelRight.add(LabFiel1);
		
		JLabel LabNewLabel_2 = new JLabel("\u5173\u4E8E2021-2022\u4F01\u4E1A\u89C4\u5212");
		LabNewLabel_2.setForeground(Color.BLACK);
		LabNewLabel_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 10));
		LabNewLabel_2.setBounds(78, 35, 120, 15);
		panelRight.add(LabNewLabel_2);
		
		JLabel LabFiel1_1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1_1.setBounds(20, 60, 55, 15);
		panelRight.add(LabFiel1_1);
		
		JLabel LabNewLabel_2_1 = new JLabel("\u515A\u53F2\u5B66\u4E60\u6559\u80B2\u5F00\u59CB\u60C5\u51B5");
		LabNewLabel_2_1.setForeground(Color.BLACK);
		LabNewLabel_2_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 10));
		LabNewLabel_2_1.setBounds(78, 60, 120, 15);
		panelRight.add(LabNewLabel_2_1);
		
		JLabel LabFiel1_1_1 = new JLabel("\u3010\u6587\u4EF6\u3011");
		LabFiel1_1_1.setBounds(20, 85, 55, 15);
		panelRight.add(LabFiel1_1_1);
		
		JLabel LabNewLabel_2_1_1 = new JLabel("\u6559\u52A1\u7CFB\u7EDF\u5B66\u4E60\u6D4B\u8BC4");
		LabNewLabel_2_1_1.setForeground(Color.BLACK);
		LabNewLabel_2_1_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 10));
		LabNewLabel_2_1_1.setBounds(78, 85, 120, 15);
		panelRight.add(LabNewLabel_2_1_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.LIGHT_GRAY);
		separator_3.setBounds(0, 123, 208, 2);
		panelRight.add(separator_3);
		
		ImageIcon imageservice=new ImageIcon("picture\\熊.png");
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
		LabNewLabel.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel.setBounds(30, 15, 54, 15);
		panelhead.add(LabNewLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(0, 50, 800, 2);
		panelhead.add(separator);

		JLabel LabNewLabel_1 = new JLabel("\u516C\u544A");
		LabNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel_1.setBounds(83, 15, 54, 15);
		panelhead.add(LabNewLabel_1);

		JLabel LabNewLabel_1_1 = new JLabel("\u76F8\u518C");
		LabNewLabel_1_1.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel_1_1.setBounds(147, 15, 54, 15);
		panelhead.add(LabNewLabel_1_1);

		JLabel LabNewLabel_1_2 = new JLabel("\u6587\u4EF6");
		LabNewLabel_1_2.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel_1_2.setBounds(211, 15, 54, 15);
		panelhead.add(LabNewLabel_1_2);

		JLabel LabNewLabel_1_2_1 = new JLabel("\u8BBE\u7F6E");
		LabNewLabel_1_2_1.setFont(new Font("幼圆", Font.PLAIN, 17));
		LabNewLabel_1_2_1.setBounds(275, 15, 54, 15);
		panelhead.add(LabNewLabel_1_2_1);

		ImageIcon iamgephone = new ImageIcon("picture\\电话.png");
		JLabel LabPhone = new JLabel(iamgephone);
		LabPhone.setBounds(628, 17, 33, 33);
		panelhead.add(LabPhone);

		ImageIcon iamgeView = new ImageIcon("picture\\视频.png");
		JLabel LabView = new JLabel(iamgeView);
		LabView.setBounds(664, 15, 33, 33);
		panelhead.add(LabView);

		ImageIcon iamgeClass = new ImageIcon("picture\\课表.png");
		JLabel LabView_1 = new JLabel(iamgeClass);
		LabView_1.setBounds(703, 15, 33, 33);
		panelhead.add(LabView_1);

		ImageIcon iamgeMore = new ImageIcon("picture\\更多.png");
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

		ImageIcon image01 = new ImageIcon("picture\\表情.png");
		JLabel Labicon1 = new JLabel(image01);
		Labicon1.setBounds(5, 5, 25, 20);
		panel.add(Labicon1);

		ImageIcon image02 = new ImageIcon("picture\\GIF.png");
		JLabel Labicon1_1 = new JLabel(image02);
		Labicon1_1.setBounds(30, 5, 25, 20);
		panel.add(Labicon1_1);

		ImageIcon image03 = new ImageIcon("picture\\裁剪.png");
		JLabel Labicon1_2 = new JLabel(image03);
		Labicon1_2.setBounds(55, 5, 25, 20);
		panel.add(Labicon1_2);

		ImageIcon image04 = new ImageIcon("picture\\文件.png");
		JLabel Labicon1_3 = new JLabel(image04);
		Labicon1_3.setBounds(78, 5, 25, 20);
		panel.add(Labicon1_3);

		ImageIcon image05 = new ImageIcon("picture\\相册.png");
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

	// 客服初始化
	public void initSocket() {
		int port = DEFAULT_PORT; // 监听端口，默认是6666端口
		String msg;
		while (true) {

			if (port < 1 || port > 65535) {// 进行判断，如果用户输入的信息是不符合端口的范围，弹出提示信息，跳过本次循环
				JOptionPane.showMessageDialog(this, "你输入的端口不正确，请输入1-65535之间的数字！");
				continue;// 结束本次循环进行下一次循环
			}

			try {// 满足条件的情况下，实例化DatagramSocket对象，并且将用户输入的Port传入进行监听
				do {
					ds = new DatagramSocket(port);
				}while(port!=6666);
				
				startThread(); // 通过线程收消息
				this.setTitle("客服："+port+"为您服务");
//				this.LabState.setText("已经在" + port + "端口进行监听");// 更改面板上的提示信息
				break;// 结束循环
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 初始化1
	public void initSocket1() {
		int port = DEFAULT_PORT; // 监听端口，默认是6666端口
		String msg = null;
		while (true) {
			// 输入对话框，参数(面板，文字信息，标题，消息类型)，返回用户输入的信息
			msg = JOptionPane.showInputDialog(this, "请输入您的用户编号", "用户编号", JOptionPane.QUESTION_MESSAGE);
			if(!"".equals(msg) && msg!=null) {
				port = Integer.parseInt(msg);// 将字符串转换成int，存入Port中
			}else {
				return;
			}
			

			if (port < 1 || port > 65535) {// 进行判断，如果用户输入的信息是不符合端口的范围，弹出提示信息，跳过本次循环
				JOptionPane.showMessageDialog(this, "你输入的端口不正确，请输入1-65535之间的数字！");
				continue;// 结束本次循环进行下一次循环
			}

			try {// 满足条件的情况下，实例化DatagramSocket对象，并且将用户输入的Port传入进行监听
				ds = new DatagramSocket(port);
				startThread(); // 通过线程收消息
				this.setTitle("用户："+port+"正在咨询");// 更改标题上的提示信息
				break;// 结束循环
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 接收消息的方法
	public void startThread() {
		// 创建一个线程，进行接收。
		new Thread() {

			private DatagramPacket p;// 声明DatagramPacket，用来接收数据的集装箱

			public void run() {
				byte[] buf = new byte[1024];// 创建byte数组用来接收数据
				p = new DatagramPacket(buf, buf.length);// 接收消息要用的集装箱，接收数据参数只需要 字节数组 和 数据大小

				while (!ds.isClosed()) {// 在Socket没有关闭的情况下死循环接收数据
					try {

						ds.receive(p);// 收消息,核心代码,将数据存在DatagramSocket中

						// 把收到的消息显示在聊天列表
						txtContent.append(p.getAddress().getHostAddress() + ":"
								+ ((InetSocketAddress) p.getSocketAddress()).getPort() + "对我说:\n"
								+ new String(p.getData(), 0, p.getLength()) + "\n\n");
						// 把滚动条固定在滚动面板的底部,如果设置为0，固定在顶部
						txtContent.setCaretPosition(txtContent.getDocument().getLength());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	// 发送消息的方法
	public void setListener() {
		// 发送按钮的事件监听
		btnsend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 获取用户在界面上输入的对方的IP地址和端口
				String ipAddress = txtIP.getText();// 获得用户输入的IP地址
				String remotePort = txtPort.getText();// 获得用户输入的端口号
				// 判断字符串的非空性，如果IP或者Port为空，发送方法结束。当再次点击的时候，方法重新开始
				if (ipAddress == null || "".equals(ipAddress) || remotePort == null || "".equals(remotePort)) {
					JOptionPane.showMessageDialog(WeChatUI.this, "请输入IP地址和端口号");
					return;
				}

				if (ds.isClosed()) {// 如果Socket处在关闭状态，提示监听不成功
					JOptionPane.showMessageDialog(WeChatUI.this, "监听不成功");
					return;
				}

				String sendContent = textArea.getText();// 获得用户在文本域中的信息
				byte[] buf = sendContent.getBytes();// 将用户信息转换成字节数组
				DatagramPacket p;// 声明一个DatagramPacket进行数据的发送
				try {
					p = new DatagramPacket(buf, buf.length, InetAddress.getByName(ipAddress),
							Integer.parseInt(remotePort));// 创建DatagramPacket对象=参数(字节数组，数据大小,IP,端口)

					ds.send(p);// 发送消息的核心代码

					// 将发送的内容追加到自己的聊天列表
					txtContent.append("我对" + ipAddress + ":" + remotePort + "说:\n" + sendContent + "\n\n");
					// 把滚动条固定在滚动面板的底部,如果设置为0，固定在顶部
					txtContent.setCaretPosition(txtContent.getDocument().getLength());
					textArea.setText("");// 对发送数据的文本域进行清空
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
