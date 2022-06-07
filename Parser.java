package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Parser {

	private static Set<String> ignoreWords = new TreeSet<>();
	private static Map<String, Integer> wordMap = new HashMap<>();
	private FileInputStream inputText;
	private String t = new File("").getAbsolutePath();

	public Map<String, Integer> parse(InputStream in) throws Exception {//
		/**
		 * O(n log n): Both while & for loops
		 * Method Adding to wordmap from local file
		 * Realise this is repetitive but found it difficult to get both URL & local to meet at this point
		 */
		FileSource fs = new FileSource();			
		File f = fs.getInputFile();
		addToTreeSet(t);
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line = null;

			while ((line = br.readLine()) != null) {	
				String[] words = line.split("\\s+");	
				for (String s : words) {
					if (!ignoreWords.contains(s)) {
						s = s.trim().replaceAll("[^a-zA-Z]", "").toLowerCase();
						addToMap(s);
					}
				}
			}
		}catch (Exception e) {
			System.out.println("Error getting your file. Please try again");
			getBufferedText();
		}
		return wordMap;
	}

	protected static Map<String, Integer> getWordMap() {
		/**
		 * (O)1: Constant time, no loops 
		 * Getter method for wordmap
		 */
		return wordMap;
	}														

	protected static void setWordMap(Map<String, Integer> wordMap) {
		/**
		 * (O)1: Constant time, no loops  
		 * Setter method for wordmap
		 */
		Parser.wordMap = wordMap;
	}

	public void addToTreeSet(String t) throws Exception {
		/**
		 * O(n log n): Both while & for loops
		 * Method which reads the txt file ignorewords and adds it to a set called ignorewords
		 * Again tried to remove repetition but ended up with a null treeset if I tried to use one of this or the method on the filesource class.
		 */
		File f = new File("ignorewords.txt");
		try (BufferedReader ig = new BufferedReader(new FileReader(f))) {
			String line = null;
			while ((line = ig.readLine()) != null) {
				String[] words = line.split(" ");
				for (String s : words) {
					ignoreWords.add(s);					
				}										
			}
		}

	}

	public void addToMap(String s) {
		/**
		 * (O)n: Checking the string length causes the time as it searches char by char. wordMap is constant as it is key based
		 * Method Allows words between 3 & 12 characters long to be used. Removed many unwanted short words
		 * that were not in the ignorewords file. Also removed some weird translations from certain
		 * URLs where it looked like two or more words would merge
		 */
		if(s.length() >= 3 && s.length()<= 12) {
			int frequency = 1;
			if (wordMap.containsKey(s)) {
				frequency += wordMap.get(s);
			}											
			wordMap.put(s, frequency);					
		}											
		
	}
	
	public void getBufferedText() throws Exception {
		/**
		 * (//(O)1: Constant time, no loops
		 * Method calls parse
		 */
		Parser r = new Parser();
		r.parse(inputText);
	}
}