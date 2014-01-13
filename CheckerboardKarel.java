/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	/* Creates a checkerboard of beepers for any rectangular world without 
	 * beepers already on it
	 * Precondition: first street, first avenue
	 * Postcondition: either first or last street, last avenue
	 */
	
	public void run() {
		faceNorth();
		putBeeper();
		if (frontIsBlocked()) {
			faceEast();
			checkerAvenue();
		}
		while (frontIsClear()) {
			checkerAvenue();
			moveAvenues();
		}
		checkerAvenue();
		faceEast();
	}
	
	/* Fills checkerboard with 
	 * 
	 */
	private void checkerAvenue() {
		while (frontIsClear()) {
			checkerTwoSquares();
		}
	}
	
	private void checkerTwoSquares() {
		if (beepersPresent()) {
			if (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
					putBeeper();
				}
			}
		}else{
			putBeeper();
			if (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
				}
			}
		}
	}
	
	private void moveAvenues(){
			if (facingNorth()) {
				faceEast();
				if (frontIsClear()) {
					if (beepersPresent()) {
						move();
						faceSouth();
						if (frontIsClear()) {
							move();
							putBeeper();
						}
					}else{
						move();
						putBeeper();
						faceSouth();
						}
					}
			}else{
				faceEast();
				if (frontIsClear()) {
					if (beepersPresent()) {
						move();
						faceNorth();
						if (frontIsClear()) {
							move();
							putBeeper();
						}
					}else{
						move();
						faceNorth();
						putBeeper();
					}		
				}
			}
	}
			
	private void faceNorth () {
		while (notFacingNorth()) {
			turnLeft();
		}
	}
	
	/* Orients Karel South
	 * Precondition: none
	 * Postcondition: Karel facing west
	 */
	
	private void faceSouth() {
		while (notFacingSouth()) {
			turnLeft();
		}
	}
	
	/* Orients Karel west
	 * Precondition: none
	 * Postcondition: Karel facing west
	 */
	private void faceWest() {
		while (notFacingWest()) {
			turnLeft();
		}
	}
	
	/* Orients Karel east
	 * Precondition: none
	 * Postcondition: Karel facing east
	 */
	private void faceEast() {
		while (notFacingEast()) {
			turnLeft();
		}
	}
}
