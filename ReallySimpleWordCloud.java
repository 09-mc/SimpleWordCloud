package ie.gmit.dip;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class ReallySimpleWordCloud extends HashMapSorter {
	private static String fontType;
	private static int letterType;
	private static Entry<String, Integer> listIndex;
	private static String word;

	public static void WordCloud() throws Exception { 
		/**
		 * O(n log n): Search feature on string marked below plus a for loop
		 * Shows user font & letters choices. Random int used to disperse words on the image. 
		 * J is the initial font size
		 * k is the words on the image
		 * 
		 */

		
		BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_4BYTE_ABGR);
		fontChoices();
		letterChoices();
		Random randomInt = new Random();							
		int j = 100;											

		System.out.println();
		System.out.println("Please enter the name of the word cloud file: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();

		System.out.println();
		System.out.println("How many words do you want to display? (max:100): ");
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();										

		for (int i = 0; i <= k; i++) {
			j = j-(100/k);
			listIndex = list.get(i);
			word = listIndex.getKey();
			String result = word.split("=")[0]; 
			Font font = new Font(fontType, letterType, j);
			Graphics graphics = image.getGraphics();
			graphics.setFont(font);
			graphics.setColor(getColour());
			graphics.drawString(result, randomInt.nextInt(800), randomInt.nextInt(800));
		}
		ImageIO.write(image, "png", new File(name + ".png"));
		image.flush();
		list.clear();
	}

	public static Color getColour() {
		/**
		 * (O)1: Constant time, no loops
		 * calls random colours for the words
		 */
		RandomColour rc = new RandomColour();						
		return rc.getRandomColour();
	}

	public static String fontChoices() throws Exception {
		/**
		 * (O)1: Constant time, no loops. 
		 * Method that calls the options for font choice
		 */
		System.out.println();
		System.out.println("1) Serif");
		System.out.println("2) Sans Serif");
		System.out.println("3) Dialog");
		System.out.println("4) Dialog Input");
		System.out.println("5) Monospaced");
		System.out.println("\nSelect Option [1-5]>");
		System.out.println("Please enter the font type you wish to use: ");

		Scanner s = new Scanner(System.in);
		int menuChoice = Integer.parseInt(s.next());

		switch (menuChoice) {
		case 1:
			fontType = Font.SERIF;
			break;
		case 2:
			fontType = Font.SANS_SERIF;
			break;
		case 3:
			fontType = Font.DIALOG;
			break;
		case 4:
			fontType = Font.DIALOG_INPUT;
			break;
		case 5:
			fontType = Font.MONOSPACED;
			break;
		case 6: {
			System.out.println("Shutting down");
			System.exit(menuChoice);
			;
		}

		default: {
			System.out.println("Invalid input: Please select from option 1-5");
			TimeUnit.SECONDS.sleep(2);
			fontChoices();
		}
		}
		return fontType;
	}

	public static int letterChoices() throws Exception {//(O)1: Constant time, no loops
		/**
		 * (O)1: Constant time, no loops. 
		 * Method that calls the options for letter choice
		 */
		System.out.println();
		System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT);
		System.out.println("1) Plain");
		System.out.println("2) Bold");
		System.out.println("3) Italic");
		System.out.println("4) Roman Baseline");
		System.out.println("5) Centre Baseline");
		System.out.println("\nSelect Option [1-5]>");
		System.out.println("Please enter the font type you wish to use: ");
		System.out.println(ConsoleColours.RESET);
		Scanner s = new Scanner(System.in);
		int menuChoice = s.nextInt();

		switch (menuChoice) {
		case 1:
			letterType = Font.PLAIN;
			break;
		case 2:
			letterType = Font.BOLD;
			break;
		case 3:
			letterType = Font.ITALIC;
			break;
		case 4:
			letterType = Font.ROMAN_BASELINE;
			break;
		case 5:
			letterType = Font.CENTER_BASELINE;
			break;
		case 6: {
			System.out.println("Shutting down");
			System.exit(menuChoice);
			;
		}

		default: {
			System.out.println("Invalid input: Please select from option 1-5");
			TimeUnit.SECONDS.sleep(2);
			fontChoices();
		}
		}
		return letterType;
	}



}