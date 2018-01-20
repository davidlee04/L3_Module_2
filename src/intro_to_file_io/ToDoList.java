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
import javax.swing.JFileChooser;
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
	JLabel taskList;
	//JTextField tasksList;
	
	String task = "";
	
	public static void main(String[] args) {
		ToDoList go = new ToDoList();
		go.setUI();
		go.refreshLabel();
	}
	void setUI() {
		frame = new JFrame();
		panel = new JPanel();
		addTask = new JButton();
		removeTask = new JButton();
		save = new JButton();
		load = new JButton();
		taskList = new JLabel();
		//tasksList = new JTextField();
		frame.add(panel);
		panel.add(addTask);
		panel.add(removeTask);
		panel.add(save);
		panel.add(load);
		panel.add(taskList);
		//panel.add(tasksList);
		addTask.setText("Add Task");
		removeTask.setText("Remove ");
		save.setText("Save Current Task List");
		load.setText("Load New Task List");
		addTask.addActionListener(this);
		removeTask.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.setVisible(true);
		frame.setSize(575, 500);
		//tasksList.setEditable(false);
	}
		
	void refreshLabel() {
		taskList.setText("");
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/savedtasks.txt"));
			String line = br.readLine();
			tasks.clear();
			while(line != null){
				task += line+" ";
				System.out.println(tasks);
				tasks.add(line);
				System.out.println(tasks);
				line = br.readLine();
			}
			for (int i = 0; i < tasks.size(); i++) {
				if(i == 0) {
					taskList.setText(taskList.getText()+tasks.get(i)+System.lineSeparator());
				}else if(i >= 1) {
					taskList.setText(taskList.getText()+", "+tasks.get(i)+System.lineSeparator());
				}
			}
			br.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addTask)) {
			String newTask = JOptionPane.showInputDialog("Enter a task.");
			tasks.add(newTask);
			
		}
		if(e.getSource().equals(removeTask)) {
			String removeTask = JOptionPane.showInputDialog("Enter the task you want to remove.");
			tasks.remove(removeTask);
			
		}
		if(e.getSource().equals(save)) {
			try {
				//System.out.println(tasks);
				FileWriter fileWriter = new FileWriter("src/intro_to_file_io/savedtasks.txt", false);
				for (int i = 0; i < tasks.size(); i++) {
					fileWriter.write(tasks.get(i)+"\n");
				}
				fileWriter.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			refreshLabel();
		
		}
		if(e.getSource().equals(load)) {
			String fileName = "";
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName = jfc.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
				System.out.println(fileName.substring(34));
			}
			try {
				tasks.clear();
				BufferedReader buffReader = new BufferedReader(new FileReader(fileName.substring(34)));
				String readLine = buffReader.readLine();
				while(readLine != null) {
					tasks.add(readLine);
					readLine = buffReader.readLine();
				}
			} catch (FileNotFoundException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		}
	}

}
