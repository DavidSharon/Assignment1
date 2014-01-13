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
	
	/* Fills avenue with beepers in checkerboard patter
	 * precondition: facing wall farthest from location
	 * postcondition: facing above mentioned wall on cell closest to that wall
	 */
	private void checkerAvenue() {
		while (frontIsClear()) {
			checkerTwoSquares();
		}
	}
	
	/* Fills next two cells with correct checkerboard pattern
	 *  precondition: facing direction of cells to be filled
	 *  post condition: two cells away from starting position, facing same direction
	 */
	
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
	
	/* moves between two avenues and goes to next position where a
	 * beeper is needed according to the checker pattern. Puts a beeper in that location
	 * precondition: facing either north or south in first or last street, respectively, of avenue
	 * postcondition: next avenue to east where beeper should be located. Stands on beeper facing farther wall 
	 */
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

	/* Orients Karel North
	 * Precondition: none
	 * Postcondition: Karel facing north
	 */
	
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
