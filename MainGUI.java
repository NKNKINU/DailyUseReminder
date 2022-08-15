package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton addNewTask_btn;
	private JButton important_btn;
	private JButton allTask_btn;
	private JButton today_btn;
	private JButton search_btn;
	private JButton exit_btn;

	public MainGUI() {
		/*
		 summary
		 	auto-generated code starts here
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addNewTask_btn = new JButton("Add New Task");
		addNewTask_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTask_clicked();
			}
		});
		addNewTask_btn.setBounds(130, 30, 161, 35);
		contentPane.add(addNewTask_btn);

		important_btn = new JButton("Important Tasks");
		important_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				important_clicked();
			}
		});
		important_btn.setBounds(130, 120, 161, 35);
		contentPane.add(important_btn);
		
		allTask_btn = new JButton("View All Tasks");
		allTask_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAll_clicked();
			}
		});
		allTask_btn.setBounds(130, 75, 161, 35);
		contentPane.add(allTask_btn);
		
		today_btn = new JButton("Tasks Due Today");
		today_btn.setBounds(130, 165, 161, 35);
		today_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				today_clicked();
			}
		});
		contentPane.add(today_btn);

		search_btn = new JButton("Search Tasks");
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_clicked();
			}
		});
		search_btn.setBounds(130, 210, 161, 35);
		contentPane.add(search_btn);

		exit_btn = new JButton("Exit");
		exit_btn.setBounds(130, 255, 161, 29);
		contentPane.add(exit_btn);
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit_clicked();
			}
		});
	}
	private void addTask_clicked(){
		AddGUI addGUI = new AddGUI();
		addGUI.setSize(420,340);
		addGUI.show();
	}
	private void viewAll_clicked(){
		ViewTasksGUI allTaskGUI = new ViewAllTasksGUI();
		allTaskGUI.setSize(440,380);
		allTaskGUI.show();
	}
	private void search_clicked() {
		SearchGUI sgui = new SearchGUI();
		sgui.setSize(400,250);
		sgui.show();
	}
	private void today_clicked() {
		ViewTasksGUI tgui = new ViewTodayTasksGUI();
		tgui.setSize(440,380);
		tgui.show();
	}
	private void important_clicked() {
		ViewTasksGUI igui = new ViewImportantTasksGUI();
		igui.setSize(440,380);
		igui.show();
	}
	private void exit_clicked() {
		System.exit(0);
	}
}
