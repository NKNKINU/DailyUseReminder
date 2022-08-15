package GUI;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class ViewTodayTasksGUI extends ViewTasksGUI {
    public ViewTodayTasksGUI() {
        super();
    }
    @Override
    protected void showAllEntries() {
    	FileManager fileManager = FileManager.getInstance();
        fileManager.load_AllTasks();
        int position = 0;
        for (int i = 0; i < fileManager.getAll_tasks().size(); i++) {
            temp = fileManager.getAll_tasks().get(i);
            if (temp.getTime().getDayOfYear() == LocalDateTime.now().getDayOfYear()) {
                btn_task = new JButton(fileManager.getAll_tasks().get(i).toString());
                btn_task.setForeground(Color.white);
                btn_task.setBackground(new Color(100,151,177));
                btn_task.setBounds(72, 28 + 30 * position, 299, 23);
                position += 1;
                if (temp.isImportant()) {
    				btn_task.setBackground(Color.ORANGE);
                }
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
