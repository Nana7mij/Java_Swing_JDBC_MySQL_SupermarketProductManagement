package team.nqnqmi.ui;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class MessageBar2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public MessageBar2() {
		setBackground(Color.WHITE);
		setSize(294,271);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 21, 294, 2);
		add(separator);
		
		JLabel Labhint = new JLabel("You have no information at the moment !");
		Labhint.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 12));
		Labhint.setBounds(10, 33, 274, 36);
		add(Labhint);
		
		JLabel Labchinese = new JLabel("\u60A8\u6682\u672A\u6536\u5230\u4FE1\u606F");
		Labchinese.setBounds(10, 97, 250, 80);
		add(Labchinese);
		
	}
}
