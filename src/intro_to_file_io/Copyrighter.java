//Copyright © 2017 by David Lee 
package intro_to_file_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copyrighter {
	public static void main(String[] args) {
		File file = new File("src/intro_to_file_io");
		File[] files = file.listFiles();
		
		try {
			FileReader fileReader;
			FileWriter fileWriter;
			String copyrightedFile = "";
			for (int i = 0; i < files.length; i++) {
				System.out.println(files.length);
				if(files[i].getAbsolutePath().contains(".java")) {
					fileReader = new FileReader(files[i].getAbsolutePath());
					int c = fileReader.read();
					while(c != -1) {
						copyrightedFile += (char) c;
						c = fileReader.read();
					}
					System.out.println(copyrightedFile);
					fileWriter = new FileWriter(files[i].getAbsolutePath());
					fileWriter.write("//Copyright © 2017 by David Lee \n"+copyrightedFile);
					fileReader.close();
					fileWriter.close();
					copyrightedFile = "";
				}
			System.out.println(copyrightedFile);
			
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
	}

}

