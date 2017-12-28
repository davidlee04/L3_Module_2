package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Assignment {
	public static void main(String[] args) {
		String initial = JOptionPane.showInputDialog("put something in");
		String message = "";
		
		for (int i = 0; i < initial.length(); i++) {
			message += initial.charAt(i);
			message += "g";
		}
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/encryptedmessage.txt", true);
			fw.write(message);
			fw.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
