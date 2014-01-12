/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
	
	/* CollectNewsPaperKarel class allows Karel to collect a beeper
	* and return it to her (or his?) starting point in a pre-defined world
	* Pre condition: Karel is in the world CollectNewsPaper facing East
	* Post condition: Karel has one beeper in the Northwest corner of
	* the inner box facing East */
	
	public void run() {
		gettoTarget();
		pickBeeper();
		gettoTarget();
	}
	
	/* gettoTarget makes Karel travel to or from these two points:
	 * A: Northwest corner of inner box
	 * B: One space outside of inner box where beeper is located
	 * Precondition: Karel is facing the point to where travel is desired 
	 * Postcondition: Karel is facing the point of origination
	 */
	
	private void gettoTarget() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		turnAround();
	}
	
	//* Makes Karel turn right
	
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	//* Makes Karel turn around
	
	private void turnAround() {
		turnLeft();
		turnLeft();
	}

}
