package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class FileSource {

	private Scanner s;
	private String url;
	private File f;
	static Set<String> ignoreWords = new TreeSet<>();
	static Map<String, Integer> wordMap = new HashMap<>();
	private FileInputStream inputText;

	public File setInputFile() { 	
		/**
		 * (O)1: Gets input, input size can vary with no big effect. No loops
		 * Method setting the file variable F
		 */
		System.out.println();		
		System.out.println("Please enter the file name that you wish to use: ");
		Scanner s = new Scanner(System.in);
		String fileName = s.next();
		File f = new File(fileName);
		return f;
	}								

	public File getInputFile() throws InterruptedException { 
		/**
		 * (O)1: Calls setInputFile which is also constant or gives error at same speed
		 * Method getting the file variable F
		 */
		try {
			f = setInputFile();
		} catch (Exception e) {
			System.out.println();
			System.out.println("Cannot find the file. Please retry.");
			System.out.println();
			TimeUnit.SECONDS.sleep(2);
			getInputFile();
		}														
		return f;
	}

	public Map<String, Integer> urlParse(Map<String, Integer> wordMap) throws Exception {
		/**
		 * (O(n log n): Both while & for loops
		 * Combined URL retrieval and adding to wordMap to be used later on
		 * Source: https://stackoverflow.com/questions/5200187/convert-inputstream-to-bufferedreader
		 */
		System.out.println();
		System.out.println("Please enter the URL that you wish to use: ");
		Scanner s = new Scanner(System.in);
		url = s.next();
		URL urlPath = new URL(url);						
		InputStream in1 = urlPath.openStream();
		ignoreWords = getIgnoreWordsFromFile();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(in1, "UTF-8"))) {    
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String t : words) {
					if (!ignoreWords.contains(t)) {
						String u = t.trim().replaceAll("[^a-zA-Z]", "").toLowerCase();
						Parser q = new Parser();
						q.addToMap(u);
					}
				}
			}
		}
		return wordMap;
	}

	public void urlOrLocalMenu() { 
		/**
		 * (O)1 Displays the below, no variables
		 * method displaying option between local file or url location
		 */
		System.out.println();
		System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT);
		System.out.println("1) Local File location");
		System.out.println("2) URL File Location");
		System.out.println("3) Quit");
		System.out.println("\nSelect Option [1-3]>");
		System.out.println(ConsoleColours.RESET);
		System.out.println();
	}

	public Map<String, Integer> urlOrLocalMenuOptions() throws Exception {
		/**
		 * (O)1: No loops, displays everything at same speed regardless of variable input
		 * Controller for methods to call after choice of URL or local file
		 */
		urlOrLocalMenu();
		s = new Scanner(System.in);
		int menuChoice = Integer.parseInt(s.next());	

		switch (menuChoice) {
		case 1:
			getBufferedText();
			break;
		case 2:
			urlParse(wordMap);
			break;
		case 3: {
			System.out.println("Shutting down");
			System.exit(menuChoice);
			;
		}

		default: {
			System.out.println("Invalid input: Please select from option 1-4");
			TimeUnit.SECONDS.sleep(2);
			main();
		}
		}			
		mapSort();
		wordCloud();
		main();
		return wordMap;
	}

	public void mapSort() throws Exception {
		/**
		 * (O)1: Constant time, no loops or variables
		 * Method that brings list method from HashMapSorter class
		 */
		HashMapSorter h = new HashMapSorter();
		h.list();								
	}

	public void wordCloud() throws Exception {
		/**
		 * (O)1: Constant time, no loops or variables
		 * brings wordcloud method from ReallySimpleWordCloud class
		 */
		ReallySimpleWordCloud rs = new ReallySimpleWordCloud();
		rs.WordCloud();							//
	}

	public void main() throws Exception {
		/**
		 * (O)1: Constant time, no loops or variables
		 * brings mainmenu method from menu class
		 */
		Menu m = new Menu();
		m.mainMenu();					
	}

	public void getBufferedText() throws Exception {//
		/**
		 * (O)1: Constant time, no loops
		 * Method to go to parse method in parser
		 */
		Parser r = new Parser();
		r.parse(inputText);
	}

	public Set<String> getIgnoreWordsFromFile() throws FileNotFoundException, IOException { 
		/**
		 * O(n log n): Both while & for loops
		 * reads in ignorewords.txt and creates a set containing the ignorewords
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
		return ignoreWords;				
	}

}
