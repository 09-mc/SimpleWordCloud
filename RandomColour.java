package ie.gmit.dip;

import java.awt.Color;
import java.util.Random;

public final class RandomColour {

	Random rand = new Random();
	
	float r = rand.nextFloat();
	float g = rand.nextFloat();
	float b = rand.nextFloat();
	
	Color randomColour = new Color(r,g,b);

	protected Color getRandomColour() {//(O)1: Constant time, no loops
		/**
		 * (O)1: Constant time, no loops. 
		 * Method getter for random colour
		 */
		return randomColour;
	}

	protected void setRandomColour(Color randomColour) {
		/**
		 * (O)1: Constant time, no loops. 
		 * Method setter for random colour
		 */
		this.randomColour = randomColour;
	}
}

