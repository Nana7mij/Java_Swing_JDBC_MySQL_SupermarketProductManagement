package team.nqnqmi.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import team.nqnqmi.Service.UserService;
import team.nqnqmi.bean.Reader;

public class txgreader extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtadd;
	private JButton button;
	private JButton button_1;
	private JTextField txtbir;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JPasswordField txtpwd;
	private JPasswordField txtpwd1;
	 UserManageUI user=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			txgreader dialog = new txgreader();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public txgreader() {}
	public txgreader(UserManageUI user,String id) {
		this.user=user;
		setBounds(100, 100, 499, 564);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\u8BFB\u8005\u7F16\u53F7\uFF1A");
		label.setBounds(51, 39, 91, 18);
		contentPanel.add(label);
		
		txtid = new JTextField();
		txtid.setBounds(173, 37, 170, 24);
		contentPanel.add(txtid);
		txtid.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label_1.setBounds(51, 101, 91, 18);
		contentPanel.add(label_1);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(173, 98, 170, 24);
		contentPanel.add(txtname);
		
		JLabel label_1_1 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		label_1_1.setBounds(51, 172, 105, 18);
		contentPanel.add(label_1_1);
		
		JLabel label_1_2 = new JLabel("\u5730\u5740\uFF1A");
		label_1_2.setBounds(51, 235, 91, 18);
		contentPanel.add(label_1_2);
		
		JLabel label_1_3 = new JLabel("\u6027\u522B\uFF1A");
		label_1_3.setBounds(51, 298, 91, 18);
		contentPanel.add(label_1_3);
		
		JLabel label_1_4 = new JLabel("\u5BC6\u7801\u4FEE\u6539\uFF1A");
		label_1_4.setBounds(51, 365, 91, 18);
		contentPanel.add(label_1_4);
		
		JLabel label_1_5 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_1_5.setBounds(51, 416, 91, 18);
		contentPanel.add(label_1_5);
		
		txtadd = new JTextField();
		txtadd.setColumns(10);
		txtadd.setBounds(173, 232, 170, 24);
		contentPanel.add(txtadd);
		
		button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateAction(user);
			}
		});
		button.setBackground(Color.CYAN);
		button.setBounds(55, 470, 116, 34);
		contentPanel.add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//释放当前窗体资源
				setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	
			}
		});
		button_1.setBackground(Color.ORANGE);
		button_1.setBounds(294, 470, 116, 34);
		contentPanel.add(button_1);
		
		 radioButton = new JRadioButton("\u7537");
		radioButton.setBounds(173, 294, 69, 27);
		contentPanel.add(radioButton);
		
		 radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setBounds(294, 294, 69, 27);
		contentPanel.add(radioButton_1);
		
		ButtonGroup bgRadio=new ButtonGroup();
		bgRadio.add(radioButton);
		bgRadio.add(radioButton_1);
		
		txtbir = new JTextField();
		txtbir.setColumns(10);
		txtbir.setBounds(173, 169, 170, 24);
		contentPanel.add(txtbir);
		
		txtpwd = new JPasswordField();
		txtpwd.setBounds(173, 362, 170, 24);
		contentPanel.add(txtpwd);
		
		txtpwd1 = new JPasswordField();
		txtpwd1.setBounds(173, 413, 170, 24);
		contentPanel.add(txtpwd1);
		init(id);
	}
	public void init(String id) {
		UserService es =new UserService();
		Reader e=es.getAllreader(id);
		txtid.setText(e.getReader_id());
		txtname.setText(e.getReader_name());
		txtbir.setText(e.getBirthday());
		txtadd.setText(e.getAddress());
		if(e.getSex().equals("男")) {
			radioButton.setSelected(true);
		}else if(e.getSex().equals("女")) {
			radioButton_1.setSelected(true);
		}
		txtpwd.setText(e.getReader_pwd());
		txtpwd1.setText(e.getReader_pwd());
	}
	public void UpdateAction(UserManageUI user) {
		UserService es =new UserService();
		String id=txtid.getText();
		String name=txtname.getText();
		String bir=txtbir.getText();
		 String add=txtadd.getText();
		 String sex="";
			if(radioButton.isSelected()) {
				sex=radioButton.getText();
			}else if(radioButton_1.isSelected()) {
				sex=radioButton_1.getText();
			}
		 String pwd=txtpwd.getText();		 
		 String pwd1=txtpwd1.getText();
		if(pwd.equals(pwd1)) { 
		Reader e=new Reader(id,name,bir,add,sex,pwd);		 
		int result=es.updateuser(e);
		if(result>0) {
			JOptionPane.showMessageDialog(null, "商品信息修改成功");
			this.dispose();
			ArrayList<Reader> product1=new ArrayList<Reader>();
			product1.add(e);
			UserTableModel etm=new UserTableModel(product1);
			user.table1.setModel(etm);
  		}
		}else {
			JOptionPane.showMessageDialog(null,"密码不一致");
		}
	}
}
