package team.nqnqmi.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class HelpDocUI extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HelpDocUI dialog = new HelpDocUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HelpDocUI() {
		this.setResizable(false);
		setTitle("\u5E2E\u52A9\u4F7F\u7528\u7533\u660E");
		setIcon();// 设置图标
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 685, 786);
		this.setLocationRelativeTo(null);// 居中显示
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 255, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(45, 77, 560, 600);
		contentPanel.add(scrollPane);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane.setViewportView(editorPane);
		editorPane.setBackground(new Color(240, 255, 240));
		editorPane.setText(
				" \u5E2E\u52A9\u6587\u6863\uFF1A\r\n\t\u611F\u8C22\u4F7F\u7528\u672C\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\uFF0C\u672C\u7CFB\u7EDF\u81F4\u529B\u4E8E\u4E3A\u7528\u6237\u6253\u9020\u6700\u8212\u9002\uFF0C\u6700\u4FBF\u6377\u7684\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\r\n\t\u672C\u7CFB\u7EDF\u90E8\u5206\u5185\u5BB9\u6765\u6E90\u4E0E\u7F51\u7EDC\uFF0C\u5982\u6709\u4FB5\u6743\u8BF7\u4E0E\u6211\u4EEC\u8054\u7CFB\u3002\r\n\t\r\n\t\u4F7F\u7528\u8BF4\u660E\uFF1A\r\n\t\t\u60A8\u53EF\u4EE5\u4F7F\u7528\u672C\u7CFB\u7EDF\u5BF9\u56FE\u4E66\u8FDB\u884C\u589E\u5220\u6539\u67E5\u501F\u9605\u7B49\u64CD\u4F5C\u3002\r\n\t\t\u53CC\u51FB\u60A8\u9009\u4E2D\u7684\u4E66\u7C4D\u53EF\u8FDB\u884C\u4FEE\u6539\u64CD\u4F5C\uFF0C\u53F3\u952E\u5355\u51FB\u53EF\u4EE5\r\n\t\t\u5BF9\u4E66\u7C4D\u8FDB\u884C\u5220\u9664\u3002\u8FD8\u6709\u66F4\u591A\u64CD\u4F5C\u6B63\u5728\u5F00\u53D1\u4E2D\uFF0C\u6B22\u8FCE\r\n\t\t\u7528\u6237\u4E3A\u6211\u4EEC\u63D0\u4F9B\u5B9D\u8D35\u610F\u89C1\u3002\u656C\u8BF7\u671F\u5F85\r\n\r\n\t\u514D\u8D23\u58F0\u660E\uFF1A\r\n\t\t \u60A8\u6240\u6709\u7684\u635F\u5931\u90FD\u4E0E\u6211\u4EEC\u65E0\u5173\uFF0C\u6211\u4EEC\u63D0\u4F9B\u7684\u4EA7\u54C1\u5747\u4E3A\u514D\u8D39\u4F7F\u7528\r\n\t\t\u4E0D\u63D0\u4F9B\u4FE1\u606F\u4FDD\u62A4\u529F\u80FD\u3002");
	}

	// 设置图标
	public void setIcon() {
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以
		java.awt.Image img = tk.getImage("picture\\fox.png");
		// 给窗体设置图标
		this.setIconImage(img);
	}
}
