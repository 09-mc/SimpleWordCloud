package ie.gmit.dip;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {

	private Scanner s;

	public void mainMenu() throws Exception {
		{
			/**
			 * (O)1: Constant time, no loops. Variable will not change overall run-time (by much)
			 * Method showing main menu choices
			 */
			
			showOptions();
			s = new Scanner(System.in);
			int menuChoice = Integer.parseInt(s.next());

			switch (menuChoice) {
			case 1:
				localOrUrl();
				break;
			case 2:
				ignoreWordsMenuOptions();
				break;
			case 3: {
				System.out.println("Shutting down");
				System.exit(menuChoice);
				;
			}

			default: {
				System.out.println("Invalid input: Please select from option 1-4");
				TimeUnit.SECONDS.sleep(2);
				mainMenu();
			}
			}

		}
	}

	private void showOptions() {
/**
 * (O)1: Constant time, display only
 */
		System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*                 Word Cloud Map                  *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");

		System.out.println("1) Word Cloud Generator");
		System.out.println("2) Ignore Words List");
		System.out.println("3) Quit");
		System.out.println("\nSelect Option [1-3]>");
		System.out.println(ConsoleColours.RESET);
	}

	public void getIgnoreWordList() throws Exception {
		/**
		 * (O)1: Constant time, no loops or variables
		 * Method to call the ignorewordslist
		 */
		IgnoreWord iw = new IgnoreWord();
		iw.ignoreWordsList();
	}

	private void ignoreWordMenu() {
		/**
		 * (O)1: Constant time, display only
		 * Method to display the ignorewordmenu
		 */
		System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*                 Word Cloud Map                  *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");

		System.out.println("1) Display Ignore word list");
		System.out.println("2) Quit to main menu");
		System.out.println("\nSelect Option [1-2]>");
		System.out.println(ConsoleColours.RESET);
	}

	public void ignoreWordsMenuOptions() throws Exception {
		/**
		 * (O)1: Constant time, no loops. Variable will not change overall run-time (by much)
		 * Method showing the Ignore word menu and follow on methods based on choices
		 */
		
		ignoreWordMenu();
		s = new Scanner(System.in);
		int menuChoice = Integer.parseInt(s.next());

		switch (menuChoice) {
		case 1:
			getIgnoreWordList();
			System.out.println("Press Enter to continue...");
			System.in.read();
			ignoreWordsMenuOptions();
		case 2: {
			mainMenu();
			;
		}

		default: {
			System.out.println("Invalid input: Please select from option 1-2");
			TimeUnit.SECONDS.sleep(2);
			ignoreWordMenu();
		}
		}
	}

	public void localOrUrl() throws Exception {
		/**
		 * (O)1: Constant time, no loops or variables
		 * calls option menu for local or URL source
		 */
		FileSource fs = new FileSource();
		fs.urlOrLocalMenuOptions();				
	
	}

}