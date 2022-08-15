package GUI;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class ViewAllTasksGUI extends ViewTasksGUI {
	public ViewAllTasksGUI() {
		super();
	}
	@Override
	protected void showAllEntries() {
		FileManager fileManager = FileManager.getInstance();
		fileManager.load_AllTasks();
		for (int i = 0; i < fileManager.getAll_tasks().size(); i++) {
			btn_task = new JButton(fileManager.getAll_tasks().get(i).toString());
			Task temp = fileManager.getAll_tasks().get(i);
			
			if (temp.isImportant()) {
				btn_task.setBackground(Color.ORANGE);
			} else if (temp.getTime().getDayOfYear() == LocalDateTime.now().getDayOfYear()) {
				btn_task.setForeground(Color.white);
				btn_task.setBackground(new Color(100,151,177));
			}
			if (temp.getTime().isBefore(LocalDateTime.now())) {
				btn_task.setBackground(Color.RED);
			}
			btn_task.setBounds(72, 28 + 30 * i, 299, 23);
			getContentPane().add(btn_task);
			btn_task.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fileManager.setCur_task(temp);

					task_clicked();
				}
			});
		}
	}
}
