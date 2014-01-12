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
	 * add a second beeper for those cases. For any beepers present on avenues where no column
	 * is suppose to be present, StoneMasonKarel will remove those beepers.
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
	
	/* fillColumn creates a column of beepers the height of the avenue StoneMasonKarel is located
	 *Precondition: at first street of desired avenue facing east
	 *Postcondition: at lowest wall of avenue facing south 
	 */
	
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
	
	/* returntoBase brings StoneMasonKarel to the first street of the avenue she is located
	 * Precondition: facing south
	 * Postcondition: first street of given avenue facing east
	 */
	
	private void returntoBase() {
		while (frontIsClear()) {
			move();
			}
			turnLeft();
	}
	
	/* movebetweenColumns moves StoneMasonKarel from one column to the other which are four avenues apart
	 * and cleans any beepers between those avenues. 
	 * Precondition: at the first street of an avenue with a column of facing east
	 * Postcondition: at the first street of the next avenue which is exactly four avenues from the previous avenue
	 *
	 */
	
	private void movebetweenColumns () {
		move();
		for (int i = 0; i < 3; i++) {
			cleanAvenue();
			move();
		}
	}
	
	/* Removes any beepers from the avenue StoneMasonKarel is located 
	 * Precondition: faces east on first street of avenue
	 * Postcondition: faces east on first street of avenue
	 */
	
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
		
			
	
			
		
		