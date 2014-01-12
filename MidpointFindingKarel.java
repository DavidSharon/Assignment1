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

	// You fill in this part
	public void run () {
		cleanWorldColor();
		findmidSection();
		faceNorth();
		findmidSection();
		paintCorner(RED);
		cleanWorldYellow();
		findRed();
		paintCorner(null);
	}
	
	private void cleanWorldColor () {
		while (frontIsClear()) {
			cleanAvenueColor();
			move();
		}
		cleanAvenueColor();
	}
	
	private void cleanAvenueColor() {
		turnLeft();
		while (frontIsClear()) {
			paintCorner (null);
			move();
		}
		paintCorner (null);
		turnAround();
		returntoBase();
		turnLeft();
	}
	
	private void cleanWorldYellow() {
		while (frontIsClear()) {
			cleanAvenueYellow();
			move();
		}
		cleanAvenueYellow();
	}
	
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
		turnLeft();
	}
	
	
	/* returntoBase brings MidpointFindingKarel to the first street of the avenue she is located
	 * Precondition: facing south
	 * Postcondition: first street of given avenue facing east
	 */
	
	private void returntoBase() {
		while (frontIsClear()) {
			move();
			}
			turnLeft();
	}
	
	private void findmidSection() {
		paintCorner(YELLOW);
		findWall();
		paintCorner(YELLOW);
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
	
	private void findWall() {
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
	
	private void findclosestYellow() {
		while (cornerColorIs (null)) {
			move();
		}
	}
	
	private void faceNorth () {
		while (notFacingNorth()) {
			turnLeft();
		}
	}
	
	private void findRed() {
		while (cornerColorIs(null)) {
			if (frontIsBlocked()) {
				turnLeft();
			}
			move();
	}
}
