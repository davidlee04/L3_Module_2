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
			int lol = fileReader.read();
			while(lol != -1) {
				initial += (char) lol;
				lol = fileReader.read();
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 1; i < initial.length(); i+=2) {
			if (initial.charAt(i) != 'g') {
				message += initial.charAt(i);
			}
		}
		message = initial;
		System.out.println(message);
	}

}
