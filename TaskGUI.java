package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.*;
public class TaskGUI extends JFrame implements ActionListener {
	private Task task;
	private JButton edit_btn;
	private JButton delete_btn;
	private JLabel lblTitle;
	private JLabel lblNotes;
	private JLabel lblTime;

	public TaskGUI(Task curr_task) {
		task = curr_task;
		getContentPane().setLayout(null);

		edit_btn = new JButton("Edit");
		edit_btn.setBounds(87, 280, 97, 23);
		edit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit_click();
			}
		});
		getContentPane().add(edit_btn);

		delete_btn= new JButton("Is Done");
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_click();
			}
		});
		delete_btn.setBounds(200, 280, 97, 23);
		getContentPane().add(delete_btn);

		lblTitle = new JLabel(task.getTitle());
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 32));
		lblTitle.setBounds(60, 10, 253, 79);
		getContentPane().add(lblTitle);

		Long totalMin = Duration.between(LocalDateTime.now(), task.getTime()).toMinutes();
		int minutes = Integer.valueOf(totalMin % 60 + "");
		Double hours = Math.floor(totalMin / 60);

		lblNotes = new JLabel("Note: " + task.getNotes());
		lblNotes.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNotes.setBounds(61, 120, 236, 120);
		getContentPane().add(lblNotes);

		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

		lblTime = new JLabel("Due at: " + task.getTime().format(df));
		lblTime.setBounds(61, 95, 236, 15);
		getContentPane().add(lblTime);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == edit_btn) {
			edit_click();
		} else if (e.getSource() == delete_btn) {
			delete_click();
		}
	}
	private void edit_click() {
		FileManager fileManager = FileManager.getInstance();
		EditGUI egui = new EditGUI(fileManager.getCur_task());
		egui.setSize(400,400);
		egui.show();
	}
	private void delete_click() {
		FileManager fileManager = FileManager.getInstance();
		fileManager.getAll_tasks().remove(fileManager.getCur_task());
		fileManager.overwrite(fileManager.getAll_tasks());
		this.dispose();
	}
}
