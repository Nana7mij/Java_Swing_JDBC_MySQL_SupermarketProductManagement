package team.nqnqmi.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import team.nqnqmi.Service.AdminService;
import team.nqnqmi.bean.Admin;

public class registerUI1 extends JPanel {
	private JLabel Labicon;
	private JTextField txtWorkId;
	private JTextField txtPwd;
	private JRadioButton rdbWomen;
	private JRadioButton rdbMan;

	//ע�ᱳ��
	public void paintComponent(Graphics g) {//��д�������ķ���
		super.paintComponent(g);
		ImageIcon image = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\background.jpg");//����ͼƬ
		image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));//����ͼƬ��С��������С
		g.drawImage(image.getImage(), 0, 0, this);//���»������
	}
	//ע��UI
	public registerUI1() {
		setBackground(new Color(255, 240, 245));
		setLayout(null);
		setSize(984,519);
		//��¼LOGO��ͼ��
		ImageIcon icon = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\Loginlogo1.png");
		Labicon = new JLabel(icon);
		Labicon.setBounds(180, 190, 200, 200);
		this.add(Labicon);
		//����ע�ᡱ����
		ImageIcon icos = new ImageIcon("E:\\GitHub\\Java_Swing_JDBC_MySQL_SupermarketProductManagement-master\\java\\SupermarketProductManagement\\picture\\register2.png");
		JLabel LabLoginicon = new JLabel(icos);
		LabLoginicon.setBounds(534, 189, 58, 32);
		this.add(LabLoginicon);
		
		txtWorkId = new JTextField();
		txtWorkId.setBounds(467, 231, 196, 32);
		add(txtWorkId);
		txtWorkId.setColumns(10);
		
		//�ָ���
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);//���÷ָ�����ֱ
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(380, 104, 1, 400);
		this.add(separator);
		
		txtPwd = new JTextField();
		txtPwd.setColumns(10);
		txtPwd.setBounds(467, 282, 196, 32);
		add(txtPwd);
		
		 rdbMan = new JRadioButton("\u7537");
		rdbMan.setSelected(true);
		rdbMan.setBackground(null);
		rdbMan.setBounds(489, 333, 50, 23);
		add(rdbMan);
		
		rdbWomen = new JRadioButton("\u5973");
		rdbWomen.setBackground((Color) null);
		rdbWomen.setBounds(575, 333, 50, 23);
		add(rdbWomen);
		
		ButtonGroup a = new ButtonGroup();
		a.add(rdbMan);
		a.add(rdbWomen);
		
		JLabel LabName = new JLabel("\u5DE5\u4F5C\u8BC1\uFF1A");
		LabName.setBounds(396, 236, 61, 20);
		add(LabName);
		
		JLabel LabName_1 = new JLabel("\u5BC6\u7801\uFF1A");
		LabName_1.setBounds(407, 287, 40, 20);
		add(LabName_1);
		
		JButton btnAdd = new JButton("\u6CE8\u518C");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnAdd.setBackground(new Color(255, 182, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(238, 130, 238));
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account=txtWorkId.getText();
				String pwd=txtPwd.getText();
				AdminService as;
				
				if("".equals(account) || "".equals(pwd)) {
					RemainUI remainUI=new RemainUI("��ʾ","���Ĺ����Ż�����δ����");
					
//					JOptionPane.showMessageDialog(null, "���Ĺ����Ż�����δ����");
				}else if(!isNumeric(account)) {
					JOptionPane.showMessageDialog(null, "������Ĺ����Ų���ȷ");
				}else {
					as=new AdminService();
					int result=as.AddAdmin(pwd);
					if(result>0) {//˵����ӳɹ�
						System.out.println("ע��ɹ�");
						JOptionPane.showMessageDialog(null, "ע��ɹ�");
						txtWorkId.setText("");
						txtPwd.setText("");
						Admin admin=as.getLastAdmin_id();
						System.out.println(admin);
						JOptionPane.showMessageDialog(null, "���ĵ�½�˺���"+admin.getAdmin_id()+",���μ������˺ţ���������");
					}
					System.out.println(result);
					
				}
				

			}
		});
		btnAdd.setBackground(new Color(238, 130, 238));
		btnAdd.setBounds(467, 373, 196, 38);
		add(btnAdd);

	}

	// �ж��Ƿ�������
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
