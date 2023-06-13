package team.nqnqmi.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import team.nqnqmi.Service.UserService;
import team.nqnqmi.bean.Reader;

public class zhuche extends JFrame {

	private JPanel contentPane;
	private JTextField txtld;
	private JTextField txtName;
	private JTextField textField;
	private JComboBox BoxYear;
	private JComboBox BoxMouse;
	private JComboBox BoxDay;
	private JRadioButton radio;
	private JRadioButton nradio;
	private ButtonGroup bgRadio;
	private JPasswordField password;
	private JPasswordField password1;
	Calendar cal = Calendar.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zhuche frame = new zhuche();
					frame.setLocationRelativeTo(null);
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
	public zhuche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtld = new JTextField();
		txtld.setBounds(158, 13, 183, 35);
		contentPane.add(txtld);
		txtld.setColumns(10);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(158, 80, 183, 35);
		contentPane.add(txtName);

		JButton btnNewButton = new JButton("\u6DFB  \u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 获取输入
				String id = txtld.getText();
				String name = txtName.getText();
				String year = (String) BoxYear.getSelectedItem();
				String mouse = (String) BoxMouse.getSelectedItem();
				String day = (String) BoxDay.getSelectedItem();
				String add = textField.getText();
				String sex = "";
				if (radio.isSelected()) {
					sex = radio.getText();
				} else if (nradio.isSelected()) {
					sex = nradio.getText();
				}
				String pwd = password.getText();
				String pwd1 = password1.getText();

				if (pwd.equals(pwd1)) {
					Reader red1 = new Reader(id, name, year + "-" + mouse + "-" + day, add, sex, pwd);
					UserService es = new UserService();
					int result = es.addReader(red1);
					if (result > 0) {
						JOptionPane.showMessageDialog(null, "插入数据成功");
					}
				} else {
					JOptionPane.showMessageDialog(null, "两次密码不一致");

				}

			}
		});
		btnNewButton.setBounds(158, 461, 113, 27);
		contentPane.add(btnNewButton);

		JLabel LabId = new JLabel("\u7F16  \u53F7");
		LabId.setBounds(31, 21, 72, 18);
		contentPane.add(LabId);

		JLabel LabId_1 = new JLabel("\u59D3   \u540D");
		LabId_1.setBounds(31, 88, 72, 18);
		contentPane.add(LabId_1);

		JLabel LabId_1_1 = new JLabel("\u751F  \u65E5");
		LabId_1_1.setBounds(31, 154, 72, 18);
		contentPane.add(LabId_1_1);

		int a = 1950;// 指定初始年份
		int year = cal.get(Calendar.YEAR);// 获取年
		int month = cal.get(Calendar.MONTH) + 1;// 月
		int day = cal.get(Calendar.DAY_OF_MONTH) + 1;// 日
		String[] y = new String[year - a + 1];
		for (int i = 0; i < y.length; i++) {
			y[i] = String.valueOf(a++);
		}
		BoxYear = new JComboBox();
		BoxYear.setModel(new DefaultComboBoxModel(y));
		BoxYear.setBounds(158, 151, 53, 24);
		contentPane.add(BoxYear);

		String[] m = new String[12];
		for (int i = 0; i < 12; i++) {
			m[i] = String.valueOf(i + 1);
		}
		BoxMouse = new JComboBox();
		BoxMouse.setModel(new DefaultComboBoxModel(m));
		BoxMouse.setBounds(222, 151, 53, 24);
		contentPane.add(BoxMouse);

		String[] d = new String[day];
		for (int i = 0; i < d.length; i++) {
			d[i] = String.valueOf(i + 1);
		}
		BoxDay = new JComboBox();
		BoxDay.setModel(new DefaultComboBoxModel(d));
		BoxDay.setBounds(289, 151, 52, 24);
		contentPane.add(BoxDay);

		JLabel Labadd = new JLabel("\u5730  \u5740");
		Labadd.setBounds(31, 226, 72, 18);
		contentPane.add(Labadd);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(158, 223, 183, 35);
		contentPane.add(textField);

		JLabel Labsex = new JLabel("\u6027  \u522B");
		Labsex.setBounds(31, 296, 72, 18);
		contentPane.add(Labsex);

		radio = new JRadioButton("\u7537");
		radio.setBounds(174, 292, 57, 27);
		contentPane.add(radio);

		nradio = new JRadioButton("\u5973");
		nradio.setBounds(279, 292, 57, 27);
		contentPane.add(nradio);

		bgRadio = new ButtonGroup();
		bgRadio.add(radio);
		bgRadio.add(nradio);

		JLabel Labpwd = new JLabel("\u5BC6\u7801\u8BBE\u7F6E");
		Labpwd.setBounds(31, 346, 72, 18);
		contentPane.add(Labpwd);

		password = new JPasswordField();
		password.setBounds(158, 343, 183, 35);
		contentPane.add(password);

		JLabel Labpwd_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		Labpwd_1.setBounds(31, 413, 72, 18);
		contentPane.add(Labpwd_1);

		password1 = new JPasswordField();
		password1.setBounds(158, 399, 183, 35);
		contentPane.add(password1);
	}
}
