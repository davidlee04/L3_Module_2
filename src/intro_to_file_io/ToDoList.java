package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToDoList implements ActionListener {
	ArrayList<String> tasks = new ArrayList<String>();
	
	JFrame frame;
	JPanel panel;
	JButton addTask;
	JButton removeTask;
	JButton save;
	JButton load;
	//JLabel taskList;
	JTextField tasksList;
	
	String task = "";
	
	int removeTaskNum = 100000000;
	public static void main(String[] args) {
		ToDoList go = new ToDoList();
		go.setUI();
	}
	void setUI() {
		frame = new JFrame();
		panel = new JPanel();
		addTask = new JButton();
		removeTask = new JButton();
		save = new JButton();
		load = new JButton();
		//taskList = new JLabel();
		tasksList = new JTextField();
		frame.add(panel);
		panel.add(addTask);
		panel.add(removeTask);
		panel.add(save);
		panel.add(load);
		//panel.add(taskList);
		panel.add(tasksList);
		addTask.setText("Add Task");
		removeTask.setText("Remove ");
		save.setText("Save Current Task List");
		load.setText("Load New Task List");
		addTask.addActionListener(this);
		removeTask.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.setVisible(true);
		frame.setSize(625, 500);
		tasksList.setEditable(false);
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/savedtasks.txt"));
			String line = br.readLine();
			while(line != null){
				task += line+"\n";
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//taskList.setText(task);
		tasksList.setText(task);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addTask)) {
			String taskNum = JOptionPane.showInputDialog("Enter the task number (e.g. 1, 2, etc...).");
			String newTask = JOptionPane.showInputDialog("Enter the corresponding task.");
			int taskInt = Integer.parseInt(taskNum);
			
		}
		if(e.getSource().equals(removeTask)) {
			String removeTask = JOptionPane.showInputDialog("Enter the # of the task you want to remove.");
			removeTaskNum = Integer.parseInt(removeTask);
			
		}
		if(e.getSource().equals(save)) {
			try {
				FileWriter fileWriter = new FileWriter("src/intro_to_file_io/savedtasks.txt");
				fileWriter.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
