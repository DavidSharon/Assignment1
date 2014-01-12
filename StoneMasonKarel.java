/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	/* StoneMasonKarel creates columns of varying height pending on where
	 * there is a ceiling in the world for that avenue. The columns are four avenues
	 * apart. The world must have exactly 4*n + avenues (e.g., 13, 17, 21 are all allowed).
	 * Beepers may already be present anywhere in the column. StoneMasonKarel will not
	 * add a second beeper for those cases. 
	 * (non-Javadoc)
	 * @see stanford.karel.SuperKarel#run()
	 */
	public void run() {
		while (frontIsClear()) {
			fillColumn();
			returntoBase();
			movebetweenColumns();
		}
	fillColumn();
	returntoBase();
	}
	
	private void fillColumn() {
		turnLeft();
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
				move();
			} else {
				move();
			}
		
		}
		if (noBeepersPresent()) {
			putBeeper (); }
		turnAround();
	}
	
	private void returntoBase() {
		while (frontIsClear()) {
			move();
			}
			turnLeft();
	}
	
	private void movebetweenColumns () {
		move();
		for (int i = 0; i < 3; i++) {
			cleanAvenue();
			move();
		}
	}
	private void cleanAvenue() {
		turnLeft();
		while (frontIsClear()) {
			if (beepersPresent()) {
				pickBeeper();
			}
			move();
		}
		if (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		returntoBase();
		}
}
		
			
	
			
		
		