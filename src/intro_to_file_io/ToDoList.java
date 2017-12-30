package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	HashMap<Integer, String> tasks = new HashMap<Integer, String>();
	
	JFrame frame;
	JPanel panel;
	JButton addTask;
	JButton removeTask;
	JButton save;
	JButton load;
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
		frame.add(panel);
		panel.add(addTask);
		panel.add(removeTask);
		panel.add(save);
		panel.add(load);
		addTask.setText("Add Task");
		removeTask.setText("Remove ");
		save.setText("Save Current Task List");
		load.setText("Load New Task List");
		addTask.addActionListener(this);
		removeTask.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.setVisible(true);
		frame.setSize(700, 500);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addTask)) {
			String newTask = JOptionPane.showInputDialog("Enter a task.");
			
		}
		if(e.getSource().equals(removeTask)) {
			
		}
	}

}
