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

	// You fill in this part
	public void run() {
		while (frontIsClear()) {
			fillColumn();
			returntoBase();
			movebetweenColumns();
		}
	}
	
	private void fillColumn() {
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
		for (int i = 0; i < 4; i++) {
			move();
		}
	}
}
		
			
	
			
		
		