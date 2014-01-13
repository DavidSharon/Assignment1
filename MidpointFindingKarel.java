/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	/* MidpointFindingKarel helps Karel find the midpoint of a world without 
	 * altering the beepers on the ground already present. It therefore- conciously- does not
	 * leave a beeper on any corner (could easily be added). It does, however
	 * clean any colors left in the world
	 * 
	 * Precondition: start at 1st street, 1st avenue
	 * Postcondition: middle of world, or closest to it if even number of rows and/ or avenues
	 * facing east
	 */
	public void run () {
		cleanWorldColor();
		findmidSection();
		faceNorth();
		findmidSection();
		paintCorner(RED);
		returntoStart();
		cleanWorldYellow();
		returntoStart();
		findRed();
		paintCorner(null);
	}
	
	/* Cleans the world of any colors on map
	 * Precondition: first street, first avenue, facing east
	 * Postcondition: first street, last avenue, facing west
	 */
	
	private void cleanWorldColor () {
		while (frontIsClear()) {
			cleanAvenueColor();
			move();
		}
		cleanAvenueColor();
		turnAround();
	}
	
	/* Cleans avenue of colors
	 * Precondition: first street, facing east
	 * Postcondition: first street, facing east
	 */
	
	private void cleanAvenueColor() {
		turnLeft();
		while (frontIsClear()) {
			paintCorner (null);
			move();
		}
		paintCorner (null);
		turnAround();
		returntoBase();
	}
	
	/* Cleans world of Yellow color only
	 * Precondition: first street, facing east
	 * Postcondition: first street, facing east
	 */
	
	private void cleanWorldYellow() {
		while (frontIsClear()) {
			cleanAvenueYellow();
			move();
		}
		cleanAvenueYellow();
		turnAround();
	}
	
	/* Cleans avenue of Yellow color only
	 * Precondition: first street, facing east
	 * Postcondition: first street, facing east
	 */
	
	private void cleanAvenueYellow() {
		turnLeft();
		while (frontIsClear()) {
			if (cornerColorIs(YELLOW)) {
				paintCorner(null);
			}
			move();
		}
		if (cornerColorIs(YELLOW)) {
			paintCorner(null);
		}
		turnAround();
		returntoBase();
	}
	
	
	/* returntoBase brings Karel to the first street of the avenue she is located
	 * Precondition: facing south
	 * Postcondition: first street of given avenue facing east
	 */
	
	private void returntoBase() {
		while (frontIsClear()) {
			move();
			}
			turnLeft();
	}
	
	/* finds mid point of row or avenue pending on where Karel is facing
	 * To find mid section of street:
	 * 		Precondition: face east on first street, first avenue
	 * 		Postcondition: face north on mid section, with corner painted orange
	 * To find mid section of avenue:
	 * 		Precondition: face north on first street
	 * 		Postcondition: face south on mid section of avenue with corner painted orange
	 */
	
	private void findmidSection() {
		paintCorner(YELLOW);
		findWall();
		paintCorner(YELLOW);
		turnAround();
		while (cornerColorIs(YELLOW)) {
			findclosestYellow();
			turnAround();
			if (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
					if (cornerColorIs(YELLOW)) {
						turnAround();
						move();
						paintCorner(ORANGE);
					}else{
						turnAround();
						move();
						paintCorner(YELLOW);
						turnAround();
				
					}
				}else{
					paintCorner(ORANGE);
				}
			}else{
					paintCorner(ORANGE);
			}
		}
	}
	
	/* moves Karel to opposite wall
	 * precondition: face direction of opposite wall
	 * postcondition: faces direction of wall, at last cell next to wall
	 */
	
	private void findWall() {
		while (frontIsClear()) {
			move();
		}
	}
	
	/* finds closest yellow in direction Karel is oriented
	 * Precondition: faces direction Karel wants to find closest yellow, on yellow corner
	 * Postcondition: on yellow corner, in direction Karel originated or if originated next to wall, painted corner red
	 */
	private void findclosestYellow() {
		if (frontIsClear()) {
			move();
		}else{
			paintCorner(RED);
		}
		while (cornerColorIs (null)) {
			move();
		}
	}
	
	/* finds corner that is colored red
	 * Precondition: first street, first avenue, facing east
	 * Postcondition: on red corner, facing east
	 */
	private void findRed() {
		faceNorth();
		while (cornerColorIs(null)) {
			if (frontIsBlocked()) {
				if (facingSouth()) {
					turnLeft();
					move();
					turnLeft();
				}else{
					if (facingNorth()) {
						turnAround();
					}
				}
			}
			move();
			}
		faceEast();
	}
	
	/* Returns Karel to first street, first avenue
	 * precondition: none
	 * postcondition: first street, first avenue, face east
	 */
	private void returntoStart() {
		faceSouth();
		returntoBase();
		faceWest();
		while (frontIsClear()) {
			move();
		}
		faceEast();
	}
	
	/* Orients Karel North
	 * Precondition: none
	 * Postcondition: Karel facing North
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
