package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public abstract class ViewTasksGUI extends JFrame {
	protected JButton btn_task;
	protected Task temp;
	protected JButton btn_refresh;
	private JLabel lblTip;
	public ViewTasksGUI() {
		setupPanel();
		showAllEntries();
	}
	protected void setupPanel(){
		getContentPane().setLayout(null);
		btn_refresh = new JButton("refresh");
		btn_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btn_refresh.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_refresh.setBounds(162, 300, 97, 23);
		getContentPane().add(btn_refresh);

		lblTip = new JLabel("Please press refresh after editing or deleting a task.");
		lblTip.setBounds(44, 280, 362, 15);
		getContentPane().add(lblTip);
	}
	protected void task_clicked() {
		TaskGUI taskgui = new TaskGUI(FileManager.getInstance().getCur_task());
		taskgui.setSize(400,360);
		taskgui.show();
	}
	
	protected abstract void showAllEntries();
	
	protected void refresh() {
		getContentPane().removeAll();
		getContentPane().repaint();
		setupPanel();
		showAllEntries();
	}
}
