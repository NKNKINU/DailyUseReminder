package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;

public class AddGUI extends JFrame {

	private LocalDateTime time;
	private JTextField title_txt;
	private JTextField notes_txt;
	private JButton save_btn;
	private JTextField YearText;
	private JTextField MonthText;
	private JTextField DayText;
	private JTextField HourText;
	private JTextField MinuteText;
	private JCheckBox cbxImportant;
	private JLabel YearLabel;
	private JLabel MonthLabel;
	private JLabel DayLabel;
	private JLabel TitleLabel;
	private JLabel NotesLabel;
	private JLabel TimeLabel;
	private JLabel lblNewLabel;
	private JLabel lblMsg;


	public AddGUI() {
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		getContentPane().setLayout(null);

		time = LocalDateTime.now();

		title_txt = new JTextField();
		title_txt.setBounds(126, 95, 195, 37);
		getContentPane().add(title_txt);
		title_txt.setColumns(10);

		notes_txt = new JTextField();
		notes_txt.setBounds(126, 142, 195, 35);
		getContentPane().add(notes_txt);
		notes_txt.setColumns(10);

		save_btn= new JButton("Save");
		save_btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save_clicked();
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
		cbxImportant.setBounds(26,213,109,23);
		getContentPane().add(cbxImportant);
		
		YearText = new JTextField();
		YearText.setText(time.getYear() + "");
		YearText.setBounds(100, 23, 40, 21);
		getContentPane().add(YearText);
		YearText.setColumns(10);
		
		MonthText = new JTextField();
		MonthText.setText(time.getMonthValue() + "");
		MonthText.setColumns(10);
		MonthText.setBounds(191, 23, 40, 21);
		getContentPane().add(MonthText);
		
		DayText = new JTextField();
		DayText.setText(time.getDayOfMonth() + "");
		DayText.setColumns(10);
		DayText.setBounds(281, 23, 40, 21);
		getContentPane().add(DayText);
		
		MonthLabel = new JLabel("Month");
		MonthLabel.setBounds(150, 26, 58, 15);
		getContentPane().add(MonthLabel);
		
		DayLabel = new JLabel("Day");
		DayLabel.setBounds(250, 27, 52, 12);
		getContentPane().add(DayLabel);
		
		HourText = new JTextField();
		HourText.setText(time.getHour() + "");
		HourText.setBounds(155, 64, 40, 21);
		getContentPane().add(HourText);
		HourText.setColumns(10);
		
		TimeLabel = new JLabel("Hour");
		TimeLabel.setBounds(111, 67, 58, 15);
		getContentPane().add(TimeLabel);
		
		MinuteText = new JTextField();
		MinuteText.setText(time.getMinute() + 1 + "");
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
	private void save_clicked(){
		FileManager fileManager = FileManager.getInstance();
		try {
			//System.out.println(cbxImportant.isSelected());
			LocalDateTime time = LocalDateTime.of(Integer.parseInt(YearText.getText()), Integer.parseInt(MonthText.getText()), Integer.parseInt(DayText.getText()),Integer.parseInt(HourText.getText()), Integer.parseInt(MinuteText.getText()),0,  1);
			//System.out.println(task.toString());
			boolean result=fileManager.save(new Task(time, title_txt.getText(), notes_txt.getText(), cbxImportant.isSelected()));
			notify(result);
			this.dispose();
			
		}catch(Exception e) {
			lblMsg.setText("Unable to save the task ... Check your input of time");
		}
	}

	public void notify(boolean result) {
		if(result==true) {
			lblMsg.setText("A new task was saved successfully...");
			save_btn.setEnabled(false);
		}
		else {
			lblMsg.setText("Unable to save the task ... something wrong..");
		}
	}
}
