package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.time.LocalDateTime;
public class EditGUI extends JFrame {
    private JTextField title_txt;
    private JTextField notes_txt;
    private JButton save_btn;
    private JTextField YearText;
    private JTextField MonthText;
    private JTextField DayText;
    private JTextField HourText;
    private JTextField MinuteText;
    private JCheckBox cbxImportant;
    private Task currTask;
    private JLabel lblNewLabel;
    private JLabel lblMsg;
    private JLabel YearLabel;
    private JLabel TitleLabel;
    private JLabel NotesLabel;
    private JLabel MonthLabel;
    private JLabel DayLabel;
    private JLabel TimeLabel;

    public EditGUI(Task currTask) {
        this.currTask = currTask;

        getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 12));
        getContentPane().setLayout(null);

        title_txt = new JTextField();
        title_txt.setText(currTask.getTitle());
        title_txt.setBounds(126, 95, 195, 37);
        getContentPane().add(title_txt);
        title_txt.setColumns(10);

        notes_txt = new JTextField();
        notes_txt.setText(currTask.getNotes());
        notes_txt.setBounds(126, 142, 195, 35);
        getContentPane().add(notes_txt);
        notes_txt.setColumns(10);

        save_btn= new JButton("Save");
        save_btn.setFont(new Font("宋体", Font.PLAIN, 16));
        save_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveEdit_clicked();
            }
        });
        save_btn.setBounds(155, 206, 122, 35);
        getContentPane().add(save_btn);

        YearLabel = new JLabel("Year");
        YearLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        YearLabel.setBounds(65, 23, 58, 15);
        getContentPane().add(YearLabel);

        TitleLabel = new JLabel("Title");
        TitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        TitleLabel.setBounds(43, 103, 58, 15);
        getContentPane().add(TitleLabel);

        NotesLabel = new JLabel("Notes");
        NotesLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        NotesLabel.setBounds(43, 149, 58, 15);
        getContentPane().add(NotesLabel);

        cbxImportant = new JCheckBox("important");
        cbxImportant.setSelected(currTask.isImportant());
        cbxImportant.setBounds(26,213,109,23);
        getContentPane().add(cbxImportant);

        YearText = new JTextField();
        YearText.setText(currTask.getTime().getYear() + "");
        YearText.setBounds(100, 23, 40, 21);
        getContentPane().add(YearText);
        YearText.setColumns(10);

        MonthText = new JTextField();
        MonthText.setText(currTask.getTime().getMonthValue() + "");
        MonthText.setColumns(10);
        MonthText.setBounds(191, 23, 40, 21);
        getContentPane().add(MonthText);

        DayText = new JTextField();
        DayText.setText(currTask.getTime().getDayOfMonth() + "");
        DayText.setColumns(10);
        DayText.setBounds(281, 23, 40, 21);
        getContentPane().add(DayText);

        MonthLabel = new JLabel("Month");
        MonthLabel.setBounds(158, 26, 58, 15);
        getContentPane().add(MonthLabel);

        DayLabel = new JLabel("Day");
        DayLabel.setBounds(256, 27, 52, 12);
        getContentPane().add(DayLabel);

        HourText = new JTextField();
        HourText.setText(currTask.getTime().getHour() + "");
        HourText.setBounds(155, 64, 40, 21);
        getContentPane().add(HourText);
        HourText.setColumns(10);

        TimeLabel = new JLabel("Hour");
        TimeLabel.setBounds(111, 67, 58, 15);
        getContentPane().add(TimeLabel);

        MinuteText = new JTextField();
        MinuteText.setText(currTask.getTime().getMinute() + "");
        MinuteText.setColumns(10);
        MinuteText.setBounds(268, 64, 40, 21);
        getContentPane().add(MinuteText);

        lblNewLabel = new JLabel("Minute");
        lblNewLabel.setBounds(219, 67, 58, 15);
        getContentPane().add(lblNewLabel);

        lblMsg = new JLabel("");
        lblMsg.setBounds(26, 181, 381, 15);
        getContentPane().add(lblMsg);
    }

    private void saveEdit_clicked(){
        FileManager fileManager = FileManager.getInstance();
        currTask.setImportant(cbxImportant.isSelected());
        currTask.setNotes(notes_txt.getText());
        currTask.setTitle(title_txt.getText());
        LocalDateTime time = LocalDateTime.of(Integer.parseInt(YearText.getText()), Integer.parseInt(MonthText.getText()),
                Integer.parseInt(DayText.getText()),Integer.parseInt(HourText.getText()), Integer.parseInt(MinuteText.getText()),
                0,  1);
        currTask.setTime(time);
        fileManager.getAll_tasks().remove(currTask);
        fileManager.overwrite(fileManager.getAll_tasks());
        // to do
        try {
//            System.out.println(cbxImportant.isSelected());
//            System.out.println(currTask);
            boolean result=fileManager.save(currTask);
            notify(result);
            this.dispose();
        }catch(Exception e) {
            lblMsg.setText("Unable to save the task ... Time must be implemented");
        }
    }

    public void notify(boolean result) {
        if(result==true) {
            lblMsg.setText("The task was edited successfully...");
            save_btn.setEnabled(false);
        }
        else {
            lblMsg.setText("Unable to edit the task ... something wrong..");
        }
    }
}
