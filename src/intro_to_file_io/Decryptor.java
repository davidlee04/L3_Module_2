//Copyright © 2017 by David Lee 
package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Decryptor {
	public static void main(String[] args) {
		String fileName = "";
		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = fileChooser.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
		String initial = "";
		String message = "";
		
		try {
			FileReader fileReader = new FileReader(fileName);
			int a = fileReader.read();
			while(a != -1) {
				initial += (char) a;
				a = fileReader.read();
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < initial.length(); i+=2) {
			message += initial.charAt(i);
		}
		System.out.println(message);
	}

}
