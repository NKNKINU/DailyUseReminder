package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SearchGUI extends JFrame {
	private static JTextField search_txt;
	private  JButton search_btn;
	private JLabel lblMsg;
	private JLabel lblNewLabel;
	public SearchGUI() {
		getContentPane().setLayout(null);
		
		search_txt = new JTextField();
		search_txt.setBounds(82, 75, 248, 21);
		getContentPane().add(search_txt);
		search_txt.setColumns(10);
		search_btn = new JButton("Search");
		search_btn.setBounds(156, 145, 97, 23);
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResult_clicked();
			}
		});
		getContentPane().add(search_btn);

		lblMsg = new JLabel("");
		lblMsg.setBounds(87, 120, 381, 15);
		getContentPane().add(lblMsg);
		
		lblNewLabel = new JLabel("Search by title");
		lblNewLabel.setBounds(156, 49, 97, 15);
		getContentPane().add(lblNewLabel);
	}

	private void searchResult_clicked() {
		ViewSearchResultsGUI sgui = new ViewSearchResultsGUI();
		sgui.setSize(440,380);
		sgui.show();
	}
	public static String getSearch_txt() {
		return search_txt.getText();
	}
}
