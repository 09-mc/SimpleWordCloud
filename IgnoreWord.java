package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class IgnoreWord {

	public void ignoreWordsList() throws Exception { 
		/**
		 * O(n): while loop is linear time
		 * Method displays ignorewords
		 */
		File f = new File("ignorewords.txt");
		try (BufferedReader ig = new BufferedReader(new FileReader(f))) {
			String s;
			while ((s = ig.readLine()) != null)
				System.out.println(s);
		}
	}
}