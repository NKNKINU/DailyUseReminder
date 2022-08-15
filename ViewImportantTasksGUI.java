package GUI;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class ViewImportantTasksGUI extends ViewTasksGUI {
    public ViewImportantTasksGUI() {
    	super();
    }
	@Override
    protected void showAllEntries() {
		FileManager fileManager = FileManager.getInstance();
        fileManager.load_AllTasks();
        int position = 0;
        for (int j = 0; j < fileManager.getAll_tasks().size(); j++) {
            Task temp = fileManager.getAll_tasks().get(j);
            if (temp.isImportant()) {
                btn_task = new JButton(fileManager.getAll_tasks().get(j).toString());
                btn_task.setBackground(Color.ORANGE);
                btn_task.setBounds(72, 28 + 30 * position, 299, 23);
                position += 1;
                if (temp.getTime().isBefore(LocalDateTime.now())) {
    				btn_task.setBackground(Color.RED);
    			}
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
}
