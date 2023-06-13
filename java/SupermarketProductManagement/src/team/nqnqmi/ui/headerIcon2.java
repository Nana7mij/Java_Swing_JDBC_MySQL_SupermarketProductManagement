package team.nqnqmi.ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class headerIcon2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public headerIcon2() {
		setSize(175,175);
		setLayout(null);
		setBackground(null);
		
		ImageIcon image01=new ImageIcon("picture\\cloud.png");
		JLabel LabiconHeader = new JLabel(image01);
		LabiconHeader.setBounds(0, 0, 175, 175);
		add(LabiconHeader);
		
		

	}
}
